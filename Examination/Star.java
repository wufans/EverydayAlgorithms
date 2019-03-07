/**
 * @Author: WuFan
 * @Date: 2019/3/7 21:34
 */

package array;
//360笔试第二题：数星星
public class Star {
    public static void main(String[] args) {
            int m=3,n=5,k=2;
            int a[][] = new int[][]{{1,1,1,0,0,},{1,1,1,1,0},{0,1,1,0,0}};
            int temp[][] = new int[m][n];
            for (int i = 1; i < m-1; i++) {
                for (int j = 1; j < n-1; j++) {
                    if(a[i][j] == 1 && a[i-1][j] == 1 &&a[i+1][j] == 1 &&a[i][j-1] == 1 &&a[i][j+1] == 1){
                        temp[i][j] = 1;
                    }
                }
            }

            int res = 0;
            for (int i = 3; i <= m; i++) {
                for (int j = 3; j <=n ; j++) {
                    for (int l = 0; l <=m-i ; l++) {
                        for (int o = 0; o <= n-j; o++) {
                            int test = 0;
                            for (int p = l+ 1; p < l+i-1; p++) {
                                for (int q = o+1; q < o+j-1; q++) {
                                    if(temp[p][q] == 1) {
                                        test++;
                                    }

                                }
                            }
                            if(test>=k){
                                res++;
                                System.out.println(i+" "+j);
                                System.out.println(l+" "+o);

                            }
                            System.out.println();
                        }
                    }
                }
            }
            System.out.println(res);

        
    }
}
