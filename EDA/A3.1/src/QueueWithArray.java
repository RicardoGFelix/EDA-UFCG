import java.util.Scanner;

class QueueWithArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeArray = scanner.nextInt();
        Queue queue = new Queue(sizeArray);

        String[] input;

        do {
            input = scanner.nextLine().split(" ");

            switch (input[0]) {
                case "add":
                    queue.add(input[1]);
                    break;
                case "remove":
                    queue.remove();
                    break;
                case "element":
                    queue.element();
                    break;
                case "print":
                    queue.content();
                    break;
                default:
                    break;
            }
        } while (!(input[0].equalsIgnoreCase("end")));
    }

    static class Queue {

        private String[] array;
        private int tail;

        public Queue(int size) {
            this.array = new String[size];
            this.tail = -1;
        }

        public void add(String value) {
            if (isFull()) {
                System.out.println("full");
            } else {
                this.tail++;
                this.array[tail] = value;
            }
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("empty");
            } else {
                shift();
            }
        }

        public void shift() {
            for (int i = 0; i<this.tail; i++) {
                this.array[i] = this.array[i+1];
            }
            this.tail--;
        }

        public void element() {
            if (isEmpty()) {
                System.out.println("empty");
            } else {
                System.out.println(array[0]);
            }
        }

        public void content() {
            if (isEmpty()) {
                System.out.println("empty");
            } else {
                String content = "";

                for (int i = 0; i<=this.tail; i++) {
                    if (content=="") {
                        content += array[i];
                    } else {
                        content += " " + array[i];
                    }
                }

                System.out.println(content);
            }
        }

        public boolean isFull() {
            boolean result = false;

            if (this.tail==array.length-1) {
                result = true;
            }

            return result;
        }

        public boolean isEmpty() {
            boolean result = false;

            if (this.tail==-1) {
                result = true;
            }

            return result;
        }
    }
}
