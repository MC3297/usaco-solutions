import java.util.*;
import java.io.*;
public class hoofball {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        int numcases = Integer.parseInt(file.readLine());
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int[] deez = new int[numcases];
        for (int i = 0; i < numcases; i++) {
            deez[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(deez); //left is 0, right is 1
        int[] pointers = new int[numcases];
        pointers[0] = 1; pointers[numcases-1] = 0;
        for (int i = 1; i < numcases-1; i++) {
            if (deez[i] - deez[i-1] <= deez[i+1] - deez[i]) {
                pointers[i] = 0;
            }
            else if (deez[i] - deez[i-1] > deez[i+1] - deez[i]) {
                pointers[i] = 1;
            }
        }
        int total = 0;
        for (int i = 0; i < numcases-1; i++) {
            if (pointers[i] == 1 && pointers[i+1] == 0) {
                int temp = 0;
                if (i-1 >= 0 && pointers[i-1] == 1) {
                    temp++;
                } 
                if (i+2 <numcases && pointers[i+2] == 0) {
                    temp++;
                }
                if (temp == 0) {
                    temp++;
                }
                total += temp;
            }
        }
        //outfile.println(Arrays.toString(pointers));
        outfile.println(total);
        file.close();
        outfile.close();
    }
}