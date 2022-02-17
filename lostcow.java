import java.util.*;
import java.io.*;
public class lostcow {
    public static boolean isBetween(long a, long b, long x) {
        if (a <= x && x <= b) {
            return true;
        }
        if (a >= x && x >= b) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        long x = Integer.parseInt(st1.nextToken());
        long y = Integer.parseInt(st1.nextToken());
        long ex = 1;
        long negpos = 1;
        long prevint = x;
        long nextint = x;
        long store = 0;
        while (!isBetween(x, nextint, y)) {
            prevint = nextint;
            nextint = x + negpos*ex;
            //outfile.println("next int is " + nextint);
            //outfile.println("increment by  " + negpos*ex);
            store += Math.abs(nextint-prevint);
            ex *= 2;
            negpos *= -1;
        }
        
        outfile.println(store - (Math.abs(nextint-y)));
        file.close();
        outfile.close();
    }
}