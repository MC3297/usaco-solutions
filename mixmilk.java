import java.util.*;
import java.io.*;
public class mixmilk {
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        StringTokenizer st1;
        int[][] storage = new int[3][2];
        st1 = new StringTokenizer(file.readLine());
        storage[0][0] = Integer.parseInt(st1.nextToken());//capacity
        storage[0][1] = Integer.parseInt(st1.nextToken());//currval
        st1 = new StringTokenizer(file.readLine());
        storage[1][0] = Integer.parseInt(st1.nextToken());
        storage[1][1] = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(file.readLine());
        storage[2][0] = Integer.parseInt(st1.nextToken());
        storage[2][1] = Integer.parseInt(st1.nextToken());
        //outfile.println(Arrays.deepToString(storage));
        for (int i = 0; i < 100; i++) { //0 to 1, 1 to 2, 2 to 3
            //storage[i%3] 
            if (storage[(i+1)%3][0]-storage[(i+1)%3][1] >= storage[i%3][1]) {
                storage[(i+1)%3][1] += storage[i%3][1];
                storage[i%3][1] = 0;
            }
            //outfile.println(Arrays.deepToString(storage));
            else if (storage[(i+1)%3][0]-storage[(i+1)%3][1] < storage[i%3][1]){
                storage[i%3][1]-= (storage[(i+1)%3][0]-storage[(i+1)%3][1]);
                storage[(i+1)%3][1] = storage[(i+1)%3][0];

            }
        }
        outfile.println(storage[0][1]);
        outfile.println(storage[1][1]);
        outfile.println(storage[2][1]);
        //outfile.println(Arrays.deepToString(storage));
        file.close();
        outfile.close();
    }
}