package Array;

/**
 * 另类二分法
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/8/2 14:05
 */
public class _0033 {
    public static int search(int[] nums, int target) {
        if(nums[0]==target) return 0;
        if(nums.length==1){
            return -1;
        }
        if(nums.length==2){
            if(nums[1]==target) return 1;
            else return -1;
        }

        int start=0,end= nums.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[start]){//前半截有序
                if(nums[mid]>target&&nums[start]<=target){
                    //target在前半截有序里面
                    end=mid-1;
                    continue;
                }
                else {//target在后半截无序的里面
                    start=mid+1;
                    continue;
                }
            }else {//后半截有序
                if(nums[mid]<target&&nums[end]>=target){
                    start=mid+1;
                    continue;
                }else {
                    end=mid-1;
                    continue;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={5,1,2,3,4};
        System.out.println(search(nums,1));
    }



    public int Dichotomy(int[] nums,int start,int end,int target){
        if(start==end) return start;
        int mid=(start+end)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]>target) return Dichotomy(nums,start,mid,target);
        else return Dichotomy(nums,mid,end,target);
    }
}

