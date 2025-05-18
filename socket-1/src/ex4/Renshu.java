package ex4;

class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // 1~nまでの合計値を返す関数
    public int sumUpToN(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    // p~qまでの整数の合計値を返す関数
    public int sumFromPtoQ(int p, int q) {
        int result = 0;

        // p > qの場合
        if (p > q)
            return -1;

        for (int i = p; i <= q; i++) {
            result += i;
        }
        return result;
    }

    // 配列a[]の指定されたindex以降の要素の合計値を返す関数
    public int sumFromArrayIndex(int[] a, int index) {
        int result = 0;

        // 不正なindex値の場合
        if (index >= a.length)
            return -1;

        for (int i = index; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    // 配列aの中で最大の値を返す関数
    public int selectMaxValue(int[] a) {
        int maxValue = a[0];
        for (int i : a) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    // 配列aの中で最小の値を返す関数
    public int selectMinValue(int[] a) {
        int minValue = a[0];
        for (int i : a) {
            if (i < minValue) {
                minValue = i;
            }
        }
        return minValue;
    }

    // 配列aの中で最大の値がある要素のindexを返す関数
    public int selectMaxIndex(int[] a) {
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 配列aの中で最小の値がある要素のindexを返す関数
    public int selectMinIndex(int[] a) {
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 配列pのi番目とj番目の要素を入れ替える関数
    public void swapArrayElements(int[] p, int i, int j) {
        int swap = p[i];
        p[i] = p[j];
        p[j] = swap;
    }

    // 同じ長さの2つの配列aとbの内容を入れ替える関数
    public boolean swapTwoArrays(int[] a, int[] b) {
        // aとbの長さが異なる場合
        if (a.length != b.length)
            return false;

        try {
            for (int i = 0; i < a.length; i++) {
                int swap = a[i];
                a[i] = b[i];
                b[i] = swap;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
