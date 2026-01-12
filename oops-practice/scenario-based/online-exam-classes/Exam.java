public class Exam {
    private String examName;
    private Question[] questions;
    private String[] answers;
    private int questionCount;
    private boolean timeExpired;
    public Exam(String examName) {
        this.examName = examName;
        questions = new Question[5];
        answers = new String[5];
        questionCount = 0;
        timeExpired = false;
    }
    //CRUD
    public void addQuestion(Question question) {
        questions[questionCount++] = question;
    }
    public void submitAnswer(int index, String answer)
            throws ExamTimeExpiredException {
        if (timeExpired) {
            throw new ExamTimeExpiredException("Exam time expired!");
        }
        answers[index] = answer;
    }
    public int evaluateExam(EvaluationStrategy strategy) {
        int total = 0;
        for (int i = 0; i < questionCount; i++) {
            total += strategy.evaluate(questions[i], answers[i]);
        }
        return total;
    }
    public void expireTime() {
        timeExpired = true;
    }
}