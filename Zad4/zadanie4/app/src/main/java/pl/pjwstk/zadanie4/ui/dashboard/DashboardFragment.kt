package pl.pjwstk.zadanie4.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.pjwstk.zadanie4.R
import pl.pjwstk.zadanie4.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private var ETPersonWeight: EditText? = null
    private var ETPersonHeight: EditText? = null
    private var ETPersonAge: EditText? = null
    private var SAreYouAWoman: Switch? = null
    private var BCalculate: Button? = null
    private var TVBenHarInfo: TextView? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ETPersonWeight = root.findViewById<EditText>(R.id.editTextTextPersonWeight)
        ETPersonHeight = root.findViewById<EditText>(R.id.editTextTextPersonHeight)
        ETPersonAge = root.findViewById<EditText>(R.id.editTextTextPersonAge)
        TVBenHarInfo = root.findViewById<TextView>(R.id.textViewBenHarInfo)
        BCalculate = root.findViewById<Button>(R.id.buttonCalculate)
        SAreYouAWoman = root.findViewById<Switch>(R.id.switchAreYouAWoman)

        BCalculate!!.setOnClickListener(View.OnClickListener { CalculateBenHar() })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun CalculateBenHar() {
        val weight: Float = ETPersonWeight!!.getText().toString().toFloat()
        val height: Float = ETPersonHeight!!.getText().toString().toFloat()
        val age: Float = ETPersonAge!!.getText().toString().toFloat()
        var benHarCal = 0f
        benHarCal = if (SAreYouAWoman!!.isChecked()) {
            (66.473 + 13.7516 * weight + 5.0033 * height - 6.755 * age).toFloat()
        } else {
            (655.0955 + 9.5634 * weight + 1.8496 * height - 4.6756 * age).toFloat()
        }
        TVBenHarInfo!!.setText("Your BenHar is: " + String.format("%.2f", benHarCal))
    }
}