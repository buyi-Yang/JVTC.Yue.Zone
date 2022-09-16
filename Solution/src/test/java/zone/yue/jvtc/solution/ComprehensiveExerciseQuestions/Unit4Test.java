package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

@TestMethodOrder(MethodOrderer.MethodName.class)
class Unit4Test {
    @BeforeAll
    static void testU4BeforeAll() {
        System.out.println("----- 单元四 循环累和 测试开始 -----");
    }

    @Test
    void testU4Q1CyclicAddition() {
        int a = 2;
        int times = 5;

        // 重新分配输入流
        System.setIn(new ByteArrayInputStream(String.format("%d %d", a, times).getBytes()));

        System.out.println("U4Q1 - 求 s = a + aa + aaa + aaaa + ... 的值：");
        Unit4.cyclicAddition();
    }

    @Test
    void testU4Q2FactorialSum() {
        System.out.println("U4Q2 - 1! + 2! + 3! + ... + 20! = " + Unit4.factorialSum(20));
    }

    @Test
    void testU4Q3() {
        System.out.println("U4Q3 - 1 - 1/2 + 1/3 - 1/4 + ... + 1/19 - 1/20 =" + Unit4.q3(20));
    }

    @Test
    void testU4Q4() {
        System.out.println("U4Q4 - 12 - 22 + 32 - 42 + ... + 192 - 202 = " + Unit4.q4(20));
    }

    @Test
    void testU4Q5() {
        System.out.println("U4Q5 - 分数序列：2/1, 3/2, 5/3, 8/5, 13/8, 21/13, ... 的前 20 项之和为：" + Unit4.q5(20));
    }

    @Test
    void testU4Q6() {
        System.out.println("U4Q6 - 当 n=5 时：" + Unit4.q6(5));
        System.out.println("U4Q6 - 当 n=6 时：" + Unit4.q6(6));
    }

    @Test
    void testU4Q7() {
        short year = 2022;
        short month = 9;
        short day = 10;
        System.out.printf("U4Q7 - %d 年 %d 月 %d 日是该年的第 %d 天%n", year, month, day, Unit4.q7(year, month, day));
    }

    @AfterAll
    static void testU4AfterAll() {
        System.out.println("===== 单元四 循环累和 测试结束 =====\n");
    }
}
