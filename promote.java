import java.util.*;
import java.io.*;
public class promote {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("promote.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int bronze1 = Integer.parseInt(st1.nextToken());
        int bronze2 = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(file.readLine());
        int silver1 = Integer.parseInt(st1.nextToken());
        int silver2 = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(file.readLine());
        int gold1 = Integer.parseInt(st1.nextToken());
        int gold2 = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(file.readLine());
        int plat1 = Integer.parseInt(st1.nextToken());
        int plat2 = Integer.parseInt(st1.nextToken());

        int b2s = 0;
        int s2g = 0;
        int g2p = 0;

        b2s += plat2 - plat1; s2g += plat2 - plat1; g2p += plat2 - plat1;
        b2s += gold2 - gold1; s2g += gold2 - gold1;
        b2s += silver2 - silver1;
        outfile.println(b2s);
        outfile.println(s2g);
        outfile.println(g2p);
        file.close();
        outfile.close();
    }
}