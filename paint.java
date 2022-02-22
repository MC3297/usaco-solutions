import java.util.*;
import java.io.*;
public class paint {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("paint.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(file.readLine());
        int c = Integer.parseInt(st1.nextToken());
        int d = Integer.parseInt(st1.nextToken());
        HashSet<Integer> check = new HashSet<>();
        for (int i = a; i < b; i++) {
            check.add(i);
        }
        for (int i = c; i < d; i++) {
            check.add(i);
        }
        outfile.println(check.size());
        file.close();
        outfile.close();
    }
}