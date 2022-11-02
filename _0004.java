package Array;

/**
 * Median of Two Sorted Arrays
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/7/20 16:07
 */
public class _0004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       /* //相当于先将两个数组排序
        int[] nums=new int[nums1.length+ nums2.length];
        int i=0,j=0,n=0;
        while(i< nums1.length&&j< nums2.length){
            if(nums1[i]<=nums2[j]){
                nums[n]=nums1[i];
                n++;i++;
            }
            else {
                nums[n]=nums2[j];
                n++;j++;
            }
        }
        if(i< nums1.length){
            for(;i< nums1.length;i++,n++) nums[n]=nums1[i];
        }else {
            for(;j< nums2.length;j++,n++) nums[n]=nums2[j];
        }
        if(n%2==0){
            return (double) (nums[n/2]+nums[n/2-1])/2;
        }else return (double) nums[n/2];*/
        int m= nums1.length,n= nums2.length;
        //int offset1=0,offset2=0;
        if((m+n)%2==1){//如果奇数（例如13），则要第(m+n+1)/2=7个
            return FindMid((m+n+1)/2,nums1,0,m-1,nums2,0,n-1);
        }else //偶数（14），要第7，8个。
            return (FindMid((m+n)/2,nums1,0,m-1,nums2,0,n-1)+
                    FindMid((m+n+2)/2,nums1,0,m-1,nums2,0,n-1))/2;
        //也可以奇数偶数合并
        /*
        return (FindMid((m+n+1)/2,nums1,0,m-1,nums2,0,n-1)+
                FindMid((m+n+2)/2,nums1,0,m-1,nums2,0,n-1))/2;
        */
    }

    private static double FindMid(int k, int[] nums1, int s1, int e1, int[] nums2, int s2, int e2) {
        //有一个数组全被排除掉，则其全是小数，直接返回另一个的“中位数”
        if(e1<=s1-1) return nums2[s2+k-1];
        if(e2<=s2-1) return nums1[s1+k-1];

        //如果k为1，不需要后面计算，直接返回两个头部最小值即可，
        // 因为前面已经排除掉k-1个
        if(k==1) return Math.min(nums1[s1],nums2[s2]);

        //比较两个数组的“当前中位数”
        int mid=k/2-1;
        int numMid1,numMid2;
        //其中一个数组不够长了，只能把mid设置为它长度那么长
        if(s1+mid>e1) mid=e1-s1;
        if(s2+mid>e2) mid=e2-s2;


        numMid1=nums1[s1+mid];
        numMid2=nums2[s2+mid];
        int tmp;
        tmp = mid + 1;
        k=k-tmp;
        if(numMid1<=numMid2){
            s1=s1+tmp;
        }else {
            s2=s2+tmp;
        }
        return FindMid(k, nums1, s1, e1, nums2, s2, e2);
    }

    public static void main(String[] args) {
        int[] nums1={2,4,6};
        int[] nums2={3,7};
        System.out.println(findMedianSortedArrays(nums1,nums2));
       /* int[] strs={6,12,34,78,45,10,23};
        //int[] strs={9,90,2,80,3,70,6,50,7,40};
        System.out.println(yxy3(strs));*/
    }
}

