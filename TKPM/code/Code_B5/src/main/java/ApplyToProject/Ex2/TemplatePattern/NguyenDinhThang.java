package ApplyToProject.Ex2.TemplatePattern;

public class NguyenDinhThang {

    public static void main(String[] args) {
        ListItemsTemplate template = new ListItemsOrderByNameASC();
        template.showListItems();
        template = new ListItemsOrderByPriceASC();
        template.showListItems();

    }
}
