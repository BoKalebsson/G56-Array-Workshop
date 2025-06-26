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

    // Group: getSize()
    @Test
    void testsGetSize_WithTwoNames() {

        // Arrange: We add two names.
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});

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

    // Group: setNames()
    @Test
    void testSetNames_ReplacesNamesCorrectly() {
        // Arrange: Create a new String[] with new names.
        String[] newNames = {"Greger Ottosson", "Allan Svensson"};

        // Act: Set the String[].
        NameRepository.setNames(newNames);

        // Assert: Get the String[] and check if the old names have been replaced with the new ones.
        assertArrayEquals(newNames, NameRepository.findAll(), "setNames() should replace all the old names with the new ones.");
    }

    @Test
    void testSetNames_WithEmptyArray_ShouldClearList() {
        // Arrange & Act: Create an empty String[].
        NameRepository.setNames(new String[0]);

        // Assert: Check if the size is 0.
        assertEquals(0, NameRepository.getSize(), "setNames() with an empty String[] should return 0.");
    }

    // Group: clear()
    @Test
    void testClear_ShouldEmptyTheList() {
        // Arrange: We start with our @BeforeEach that enters two names.

        // Act: We clear the String[].
        NameRepository.clear();

        // Assert: Size should be 0, and findAll() should return an empty String[].
        assertEquals(0, NameRepository.getSize(), "clear() should clear the String[] and the size should be 0.");
        assertArrayEquals(new String[0], NameRepository.findAll(), "findAll() shall return an empty String[] after clear().");
    }

    // Group: findAll()
    @Test
    void testFindAll_WithTwoNames() {
        // Arrange: We start with our @BeforeEach that enters two names.

        // Act: We fetch all names through the method we want to test.
        String[] actualNames = NameRepository.findAll();

        // Assert: We expect that it is the same names as in the String[].
        assertArrayEquals(
                new String[]{"Erik Svensson", "Mehrdad Javan"},
                actualNames,
                "findAll() should return all names currently stored"
        );
    }

    @Test
    void testFindAll_WhenEmpty() {
        // Arrange: Empty the String[] with clear().
        NameRepository.clear();

        // Act: Get all names from the String[].
        String[] actualNames = NameRepository.findAll();

        // Assert: We expect an empty String[].
        assertArrayEquals(
                new String[0],
                actualNames,
                "findAll() should return an empty array when the list is cleared"
        );
    }

    @Test
    void testFindAll_ReturnsCopy_NotReference() {
        // Arrange: We start with our @BeforeEach that enters two names.

        // Act: Get a copy of String[] names.
        String[] actualNames = NameRepository.findAll();

        // Modify something in the copy.
        actualNames[0] = "Något annat";

        // Get a copy again to verify that the original has not been changed.
        String[] namesAfterChange = NameRepository.findAll();

        // Assert: The original should contain the original value.
        assertEquals("Erik Svensson", namesAfterChange[0], "Changing the returned array should not affect the original data.");
    }


}



