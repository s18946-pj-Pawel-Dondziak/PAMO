package pl.pjwstk.zadanie4.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.pjwstk.zadanie4.R
import pl.pjwstk.zadanie4.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private var TVRecipies: TextView? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        TVRecipies = root.findViewById<TextView>(R.id.textViewRecipies)
        TVRecipies!!.setText(GenerateReipies())

        return root
    }

    private fun GenerateReipies(): String? {
        return """
                Muffinki a la pizza
                Krok 1
                Cukier, sól i drożdże rozpuść w ciepłej wodzie.Powstały płyn połącz mąką, jajkiem i majonezem. Dokładnie wyrób ciasto tak, aby było elastyczne i gładkie. Jeśli ciasto będzie zbyt luźne, dodaj więcej mąki i podobnie jeśli będzie zbyt twarde, dodaj odrobinę więcej wody. Ciasto przełóż do miski, przykryj ściereczką i odstaw na około 60 minut w ciepłe miejsce, aby wyrosło.
                
                
                Krok 2
                Kiełbasę pokrój w plasterki – podsmaż ją na patelni tak, aby się wytopiło z niej trochę tłuszczu.
                
                
                Krok 3
                Ciasto delikatnie pomieszaj z serem mozarella, kiełbasą razem z tłuszczem, pokrojonymi oliwkami i ziołami Knorr.
                
                
                Krok 4
                Powstałą w ten sposób mieszankę rozłóż do foremek na muffinki wcześniej wysmarowanych olejem.
                
                
                Krok 5
                Całość wstaw do nagrzanego do 180*C piekarnika na około 20 minut. Podawaj z dipem czosnkowym.
                """.trimIndent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}