package Array;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/7/27 11:05
 */
public class _0016 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clo=Integer.MAX_VALUE;
        int su=Integer.MAX_VALUE;
        for(int a=0;a< nums.length;a++){

            int b=a+1,c=nums.length-1;
            while (b<c){
                int sum=nums[a]+nums[b]+nums[c];
                int diff=sum>=target?sum-target:target-sum;
                if(diff==0) return target;
                if(sum>target){
                    c--;
                }else b++;
                if(diff<clo){
                    su=sum;
                    clo=diff;
                }
            }
        }
        return su;
    }
    public static void main(String[] args) {
        int[] nums={0,1,2};
        System.out.println(threeSumClosest(nums,3));
    }
}

