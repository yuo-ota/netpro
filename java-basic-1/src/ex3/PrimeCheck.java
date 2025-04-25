package ex3;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeCheck {
    private static final int MAX_PRIME = 100000;
    private Map<String, Integer> countTable = new LinkedHashMap<>();

    public static void main(String[] args) {
        new PrimeCheck();
    }

    public PrimeCheck() {
        // Map生成
        generateMap();

        // カウント
        countPrime();

        // 描画
        printResult();
    }

    public void printResult() {
        countTable.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void countPrime() {
        // エラトステネスの篩アルゴリズムを用いる
        // 最終的にfalseだと素数
        boolean[] primeTable = new boolean[MAX_PRIME - 1]; // 2~100000の範囲で考えるため、要素数はMAX_PRIME - 1となる。

        // 素数検索
        for (int i = 2; i < (int) (Math.sqrt(MAX_PRIME)); i++) {
            // 非素数の場合
            if (primeTable[i - 2])
                continue;

            // 篩設定
            int j = i;
            while (true) {
                j += i;
                if (j > MAX_PRIME)
                    break;

                primeTable[j - 2] = true;
            }
        }

        // カウント
        int prePrimeNum = -1; // 前の素数の下1桁について
        for (int i = 2; i <= MAX_PRIME; i++) {
            if (!primeTable[i - 2]) {
                countPrime(prePrimeNum, i);
                prePrimeNum = i;
            }
        }
    }

    public void countPrime(int preNum, int nowNum) {
        String key = preNum % 10 + "-" + nowNum % 10;
        if (countTable.containsKey(key)) {
            countTable.put(key, countTable.get(key) + 1);
        }
    }

    public void generateMap() {
        countTable.put("1-1", 0);
        countTable.put("1-3", 0);
        countTable.put("1-7", 0);
        countTable.put("1-9", 0);
        countTable.put("3-1", 0);
        countTable.put("3-3", 0);
        countTable.put("3-7", 0);
        countTable.put("3-9", 0);
        countTable.put("7-1", 0);
        countTable.put("7-3", 0);
        countTable.put("7-7", 0);
        countTable.put("7-9", 0);
        countTable.put("9-1", 0);
        countTable.put("9-3", 0);
        countTable.put("9-7", 0);
        countTable.put("9-9", 0);
    }
}
