package zone.yue.jvtc.solution.ceq;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Unit5Test {
    @BeforeAll
    static void testU5BeforeAll() {
        System.out.println("----- 单元五 循环累和 测试开始 -----");
    }

    @Test
    void testU5Q1() {
        System.out.println("U5Q1 - ");
        Unit5.q1();
    }

    @AfterAll
    static void testU5AfterAll() {
        System.out.println("===== 单元五 循环累和 测试结束 =====\n");
    }
}
