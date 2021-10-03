import java.util.Arrays;
import java.util.Scanner;

class HashSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        Set set = new Set(size);

        String[] input;

        do {
            input = scanner.nextLine().split(" ");

            switch (input[0]) {
                case "put":
                    set.put(Integer.parseInt(input[1]));
                    System.out.println(set.toString());
                    break;
                case "remove":
                    set.remove(Integer.parseInt(input[1]));
                    System.out.println(set.toString());
                    break;
                case "contains":
                    System.out.println(set.contains(Integer.parseInt(input[1])));
                    break;
            }
        } while (!(input[0].equalsIgnoreCase("end")));
    }

    static class Set {

        private Integer[] array;
        private int elements;

        public Set(int arrayLength) {
            this.array = new Integer[arrayLength];
            this.elements = 0;
        }

        public int hash(Integer value) {
            return value % array.length;
        }

        public boolean isFull() {
            return this.elements==this.array.length;
        }

        public boolean isEmpty() {
            return this.elements==0;
        }

        public void put(Integer element) {
            if (element!=null && !isFull() && !this.contains(element)) {

                int probe = 0;
                int hash;

                while (probe<this.array.length) {
                    hash = (hash(element)+probe) % array.length;

                    if (this.array[hash]==null) {
                        this.array[hash] = element;
                        this.elements++;
                        break;
                    }

                    probe++;
                }
            }
        }

        public void remove(Integer element) {
            if (element!=null && !this.isEmpty() && this.contains(element)) {

                int probe = 0;
                int hash;

                while (probe<this.array.length) {
                    hash = (hash(element)+probe) % array.length;

                    if (this.array[hash]!=null && this.array[hash]==element) {
                        this.array[hash] = null;
                        this.elements--;
                        break;
                    }

                    probe++;
                }
            }
        }

        public boolean contains(Integer element) {
            boolean result = false;

            if (!this.isEmpty()) {

                for (int i = 0; i< array.length; i++) {
                    if (array[i]==element) {
                        result = true;
                        break;
                    }
                }
            }

            return result;
        }

        public String toString() {
            return Arrays.toString(this.array);
        }
    }
}
