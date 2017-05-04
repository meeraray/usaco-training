/*
ID: ronukra2
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
		int n = Integer.parseInt(st.nextToken());
		int[][] farmerTimes = new int[n][2]; 
		for(int i = 0; i < n; i++) {
		  farmerTimes[i][0]= 1;
		  farmerTimes[i][1]= 2;
		}
		//System.out.println(Arrays.deepToString(farmerTimes));
    //int i1 = Integer.parseInt(st.nextToken());    // first integer
    // int i2 = Integer.parseInt(st.nextToken());    // second integer
    // out.println(i1+i2);                           // output result
    // out.close();                                  // close the output file
  }
}
