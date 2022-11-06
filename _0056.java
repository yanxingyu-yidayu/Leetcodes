import java.util.ArrayList;
import java.util.LinkedList;

public class _0056 {
    public static int[][] merge(int[][] intervals) {
        /**
         * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
         * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
**/     
        //想法一：直接暴力解法，每遍历一个数组，查看之前的，如果重合就替换。
        //n个数组最多合并后就只有n个，最少1个
        //遍历到i就遍历0到i个数组，时间复杂度o（n!）
        //想法二：插入排序，放入新数组
        //如果当前的尾部小于新数组的头，放在数组头
        //否则遍历顺序数组找到合适位置
        //合适的位置就是判定
        /*
        LinkedList<int[]> result=new LinkedList<>();
        int index=-1;
        int head,tail;
        //Integer[] arrs=result.toArray(new Integer[result.size()]);
        //int[][] result=new int[intervals.length][2];
        //result[0]=intervals[0];
        result.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            head=intervals[i][0];
            tail=intervals[i][1];
            if(tail<result.get(0)[0]){
                //不行，int[][]位置固定
                //还是得用linkedlist,最后将结果转换
                //将其插入数组头
                result.add(0, intervals[i]);
            }
            if(head>result.get(result.size()-1)[1]){
                //比最后一个尾巴还大，放在最后
                result.add(intervals[i]);
            }
            for(index=0;index<result.size();index++){
                //在中间只有三种情况
                //（1）在两个元素中间但是不覆盖
                //（2）在两个元素中间但是将两个元素连接
                //（3）在延长前一个元素，即头在一个元素里，尾巴超出
                //（4）头超出，尾巴在一个元素里
                //太麻烦了放弃
            }

        } */
        //想法二
        //新建一个一维数组，将间断点放进去
        //再设置一个标记数组，标识这个间断点是开始还是结尾
        //每加入一个数组，将头尾放好，将中间的间断点删除
        ArrayList<Integer> points=new ArrayList<>();
        ArrayList<Integer> flag=new ArrayList<>();
        points.add(intervals[0][0]);
        flag.add(-1);
        points.add(intervals[0][1]);
        flag.add(1);
        for(int i=1;i<intervals.length;i++){
            //新区间的头和尾
            int head=intervals[i][0];
            int tail=intervals[i][1];
            
            //新区间在坐标上的位置，原来该位置的元素比他大
            //此时只是位置但是还没有插入
            int start=getIndex(points, head);
            
            int end=getIndex(points, tail);
            //start==end,说明是新区间
            //先插尾巴，再插头
            if(start==end){
                points.add(end, tail);
                flag.add(end,1);
                points.add(start, head);
                flag.add(start, -1);
                continue;
            }
            
            //start和end中间相差一说明只部分覆盖一个区间
            //相差多个，说明包含了-1，1，-1，1，这样把中间的全部去掉
            //中间包含1，-1，1，说明start不要插入，把尾部插入，中间的去掉
            //中间包含1，-1，1，-1，说明start和end都不要插入，并且去掉中间的
            //中间包含-1，1，-1，只插入start,不插入end,中间的去掉
            if(flag.get(start)==1){
                if(flag.get(end-1)==1){
                    points.add(end, tail);
                    flag.add(end, 1);
                }
                while(start<end){
                    points.remove(start);
                    flag.remove(start);
                    end--;
                }
                continue;
            }
            if(flag.get(start)==-1){
                if(flag.get(end-1)==1){
                    points.add(end, tail);
                    flag.add(end, 1);
                }
                points.add(start, head);
                flag.add(start, -1);
                start++;
                while(start<=end){
                    points.remove(start);
                    flag.remove(start);
                    end--;
                }
                continue;
            }
        }
        // 将结果转化为Int[][]
        int[][] result=new int[points.size()/2][2];
        for(int i=0;i<points.size()/2;i++){
            result[i][0]=points.get(2*i);
            result[i][1]=points.get(2*i+1);
        }
        return result;
    }

    private static int getIndex(ArrayList<Integer> points, int ele) {
        if(points.get(0)>ele) return 0;
        if(points.get(points.size()-1)<ele) return points.size();
        for(int i=1;i<points.size();i++){
            if(points.get(i)>=ele&&points.get(i-1)<ele){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
        int[][] nums3={{1,2},{2,4}};
        //[1,3],[2,6],[8,10],[15,18]
        int[][] nums={{1,3},{2,6},{8,10},{15,18}};
        int[][] result=merge(nums);
        
        System.out.println(result);
    }
}
