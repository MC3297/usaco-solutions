import java.util.*;
import java.io.*;
public class reduce {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int numlines = Integer.parseInt(file.readLine());
        int[][] storage = new int[numlines][2];
        for (int i = 0; i < numlines; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            storage[i][0] = Integer.parseInt(st1.nextToken());
            storage[i][1] = Integer.parseInt(st1.nextToken());
        }
        int Xmaxindex = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[Xmaxindex][0] < storage[i][0]) {
                Xmaxindex = i;
            }
        }
        int Ymaxindex = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[Ymaxindex][1] < storage[i][1]) {
                Ymaxindex = i;
            }
        }
        int Xminindex = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[Xminindex][0] > storage[i][0]) {
                Xminindex = i;
            }
        }
        int Yminindex = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[Yminindex][1] > storage[i][1]) {
                Yminindex = i;
            }
        }
        int aXmax = 0;
        int aXmin = (int)1E8;
        int aYmax = 0;
        int aYmin = (int)1E8;
        for (int i = 0; i < storage.length; i++) {
            if (i != Xmaxindex) {
                aXmax = Math.max(aXmax, storage[i][0]);
                aXmin = Math.min(aXmin, storage[i][0]);
                aYmax = Math.max(aYmax, storage[i][1]);
                aYmin = Math.min(aYmin, storage[i][1]);
            }
        }
        int bXmax = 0;
        int bXmin = (int)1E8;
        int bYmax = 0;
        int bYmin = (int)1E8;
        for (int i = 0; i < storage.length; i++) {
            if (i != Ymaxindex) {
                bXmax = Math.max(bXmax, storage[i][0]);
                bXmin = Math.min(bXmin, storage[i][0]);
                bYmax = Math.max(bYmax, storage[i][1]);
                bYmin = Math.min(bYmin, storage[i][1]);
            }
        }
        
        int cXmax = 0;
        int cXmin = (int)1E8;
        int cYmax = 0;
        int cYmin = (int)1E8;
        for (int i = 0; i < storage.length; i++) {
            if (i != Xminindex) {
                cXmax = Math.max(cXmax, storage[i][0]);
                cXmin = Math.min(cXmin, storage[i][0]);
                cYmax = Math.max(cYmax, storage[i][1]);
                cYmin = Math.min(cYmin, storage[i][1]);
            }
        }
        int dXmax = 0;
        int dXmin = (int)1E8;
        int dYmax = 0;
        int dYmin = (int)1E8;
        for (int i = 0; i < storage.length; i++) {
            if (i != Yminindex) {
                dXmax = Math.max(dXmax, storage[i][0]);
                dXmin = Math.min(dXmin, storage[i][0]);
                dYmax = Math.max(dYmax, storage[i][1]);
                dYmin = Math.min(dYmin, storage[i][1]);
            }
        }
 
        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        a = (aXmax - aXmin) * (aYmax - aYmin);
        b = (bXmax - bXmin) * (bYmax - bYmin);
        c = (cXmax - cXmin) * (cYmax - cYmin);
        d = (dXmax - dXmin) * (dYmax - dYmin);
        
        outfile.println(Math.min(Math.min(a, b), Math.min(c,d)));
        file.close();
        outfile.close();
    }
}