import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            sb.append(".");
        }

        for(int i = 0; i < n; i++){
            board.add(sb.toString());
        }

        int[] left = new int[n];
        int[] upperD = new int[(2*n - 1)];
        int[] lowerD = new int[(2*n - 1)];

        solve(0, n, left, upperD, lowerD, board, ans);
        return ans;
    }

    public static void solve(int col, int n, int[] left, int[] upperD, int[] lowerD, List<String> board, List<List<String>> ans){
        if(col == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row < n; row++){
            if(left[row] == 0 && upperD[n-1 + col - row] == 0 && lowerD[row + col] == 0){
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col,'Q');
                board.set(row, newRow.toString());
                left[row] = 1;
                upperD[n-1 + col - row] = 1;
                lowerD[row + col] = 1;
                solve(col + 1, n, left, upperD, lowerD, board, ans);
                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
                left[row] = 0;
                upperD[n-1 + col - row] = 0;
                lowerD[row + col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        for (List<String> list : ans) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
