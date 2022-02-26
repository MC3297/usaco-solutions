import java.util.*;
import java.io.*;
public class crosswords {
    public static boolean isHorizontal(char[][] storage, int row, int col) {
        if (storage[row][col] != '.') {
            return false;
        }
        if (col-1 < 0 || (col-1 >= 0 && storage[row][col-1] == '#')) {
            if (col+2 < storage[row].length && storage[row][col+1] == '.' && storage[row][col+2] == '.') {
                return true;
            }
        }
        return false;
    }
    public static boolean isVertical(char[][] storage, int row, int col) {
        if (storage[row][col] != '.') {
            return false;
        }
        if (row-1 < 0 || (row-1 >= 0 && storage[row-1][col] == '#')) {
            if (row+2 < storage.length && storage[row+1][col] == '.' && storage[row+2][col] == '.') {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("crosswords.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));
        StringTokenizer st1 = new StringTokenizer(file.readLine());
        int numrows = Integer.parseInt(st1.nextToken());
        int numcols = Integer.parseInt(st1.nextToken());
        char[][] storage = new char[numrows][numcols];
        for (int i = 0; i < numrows; i++) {
            String s = file.readLine();
            for (int j = 0; j < numcols; j++) {
                storage[i][j] = s.charAt(j);
            }
        }
        int totalclues = 0;
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                if (isHorizontal(storage, i, j) || isVertical(storage, i, j)) {
                    totalclues++; storage[i][j] = '%';
                }
            }
        }
        outfile.println(totalclues);
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                if (storage[i][j] == '%') {
                    outfile.println((i+1)+" "+(j+1));
                }
            }
        }
        file.close();
        outfile.close();
    }
}