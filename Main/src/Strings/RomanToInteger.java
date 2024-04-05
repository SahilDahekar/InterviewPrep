package Strings;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))){
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static String intToRoman(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while(num > 0){
            if(num >= values[i]){
                sb.append(roman[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        // String roman = "LVIII";
        String roman = "MCMXCIV";
        int num = 58;
        System.out.println(romanToInt(roman));
        System.out.println(intToRoman(num));
    }
}
