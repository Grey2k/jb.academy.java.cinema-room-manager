import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long first = scanner.nextLong();
        char operation = scanner.next().charAt(0);
        long second = scanner.nextLong();

        try {
            long result = switch (operation) {
                case '+' -> first + second;
                case '-' -> first - second;
                case '/' -> {
                    if (second == 0) {
                        throw new RuntimeException("Division by 0!");
                    }

                    yield first / second;
                }
                case '*' -> first * second;
                default -> throw new RuntimeException("Unknown operator");
            };

            System.out.println(result);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}