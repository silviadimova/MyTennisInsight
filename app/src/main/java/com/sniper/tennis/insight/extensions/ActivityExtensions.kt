package com.sniper.tennis.insight.extensions

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes

fun Activity.showToast(@StringRes messageResource: Int) {
    Toast.makeText(
            this,
            messageResource,
            Toast.LENGTH_LONG
    ).show()
}
