package ch.heigvd.iict.daa.labo2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InputNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("InputNameActivity", "onCreate")
        setContentView(R.layout.activity_input_name)

        val textField = findViewById<EditText>(R.id.edit_text_name)
        val button = findViewById<Button>(R.id.save_button)

        textField.setText(intent.getStringExtra(ASK_FOR_USERNAME))

        button.setOnClickListener {

            val username = textField.text.toString()
            val data = Intent()
            data.putExtra(ASK_FOR_USERNAME, username)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("InputNameActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("InputNameActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("InputNameActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("InputNameActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("InputNameActivity", "onDestroy")
    }

    companion object {
        const val ASK_FOR_USERNAME: String = ""
    }
}