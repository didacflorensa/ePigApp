package com.example.didac.epigapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.didac.epigapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Didac on 30/1/18.
 */



public class DashboardFragment extends Fragment {

    protected LineChart chart;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        chart = getActivity().findViewById(R.id.chart);


        List<Entry> entryList = new ArrayList<Entry>();

        entryList.add(new Entry(1, 10));
        entryList.add(new Entry(2, 13));
        entryList.add(new Entry(3, 15));
        entryList.add(new Entry(4, 17));
        entryList.add(new Entry(5, 14));
        entryList.add(new Entry(6, 12));


        LineDataSet setComp1 = new LineDataSet(entryList, "text");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setColor(R.color.accent);

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);

        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();

    }
}
