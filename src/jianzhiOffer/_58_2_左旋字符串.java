package jianzhiOffer;

/**
 * 左旋字符串
 * 字符串的左旋操作是把字符串前面的若干个字符串转移到字符串的尾部。
 * 例如输入abcdefg和2，输出cdefgab
 * 先分别翻转两个部分bagfedc，再整个翻转得到cdefgab
 */
public class _58_2_左旋字符串 {
    public String LeftRotateString(String s, int n) {
        if (n >= s.length())
            return s;
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
