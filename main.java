// package model;

public class main {
    public static void main(String[] args){
        UserInput user=new UserInput();
        user.collectDetails();
        double calories=CalorieCalculator.calculateTotalCalories(user);
        double totalCalories = CalorieCalculator.calculateTotalCalories(user);
        CalorieCalculator.showCalorieTable(totalCalories);
        System.out.printf("\n%s, your estimated daily calories need is:%f calories. \n ",
                user.name.substring(0, 1).toUpperCase() + user.name.substring(1),
                calories);
    }
}
