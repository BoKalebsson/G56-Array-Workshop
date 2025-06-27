package se.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NameValidatorTest {

    @Test
    void validName_shouldReturnTrue() {
        // Arrange: Prepare a valid full name string with two words.
        String validName = "Olle Anders";

        // Act: Call isValid with the valid name input.
        boolean actual = NameValidator.isValid(validName);

        // Assert: Check that the result is true.
        assertTrue(actual, "Expected valid name to return true");
    }

    @Test
    void validName_withSwedishCharacters_shouldReturnTrue() {
        // Arrange: Prepare a valid full name containing Swedish letters å, ä, ö.
        String validName = "Åke Öberg";

        // Act: Call isValid with the valid Swedish name.
        boolean actual = NameValidator.isValid(validName);

        // Assert: The validation should accept the name.
        assertTrue(actual, "Expected valid name with å, ä, ö to return true");
    }

    @Test
    void nullName_shouldReturnFalse() {
        // Arrange: Prepare a null input.
        String nullName = null;

        // Act: Call isValid with null input.
        boolean actual = NameValidator.isValid(nullName);

        // Assert: Validation should reject null.
        assertFalse(actual, "Expected null name to return false");
    }

    @Test
    void emptyName_shouldReturnFalse() {
        // Arrange: Prepare an empty string.
        String emptyName = "";

        // Act: Call isValid with empty string.
        boolean actual = NameValidator.isValid(emptyName);

        // Assert: Validation should reject empty string.
        assertFalse(actual, "Expected empty string to return false");
    }

    @Test
    void blankName_shouldReturnFalse() {
        // Arrange: Prepare a blank string containing only spaces.
        String blankName = "    ";

        // Act: Call isValid with blank string.
        boolean actual = NameValidator.isValid(blankName);

        // Assert: Validation should reject blank string.
        assertFalse(actual, "Expected blank string to return false");
    }

    @Test
    void singleWordName_shouldReturnFalse() {
        // Arrange: Prepare a single word name without a space.
        String singleWord = "Olle";

        // Act: Call isValid with single word.
        boolean actual = NameValidator.isValid(singleWord);

        // Assert: Validation should reject single word names.
        assertFalse(actual, "Expected single word name to return false");
    }

    @Test
    void threeWordsName_shouldReturnFalse() {
        // Arrange: Prepare a name with three words.
        String threeWords = "Olle Anders Jonsson";

        // Act: Call isValid with three-word name.
        boolean actual = NameValidator.isValid(threeWords);

        // Assert: Validation should reject names with more than two words.
        assertFalse(actual, "Expected name with three words to return false");
    }

    @Test
    void invalidCharacters_shouldReturnFalse() {
        // Arrange: Prepare a name containing digits.
        String nameWithDigits = "Olle Anders123";

        // Act: Call isValid with name containing digits.
        boolean actual = NameValidator.isValid(nameWithDigits);

        // Assert: Validation should reject names with digits.
        assertFalse(actual, "Expected name with digits to return false");
    }

    @Test
    void invalidCharacters_specialChars_shouldReturnFalse() {
        // Arrange: Prepare a name containing special characters.
        String nameWithSpecialChar = "Olle Anders!";

        // Act: Call isValid with name containing special characters.
        boolean actual = NameValidator.isValid(nameWithSpecialChar);

        // Assert: Validation should reject names with special characters.
        assertFalse(actual, "Expected name with special characters to return false");
    }
}