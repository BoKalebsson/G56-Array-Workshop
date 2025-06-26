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



    }
}
