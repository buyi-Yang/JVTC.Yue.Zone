package zone.yue.jvtc.solution.WeeklyWork;

/**
 * @author Yue_plus
 */
public class Y22W43 {
    /**
     * 求最大公约数
     * <bbbr title="Greatest Common Divisor">GCD</bbbr>
     *
     * @param a 整数
     * @param b 整数
     * @return 两数的最大公约数
     */
    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : getGcd(b, a % b);
    }

    /**
     * 求最小公倍数
     * <abbr title="Least Common Multiple">LCM</abbr>
     * @param a 整数
     * @param b 整数
     * @return 两数的最小公倍数
     */
    public static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
}
