package zone.yue.jvtc.solution.ceq;

public class Unit5 {
    /**
     * 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个；
     * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下的一半零一个。
     * 到第 10 天早上想再吃时，见只剩下一个桃子了。
     * 求第一天共摘了多少。
     */
    public static void q1() {
        int sum, remain = 1;

        // 每天吃剩的桃子加一个正好是前一天桃子的一半，每天桃子的总数就是前一天剩下桃子的数量。
        for (int day = 9; day >= 1; day--) {
            sum = (remain + 1) * 2;
            remain = sum;
            System.out.println("第 " + day + " 天还剩 " + remain + " 个桃子");
        }

        System.out.println("答：第一天共摘了 " + remain + " 个桃子");
        // 一天吃 768 个桃子的猴，NB！
    }
}
