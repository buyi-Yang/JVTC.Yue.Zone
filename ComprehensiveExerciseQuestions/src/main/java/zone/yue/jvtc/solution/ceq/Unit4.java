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
     * Q3 - 计算：1 - 1/2 + 1/3 - 1/4 + ... + 1/(n-1) - 1/n
     *
     * @param n 最大分母
     * @return 1 - 1/2 + 1/3 - 1/4 + ... + 1/(n-1) - 1/n 的结果
     */
    public static double q3(int n) {
        // Q3 - 计算：
        // 1 - 1/2 + 1/3 - 1/4 + 1/5 - 1/6 + 1/7 - 1/8 + 1/9 - 1/10
        // + 1/11 - 1/12 + 1/13 - 1/14 + 1/15 - 1/16 + 1/17 - 1/18 + 1/19 - 1/20
        // return 0.6687714031754279;

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

    /**
     * Q4 - 计算：12 - 22 + 32 - 42 + ... + (n*10+2) - (n*10+2)
     *
     * @param n ((n-2)/10)
     * @return 12 - 22 + 32 - 42 + ... + (n*10+2) - (n*10+2) 的结果
     */
    public static long q4(int n) {
        // Q4 - 计算：12-22+32-42+52-62+72-82+92-102+112-122+132-142+152-162+172-182+192-202
        // return -100;

        boolean isPlus = true;
        long result = 0;

        for (int i = 1; i <= Math.abs(n); i++) {
            if (isPlus) {
                result += i * 10L + 2L;
            } else {
                result -= i * 10L + 2L;
            }

            isPlus = !isPlus;
        }

        return result;
    }

    /**
     * Q5 - 有一分数序列：2/1, 3/2, 5/3, 8/5, 13/8, 21/13, ...
     *
     * @param n 数列长度
     * @return 数列前 n 项之和
     */
    public static double q5(int n) {
        // Q5 - 有一分数序列：
        // 2/1 + 3/2 + 5/3 + 8/5 + 13/8 + 21/13 + 34/21 + 55/34 + 89/55 + 144/89 + 233/144 + 377/233 + 610/377
        // + 987/610 + 1597/987 + 2584/1597 + 4181/2584 + 6765/4181 + 10946/6765 + 17711/10946
        // 求出这个数列的前 20 项之和。
        //
        // return 32.6602607986416;

        // 分子
        int molecular = 2;
        // 分母
        int denominator = 1;
        double result = 0;

        for (int i = 0; i < n; i++) {
            int nextMolecular = molecular + denominator;
            result += (double) molecular / denominator;
            denominator = molecular;
            molecular = nextMolecular;
        }

        return result;
    }
}
