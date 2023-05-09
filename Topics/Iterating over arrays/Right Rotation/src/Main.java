import java.util.Scanner;
import java.util.Arrays;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        int[] rotated = new int[arr.length];
        int newIndex;

        for (int i = 0; i < arr.length; i++) {
            newIndex = (i + steps) % arr.length;
            rotated[newIndex] = arr[i];
        }

        System.arraycopy(rotated, 0, arr, 0, arr.length);
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}