import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = switch (scanner.nextInt()) {
            case 1 -> "Yes!";
            case 2, 3, 4 -> "No!";
            default -> "Unknown number";
        };

        System.out.println(result);
    }
}