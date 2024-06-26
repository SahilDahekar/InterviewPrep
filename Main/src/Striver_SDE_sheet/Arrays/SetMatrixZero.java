package Arrays;

import java.util.Arrays;

public class SetMatrixZero{

    //Brute Force will create a new matrix and return it

    //Better Solution
    // public static void setZeroes(int[][] matrix) {

    //     int[] row = new int[matrix.length];
    //     int[] col = new int[matrix[0].length];

    //     for(int i = 0; i < matrix.length; i++){
    //         for(int j = 0; j < matrix[0].length; j++){
    //             if(matrix[i][j] == 0){
    //                 row[i] = -1;
    //                 col[j] = -1;
    //             }
    //         }
    //     }

    //     for(int i = 0; i < matrix.length; i++){
    //         for(int j = 0; j < matrix[0].length; j++){
    //             if(row[i] == -1 || col[j] == -1){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }


    //Optimized Solution 
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                       matrix[i][j] = 0; 
                    }
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0; i < m; i++){  
                matrix[0][i] = 0;
            }            
        }

        if(col0 == 0){
            for(int i = 0; i < n; i++){  
                matrix[i][0] = 0;
            }            
        }
    }

    public static void main(String[] args) {

        // Output: 
            // [0,0,0,0],
            // [0,4,5,0],
            // [0,3,1,0]

        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}