package ex2;

import java.util.Random;

public class TheBoilingEarthEraC {
    private static final int START_YEAR = 2016;
    private static final int TARGET_MONTH = 7;
    private static final double SUMMER_DAY_LIMIT = 30.0;

    private static double[][] temperatures = new double[10][31];

    public static void main(String[] args) {
        generateData(); // データの生成

        // printMonthData(2025); // A課題

        System.out.println("猛暑日連続ペア");
        // checkSummerDay(2025); // B課題

        // C問題
        for (int i = 0; i < temperatures.length; i++) {
            checkSummerDay(i + START_YEAR);
        }
    }

    public static void generateData() {
        final double START_TEMP = 29.0;
        final double DIFF_TEMP = 0.3;

        Random random = new Random();
        double YearAveTemp = START_TEMP;

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < temperatures[i].length; j++) {
                // 気温の生成
                double temp = YearAveTemp + (random.nextDouble(-5.0, 5.0));
                // 小数点第二位を丸める
                double editedTemp = Math.round(temp * 10) / 10.0;
                temperatures[i][j] = editedTemp;
            }
            // 毎年DIFF_TEMP分平均気温を上昇させる
            YearAveTemp += DIFF_TEMP;
        }
    }

    // 指定された日時をフォーマット化して出力
    public static void printDate(int targetYear, int targetYearIndex, int targetDateIndex) {
        System.out.print(targetYear + "年" + TARGET_MONTH + "月" + (targetDateIndex + 1) + "日\t"
                + temperatures[targetYearIndex][targetDateIndex]
                + "℃");
    }

    public static void printMonthData(int year) {
        // 不正な引数の場合
        if (year < START_YEAR || year >= START_YEAR + temperatures.length) {
            System.out.println("入力された数値が条件を満たしません。");
            return;
        }
        // 対象年のindex
        int targetYearIndex = year - START_YEAR;

        // 出力
        for (int i = 0; i < temperatures[targetYearIndex].length; ++i) {
            printDate(year, targetYearIndex, i);
            System.out.println();
        }
    }

    public static void checkSummerDay(int year) {
        // 不正な引数の場合
        if (year < START_YEAR || year >= START_YEAR + temperatures.length) {
            System.out.println("入力された数値が条件を満たしません。");
            return;
        }
        // 対象年のindex
        int targetYearIndex = year - START_YEAR;

        // 出力
        for (int i = 0; i < temperatures[targetYearIndex].length - 1; ++i) {
            if (temperatures[targetYearIndex][i] >= SUMMER_DAY_LIMIT
                    && temperatures[targetYearIndex][i + 1] >= SUMMER_DAY_LIMIT) {
                printDate(year, targetYearIndex, i);
                System.out.print(" と\t");
                printDate(year, targetYearIndex, i + 1);
                System.out.println();
            }
        }
    }
}