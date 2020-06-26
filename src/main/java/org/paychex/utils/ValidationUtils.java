package org.paychex.utils;

public class ValidationUtils {

    public static boolean isValid(String isbn) {
        if (isbn == null) return false;
        isbn = isbn.replaceAll("-","");
        return isbn.length() == 10 && isValidISBN10(isbn) || isbn.length() == 13 && isValidISBN13(isbn);
    }

    public static boolean isValidISBN10(String isbn) {
        if (isbn == null || isbn.length() != 10) return false;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (digit < 0 || digit > 9) return false;
            sum += digit * (10 - i);
        }
        char lastDigit = isbn.charAt(9);
        int checkDigit = 11 - (sum % 11);
        if (lastDigit != 'X' && (lastDigit < '0' || lastDigit > '9')) return false;
        sum += lastDigit == 'X' ? 10 : checkDigit;
        return sum % 11 == 0;
    }

    public static boolean isValidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) return false;
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = isbn.charAt(i) - '0';
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        sum = 10 - (sum % 10);
        if (sum == 10) sum = 0;
        return sum == isbn.charAt(12) - '0';
    }
}
