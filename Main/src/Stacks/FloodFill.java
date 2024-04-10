package Stacks;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int org, int color){
        if(sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && image[sr][sc] == org){
            image[sr][sc] = color;

            fill(image, sr + 1, sc, org, color);
            fill(image, sr - 1, sc, org, color);
            fill(image, sr, sc + 1, org, color);
            fill(image, sr, sc - 1, org, color);
        }
    }

    public static void display(int[][] image){
        System.out.println();
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        
        int sr = 1;
        int sc = 1;
        int color = 2;
        
        System.out.println();
        System.out.println("Input image : ");
        display(image);

        floodFill(image, sr, sc, color);
        System.out.println("Output image : ");
        display(image);

    }
}
