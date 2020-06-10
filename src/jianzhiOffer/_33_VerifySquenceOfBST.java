package jianzhiOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class _33_VerifySquenceOfBST {
    /**
     可以确定的是，一个数组中最后一个肯定是根节点，
     再在数组中找到第一个大于根节点的值的位置，左边部分
     是左子树，右边部分是右子树
     */
    public boolean VerifySquenceOfBST(int [] sequence){
        if(sequence == null || sequence.length == 0)
            return false;
        return verify(sequence,0,sequence.length - 1);
    }

    private boolean verify(int [] sequence, int first, int last){
        if(last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        while(first < last && sequence[cutIndex] <= rootVal){
            cutIndex++;
        }
        for(int i = cutIndex; i< last;i++){
            if(sequence[i] < rootVal)
                return false;
        }
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex,last - 1);
    }
}