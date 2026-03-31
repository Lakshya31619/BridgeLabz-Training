public class Question {
    private int questionId;
    private String questionText;
    private String correctAnswer;
    private int marks;
    public Question(int questionId, String questionText, String correctAnswer, int marks) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public int getMarks() {
        return marks;
    }
    public String getQuestionText() {
        return questionText;
    }
}