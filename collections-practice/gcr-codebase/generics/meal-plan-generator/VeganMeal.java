public class VeganMeal implements MealPlan {
    @Override
    public String getName() {
        return "Vegan Meal";
    }
    @Override
    public int getCalories() {
        return 550;
    }
}