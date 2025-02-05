import java.io.*;

public class Main {
    public static int gcd(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        int gcdValue = gcd(num1, num2);
        System.out.println(gcdValue);
        System.out.println((long) num1 * num2 / gcdValue);
    }
}