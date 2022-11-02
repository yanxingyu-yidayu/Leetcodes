import java.util.ArrayList;
import java.util.List;

public class _0054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        //对于m行n列二维数组进行螺旋输出
        //起始四个点的左边（0，0）（0，n-1）（m-1,n-1）（m-1,0）
        //四个值:行顶值rt=0，列顶值ct=0，行底值rd=m-1,列底值cd=n-1
        //Column row top down
        //0,0~0,n-2
        //0,n-1~m-2,n-1
        //m-1,n-1~m-1,1
        //m-1,0~1,0
        //从外面包围了一圈，然后递归
        //直到最后，行顶==行底，列顶=列底，直接输出该元素，终止递归
        List<Integer> result=new ArrayList<>();
        recursion(result,matrix,0,0,matrix.length-1,matrix[0].length-1);
        return result;

    }
    private static void recursion(List<Integer> result,int[][] matrix, int rt, int ct, int rd, int cd) {
        //递归终止的条件就是剩下最后一个或者一行或者一列
        if(rt>rd||ct>cd) return;
        if(rt==rd){//只剩下一行
            for(int i=rt,j=ct;j<=cd;j++){
                result.add(matrix[i][j]);
            }
            return;
        }
        if(ct==cd){//只剩下一列
            for(int i=rt,j=ct;i<=rd;i++){
                result.add(matrix[i][j]);
            }
            return;
        }
        for(int i=rt,j=ct;j<cd;j++){
            result.add(matrix[i][j]);
        }
        for(int i=rt,j=cd;i<rd;i++){
            result.add(matrix[i][j]);
        }
        for(int i=rd,j=cd;j>ct;j--){
            result.add(matrix[i][j]);
        }
        for(int i=rd,j=ct;i>rt;i--){
            result.add(matrix[i][j]);
        }
        recursion(result, matrix, rt+1, ct+1, rd-1, cd-1);
    }
    public static void main(String[] args) {
        int[][] nums1={{7,8,9},{4,5,6},{1,2,3}};
        int[][] nums2={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12}};
        int[][] nums3={{1,2},{3,4}};
        List<Integer> result=spiralOrder(nums3);
        System.out.println(result);
    }
}
