package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

/**
 * 单元五 循环递推
 *
 * @author Yue_plus
 */
public class Unit5 {
    /**
     * 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个；
     * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下的一半零一个。
     * 到第 n 天早上想再吃时，见只剩下一个桃子了。
     * 求第一天共摘了多少。
     *
     * @param n 到第几天发现只剩一个桃子了
     */
    public static void q1(int n) {
        int sum, remain = 1;

        // 每天吃剩的桃子加一个正好是前一天桃子的一半，每天桃子的总数就是前一天剩下桃子的数量。
        for (n--; n >= 1; n--) {
            sum = (remain + 1) * 2;
            remain = sum;
            System.out.println("第 " + n + " 天还剩 " + remain + " 个桃子");
        }

        System.out.println("答：第一天共摘了 " + remain + " 个桃子");
        // 一天吃 768 个桃子的猴，NB！
    }

//    /**
//     * 有一对兔子，从出生后第 3 个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子。
//     * 假如兔子都不死，问二十个月中每个月的兔子总数为多少？
//     */
//    public static void q2(int month) {
//        // 参考：[斐波那契数列_百度百科](https://baike.baidu.com/item/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97/99145#6_2)
//
//        // 第二十个月的兔子总数为：6765
//
//
//        if(month < 1) {
//            System.out.println("");
//        }
//
//        long a = 1;
//        long b = 1;
//        long temp;
//        for(int i = 2; i < month; i++) {
//            temp = a;
//            a = b;
//            b += temp;
//        }
//        return BigInteger.valueOf(b);
//    }

    /**
     * Q3 - 有 5 个人坐在一起，问第五个人多少岁？
     */
    public static void q3() {
        // 设五人分别为 A B C D E
        int a, b, c, d, e;

        // A 他说是 10 岁
        a = 10;

        // B 说他比 A 大 2 岁
        b = a + 2;

        // C 说他比 B 大 2 岁
        c = b + 2;

        // D 说他比 C 大 2 岁
        d = c + 2;

        // E 说他比 D 大 2 岁
        e = d + 2;

        System.out.println("第五个人的年龄为：" + e + " 岁");
    }

    /**
     * 一个球从 h 米高度自由落下，每次落地后反跳回原高度的一半；
     * 再落下，求它在第 n 次落地时，共经过多少米？第 n 次反弹多高？
     * @param height 高度
     * @param n 落地次数
     */
    public static void q5(double height, int n) {
        if (height <= 0) {
            System.out.println("错误！height 值不能小于或等于 0.0。");
        } else {
            // 共经过距离
            double through = 0;
            for (int i = 1; i <= Math.abs(n); i++) {
                through += height;
                height /= 2;
                System.out.printf("第 %d 次落地，共经过 %g 米，此次反弹 %g 米。%n", i, through, height);
            }
        }
    }
}
