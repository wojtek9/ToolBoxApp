package com.example.toolboxapp.components.valutatool

import com.example.toolboxapp.enums.Valuta
import java.util.Currency

class ValutaHelper {

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

    fun getValutaNames(): List<String> {
        val valutaNames = Valuta.entries.map { it.name }
        return valutaNames
    }
}