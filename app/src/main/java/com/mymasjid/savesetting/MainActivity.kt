package com.mymasjid.savesetting
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val darkModeSwitch: Switch = findViewById(R.id.switch_dark_mode)
        val rootLayout : RelativeLayout = findViewById(R.id.root_layout)

            val sharedPreferences = getSharedPreferences("UserPrefrrance",Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()

            val isDarkModeEnable = sharedPreferences.getBoolean("darkMode",false)
            darkModeSwitch.isChecked = isDarkModeEnable

            if(isDarkModeEnable)
                rootLayout.setBackgroundColor(Color.BLACK)
            else
                rootLayout.setBackgroundColor(Color.WHITE)

        darkModeSwitch.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
           editor.putBoolean("darkMode",isChecked)
            if (isChecked)
                rootLayout.setBackgroundColor(Color.BLACK)
            else
                rootLayout.setBackgroundColor(Color.WHITE)
            editor.apply()
        }
    }
}
