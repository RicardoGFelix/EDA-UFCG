import java.util.ArrayList;
import java.util.Scanner;

class WordCloud {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Hashtable hashtable = new Hashtable(input.length);

        addAllElements(input, hashtable);

        String word = "";

        while (!word.equals("fim")) {
            word = scanner.nextLine();

            if (!word.equals("fim")) {
                System.out.println(hashtable.getWordOccurrences(word));
            }
        }
    }

    private static void addAllElements(String[] input, Hashtable hashtable) {
        for (String word : input) {
            hashtable.put(word);
        }
    }


    static class Hashtable {

        Object[] table;
        int size;

        public Hashtable(int size) {
            this.table = new ArrayList[size];
            this.size = size;
        }

        private int hash(String element) {
            return Math.abs(element.hashCode()) % this.size;
        }

        public void put(String element) {
            if (element!=null) {

                int hash = hash(element);

                ArrayList<String> list = (ArrayList<String>) table[hash];

                if (list==null) {

                    list = new ArrayList<>();
                    list.add(element);
                    table[hash] = list;

                } else {

                    list.add(element);
                }
            }
        }

        public int getWordOccurrences(String element) {
            int result = 0;

            if (element!=null) {

                int hash = hash(element);

                if (this.table[hash]!=null) {

                    ArrayList<String> list = (ArrayList<String>) table[hash];

                    for (String word : list) {

                        if (word.equals(element)) {
                            result++;
                        }
                    }
                }
            }

            return result;
        }
    }
}