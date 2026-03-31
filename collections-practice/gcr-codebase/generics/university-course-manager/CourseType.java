public abstract class CourseType {
    private final String evaluationMethod;
    protected CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }
    public String getEvaluationMethod() {
        return evaluationMethod;
    }
    public abstract String getCourseType();
}