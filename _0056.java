package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/11/21 11:02
 */
public class _0056 {
    public static int[][] merge(int[][] intervals) {
        //如果数组为空，返回空
        if(intervals.length==0)
            return new int[0][2];
        //将数组按照起始点排序，则可以合并的区间一定连续
        Arrays.sort(intervals, new Comparator<int[]>() {
            //前一个参数为列表，后一个<>里为元素
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //将区间存入List，方便增删改
        List<int[]> result=new ArrayList<int[]>();
        //现在Intervals是有序的,这样新加入的区间，
        // 要么只会在数组最后加入（起点很靠后）
        //要么就只会延长数组最后一个区间，甚至不延长，缩在某个区间里面
        // （因为起始点有序，不存在向前延长某个区间）
        //(也不会存在连接数组中两个区间，因为之前的起始点都在它前面，新起点只会在所有起点后面)
        for(int i=0;i< intervals.length;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];
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
        int[] nums1={2,3,1,1,4};
        int[][] nums2={{1,2},{2,5},{7,8}};
        //groupAnagrams(nums2);
        int[][] result=merge(nums2);
        for(int i=0;i< result.length;i++){
            System.out.println(result[i][0]+","+result[i][1]);
        }
    }
}

