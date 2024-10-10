package ch.heigvd.iict.daa.labo2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var username: String = ""

    private val getName = registerForActivityResult(PickNameContract()) {
        Log.d("MainActivity", "Mon nom est $it")
        if (it != null) {
            username = it
        }
        updateName()
    }

    private fun updateName() {
        val currentName = findViewById<TextView>(R.id.welcome_text)
        if(username.isNotEmpty()) {
            currentName.text = getString(R.string.welcome_with_name, username)
        } else {
            currentName.text = getString(R.string.welcome)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")
        setContentView(R.layout.activity_main)
        updateName()

        val editButton = findViewById<Button>(R.id.edit_button)
        editButton.setOnClickListener {
            getName.launch(null)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }


}