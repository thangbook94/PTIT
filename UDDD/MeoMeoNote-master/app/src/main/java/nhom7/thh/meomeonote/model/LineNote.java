package nhom7.thh.meomeonote.model;

public class LineNote {
    private int id;
    private String title;
    private String shortContent;
    private String lastModified;
    private boolean isLocked;
    private String timer;
    private int catAvt;

    public LineNote(int id, String title, String shortContent, String lastModified, boolean isLocked, String timer, int catAvt) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.lastModified = lastModified;
        this.isLocked = isLocked;
        this.timer = timer;
        this.catAvt = catAvt;
    }

    public LineNote() {
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public int getCatAvt() {
        return catAvt;
    }

    public void setCatAvt(int catAvt) {
        this.catAvt = catAvt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LineNote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", catAvt=" + catAvt +
                '}';
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }
}
