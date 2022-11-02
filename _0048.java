package Array;

import java.util.List;

/**
 * 旋转图像
 *
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/10/20 21:14
 */
public class _0048 {
    //经过人提醒才发现可以转置再镜像
    public static void rotate(int[][] matrix) {
        int n= matrix.length;
        System.out.println(n);
        int tmp;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(matrix[i][j]);
//
//            }
//            System.out.println(" ");
//        }
        //转置后再进行镜像翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=tmp;
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(matrix[i][j]);
//
//            }
//            System.out.println(" ");
//        }
    }
    public static void main(String[] args) {
        int[] nums1={2,3,1,1,4};
        int[][] nums2={{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums2);
    }
}

