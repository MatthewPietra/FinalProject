import org.classes.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testisPostalCodeValid1() {
        String postalCode = "12345";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid2() {
        String postalCode = "H1S 2D1";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid3() {
        String postalCode = "H1S2D1";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid4() {
        String postalCode = "H1A ";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid5() {
        String postalCode = "H1HH11";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid6() {
        String postalCode = "HHH hhh";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid7() {
        String postalCode = "H1H H11";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid("H1H H11");

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid8() {
        String postalCode = null;
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(null);

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testisPostalCodeValid9() {
        String postalCode = "";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid("");

        Assertions.assertEquals(expected, result);
    }
}
