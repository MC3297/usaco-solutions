import java.util.*;
import java.io.*;
public class lineup {
    public static int translate(String s) {
        if (s.equals("Beatrice")) {
            return 1;
        }
        if (s.equals("Belinda")) {
            return 2;
        }
        if (s.equals("Bella")) {
            return 3;
        }
        if (s.equals("Bessie")) {
            return 4;
        }
        if (s.equals("Betsy")) {
            return 5;
        }
        if (s.equals("Blue")) {
            return 6;
        }
        if (s.equals("Buttercup")) {
            return 7;
        }
        if (s.equals("Sue")) {
            return 8;
        }
        return 0;
    }
    public static int arrToNum(int[] arr) {
        int finalval = 0;
        for (int i = 0; i < arr.length; i++) {
            finalval += arr[i] * Math.pow(10, i);
        }
        return finalval;
    }
    public static boolean works(int[] a, int[][] b) {
        for (int i = 0; i < b.length; i++) {
            boolean fal = false;
            for (int j = 1; j < a.length; j++) {
                if ((a[j] == b[i][0] && a[j-1] == b[i][1]) || (a[j] == b[i][1] && a[j-1] == b[i][0])) {
                    fal = true;
                }
            }
            if (fal == false) {
                return false;
            }
        }
        return true;
    }
    public static boolean unique(int[] arr) {
        HashSet<Integer> check = new HashSet<>(8);
        for (int i = 0; i < arr.length; i++) {
            check.add(arr[i]);
        }
        if (check.size() != arr.length) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        //StringTokenizer st1 = new StringTokenizer(file.readLine());
        int n = Integer.parseInt(file.readLine());
        //int[][] storage = new int[n][2];
        int[][] storage = new int[n][2];
        int[] v = new int[8];
        int min = 2147483646;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(file.readLine());
            storage[i][0] = translate(st.nextToken());
            st.nextToken();st.nextToken();st.nextToken();st.nextToken();
            storage[i][1] = translate(st.nextToken());
        }
        //outfile.println(Arrays.deepToString(storage));
        for (int a = 1; a <= 8; a++) {
            for (int b = 1; b <= 8; b++) {
                for (int c = 1; c <= 8; c++) {
                    for (int d = 1; d <= 8; d++) {
                        for (int e = 1; e <= 8; e++) {
                            for (int f = 1; f <= 8; f++) {
                                for (int g = 1; g <= 8; g++) {
                                    for (int h = 1; h <= 8; h++) {
                                        v[0]=a; v[1]=b; v[2]=c; v[3]=d; v[4]=e; v[5]=f; v[6]=g; v[7]=h;
                                        //outfile.println(Arrays.toString(v));
                                        if (works(v, storage) && unique(v)) {
                                            min = Math.min(min, arrToNum(v));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /*for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 8; j++) {
                for (int k = j+1; k < 8; k++) {
                    outfile.println(i + " " + j + " " + k);
                }
            }
        }*/
        //outfile.println(min);
        String s = String.valueOf(min);
        for (int i = 0; i < s.length(); i++) {
            outfile.println(untranslate(s.charAt(i)));
        }
        file.close();
        outfile.close();
    }
    public static String untranslate(char a) {
        if (a == '1') {return "Beatrice";}
        if (a == '2') {return "Belinda";}
        if (a == '3') {return "Bella";}
        if (a == '4') {return "Bessie";}
        if (a == '5') {return "Betsy";}
        if (a == '6') {return "Blue";}
        if (a == '7') {return "Buttercup";}
        if (a == '8') {return "Sue";}
        return "hi";
    }
}