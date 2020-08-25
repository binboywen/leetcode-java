package written_examination.perfectWorld;
import java.util.*;
public class Main3 {
    public static HashMap<Integer,Integer>count;
    public static HashMap<Integer,List<Integer>>graph;
    private static boolean isPerfect(int x, int y) {
        int r = (int)Math.sqrt(x + y);
        return r * r == x + y;
    }

    public static int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) {
                if (count.get(y) != 0) {
                    ans += dfs(y, todo - 1);
                }
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }
    static int perfectArrayNum(int[] A) {
        int N = A.length;
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : 数组 A 中值为 v 的节点数量
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
        for (int x: count.keySet()) {
            graph.put(x, new ArrayList());
        }

        for (int x: count.keySet())
            for (int y: count.keySet()) {
                if (isPerfect(x, y)) {
                    graph.get(x).add(y);
                }
            }

        // 增加从 x 开始的可行路径数量
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, N - 1);
        return ans;

    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for(int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        res = perfectArrayNum(_array);
        System.out.println(String.valueOf(res));

    }
}
