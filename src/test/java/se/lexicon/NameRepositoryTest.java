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
    void testsGetSizeWithTwoNames() {

        // Arrange: We add two names.
        NameRepository.setNames(new String[]{"Erik Svensson", "Merdad Javan"});

        // Act: We get the length.
        int actual = NameRepository.getSize();

        // Assert: We expect the value 2.
        assertEquals(2, actual, "getSize() should return 2 when two names is added.");
    }

    @Test
    void testGetSizeWhenEmpty() {
        // Arrange: We clear the string[].
        NameRepository.clear();

        // Act: We get the length.
        int actual = NameRepository.getSize();

        // Assert: We expect the value 0.
        assertEquals(0, actual, "getSize() should return 0 after clear.");
    }








}
