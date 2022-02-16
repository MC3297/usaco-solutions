import java.util.*;
import java.io.*;
public class notlast {
    public static int min(HashMap<String, Integer> hm) {
        int min = (int)1000000;
        for (int i: hm.values()) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        int cases = Integer.parseInt(file.readLine());
        HashMap<String, Integer> hm = new HashMap<>(cases);
        hm.put("Bessie", 0);
        hm.put("Elsie", 0);
        hm.put("Daisy", 0);
        hm.put("Gertie", 0);
        hm.put("Annabelle", 0);
        hm.put("Maggie", 0);
        hm.put("Henrietta", 0);

        for (int i = 0; i < cases; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            String name = st1.nextToken();
            hm.put(name, hm.get(name) + Integer.parseInt(st1.nextToken()));
        }
        //outfile.println(hm);
        int min = 69420;
        int secmin = min;
        for (String i: hm.keySet()) {
            if (hm.get(i) < min) {
                secmin = min; min = hm.get(i);
            }
            else if (hm.get(i) > min && hm.get(i) < secmin) {
                secmin = hm.get(i);
            }
        }
        //outfile.println(min);
        //outfile.println(secmin);
        if (secmin == 69420) {
            outfile.println("Tie");
            file.close();
            outfile.close();
        }
        int num = 0;
        for (String i: hm.keySet()) {
            if (hm.get(i) == secmin) {
                num++;
            }
        }
        //outfile.println(num);
        if (num >= 2) {
            outfile.println("Tie");
            file.close();
            outfile.close();
        }
        for (String i: hm.keySet()) {
            if (hm.get(i) == secmin) {
                outfile.println(i);
                file.close();
                outfile.close();
                break;
            }
        }
        file.close();
        outfile.close();
    }
}