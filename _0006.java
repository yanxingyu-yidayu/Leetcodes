package String;

import java.util.LinkedList;

/**
 * Z型变换
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/8/3 15:53
 */
public class _0006 {
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }

        StringBuilder news= new StringBuilder();
        //LinkedList<Character> list=new LinkedList<>();

        int len=s.length();
        int n=(numRows-1)*2;
        int times=len/(numRows*2-1);
        int remainder=len%(numRows*2-1);

        for(int i=0;i<numRows;i++){
            int j=i;
            while(j<len){

                //list.add(s.charAt(j));
                news.append(s.charAt(j));
                if(i==0||i==numRows-1){
                    j=j+n;
                }else {
                    j=j+n-i-i;
                    if(j>=len) break;
                    news.append(s.charAt(j));
                    j=j+i+i;
                }
                if(j>=len) break;
            }
        }

        return news.toString();

    }
    public static void main(String[] args) {
        String s = "A";
        System.out.println(convert(s,1));
    }
}

