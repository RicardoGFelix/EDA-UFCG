import java.util.Scanner;

class MasterTheorem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ord = sc.nextInt();
        System.out.println(masterTheorem(a, b, ord));
    }

    private static String masterTheorem(int a, int b, int ord) {
        String result = "T(n) = theta()";
        double log = Math.log(a)/Math.log(b);

        if (log<ord) {
            result = "T(n) = theta(n**" + ord + ")";
        } else if (log==ord) {
            result = "T(n) = theta(n**" + ord + " * log n)";
        }

        return result;
    }
}
