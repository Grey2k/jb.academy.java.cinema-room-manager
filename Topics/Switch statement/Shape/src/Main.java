import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = switch (scanner.nextInt()) {
            case 1 -> "square";
            case 2 -> "circle";
            case 3 -> "triangle";
            case 4 -> "rhombus";
            default -> null;
        };

        if (result != null) {
            System.out.printf("You have chosen a %s%n", result);
        } else {
            System.out.println("There is no such shape!");
        }
    }
}