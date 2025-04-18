package ex2;

public class IfArgsTest {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        switch (x) {
            case 7:
            case 8:
            case 9:
                System.out.println("big number");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("middle number");
                break;
            case 1:
            case 2:
            case 3:
                System.out.println("small number");
                break;
            default:
                System.out.println("out of scope");
        }

    }// main end
}// class end