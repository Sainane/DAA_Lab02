package ch.heigvd.iict.daa.labo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import ch.heigvd.iict.daa.labo2.fragments.ConfigFragment

class MainActivityFragment2 : AppCompatActivity() {

    private lateinit var fragmentContainerView: FragmentContainerView
    private lateinit var buttonPrevious: Button
    private lateinit var buttonClose: Button
    private lateinit var buttonNext: Button
    private var maxStep = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment2)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, ConfigFragment.newInstance(1))
                .addToBackStack(null)
                .commit()
        }
        fragmentContainerView = findViewById(R.id.fragment_container_view)
        buttonPrevious = findViewById(R.id.button_previous)
        buttonClose = findViewById(R.id.button_close)
        buttonNext = findViewById(R.id.button_next)

        buttonPrevious.setOnClickListener { back() }
        buttonClose.setOnClickListener { finish() }
        buttonNext.setOnClickListener { goToNextStep() }

    }


    private fun back() {
        if(supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        }
        supportFragmentManager.popBackStack()
    }

    private fun goToNextStep() {
        if (supportFragmentManager.backStackEntryCount < maxStep) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container_view,
                ConfigFragment.newInstance(supportFragmentManager.backStackEntryCount + 1)
            )
                .addToBackStack(null)
                .commit()
        }
    }
}