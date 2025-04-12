package com.vharya.latihan4

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonOpen = findViewById<Button>(R.id.open_button)
        val buttonSave = findViewById<Button>(R.id.save_button)
        val checkboxAutoSave = findViewById<CheckBox>(R.id.checkbox_auto_save)
        val checkboxStar = findViewById<CheckBox>(R.id.checkbox_star)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val toggleButton = findViewById<ToggleButton>(R.id.toggle)

        buttonOpen.setOnClickListener { displayToast("Open Something...") }
        buttonSave.setOnClickListener { displayToast("Save data!") }

        checkboxAutoSave.setOnClickListener {
            if (checkboxAutoSave.isChecked) displayToast("AutoSave On")
            else displayToast("AutoSave Off")
        }
        checkboxStar.setOnClickListener {
            if (checkboxAutoSave.isChecked) displayToast("Added to Favorites")
            else displayToast("Removed from Favorites")
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radio_button_1) displayToast("Radio 1 Checked!")
            if (checkedId == R.id.radio_button_2) displayToast("Radio 2 Checked!")
        }

        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) displayToast("Toggle on")
            else displayToast("Toggle off")
        }
    }

    private fun displayToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}