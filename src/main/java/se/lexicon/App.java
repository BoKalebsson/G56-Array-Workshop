package se.lexicon;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("All names:");
                    printNames(NameRepository.findAll());
                    break;

                case "2":
                    System.out.print("Enter a name to search for (exact full name): ");
                    String searchName = scanner.nextLine();
                    String found = NameRepository.find(searchName);
                    System.out.println(found != null ? "Found: " + found : "Not found.");
                    break;

                case "3":
                    System.out.print("Enter a full name to add: ");
                    String nameToAdd = scanner.nextLine();

                    if (!NameValidator.isValid(nameToAdd)) {
                        System.out.println("Invalid input. Name must consist of two words (firstname and lastname), only letters (a–z, å, ä, ö) allowed.");
                    } else {
                        boolean added = NameRepository.add(nameToAdd);
                        System.out.println(added ? "Name added." : "Name already exists.");
                    }
                    break;

                case "4":
                    System.out.print("Enter a firstname to search for it: ");
                    String firstName = scanner.nextLine();
                    printNames(NameRepository.findByFirstName(firstName));
                    break;

                case "5":
                    System.out.print("Enter a lastname to search for it: ");
                    String lastName = scanner.nextLine();
                    printNames(NameRepository.findByLastName(lastName));
                    break;

                case "6":
                    System.out.print("Enter the original name to update: ");
                    String original = scanner.nextLine();

                    System.out.print("Enter the new name: ");
                    String updated = scanner.nextLine();

                    if (!NameValidator.isValid(updated)) {
                        System.out.println("Invalid input. New name must consist of two words (firstname and lastname), only letters (a–z, å, ä, ö) allowed.");
                    } else {
                        boolean updatedResult = NameRepository.update(original, updated);
                        if (updatedResult) {
                            System.out.println("Update successful.");
                        } else if (NameRepository.find(updated) != null) {
                            System.out.println("Update failed. The new name already exists.");
                        } else {
                            System.out.println("Update failed. The original name was not found.");
                        }
                    }
                    break;

                case "7":
                    System.out.print("Enter a name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    boolean removed = NameRepository.remove(nameToRemove);
                    System.out.println(removed ? "Name removed." : "Name not found.");
                    break;

                case "8":
                    System.out.println("Clears all names...");
                    NameRepository.clear();
                    break;

                case "9":
                    System.out.println("Exiting the program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Show all names");
        System.out.println("2. Search for a name (exact)");
        System.out.println("3. Add a new name");
        System.out.println("4. Search for firstname");
        System.out.println("5. Search for lastname");
        System.out.println("6. Update name");
        System.out.println("7. Remove name");
        System.out.println("8. Clear all names");
        System.out.println("9. Exit");
        System.out.print("Choose an alternative: ");
    }

    private static void printNames(String[] names) {
        if (names.length == 0) {
            System.out.println("(No names found.)");
        } else {
            for (String name : names) {
                System.out.println("- " + name);
            }
        }
    }
}