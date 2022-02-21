import java.util.*;
import java.io.*;
public class buckets {
    public static boolean between(int x, int a, int b) {
        if (a < x && x < b || b < x && x < a) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        int barnrow = 0;
        int barncol = 0;
        int lakerow = 0;
        int lakecol = 0;
        int rockrow = 0;
        int rockcol = 0;
        for (int i = 0; i < 10; i++) {
            String s = file.readLine();
            for (int j = 0; j < 10; j++) {
                if (s.charAt(j) == 'R') {rockrow = i; rockcol = j;}
                else if (s.charAt(j) == 'B') { barnrow = i; barncol = j;}
                else if (s.charAt(j) == 'L') {lakerow = i; lakecol = j;}
            }
        }
        if (lakerow == barnrow && rockrow == lakerow && between(rockcol, barncol, lakecol)) {
            outfile.println(Math.abs(barncol-lakecol)+1);
        }
        else if (lakecol == barncol && rockcol == lakecol && between(rockrow, barnrow, lakerow)) {
            outfile.println(Math.abs(barnrow-lakerow)+1);
        }
        else {
            outfile.println(Math.abs(barnrow - lakerow) + Math.abs(barncol - lakecol)-1);
        }
        file.close();
        outfile.close();
    }
}