import java.util.*;
import java.io.*;
public class blist {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("blist.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        int n = Integer.parseInt(file.readLine());
        int[][] storage = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            storage[i][0] = Integer.parseInt(st1.nextToken());
            storage[i][1] = Integer.parseInt(st1.nextToken());
            storage[i][2] = Integer.parseInt(st1.nextToken());
        }
        int[] last = new int[findMax(storage)];
        for (int i = 0; i < storage.length; i++) {
            for (int j = storage[i][0]; j < storage[i][1]; j++) {
                last[j] += storage[i][2];
            }
        }
        //outfile.println(Arrays.toString(last));
        int m = 0;
        for (int i = 0; i < last.length; i++) {
            m = Math.max(m, last[i]);
        }
        outfile.println(m);
        file.close();
        outfile.close();
    }
    public static int findMin(int[][] arr) {
        int min = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i][0], min);
        }
        return min;
    }
    public static int findMax(int[][] arr) {
        int max = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i][1], max);
        }
        return max;
    }
}