public class _0055 {
    public static boolean canJump(int[] nums) {
        //贪心算法
        //每遍历一个就扩展可以到达的最大范围
        //知道到达最大范围
        //遇到数组尾部就停止
        int scope=nums[0];
        int i=0;
        int tmp=nums[0];//遍历一个元素后的可到达范围，跟scope比较
        while(i<nums.length-1&&i<scope){
            i++;
            if(i==nums.length-1){
                //到达末尾
                return true;
            }
            tmp=i+nums[i];
            if(tmp>=nums.length-1){
                return true;
            }
            scope=Math.max(tmp, scope);
        }
        if(scope>=nums.length-1){
            return true;
        }else return false;
    }
    public static void main(String[] args) {
        int[] nums1={2,3,1,1,4};
        int[] nums2={3,2,1,0,4};
        
        boolean result=canJump(nums2);
        System.out.println(result);
    }
}
