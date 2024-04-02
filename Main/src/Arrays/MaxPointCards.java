package Arrays;

public class MaxPointCards{
    public static int maxSumFromCards(int[] cards, int k){
        int lsum = 0;
        int rsum = 0;
        int maxsum = 0;

        for(int i = 0; i < k; i++){
            lsum += cards[i];
        }

        maxsum = lsum;
        int ridx = cards.length - 1;

        for(int i = k - 1; i >= 0; i--){
            lsum -= cards[i];
            rsum += cards[ridx];
            ridx--;
            maxsum = Math.max(maxsum, lsum + rsum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int[] cards = new int[]{6,2,3,4,7,2,1,7,1};
        System.out.println("Maximum Sum : " + maxSumFromCards(cards, 4));
    }
}