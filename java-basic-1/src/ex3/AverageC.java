package ex3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AverageC {
    private static final int START_STUDENT_ID = 100;
    private static final int STUDENT_COUNT = 100;
    private Subject[] students = new Subject[STUDENT_COUNT];

    public static void main(String[] args) {
        new AverageC();
    }

    public AverageC() {
        // 学生データ生成
        generateStudentInfo();

        // 平均値計算
        int sum = 0;
        for (Subject s : students) {
            sum += s.getScore();
        }
        System.out.println("受験者全体での平均点は" + (double) sum / STUDENT_COUNT + "点です。\n");

        // ソート
        Arrays.sort(students, new StudentScoreComparator());

        // 一覧表示
        System.out.println("合格者の一覧は以下。");
        System.out.println("受験番号,点数");
        for (Subject s : students) {
            if (s.getScore() >= 80) {
                System.out.println(s);
            }
        }
    }

    public void generateStudentInfo() {
        Random random = new Random();
        for (int i = 0; i < STUDENT_COUNT; i++) {
            students[i] = new Subject(random.nextInt(101), START_STUDENT_ID + i); // 101未満の値を生成するため、100が最高の値になる。
            students[i].name = "数学";
        }
    }
}

class StudentScoreComparator implements Comparator<Subject> {
    public int compare(Subject s1, Subject s2) {
        return s1.getScore() - s2.getScore();
    }
}
