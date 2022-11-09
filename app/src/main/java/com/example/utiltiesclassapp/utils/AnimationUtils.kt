package com.example.utiltiesclassapp.utils

import android.view.View


fun View.translateYBy(
    alpha: Float = 1f,
    translateBy: Float = 50f,
    duration: Long = 500L,
    startingDelay: Long = 0
) {
    animate().alpha(alpha).translationYBy(translateBy)
        .setStartDelay(startingDelay)
        .setDuration(duration).start()
}