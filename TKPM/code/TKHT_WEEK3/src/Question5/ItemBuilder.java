package Question5;

public interface ItemBuilder {
    ItemBuilder buidlId(String id);

    ItemBuilder buildName(String name);

    ItemBuilder buildDesc(String desc);

    ItemBuilder buildDate(String date);

    ItemBuilder buildFeedback(String feedback);

    ItemBuilder buildPromo(String promo);

    ItemBuilder buildSalePrice(long salePrice);

    Item build();
}
