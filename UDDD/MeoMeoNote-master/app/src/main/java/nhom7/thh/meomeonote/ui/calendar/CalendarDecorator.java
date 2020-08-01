package nhom7.thh.meomeonote.ui.calendar;

import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.HashSet;

public class CalendarDecorator implements DayViewDecorator {
    private int mColor;
    private HashSet<CalendarDay> mCalendarDayCollection;

    public CalendarDecorator(int color, HashSet<CalendarDay> calendarDayCollection) {
        mColor = color;
        mCalendarDayCollection = calendarDayCollection;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return mCalendarDayCollection.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.BLACK));
        view.addSpan(new BackgroundColorSpan(mColor));
//        view.setBackgroundDrawable(R.drawable.);

    }
}
