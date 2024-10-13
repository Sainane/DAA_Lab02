package ch.heigvd.iict.daa.labo2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * Contract to pick a name from the InputNameActivity.
 * @author Eva Ray, Massimo Stefani, Rachel Tranchida
 */
class PickNameContract : ActivityResultContract<String, String?>()
    {
        override fun createIntent(context: Context, input: String): Intent {
            return Intent(context, InputNameActivity::class.java).apply {
                putExtra(InputNameActivity.ASK_FOR_USERNAME, input)
            }
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            if (resultCode != Activity.RESULT_OK) {
                return null
            }
            return intent?.getStringExtra(InputNameActivity.ASK_FOR_USERNAME)
        }
    }