package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.postalCode = null;
            {
                this.country = country;
            }
        }
    }

    /**
     * Checks if a postal code follows the Quebec Standard format.
     * @param postalCode the postal code to be checked
     * @return returns if a postal code follows Quebec Standard
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6 && postalCode.length() != 7) {
            return false;
        }
        if (postalCode.length() == 6) {
            return postalCode.matches("[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]");
        } else {
            return postalCode.matches("[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]");
        }
    }
}
