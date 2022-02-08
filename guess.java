import java.util.*;
import java.io.*;
public class guess {
    public static int sharedHashSet(HashSet<String> first, HashSet<String> second) {
        int returnval = 0;
        for (String i: first) {
            if (second.contains(i)) {
                returnval++;
            }
        }
        return returnval;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("guess.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        int tescase = Integer.parseInt(file.readLine());
        StringTokenizer st1;
        HashSet<String>[] storage = new HashSet[tescase];
        for (int i = 0; i < tescase; i++) {
            st1 = new StringTokenizer(file.readLine());
            String name = st1.nextToken();
            int numtimes = Integer.parseInt(st1.nextToken());
            storage[i] = new HashSet<String>(numtimes);
            for (int j = 0; j < numtimes; j++) {
                storage[i].add(st1.nextToken());
            }
        }
        int max = 0;
        
        for (int i = 0; i < storage.length; i++) {
            for (int j = i+1; j < storage.length; j++) {
                max = Math.max(max, sharedHashSet(storage[i], storage[j]));
            }
        }
        
        
        outfile.println(max+1);
        /*ArrayList<String>[] storage = new ArrayList[tescase];
        for (int a = 0; a < tescase; a++) {
            storage[a] = new ArrayList<String>();
            st1 = new StringTokenizer(file.readLine());
            String name = st1.nextToken();
            storage[a].add(name);
            int numch = Integer.parseInt(st1.nextToken());
            for (int b = 0; b < numch; b++) {
                storage[a].add(st1.nextToken());
            }
        }*/
        
        
        file.close();
        outfile.close();
    }
}