package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        // Finds the length of names.
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param setNames The array of names to set.
     *
     * This method now takes the method string[] with setNames, and assigns them to the class string[] names.
     */
    public static void setNames(String[] setNames) {
        // Assign values to the class String[] names.
        NameRepository.names = setNames;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        // Sets names to a new, empty String[].
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        String[] allNames = new String[names.length];

        // Loops through String[] names, and copy the value to String[] allNames.
        for (int i = 0; i < names.length; i++) {
            allNames[i] = names[i];
        }
        // Return the copied String[].
        return allNames;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {

        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(fullName)) {
                // The name was found.
                return names[i];
            }
        }
        // The name was not found.
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param nameToAdd The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     *
     *
     */
    public static boolean add(String nameToAdd) {

        // Check if the name is valid first of all. Exit if not.
        if (!NameValidator.isValid(nameToAdd)) {
            return false;
        }

        for (int i = 0; i < names.length; i++) {

            // Checks if the nameToAdd is in the String[] names.
            if (names[i].equalsIgnoreCase(nameToAdd)){
                // The name was found, and will not be added.
                return false;
            }
        }
        // Copy the String[] names, expand the index by +1, and add the name at last index, then update.
        String[] addedName = Arrays.copyOf(names, names.length + 1);
        addedName[addedName.length - 1] = nameToAdd;
        names = addedName;
        // The name was added.
        return true;
    }

    /**
     * Find all names that match the given firstName.
     *
     * @param searchedFirstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String searchedFirstName) {

        String[] matchingNames = new String[0];


        for (int i = 0; i < names.length; i++) {
            // Split the string[] at " " and store the two names in a new String[].
            String[] splitName = names[i].split(" ");
            // Assign splitName[0] containing the first name, to the string currentFirstName.
            String currentFirstName = splitName[0];

            if (currentFirstName.equalsIgnoreCase(searchedFirstName)){

                // Copy the matchingNames, into the String[] temp expanded with +1 index.
                String[] temp = Arrays.copyOf(matchingNames, matchingNames.length + 1);
                // Add names[i] to the last index in the String[] temp.
                temp[temp.length - 1] = names[i];
                // Updates the String[] matchingNames.
                matchingNames = temp;
            }

        }
        return matchingNames;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param searchedLastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String searchedLastName) {

        String[] matchingNames = new String[0];


        for (int i = 0; i < names.length; i++) {
            // Split the string[] at " " and store the two names in a new String[].
            String[] splitName = names[i].split(" ");
            // Assign splitName[1] containing the last name, to the string currentLastName.
            String currentLastName = splitName[1];


            if (currentLastName.equalsIgnoreCase(searchedLastName)){

                // Copy the matchingNames, into the String[] temp expanded with +1 index.
                String[] temp = Arrays.copyOf(matchingNames, matchingNames.length + 1);
                // Add names[i] to the last index in the String[] temp.
                temp[temp.length - 1] = names[i];
                // Updates the String[] matchingNames.
                matchingNames = temp;
            }

        }
        return matchingNames;
    }

    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param originalName    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String originalName, String updatedName) {

        if (!NameValidator.isValid(updatedName)) {
            return false;
        }

        for (int i = 0; i < names.length; i++) {

            // Checks if names[i] is equal to the originalName.
            if (names[i].equalsIgnoreCase(originalName)){

                for (int j = 0; j < names.length; j++) {

                    // Checks if names[j] is equal to the updatedName.
                    if (names[j].equalsIgnoreCase(updatedName)) {
                        // We found a duplicate and will not update the list with it.
                        return false;
                    }
                }
                // We have found the original name, and updates it to the updatedName.
                names[i] = updatedName;
                // The update succeeded.
                return true;
            }
        }
        // We never found the originalName in the String[] names.
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {

        int indexToRemove = -1;

        // Find the index we want to remove.
        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(fullName)) {
                indexToRemove = i;
                // We found it, stop looking.
                break;
            }
        }
        // The name was not in the list.
        if (indexToRemove == -1) {
            return false;
        }

        // Create a String[] that is -1 index.
        String[] nameRemoved = new String[names.length -1];
        // Used for keeping track of the position in the new String[].
        int newIndex = 0;

        // Copy all the names, except the one we want to remove.
        for (int i = 0; i < names.length; i++) {

            if (i == indexToRemove) {
                // This is the index we want to remove, skip it.
                continue;
            }

            // Copy the name to the new String[].
            nameRemoved[newIndex] = names[i];
            // Update the index by 1 in the new String[].
            newIndex++;
        }

        // Update the String[] names with the updates from String[] nameRemoved.
        names = nameRemoved;

        // Removal of the name was successful.
        return true;
    }

}