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
		
		//create and populate timeline
		int[][] farmerTimes = new int[n * 2][2];
		for(int i = 0; i < n * 2; i += 2) {
		  st = new StringTokenizer(f.readLine());
		  
		  farmerTimes[i] = new int[]{Integer.parseInt(st.nextToken()), 1};
		  farmerTimes[i + 1] = new int[] {Integer.parseInt(st.nextToken()), 0};
		}
		
		//put 'em in order
		Arrays.sort(farmerTimes, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
          return Integer.compare(o1[0], o2[0]);
      }
    });

    //longest milking time
    int max = 0;
    int current = 0;
    int start = 0;
    boolean stillGoing = false;
    for(int[] coord : farmerTimes) {
      if(coord[1] == 1) {
        if(stillGoing == false) {
          stillGoing = true;
          start = coord[0];
        }
        else{
          current = coord[0] - start;
        }
        System.out.println(coord);
      }
      else {
        if(current > max) {
          max = current;
        }
        current = 0;
        stillGoing = false;
      }
    }
		
		System.out.println(Arrays.deepToString(farmerTimes));
		System.out.println(max);
		//int[][] farmerTimes = new int[n][2]; 
		// for(int i = 0; i < n; i++) {
		//   farmerTimes[i][0]= 1;
		//   farmerTimes[i][1]= 2;
		// }
		
		// int[] timeline = new int[1000000];
		// for(int i = 0; i < timeline.length; i++) {
		//   timeline[i] = i;
		//   System.out.println(timeline[i]);
		// }
    //int i1 = Integer.parseInt(st.nextToken());    // first integer
    // int i2 = Integer.parseInt(st.nextToken());    // second integer
    // out.println(i1+i2);                           // output result
    // out.close();                                  // close the output file
  }
}
