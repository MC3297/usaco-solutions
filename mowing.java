import java.util.*;
import java.io.*;
public class mowing {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        HashMap<String, Integer> check = new HashMap<>();
        int n = Integer.parseInt(file.readLine());
        int time = 0;
        int x = 0;
        int y = 0;
        ArrayList<Integer> timediff = new ArrayList<>();
        check.put(x+" "+y, 0);
        for (int m = 0; m < n; m++) {
            StringTokenizer st1 = new StringTokenizer(file.readLine());
            String direction = st1.nextToken();
            int length = Integer.parseInt(st1.nextToken());
            if (direction.equals("N")) { //y++
                for (int i = 0; i < length; i++) {
                    y++;
                    time++;
                    if (check.containsKey(x+" "+y)) {
                        timediff.add(time-check.get(x+" "+y));
                    }
                    check.put(x+" "+y, time);
                }
            }
            else if (direction.equals("S")) { //y--
                for (int i = 0; i < length; i++) {
                    y--;
                    time++;
                    if (check.containsKey(x+" "+y)) {
                        timediff.add(time-check.get(x+" "+y));
                    }
                    check.put(x+" "+y, time);
                }
            }
            else if (direction.equals("E")) { //x++
                for (int i = 0; i < length; i++) {
                    x++;
                    time++;
                    if (check.containsKey(x+" "+y)) {
                        timediff.add(time-check.get(x+" "+y));
                    }
                    check.put(x+" "+y, time);
                }
            }
            else if (direction.equals("W")) { //x--
                for (int i = 0; i < length; i++) {
                    x--;
                    time++;
                    if (check.containsKey(x+" "+y)) {
                        timediff.add(time-check.get(x+" "+y));
                    }
                    check.put(x+" "+y, time);
                }
            }
        }
        if (timediff.size() == 0) {
            outfile.println(-1);
        }
        else {
            int min = timediff.get(0);
            for (int i: timediff) {
                if (i < min) min = i;
            }
            outfile.println(min);
        }
        
        file.close();
        outfile.close();
    }
}