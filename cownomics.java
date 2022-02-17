import java.util.*;
import java.io.*;
public class cownomics {
    public static boolean compare(HashSet<Character> a, HashSet<Character> b) {
        for (char i: a) {
            if (b.contains(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(file.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] spotty = new String[n];
        String[] normal = new String[n];
        for (int i = 0; i < n; i++) {
            spotty[i] = file.readLine();
        }
        for (int i = 0; i < n; i++) {
            normal[i] = file.readLine();
        }
        int places = 0;
        for (int i = 0; i < m; i++) {
            HashSet<Character> spot = new HashSet<>();
            HashSet<Character> norm = new HashSet<>();
            for (int j = 0; j < spotty.length; j++) {
                spot.add(spotty[j].charAt(i));
            }
            for (int j = 0; j < normal.length; j++) {
                norm.add(normal[j].charAt(i));
            }
            if (compare(spot, norm)) {
                places++;
            }
        }
        outfile.println(places);
        file.close();
        outfile.close();
    }
}