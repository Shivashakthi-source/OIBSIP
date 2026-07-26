import java.util.ArrayList;

public class ExamManager {

    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int[] answers;

    public ExamManager() {
        questions = QuestionBank.getQuestions();
        resetExam();
    }

    // Reset exam
    public void resetExam() {

        currentQuestionIndex = 0;

        answers = new int[questions.size()];

        for (int i = 0; i < answers.length; i++) {
            answers[i] = -1;
        }
    }

    // Get current question
    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    // Total questions
    public int getTotalQuestions() {
        return questions.size();
    }

    // Current question number
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    // Next question
    public void nextQuestion() {

        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
        }

    }

    // Previous question
    public void previousQuestion() {

        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
        }

    }

    // Save answer
    public void saveAnswer(int answer) {
        answers[currentQuestionIndex] = answer;
    }

    // Restore saved answer
    public int getSavedAnswer() {
        return answers[currentQuestionIndex];
    }

    // First question?
    public boolean isFirstQuestion() {
        return currentQuestionIndex == 0;
    }

    // Last question?
    public boolean isLastQuestion() {
        return currentQuestionIndex == questions.size() - 1;
    }

    // Calculate score
    public int calculateScore() {

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {

            if (answers[i] == questions.get(i).getCorrectAnswer()) {
                score++;
            }

        }

        return score;
    }

    // Correct answers
    public int getCorrectAnswers() {
        return calculateScore();
    }

    // Wrong answers
    public int getWrongAnswers() {

        int wrong = 0;

        for (int i = 0; i < questions.size(); i++) {

            if (answers[i] != -1 &&
                answers[i] != questions.get(i).getCorrectAnswer()) {

                wrong++;
            }

        }

        return wrong;
    }

    // Unanswered questions
    public int getUnansweredQuestions() {

        int count = 0;

        for (int answer : answers) {

            if (answer == -1)
                count++;

        }

        return count;
    }

}