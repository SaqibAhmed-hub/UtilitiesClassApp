package com.example.utiltiesclassapp.utils

import android.graphics.Color
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import java.io.IOException
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
fun TextInputEditText.markRequiredInRed() {
    hint = buildSpannedString {
        append(hint)
        color(Color.RED) { append(" *") }
    }
}

fun EditText.markRequiredInRed() {
    hint = buildSpannedString {
        append(hint)
        color(Color.RED) { append(" *") }
    }
}

fun MaterialTextView.markRequiredInRed() {
    text = buildSpannedString {
        append(text)
        color(Color.RED) { append(" *") }
    }
}

fun AlertDialog.dimBackground() {
    val lp: WindowManager.LayoutParams = this.window!!.attributes
    lp.dimAmount = 0.7f  // Dim level. 0.0 - no dim, 1.0 - completely opaque
    this.window!!.attributes = lp
}

fun getErrorMessage(e: Exception) =
    if (e is IOException) {
        "IO Exception"
    } else {
        "Something went wrong"
    }
