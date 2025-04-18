package ex2;

//ユーザの現在の年齢を入力し、10年後の年齢を表示するプログラム
import java.util.Calendar;
import java.util.Scanner;

public class PrintYourAge {
    public static void main(String[] args) {
        try {
            System.out.println("何歳ですか?");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // 数値判定
                if (scanner.hasNextInt()) {
                    int age = scanner.nextInt();

                    if (age < 0 || age >= 120) {
                        System.out.println("不正な数値です。再入力してください。");
                        scanner.nextLine();
                        continue;
                    }

                    printResult(age);
                    scanner.close();
                    break;
                }

                // 終了判定
                String str = scanner.nextLine();
                if (str.equals("q") || str.equals("e")) {
                    scanner.close();
                    return;
                }

                // その他の値の場合
                System.out.println("不正な値です。再入力してください。");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printResult(int age) {
        int nowYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = nowYear - age;
        String birthYearByJpEra = convertJpEra(birthYear);

        if (birthYearByJpEra == null)
            return;

        System.out.println("2030年のあなたの年齢は" + (age - nowYear + 2030) + "歳です。");
        System.out.println("あなたは" + birthYearByJpEra + "に生まれました。");
    }

    // 西暦を和暦に変換
    public static String convertJpEra(int year) {
        final int START_YEAR_OF_REIWA = 2019;
        final int START_YEAR_OF_HEISEI = 1989;
        final int START_YEAR_OF_SHOWA = 1926;
        final int START_YEAR_OF_TAISHO = 1912;
        final int START_YEAR_OF_MEIJI = 1868;

        if (year >= START_YEAR_OF_REIWA) {
            return "令和" + (year - START_YEAR_OF_REIWA + 1) + "年";
        } else if (year >= START_YEAR_OF_HEISEI) {
            return "平成" + (year - START_YEAR_OF_HEISEI + 1) + "年";
        } else if (year >= START_YEAR_OF_SHOWA) {
            return "昭和" + (year - START_YEAR_OF_SHOWA + 1) + "年";
        } else if (year >= START_YEAR_OF_TAISHO) {
            return "大正" + (year - START_YEAR_OF_TAISHO + 1) + "年";
        } else if (year >= START_YEAR_OF_MEIJI) {
            return "明治" + (year - START_YEAR_OF_MEIJI + 1) + "年";
        } else {
            return null;
        }
    }
}
