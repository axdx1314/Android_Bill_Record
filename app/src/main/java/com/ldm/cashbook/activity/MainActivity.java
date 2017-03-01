package com.ldm.cashbook.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.ldm.cashbook.R;
import com.ldm.cashbook.adapter.CashAdapter;
import com.ldm.cashbook.database.CashTableUtils;
import com.ldm.cashbook.model.CashModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //列表控件ListView
    private ListView cash_lv;
    //数据适配器
    private CashAdapter mCashAdapter;
    //数据
    private List<CashModel> mDatas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
    }

    /**
     * @description 获取数据及展示
     * @author ldm
     * @time 2017/3/1 11:43
     */
    private void initDatas() {
        mDatas = CashTableUtils.getInstance().queryAllCashes();
        mCashAdapter = new CashAdapter(this, mDatas, R.layout.cash_item);
        cash_lv.setAdapter(mCashAdapter);
    }

    private void initViews() {
        cash_lv = (ListView) findViewById(R.id.cash_lv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                showInputDialog();
            }
        });
    }

    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View dialogView = mInflater.inflate(R.layout.dialog_add_cash, null);
        final EditText edt_title = (EditText) dialogView.findViewById(R.id.edt_title);
        final EditText edt_number = (EditText) dialogView.findViewById(R.id.edt_number);
        final DatePicker dp_time = (DatePicker) dialogView.findViewById(R.id.dp_time);
        builder.setView(dialogView);
        builder.setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //保存数据
                String title = edt_title.getText().toString().trim();
                String number = edt_number.getText().toString().trim();
                String time = dp_time.getYear() + "-" + (dp_time.getMonth() + 1) + "-" + dp_time.getDayOfMonth();
                CashModel model = new CashModel();
                model.setCostName(title);
                model.setCostNumber(number);
                model.setCostTime(time);
                CashTableUtils.getInstance().insertCashData(model);
                mDatas.add(model);
                mCashAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), null);
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, ShowCashActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
