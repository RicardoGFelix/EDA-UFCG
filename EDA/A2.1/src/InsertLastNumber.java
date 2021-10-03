import java.util.Arrays;
import java.util.Scanner;

class InsertLastNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = getArray(scanner);
        System.out.println(Arrays.toString(insertLastNumberInOrder(values)));
    }

    private static int[] insertLastNumberInOrder(int[] array) {
        for (int i = array.length-1; i>0; i--) {
            if (array[i]<array[i-1]) {
                swap(array, i, i-1);
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    private static int[] getArray(Scanner scanner) {
        String[] array = scanner.nextLine().split(" ");
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Integer.parseInt(array[i]);
        }

        return newArray;
    }
}
