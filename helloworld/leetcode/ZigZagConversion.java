package leetcode;

/**
 * Created by I321049 on 2018/5/16.
 */
public class ZigZagConversion {
    public static void main(String args[]){
        Zig_Zag_Solution solution = new Zig_Zag_Solution();
        solution.convert("AD", 1);
    }
}
class Zig_Zag_Solution {
    public String convert(String s, int numRows) {
        String []s_string = s.split("");
        String result = "";
        if(numRows == 1){
            return s;
        }else if (numRows == 2){
            String result_1 = "";
            String result_2 = "";
            for(int id_2 = 0; id_2 < s_string.length; id_2 ++){
                if(id_2%2 == 0){
                    result_1 += s_string[id_2];
                }else {
                    result_2 += s_string[id_2];
                }
            }
            result = result_1 + result_2;
            return result;
        }
        int col = numRows;
        int column_id = 0;
        int id = 0;
        int row = (s.length()/(2*col-2))*(col-1) + (s.length()%(2*col - 2))/col + (s.length()%(2*col-2))%col;
        String[] res[] = new String[row][col];

        for(int i = 0; i < row; i ++){
            if(i%(col-1) == 0 ){
                for(int j = 0; j < col; j++){
                    if(id < s_string.length){
                        res[i][j] = s_string[id++];
                    }
                }
            }else if(id < s.length()){
                column_id = col - i%(col - 1) - 1;
                res[i][column_id] = s_string[id++];
            }
        }
        for(int r = 0; r < col; r++){
            for(int c = 0; c < row; c++){
                if (res[c][r] != null){
                    result = result + res[c][r];
                }
            }
        }
        return result;
    }
}
