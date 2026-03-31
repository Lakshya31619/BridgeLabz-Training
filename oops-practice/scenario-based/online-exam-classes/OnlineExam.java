public class OnlineExam{
    public static void main(String[] args) {
        Students student = new Students(1, "Rahul Gandhi");
        Exam exam = new Exam("Java Test");
        Question q1 = new Question(1, "What is Java?", "Object Oriented Programming Language", 10);
        Question q2 = new Question(2, "Define OOPS", "Object Oriented", 10);
        exam.addQuestion(q1);
        exam.addQuestion(q2);
        try {
            exam.submitAnswer(0, "Nashta");
            exam.submitAnswer(1, "Galti se mistake");
        } catch (ExamTimeExpiredException e) {
            System.out.println("Error: " + e.getMessage());
        }
        EvaluationStrategy strategy = new ObjectiveEvaluation();
        int result = exam.evaluateExam(strategy);
        System.out.println("Student: " + student.getName());
        System.out.println("Total Marks: " + result);
    }
}