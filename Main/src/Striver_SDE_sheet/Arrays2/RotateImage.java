package Arrays2;

import java.util.Arrays;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int bottom = n - 1;

        while(top < bottom){
            for(int i = 0; i < n; i++){
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        for(int r = 0; r < n; r++){
            for(int c = r + 1; c < n; c++){  
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] mat : matrix) {
            System.out.println(Arrays.toString(mat));
        }
    }
}
