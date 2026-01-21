public class MealPlanGenerator {
    // Generic method with bounded type parameter
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        validateMealPlan(plan);
        return new Meal<>(plan);
    }
    private static <T extends MealPlan> void validateMealPlan(T plan) {
        if (plan.getCalories() <= 0) {
            throw new IllegalArgumentException("Invalid calorie count");
        }
    }
}