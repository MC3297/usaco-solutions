import java.util.*;
import java.io.*;
public class art {
    public static int leastRow(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static int greatRow(int[][] arr, int target) {
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static int leastCol(int[][] arr, int target) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static int greatCol(int[][] arr, int target) {
        for (int i = arr[0].length-1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("art.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
        int n = Integer.parseInt(file.readLine());
        int[][] storage = new int[n][n];
        HashSet<Integer> check = new HashSet<>(10);
        for (int i = 0; i < n; i++) {
            String s = file.readLine();
            for (int j = 0; j < s.length(); j++) {
                storage[i][j] = Character.getNumericValue(s.charAt(j));
                check.add(Character.getNumericValue(s.charAt(j)));
            }
        }
        if (check.contains(0))check.remove(0);
        if (check.contains(-1))check.remove(-1);
        HashSet<Integer> checkv2 = new HashSet<>();
        checkv2 = (HashSet)check.clone();
        for (int p: check) {
            for (int i = leastRow(storage, p); i <= greatRow(storage, p); i++) {
                for (int j = leastCol(storage, p); j <= greatCol(storage, p); j++) {
                    if (storage[i][j] != p) {
                        if (checkv2.contains(storage[i][j])) checkv2.remove(storage[i][j]);
                    }
                }
            }
        }
        outfile.println(checkv2.size());
        file.close();
        outfile.close();
    }
}