package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/11/21 15:43
 */
public class _0057 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //想法一，新元素插入，按照56题的重新来一遍就好
        //想法二，找到合适的地方修改
        List<int[]> list=new ArrayList<int[]>();
        if(intervals.length==0){
            list.add(newInterval);
            return list.toArray(new int[1][]);
        }
        int l=newInterval[0];
        int r=newInterval[1];

        //因为原来的区间没有重叠
        //遍历有序数组找到新区间落在第几个起点后
        //起点(1)要么落在第i个区间里面，此时需要判断修改第i个区间
        //(2)落在第i个区间后面，此时需要
        int index=-1;
        if(l<intervals[0][0]){
            list.add(0,newInterval);
        }
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            list.add(intervals[i]);
            if(intervals[i-1][0]<=l&&intervals[i][0]>l){
                list.add(i,newInterval);
                continue;
            }
        }
        if(intervals[intervals.length-1][0]<=l){
            list.add(newInterval);
        }
        List<int[]> result=new ArrayList<int[]>();
        for(int i=0;i< list.size();i++){
            int s=list.get(i)[0];
            int e=list.get(i)[1];
            //新建元素有且仅有插在数组最后：数组为空or靠后区间
            if(result.size()==0||s>result.get(result.size()-1)[1]){
                result.add(new int[]{s,e});
            }else {
                //根据最后一个区间判断是否延长
                int last=result.get(result.size()-1)[1];
                if(e>last){
                    result.get(result.size()-1)[1]=e;
                }

            }
        }
        //!!!list转数组!!!
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[] nums1={3,7};
        int[][] nums2={{3,5}};
        //groupAnagrams(nums2);
        int[][] result=insert(nums2,nums1);
        for(int i=0;i< result.length;i++){
            System.out.println(result[i][0]+","+result[i][1]);
        }
    }
}

