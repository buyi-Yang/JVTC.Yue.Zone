package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

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
        Unit5.q1(10);
    }

//    @Test
//    void testU5Q2() {
//        System.out.println("U5Q2 - 二十个月中每个月的兔子总数为" + Unit5.q2(20));
//    }

    @Test
    void testU5Q3() {
        Unit5.q3();
    }

    @Test
    void testU5Q5() {
        System.out.println("U5Q5 - ");
        Unit5.q5(100, -10);
    }

    @AfterAll
    static void testU5AfterAll() {
        System.out.println("===== 单元五 循环累和 测试结束 =====\n");
    }
}
