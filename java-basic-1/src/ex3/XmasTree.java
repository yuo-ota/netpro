package ex3;

import java.util.Scanner;

public class XmasTree {
    public static void main(String[] args) {
        new XmasTree();
    }

    public XmasTree() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("カンマ区切りで値を入力してください。\n" +
                    "第一引数には木の裾の幅の半分の幅を\n" +
                    "第二引数には幹の幅を\n" +
                    "第三引数には幹の高さを\n" +
                    "第四引数には雪模様の種類(*, |, .のいずれか)をお願いします。");
            while (true) {
                String str = scanner.nextLine();
                // 終了判定
                if (str.equals("q") || str.equals("e")) {
                    break;
                }

                // 正規の入力値の場合
                String[] elements = str.split(",");
                if (elements.length == 4) {
                    try {
                        TreeInfo treeInfo = new TreeInfo(Integer.valueOf(elements[0]),
                                Integer.valueOf(elements[1]),
                                Integer.valueOf(elements[2]),
                                elements[3]);
                        treeInfo.draw();
                    } catch (NumberFormatException e) {
                        System.out.println("不正な値です。 hint: 入力値の数字は全て自然数のみ受け付けます。");
                    } catch (IllegalArgumentException e) {
                        System.out.println("不正な値です。値を変えて再入力してください。");
                    }
                    continue;
                }

                // その他の値の場合
                System.out.println("不正な値です。再入力してください。");
            }
            scanner.close();
            return;
        } catch (Exception e) {
            System.out.println("予期せぬエラーが発生しました。もう一度お試しください。");
        }
    }
}

class TreeInfo {
    private final String VALID_KIND_STRING = "+|.";

    private int maxWidth;
    private int trunkWidth;
    private int trunkHeight;
    private String snowKind;

    public TreeInfo(int maxWidth, int trunkWidth, int trunkHeight, String snowKind) throws IllegalArgumentException {
        // 値のチェック
        if (maxWidth < 1 || // 木の裾が自然数でないとき
                trunkWidth >= maxWidth * 2 || // 幹の幅が木の裾幅以上にあるとき
                trunkWidth < 1 || // 幹の幅が自然数でないとき
                trunkHeight < 1 || // 幹の高さが自然数でないとき
                snowKind.length() != 1 || // snowKindの値が1文字でないとき
                !VALID_KIND_STRING.contains(snowKind) // snowKindの入力値が想定されていないものであるとき
        ) {
            throw new IllegalArgumentException();
        }

        this.maxWidth = maxWidth;
        this.trunkWidth = trunkWidth;
        this.trunkHeight = trunkHeight;
        this.snowKind = snowKind;
    }

    // 木の描画関数
    public void draw() {
        for (int i = 0; i < maxWidth + trunkHeight + 1; i++) {
            if (i <= maxWidth) {
                drawUpSide(i);
            } else {
                drawDownSide(i - maxWidth);
            }
            System.out.println();
        }
    }

    // 木の上半身の描画関数
    public void drawUpSide(int stepCount) {
        for (int i = 0; i < maxWidth * 2; i++) {
            // 葉の場合
            if (i >= maxWidth - stepCount && i < maxWidth + stepCount) {
                System.out.print("*");
                continue;
            }

            // 雪の場合
            switch (snowKind) {
                case "+":
                    if (i % 3 == stepCount % 3) {
                        System.out.print("+");
                    } else {
                        System.out.print(" ");
                    }
                    break;
                case "|":
                    if (i % 2 == 0) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                    break;
                case ".":
                    if (i % 2 == stepCount % 2) {
                        System.out.print(".");
                    } else {
                        System.out.print(" ");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    // 木の下半身の描画関数
    public void drawDownSide(int stepCount) {
        for (int i = 0; i < maxWidth + (trunkWidth + 1) / 2; i++) {
            if (i < maxWidth - trunkWidth / 2) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }
        }
    }
}