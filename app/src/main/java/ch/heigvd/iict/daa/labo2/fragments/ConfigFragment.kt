package ch.heigvd.iict.daa.labo2.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.iict.daa.labo2.R

/**
 * A fragment that displays a step number.
 * @author Eva Ray, Massimo Stefani, Rachel Tranchida
 */
private const val ARG_STEP = "step"

class ConfigFragment : Fragment() {

    private var step: Int = 1
    companion object {


        fun newInstance(step: Int): ConfigFragment {
            val fragment = ConfigFragment()
            val args = Bundle()
            args.putInt(ARG_STEP, step)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            step = it.getInt(ARG_STEP)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_config, container, false)

        return view}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stepNumber = view.findViewById<TextView>(R.id.step_number)
        stepNumber.text = step.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ARG_STEP", step)
    }

}