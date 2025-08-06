package model;

public class main {
    public static void main(String[] args) {
        UserInput user = new UserInput();
        user.collectDetails();

        double totalCalories = CalorieCalculator.calculateTotalCalories(user);

        // Display fancy summary and table
        CalorieCalculator.showResultBox(user, totalCalories);
        CalorieCalculator.showZigzagCalorieTable(totalCalories);
        CalorieCalculator.showZigzagSchedule(totalCalories * 0.91, totalCalories * 0.81, totalCalories * 0.62);
    }
}
