import java.util.*;
import java.io.*;
public class marathon {
    public static int distance(int[] a, int[] b) {
        int total = 0;
        total += Math.abs(a[0] - b[0]);
        total += Math.abs(a[1] - b[1]);
        return total;
    }
    public static int difference(int i, int[][] storage) {
        int combineddist = 0;
        combineddist += distance(storage[i-1], storage[i]);
        combineddist += distance(storage[i], storage[i+1]);
        int skipped = distance(storage[i-1], storage[i+1]);
        return combineddist-skipped;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        int num = Integer.parseInt(file.readLine());
        int[][] storage = new int[num][2];
        for (int i = 0; i < num; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            storage[i][0]= Integer.parseInt(st1.nextToken());
            storage[i][1]= Integer.parseInt(st1.nextToken());
        }
        int indexToSkip = 1;
        for (int i = 1; i < storage.length-1; i++) {
            if (difference(indexToSkip, storage) < difference(i, storage)) {
                indexToSkip = i;
            }
        }
        long total = 0;
        int[] prev = storage[0];
        for (int i = 1; i < storage.length; i++) {
            if (i != indexToSkip) {
                total += distance(storage[i], prev);
                prev = storage[i];
            }
        }
        outfile.println(total);
        file.close();
        outfile.close();
    }
}
