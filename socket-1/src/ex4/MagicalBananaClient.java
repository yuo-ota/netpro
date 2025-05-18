package ex4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class MagicalBananaClient {
    public static void main(String arg[]) {
        try {
            Socket socket = new Socket("localhost", 5050);
            System.out.println("接続されました");

            System.out.println("マジカルバナナを開始します！");

            Word content = new Word();
            System.out.println("マジカルバナナ");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in, "Shift-JIS");

            while (true) {
                try {
                    System.out.println(content.getWord() + "といったら");

                    while (true) {
                        // 数値判定
                        if (scanner.hasNext()) {
                            String word = scanner.next();

                            if (word.equals("quit")) {
                                System.out.println("aaa");
                                return;
                            } else if (word.isEmpty()) {
                                continue;
                            }
                            content = new Word(word);
                            scanner.nextLine();
                            break;
                        }
                    }

                    oos.writeObject(content);
                    oos.flush();

                    System.out.println("相手の入力を待っています......");
                    Word newTargetWord = (Word) ois.readObject();
                    String target = newTargetWord.getWord();
                    System.out.println(content.getWord() + "といったら" + target);
                    content = new Word(target);
                } catch (Exception e) {
                    System.out.println("通信が終了しました。");
                    break;
                }
            }
            scanner.close();
            ois.close();
            oos.close();
            socket.close();
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}