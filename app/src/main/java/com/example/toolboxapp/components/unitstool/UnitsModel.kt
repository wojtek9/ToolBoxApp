package com.example.toolboxapp.components.unitstool

import android.annotation.SuppressLint
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.toolboxapp.R

class UnitsModel (private val activity: AppCompatActivity) {
    val controller = UnitsController()
    val helper = UnitsHelper()

    fun setupUI() {
        setupSpinnerValues()
        setupListeners()
    }

    private fun setupSpinnerValues() {
        val fromSpinner = activity.findViewById<Spinner>(R.id.units_spinner)
        val toSpinner = activity.findViewById<Spinner>(R.id.units_spinner2)

        val valutaNames = helper.getUnitNames()
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, valutaNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        fromSpinner.adapter = adapter
        toSpinner.adapter = adapter
    }

    @SuppressLint("DefaultLocale")
    private fun setupListeners() {
        val convertBtn = activity.findViewById<Button>(R.id.units_convert_btn)
        convertBtn.setOnClickListener {
            val unitsText = activity.findViewById<EditText>(R.id.units_amount)
            val amount = unitsText.text.toString().toDoubleOrNull() ?: 0.0
            val from = activity.findViewById<Spinner>(R.id.units_spinner).selectedItem.toString()
            val to = activity.findViewById<Spinner>(R.id.units_spinner2).selectedItem.toString()
            val result = onConvertBtnClicked(amount, from, to)
            val resultText = activity.findViewById<TextView>(R.id.units_result_text)
            resultText.text = String.format("%.6f", result) //round to 6 decimals
        }

        val swapBtn = activity.findViewById<ImageButton>(R.id.units_swap_btn)
        swapBtn.setOnClickListener {
            val fromSpinner = activity.findViewById<Spinner>(R.id.units_spinner)
            val toSpinner = activity.findViewById<Spinner>(R.id.units_spinner2)

            val fromPosition = fromSpinner.selectedItemPosition
            val toPosition = toSpinner.selectedItemPosition

            fromSpinner.setSelection(toPosition)
            toSpinner.setSelection(fromPosition)
        }
    }

    private fun onConvertBtnClicked(amount: Double, from: String, to: String): Double {
        val result = controller.calculate(amount, from, to)
        return result
    }
}