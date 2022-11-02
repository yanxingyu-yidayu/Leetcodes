package String;

/**
 * 字符串转换整数
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/8/10 10:37
 */
public class _0008 {
    public static int myAtoi(String s) {
        int len=s.length();
        if(len==0) return 0;
        int i=0;
        long sum=0;
        boolean flag=true;
        char c=s.charAt(i);
        while (c==' '){
            i++;
            if(i==len) return 0;
            c=s.charAt(i);
        }
        if(c=='-'){
            i++;
            if(i==len) return 0;
            c=s.charAt(i);
            if(c>'9'||c<'0') return 0;
            flag=false;
        }
        if(c=='+'){
            i++;
            if(i==len) return 0;
            c=s.charAt(i);
            if(c>'9'||c<'0') return 0;
        }
        while (c<='9'&&c>='0'){
            int n=c-'0';
            sum=sum*10+n;
            if(sum>Integer.MAX_VALUE) {
                if(flag) return Integer.MAX_VALUE;
                else return -1-Integer.MAX_VALUE;
            }

            i++;
            if(i==len) break;
            c=s.charAt(i);
        }
        if(flag) return (int)sum;
        else return (int)(0-sum);

    }
    public static void main(String[] args) {
        String s = "1233564457425345";
        System.out.println(myAtoi(s));
    }
}

