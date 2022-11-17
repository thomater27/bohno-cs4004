import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTimeTest {

    private MeetingTime test;

    @BeforeEach
    void setUp() {
        test = null;
    }

    @ParameterizedTest
    @DisplayName("Ensures getHours returns the hour as int")
    @ValueSource(ints = {0, 1, 2, 6, 9, 12, 18, 24})
    void getHours(int num) {
        test = new MeetingTime(num);
        assertEquals(num, test.getHours());
    }

    @ParameterizedTest
    @DisplayName("Ensures that the constructors throw errors if the hour is out of bounds")
    @ValueSource(ints = {-1, 25, 100, -100, -12})
    void testConstructorsThrowError(int num) {
        assertThrows(IllegalArgumentException.class, () ->
                new MeetingTime(num));
    }

    @ParameterizedTest
    @DisplayName("Tests passing Strings to the constructor")
    @ValueSource(strings = {"0", "1", "12", "24"})
    void testStringConstructor(String str) {
        test = new MeetingTime(str);
        assertEquals(str, Integer.toString(test.getHours()));
    }

    @Test
    @DisplayName("Testing toString")
    void testToString() {
        test = new MeetingTime(0);
        assertEquals("00:00", test.toString());
        test = new MeetingTime(6);
        assertEquals("06:00", test.toString());
        test = new MeetingTime(15);
        assertEquals("15:00", test.toString());
        test = new MeetingTime(24);
        assertEquals("24:00", test.toString());
    }
}