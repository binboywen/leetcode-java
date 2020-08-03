package jianzhiOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数
 * 让小朋友们围成一个大圈。
 * 然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，
 * 然后可以在礼品箱中任意的挑选礼物，
 * 并且不再回到圈中，从他的下一个小朋友开始，
 * 继续 0...m-1 报数 .... 这样下去 ....
 * 直到剩下最后一个小朋友，可以不用表演。
 */
public class _62_圆圈中最后剩下的数字 {
    /**
     * 约瑟夫环，圆圈长度为 n 的解可以看成长度为
     * n-1 的解再加上报数的长度 m。
     * 因为是圆圈，所以最后需要对 n 取余。
     *
     *
     * 递推公式：
     * 把n个人的编号改为0~n-1，然后对删除的过程进行分析。
     * 第一个删除的数字是(m-1)%n，记为k，则剩余的编号为(0,1,...,k-1,k+1,...,n-1)，下次开始删除时，
     * 顺序为(k+1,...,n-1,0,1,...k-1)。
     * 用f(n,m)表示从(0~n-1)开始删除后的最终结果。
     * 用q(n-1,m)表示从(k+1,...,n-1,0,1,...k-1)开始删除后的最终结果。
     * 则f(n,m)=q(n-1,m)。
     *
     * 下面把(k+1,...,n-1,0,1,...k-1)转换为(0~n-2)的形式，即
     * k+1对应0
     * k+2对于1
     * ...
     * k-1对应n-2
     * 转化函数设为p(x)=(x-k-1)%n, p(x)的逆函数为p^(x)=(x+k+1)%n。
     * 则f(n,m)=q(n-1,m)=p^(f(n-1,m))=(f(n-1,m)+k+1)%n，又因为k=(m-1)%n。
     * f(n,m)=(f(n-1,m)+m)%n;
     *
     * 最终的递推关系式为
     * f(1,m) = 0;             （n=1)
     * f(n,m)=(f(n-1,m)+m)%n; （n>1）
     */

    public static int LastRemaining(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining(n - 1, m) + m) % n;
    }

    /**
     *链表
     */
    public static int LastRemaining_Solution2(int n, int m) {
        if(n == 0 || m <= 0) {
            return -1;
        }
        List<Integer> students = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            students.add(i);
        }
        int index = 0;
        while(students.size() > 1) {
            index = (index + m - 1) % students.size();
            students.remove(index);
        }
        return students.get(0);
    }
    public static void main(String [] args){
        int res = LastRemaining(5,3);
        System.out.println("");
    }
}
