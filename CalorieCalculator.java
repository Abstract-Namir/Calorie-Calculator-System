// package model;
public class CalorieCalculator {
    public static double calculateBMR(UserInput user) {
        if (user.gender.matches("male"))
        { return 10 * user.weight + 6.25 * user.height - 5 * user.age + 5; }
        else
        { return 10 * user.weight + 6.25 * user.height - 5 * user.age - 161; }
    }
    public static double getActivityMultiplier(String level){
        return switch (level){
            case "sedentary" -> 1.2;
            case "light"     -> 1.375;
            case "moderate"  -> 1.55;
            case "active"    -> 1.725;
            case "very active" -> 1.9;
            default->1.2;
        };

        }
    public static double calculateTotalCalories(UserInput user) {
    double bmr=calculateBMR(user);
    double multiplier=getActivityMultiplier(user.activityLevel);
    return bmr*multiplier;
    }
    public static void showCalorieTable(double totalCalories) {
        System.out.println("\n--------- Calorie Goals ---------");
        System.out.printf("Maintain weight       : %.0f Calories/day%n", totalCalories);
        System.out.printf("Mild weight loss (0.25 kg/week) : %.0f Calories/day%n", totalCalories * 0.91);
        System.out.printf("Weight loss (0.5 kg/week)       : %.0f Calories/day%n", totalCalories * 0.81);
        System.out.printf("Extreme weight loss (1 kg/week) : %.0f Calories/day%n", totalCalories * 0.62);
        System.out.println("----------------------------------\n");
    }
}

