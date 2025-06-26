package se.lexicon;


public class App {
    public static void main(String[] args) {

        System.out.println("----------------------------------");

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Number of names in the array: " + NameRepository.getSize());

        System.out.println("----------------------------------");

        String[] names = NameRepository.findAll();
        System.out.println("Names in the array: ");
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("----------------------------------");

        String searchedName = "Erik Svenson";
        String result = NameRepository.find(searchedName);

        System.out.println("Name you searched for: " + searchedName);

        if (result != null) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Result: Was not found");
        }

        System.out.println("----------------------------------");

        System.out.println(NameRepository.add("Fredrik Andersson") ? "Name was added." : "Name already exist.");

        String[] updatedNames = NameRepository.findAll();

        System.out.println("Names in the array now: ");
        for (String name : updatedNames) {
            System.out.println(name);
        }

        System.out.println("----------------------------------");

        String[] firstNameMatches = NameRepository.findByFirstName("Erik");

        System.out.println("Matching names with firstname of 'Erik':");
        for (String name : firstNameMatches) {
            System.out.println(name);
        }

        System.out.println("----------------------------------");

        String[] lastNameMatches = NameRepository.findByLastName("Javan");

        System.out.println("Matching names with lastname of 'Javan':");
        for (String name : lastNameMatches) {
            System.out.println(name);
        }

        System.out.println("----------------------------------");

        String originalName = "Mehrdad Javan";
        String newName = "Erik Svensson";

        boolean wasUpdated = NameRepository.update(originalName, newName);

        System.out.println("Tried to update: " + originalName + " → " + newName);
        System.out.println(wasUpdated ? "Update successful." : "Update failed.");


        System.out.println("The names in the list now:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }

        System.out.println("----------------------------------");

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Fredrik Andersson"});

        System.out.println("Before removal:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }

        boolean removed = NameRepository.remove("Mehrdad Javan");
        System.out.println("Trying to remove 'Mehrdad Javan': " + (removed ? "Successful." : "Failed."));

        System.out.println("After removal:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }

        System.out.println("----------------------------------");


    }
}
