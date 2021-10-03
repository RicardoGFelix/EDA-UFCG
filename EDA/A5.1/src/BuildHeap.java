import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] convertedInput = convertsTypeArray(scanner);

        Heap heap = new Heap(convertedInput.length);

        heap.buildHeap(convertedInput);
        System.out.println(heap.toString());
    }

    private static int[] convertsTypeArray(Scanner scanner) {
        String[] a = scanner.nextLine().split(" ");
        int[] newArray = new int[a.length];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Integer.parseInt(a[i]);
        }

        return newArray;
    }

    static class Heap {

        private int[] heap;
        private int tail;

        public Heap(int capacity) {
            this.heap = new int[capacity];
            this.tail = -1;
        }

        private int left(int index) {
            return 2*index+1;
        }

        private int right(int index) {
            return 2*index+2;
        }

        private int parent(int index) {
            return (index-1)/2;
        }

        private void swap(int position, int largest) {
            int aux = this.heap[position];
            this.heap[position] = this.heap[largest];
            this.heap[largest] = aux;
        }

        private void heapify(int position) {
            int left = left(position);
            int right = right(position);
            int largest;

            if (left<this.tail+1 && this.heap[left]>this.heap[position]) {
                largest = left;
            } else {
                largest = position;
            }

            if (right<this.tail+1 && this.heap[right]>this.heap[largest]) {
                largest = right;
            }

            if (largest!=position) {
                swap(position, largest);
                this.heapify(largest);
            }
        }

        public void buildHeap(int[] heap) {
            this.heap =heap;
            this.tail = heap.length-1;

            for (int i = parent(this.tail); i>=0; i--) {
                this.heapify(i);
            }
        }

        public String toString() {
            return Arrays.toString(this.heap);
        }
    }
}