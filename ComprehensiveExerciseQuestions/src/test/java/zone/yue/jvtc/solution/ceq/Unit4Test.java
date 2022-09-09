package zone.yue.jvtc.solution.ceq;

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
        System.out.println("U4Q1 - ");
        Unit4.cyclicAddition();

        // 模拟键盘输入
        System.setIn(new ByteArrayInputStream("123".getBytes()));
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

    @AfterAll
    static void testU4AfterAll() {
        System.out.println("===== 单元四 循环累和 测试结束 =====\n");
    }
}
