public class _0059 {
    public static int[][] generateMatrix(int n) {
        //想法一：计算规律：第一排1到n
        //想法二：设置nxn数组
        //遍历到溢出就向右转
        int[][] matrix=new int[n][n];
        //int[][] flag=new int[n][n]{-1};
        
        //不去计算边界判定条件
        int index=0;
        int i=0;//第i行
        int j=-1;//第j行
        
        int k=n-1;
        //matrix[i][j]=index;
        while(index<n*n){
            //n=3:2,1
            //n=4:3,1
            //n=5:4,2,1
            //每次走k-1步，一圈走四次
           
            if(k==-1) break;
            if(k==0) {
                j+=1;
                index++;
                matrix[i][j]=index;
                break;
            }
            for(int ii=0;ii<k;ii++){
                index++;
                j+=1;
                matrix[i][j]=index;
            }
            //j+=1;//开始向下转
            j+=1;
            i-=1;
            for(int ii=0;ii<k;ii++){
                index++;
                i+=1;
                matrix[i][j]=index;
            }
            i+=1;
            j+=1;
            //向左转
            for(int ii=0;ii<k;ii++){
                index++;
                j-=1;
                matrix[i][j]=index;
            }
            j-=1;
            i+=1;
            //向上转
            for(int ii=0;ii<k;ii++){
                index++;
                i-=1;
                matrix[i][j]=index;
            }
            //i-=1;
            k-=2;
            
        }
        return matrix;
    }
    public static void main(String[] args) {
        
        int[][] nums3={{1,2},{0,1}};
        //[1,3],[2,6],[8,10],[15,18]
        int[][] nums={{1,3},{2,6},{8,10},{15,18}};
        int[][] result=generateMatrix(3);
        
        System.out.println(result);
    }
}
