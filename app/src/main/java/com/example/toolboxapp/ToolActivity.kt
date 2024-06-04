package com.example.toolboxapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.toolboxapp.components.unitstool.UnitsModel
import com.example.toolboxapp.components.valutatool.ValutaModel
import com.example.toolboxapp.enums.ToolName

class ToolActivity : AppCompatActivity() {
    private val valutaModel = ValutaModel(this)
    private val unitsModel = UnitsModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolName = intent.getStringExtra("TOOL_NAME") ?: "default"

        when (toolName) {
            ToolName.VALUTA.name -> {
                setContentView(R.layout.valuta_tool_view)
                valutaModel.setupUI()
            }
            ToolName.UNITS.name -> {
                setContentView(R.layout.units_tool_view)
                unitsModel.setupUI()
            }
            //"tool3" -> {setContentView(R.layout.tool3)}
            //"tool4" -> {setContentView(R.layout.tool4)}
            //"tool5" -> {setContentView(R.layout.tool5)}
            //"tool6" -> {setContentView(R.layout.tool6)}
            //"tool7" -> {setContentView(R.layout.tool7)}
            //"tool8" -> {setContentView(R.layout.tool8)}
            else -> {
                // Default or error layout
                setContentView(R.layout.activity_main)
                Toast.makeText(this, "Invalid Tool Name", Toast.LENGTH_SHORT).show()
            }
        }

        Toast.makeText(this, toolName, Toast.LENGTH_SHORT).show()
    }
}