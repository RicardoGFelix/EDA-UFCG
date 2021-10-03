import java.util.Scanner;

class CountingSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArray = getArray(scanner);
        int maxValue = scanner.nextInt();
        countingSort(inputArray, maxValue, 0, inputArray.length-1);
    }

    private static void countingSort(int[] array, int maxValue, int leftIndex, int rightIndex) {
        int[] countArray = new int[maxValue+1];

        for (int i = leftIndex; i<=rightIndex; i++) {
            countArray[array[i]]++;
            System.out.println(outputArray(countArray));
        }

        for (int i = 0; i<countArray.length-1; i++) {
            countArray[i+1] += countArray[i];
        }

        System.out.println("Cumulativa do vetor de contagem - " +
                outputArray(countArray));

        int[] result = new int[rightIndex-leftIndex+1];

        for (int i = rightIndex; i>=leftIndex; i--) {
            result[--countArray[array[i]]] = array[i];
        }

        for (int i = leftIndex; i<=rightIndex; i++) {
            array[i] = result[i-leftIndex];
        }

        System.out.println(outputArray(countArray));
        System.out.println(outputArray(result));

    }

    private static int[] getArray(Scanner scanner) {
        String[] array = scanner.nextLine().split(" ");
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Integer.parseInt(array[i]);
        }

        return newArray;
    }

    private static String outputArray(int[] array) {
        String output = "";
        for (int i = 0; i<array.length; i++) {
            if (output.length()==0) {
                output += array[i];
            } else {
                output += " " + array[i];
            }
        }

        return output;
    }

}
