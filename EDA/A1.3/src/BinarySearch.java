import java.lang.reflect.Array;
import java.util.Scanner;

class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] convertedInput = convertsTypeArray(sc);
        int number = sc.nextInt();
        binarySearch(number, convertedInput);
    }

    private static int[] convertsTypeArray(Scanner scanner) {
        String[] a = scanner.nextLine().split(" ");
        int[] newArray = new int[a.length];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Integer.parseInt(a[i]);
        }

        return newArray;
    }

    private static int binarySearch(int n, int[] array) {
        return recursiveBinarySearch(n, array, 0, array.length-1);
    }

    private static int recursiveBinarySearch(int n, int[] a, int start, int end) {
        int result = -1;
        int middle = (start + end) / 2;

        if (start <= end) {

            System.out.println(middle);

            if (n==a[middle]) {
                result = middle;
            } else if (n<a[middle]) {
                result = recursiveBinarySearch(n, a, start, middle-1);
            } else {
                result = recursiveBinarySearch(n, a, middle+1, end);
            }
        } else {
            System.out.println(result);
        }

        return result;
    }
}
