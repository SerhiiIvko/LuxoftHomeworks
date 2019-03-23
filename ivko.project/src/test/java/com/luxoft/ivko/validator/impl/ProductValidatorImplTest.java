//package com.luxoft.com.luxoft.ivko.validator.impl;
//
//import com.luxoft.com.luxoft.ivko.validator.ProductValidatorService;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ProductValidatorImplTest {
//    private ProductValidatorService service = new ProductValidatorImpl();
//
//    @Test
//    public void validateNameWhenStringIsEmpty() {
//        //GIVEN:
//        String expectedName = "";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateName(expectedName);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validateNameWhenStringContainsSpacesOnly() {
//        //GIVEN:
//        String expectedName = "     ";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateName(expectedName);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validateNameWhenStringSoLong() {
//        //GIVEN:
//        String expectedName = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateName(expectedName);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validateNameWhenNameIsCorrect() {
//        //GIVEN:
//        String expectedName = "Carrot";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateName(expectedName);
//
//        //THEN:
//        Assert.assertTrue(isValid);
//    }
//
//    @Test
//    public void validateTypeWhenStringIsEmpty() {
//        //GIVEN:
//        String expectedType = "";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateType(expectedType);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validateTypeWhenStringContainsSpacesOnly() {
//        //GIVEN:
//        String expectedType = "         ";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateType(expectedType);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validateTypeWhenStringSoLong() {
//        //GIVEN:
//        String expectedType = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateType(expectedType);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validateTypeWhenIsCorrect() {
//        //GIVEN:
//        String expectedName = "vegetable";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validateType(expectedName);
//
//        //THEN:
//        Assert.assertTrue(isValid);
//    }
//
//    @Test
//    public void validatePriceWhenStringIsEmpty() {
//        //GIVEN:
//        String expectedPrice = "";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validatePrice(expectedPrice);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validatePriceIfStringContainOnlySpaces() {
//        //GIVEN:
//        String expectedPrice = "     ";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validatePrice(expectedPrice);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validatePriceIfStringHasNoDigits() {
//        //GIVEN:
//        String expectedPrice = "sss";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validatePrice(expectedPrice);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validatePriceIfIncorrectValue() {
//        //GIVEN:
//        String expectedPrice = "-50";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validatePrice(expectedPrice);
//
//        //THEN:
//        Assert.assertFalse(isValid);
//    }
//
//    @Test
//    public void validatePriceIfCorrectValue() {
//        //GIVEN:
//        String expectedPrice = "53.4";
//        boolean isValid;
//
//        //WHEN:
//        isValid = service.validatePrice(expectedPrice);
//
//        //THEN:
//        Assert.assertTrue(isValid);
//    }
//}
