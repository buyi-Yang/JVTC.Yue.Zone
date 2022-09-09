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

    @AfterAll
    static void testU4AfterAll() {
        System.out.println("===== 单元四 循环累和 测试结束 =====\n");
    }
}
