package String;

/**
 * 最长子串
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/8/2 22:00
 */
public class _0003 {
    public static int lengthOfLongestSubstring(String s) {
        //思路一：滑动窗口
        if(s.length()==0) return 0;
        int left=0,right=0;
        int max=0;
        while(right<s.length()-1){
            right++;
            int loc=Check(s,left,right,s.charAt(right));
            if(loc!=-1){
                left=loc+1;
            }
            max=Math.max(right-left+1,max);
        }
        return max;
    }

    private static int Check(String s, int left, int right, char charAt) {
        for(int i=left;i<right;i++){
            if(s.charAt(i)==charAt) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

