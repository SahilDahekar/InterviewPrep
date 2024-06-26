package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Hidden Patterns in Pascals Triangle : https://youtu.be/nFqeCXOJn0I?si=Q15QamYsSqOzm0dV

public class PascalsTriangle {

    // Key point to remember is how Hidden mathematical formulations can solve these type of problems easily.
    // In this case binomial coefficients help to solve the problem very easily.
    // For example : (a + b)^0 = 1                             [1]
    //               (a + b)^1 = a + b                         [1,1]
    //               (a + b)^2 = a^2 + 2ab + b^2               [1,2,1]
    //               (a + b)^3 = a^3 + 3ab^2 + 3a^2b + b^3     [1,3,3,1]

    // Optimized Approach
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){

            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int x = 1;
            for(int j = 1; j < i; j++){
                x = x * (i - j);
                x = x/j;
                temp.add(x);
            }
            res.add(temp);
        }

        return res;
    }
    public static void main(String[] args) {

        List<List<Integer>> res = generate(5);

        for(int i = 0; i < res.size(); i++){
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}
