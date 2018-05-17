package leetcode;

/**
 * Created by I321049 on 2018/5/17.
 */
public class atoi {
    public static void main(String args[]){
        atoi_Solution s = new atoi_Solution();
        s.myAtoi("0123456789");
        System.out.println();
        s.myAtoi("+-");
        System.out.println((char)48);
    }
}

class atoi_Solution{
    public int myAtoi(String str) {
       char []chars = str.toCharArray();
       for(int i = 0; i < chars.length; i++){
           System.out.print((int)chars[i]+" ");
       }
       return 1;
    }
}