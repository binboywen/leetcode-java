package jianzhiOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class _33_二叉搜索树的后续遍历序列 {
    /**
     可以确定的是，一个数组中最后一个肯定是根节点，
     再在数组中找到第一个大于根节点的值的位置，左边部分
     是左子树，右边部分是右子树
     */
    public static boolean VerifySquenceOfBST(int [] sequence){
        if(sequence == null || sequence.length == 0)
            return false;
        return verify(sequence,0,sequence.length - 1);
    }

    private static boolean verify(int [] sequence, int first, int last){
        if(last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        while(cutIndex < last  && sequence[cutIndex] <= rootVal){
            cutIndex++;
        }
        if(cutIndex == sequence.length) return true;
        for(int i = cutIndex; i< last;i++){
            if(sequence[i] < rootVal)
                return false;
        }
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex,last - 1);
    }
    public static void main(String [] args){
        int [] arr = {179, 437, 1405, 5227, 8060, 8764, 8248, 4687, 3297, 13038, 12691, 15744, 16195, 15642, 19813, 17128, 21051, 20707, 22177, 21944, 23644, 23281, 19970, 23652, 26471, 31467, 33810, 32300, 33880, 27334, 25987, 35643, 35103, 36489, 42534, 42990, 42942, 37090, 36075, 34516, 16624, 11335, 10737, 44641, 45754, 47096, 46021, 49150, 48013, 49814, 51545, 52555, 50701, 47875, 56783, 57558, 53812, 62008, 61737, 63052, 63478, 62799, 59246, 64765, 64066, 63862, 65384, 67449, 66552, 57741, 45618, 44412, 667, 69718, 75519, 76819, 72971, 79319, 78145, 80615, 84280, 80984, 86598, 85903, 84334, 80867, 87993, 92361, 88465, 87738, 80364, 94380, 94446, 96785, 93694, 76847, 99655, 98675, 97001, 72112};
        System.out.println(VerifySquenceOfBST(arr));
    }

}
