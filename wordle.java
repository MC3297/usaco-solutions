import java.io.*;
import java.util.*;

public class wordle {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        String[] correctarr = new String[3];
        String[] ansarr = new String[3];
        correctarr[0] = r.readLine();correctarr[1] = r.readLine();correctarr[2] = r.readLine();
        ansarr[0] = r.readLine();ansarr[1] = r.readLine();ansarr[2] = r.readLine();
        int correct = 0;
        HashMap<Character, Integer> corr = new HashMap<>(26);
        HashMap<Character, Integer> ans = new HashMap<>(26);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!corr.containsKey(correctarr[i].charAt(j))) {
                    corr.put(correctarr[i].charAt(j), 1);
                }
                else if (corr.containsKey(correctarr[i].charAt(j))) {
                    corr.put(correctarr[i].charAt(j), corr.get(correctarr[i].charAt(j))+1);
                }
                if (!ans.containsKey(ansarr[i].charAt(j))) {
                    ans.put(ansarr[i].charAt(j), 1);
                }
                else if (ans.containsKey(ansarr[i].charAt(j))) {
                    ans.put(ansarr[i].charAt(j), ans.get(ansarr[i].charAt(j))+1);
                }

            }
        }
        //pw.println(corr);
        //pw.println(ans);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (correctarr[i].charAt(j) == ansarr[i].charAt(j)) {
                    correct++;
                    corr.put(correctarr[i].charAt(j), corr.get(correctarr[i].charAt(j))-1);
                    ans.put(ansarr[i].charAt(j), ans.get(ansarr[i].charAt(j))-1);
                }
            }
        }
        int warning = 0;
        for (char i: corr.keySet()) {
            if (ans.containsKey(i)) {
                warning += Math.min(corr.get(i), ans.get(i));
            }
        }
        pw.println(correct);
        pw.println(warning);
		pw.close();
	}
}