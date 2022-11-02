package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2
 * 数组里有重复数字
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/10/14 9:10
 */
public class _0047 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> alist = new ArrayList<>();
        List<List<Integer>> allList=new ArrayList<>();
        int[] visited =new int[nums.length];
        Arrays.fill(visited,0);
        if(nums.length== 1){
            alist.add(nums[0]);
            allList.add(alist);
            return allList;
        }
        Arrays.sort(nums);
        Recursion(nums,visited,0,allList,alist);
        return allList;
    }

    private static void Recursion(int[] nums, int[] visited, int index, List<List<Integer>> allList, List<Integer> alist) {
        //alist已经填满，加入大数组
        if(index== nums.length){
            allList.add(new ArrayList<Integer>(alist));
            return;
        }
        for(int i=0;i< nums.length;++i){
            //对于每一个小的alist（未满）,都要遍历数组，按顺序找到数字填入
            //已经使用过的就不需要填入了
            //跟上一个数字一样但是未使用的，再用会导致重复，因为此时前1使用而后1未使用
            //若使用到后1，此时前1一定已经回溯为未使用，跟上面重复
            if(visited[i]==1||(i>0&&nums[i]==nums[i-1]&&nums[i-1]==0)){
                continue;
            }
            alist.add(nums[i]);
            visited[i]=1;
            Recursion(nums,visited,index+1,allList,alist);
            visited[i]=0;
            //alist.remove(nums[i]);
            alist.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] nums1={2,3,1,1,4};
        int[] nums2={1,1,3};
        System.out.println(permuteUnique(nums2));
        _0047 so = new _0047();
        so.permuteUnique(nums2);
        List<List<Integer>> allList=permuteUnique(nums2);
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

