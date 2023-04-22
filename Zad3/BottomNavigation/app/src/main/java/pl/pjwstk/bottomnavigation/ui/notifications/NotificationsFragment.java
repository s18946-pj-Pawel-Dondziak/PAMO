package pl.pjwstk.bottomnavigation.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pl.pjwstk.bottomnavigation.R;
import pl.pjwstk.bottomnavigation.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView TVRecipies;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TVRecipies = root.findViewById(R.id.textViewRecipies);
        TVRecipies.setText(GenerateReipies());
        return root;
    }

    private String GenerateReipies() {
        return
                "Muffinki a la pizza\n" +
                        "Krok 1\n" +
                        "Cukier, sól i drożdże rozpuść w ciepłej wodzie." +
                        "Powstały płyn połącz mąką, jajkiem i majonezem. " +
                        "Dokładnie wyrób ciasto tak, aby było elastyczne i gładkie. " +
                        "Jeśli ciasto będzie zbyt luźne, dodaj więcej mąki i podobnie jeśli będzie zbyt twarde, " +
                        "dodaj odrobinę więcej wody. " +
                        "Ciasto przełóż do miski, przykryj ściereczką i odstaw na około 60 minut w ciepłe miejsce, " +
                        "aby wyrosło.\n\n\n" +
                        "Krok 2\n" +
                        "Kiełbasę pokrój w plasterki – podsmaż ją na patelni tak, aby się wytopiło z niej trochę tłuszczu.\n\n\n" +
                        "Krok 3\n" +
                        "Ciasto delikatnie pomieszaj z serem mozarella, kiełbasą razem z tłuszczem, pokrojonymi oliwkami i ziołami Knorr.\n\n\n" +
                        "Krok 4\n" +
                        "Powstałą w ten sposób mieszankę rozłóż do foremek na muffinki wcześniej wysmarowanych olejem.\n\n\n" +
                        "Krok 5\n" +
                        "Całość wstaw do nagrzanego do 180*C piekarnika na około 20 minut. Podawaj z dipem czosnkowym."
                ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}