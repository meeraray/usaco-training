/*
ID: ronukra2
LANG: JAVA
TASK: milk2
*/
/* 
Stand back! This could get moo-sy.
>You're really milking these puns, aren't you?
*/

//SOLVED!

import java.io.*;
import java.util.*;

class milk2 {
  
  //public static boolean separate = true;
  
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
		
		ArrayList<int[]> timeline = new ArrayList<int[]>(Arrays.asList(farmerTimes));
	   
	  //create perfect case by doing combine on all
	  boolean done = false;
	  int itr1pos = 0;
	 int itr2pos = 0;
	  while(done == false) {
	    
	    done = true;
	    Iterator<int[]> itr = timeline.iterator();
	    itr1pos = 0;
	    check:
	    while(itr.hasNext()) {
	      Iterator<int[]> itr2 = timeline.iterator();
	      
	      int[] arr1 = itr.next();
	      itr2pos = 0;
	      while(itr2.hasNext()) {
	        
	        int[] arr2 = itr2.next();
	        //System.out.printf("\n %d %d %d %d \n", arr1[0], arr1[1], arr2[0], arr2[1]);
	        if(canCombine(arr1, arr2)) {
	          //System.out.println("can combine");
	          done = false;
	          //System.out.printf("\n %d %d %d %d \n", arr1[0], arr1[1], arr2[0], arr2[1]);
	          int[] combined = combine(arr1, arr2);
	         // //System.out.printf("\n %d %d \n", combined[0], combined[1]);
	          timeline.remove(itr1pos);
	          //System.out.println(itr1pos);
	          //milk2.print(timeline);
	          //System.out.println(itr2pos > itr1pos ? itr2pos - 1 : itr2pos);
	          timeline.remove(itr2pos > itr1pos ? itr2pos - 1 : itr2pos);
	          timeline.add(combined);
	          break check;
	        } itr2pos++;
	      } itr1pos++;
	    }
	  }
	  
	  //make sure they're in order
    Collections.sort(timeline, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
          return arr1[0] < arr2[0] ? -1 : 0;
      }
    });
    Collections.sort(timeline, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
          return arr1[0] < arr2[0] ? -1 : 1;
      }
    });
	  //System.out.println("End:");
	  //milk2.print(timeline);
	  
	  //find longest idle and working times
	  int biggestIdle = 0;
	  int biggestWorking = 0;
	  int c = 0;
	  Iterator<int[]> maxitr = timeline.iterator(); 
	  while(maxitr.hasNext()) {
	    int[] now = maxitr.next();
	    if(now[1] - now[0] > biggestWorking) {
	      biggestWorking = now[1] - now[0];
	    }
	    if(maxitr.hasNext()) {
	      //System.out.println(timeline.get(c + 1)[0] - now[1]);
	      biggestIdle = timeline.get(c + 1)[0] - now[1] > biggestIdle ? timeline.get(c + 1)[0] - now[1] : biggestIdle;
	    }
	    c++;
	  }
	  //milk2.print(timeline);
	  //System.out.println(biggestWorking);
	  //System.out.println(biggestIdle);
	  //out.printf("%d %d", biggestWorking, biggestIdle);
		out.println(Integer.toString(biggestWorking) + " " + Integer.toString(biggestIdle));
		out.close();
		//System.out.println(canCombine(timeline.get(0), timeline.get(1)));
		//int[] test = combine(timeline.get(0), timeline.get(1));
		//System.out.printf("\n %d %d \n", timeline.get(0)[0], timeline.get(0)[1]);
		                              // close the output file
  }
  
  //one and two 
  public static int[] combine(int[] oneA, int[] twoA) { //returns arraylist, not int[]
    
    int[] one = new int[]{0,0};
    int[] two = new int[]{0,0};
    
    //make sure A is before b 
    if(oneA[0] > twoA[0]) { //if in wrong order switch them
      one = new int[]{ twoA[0], twoA[1] };
      two = new int[]{ oneA[0], oneA[1] };
      
    }
    else { //otherwise just copy
      one = oneA;
      two = twoA;
    }
    
    
    //Check overlap beforehand with canCombine, so not overlapping and identical case is not included here
    
    //case 1: two is in btwn one
    //milk2.separate = false;
    if(two[0] <= one[1] && two[1] <= one[1]){
      ////System.out.println("inside");
      return one;
    } 
    
    //case 2: overlap
    if(two[0] <= one[1]) { //we don't need to check if two's end is after one's end bc that was taken care of in case 1
      return new int[]{one[0], two[1]};
    }
    
    ////System.out.println("impossible!");
    ////System.out.println(Arrays.deepToString(new int[][] {one, two}));
    return new int[]{};///oneN.addAll(twoN);
  }
  
  //also returns false if a and b are the same
  public static boolean canCombine(int[] a, int[] b) {
    if(a[0] == b[0] & a[1] == b[1]) {
      return false;
    }
    if((a[0] <= b[0] & a[1] < b[0]) || (a[0] >= b[0] & a[0] > b[1] )) {
      return false;
    }
    return true;
  }
  
  // public static void print(ArrayList<int[]> list) {
  //   Iterator<int[]> itr = list.iterator();
  //       while(itr.hasNext()) {
  //           //int[] now = itr.next();
  //           System.out.println(Arrays.toString(itr.next()));
  //       }
  // }
  
}
