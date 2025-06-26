package se.lexicon;


public class App {
    public static void main(String[] args) {

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        // call more methods as needed
    }
}
