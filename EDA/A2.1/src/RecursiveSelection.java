import java.util.Arrays;
import java.util.Scanner;

class RecursiveSelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = getArray(scanner);
        recursiveSelectionSort(values, 0, values.length-1);
    }

    private static void recursiveSelectionSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex==rightIndex || array.length==0) {
            return;
        }
        int minorIndex = leftIndex;
        for (int i = leftIndex+1; i<=rightIndex; i++) {
            if (array[i]<array[minorIndex]) {
                minorIndex = i;
            }
        }

        swap(array, leftIndex, minorIndex);

        System.out.println(Arrays.toString(array));

        recursiveSelectionSort(array, leftIndex+1, rightIndex);
    }

    private static void swap(int[] array, int index, int minorIndex) {
        int aux = array[index];
        array[index] = array[minorIndex];
        array[minorIndex] = aux;
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
