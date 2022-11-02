package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 输入：nums = [1]
 * 输出：[[1]]
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/10/7 17:07
 */
public class _0046 {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length== 1){
            List<Integer> alist = new ArrayList<>();
            alist.add(nums[0]);
            List<List<Integer>> allList=new ArrayList<>();
            allList.add(alist);
            return allList;
        }
        List<List<Integer>> allList=new ArrayList<>();
        allList=Recursion(nums,0);
        return allList;
    }

    private static List<List<Integer>> Recursion(int[] nums, int index) {
        if(index== nums.length-1){
            List<Integer> alist = new ArrayList<>();
            alist.add(nums[index]);
            List<List<Integer>> allList=new ArrayList<>();
            allList.add(alist);
            return allList;
        }
        List<List<Integer>> tmpList=Recursion(nums,index+1);
        List<List<Integer>> allList=new ArrayList<>();
        int num=nums[index];
        int size=tmpList.size();
        for(int i=0;i<size;i++){
            List<Integer> alist=tmpList.get(i);
            //tmpList.remove(alist);
            int len=alist.size();
            for(int j=0;j<=len;j++){
                List<Integer> bList=new ArrayList<>(alist);
                bList.add(j,num);
                allList.add(bList);
            }
        }
        tmpList.clear();
        return allList;
    }

    public static void main(String[] args) {
        int[] nums1={2,3,1,1,4};
        int[] nums2={1,2,3};
        System.out.println(permute(nums2));
        List<List<Integer>> allList=permute(nums2);
        for (List<Integer> list:allList
             ) {
            for (Integer i:list
                 ) {
                System.out.print(i+" ");
            }
            System.out.println(" ");
        }
       /* int[] strs={6,12,34,78,45,10,23};
        //int[] strs={9,90,2,80,3,70,6,50,7,40};
        System.out.println(yxy3(strs));*/
    }
}

