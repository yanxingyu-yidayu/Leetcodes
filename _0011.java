package Array;

/**
 * 数组灌水求最值
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/7/23 15:09
 */
public class _0011 {
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=(j-i)*Math.min(height[i],height[j]);
        if(height[i]<=height[j]){
            max=MoveR(max,height,i,j);
        }else
            max=MoveL(max,height,i,j);
        return max;
    }

    private static int MoveR(int max, int[] height, int i, int j) {
        if(i==j)
            return max;
        if(i+1==j)
            return Math.max(max,Math.min(height[j],height[i]));
        int n=i;
        while (n<j){
            n++;
            if(height[n]>height[i]){
                int vl=(n-i)*Math.min(height[n],height[i]);
                int vr=(j-n)*Math.min(height[j],height[n]);
                max=Math.max(vl,max);
                max=Math.max(vr,max);
                if (height[n]>height[j])
                    max=MoveL(max,height,n,j);
                else
                    max=MoveR(max,height,n,j);
                break;
            }
        }
        return max;
    }

    private static int MoveL(int max, int[] height, int i, int j) {
        if(i==j)
            return max;
        if(i+1==j)
            return Math.max(max,Math.min(height[j],height[i]));
        int n=j;
        while (n>i){
            n--;
            if(height[n]>height[j]){
                int vl=(n-i)*Math.min(height[n],height[i]);
                int vr=(j-n)*Math.min(height[j],height[n]);
                max=Math.max(vl,max);
                max=Math.max(vr,max);
                if (height[n]>height[i]) max=MoveR(max,height,i,n);
                else max=MoveL(max,height,i,n);
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}

