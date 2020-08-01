package nhom7.thh.meomeonote.entity;

import java.io.Serializable;

public class Note implements Serializable {
    private int id;
    private String password;
    private String title;
    private String content;
    private String created;
    private String lastModified;
    private String timer;
    private String catName;
    private int status;
    private int userId;

    public Note(int id, String password,
                String title, String content, String created,
                String lastModified, String timer, int status, int userId, String catName) {

        this.id = id;
        this.password = password;
        this.title = title;
        this.content = content;
        this.created = created;
        this.lastModified = lastModified;
        this.timer = timer;
        this.status = status;
        this.userId = userId;
        this.catName = catName;
    }

    public Note() {
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", last_modified='" + lastModified + '\'' +
                ", timer='" + timer + '\'' +
                ", catName='" + catName + '\'' +
                ", status=" + status +
                ", user_id=" + userId +
                '}';
    }
}
