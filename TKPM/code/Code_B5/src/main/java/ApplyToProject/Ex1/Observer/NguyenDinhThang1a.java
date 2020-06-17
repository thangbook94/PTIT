package ApplyToProject.Ex1.Observer;

public class NguyenDinhThang1a {
    public static void main(String[] args) {
        ItemService itemService = createItem("Liar game chap 10 ", 1);
        itemService.changeStatus(ItemStatus.ACTIVE);
    }

    private static ItemService createItem(String name, int price) {
        ItemService item = new ItemService(name, price);
        item.attach(new User("thang@gmail", "123"));
        item.attach(new User("thang1@gmail", "1233"));
        item.attach(new User("thang2@gmail", "124123"));
        return item;
    }
}
