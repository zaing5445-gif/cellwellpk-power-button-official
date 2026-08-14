package com.cellwellpk.powerbutton

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class FloatingPowerService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Power Off = FREE
        // Factory Reset check = 499 Per Reset
        return START_STICKY
    }

    fun onFactoryResetClick() {
        if (BillingHelper.isResetPaid(this)) {
            // Paid hai - Reset karne do
            Toast.makeText(this, "Resetting... 1 Reset used", Toast.LENGTH_SHORT).show()
            BillingHelper.useOneReset(this) // 499 khatam, agla reset phir 499
            // Yahan asal reset code ayega
        } else {
            // Paid nahi hai - Paywall kholo
            val i = Intent(this, PaywallActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }
    }
}
