package nhom7.thh.meomeonote.ui.cats;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CatsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CatsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cats fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}