import java.util.*;
import java.io.*;
public class diamond {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] storage = new int[n];
        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(file.readLine());
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            int size = 0;
            for (int j = 0; j < n; j++) {
                if (storage[j] >= storage[i] && storage[i]+k >= storage[j]) {
                    size++;
                }
            }
            total = Math.max(total, size);
        }
        outfile.println(total);
        file.close();
        outfile.close();
    }
}