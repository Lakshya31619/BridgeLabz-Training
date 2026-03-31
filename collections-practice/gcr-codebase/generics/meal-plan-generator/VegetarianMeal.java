public class VegetarianMeal implements MealPlan {
    @Override
    public String getName() {
        return "Vegetarian Meal";
    }
    @Override
    public int getCalories() {
        return 600;
    }
}