package Array;

/**
 * 两数之和
 *
 * @author yxy
 * @version 2022/7/20 11:02
 */

/*
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。


示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]


提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int a=0,b= nums.length-1;
        int num1=nums[a],num2=nums[b];
        for(;a<nums.length;a++){
            num1=nums[a];
            int tmp=target-num1;
            for(b=nums.length-1;b>0;b--){
                if(b==a) continue;
                if(nums[b]==tmp) return new int[]{a,b};
            }
        }
        return new int[]{a,b};
    }
    public void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=twoSum(nums,target);

    }
}
/*复杂度分析

        时间复杂度：O(N^2)O(N
        2
        )，其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。

        空间复杂度：O(1)O(1)。

        作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*
* class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* 复杂度分析

时间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。对于每一个元素 x，我们可以 O(1)O(1) 地寻找 target - x。

空间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销。

* */



