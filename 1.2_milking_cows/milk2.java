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
		int[][] farmerTimes = new int[n][2];
		for(int i = 0; i < n; i++) {
		  st = new StringTokenizer(f.readLine());
		  farmerTimes[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		int[] timeline = new int[1000001];
		int farthestPoint = 0;
		int earliestPoint = 1000000;
		for(int[] coord : farmerTimes){
		  for(int i = coord[0]; i <= coord[1]; i++){
		    timeline[i] = 1;
		    if(coord[1] > farthestPoint) {
		      farthestPoint = coord[1]; //determine farthest point for use in idle time
		    }
		    if(coord[0] < earliestPoint) {
		      earliestPoint = coord[0]; //determine farthest point for use in idle time
		    }
		  }
		}
		
		System.out.println(earliestPoint);
		
		//StdOut.printf("Farthest Point: %d", farthestPoint);
		
		//longest milking time
		boolean started = false;
    int current = 0;
    int max = 0;
    int count = 0;
    
    for(int now : timeline) {
    	if(now == 1) {
    		if(started == false) { //beginning of chain
    			started = true;
    		}
    		current++;
    		//System.out.println("on element:"  + count);
  			//System.out.println(current);
    	}
    	if(now == 0 || count == 1000000) { //now = 0
    		if(started) {//end of chain
    			started = false;
    			max = Math.max(max, current);
    			current = 0;
    		}
    	}
    	count++;
    }
    
    int maxMilking = max - 1;
    
    System.out.println(maxMilking);
    //System.out.println(count);
    
    
    //longest idle time
		started = false;
    current = 0;
    max = 0;
    count = 0;
    
    for(int now : timeline) {
    	if(now == 0) {
    	  if(count > farthestPoint) { 
    	    break;
    	  }
	      if(count < earliestPoint) { 
    	    continue;
    	  }
    		if(started == false) { //beginning of chain
    			started = true;
    		}
  			current++;
  			//System.out.println("on element:"  + count);
  			//System.out.println(current);
    	}
    	if(now == 1) { //now = 0
    		if(started) {//end of chain
    			started = false;
    			max = Math.max(max, current);
    			current = 0;
    		}
    	}
    	count++;
    }
    
    int maxIdle = max + 1; //counting system on prob text involves non-inclusive, simple subtraction
    
    
    out.println(maxMilking + " " + maxIdle);                           // output result
    out.close();                                  // close the output file
  }
}
