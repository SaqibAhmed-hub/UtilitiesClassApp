package com.example.utiltiesclassapp.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun showKeyboard(activity: Activity) {
    val view = activity.currentFocus
    val methodManager =
        activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    assert(view != null)
    methodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.toastLong(message: String?) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Context.toastShort(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun View.createSnackbar(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG) =
    Snackbar.make(this, resources.getString(messageRes), length)