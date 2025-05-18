package ex4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MagicalBananaServer {
    public static void main(String[] args) {
        try {
            // 1. サーバーソケットをポート番号で作成 //例えば5050
            ServerSocket serverSocket = new ServerSocket(5050);
            Word content = new Word();
            System.out.println("接続しました。相手の入力を待っています......");
            Socket clientSocket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(System.in, "Shift-JIS");

            while (true) {
                try {
                    System.out.println("相手の入力を待っています......");
                    // 5. クライアントからのデータを受信して表示
                    Word newTargetWord = (Word) ois.readObject();
                    System.out.println(content.getWord() + "といったら" + newTargetWord.getWord());
                    System.out.println(newTargetWord.getWord() + "といったら");

                    while (true) {
                        // 数値判定
                        if (scanner.hasNext()) {
                            String word = scanner.next();

                            if (word.equals("quit")) {
                                return;
                            } else if (word.isEmpty()) {
                                continue;
                            }

                            content = new Word(word);
                            scanner.nextLine();
                            break;
                        }
                    }

                    // 4. クライアントにデータを送信するためのOutputStreamを取得
                    oos.writeObject(content);
                    oos.flush();
                } catch (Exception e) {
                    System.out.println("通信が終了しました。");
                    break;
                }
            }
            // close処理
            scanner.close();
            ois.close();
            oos.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
