package com.example.utiltiesclassapp.utils

import java.util.regex.Pattern


val EMAIL_ADDRESS_PATTERN = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
            + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
            + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
)

fun String?.checkIsNullOrEmpty(): Boolean {
    return !this.isNullOrEmpty() && !this.equals("null", ignoreCase = true)
}

fun String.removeFirstLastChar(): String = this.substring(1, this.length.minus(1))

fun String.isValidEmail(): Boolean {
    return EMAIL_ADDRESS_PATTERN.matcher(this).matches()
}

fun String.captalize(value: String): String {
    return value.replaceFirstChar {
        it.uppercase()
    }
}
