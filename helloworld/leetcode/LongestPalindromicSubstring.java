package leetcode;

/**
 * Created by I321049 on 2018/5/15.
 * Note: Next step is find more simple code.
 */

public class LongestPalindromicSubstring {
    public static void main(String[] arg){
        Solution_05 solution = new Solution_05();
        System.out.println(solution.longestPalindrome("12321"));
    }
}

class Solution_05 {
    public String longestPalindrome(String s) {
        String []chars = s.split("");
        String s2 = "";
        int maxRight = 0;
        int pos = 0;
        int MaxLen = 0;
        int sub_pos = 0;
        if(chars.length == 0){
            return "";
        }else if(chars.length == 1){
            return s;
        }else{
           s2 = "#" + String.join("#", chars) + "#";
           String []s2chars = s2.split("");
           int []RL = new int[s2chars.length];
           for(int i = 0; i < s2chars.length; i++){
               if(i < maxRight){
                   if(RL[2*pos - i] < maxRight - i){
                       RL[i] = RL[2*pos - i];
                   }else{
                       RL[i] = maxRight - i;
                   }

               }else{
                   RL[i] = 1;
               }

               while(i - RL[i] >= 0 && i + RL[i] < s2chars.length && s2chars[i-RL[i]].equals(s2chars[i+RL[i]])){
                   RL[i]+=1;
               }

               if (i + RL[i] - 1 > maxRight){
                   pos = i;
                   maxRight = i + RL[i] - 1;
               }
               if (RL[i] > MaxLen){
                   MaxLen = RL[i] - 1;
                   sub_pos = pos;
               }
           }
        }
        System.out.print(s2);
        String s2_sub = s2.substring(sub_pos-MaxLen,sub_pos+MaxLen);
        String []s2_chars_new = s2_sub.split("#");
        String result = String.join("", s2_chars_new);
        return result;
    }
}