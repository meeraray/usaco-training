import java.io.*;
import java.util.*;

class hanoi {
    
    public static ArrayList<int[]> posts = new ArrayList<int[]>();
    
    public static void main(String[] args) {
        posts.add(new int[]{1, 2, 3, 4, 5});
        posts.add(new int[]{0, 0, 0, 0, 0});
        posts.add(new int[]{0, 0, 0, 0, 0});
        print(posts);
        //System.out.println(getTopNum(1));
        move(0,1);
        move(0,1);
        move(0,2);
        move(0,2);
        move(0,2);
        move(2,1);
        move(2,0);
        move(2,0);
        print(posts);
    }
    
    /* moves top of 1 stack onto top of another 
    returns true only if transfer was successfull
    not successful (returns false) if: 
        destination post already full or 
        if disk on top is greater than destination disk on bottom (moved disk must be < destination disk)
        originalStack is empty
        arguments out of bounds
    */
    public static boolean move(int originalStack, int destinationStack) {
        if(originalStack == destinationStack) { //same stack
            return false;
        }
        if(getTopPos(originalStack) == 0) { //empty original
            return false;
        }
        if(getTopPos(destinationStack) == 5) { //destination full
            return false;
        }
        if(getTopPos(destinationStack) != 0) { 
            if(getTopNum(originalStack) > getTopNum(destinationStack)) {
                return false;
            }
        }
        posts.get(destinationStack)[getTopPos(destinationStack)] = getTopNum(originalStack);
        posts.get(originalStack)[getTopPos(originalStack) - 1] = 0;
        return true;
    }
    
    /* returns the top position open. 
    so if empty it will return pos 0, if 0th slot filled it returns pos 1
    if fully filled returns 5 CHECK FOR THIS 
    */
    public static int getTopPos(int postNum) { 
        int[] post = posts.get(postNum);
        int a = 0;
        for(int n : post) {
            if(n == 0) {
                return a;
            }
            a++;
        }
        return 5;
    }
    
    public static int getTopNum(int postNum) { //doesn't work if postNum == 0
        return posts.get(postNum)[getTopPos(postNum) - 1];
    }
    
    public static void print(ArrayList<int[]> list) {
     Iterator<int[]> itr = list.iterator();
         while(itr.hasNext()) {
             System.out.println(Arrays.toString(itr.next()));
         }
   }
}
