package com.ldm.cashbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ldm.cashbook.R;
import com.ldm.cashbook.database.CashTableUtils;
import com.ldm.cashbook.model.CashModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * @author ldm
 * @description hellocharts-android使用 https://github.com/lecho/hellocharts-android
 * @time 2017/3/1 14:15
 */
public class ShowCashActivity extends AppCompatActivity {
    private LineChartView mChart;
    private Map<String, Integer> chartData = new TreeMap<String, Integer>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_show);
        initViewsAndDatas();
        initChartViews();
    }

    private void initChartViews() {
        List<Line> lines = new ArrayList<>();
        List<PointValue> values = new ArrayList<>();
        int index = 0;
        for (Integer integer : chartData.values()) {
            values.add(new PointValue(index, integer));
            index++;
        }
        Line line = new Line(values);
        line.setHasLabels(true);
        line.setColor(ChartUtils.COLOR_BLUE);
        line.setShape(ValueShape.CIRCLE);
        line.setPointColor(ChartUtils.COLOR_RED);
        lines.add(line);
        LineChartData lineChartData = new LineChartData(lines);
        mChart.setLineChartData(lineChartData);
    }

    /**
     * @description 获取数据及展示
     * @author ldm
     * @time 2017/3/1 11:43
     */
    private void initViewsAndDatas() {
        mChart = (LineChartView) findViewById(R.id.cash_chart);
        List<CashModel> mDatas = CashTableUtils.getInstance().queryAllCashes();
        if (null != mDatas) {
            for (CashModel mData : mDatas) {
                String time = mData.getCostTime();
                int cost = Integer.valueOf(mData.getCostNumber());
                if (!chartData.containsKey(time)) {
                    chartData.put(time, cost);
                } else {
                    int orginCost = chartData.get(time);
                    chartData.put(time, orginCost + cost);
                }
            }
        }
    }
}
