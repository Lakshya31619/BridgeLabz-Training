public class DescriptiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(Question question, String answer) {
        if (answer.length() >= 5) {
            return question.getMarks() / 2;
        }
        return 0;
    }
}