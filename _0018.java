package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/7/27 12:47
 */
/*给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
请你找出并返回满足下述全部条件且不重复的四元组
[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d< n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

示例 1：
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/
public class _0018 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //四个数可以一样，下标不能一样
        Arrays.sort(nums);
        List<List<Integer>> fElems=new ArrayList<>();
        if(nums.length<4) return fElems;
        for(int a=0;a< nums.length-3;a++){
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if ((long) nums[a] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for(int d= nums.length-1;d>2;d--){
                if (d < nums.length-2 && nums[d] == nums[d + 1]) {
                    continue;
                }
                if ((long) nums[a] + nums[d] + nums[d - 1] + nums[d - 2] < target) {
                    break;
                }
                /*if ((long) nums[a] + nums[a+3] + nums[a + 2] + nums[a + 1] > target) {
                    continue;
                }*/

                int b=a+1,c=d-1;
                while (b<c){
                    int sum=nums[a]+nums[b]+nums[c]+nums[d];
                    int abc=sum-nums[a]-nums[b]-nums[c];
                    if(abc!=nums[d]){
                        c--;
                        continue;
                    }
                    if(sum==target){
                        List<Integer> elem=new ArrayList<>();
                        elem.add(nums[a]);
                        elem.add(nums[b]);
                        elem.add(nums[c]);
                        elem.add(nums[d]);
                        if(!fElems.contains(elem)){
                            fElems.add(elem);
                        }
                        while(b<c&&nums[b]==nums[b+1]){
                            b++;
                        }
                        b++;
                        while (c>b&&nums[c]==nums[c-1]){
                            c--;
                        }
                        c--;
                    }else if (sum>target){
                        c--;
                    }else b++;
                }
            }
        }
        return fElems;
    }
    public static void main(String[] args) {
//        int[] nums={1,0,-1,0,-2,2};
//        System.out.println(fourSum(nums,0));
//
//        int[] nums={1000000000,1000000000,1000000000,1000000000};
//        System.out.println(fourSum(nums,-294967296));

        int[] nums={2,2,2,2,2};
        System.out.println(fourSum(nums,8));

    }
}

