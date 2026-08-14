package com.cellwellpk.powerbutton

import android.content.Context

object BillingHelper {
    // Product ID - 499 Per Reset
    const val PRODUCT_ID = "factory_reset_499_per_reset"
    const val PRICE = "499 PKR"

    fun isResetPaid(context: Context): Boolean {
        val prefs = context.getSharedPreferences("cellwellpk_499", 0)
        return prefs.getBoolean("paid_for_reset", false)
    }

    fun markPaid(context: Context) {
        val prefs = context.getSharedPreferences("cellwellpk_499", 0)
        prefs.edit().putBoolean("paid_for_reset", true).apply()
    }

    fun useOneReset(context: Context) {
        // Reset use hote hi payment khatam - agla reset phir se 499
        val prefs = context.getSharedPreferences("cellwellpk_499", 0)
        prefs.edit().putBoolean("paid_for_reset", false).apply()
    }
}
