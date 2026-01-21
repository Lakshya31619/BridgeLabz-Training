public class MealPlanMain {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal =  MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
        displayMeal(vegMeal);
        displayMeal(veganMeal);
        displayMeal(ketoMeal);
        displayMeal(proteinMeal);
    }
    private static void displayMeal(Meal<? extends MealPlan> meal) {
        System.out.println(meal.getMealPlan().getName() + " | Calories: " + meal.getMealPlan().getCalories());
    }
}