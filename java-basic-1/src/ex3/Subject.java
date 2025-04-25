package ex3;

public class Subject {
    String name;
    int score;
    private int studentId;

    Subject(int s, int studentId) { // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
        score = s;
        this.studentId = studentId;
    }

    // setScore というメソッドを定義する。
    // score に値を設定する。
    public void setScore(int num) {
        score = num;
    }

    // getScore というメソッドを定義する。
    // scoreを返す。
    public int getScore() {
        return score;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return studentId + "," + score;
    }
}
