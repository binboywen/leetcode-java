package jianzhiOffer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */

public class _17_打印从1到最大的N位数 {
    /**
     * 当输入一个大数时会产生溢出问题
     * @param n
     */
    public void print1ToMaxOfNDigits(int n){
        int number = 1;
        int i = 1;
        while(i++ <= n){
            number *= 10;
        }
        for (i = 1; i < number; i++){
            System.out.println(i);
        }
    }

    /**
     * 可以考虑使用字符串求解，用char数组进行存储
     * 1_一般解法
     * 2_使用回溯法得到所有的数
     */
    public void print1ToMaxOfNDigits_1(int n){
        if(n <= 0)
            return ;
        char [] number = new char[n + 1];
        number[n] = '\0';
        while(!Increment(number)){
            PrintNumber(number);
        }
    }

    public boolean Increment(char [] number){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength -1 ; i >= 0; i--){
            int nSum = number[i]  - '0' + nTakeOver;
            if(i == nLength -1)
                nSum++;
            if(nSum >= 10){
                if(i == 0)
                    isOverflow = true;
                else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)(nSum + '0');
                }
            }
            else{
                number[i] = (char)(nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    public void PrintNumber(char [] number){
        boolean isBeginning0 = true;
        int nLength = number.length;

        for(int i = 0; i < nLength; i++){
            if(isBeginning0 && number[i] != 0){
                isBeginning0 = false;
            }
            if (!isBeginning0)
            {
                System.out.println(number[i]);
            }
        }

    }
    /**
     * 可以考虑使用字符串求解，用char数组进行存储
     * 1_一般解法
     * 2_使用回溯法得到所有的数
     */
    public void print1ToMaxOfNDigits_2(int n){
        if (n <= 0)
            return ;
        char [] number = new char[n];
        print1ToMaxOfNDigits_2(number, 0);
    }

    private void print1ToMaxOfNDigits_2(char [] number, int digit){
        if (digit == number.length){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++){
            number[digit] = (char)(i + '0');
            print1ToMaxOfNDigits_2(number, digit+1);
        }
    }

    private void printNumber(char [] number){
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

}
