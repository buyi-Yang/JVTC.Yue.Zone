package zone.yue.jvtc.solution.ceq;

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
}
