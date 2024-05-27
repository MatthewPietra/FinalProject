import org.classes.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    public void testUtil1() {
        String postalCode = "12345";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid("12345");

        Assertions.assertEquals(expected, result);
    }
}
