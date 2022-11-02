import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

class Solution {
    public static int maxSubArray(int[] nums) {
        //先找到临时尾部，从尾部往前遍历找到最后一个正数last
        //从第一个非负数为头开始遍历，一直加到自己为负时停止，
        //和为负说明这一段正数不值得要，丢弃，每次更新把最值及其坐标暂存
        //遍历知道找到下一个非负数，把它作为头继续遍历
        //直到遍历到last，这样可以得到初始值。
        int max=0;
        int maxStart=0,maxEnd=0;
        int last=nums.length-1;
        int start=0;
        int sum=0;
        for(;last>=0;last--){
            if(nums[last]>0)
            break;
        }
        
        for(;start<nums.length;start++){
            if(nums[start]>0)
            break;
        }
        if(start==last) return nums[last];
        if(last==-1&&start==nums.length){
            //数组无正数，只要找最大值
            max=nums[0];
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max){
                    max=nums[i];
                }
            }
            return max;
        }
        int i=start;
        while(i<=last){
            sum+=nums[i];
            if(sum<0){
                for(start=i+1;start<last;start++){
                    if(start>0)
                    break;
                }
                i=start;
                sum=0;
                continue;
            }
            if(sum>max){
                max=sum;
                maxStart=start;
                maxEnd=i;
            }
            i++;
        }
        // for(int i=start;i<nums.length;i++){
        //     sum+=nums[i];
        //     if(sum<0)
        // }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2={5,4,-1,7,8};
        int result=maxSubArray(nums2);
        System.out.println(result);
    }
}