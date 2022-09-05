package zone.yue.jvtc.ComprehensiveExerciseQuestions;

import org.junit.jupiter.api.Test;

public class Unit1Test {
    @Test
    public void testTriangleArea() {
        double a = 5.0;
        double h = 3.0;
        System.out.printf("Q1 - 底边为 %g 高为 %g 的三角形面积为 %g%n", a, h, Unit1.TriangleArea(a, h));
    }

    @Test
    public void testParallelogramPerimeter() {
        double a = 1.0;
        double b = 2.0;
        System.out.printf("Q2 - 边长分别为 %g 与 %g 的平行四边形周长为 %g%n", a, b, Unit1.ParallelogramPerimeter(a, b));
    }

    @Test
    public void testCuboidVolume() {
        double a = 2.0;
        double b = 3.0;
        double h = 5.0;
        System.out.printf("Q3 - 长为 %g 宽为 %g 高为 %g 的长方体体积为 %g%n", a, b, h, Unit1.CuboidVolume(a, b, h));
    }

    @Test
    public void testCylinderVolume() {
        double r = 3.0;
        double h = 5.0;
        System.out.printf("Q4 - 半径为 %g 高为 %g 的圆柱体的体积为 %g%n", r, h, Unit1.CylinderVolume(r, h));
    }

    @Test
    public void testConeVolume() {
        double r = 3.0;
        double h = 5.0;
        System.out.printf("Q5 - 半径为 %g 高为 %g 的圆锥体的体积为 %g%n", r, h, Unit1.ConeVolume(r, h));
    }

    @Test
    public void testCircuitPower() {
        double U = 3.0;
        double R = 5.0;
        System.out.printf("Q6 - 电压为 %g 电阻为 %g 的电路的电功率为 %g%n", U, R, Unit1.ResistanceCircuitPower(U, R));
    }

    @Test public void testNotResistanceCircuitPower() {
        double I = 3.0;
        double R = 5.0;
        System.out.printf("Q7 - 电流为 %g 电阻为 %g 的电路的电热为 %g%n", I, R, Unit1.NotResistanceCircuitPower(I, R));
    }
}
