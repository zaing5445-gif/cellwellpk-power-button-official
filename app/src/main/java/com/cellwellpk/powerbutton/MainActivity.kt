package com.cellwellpk.powerbutton
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, FloatingPowerService::class.java))
        finish()
    }
}
