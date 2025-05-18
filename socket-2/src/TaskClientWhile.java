import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5050);
            System.out.println("接続されました");
            System.out.println("2以上の任意の整数nを入力してください。");

            Scanner scanner = new Scanner(System.in);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true) {
                int n = scanner.nextInt();
                if (n == -1) {
                    System.out.println("サーバーとの通信を終了します。");
                    break;
                } else if (n < 2) {
                    System.out.println("不正な数値が入力されました。");
                    continue;
                }

                TaskObject task = new TaskObject();
                task.setExecNumber(n);

                oos.writeObject(task);
                oos.flush();

                TaskObject result = (TaskObject) ois.readObject();

                int resultContent = result.getResult();
                System.out.println("以下で最大の素数は\n" + resultContent + "\nです。");
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
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
