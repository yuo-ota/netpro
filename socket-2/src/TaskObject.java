import java.io.Serializable;

public class TaskObject implements Serializable, ITask {
    private int targetNum;
    private int resultNum;

    @Override
    public void setExecNumber(int x) {
        targetNum = x;
    }

    @Override
    public void exec() {
        // エラトステネスの篩アルゴリズムを用いる
        // 最終的にfalseだと素数
        boolean[] primeTable = new boolean[targetNum - 1]; // 2~targetNumの範囲で考えるため、要素数はtargetNum - 1となる。

        // 素数検索
        for (int i = 2; i <= (int) (Math.sqrt(targetNum)); i++) {
            // 非素数の場合
            if (primeTable[i - 2])
                continue;

            // 篩設定
            int j = i;
            while (true) {
                j += i;
                if (j > targetNum)
                    break;

                primeTable[j - 2] = true;
            }
        }
        for (int i = targetNum; i >= 2; i--) {
            if (!primeTable[i - 2]) {
                resultNum = i;
                break;
            }
        }
    }

    @Override
    public int getResult() {
        exec();
        return resultNum;
    }
}
