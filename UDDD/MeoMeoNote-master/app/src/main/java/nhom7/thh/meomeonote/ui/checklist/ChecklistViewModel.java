package nhom7.thh.meomeonote.ui.checklist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChecklistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ChecklistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is checklist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}