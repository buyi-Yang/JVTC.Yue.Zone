package zone.yue.jvtc.solution.ceq;


/**
 * 单元八 数组基本应用
 *
 * @author Yue_plus
 */
public class Unit8 {
    /**
     * Q1 - 最高分和最低分
     *
     * <p>输入一个班级某门课程的成绩存入数组，求最高分和最低分。
     */
    public static String q1(double[] arr) {
        double highest = 0;
        double lowest = 0;

        for (double i : arr) {
            if (i > highest) {
                highest = i;
            } else if (i < lowest) {
                lowest = i;
            }
        }

        return String.format("最高分为：%g；最低分为：%g；", highest, lowest);
    }
}
