package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class Unit3Test {
    @BeforeAll
    static void testU3BeforeAll() {
        System.out.println("----- 单元三 基本循环（要求用 while 语句设计） 测试开始 -----");
    }

    @Test
    void testU3Q1PassJudgment() {
        // 此示例共 10 名学生，其中 4 人及格，6 人不及格。
        double[] list = {0, 1, 20, 30, 50, 59, 60, 80.5, 99, 100};
        System.out.println("U3Q1 - " + Unit3.passJudgment(list));
    }

    @Test
    void testU3Q2HighestAndLowestScore() {
        // 此示例共 10 名学生，其中最高分为 100 分，最低分为 -99 分。
        double[] list = {50, 59, 60, 80.5, 0, 1, 20, 30, -99, 100};
        System.out.println("U3Q2 - " + Unit3.highestAndLowestScore(list));
    }

    @Test
    void testU3Q3CountAlphabetAndOther() {
        // 此句长度为 44，其中有 35 个字母（a~z 与 A~Z）。
        String en = "The quick brown fox jumps over the lazy dog.";
        // 输入中文会导致异常结果，当前认为是编码转换导致的。
        String zh = "我能吞下玻璃而不伤身体。";
        System.out.println("U3Q3 - en - " + Unit3.countLetterAndOther(en));
        System.out.println("U3Q3 - zh - " + Unit3.countLetterAndOther(zh));
    }

    @Test
    void testU3Q4VoteStatistics() {
        // 此列表中张同学 5 票，王同学 3 票，无效票 2 张。
        String[] zhangWin = {"张同学", "张同学", "王同学", "张同学", "张同学", "王同学", "王同学", "张同学", "张三", "狗蛋"};
        String[] even = {"张同学", "王同学"};

        System.out.println("U3Q4 - " + Unit3.voteStatistics(zhangWin));
        System.out.println("U3Q4 - 平手 - " + Unit3.voteStatistics(even));
    }

    @Test
    void testU3Q5JuryScoring() {
        double[] list = {-0.1, 0, 15.9, 666, -233, 3.14, 77, 486, 114, 514, 5};
        System.out.println("U3Q5 - " + Unit3.juryScoring(list));
    }

    @Test
    void testU3Q6Count() {
        System.out.println("U3Q6 - " + Unit3.count());
    }

    @Test
    void testU3Q7LeapYear() {
        System.out.println("U3Q7 - " + Unit3.leapYear());
    }

    @AfterAll
    static void testU3AfterAll() {
        System.out.println("===== 单元三 基本循环（要求用 while 语句设计） 测试结束 =====\n");
    }
}
