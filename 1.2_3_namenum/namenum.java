/*
NAME: ronukra2
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;

class namenum  {
    

     
    public static void main(String[] args) throws IOException {
        
        String[][] letters = new String[][]{
        new String[] {},
        new String[] {}, //first three are empty, numbering starts at 2 for conveniences's sake
        new String[] {"A", "B", "C"}, 
        new String[] {"D", "E", "F"}, 
        new String[] {"G", "H", "I"}, 
        new String[] {"J", "K", "L"}, 
        new String[] {"M", "N", "O"}, 
        new String[] {"P", "R", "S"}, 
        new String[] {"T", "U", "V"}, 
        new String[] {"W", "Y", "Z"}
        };
        
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String serial = f.readLine();
        int length = serial.length();
        
        
        //generate base list
        ArrayList<String[]> combs = new ArrayList<String[]>();
        for(int i = 0; i < length; i++) {
            combs.add(letters[Character.getNumericValue(serial.charAt(i))]);
        }
        String[] first = combs.get(0);
        int firstInd = Character.getNumericValue(serial.charAt(0));
      
        //print(combs);
        
        //create list of possible names
        while(combs.size() != 1) {
            String[] one = combs.get(0);             
            String[] two = combs.get(1); 
            String[] newA = new String[one.length * two.length];
            int j = 0;
            for(String oneS : one) {
                for(String twoS : two) {
                    newA[j] = oneS + twoS;
                    j++;
                }
            } 
            combs.remove(0);
            combs.remove(0);
            combs.add(0, newA);
        }
        
        //print(combs);
        
        String[] realCombs = combs.get(0);
        
        // for(String a : realCombs) {
        //     //System.out.println(a);
        // }
        String name = dict.readLine();
        //int j = 0;
        
        
        //check if names are real, output them
        boolean none = true;
        while(name != null) {
            if(firstInd != 9 && name.charAt(0) == letters[firstInd + 1][0].charAt(0)) {
                break;
            }
            if(name == null) {
                break;
            }
            //System.out.println(name);
            if(name.charAt(0) == first[0].charAt(0) || name.charAt(0) == first[1].charAt(0) || name.charAt(0) == first[2].charAt(0)) {
                //System.out.println(name);
                for(String realComb : realCombs) {
                    //System.out.println(realComb);
                    //System.out.println(name);
                    if(realComb.equals(name)) {
                        none = false;
                        out.println(realComb);
                    }
                }
            }
            name = dict.readLine();
        }
        if(none) {
            out.println("NONE");
        }
        out.close();
        //print(rcombs);
    }
    
//     public static void print(ArrayList<String[]> list) {
//      Iterator<String[]> itr = list.iterator();
//          while(itr.hasNext()) {
//              //int[] now = itr.next();
//              System.out.println(Arrays.toString(itr.next()));
//          }
//   }
   
}