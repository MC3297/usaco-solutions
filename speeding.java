import java.util.*;
import java.io.*;
public class speeding {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] storage = new int[100];
        int total = 0;
        for (int i = 0; i < n; i++) {
            st1 = new StringTokenizer(file.readLine());
            int miles = Integer.parseInt(st1.nextToken());
            int speed = Integer.parseInt(st1.nextToken());
            for (int j = total; j < total + miles; j++) {
                storage[j] = speed;
            }
            total += miles;
        }
        int[] bstorage = new int[100];
        int btotal = 0;
        for (int i = 0; i < m; i++) {
            st1 = new StringTokenizer(file.readLine());
            int bmiles = Integer.parseInt(st1.nextToken());
            int bspeed = Integer.parseInt(st1.nextToken());
            for (int j = btotal; j < btotal + bmiles; j++) {
                bstorage[j] = bspeed;
            }
            btotal += bmiles;
        }
        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (bstorage[i] > storage[i]) {
                max = Math.max(bstorage[i]-storage[i], max);
            }
        }
        outfile.println(max);
        //outfile.println(Arrays.toString(storage));
        //outfile.println(Arrays.toString(bstorage));
        file.close();
        outfile.close();
    }
}