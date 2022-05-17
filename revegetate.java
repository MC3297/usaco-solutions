import java.io.*;
import java.util.*;
public class revegetate {
    public static void add(HashMap<Integer, ArrayList<Integer>> adj, int x, int y) {
        if (adj.containsKey(x)) adj.get(x).add(y);//x -> y
        else if (!adj.containsKey(x)) {adj.put(x, new ArrayList<>()); adj.get(x).add(y);}
    }
    public static void main(String[] args) throws IOException {
        Kattio k = new Kattio("revegetate");
        int n = k.nextInt();
        int m = k.nextInt();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = k.nextInt();
            int y = k.nextInt();
            add(adj, Math.max(x,y), Math.min(x,y));
        }
        HashMap<Integer, Integer> colors = new HashMap<>();
        for (int i = 1; i <= n; i++) colors.put(i, 1);
        for (int i = 2; i <= n; i++) {
            if (adj.get(i) != null) colors.put(i, nextAvailable(adj.get(i), colors));
        }
        for (int i = 1; i <= n; i++) k.print(colors.get(i));
        k.close();
    }
    public static int nextAvailable(ArrayList<Integer> list, HashMap<Integer, Integer> colors) {
        HashSet<Integer> tempset = new HashSet<>();
        for (int i: list) tempset.add(colors.get(i));
        for (int i = 1; i <= 4; i++) {
            if (!tempset.contains(i)) return i;
        }
        return 1;
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
    
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
    
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
    
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        }
}