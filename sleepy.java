import java.util.*;
import java.io.*;
public class sleepy {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int numcases = Integer.parseInt(file.readLine());
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        /*ArrayList<Integer> arr = new ArrayList<>(numcases);
        for (int j = 0; j < numcases; j++) {
            arr.add(Integer.parseInt(st1.nextToken()));
        }*/
        int[] storage = new int[numcases];
        for (int i = 0; i < numcases; i++) {
            storage[i] = Integer.parseInt(st1.nextToken());
        }
        int index = 0;
        for (int i = numcases-1; i >= 1; i--) {
            if (storage[i-1] > storage[i]) {
                index = i;
                break;
            }
        }
        outfile.println(index);
        //outfile.println(storage.length - index);
        
        file.close();
        outfile.close();
    }
}