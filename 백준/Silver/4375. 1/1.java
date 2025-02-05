import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input;
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            int modulus = 1;
            int count = 1;
            
            while (modulus % num != 0) {
                modulus = (modulus * 10 + 1) % num;
                count++;
            }
            System.out.println(count);
        }
    }
}
