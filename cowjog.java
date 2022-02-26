import java.util.*;
import java.io.*;
public class cowjog {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("cowjog.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
        int n = Integer.parseInt(file.readLine());
        int[][] storage = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            storage[i][0] = Integer.parseInt(st1.nextToken());
            storage[i][1] = Integer.parseInt(st1.nextToken());
        }
        for (int i = storage.length-1; i >= 1; i--) {
            if (storage[i][1] < storage[i-1][1]) {
                storage[i-1][0] = -69420; storage[i-1][1] = storage[i][1];
            }
        }
        int totalgroups = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i][0] != -69420) {
                totalgroups++;
            }
        }
        outfile.println(totalgroups);
        file.close();
        outfile.close();
    }
}