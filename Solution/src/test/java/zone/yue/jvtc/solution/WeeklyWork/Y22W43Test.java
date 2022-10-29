package zone.yue.jvtc.solution.WeeklyWork;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Y22W43Test {
    @BeforeAll
    static void testY22W37BeforeAll() {
        System.out.println("----- 2022 年第 43 周编程作业 测试开始 -----");
    }

    @Test
    void testY22W43GetGcd() {
        int a = 8;
        int b = 17;
        int result = Y22W43.getGcd(a, b);
        System.out.println("两数的最大公约数：" + result);
    }

    @Test
    void testY22W43GetLcm() {
        int a = 42;
        int b = 87;
        int result = Y22W43.getLcm(a, b);
        System.out.println("两数的最小公倍数：" + result);
    }

    @AfterAll
    static void testY22W37AfterAll() {
        System.out.println("===== 2022 年第 43 周编程作业 测试结束 =====");
    }
}
