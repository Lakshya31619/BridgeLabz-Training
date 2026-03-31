public class ExamProctorMain {
    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();
        exam.visitQuestion(1);
        exam.submitAnswer(1, "A");
        exam.visitQuestion(2);
        exam.submitAnswer(2, "C");
        exam.visitQuestion(3);
        exam.submitAnswer(3, "C");
        exam.visitQuestion(4);
        exam.submitAnswer(4, "D");
        System.out.println("\nLast Visited Question: " + exam.getLastVisitedQuestion());
        int score = exam.calculateScore();
        System.out.println("Final Score: " + score);
    }
}