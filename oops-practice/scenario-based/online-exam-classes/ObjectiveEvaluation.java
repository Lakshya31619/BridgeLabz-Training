public class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(Question question, String answer) {
        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            return question.getMarks();
        }
        return 0;
    }
}