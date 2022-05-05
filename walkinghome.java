import java.io.*;
import java.util.*;
//walking home but DP O(n^2k)
class info {
    int up;
    int left;
    public info(int up, int left) {
        this.up = up;
        this.left = left;
    }
    public void add(int up, int left) {
        this.up += up;
        this.left += left;
    }
    @Override
    public String toString() {//debug
        return "["+up+","+left+"]";
    }
}
public class walkinghome {
    public static void fill(info[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = new info(0,0);
                }
            }
        }
    }
    public static void print(info[][][] dp) {//debug
        for (int k = 0; k < dp[0][0].length; k++) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    System.out.print(dp[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numtestcases = Integer.parseInt(r.readLine());
        for (int q = 0; q < numtestcases; q++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[][] original = new char[n+1][n+1];
            for (int i = 0; i < n; i++) {
                String s = r.readLine();
                for (int j = 0; j < s.length(); j++) {
                    original[i+1][j+1] = s.charAt(j);
                }
            }

            info[][][] dp = new info[n+1][n+1][k+1];
            fill(dp);
            dp[1][1][0] = new info(1, 1);//take care of base cases
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (original[i][j] == '.') {
                        dp[i][j][0].add(dp[i-1][j][0].up, dp[i][j-1][0].left);
                    }
                }
            }
            dp[1][1][0] = new info(0, 0);

            for (int l = 1; l <= k; l++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (original[i][j] == '.') {
                            dp[i][j][l].add(dp[i-1][j][l].up + dp[i-1][j][l-1].left, dp[i][j-1][l].left + dp[i][j-1][l-1].up);
                        }
                    }
                }
            }
            int total = 0;
            for (int i = 0; i <= k; i++) {
                total += dp[n][n][i].up;
                total += dp[n][n][i].left;
            }
            //print(dp);
            pw.println(total);
        }
        pw.close();
    }
}
