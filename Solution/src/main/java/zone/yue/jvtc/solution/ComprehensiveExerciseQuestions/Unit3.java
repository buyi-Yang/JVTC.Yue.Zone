package zone.yue.jvtc.solution.ComprehensiveExerciseQuestions;

import java.util.Arrays;

/**
 * 单元三 基本循环（要求用 while 语句设计）
 *
 * @author Yue_plus
 */
public class Unit3 {
    // 这个单元所有替明明都可以用 Foreach 语法！草！

    /**
     * Q1 - 输入一个班某门课的成绩，输出统计及格不及格的人数。
     * 及格线为 60 分。
     *
     * @param list 学生成绩列表
     * @return 字符串，其中描述了学生成绩列表长度、及格与不及格同学人数、及格率。
     */
    public static String passJudgment(double[] list) {
        // 及格线
        final int passLine = 60;
        // 及格人数
        int passCount = 0;
        // 不及格人数
        int unPassCount = 0;

        int i = 0;
        while (i < list.length) {
            if (list[i] >= passLine) {
                passCount++;
            } else {
                unPassCount++;
            }
            i++;
        }

        return String.format("共输入 %d 名同学的成绩，其中 %d 名同学及格，%d 名同学成绩不及格，当前及格率为 %g",
                list.length, passCount, unPassCount, ((double) passCount / (double) list.length) * 100);
    }

    /**
     * Q2 - 输入一个班某门课的成绩，输出最高分和最低分。
     *
     * @param list 学生成绩列表
     * @return 字符串，其中描述了学生成绩列表长度，以及其中的最高分与最低分。
     */
    public static String highestAndLowestScore(double[] list) {
        // 最高分
        double highest = 0;
        // 最低分
        double lowest = 0;

        int i = 0;
        while (i < list.length) {
            if (list[i] > highest) {
                highest = list[i];
            } else if (list[i] < lowest) {
                lowest = list[i];
            }
            i++;
        }

        return String.format("共输入 %d 名同学的成绩，其中最高分为 %g，最低分为 %g。", list.length, highest, lowest);
    }

    /**
     * Q3 - 统计字符串中的英文字母（a~z 与 A~Z）与其他字符数量。
     *
     * @param text 需要进行统计的文本
     * @return 字符串，其中描述了给定字符串中的英文字母与其他字符的数量。
     */
    public static String countLetterAndOther(String text) {
        // 英文字母个数
        int countLetter = 0;
        // 其他字符个数
        int otherLetter = 0;

        int i = 0;
        while (i < text.length()) {
            if (Character.isLetter(text.charAt(i))) {
                countLetter++;
            } else {
                otherLetter++;
            }
            i++;
        }

        return String.format("给定文本长为 %d 个字符，其中含有 %d 个英文字母与 %d 个其他字符。",
                text.length(), countLetter, otherLetter);
    }

    /**
     * Q4 - 张同学和王同学竞选班长，编写统计选票的程序。
     *
     * @param list 选票列表
     * @return 字符串，描述统票结果。
     */
    public static String voteStatistics(String[] list) {
        // 王同学得票
        int wang = 0;
        // 张同学得票
        int zhang = 0;
        // 无效票
        int invalid = 0;

        int i = 0;
        while (i < list.length) {
            if ("王同学".equals(list[i])) {
                wang++;
            } else if ("张同学".equals(list[i])) {
                zhang++;
            } else {
                invalid++;
            }
            i++;
        }

        // 判断是否平手
        if (wang == zhang) {
            return String.format("共收到 %d 张选票，王同学获得 %d 票，张同学获得 %d 票，无效票 %d 张，两位候选人旗鼓相当！",
                    list.length, wang, zhang, invalid);
        }

        return String.format("共收到 %d 张选票，王同学获得 %d 票，张同学获得 %d 票，无效票 %d 张，%s当选！",
                list.length, wang, zhang, invalid, wang > zhang ? "王同学" : "张同学");
    }

