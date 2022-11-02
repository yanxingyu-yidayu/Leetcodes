package Array;

/**
 * 跳跃游戏2
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/10/7 9:19
 */
public class _0045 {
    public static int jump(int[] nums) {
        if(nums.length==1) return 0;
        int count=1;
        int cover=nums[0];
        int tar=cover;
        if(cover>= nums.length-1){
            return count;
        }
        int i=0;
        while (cover< nums.length-1){
            count++;
            for(;i<=cover;i++){
                if (nums[i]+i>tar)
                    tar=nums[i]+i;
            }
            cover=tar;
//            这样会出现动态更新上界的问题导致死循环或者循环溢出
//            for(;i<=cover;i++){
//                if (nums[i]+i>cover)
//                    cover=nums[i]+i;
//            }
            if(cover== nums.length-2){
                return count+1;
            }
            if(cover>= nums.length-1){
                return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1={2,3,1,1,4};
        int[] nums2={1,2,3};
        System.out.println(jump(nums2));
       /* int[] strs={6,12,34,78,45,10,23};
        //int[] strs={9,90,2,80,3,70,6,50,7,40};
        System.out.println(yxy3(strs));*/
    }
}

