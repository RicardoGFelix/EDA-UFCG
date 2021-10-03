import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MaxBST {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] convertedInput = convertsTypeArray(scanner);
        BST bst = new BST();

        insertElements(convertedInput, bst);
        maxBST(convertedInput, bst);
    }

    private static void insertElements(int[] array, BST bst) {
        for (int value : array) {
            bst.insert(value);
        }
    }

    private static void maxBST(int[] array, BST bst) {
        String result = "";

        List maxValues = bst.maxValues();

        for (int i = 0; i<maxValues.size(); i++) {
            if (result=="") {
                result += maxValues.get(i);
            } else {
                result += " " + maxValues.get(i);
            }
        }

        System.out.println(result);
    }

    private static int[] convertsTypeArray(Scanner scanner) {
        String[] a = scanner.nextLine().split(" ");
        int[] newArray = new int[a.length];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Integer.parseInt(a[i]);
        }

        return newArray;
    }

    static class BST {

        private Node root;

        public BST() {
            this.root = null;
        }

        public boolean isEmpty() {
            return this.root==null;
        }

        public void insert(int data) {
            if (this.isEmpty()) {
                this.root = new Node(data);
            } else {
                insert(this.root, data);
            }
        }

        private void insert(Node node, int data) {
            if (data<node.getData()) {

                if (node.getLeft()==null) {
                    Node newNode = new Node(data);
                    node.setLeft(newNode);
                    newNode.setParent(node);
                } else {
                    insert(node.getLeft(), data);
                }

            } else {

                if (node.getRight()==null) {
                    Node newNode = new Node(data);
                    node.setRight(newNode);
                    newNode.setParent(node);
                } else {
                    insert(node.getRight(), data);
                }
            }
        }

        public List maxValues() {
            List list = new ArrayList();
            int max = this.root.getData();

            list.add(max);

            Node node = this.root;

            while(node.right != null) {
                node = node.right;
                list.add(node.getData());

            }

            return list;
        }

    }

    static class Node {

        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getParent() {
            return parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}
