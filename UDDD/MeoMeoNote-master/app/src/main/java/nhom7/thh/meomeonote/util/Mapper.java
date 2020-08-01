package nhom7.thh.meomeonote.util;

import android.app.Activity;

import nhom7.thh.meomeonote.entity.Note;
import nhom7.thh.meomeonote.model.LineNote;

public class Mapper {
    public static LineNote mapNoteEntityToLineNote(Note note, Activity activity) {
        return
                new LineNote(
                        note.getId(),
                        note.getTitle(),
                        note.getContent().length() > 30 ? note.getContent().substring(0, 30) + "..." : note.getContent(),
                        note.getLastModified().substring(9),
                        note.getPassword() == null ? false : true,
                        note.getTimer(), BaseUtil.getIdResource(activity, "cat_avt_" + note.getCatName(), "drawable", activity.getPackageName())
                );
    }
}
