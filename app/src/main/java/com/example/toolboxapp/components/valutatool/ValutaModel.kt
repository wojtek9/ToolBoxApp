package com.example.toolboxapp.components.valutatool

import android.annotation.SuppressLint
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.toolboxapp.R
import com.example.toolboxapp.enums.Valuta

class ValutaModel(private val activity: AppCompatActivity) {
    val controller = ValutaController()
    val helper = ValutaHelper()

    fun setupUI() {
        setupSpinnerValues()
        setupListeners()
    }

    private fun setupSpinnerValues() {
        val fromSpinner = activity.findViewById<Spinner>(R.id.spinner)
        val toSpinner = activity.findViewById<Spinner>(R.id.spinner2)

        val valutaNames = helper.getValutaNames()
        //val valutaNames = getSpinnerValutas()
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, valutaNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        fromSpinner.adapter = adapter
        toSpinner.adapter = adapter
    }

    private fun getSpinnerValutas(): Array<String> {
        val nameAndSymbol = arrayOf("USD $", "GBP £", "DKK")
        return nameAndSymbol
    }

    @SuppressLint("DefaultLocale")
    private fun setupListeners() {
        val convertBtn = activity.findViewById<Button>(R.id.convert_btn)
        convertBtn.setOnClickListener {
            val valutaText = activity.findViewById<EditText>(R.id.valuta_amount)
            val amount = valutaText.text.toString().toDoubleOrNull() ?: 0.0
            val fromCurrency = activity.findViewById<Spinner>(R.id.spinner).selectedItem.toString()
            val toCurrency = activity.findViewById<Spinner>(R.id.spinner2).selectedItem.toString()
            val result = onConvertBtnClicked(amount, fromCurrency, toCurrency)
            val resultText = activity.findViewById<TextView>(R.id.result_text)
            resultText.text = String.format("%.3f", result) //round to 3 decimals
        }

        val swapBtn = activity.findViewById<ImageButton>(R.id.valuta_swap_btn)
        swapBtn.setOnClickListener {
            val fromSpinner = activity.findViewById<Spinner>(R.id.spinner)
            val toSpinner = activity.findViewById<Spinner>(R.id.spinner2)

            val fromPosition = fromSpinner.selectedItemPosition
            val toPosition = toSpinner.selectedItemPosition

            fromSpinner.setSelection(toPosition)
            toSpinner.setSelection(fromPosition)
        }
    }

    fun onConvertBtnClicked(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val result = controller.calculateConversion(amount, fromCurrency, toCurrency)
        return result
    }
}