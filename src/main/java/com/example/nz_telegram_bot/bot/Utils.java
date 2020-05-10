package com.example.nz_telegram_bot.bot;

import org.apache.commons.validator.routines.EmailValidator;

public class Utils {
    public static boolean isValidEmailAdDress (String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
