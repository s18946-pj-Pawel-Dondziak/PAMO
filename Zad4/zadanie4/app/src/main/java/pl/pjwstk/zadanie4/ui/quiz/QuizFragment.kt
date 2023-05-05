package pl.pjwstk.zadanie4.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import pl.pjwstk.zadanie4.R
import pl.pjwstk.zadanie4.classes.Question
import pl.pjwstk.zadanie4.classes.Quiz
import java.util.*

class QuizFragment : Fragment() {

    private val mViewModel: QuizViewModel? = null
    private var questionTextView: TextView? = null
    private var optionsRadioGroup: RadioGroup? = null
    private var submitButton: Button? = null
    private var quiz: Quiz? = null

    companion object {
        fun newInstance() = QuizFragment()
    }

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_quiz, container, false)

        questionTextView = root.findViewById(R.id.questionTextView)
        optionsRadioGroup = root.findViewById(R.id.optionsRadioGroup)
        submitButton = root.findViewById(R.id.submitButton)

        quiz = Quiz()

        displayQuestion(root)

        submitButton!!.setOnClickListener(View.OnClickListener {
            val selectedOptionId = optionsRadioGroup!!.getCheckedRadioButtonId()
            if (selectedOptionId != -1) {
                val selectedOptionRadioButton = root.findViewById<RadioButton>(selectedOptionId)
                val selectedOption = optionsRadioGroup!!.indexOfChild(selectedOptionRadioButton) + 1
                quiz!!.answerQuestion(selectedOption)
                if (quiz!!.isQuizFinished()) {
                    // Quiz zakończony, wyświetlenie wyników
                    showQuizResults()
                } else {
                    // Wyświetlenie kolejnego pytania
                    displayQuestion(root)
                }
            }
        })

        return root
    }

    private fun displayQuestion(root: View) {
        val currentQuestion: Question = quiz!!.currentQuestion
        questionTextView!!.setText(currentQuestion.getQuestionText())
        val optionRadioButtons = arrayOfNulls<RadioButton>(4)
        optionRadioButtons[0] = root.findViewById(R.id.option1RadioButton)
        optionRadioButtons[1] = root.findViewById(R.id.option2RadioButton)
        optionRadioButtons[2] = root.findViewById(R.id.option3RadioButton)
        optionRadioButtons[3] = root.findViewById(R.id.option4RadioButton)
        for (i in 0..3) {
            optionRadioButtons[i]!!.text = currentQuestion.getOptions().get(i)
        }
        optionsRadioGroup!!.clearCheck()
    }

    private fun showQuizResults() {
        val correctAnswers = quiz!!.correctAnswers
        val totalQuestions = quiz!!.totalQuestions
        val quizPercentage = quiz!!.quizPercentage
        val results = String.format(
            Locale.getDefault(),
            "Wynik: %d/%d (%.2f%%)",
            correctAnswers,
            totalQuestions,
            quizPercentage
        )
        questionTextView!!.text = results
        optionsRadioGroup!!.visibility = View.GONE
        submitButton!!.isEnabled = false
    }
}