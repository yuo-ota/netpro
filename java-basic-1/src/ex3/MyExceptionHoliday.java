package ex3;

import java.util.Scanner;

public class MyExceptionHoliday {
    private static final int[] MAY_HOLIDAY_DATE = { 3, 4, 5, 6, 10, 11, 17, 18, 24, 25, 31 };

    public static void main(String[] args) {
        new MyExceptionHoliday();
    }

    public MyExceptionHoliday() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("5月の何日ですか？（終了したい場合はexitと入力）：");

                // 数値判定
                if (scanner.hasNextInt()) {
                    int date = scanner.nextInt();

                    try {
                        search(date);
                    } catch (NoHolidayException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        System.out.println("不正な値です。再入力してください。");
                    }
                    scanner.nextLine();
                    continue;
                }

                // 終了判定
                String str = scanner.nextLine();
                if (str.equals("exit")) {
                    scanner.close();
                    return;
                }

                // その他の値の場合
                System.out.println("不正な値です。再入力してください。");
            }
        } catch (Exception e) {
            System.out.println("予期せぬエラーが発生しました。もう一度お試しください。");
        }
    }

    public void search(int date) throws NoHolidayException, IllegalArgumentException {
        // 不正な値の検出
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }

        // 検索
        for (int i = 0; i < MAY_HOLIDAY_DATE.length; i++) {
            if (MAY_HOLIDAY_DATE[i] == date) {
                System.out.println(date + "日はお休みです。");
                return;
            }
        }

        throw new NoHolidayException();
    }
}
