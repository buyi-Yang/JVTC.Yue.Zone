package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Unit8Test {
    @Test
    void testU8Q1() {
        // 最高分为：123.000；最低分为：-87.0000；
        double[] arr = {1, 2, 5, 10, 18, -66, -87, 0, 123, 0.0, 0.1, -0.1, -0.6666};
        System.out.println("U8Q1 - " + Unit8.q1(arr));
    }

    @Test
    void testU8Q2() {
        // 优：2 人；良：3 人；中：2 人；及格：1 人；不及格：5 人；
        double[] arr = {90, 91, 89.9999, 80.01, 81.999, 79.999, 70.0001, 61, 59.99999, 30, -31, 0.001, -0.999};
        System.out.println("U8Q2 - " + Unit8.q2(arr));
    }
}
