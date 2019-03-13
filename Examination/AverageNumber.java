public class AverageNumber{
/*
=问题 
求N个整数的平均值（注意N可能很大，N个数直接相加会造成整数溢出）
=分析 
不能直接相加。那么可以每个数先除以N，再将N个数相加。但是由于计算机整数相除的会舍去小数部分，那么我们可以用一个变量保存余数，把每个数的余数都加到该变量上面，然后每次都用这个余数的和去除以N。

*/
int avg(int A[], int N)
  {
      int ans = 0, res = 0;
      for(int i=0; i<N; i++)
      {
          ans += A[i]/N; 
          res += A[i]%N; 
          ans += res/N;
          res = res%N;
      }
      return ans;
  }

}
