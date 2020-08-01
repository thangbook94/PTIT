package nhom7.thh.meomeonote.model;

public class Cat {
    private String catShortName;
    private String catName;
    private String catIcon;
    private String catAlbum;

    public Cat(String catShortName, String catName) {
        this.catShortName = catShortName;
        this.catName = catName;
        this.catIcon = "cat_avt_" + catShortName;
        this.catAlbum = "album_" + catShortName;
    }

    public String getCatShortName() {
        return catShortName;
    }

    public void setCatShortName(String catShortName) {
        this.catShortName = catShortName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatIcon() {
        return catIcon;
    }

    public void setCatIcon(String catIcon) {
        this.catIcon = catIcon;
    }

    public String getCatAlbum() {
        return catAlbum;
    }

    public void setCatAlbum(String catAlbum) {
        this.catAlbum = catAlbum;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catShortName='" + catShortName + '\'' +
                ", catName='" + catName + '\'' +
                ", catIcon='" + catIcon + '\'' +
                ", catAlbum='" + catAlbum + '\'' +
                '}';
    }
}
