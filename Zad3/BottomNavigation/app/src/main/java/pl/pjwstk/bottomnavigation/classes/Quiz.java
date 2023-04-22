package pl.pjwstk.bottomnavigation.classes;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswers;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        correctAnswers = 0;
        addQuestions();
    }

    private void addQuestions() {
        questions.add(new Question("Ile wynosi prawidłowy poziom cholesterolu?", "Do 500 mg/dl.", "Do 100 mg/dl.", "Do 200 mg/dl.", "Do 300 mg/dl.", 3));
        questions.add(new Question("Jakie powinno być tętno?", "80 - 100 uderzeń na minutę", "60 - 80 uderzeń na minutę", "40 - 60 uderzeń na minutę", "100 - 120 uderzeń na minutę", 2));
        questions.add(new Question("Ile wody powinno się pić dziennie?", "1 litr", "2 litry", "3 litry", "4 litry", 2));
        questions.add(new Question("Ile powinien wynosić poziom cókru we krwi?", "120 -140 mg/dl", "0 -50 mg/dl", "100 -120 mg/dl", "60 -100 mg/dl", 4));
        questions.add(new Question("Które z poniższych jest najbogatszym źródłem witaminy C?", "Marchewka", "Pomarańcza", "Banany", "Gruszka", 2));
        questions.add(new Question("Wątrobie najbardziej szkodzi?", "Kwaśne jedzienie", "Tłuste jedzenie", "Jedzenie białka zwierzęcego", "Słodkie jedzienie", 2));
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void answerQuestion(int selectedOption) {
        if (selectedOption == getCurrentQuestion().getCorrectOption()) {
            correctAnswers++;
        }
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex == questions.size();
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public double getQuizPercentage() {
        return (double) correctAnswers / questions.size() * 100;
    }
}
