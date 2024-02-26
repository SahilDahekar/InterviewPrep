package Arrays;

public class isUnique{

    // public static boolean isUniqueString(String str){
    //     if(str.length() > 256){
    //         return false;
    //     }

    //     boolean[] char_set = new boolean[256];

    //     for(int i = 0; i < str.length(); i++){
    //         int val = str.charAt(i);
    //         if(char_set[val]){
    //             return false;
    //         }

    //         char_set[val] = true;
    //     }

    //     return true;
    // }

    public static boolean isUniqueString(String str){
        if(str.length() > 256){
            return false;
        }

        int checker = 0;

        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }

            checker |= (1 << val);
        }

        return true;

    }
    public static void main(String[] args) {
        System.out.println(isUniqueString("abcd"));;
    }
}