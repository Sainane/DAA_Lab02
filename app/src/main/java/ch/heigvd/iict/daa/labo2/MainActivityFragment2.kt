package ch.heigvd.iict.daa.labo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import ch.heigvd.iict.daa.labo2.fragments.ConfigFragment

/**
 * It displays instances of ConfigFragment and allows users to navigate between
 * them using "Back", "Next", and "Close" buttons.
 * The activity maintains a back stack to support navigation and handles transitions
 * between different steps (fragments).
 * @author Eva Ray, Massimo Stefani, Rachel Tranchida
 */
class MainActivityFragment2 : AppCompatActivity() {

    private lateinit var fragmentContainerView: FragmentContainerView
    private lateinit var buttonBack: Button
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
        buttonBack = findViewById(R.id.button_previous)
        buttonClose = findViewById(R.id.button_close)
        buttonNext = findViewById(R.id.button_next)

        buttonBack.setOnClickListener { back() }
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