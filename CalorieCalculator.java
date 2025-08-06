package model;

public class CalorieCalculator {

    public static double calculateBMR(UserInput user) {
        if (user.gender.equals("male")) {
            return 10 * user.weight + 6.25 * user.height - 5 * user.age + 5;
        } else {
            return 10 * user.weight + 6.25 * user.height - 5 * user.age - 161;
        }
    }

    public static double getActivityMultiplier(String level) {
        return switch (level) {
            case "sedentary" -> 1.20;
            case "light" -> 1.375;
            case "moderate" -> 1.55;
            case "active" -> 1.725;
            case "very active" -> 1.90;
            default -> 1.2;
        };
    }

    public static double calculateTotalCalories(UserInput user) {
        double bmr = calculateBMR(user);
        double multiplier = getActivityMultiplier(user.activityLevel);
        return bmr * multiplier;
    }

    public static void showResultBox(UserInput user, double totalCalories) {
        long roundedCalories = Math.round(totalCalories);

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ Hello %-55s  ║%n", capitalize(user.name));
        System.out.printf("║ Estimated Daily Calories Needed: %d kcal                     ║%n", roundedCalories);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    public static void showZigzagCalorieTable(double totalCalories) {
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     DAILY CALORIE GOALS                       ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.printf ("║ %-35s : %7.0f kcal            ║%n", "Maintain weight", totalCalories);
        System.out.printf ("║ %-35s : %7.0f kcal            ║%n", "Mild weight loss (0.25 kg/week)", totalCalories * 0.91);
        System.out.printf ("║ %-35s : %7.0f kcal            ║%n", "Weight loss (0.5 kg/week)", totalCalories * 0.81);
        System.out.printf ("║ %-35s : %7.0f kcal            ║%n", "Extreme weight loss (1 kg/week)", totalCalories * 0.62);
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }

    public static void showZigzagSchedule(double mildLoss, double loss, double extremeLoss) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                            ZIGZAG CALORIE CYCLING SCHEDULE                           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-10s │ %-25s │ %-20s │ %-20s ║%n", "Day", "Mild weight loss", "Weight loss", "Extreme weight loss");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════╣");

        for (int i = 0; i < days.length; i++) {
            double mild = (i == 0 || i == 6) ? mildLoss + 200 : mildLoss - 200; // higher calories on Sun/Sat
            double normal = (i == 0 || i == 6) ? loss + 200 : loss - 200;
            double extreme = (i == 0 || i == 6) ? extremeLoss + 100 : extremeLoss - 100;

            System.out.printf("║ %-10s │ %-25s │ %-20s │ %-20s ║%n",
                    days[i],
                    String.format("%.0f Calories", mild),
                    String.format("%.0f Calories", normal),
                    String.format("%.0f Calories", extreme));
        }

        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
    }

    private static String capitalize(String name) {
        String[] parts = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }
}
