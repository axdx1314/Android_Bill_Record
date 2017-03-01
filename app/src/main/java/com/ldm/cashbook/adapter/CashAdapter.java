package com.ldm.cashbook.adapter;

import android.content.Context;

import com.ldm.cashbook.R;
import com.ldm.cashbook.common.CommonAdapter;
import com.ldm.cashbook.common.ViewHolder;
import com.ldm.cashbook.model.CashModel;

import java.util.List;

/**
 * @author ldm
 * @description列表适配器
 * @time 2017/3/1 11:59
 */
public class CashAdapter extends CommonAdapter<CashModel> {
    public CashAdapter(Context mContext, List<CashModel> mDatas, int itemResId) {
        super(mContext, mDatas, itemResId);
    }

    @Override
    public void convert(ViewHolder holder, CashModel cashModel) {
        holder.setTextView(R.id.item_title, cashModel.getCostName());
        holder.setTextView(R.id.item_time, cashModel.getCostTime());
        holder.setTextView(R.id.item_number, cashModel.getCostNumber());
    }
}
