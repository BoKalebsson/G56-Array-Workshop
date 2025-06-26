package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {

    @BeforeEach
    void setUp() {
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
    }

    @Test
    void testsGetSize_WithTwoNames() {

        // Arrange: We add two names.
        NameRepository.setNames(new String[]{"Erik Svensson", "Merdad Javan"});

        // Act: We get the length.
        int actual = NameRepository.getSize();

        // Assert: We expect the value 2.
        assertEquals(2, actual, "getSize() should return 2 when two names is added.");
    }

    @Test
    void testGetSize_WhenEmpty() {
        // Arrange: We clear the string[].
        NameRepository.clear();

        // Act: We get the length.
        int actual = NameRepository.getSize();

        // Assert: We expect the value 0.
        assertEquals(0, actual, "getSize() should return 0 after clear.");
    }

    @Test
    void testSetNames_ReplacesNamesCorrectly() {
        // Arrange: Create a new String[] with new names.
        String[] newNames = {"Greger Ottosson", "Allan Svensson"};

        // Act: Set the String[].
        NameRepository.setNames(newNames);

        // Assert: Get the String[] and
        assertArrayEquals(newNames, NameRepository.findAll(), "setNames() should replace all the old names with the new ones.");
    }

    @Test
    void testSetNames_WithEmptyArray_ShouldClearList() {
        // Arrange & Act: Create an empty String[].
        NameRepository.setNames(new String[0]);

        // Assert: Check if the size is 0.
        assertEquals(0, NameRepository.getSize(), "setNames() with an empty String[] should have the length of 0.");
    }


}
