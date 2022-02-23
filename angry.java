import java.util.*;
import java.io.*;
public class angry {
    public static int range(int[] storage, int start) {
        int radius = 1;
        int right = start;
        boolean switches = true;
        while (switches) {
            switches = false;
            int prev = storage[right];
            while (right+1 < storage.length && storage[right+1] <= prev+radius) {
                switches = true;
                right++;
            }
            radius++;
        }
        int lradius = 1;
        int left = start;
        switches = true;
        while (switches) {
            switches = false;
            int prev = storage[left];
            while (left-1 >= 0 && storage[left-1] >= prev-lradius) {
                switches = true;
                left--;
            }
            lradius++;
        }
        //System.out.println(storage[left]);
        //System.out.println(storage[right]);
        return right-left+1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("angry.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int n = Integer.parseInt(file.readLine());
        int[] storage = new int[n];
        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(file.readLine());
        }
        Arrays.sort(storage);
        int max = 0;
        for (int i = 0; i < storage.length; i++) {
            //outfile.println(range(storage, i));
            max = Math.max(max, range(storage, i));
        }
        outfile.println(max);
        file.close();
        outfile.close();
    }
}