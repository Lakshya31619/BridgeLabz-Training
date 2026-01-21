public class HighProteinMeal implements MealPlan {
    @Override
    public String getName() {
        return "High Protein Meal";
    }
    @Override
    public int getCalories() {
        return 800;
    }
}