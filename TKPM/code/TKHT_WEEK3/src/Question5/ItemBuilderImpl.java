package Question5;

public class ItemBuilderImpl implements ItemBuilder {
    private String id;
    private String desc = "";
    private long salePrice;
    private String date = "";
    private String name = "";
    private String promo = "";
    private String feedback = "";

    @Override
    public ItemBuilder buidlId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public ItemBuilder buildName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ItemBuilder buildDesc(String desc) {
        this.desc = desc;
        return this;
    }

    @Override
    public ItemBuilder buildDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public ItemBuilder buildFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    @Override
    public ItemBuilder buildPromo(String promo) {
        this.promo = promo;
        return this;
    }

    @Override
    public ItemBuilder buildSalePrice(long salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    @Override
    public Item build() {
        return new Item(id, desc, salePrice, date, name, promo, feedback);
    }
}
