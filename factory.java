import java.util.*;
import java.io.*;
public class factory {
    public static void bfs(int n, int start, ArrayList<ArrayList<Integer>> graph, HashSet<Integer> check){
        // n = number of nodes
        // start = starting node
        // graph = adjacency list
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int x = q.peek();
            q.poll();
            for(int i: graph.get(x)){
                // do whatever you want to the node here
                if(visited[i] == false){
                    check.add(i);
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("factory.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        int n = Integer.parseInt(file.readLine());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            adj.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> check = new HashSet<>();
            bfs(n, i, adj, check);
            if (check.size() == n-1) {
                outfile.println(i);
                file.close();
                outfile.close();
                break;
            }
        }
        outfile.println(-1);
        //outfile.println(adj);
        //outfile.println(check);
        file.close();
        outfile.close();
    }
}