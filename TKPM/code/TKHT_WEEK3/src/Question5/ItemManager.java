package Question5;

public class ItemManager {
    public static void main(String[] args) {
        ItemBuilder itemBuilder1 = new ItemBuilderImpl();
        Item item1 = itemBuilder1.buidlId("1").buildDate("20/10").buildDesc("Giam gia").build();
        System.out.println(item1);
        ItemBuilder itemBuilder2 = new ItemBuilderImpl();
        Item item2 = itemBuilder2.buidlId("2").buildFeedback("Tot").buildSalePrice(20).build();
        System.out.println(item2);
    }
}
