/*
ID: ronukra2
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*; 

class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new FileWriter("transform.out"));
        
        int N = Integer.parseInt(f.readLine());
        
        String[][] original = new String[N][N];
        for(int i = 0; i < N; i++) {
            String line = f.readLine();
            String[] lineA = new String[N];
            for(int j = 0; j < N; j++) {
               lineA[j] = String.valueOf(line.charAt(j));
            }
            original[i] = lineA;
        }
        
        String[][] transformed = new String[N][N];
        for(int i = 0; i < N; i++) {
            String line = f.readLine();
            String[] lineA = new String[N];
            for(int j = 0; j < N; j++) {
               lineA[j] = String.valueOf(line.charAt(j));
            }
            transformed[i] = lineA;
        }
        
        System.out.println(Arrays.deepToString(original));
        System.out.println(Arrays.deepToString(transformed));
        
        boolean[] transformations = new boolean[7];
        
        
        System.out.println(Arrays.deepEquals(original, transformed));
        //#1: 90 degree rotation
        String[][] transformedA = new String[N][N];
        
        
        int c = 0;
        while(!Arrays.deepEquals(transformed, transformedA) & c < 9) {
           int i = 0;
            for(String[] row : original) {
                int j = 0;
                for(String point : row) {
                    switch(c) {
                        case 0: transformedA[j][-i + N - 1] = point;
                                break; //System.out.printf("(%d, %d) -> (%d, %d)", j, -i, -i, -j)
                        case 1: transformedA[-i + N - 1][-j + N - 1] = point; System.out.println("test"); break;//(j, -i) => (-j, i)
                        case 2: //(j, -i) => (i, j); -(J - N + 1)
                            transformedA[-j + N - 1][i] = point; break;
                        case 3: 
                            //(x, y) => (-1 * (x - midline) + midline, y)
                            System.out.printf("i=%d  j=%d", i, j);
                            transformedA[i][-1 * j + N - 1] = point;
                            break;
                        case 4:
                            transformedA[-1 * j + N - 1][-i + N - 1] = point;
                            break;
                        case 5:
                            transformedA[-1 * i + N - 1][j] = point;
                            break;
                        case 6:
                            transformedA[j][i] = point; break;  
                        case 7: 
                            if(Arrays.deepEquals(original, transformed)) {
                                System.out.println("same");
                                out.println("6");
                                out.close();
                                return;
                            }
                        case 8:
                            out.println("7");
                            out.close();
                            return;
                    }
                    j++;
                }
            System.out.printf("\n");
            i++;
            } //inner (j) is x value, outer (i) is y value (negated)
        
           c++; 
        }
        System.out.println(Arrays.deepToString(transformedA));
        
        //cases #6 and #7 are already taken care of
        //c--;
        out.println(Integer.toString(c));
        out.close();
    }
    

}