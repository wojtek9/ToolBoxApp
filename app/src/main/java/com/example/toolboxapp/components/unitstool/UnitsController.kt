package com.example.toolboxapp.components.unitstool

import com.example.toolboxapp.enums.Units

class UnitsController {

    fun calculate(amount: Double, from: String, to: String): Double {
        val conversion = getConversion(from, to)
        val result = amount * conversion
        return result
    }

    private fun getConversion(from: String, to: String): Double {
        var result = -1.0
        when (from) {
            Units.Millimeters.name -> when(to) {
                Units.Millimeters.name -> result = 1.0
                Units.Centimeters.name -> result = 0.1
                Units.Meters.name -> result = 0.001
                Units.Kilometers.name -> result = 0.000001
                Units.Miles.name -> result = 0.0000006213711922
                Units.Yards.name -> result = 0.0010936133
            }
            Units.Centimeters.name -> when (to) {
                Units.Millimeters.name -> result = 10.0
                Units.Centimeters.name -> result = 1.0
                Units.Meters.name -> result = 0.01
                Units.Kilometers.name -> result = 0.00001
                Units.Miles.name -> result = 0.0000062137
                Units.Yards.name -> result = 0.010936133
            }
            Units.Meters.name -> when (to) {
                Units.Millimeters.name -> result = 1000.0
                Units.Centimeters.name -> result = 100.0
                Units.Meters.name -> result = 1.0
                Units.Kilometers.name -> result = 0.001
                Units.Miles.name -> result = 0.0006213712
                Units.Yards.name -> result = 1.0936132983
            }
            Units.Kilometers.name -> when (to) {
                Units.Millimeters.name -> result = 1000000.0
                Units.Centimeters.name -> result = 100000.0
                Units.Meters.name -> result = 1000.0
                Units.Kilometers.name -> result = 1.0
                Units.Miles.name -> result = 0.6213711922
                Units.Yards.name -> result = 1093.6132983
            }
            Units.Miles.name -> when (to) {
                Units.Millimeters.name -> result = 1609344.0
                Units.Centimeters.name -> result = 160934.4
                Units.Meters.name -> result = 1609.344
                Units.Kilometers.name -> result = 1.609344
                Units.Miles.name -> result = 1.0
                Units.Yards.name -> result = 1760.0
            }
            Units.Yards.name -> when (to) {
                Units.Millimeters.name -> result = 914.4
                Units.Centimeters.name -> result = 91.44
                Units.Meters.name -> result = 0.9144
                Units.Kilometers.name -> result = 0.0009144
                Units.Miles.name -> result = 0.0005681818
                Units.Yards.name -> result = 1.0
            }
        }
        return if (result != -1.0) {
            result
        } else {
            throw IllegalArgumentException("Unsupported currency combination: $from to $to")
        }
    }
}