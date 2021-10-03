import java.util.Scanner;

class Duplicados {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        System.out.println(temDuplicacao(input));
    }

    public static String temDuplicacao(String[] seq) {
        String result = "false";

        for (int i = 0; i < seq.length; i++) {
            for (int j = i + 1; j < seq.length; j++) {
                if (Integer.parseInt(seq[i])==Integer.parseInt(seq[j])) {
                    result = "true";
                    break;
                }
            }
        }

        return result;
    }
}