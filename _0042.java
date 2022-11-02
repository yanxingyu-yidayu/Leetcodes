package Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 接雨水
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/9/29 23:49
 */
public class _0042 {
    public static int trap(int[] height) {
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            int left=i-1;
            int right=i+1;
            int l=i-1;
            int r=i+1;
//            if(height[left]<height[i]||height[right]<height[i])
//                continue;
            while (left>=0){
                if(height[left]>height[l]){
                    l=left;
                }
                left--;
            }
            while (right<height.length){
                if(height[right]>height[r]){
                    r=right;
                }
                right++;
            }
            if (l<0||r==height.length||height[l]<=height[i]||height[r]<=height[i]){
                continue;
            }
            sum+=Math.min(height[l],height[r])-height[i];
        }
        return sum;
    }
    public static int trap2(int[] height) {
        //动态规划
        //按列计算
        //遍历一次为每一列找到其左边最高峰
        int []maxLeft=new int[height.length];
        int []maxRight=new int[height.length];
        maxLeft[0]=0;
        maxRight[height.length-1]=0;
        int maxL=height[0];
        int maxR=height[height.length-1];
        int sum=0;
        for(int i=1;i< height.length;i++){
            //简便写法，它左边一个的maxleft跟它左边比较得出maxleft
            //max_left[i] = Math.max(max_left[i - 1], height[i - 1])
            maxL=Math.max(maxL,height[i-1]);
            maxLeft[i]=maxL;
        }
        for(int i= height.length-2;i>=0;i--){
            maxR=Math.max(maxR,height[i+1]);
            maxRight[i]=maxR;
        }
        for(int i=0;i< height.length;i++){
            int v=Math.min(maxLeft[i],maxRight[i]);
            if(v>height[i]){
                sum+=v-height[i];
            }

        }
//        System.out.println(Arrays.toString(height));
//        System.out.println(Arrays.toString(maxLeft));
//        System.out.println(Arrays.toString(maxRight));
        return sum;
    }
    public static int trap3(int[] height) {
        //双指针
        //左大和右大，按照遍历更新左大，当且仅当左大是较小值，即右边有比它高的
        //即计算每一列不需要全计算左大和右大，当右大明显更高时，左大就找max
        //反之当左大遍历到高值了，开始从右大遍历，
        //类似于选择（好像是？某个）排序的思想
        int sum=0;
        int maxLeft=0;
        int maxRight=0;
        int i=1;
        int left=1;
        int right= height.length-2;
        for(;i< height.length-1;i++){//每次加的是left或者right上的水
            //双指针指的是left和right，i只起到一个计数的作用
            if(height[left-1]<height[right+1]){
                maxLeft=Math.max(height[left-1],maxLeft);
                int min=maxLeft;
                if(min>height[left]){
                    sum+=min-height[left];
                }
                left++;
            }else {//现在已经左高右低
                maxRight=Math.max(height[right+1],maxRight);
                int min=maxRight;
                if(min>height[right]){
                    sum+=min-height[right];
                }
                right--;
            }
        }
        return sum;
    }
    //栈，类似于双指针，难以理解
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums1={4,2,0,3,2,5};
        int[] nums2={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(nums2));
       /* int[] strs={6,12,34,78,45,10,23};
        //int[] strs={9,90,2,80,3,70,6,50,7,40};
        System.out.println(yxy3(strs));*/
    }
}

