package ApplyToProject.Ex4.IteratorPattern;

public class NguyenDinhThang {
    public static void main(String[] args) {
        ItemCollection collection = new ItemCollection();
        ItemIterator iterator = (ItemIterator) collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
