import java.util.*;
import java.io.*;
public class cbarn {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(file.readLine());
        int[] storage = new int[n];
        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(file.readLine());
        }
        int min = (int)1E8;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                total += j*storage[(i+j)%n];
            }
            min = Math.min(min, total);
        }
        outfile.println(min);
        file.close();
        outfile.close();
    }
}