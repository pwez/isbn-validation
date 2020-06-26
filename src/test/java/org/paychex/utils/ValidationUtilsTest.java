package org.paychex.utils;

import org.junit.Assert;
import org.junit.Test;

public class ValidationUtilsTest {

    @Test
    public void nullIsbn10IsInvalid() {
        Assert.assertFalse(ValidationUtils.isValidISBN10(null));
    }

    @Test
    public void isbn10WithLengthLessThen10Invalid() {
        String isbn = "000000000";
        Assert.assertFalse(ValidationUtils.isValidISBN10(isbn));
    }

    @Test
    public void isbn10WithLengthGreaterThen10Invalid() {
        String isbn = "00000000000";
        Assert.assertFalse(ValidationUtils.isValidISBN10(isbn));
    }

    @Test
    public void validIsbn10() {
        String isbn = "0198526631";
        Assert.assertTrue(ValidationUtils.isValidISBN10(isbn));
    }

    @Test
    public void invalidIsbn10() {
        String isbn = "019852663X";
        Assert.assertFalse(ValidationUtils.isValidISBN10(isbn));
    }

    @Test
    public void nullIsbn13IsInvalid() {
        Assert.assertFalse(ValidationUtils.isValidISBN13(null));
    }

    @Test
    public void isbn13WithLengthLessThen13Invalid() {
        String isbn = "000000000";
        Assert.assertFalse(ValidationUtils.isValidISBN13(isbn));
    }

    @Test
    public void isbn13WithLengthGreaterThen13Invalid() {
        String isbn = "00000000000000";
        Assert.assertFalse(ValidationUtils.isValidISBN13(isbn));
    }

    @Test
    public void validIsbn13() {
        String isbn = "9781402894626";
        Assert.assertTrue(ValidationUtils.isValidISBN13(isbn));
    }

    @Test
    public void invalidIsbn13() {
        String isbn = "5885250576";
        Assert.assertFalse(ValidationUtils.isValidISBN13(isbn));
    }

    @Test
    public void isValidIsbn() {
        String isbn10 = "0198526631";
        Assert.assertTrue(ValidationUtils.isValid(isbn10));

        String isbn13 = "9781402894626";
        Assert.assertTrue(ValidationUtils.isValid(isbn13));
    }

    @Test
    public void isInvalidIsbn() {
        String isbn10 = "019852663X";
        Assert.assertFalse(ValidationUtils.isValid(isbn10));

        String isbn13 = "5885250576628";
        Assert.assertFalse(ValidationUtils.isValid(isbn13));
    }
    
}
