import org.junit.jupiter.api.Test;
import org.util.Util;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TitleCaseTest {

    @Test
    public void testToTitleCase1() {
        String input = "hello world";
        String expected = "Hello World";
        String result = Util.toTitleCase(input);
        assertEquals(expected, result );
    }

    @Test
    public void testToTitleCase2() {
        String input = "hello world today";
        String expected = "Hello World";
        String result = Util.toTitleCase(input);
        assertEquals(expected, result );
    }
    @Test
    public void testToTitleCase3() {
        String input = "hello w0rld";
        String expected = "Hello W0rld";
        String result = Util.toTitleCase(input);
        assertEquals(expected, result );
    }


}
