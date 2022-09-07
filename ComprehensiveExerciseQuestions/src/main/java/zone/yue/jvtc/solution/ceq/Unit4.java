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
     * @param n 累和次数（大于 25 结果会溢出）
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

        for (int i = 1; i <= n; i++) {
            BigInteger factorial = BigInteger.valueOf(1);
            for (int j = 1; j <= i; j++) {
                factorial = factorial.multiply(BigInteger.valueOf(j));
            }
            sum = factorial;
        }

        return sum;
    }
}
