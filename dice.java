import java.io.*;
import java.util.*;

public class dice {
    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static boolean beats(int[] a, int[] b) {
        int awins = 0;
        int bwins = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] > b[j]) {
                    awins++;
                }
                else if (b[j] > a[i]) {
                    bwins++;
                }
            }
        }
        if (awins > bwins) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int numtests = Integer.parseInt(r.readLine());
		//int[] storage = new int[numtests];
        int[] a = new int[4];
        int[] b = new int[4];
		for (int q = 0; q < numtests; q++) {
            boolean returned = false;
			StringTokenizer st = new StringTokenizer(r.readLine());
			for (int j = 0; j < 4; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
            for (int j = 0; j < 4; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
            int[] c = new int[4];
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    for (int k = 1; k <= 10; k++) {
                        for (int l = 1; l <= 10; l++) {
                            c[0] = i;
                            c[1] = j;
                            c[2] = k;
                            c[3] = l;
                            if (returned == false) {
                                if ((beats(a, b) && beats(b, c) && beats(c, a)) || (beats(a, c) && beats(c, b) && beats(b, a))) {
                                    pw.println("yes");
                                    returned = true;
                                }
                            }
                        }
                    }
                }
            }
            if (returned == false) {
                pw.println("no");
            }
			//Integer.parseInt(st.nextToken());
		}
        
		pw.close();
	}
}