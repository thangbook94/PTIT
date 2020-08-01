package nhom7.thh.meomeonote.ui.cats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.adapter.GridViewICatIconAdapter;
import nhom7.thh.meomeonote.dbhelper.DbHelper;
import nhom7.thh.meomeonote.entity.Cat;
import nhom7.thh.meomeonote.util.BaseUtil;

public class CatsFragment extends Fragment {

    private CatsViewModel catsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catsViewModel =
                ViewModelProviders.of(this).get(CatsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cats, container, false);
        final GridView gridView = root.findViewById(R.id.grid_cats);
//        catsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        final List<Integer> avts = new ArrayList<>();
        DbHelper dbHelper = new DbHelper(getContext());
        final List<Cat> allCats = dbHelper.getAllCat();
        for (Cat i : allCats) {
            if (i.getStatus() == 1) {
                avts.add(BaseUtil.getIdResource(getActivity(), "cat_avt_" + i.getCatShortName(), "drawable", getActivity().getPackageName()));
            } else {
                avts.add(R.drawable.notowned);
            }
        }
        final GridViewICatIconAdapter adapter = new GridViewICatIconAdapter(avts, getActivity());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater layoutInflater = getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.gridview_cat_info, null);
                ImageView catAlbum = view1.findViewById(R.id.cat_album);
                TextView catName = view1.findViewById(R.id.cat_name);
                if (allCats.get(position).getStatus() == 1) {
                    int temp = BaseUtil.getIdResource(getActivity(), "album_" + allCats.get(position).getCatShortName(), "drawable", getActivity().getPackageName());
                    catAlbum.setImageResource(temp);
                    catName.setText(allCats.get(position).getCatname());
                }
                final AlertDialog alertDialog = builder.create();
                alertDialog.setView(view1);
                alertDialog.show();
                alertDialog.getWindow().setLayout(800, 660);
            }
        });
        return root;
    }
}