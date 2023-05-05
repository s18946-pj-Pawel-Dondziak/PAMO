package pl.pjwstk.zadanie4.ui.chartBMI

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.pjwstk.zadanie4.R

class ChartBMIFragment : Fragment() {

    companion object {
        fun newInstance() = ChartBMIFragment()
    }

    private lateinit var viewModel: ChartBMIViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart_b_m_i, container, false)
    }

}