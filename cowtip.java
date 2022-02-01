import java.util.*;
import java.io.*;
public class cowtip {
    public static void reverse(int[][] arr, int row, int col) {
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                }
                else if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        int testcases = Integer.parseInt(file.readLine());
        int[][] storage = new int[testcases][testcases];
        for (int i = 0; i < testcases; i++) {
            String s = file.readLine();
            //StringTokenizer st1 = new StringTokenizer(file.readLine());
            for (int j = 0; j < testcases; j++) {
                storage[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        int moves = 0;
        for (int i = storage.length-1; i >= 0; i--) {
            for (int j = storage[i].length-1; j >= 0; j--) {
                if (storage[i][j] == 1) {
                    moves++;
                    reverse(storage, i, j);
                }
            }
        }
        outfile.println(moves);
        //outfile.println(Arrays.deepToString(storage));
        file.close();
        outfile.close();
    }
}