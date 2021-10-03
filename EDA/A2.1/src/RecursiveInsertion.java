import java.util.Arrays;
import java.util.Scanner;

class RecursiveInsertion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = getArray(scanner);
        recursiveInsertionSort(values, 0, values.length-1);
    }

    private static void recursiveInsertionSort(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex<rightIndex) {
            int nextValue = array[leftIndex+1];
            int j = leftIndex;
            while (j>=0 && array[j]>nextValue) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = nextValue;
            System.out.println(Arrays.toString(array));
            recursiveInsertionSort(array, leftIndex+1, rightIndex);
        }
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
