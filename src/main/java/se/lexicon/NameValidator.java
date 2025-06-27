package se.lexicon;

public class NameValidator {

    public static boolean isValid(String name) {
        if (name == null) return false;

        name = name.trim();
        if (name.isEmpty()) return false;

        String[] parts = name.split(" ");
        if (parts.length != 2) return false;

        String nameRegex = "^[a-zA-ZåäöÅÄÖ]+$";
        return parts[0].matches(nameRegex) && parts[1].matches(nameRegex);
    }
}