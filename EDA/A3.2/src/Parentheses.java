import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Parentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();

        String input = scanner.nextLine();

        System.out.println(checksInput(stack, input));
    }



    public static String checksInput(Stack stack, String input) {
        String result;

        String[] characters = input.split("");

        for(int i = 0; i < characters.length; i++) {
            stack.push(characters[i]);
        }

        if (stack.inputIsValid()) {
            result = "S";
        } else {
            result = "N";
        }

        return result;
    }

    static class Stack {


        private LinkedList list;

        public Stack() {
            this.list = new LinkedList();
        }

        public boolean isEmpty() {
            boolean result = false;

            if (this.list.size() == 0) {
                result = true;
            }

            return result;
        }

        public void push(String value) {
            this.list.insert(value);
        }

        public void pop(){
            if (!this.isEmpty()) {
                this.list.remove();
            }
        }

        public boolean inputIsValid() {
            boolean result = true;
            int cont = 0;

            Object[] array = this.list.toArray();

            for (int i = 0; i < this.list.size(); i++) {

                if (array[i].equals("(")) {
                    cont++;
                } else if (array[i].equals(")")) {
                    cont--;
                }

                if (cont<0) {
                    break;
                }
            }

            if (cont!=0) {
                result = false;
            }

            return result;
        }
    }


    static class LinkedList {

        private String data;
        private LinkedList head;
        private LinkedList next;
        private LinkedList previous;

        public LinkedList() {}

        public LinkedList(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public LinkedList getNext() {
            return next;
        }

        public LinkedList getPrevious() {
            return previous;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setNext(LinkedList next) {
            this.next = next;
        }

        public void setPrevious(LinkedList previous) {
            this.previous = previous;
        }

        public LinkedList getHead() {
            return this.head;
        }

        public void setHead(LinkedList head) {
            this.head = head;
        }

        public boolean isEmpty() {
            boolean result = false;

            if (this.data==null) {
                result = true;
            }

            return result;
        }

        public void insert(String value) {
            if (this.isEmpty()) {

                this.setData(value);
                this.setNext(new LinkedList());
                this.getNext().setPrevious(this);
                this.setHead(this);

            } else {

                this.getNext().insert(value);
            }
        }

        public void remove() {

            if (!this.isEmpty()) {

                if (this.size()==1) {
                    this.head = null;
                } else if (this.getNext().isEmpty()) {
                    this.setData(this.getNext().getData());
                    this.setNext(this.getNext().getNext());
                } else {
                    this.getNext().remove();
                }
            }
        }

        public int size() {
            int result = 0;

            if (!this.isEmpty()) {
                result = 1 + this.getNext().size();
            }

            return result;
        }

        public int search(String value, int index) {
            int result = -1;

            if (value!=null) {

                if (!this.isEmpty()) {

                    if (this.getData().equals(value)) {
                        result = index;
                    } else {
                        result = this.next.search(value, index+1);
                    }
                }
            }

            return result;
        }

        public Object[] toArray() {

            List array = new ArrayList<>();

            recursiveToArray(array);

            return array.toArray();
        }

        private void recursiveToArray(List array){

            if (!this.isEmpty()) {
                array.add(this.getData());
                this.getNext().recursiveToArray(array);
            }
        }
    }
}
