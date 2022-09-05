package zone.yue.jvtc.ComprehensiveExerciseQuestions;

public class Unit1 {
    /**
     * Q1 - 已知三角形的底边长与高，求三角形面积。
     *
     * @param a 三角形底边长
     * @param h 三角形高
     * @return 三角形面积
     */
    public static double TriangleArea(double a, double h) {
        return a * h / 2;
    }

    /**
     * Q2 - 已知平行四边形的两边长，求平行四边形的周长。
     *
     * @param a 平行四边形的边长
     * @param b 平行四边形的另一条边长
     * @return 平行四边形的周长
     */
    public static double ParallelogramPerimeter(double a, double b) {
        return (a + b) * 2;
    }

    /**
     * Q3 - 已知长方体的长宽高，求长方体的体积。
     *
     * @param a 长方体的长
     * @param b 长方体的宽
     * @param h 长方体的高
     * @return 长方体的体积
     */
    public static double CuboidVolume(double a, double b, double h) {
        return a * b * h;
    }

    /**
     * Q4 - 已知圆柱体半径与高，求圆柱体体积。
     *
     * @param r 圆柱体半径
     * @param h 圆柱体高
     * @return 圆柱体体积
     */
    public static double CylinderVolume(double r, double h) {
        return Math.sqrt(Math.PI * r) * h;
    }

    /**
     * Q5 - 已知圆锥体的半径与高，求圆锥体的体积。
     *
     * @param r 圆锥体的半径
     * @param h 圆锥体的高
     * @return 圆锥体的体积
     */
    public static double ConeVolume(double r, double h) {
        return Math.sqrt(Math.PI * r) * h / 3;
    }

    /**
     * Q6 - 已知电压与电阻，求电功率。
     * @param U 电压
     * @param R 电阻
     * @return 电功率
     */
    public static double ResistanceCircuitPower(double U, double R) {
        return Math.sqrt(U) / R;
    }

    /**
     * Q7 - 已知电流与电阻，求电热。
     * @param I 电流
     * @param R 电阻
     * @return 电热
     */
    public static double NotResistanceCircuitPower(double I, double R) {
        return Math.sqrt(I) * R;
    }
}