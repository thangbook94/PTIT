package nhom7.thh.meomeonote.entity;

public class Attachment {
    private int id;
    private String link;
    private String type;
    private String created;
    private String last_modified;
    private int status;
    private int note_id;

    public Attachment() {
    }

    public Attachment(int id, String link, String type, String created, String last_modified, int status, int note_id) {
        this.id = id;
        this.link = link;
        this.type = type;
        this.created = created;
        this.last_modified = last_modified;
        this.status = status;
        this.note_id = note_id;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }
}
