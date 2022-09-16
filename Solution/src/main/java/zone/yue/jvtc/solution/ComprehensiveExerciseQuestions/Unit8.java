package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;


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
     *
     * @param arr 一个班级某门课程的成绩
     * @return 最高分和最低分
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

    /**
     * Q2 - 统计人数
     *
     * <p>输入一个班级某门课程的成绩存入数组，统计优、良、中、及、不及的人数。
     *
     * @param arr 一个班级某门课程的成绩
     * @return 优、良、中、及格、不及格的人数
     */
    public static String q2(double[] arr) {
        // A = 优（90 分以上）
        int a = 0;

        // B = 良（90~80 分之间）
        int b = 0;

        // C = 中（80~70 分之间）
        int c = 0;

        // D = 及格（70~60 分之间）
        int d = 0;

        // E = 不及格（60 分以下）
        int e = 0;

        for (double i : arr) {
            if (i >= 90.0) { a++; }
            else if (i >= 80.0) { b++; }
            else if (i >= 70.0) { c++; }
            else if (i >= 60.0) { d++; }
            else { e++; }
        }

        return String.format("优：%d 人；良：%d 人；中：%d 人；及格：%d 人；不及格：%d 人", a, b, c, d, e);
    }
}