    /**
     * Q5 - 歌手大奖赛有 10 位评委打分，10 位评委分数的平均分就是每个歌手的最后得分，编写计算歌手最后得分的程序。
     *
     * @param list 评委打分列表，只取列表前十项，负数视为 0 分。
     * @return 字符串，描述歌手最后得分。
     */
    public static String juryScoring(double[] list) {
        // 评委人数
        final int judges = 10;
        // 截断数组，只取前十。
        list = Arrays.copyOf(list, judges);

        // 总分
        double total = 0;

        byte i = 0;
        while (i < judges) {
            if (list[i] > 0) {
                total += list[i];
            }
            i++;
        }

        return String.format("该选手最终得分为：%g 分", total / 10);
    }

    /**
     * Q6 - 编写程序统计 100 以内能被 3 整除的偶数有多少个。
     *
     * @return 字符串，描述 100 以内能被 3 整除的偶数有多少个。
     */
    public static String count() {
        /*
         考虑负数的话就有无穷个小于 100 且能被 3 整除的偶数。（皮
         return "Infinity";

        (我TM直接打表((继续皮
        return """
                0~100 以内能被 3 整除的偶数有 34 个：
                0 3 6 9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60 63 66 69 72 75 78 81 84 87 90 93 96 99""";
        */

        // 考虑在 0~100 以内能被 3 整除的偶数有多少个。
        byte count = 0;

        byte i = 0;
        final byte iMax = 100;
        while (i <= iMax) {
            if (i % 3 == 0) {
                count++;
            }
            i++;
        }

        return String.format("0~100 以内能被 3 整除的偶数有 %d 个。", count);
    }

    /**
     * 编写程序统计 2000~3000 年有多少个闰年。
     *
     * @return 字符串，描述 2000~3000 年有多少个闰年。
     */
    public static String leapYear() {
        /*
        打表！都可以打表！（麻了
        return """
                2000~3000 年有 243 个闰年：
                2000 2004 2008 2012 2016 2020 2024 2028 2032 2036 2040 2044 2048 2052 2056 2060 2064 2068 2072 2076 2080
                2084 2088 2092 2096 2104 2108 2112 2116 2120 2124 2128 2132 2136 2140 2144 2148 2152 2156 2160 2164 2168
                2172 2176 2180 2184 2188 2192 2196 2204 2208 2212 2216 2220 2224 2228 2232 2236 2240 2244 2248 2252 2256
                2260 2264 2268 2272 2276 2280 2284 2288 2292 2296 2304 2308 2312 2316 2320 2324 2328 2332 2336 2340 2344
                2348 2352 2356 2360 2364 2368 2372 2376 2380 2384 2388 2392 2396 2400 2404 2408 2412 2416 2420 2424 2428
                2432 2436 2440 2444 2448 2452 2456 2460 2464 2468 2472 2476 2480 2484 2488 2492 2496 2504 2508 2512 2516
                2520 2524 2528 2532 2536 2540 2544 2548 2552 2556 2560 2564 2568 2572 2576 2580 2584 2588 2592 2596 2604
                2608 2612 2616 2620 2624 2628 2632 2636 2640 2644 2648 2652 2656 2660 2664 2668 2672 2676 2680 2684 2688
                2692 2696 2704 2708 2712 2716 2720 2724 2728 2732 2736 2740 2744 2748 2752 2756 2760 2764 2768 2772 2776
                2780 2784 2788 2792 2796 2800 2804 2808 2812 2816 2820 2824 2828 2832 2836 2840 2844 2848 2852 2856 2860
                2864 2868 2872 2876 2880 2884 2888 2892 2896 2904 2908 2912 2916 2920 2924 2928 2932 2936 2940 2944 2948
                2952 2956 2960 2964 2968 2972 2976 2980 2984 2988 2992 2996""";
         */

        short count = 0;

        short y = 2000;
        final short yMax = 3000;
        while (y <= yMax) {
            /*
            能够被 4 整除但不被 100 整除的是闰年；
            能够被 100 整除但不被 400 整除的是平年；
            能够被 400 整除但不被 3200 整除的是闰年；
            [闰年（历法中的名词）_百度百科](https://baike.baidu.com/item/%E9%97%B0%E5%B9%B4/27098#6)
            */
            boolean isLeapYear = (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
            if (isLeapYear) {
                count++;
            }
            y++;
        }

        return String.format("2000~3000 年有 %d 个闰年", count);
    }

    // 想念 for 循环的第 231 行
}
