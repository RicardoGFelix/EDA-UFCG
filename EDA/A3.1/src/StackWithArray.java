import java.util.Scanner;

class StackWithArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeArray = scanner.nextInt();
        Stack stack = new Stack(sizeArray);

        String[] input;

        do {
            input = scanner.nextLine().split(" ");

            switch (input[0]) {
                case "push":
                    stack.push(input[1]);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "peek":
                    stack.peek();
                    break;
                case "print":
                    stack.content();
                    break;
                default:
                    break;
            }
        } while (!(input[0].equalsIgnoreCase("end")));
    }

    static class Stack {

        private String[] array;
        private int top;

        public Stack(int size) {
            this.array = new String[size];
            this.top = -1;
        }

        public void push(String value) {
            if (isFull()) {
                System.out.println("full");
            } else {
                this.top++;
                this.array[top] = value;
            }
        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("empty");
            } else {
                this.top--;
            }
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("empty");
            } else {
                System.out.println(array[top]);
            }
        }

        public void content() {
            if (isEmpty()) {
                System.out.println("empty");
            } else {
                String content = "";

                for (int i = 0; i<=this.top; i++) {
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

            if (this.top ==array.length-1) {
                result = true;
            }

            return result;
        }

        public boolean isEmpty() {
            boolean result = false;

            if (this.top==-1) {
                result = true;
            }

            return result;
        }
    }
}
