package pl.pjwstk.zadanie4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.pjwstk.zadanie4.R
import pl.pjwstk.zadanie4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var ETPersonWeight: EditText? = null
    private var ETPersonHeight: EditText? = null
    private var BCalculate: Button? = null
    private var BMIInfo: TextView? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ETPersonWeight = root.findViewById<EditText>(R.id.editTextTextPersonWeight)
        ETPersonHeight = root.findViewById<EditText>(R.id.editTextTextPersonHeight)
        BMIInfo = root.findViewById<TextView>(R.id.textViewBMIInfo)
        BCalculate = root.findViewById<Button>(R.id.buttonCalculate)

        BCalculate!!.setOnClickListener(View.OnClickListener { CalCulateBMI() })

        return root
    }

    private fun CalCulateBMI() {
        val weight: Float = ETPersonWeight!!.getText().toString().toFloat()
        val height: Float = ETPersonHeight!!.getText().toString().toFloat()
        val bmi = 100 * 100 * weight / (height * height)
        BMIInfo!!.setText("Your BMI is: " + String.format("%.2f", bmi))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}