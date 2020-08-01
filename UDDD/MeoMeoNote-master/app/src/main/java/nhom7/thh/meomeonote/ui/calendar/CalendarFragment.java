package nhom7.thh.meomeonote.ui.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateLongClickListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.HashSet;

import nhom7.thh.meomeonote.CalendarInfoActivity;
import nhom7.thh.meomeonote.R;
import nhom7.thh.meomeonote.dbhelper.DbHelper;

public class CalendarFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);
        final MaterialCalendarView materialCalendarView = root.findViewById(R.id.calendarView);
        materialCalendarView.state().edit().setCalendarDisplayMode(CalendarMode.MONTHS).commit();
        materialCalendarView.setSelectionColor(Color.GRAY);
        final CalendarDay currentDate = materialCalendarView.getCurrentDate();
        String month = (currentDate.getMonth() + 1) + "/" + currentDate.getYear();
        DbHelper db = new DbHelper(getContext());
        final HashSet<CalendarDay> setDayNote = db.getNodeByUserIdAndMonth(9999, month);
        materialCalendarView.addDecorator(new CalendarDecorator(getResources().getColor(R.color.calendar_note), setDayNote));

        HashSet<CalendarDay> setDaysChecklist = db.getChecklistByUserIdAndMonth(9999, month);
        materialCalendarView.addDecorator(new CalendarDecorator(getResources().getColor(R.color.calendar_checklist), setDaysChecklist));

        HashSet<String> set1 = new HashSet<>();
        for (CalendarDay c : setDaysChecklist) {
            set1.add(c.getDate().toString());
        }
        HashSet<CalendarDay> calendarDayHashSet = new HashSet<>();
        for (CalendarDay calendarDay : setDayNote) {
            if (set1.contains(calendarDay.getDate().toString())) {
                calendarDayHashSet.add(calendarDay);
            }
        }
        materialCalendarView.addDecorator(new CalendarDecorator(getResources().getColor(R.color.calendar_both), calendarDayHashSet));

        materialCalendarView.setOnDateLongClickListener(new OnDateLongClickListener() {
            @Override
            public void onDateLongClick(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date) {
                Intent intent = new Intent(getActivity(), CalendarInfoActivity.class);
                int month = date.getMonth() + 1;
                String m = month > 10 ? month + "" : ("0" + month);
                String d = date.getDay() + "/" + m + "/" + date.getYear();
                intent.putExtra("date", d);
                startActivity(intent);
            }
        });
        materialCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                String month = (date.getMonth() + 1) + "/" + date.getYear();
                DbHelper db = new DbHelper(getContext());
                HashSet<CalendarDay> setDaysNote = db.getNodeByUserIdAndMonth(9999, month);
                materialCalendarView.addDecorator(new CalendarDecorator(getResources().getColor(R.color.calendar_note), setDaysNote));

                HashSet<CalendarDay> setDaysChecklist = db.getChecklistByUserIdAndMonth(9999, month);
                materialCalendarView.addDecorator(new CalendarDecorator(getResources().getColor(R.color.calendar_checklist), setDaysChecklist));

                HashSet<String> set1 = new HashSet<>();
                for (CalendarDay c : setDaysChecklist) {
                    set1.add(c.getDate().toString());
                }
                HashSet<CalendarDay> calendarDayHashSet = new HashSet<>();
                for (CalendarDay calendarDay : setDayNote) {
                    if (set1.contains(calendarDay.getDate().toString())) {
                        calendarDayHashSet.add(calendarDay);
                    }
                }
                materialCalendarView.addDecorator(new CalendarDecorator(getResources().getColor(R.color.calendar_both), calendarDayHashSet));
            }
        });
        return root;
    }


}