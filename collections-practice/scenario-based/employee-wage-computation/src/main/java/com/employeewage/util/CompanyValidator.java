package com.employeewage.util;
import java.util.regex.Pattern;
// Regex Implementation (Extra Requirement)
public class CompanyValidator {
    private static final String COMPANY_REGEX = "^[A-Z][a-zA-Z]{2,}$";
    public static boolean isValidCompanyName(String name) {
        return Pattern.matches(COMPANY_REGEX, name);
    }
}