package String;

/**
 * 最长回文子串
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/8/3 15:19
 */
public class _0005 {
    public static String longestPalindrome(String s) {
        //左右双指针，
        //分单数和双数两种情况
        //单数就是找到一对间隔为一的相同字符
        //双数就是找到一对相邻的相同字符
        //从这一对字符向外拓展到最长
        //left不可重复，就可以不断前进直到len-2
        if(s.length()==1) return s;
        //if(s.length()==2) return s.substring(0,1);
        String pa=s.substring(0,1);
        int left=0,right=1;
        while(left<=s.length()-2&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                //先判定中心相邻
                String LPa=Extend(s,left,right);
                if(LPa.length()>pa.length()) pa=LPa;
                right++;
            }else {
                left++;
            }
        }
        return pa;
    }

    private static String Extend(String s, int left, int right) {
        while(s.charAt(left)==s.charAt(right)){
            if(left==0||right==s.length()-1) {
                return s.substring(left,right+1);
            }
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public static void main(String[] args) {
        String s = "aababa";
        System.out.println(longestPalindrome(s));
    }
}

