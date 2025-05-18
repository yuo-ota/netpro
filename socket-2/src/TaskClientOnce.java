import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientOnce {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5050);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("2以上の任意の整数nを入力してください。");
            int n = 2;
            while (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n == -1) {
                    scanner.close();
                    oos.close();
                    socket.close();
                    return;
                } else if (n < 2) {
                    System.out.println("不正な数値が入力されました。");
                    continue;
                } else {
                    break;
                }
            }
            scanner.close();

            TaskObject task = new TaskObject();
            task.setExecNumber(n);

            oos.writeObject(task);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject result = (TaskObject) ois.readObject();

            int resultContent = result.getResult();
            System.out.println(n + "以下で最大の素数は" + resultContent + "\nです。");

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
