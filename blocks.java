import java.util.*;
import java.io.*;
public class blocks {
    public static void union(HashMap<Character, Integer> a, HashMap<Character, Integer> b, HashMap<Character, Integer> returnmap) {
        for (char i: a.keySet()) {
            if (b.containsKey(i)) {
                returnmap.put(i, Math.max(a.get(i), b.get(i)));
            }
            else {
                returnmap.put(i, a.get(i));
            }
        }
        for (char i: b.keySet()) {
            if (!a.containsKey(i)) {
                returnmap.put(i, b.get(i));
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        int testcases = Integer.parseInt(file.readLine());
        String[] first = new String[testcases];
        String[] second = new String[testcases];
        HashMap<Character, Integer>[] deez = new HashMap[testcases];
        for (int i = 0; i < testcases; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            first[i] = st1.nextToken();
            second[i] = st1.nextToken();
            HashMap<Character, Integer> a = new HashMap<Character, Integer>();
            for (int j = 0; j < first[i].length(); j++) {
                if (!a.containsKey(first[i].charAt(j))) {
                    a.put(first[i].charAt(j), 1);
                }
                else {
                    a.put(first[i].charAt(j), a.get(first[i].charAt(j))+1);
                }
            }
            HashMap<Character, Integer> b = new HashMap<Character, Integer>();
            for (int j = 0; j < second[i].length(); j++) {
                if (!b.containsKey(second[i].charAt(j))) {
                    b.put(second[i].charAt(j), 1);
                }
                else {
                    b.put(second[i].charAt(j), b.get(second[i].charAt(j))+1);
                }
            }
            HashMap<Character, Integer> ab = new HashMap<Character, Integer>();
            union(a, b, ab);
            deez[i] = ab;
        }
        HashMap<Character, Integer> finalmap = new HashMap<Character, Integer>();
        //outfile.println(Arrays.toString(deez));
        for (int i = 0; i < deez.length; i++) {
            for (char j: deez[i].keySet()) {
                if (!finalmap.containsKey(j)) {
                    finalmap.put(j, deez[i].get(j));
                }
                else if (finalmap.containsKey(j)) {
                    finalmap.put(j, finalmap.get(j) + deez[i].get(j));
                }
            }
        }
        //outfile.println(finalmap);
        for (int i = 97; i < 123; i++) {
            if (finalmap.containsKey((char)i)) {
                outfile.println(finalmap.get((char)i));
            }
            else {
                outfile.println(0);
            }
        }
        file.close();
        outfile.close();
    }
}