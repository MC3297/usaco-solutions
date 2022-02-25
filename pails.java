import java.util.*;
import java.io.*;
public class pails {
    public static void main(String[] args) throws IOException{
    BufferedReader file = new BufferedReader(new FileReader("pails.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int x = Integer.parseInt(st1.nextToken());
        int y = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int max = 0;
        for (int i = 0; i <= m/x; i++) {
            int currval = i*x;
            currval += (m-currval)/y * y;
            max = Math.max(max, currval);
        }
        outfile.println(max);
        file.close();
        outfile.close();
    }
}