package written_examination.zhaoyinwangluo;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main tt = new Main();
        System.out.println("结果为：" + tt.minStr("JDJSOJSNENDNSO","NDSO"));
    }
    public static String minStr(String str1, String str2) {
        if (str1 == null || str1 == "" || str2 == null || str2 == "" || str1.length() < str2.length()) {
            return "";
        }
        int[] str1Char = new int[128];
        int[] str2Char = new int[128];

        for (int i = 0; i < str2.length(); i++) {
            str2Char[str2.charAt(i)]++;
        }

        int count = 0;
        int left = 0;
        int right = 0;
        String result = "";

        int minLength = str1.length() + 1;

        while (right <str1.length()) {
            char ch = str1.charAt(right);
            str1Char[ch]++;
            if (str2Char[ch] > 0 && str2Char[ch] >= str1Char[ch]) {
                count++;
            }

            while (count == str2.length()) {
                ch = str1.charAt(left);
                if (str2Char[ch] > 0 && str2Char[ch] >= str1Char[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = str1.substring(left, left + minLength) ;
                }
                str2Char[str1.charAt(left)]--;
                left++;
            }
            right++;
        }
        return result;
    }
}
