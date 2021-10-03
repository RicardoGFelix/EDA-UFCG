import java.util.Scanner;

class NegativeCountingSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArray = getArray(scanner);
        int maxValue = scanner.nextInt();
        int minValue = scanner.nextInt();
        countingSort(inputArray, maxValue, minValue, 0, inputArray.length-1);
    }

    private static void countingSort(int[] array, int maxValue, int minValue, int leftIndex, int rightIndex) {
        int[] countArray = new int[maxValue-minValue+1];

        //frequencia
        for (int i = leftIndex; i<=rightIndex; i++) {
            countArray[array[i]-minValue]++;
            System.out.println(outputArray(countArray));
        }

        //cumulativa
        for (int i = 0; i<countArray.length-1; i++) {
            countArray[i+1] += countArray[i];
        }

        System.out.println("Cumulativa do vetor de contagem - " +
                outputArray(countArray));

        int[] result = new int[rightIndex-leftIndex+1];

        //ordenando e reduzindo a cumulativa
        for (int i = rightIndex; i>=leftIndex; i--) {
            result[--countArray[array[i]-minValue]] = array[i];
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
            if (array.length==1) {
                output = "[" + array[i] + "]";
            } else if (output.length()==0) {
                output += "[" + array[i];
            } else if (i+1== array.length) {
                output += ", " + array[i] + "]";
            } else {
                output += ", " + array[i];
            }
        }

        return output;
    }

}
