package com.luxoft.ivko.validator.impl;

import com.luxoft.ivko.validator.ClientValidatorService;
import org.junit.Assert;
import org.junit.Test;

public class ClientValidatorServiceImplTest {
    private ClientValidatorService service = new ClientValidatorServiceImpl();

    @Test
    public void validateNameWhenStringIsEmpty() {
        //GIVEN:
        String expectedName = "";
        boolean isValid;

        //WHEN:
        isValid = service.validateName(expectedName);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateNameWhenStringContainsSpacesOnly() {
        //GIVEN:
        String expectedName = "     ";
        boolean isValid;

        //WHEN:
        isValid = service.validateName(expectedName);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateNameWhenStringSoLong() {
        //GIVEN:
        String expectedName = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        boolean isValid;

        //WHEN:
        isValid = service.validateName(expectedName);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateNameWhenNameIsCorrect() {
        //GIVEN:
        String expectedName = "Chris";
        boolean isValid;

        //WHEN:
        isValid = service.validateName(expectedName);

        //THEN:
        Assert.assertTrue(isValid);
    }

    @Test
    public void validateSurnameWhenStringIsEmpty() {
        //GIVEN:
        String expectedSurname = "";
        boolean isValid;

        //WHEN:
        isValid = service.validateSurname(expectedSurname);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateSurnameWhenStringContainsSpacesOnly() {
        //GIVEN:
        String expectedSurname = "    ";
        boolean isValid;

        //WHEN:
        isValid = service.validateSurname(expectedSurname);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateSurnameWhenStringSoLong() {
        //GIVEN:
        String expectedSurname = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        boolean isValid;

        //WHEN:
        isValid = service.validateSurname(expectedSurname);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateSurnameIsCorrect() {
        //GIVEN:
        String expectedSurname = "Smith";
        boolean isValid;

        //WHEN:
        isValid = service.validateSurname(expectedSurname);

        //THEN:
        Assert.assertTrue(isValid);
    }

    @Test
    public void validatePasswordWhenStringIsEmpty() {
        //GIVEN:
        String expectedPassword = "";
        boolean isValid;

        //WHEN:
        isValid = service.validatePassword(expectedPassword);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordWhenStringContainsSpacesOnly() {
        //GIVEN:
        String expectedPassword = "    ";
        boolean isValid;

        //WHEN:
        isValid = service.validatePassword(expectedPassword);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordSoShort() {
        //GIVEN:
        String expectedPassword = "33";
        boolean isValid;

        //WHEN:
        isValid = service.validatePassword(expectedPassword);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordSoLong() {
        //GIVEN:
        String expectedPassword = "a9bcd1efghijklmnopq22tuvwxyz4abcdefghi5jklmnop777qrstuvwxyz";
        boolean isValid;

        //WHEN:
        isValid = service.validatePassword(expectedPassword);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePasswordIsCorrect() {
        //GIVEN:
        String expectedPassword = "fer34tyuP";
        boolean isValid;

        //WHEN:
        isValid = service.validateSurname(expectedPassword);

        //THEN:
        Assert.assertTrue(isValid);
    }

    @Test
    public void validateEmailWhenStringIsEmpty() {
        //GIVEN:
        String expectedEmail = "";
        boolean isValid;

        //WHEN:
        isValid = service.validateEmail(expectedEmail);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateEmailWhenStringContainsSpacesOnly() {
        //GIVEN:
        String expectedEmail = "   ";
        boolean isValid;

        //WHEN:
        isValid = service.validateEmail(expectedEmail);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateEmailSoLong() {
        //GIVEN:
        String expectedEmail = "fer34tyuPfer@34tyuPfer34tyuPfer34tyuP.com";
        boolean isValid;

        //WHEN:
        isValid = service.validateEmail(expectedEmail);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateEmailIsJustIncorrect() {
        //GIVEN:
        String expectedEmail = "fer3@4tyuP";
        boolean isValid;

        //WHEN:
        isValid = service.validateEmail(expectedEmail);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateEmailIsCorrect() {
        //GIVEN:
        String expectedEmail = "fer3@gmail.com";
        boolean isValid;

        //WHEN:
        isValid = service.validateEmail(expectedEmail);

        //THEN:
        Assert.assertTrue(isValid);
    }

    @Test
    public void validatePhoneWhenStringIsEmpty() {
        //GIVEN:
        String expectedPhone = "";
        boolean isValid;

        //WHEN:
        isValid = service.validatePhone(expectedPhone);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePhoneWhenStringContainsSpacesOnly() {
        //GIVEN:
        String expectedPhone = "   ";
        boolean isValid;

        //WHEN:
        isValid = service.validatePhone(expectedPhone);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validatePhoneWhenPhoneIncorrectLength() {
        //GIVEN:
        String expectedPhone1 = "+5666666666666666666666666666";
        String expectedPhone2 = "+5556666";
        boolean isValid1;
        boolean isValid2;

        //WHEN:
        isValid1 = service.validatePhone(expectedPhone1);
        isValid2 = service.validatePhone(expectedPhone2);

        //THEN:
        Assert.assertFalse(isValid1);
        Assert.assertFalse(isValid2);
    }

    @Test
    public void validatePhoneWhenPhoneCorrect() {
        //GIVEN:
        String expectedPhone1 = "+380665058899";
        boolean isValid;

        //WHEN:
        isValid = service.validatePhone(expectedPhone1);

        //THEN:
        Assert.assertTrue(isValid);
    }

    @Test
    public void validateAgeIfStringIsEmpty() {
        //GIVEN:
        String expectedAge = "";
        boolean isValid;

        //WHEN:
        isValid = service.validateAge(expectedAge);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateAgeIfStringContainOnlySpaces() {
        //GIVEN:
        String expectedAge = "     ";
        boolean isValid;

        //WHEN:
        isValid = service.validateAge(expectedAge);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateAgeIfStringHasNoDigits() {
        //GIVEN:
        String expectedAge = "sss";
        boolean isValid;

        //WHEN:
        isValid = service.validateAge(expectedAge);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateAgeIfSoFewSymbols() {
        //GIVEN:
        String expectedAge = "5";
        boolean isValid;

        //WHEN:
        isValid = service.validateAge(expectedAge);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateAgeIfSoMuchSymbols() {
        //GIVEN:
        String expectedAge = "345";
        boolean isValid;

        //WHEN:
        isValid = service.validateAge(expectedAge);

        //THEN:
        Assert.assertFalse(isValid);
    }

    @Test
    public void validateAgeIfCorrectValue() {
        //GIVEN:
        String expectedAge = "34.5";
        boolean isValid;

        //WHEN:
        isValid = service.validateAge(expectedAge);

        //THEN:
        Assert.assertTrue(isValid);
    }
}
