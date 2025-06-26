package se.lexicon;


public class App {
    public static void main(String[] args) {

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println("Number of names in the array: " + NameRepository.getSize());

        System.out.println();

        String[] names = NameRepository.findAll();
        System.out.println("Names in the array: ");
        for (String name : names) {
            System.out.println(name);
        }

        String searchedName = "Erik Svenson";
        String result = NameRepository.find(searchedName);

        System.out.println("Name you searched for: " + searchedName);

        if (result != null) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Result: Was not found");
        }

    }
}
