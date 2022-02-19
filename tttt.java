import java.util.*;
import java.io.*;
public class tttt {
    public static boolean wins(char[][] arr, char a, char b) {
        HashSet<Character> deez = new HashSet<>(2); deez.add(a); deez.add(b);
        HashSet<Character> check = new HashSet<>(3);
        check.add(arr[0][0]); check.add(arr[0][1]); check.add(arr[0][2]);
        if (check.equals(deez)) return true;
        check.clear();
        check.add(arr[1][0]); check.add(arr[1][1]); check.add(arr[1][2]);if (check.equals(deez)) return true; check.clear();
        check.add(arr[2][0]); check.add(arr[2][1]); check.add(arr[2][2]);if (check.equals(deez)) return true;check.clear();
        check.add(arr[0][0]); check.add(arr[1][0]); check.add(arr[2][0]);if (check.equals(deez)) return true;check.clear();
        check.add(arr[0][1]); check.add(arr[1][1]); check.add(arr[2][1]);if (check.equals(deez)) return true;check.clear();
        check.add(arr[0][2]); check.add(arr[1][2]); check.add(arr[2][2]);if (check.equals(deez)) return true;check.clear();

        check.add(arr[0][0]); check.add(arr[1][1]); check.add(arr[2][2]);if (check.equals(deez)) return true;check.clear();
        check.add(arr[2][0]); check.add(arr[1][1]); check.add(arr[0][2]);if (check.equals(deez)) return true;check.clear();
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        char[][] storage = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String s = file.readLine();
            for (int j = 0; j < s.length(); j++) {
                storage[i][j] = s.charAt(j);
            }
        }
        int numones = 0;
        int numtwos = 0;
        for (int i = 65; i < 91; i++) {
            if (wins(storage, (char)i, (char)i)){numones++;}
        }
        //outfile.println();
        for (int i = 65; i < 91; i++) {
            for (int j = i+1; j < 91; j++) {
                if (wins(storage, (char)i, (char)j)){numtwos++;}
            }
        }
        outfile.println(numones);
        outfile.println(numtwos);
        //outfile.println(wins(storage, 'C', 'X'));
        file.close();
        outfile.close();
    }
}