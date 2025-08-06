package model;

import java.util.Scanner;

public class UserInput {
    String name, gender, activityLevel;
    int age;
    double weight, height;
    Scanner scanner = new Scanner(System.in);

    public void collectDetails() {
        inputName();
        inputAge();
        inputGender();
        inputWeight();
        inputHeight();
        inputActivityLevel();
    }

    private void inputName() {
        System.out.println("********************** CALORIE CALCULATOR **********************");
        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("YOUR NAME CANNOT BE EMPTY");
            }
        } while (name.trim().isEmpty());
        name = name.toLowerCase();
        System.out.println();
    }

    private void inputAge() {
        boolean valid = false;
        do {
            System.out.print("Enter your age: ");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Enter appropriate age.");
            } else {
                try {
                    age = Integer.parseInt(input);
                    if (age >= 10 && age <= 120) {
                        valid = true;
                    } else {
                        System.out.println("Age must be between 10 and 120.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("INVALID Age, TRY AGAIN!");
                }
            }
        } while (!valid);
        System.out.println();
    }

    private void inputGender() {
        boolean valid = false;
        do {
            System.out.print("Enter gender (male/female): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) {
                System.out.println("Gender cannot be empty!");
            } else if (input.matches("male|female")) {
                gender = input;
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        } while (!valid);
        System.out.println();
    }

    private void inputWeight() {
        boolean valid = false;
        do {
            System.out.print("Enter your weight (e.g. 70kg or 154lbs): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) {
                System.out.println("Weight cannot be empty!");
                continue;
            }
            try {
                if (input.matches("\\d+(\\.\\d+)?(kg|kgs|kilograms)?")) {
                    weight = Double.parseDouble(input.replaceAll("[^\\d.]", ""));
                    valid = true;
                } else if (input.matches("\\d+(\\.\\d+)?(lbs|pounds)")) {
                    double pounds = Double.parseDouble(input.replaceAll("[^\\d.]", ""));
                    weight = pounds * 0.453592;
                    valid = true;
                } else {
                    System.out.println("Invalid format. Example: 70kg or 154lbs");
                }
                if (weight < 30 || weight > 300) {
                    System.out.println("Please enter a realistic weight.");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again!");
            }
        } while (!valid);
        System.out.printf("Stored weight (in kg): %.2f\n", weight);
        System.out.println();
    }

    private void inputHeight() {
        boolean valid = false;
        do {
            System.out.print("Enter your height (e.g. 170cm or 5ft 8in): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.isEmpty()) {
                System.out.println("Height cannot be empty!");
                continue;
            }
            try {
                if (input.matches("\\d+(\\.\\d+)?(cm|centimeters)?")) {
                    height = Double.parseDouble(input.replaceAll("[^\\d.]", ""));
                    valid = true;
                } else if (input.matches("\\d+\\s*ft\\s*\\d+\\s*in")) {
                    String[] parts = input.split("ft|in");
                    int feet = Integer.parseInt(parts[0].trim());
                    int inches = Integer.parseInt(parts[1].trim());
                    height = (feet * 12 + inches) * 2.54;
                    valid = true;
                } else if (input.matches("\\d+'\\d+\"")) {
                    String[] parts = input.split("'|\"");
                    int feet = Integer.parseInt(parts[0].trim());
                    int inches = Integer.parseInt(parts[1].trim());
                    height = (feet * 12 + inches) * 2.54;
                    valid = true;
                } else {
                    System.out.println("Invalid format. Use '170cm' or '5ft 8in' or '5'8\"'");
                }
                if (height < 100 || height > 250) {
                    System.out.println("Please enter a realistic height in cm.");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again!");
            }
        } while (!valid);
        System.out.printf("Stored height (in cm): %.2f\n", height);
        System.out.println();
    }

    private void inputActivityLevel() {
        boolean valid = false;
        do {
            System.out.println("Choose your activity level:");
            System.out.println("1. Sedentary      (little or no exercise)");
            System.out.println("2. Light          (light exercise/sports 1–3 days/week)");
            System.out.println("3. Moderate       (moderate exercise/sports 3–5 days/week)");
            System.out.println("4. Active         (hard exercise/sports 6–7 days a week)");
            System.out.println("5. Very Active    (very hard exercise or a physical job)");
            System.out.print("Enter activity level (name or number): ");

            String level = scanner.nextLine().trim().toLowerCase();

            switch (level) {
                case "1": case "sedentary":
                    activityLevel = "sedentary"; valid = true; break;
                case "2": case "light": case "lightly active":
                    activityLevel = "light"; valid = true; break;
                case "3": case "moderate": case "moderately active":
                    activityLevel = "moderate"; valid = true; break;
                case "4": case "active":
                    activityLevel = "active"; valid = true; break;
                case "5": case "very active":
                    activityLevel = "very active"; valid = true; break;
                default:
                    System.out.println("Invalid input. Please enter a valid number or activity level.");
            }
        } while (!valid);
        System.out.println("Selected activity level: " + activityLevel);
        System.out.println("**************************************************************\n");
    }
}
