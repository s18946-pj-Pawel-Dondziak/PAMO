package pl.pjwstk.bottomnavigation.ui.chart_bmi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import pl.pjwstk.bottomnavigation.R;

public class ChartBMIFragment extends Fragment {

    private LineChart mChart;
    public static ChartBMIFragment newInstance() {
        return new ChartBMIFragment();
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chartbmi, container, false);

        //mChart = root.findViewById(R.id.chartBmi);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 22.5f));
        entries.add(new Entry(1, 23.0f));
        entries.add(new Entry(2, 24.5f));
        entries.add(new Entry(3, 24.0f));
        entries.add(new Entry(4, 25.5f));
        entries.add(new Entry(5, 26.0f));

        LineDataSet dataSet = new LineDataSet(entries, "BMI");
        dataSet.setColor(Color.BLUE);
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(4f);
        LineData lineData = new LineData(dataSet);
        mChart.setData(lineData);

        Description description = new Description();
        description.setText("Zmiany BMI w czasie");
        mChart.setDescription(description);

        mChart.invalidate();

        return root;
    }

}