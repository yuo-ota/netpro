public class DinnerFullCourse {
    private Dish[] list = new Dish[5];

    public static void main(String[] args) {

        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }

    public DinnerFullCourse() {
        list[0] = new Dish();
        list[0].setName("特選シーザサラダ");
        list[0].setPrice(1000);

        list[1] = new Dish();
        list[1].setName("銀しゃり");
        list[1].setPrice(500);

        list[2] = new Dish();
        list[2].setName("梅干し");
        list[2].setPrice(200);

        list[3] = new Dish();
        list[3].setName("ロールケーキ");
        list[3].setPrice(800);

        list[4] = new Dish();
        list[4].setName("唐辛子");
        list[4].setPrice(150);
    }// Dinnerコンストラクターエンド

    public void eatAll() {
        for (Dish d : list) {
            System.out.println(d.getName() + ":" + d.getPrice() + "円");
        }
    }
}
