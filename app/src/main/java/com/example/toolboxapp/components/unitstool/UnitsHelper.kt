package com.example.toolboxapp.components.unitstool

import com.example.toolboxapp.enums.Units

class UnitsHelper {

    fun getUnitNames(): List<String> {
        val unitNames = Units.entries.map { it.name }
        return unitNames
    }
}