package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * 找数组中和为0的三元组
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/7/23 16:04
 */
public class _0015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        //排序
        sort(nums);
        List<List<Integer>> threeElem=new ArrayList<>();
        int min=0,max=nums.length-1,mid;
        if(nums[min]>0||nums[max]<0){

            return threeElem;
        }
        if(nums[min]==0&&nums[min+2]>0){
            return threeElem;
        }
        if(nums[max]==0&&nums[max-2]<0){
            return threeElem;
        }
        //一个负数
        int lastI=max;
        for(int i=0;nums[i]<0;i++){
            if(nums[i]==nums[lastI]) {
                lastI=i;
                continue;
            }

            if(nums[max]*2+nums[i]<0) continue;
            int lastJ=min;
            for (int j=max;;j--){
                if(nums[j]==nums[lastJ]) {
                    lastJ=j;
                    continue;
                }
                if(nums[j]*2+nums[i]<0) break;

                int lastN=min;
                for(int n=j-1;nums[n]>=0;n--){
                    if(nums[n]==nums[lastN]) {
                        lastN=n;
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[n]==0){
                        List<Integer> elem=new ArrayList<>();
                        elem.add(nums[i]);
                        elem.add(nums[n]);
                        elem.add(nums[j]);
                        threeElem.add(elem);
                    }
                    lastN=n;
                }
                lastJ=j;
            }
            lastI=i;
        }
        //两个负数
        lastI=min;
        for(int i=max;nums[i]>0;i--){
            if(nums[i]==nums[lastI]){
                lastI=i;
                continue;
            }
            if(nums[min]*2+nums[i]>0) continue;
            int lastJ=max;
            for (int j=min;;j++){
                if(nums[j]==nums[lastJ]) {
                    lastJ=j;
                    continue;
                }
                if(nums[j]*2+nums[i]>0) break;
                int lastN=max;
                for(int n=j+1;nums[n]<0;n++){
                    if(nums[n]==nums[lastN]) {
                        lastN=n;
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[n]==0){
                        List<Integer> elem=new ArrayList<>();
                        elem.add(nums[j]);
                        elem.add(nums[n]);
                        elem.add(nums[i]);
                        threeElem.add(elem);
                    }
                    lastN=n;
                }
                lastJ=j;
            }
            lastI=i;
        }


        //三个0
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&i<nums.length-2) {
                if (nums[i + 1] == 0 && nums[i + 2] == 0) {
                    List<Integer> elem = new ArrayList<>();
                    elem.add(0);
                    elem.add(0);
                    elem.add(0);
                    threeElem.add(elem);
                    break;
                }
            }
        }

        return threeElem;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> threeElem=new ArrayList<>();
        int min=0,max=nums.length-1,mid;
        if(nums[min]>0||nums[max]<0){

            return threeElem;
        }
        if(nums[min]==0&&nums[min+2]>0){
            return threeElem;
        }
        if(nums[max]==0&&nums[max-2]<0){
            return threeElem;
        }


        for(int i=0;i+2<=max;i++){
            if(nums[i]==nums[i-1]&&i>0) {
                continue;
            }
            if(nums[max]*2+nums[i]<0) continue;


            for (int j=max;j-2>=0;j--){
                if(nums[j]==nums[j+1]&&j<max) {
                    continue;
                }


                for(int n=j-1;n>i;n--){
                    if(nums[n]==nums[n+1]&&n<j-1) {
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[n]==0){
                        List<Integer> elem=new ArrayList<>();
                        elem.add(nums[i]);
                        elem.add(nums[n]);
                        elem.add(nums[j]);
                        threeElem.add(elem);
                    }

                }

            }

        }

        //三个0
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&i<nums.length-2) {
                if (nums[i + 1] == 0 && nums[i + 2] == 0) {
                    List<Integer> elem = new ArrayList<>();
                    elem.add(0);
                    elem.add(0);
                    elem.add(0);
                    if(!threeElem.contains(elem))  threeElem.add(elem);
                    break;
                }
            }
        }

        return threeElem;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        //排序
        Arrays.sort(nums);
        List<List<Integer>> threeElem=new ArrayList<>();
        int min=0,max=nums.length-1,mid;
        if(nums[min]>0||nums[max]<0){

            return threeElem;
        }
        if(nums[min]==0&&nums[min+2]>0){
            return threeElem;
        }
        if(nums[max]==0&&nums[max-2]<0){
            return threeElem;
        }


        for(int i=0;i+2<=max;i++){
            if(i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            if(nums[max]*2+nums[i]<0) continue;
            if(nums[i]>0) break;


            int j=max,m=i+1;
            while (j-2>=i&&m<j){
                if(j<max&&nums[j]==nums[j+1]){
                    j--;
                    continue;
                }

                if(nums[i]+nums[j]+nums[m]==0){
                    List<Integer> elem = new ArrayList<>();
                    elem.add(nums[i]);
                    elem.add(nums[m]);
                    elem.add(nums[j]);
                    threeElem.add(elem);
                    m++;
                    j--;
                }else if(nums[i]+nums[j]+nums[m]>0){
                    j--;
                    continue;
                }else {
                    m++;
                }
            }

        }



        return threeElem;
    }

    public static void main(String[] args) {
        int[] nums={0,0,0};
        System.out.println(threeSum2(nums));
    }
}

