package jianzhiOffer;

import java.util.*;

public class _00_比较器的使用 {
    class Stu{
        int id;
        int score;
    }
    static class MyComparator implements Comparator<Integer>{
        //降序，默认升序
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    static class StuComparator implements Comparator<Stu>{
        //降序，升序也要自定义
        @Override
        public int compare(Stu o1, Stu o2) {
            return o2.id - o1.id;
        }
    }
    static class StrComparator implements Comparator<String>{
        //升序
        @Override
        public int compare(String o1, String o2) {

            return (o1 + o2).compareTo(o2+o1);
        }
    }
    public static void main(String [] args){
        //1.包装类型数组排序，不能对基本类型进行排序，int数组应该改为Integer类型的数组
        Integer [] arr = new Integer[10];
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });
        Arrays.sort(arr,new MyComparator());
        Arrays.sort(arr,(o1,o2)->o2 - o1);

        //2.自定义类型数组排序
        Stu [] arrStu = new Stu[20];
        Arrays.sort(arrStu, new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {

                return o2.id - o1.id;
            }
        });
        Arrays.sort(arrStu,new StuComparator());
        Arrays.sort(arrStu,(o1,o2)->o2.id - o1.id);

        //3.字符串类型数组排序
        String [] arrStr = new String[20];
        Arrays.sort(arrStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        Arrays.sort(arrStr,new StrComparator());
        Arrays.sort(arrStr,(o1,o2)->(o1+o2).compareTo(o2+o1));

        //4.List类型排序用Collections,其他用法都是一样的
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        Collections.sort(list, new MyComparator());
        Collections.sort(list,((o1, o2) -> o2 - o1));




    }
}
