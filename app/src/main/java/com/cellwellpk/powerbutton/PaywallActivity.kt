package com.cellwellpk.powerbutton

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaywallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            setPadding(50, 100, 50, 50)
        }
        val title = TextView(this).apply {
            text = "⚠️ Factory Reset - 499 PKR Per Reset\n\nSara Data Delete Hoga\n1 Reset = 499 Rs (Monthly Nahi)"
            textSize = 18f
        }
        val payBtn = Button(this).apply { text = "Pay 499 Rs - 1 Reset" }
        payBtn.setOnClickListener {
            BillingHelper.markPaid(this)
            Toast.makeText(this, "499 Paid! Ab Reset Kar Sakte Ho", Toast.LENGTH_LONG).show()
            finish()
        }
        layout.addView(title)
        layout.addView(payBtn)
        setContentView(layout)
    }
}
