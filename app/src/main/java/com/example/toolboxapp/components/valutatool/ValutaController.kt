package com.example.toolboxapp.components.valutatool

import com.example.toolboxapp.enums.Valuta

class ValutaController {

    fun calculateConversion(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val conversionRate = getCloseToCorrectConversionRate(fromCurrency, toCurrency)
        val result = amount * conversionRate
        return result
    }

    private fun getCloseToCorrectConversionRate(fromCurrency: String, toCurrency: String): Double {
        return when (fromCurrency) {
            Valuta.USD.name -> when (toCurrency) {
                Valuta.USD.name -> 1.0
                Valuta.GBP.name -> 0.78
                Valuta.DKK.name -> 6.87
                Valuta.EUR.name -> 0.92
                else -> throw IllegalArgumentException("Unsupported currency combination: $fromCurrency to $toCurrency")
            }
            Valuta.GBP.name -> when (toCurrency) {
                Valuta.USD.name -> 1.27
                Valuta.GBP.name -> 1.0
                Valuta.DKK.name -> 8.75
                Valuta.EUR.name -> 1.17
                else -> throw IllegalArgumentException("Unsupported currency combination: $fromCurrency to $toCurrency")
            }
            Valuta.DKK.name -> when (toCurrency) {
                Valuta.USD.name -> 0.14
                Valuta.GBP.name -> 0.11
                Valuta.DKK.name -> 1.0
                Valuta.EUR.name -> 0.13
                else -> throw IllegalArgumentException("Unsupported currency combination: $fromCurrency to $toCurrency")
            }
            Valuta.EUR.name -> when (toCurrency) {
                Valuta.USD.name -> 1.08
                Valuta.GBP.name -> 0.85
                Valuta.DKK.name -> 7.45
                Valuta.EUR.name -> 1.0
                else -> throw IllegalArgumentException("Unsupported currency: $fromCurrency")
            }
            else -> throw IllegalArgumentException("Unsupported currency: $fromCurrency")
        }
    }

    fun calculateConversionRate(fromCurrency: String, toCurrency: String): Double {
        // Use API or something to get actual conversion rates
        return 0.0
    }
}