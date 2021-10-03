import java.util.Arrays;
import java.util.Scanner;

class PriorityQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] values = getArray(scanner);
        int indexSeniors = scanner.nextInt();

        priorityQueue(values, indexSeniors);
    }

    private static void priorityQueue(int[] array, int indexSeniors) {

        int index = 0;
        for (int i = indexSeniors; i < array.length; i++) {
            int pivot = array[i];

            for (int j = i; j > index; j--) {
                array[j] = array[j - 1];
            }
            array[index] = pivot;
            index++;

            System.out.println(Arrays.toString(array));
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
