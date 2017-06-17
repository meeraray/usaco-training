import java.io.*;
import java.util.*;

public class arraylist_test {
    public static void main(String[] args) {
        // ArrayList<int[]> list = new ArrayList<int[]>();
        // list.add(new int[]{2, 5});
        // list.add(new int[]{4, 7});
        // int[][] testArr = new int[][]{{1, 5}};
        // ArrayList<int[]> conv = new ArrayList<int[]>(Arrays.asList(testArr));
        // //ArrayList test = new ArrayList
        // list.addAll(conv);
        // Iterator<int[]> itr = list.iterator();
        // while(itr.hasNext()) {
        //     //int[] now = itr.next();
        //     System.out.println(Arrays.toString(itr.next()));
        // }
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{5, 6});
        list.add(new int[]{29, 15});
        list.add(new int[]{21, 9});
        Collections.sort(list, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
          return arr1[0] < arr2[0] ? -1 : 0;
      }
    });
    Iterator<int[]> itr = list.iterator();
        while(itr.hasNext()) {
            //int[] now = itr.next();
            System.out.println(Arrays.toString(itr.next()));
        }
        //System.out.println(list.size());
        System.out.println(32000 > 130);
    }
}