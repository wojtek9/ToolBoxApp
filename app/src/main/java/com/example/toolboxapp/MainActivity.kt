package com.example.toolboxapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button_tool1).setOnClickListener {
            navigateToTool("tool1")
        }
        findViewById<View>(R.id.button_tool2).setOnClickListener {
            navigateToTool("tool2")
        }
        // Repeat for tools 3 to 8
        findViewById<View>(R.id.button_tool8).setOnClickListener {
            navigateToTool("tool8")
        }
    }

    private fun navigateToTool(toolName: String) {
        val intent = Intent(this, ToolActivity::class.java)
        intent.putExtra("TOOL_NAME", toolName)
        startActivity(intent)
    }
}