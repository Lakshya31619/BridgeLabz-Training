import java.util.*;
class ExamProctor {
    private Stack<Integer> questionStack = new Stack<>();
    private HashMap<Integer, String> answers = new HashMap<>();
    private HashMap<Integer, String> correctAnswers = new HashMap<>();
    public ExamProctor() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
    }
    // Visit a question
    public void visitQuestion(int questionId) {
        questionStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }
    // Answer a question
    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answer saved for Q" + questionId);
    }
    // View last visited question
    public int getLastVisitedQuestion() {
        if (!questionStack.isEmpty()) {
            return questionStack.peek();
        }
        return -1;
    }
    // Auto-evaluate score
    public int calculateScore() {
        int score = 0;
        for (Map.Entry<Integer, String> entry : answers.entrySet()) {
            int qId = entry.getKey();
            String studentAnswer = entry.getValue();
            if (correctAnswers.containsKey(qId) &&
                correctAnswers.get(qId).equalsIgnoreCase(studentAnswer)) {
                score++;
            }
        }
        return score;
    }
}