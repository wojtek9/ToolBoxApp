package com.example.toolboxapp.components.valutatool

import java.util.Currency

class Helper {

    fun getValutaInstance(currency: String): Currency? {
        val inst = Currency.getInstance(currency)
        return inst
    }

    fun getValutaSymbol(currency: String): String? {
        val inst = getValutaInstance(currency)
        if (inst != null) {
            return inst.symbol
        }
        return "err"
    }

    fun getValutaCode(currency: String): String? {
        val inst = getValutaInstance(currency)
        if (inst != null) {
            return inst.currencyCode
        }
        return "err"
    }
}