package written_examination.xiaohuangshu;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    static int maxn = 16;
    static int n,m,r,c;
    static int [][] a = new int[maxn+5][maxn+5];
    static int [] b = new int[maxn+5];
    static int [][] f = new int[maxn+5][maxn+5];
    static int ans = 2000000000;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int i,k,j;
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        for(i=1; i <= n; i++){
            for(j= 1; j <=m;j++){
                a[i][j] = sc.nextInt();
            }
        }
        int s=0,e=0,x,t;
        for(i=0;i<r;i++)s=s|(1<<i);
        for(i=n-r;i<n;i++)e=e|(1<<i);
        while(s<=e)
        {
            work(s);
            x=(s&(-s));
            t=s+x;
            s=t|((s^t)/x)>>2;
        }
        System.out.println(ans);
    }
    public static void work(int s)
    {
        int i,j,k,x,p;
        for(b[0]=i=0;i<n;i++)
            if((s & (1<<i))>=0)
            {
                b[++b[0]]=i+1;
            }
        Arrays.fill(f,90);


        for(i=1;i<=m;i++)
            for(f[i][1]=0,j=2;j<=b[0];j++)
                f[i][1]+=Math.abs(a[b[j]][i]-a[b[j-1]][i]);

        for(j=2;j<=c;j++)
            for(i=j;i<=m;i++)
                for(k=j-1;k<i;k++)
                {
                    for(x=0,p=1;p<=b[0];p++)x+=Math.abs(a[b[p]][k]-a[b[p]][i]);
                    f[i][j]=Math.min(f[i][j],f[k][j-1]+f[i][1]+x);
                }
        for(i=c;i<=m;i++)ans=Math.min(ans,f[i][c]);
    }


}
