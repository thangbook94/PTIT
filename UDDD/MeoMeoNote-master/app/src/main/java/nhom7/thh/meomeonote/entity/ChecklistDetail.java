package nhom7.thh.meomeonote.entity;

public class ChecklistDetail {
    private int id;
    private String password;
    private String content;
    private String created;
    private String last_modified;
    private int status;
    private int checklist_id;
    private String dateRemove;

    public ChecklistDetail(int id, String password,
                           String content, String created, String last_modified, int status, int checklist_id, String dateRemove) {
        this.id = id;
        this.password = password;
        this.content = content;
        this.created = created;
        this.last_modified = last_modified;
        this.status = status;
        this.checklist_id = checklist_id;
        this.dateRemove = dateRemove;
    }

    public ChecklistDetail() {
    }

    public String getDateRemove() {
        return dateRemove;
    }

    public void setDateRemove(String dateRemove) {
        this.dateRemove = dateRemove;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getChecklist_id() {
        return checklist_id;
    }

    public void setChecklist_id(int checklist_id) {
        this.checklist_id = checklist_id;
    }
}
