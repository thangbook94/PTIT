package nhom7.thh.meomeonote.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.dbhelper.DbHelper;

import static android.content.Context.MODE_PRIVATE;

public class CatUtil {
    public static boolean getCatOnwed(Activity activity, String catShortName, String catFullName) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("bt1", MODE_PRIVATE);
        boolean isOwned = sharedPreferences.getBoolean(catShortName + "_reward", false);
        if (!isOwned) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.gridview_cat_info, null);
            ImageView catAlbum = view1.findViewById(R.id.cat_album);
            TextView catName = view1.findViewById(R.id.cat_name);
            int temp = BaseUtil.getIdResource(activity, "album_" + catShortName, "drawable", activity.getPackageName());
            catAlbum.setImageResource(temp);
            catName.setText("Found " + catFullName + "!!!");
            final AlertDialog alertDialog = builder.create();
            alertDialog.setView(view1);
            alertDialog.show();
            alertDialog.getWindow().setLayout(800, 660);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(catShortName + "_reward", true);
            editor.apply();
            DbHelper dbHelper = new DbHelper(activity);
            dbHelper.updateCat(catShortName);
        } else {
            Toast.makeText(activity, "Already get this reward! Please check the Cats collection.", Toast.LENGTH_SHORT).show();
        }
        return isOwned;
    }
}
