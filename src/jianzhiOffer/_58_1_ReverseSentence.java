package jianzhiOffer;

/**
 * 翻转单词顺序（像这种隐含的条件就是不能使用额外的空间，包括
 * 像递归这样的函数）
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串
 * "I am a student." 则输出student. a am I
 * 先翻转句子中所有字符，再翻转每个单词中字符的顺序
 */
public class _58_1_ReverseSentence {
    //先旋转每个单词，再旋转整个字符串
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
