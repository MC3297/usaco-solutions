import java.io.*;
import java.util.*;
public class acowdemia1 {
    public static long defaultval(long[] arr) {
        long max = (int)-1E8;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr.length-i) {
                max = Math.max(max, arr.length-i);
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        long n = Integer.parseInt(st.nextToken());
        long l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        long[] storage = new long[(int)n];
        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(storage);
        long hindex = defaultval(storage);
        for (int i = 0; i < n; i++) {
            if (storage[i]+1 == n-i) {
                long currindex = i;
                long numtimes = 0;
                while (currindex < storage.length && storage[(int)currindex]+1 == n-i) {
                    currindex++; numtimes++;
                }
                if (numtimes <= l) {
                    hindex = Math.max(hindex, n-i);
                }
            }
        }
        pw.println(hindex);
        pw.close();
    }
}
