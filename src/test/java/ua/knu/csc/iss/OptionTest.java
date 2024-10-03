package ua.knu.csc.iss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionTest {

    @Test
    void testEquals() {
        Option opt1 = new Option("123", "myOption");
        Option opt2 = new Option("123", "myOption");
        assertEquals(opt1, opt2, "Option objects with same fields compare equal");
        assertFalse(opt1 == opt2, "Different objects have different identity");
    }
}