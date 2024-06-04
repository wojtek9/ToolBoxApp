package com.example.toolboxapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.toolboxapp.enums.ToolName

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button_tool1).setOnClickListener {
            navigateToTool(ToolName.VALUTA.name)
        }
        findViewById<View>(R.id.button_tool2).setOnClickListener {
            navigateToTool(ToolName.UNITS.name)
        }
        /*
        findViewById<View>(R.id.button_tool3).setOnClickListener {
            navigateToTool("tool3")
        }
        findViewById<View>(R.id.button_tool4).setOnClickListener {
            navigateToTool("tool4")
        }
        findViewById<View>(R.id.button_tool5).setOnClickListener {
            navigateToTool("tool5")
        }
        findViewById<View>(R.id.button_tool6).setOnClickListener {
            navigateToTool("tool6")
        }
        findViewById<View>(R.id.button_tool7).setOnClickListener {
            navigateToTool("tool7")
        }
        findViewById<View>(R.id.button_tool8).setOnClickListener {
            navigateToTool("tool8")
        }
        */
    }

    private fun navigateToTool(toolName: String) {
        val intent = Intent(this, ToolActivity::class.java)
        intent.putExtra("TOOL_NAME", toolName)
        startActivity(intent)
    }
}