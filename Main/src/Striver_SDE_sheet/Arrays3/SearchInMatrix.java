package Arrays3;

public class SearchInMatrix{

    public static boolean binarySearch(int[][] matrix, int row , int cStart, int cEnd, int target){
        
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart)/2;
            if(matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid] < target){
                cStart = mid + 1;
            } else{
                cEnd = mid - 1;
            }
        }

        return false;
    }

    // O(log n) + O(log m) Solution
    // public static boolean searchMatrix(int[][] matrix, int target) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     if(target < matrix[0][0] || target > matrix[n - 1][m - 1]){
    //         return false;
    //     }

    //     if(n == 1){
    //         return binarySearch(matrix, 0, 0, m - 1, target);
    //     }

    //     int rStart = 0;
    //     int rEnd = n - 1;
    //     int cMid = m/2;

    //     while(rStart < (rEnd - 1)){
    //         int mid = rStart + (rEnd - rStart)/2;
    //         if(matrix[mid][cMid] == target){
    //             return true;
    //         } else if (matrix[mid][cMid] < target){
    //             rStart = mid;
    //         } else {
    //             rEnd = mid;
    //         }
    //     }

    //     if(matrix[rStart][cMid] == target){
    //         return true;
    //     }

    //     if(matrix[rEnd][cMid] == target){
    //         return true;
    //     }

    //     if(target <= matrix[rStart][cMid - 1]){
    //         return binarySearch(matrix, rStart, 0, cMid - 1, target);
    //     }

    //     if(target >= matrix[rStart][cMid + 1]){
    //         return binarySearch(matrix, rStart, cMid + 1, m - 1, target);
    //     }

    //     if(target <= matrix[rStart + 1][cMid - 1]){
    //         return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
    //     } else {
    //         return binarySearch(matrix, rStart + 1, cMid + 1, m - 1, target);
    //     }
    // }
        
    // O(n^2) Solution
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}