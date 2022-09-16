package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class Unit1Test {
    @BeforeAll
    static void testU1Before() {
        System.out.println("----- 单元一 公式计算 测试开始 -----");
    }

    @Test
    void testU1Q1TriangleArea() {
        double a = 5.0;
        double h = 3.0;
        System.out.printf("U1Q1 - 底边为 %g 高为 %g 的三角形面积为 %g%n", a, h, Unit1.triangleArea(a, h));
    }

    @Test
    void testU1Q2ParallelogramPerimeter() {
        double a = 1.0;
        double b = 2.0;
        System.out.printf("U1Q2 - 边长分别为 %g 与 %g 的平行四边形周长为 %g%n", a, b, Unit1.parallelogramPerimeter(a, b));
    }

    @Test
    void testU1Q3CuboidVolume() {
        double a = 2.0;
        double b = 3.0;
        double h = 5.0;
        System.out.printf("U1Q3 - 长为 %g 宽为 %g 高为 %g 的长方体体积为 %g%n", a, b, h, Unit1.cuboidVolume(a, b, h));
    }

    @Test
    void testU1Q4CylinderVolume() {
        double r = 3.0;
        double h = 5.0;
        System.out.printf("U1Q4 - 半径为 %g 高为 %g 的圆柱体的体积为 %g%n", r, h, Unit1.cylinderVolume(r, h));
    }

    @Test
    void testU1Q5ConeVolume() {
        double r = 3.0;
        double h = 5.0;
        System.out.printf("U1Q5 - 半径为 %g 高为 %g 的圆锥体的体积为 %g%n", r, h, Unit1.coneVolume(r, h));
    }

    @Test
    void testU1Q6CircuitPower() {
        double u = 3.0;
        double r = 5.0;
        System.out.printf("U1Q6 - 电压为 %g 电阻为 %g 的电路的电功率为 %g%n", u, r, Unit1.resistanceCircuitPower(u, r));
    }

    @Test
    void testU1Q7NotResistanceCircuitPower() {
        double i = 3.0;
        double r = 5.0;
        System.out.printf("U1Q7 - 电流为 %g 电阻为 %g 的电路的电热为 %g%n", i, r, Unit1.notResistanceCircuitPower(i, r));
    }


    @AfterAll
    static void testU1AfterAll() {
        System.out.println("===== 单元一 公式计算 测试结束 =====\n");
    }
}
