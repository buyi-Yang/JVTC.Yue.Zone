package zone.yue.jvtc.solution.ceq;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 单元四 循环累和
 *
 * @author Yue_plus
 */
public class Unit4 {
    public static void main(String[] args) {
        Unit4.cyclicAddition();
    }

    public static void cyclicAddition() {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextInt());
    }

    /**
     * Q2 - 乘阶累和
     *
     * @param n 累和次数（n 取绝对值）
     * @return 1! + 2! + 3! + ... + (n-2)! + (n-1)! + n! 的和。
     */
    public static BigInteger factorialSum(int n) {
        /*
        Q2 - 求 1! + 2! + 3! + ... + 20! 的和。
        就说这数对不对吧：
        return 2432902008176640000L;
        */

        /*
         使用 long 类型的话 n 大于 25 结果就会溢出。
         long sum = 0;
         for (int i = 1; i <= n; i++) {
             long factorial = 1;
             for (int j = 1; j <= i; j++) {
                 factorial *= j;
             }
             sum =+ factorial;
         }
         return sum;
        */

        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 1; i <= Math.abs(n); i++) {
            BigInteger factorial = BigInteger.valueOf(1);
            for (int j = 1; j <= i; j++) {
                factorial = factorial.multiply(BigInteger.valueOf(j));
            }
            sum = factorial;
        }

        return sum;
    }

    /**
     * 计算 1 - 1/2 + 1/3 - 1/4 + ... + 1/(n-1) - 1/n 。
     *
     * @param n 最大分母
     * @return 1 - 1/2 + 1/3 - 1/4 + ... + 1/(n-1) - 1/n 的结果
     */
    public static double q3(int n) {
        /*
        Q3 - 计算：1 - 1/2 + 1/3 - 1/4 + 1/5 - 1/6 + 1/7 - 1/8 + 1/9 - 1/10
          + 1/11 - 1/12 + 1/13 - 1/14 + 1/15 - 1/16 + 1/17 - 1/18 + 1/19 - 1/20
        return 0.6687714031754279;
        */

        boolean isPlus = true;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            if (isPlus) {
                result += 1.0 / i;
            } else {
                result -= 1.0 / i;
            }

            isPlus = !isPlus;
        }

        return result;
    }
}
