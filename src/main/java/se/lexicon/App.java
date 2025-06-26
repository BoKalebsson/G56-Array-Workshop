package se.lexicon;


public class App {
    public static void main(String[] args) {

        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        NameRepository.clear();
        System.out.println(NameRepository.getSize());
    }
}
