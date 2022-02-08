import java.util.*;
import java.io.*;
public class cowsignal {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int height = Integer.parseInt(st1.nextToken());
        int length = Integer.parseInt(st1.nextToken());
        int scale = Integer.parseInt(st1.nextToken());
        for (int a = 0; a < height; a++) {
            String s = file.readLine();
            for (int i = 0; i < scale; i++) {
                for (int z = 0; z < length; z++) {
                    for (int j = 0; j < scale; j++) {
                        outfile.print(s.charAt(z));
                    }
                }
                outfile.println();
            }
        }
        file.close();
        outfile.close();
    }
}