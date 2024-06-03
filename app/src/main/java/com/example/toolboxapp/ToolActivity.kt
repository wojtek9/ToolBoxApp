package com.example.toolboxapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.toolboxapp.components.valutatool.ValutaModel

class ToolActivity : AppCompatActivity() {
    private val valutaModel = ValutaModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolName = intent.getStringExtra("TOOL_NAME") ?: "default"

        when (toolName) {
            "tool1" -> {
                setContentView(R.layout.valuta_tool_view)
                valutaModel.setupUI()
            }
            //"tool2" -> {setContentView(R.layout.tool2)}
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