package com.example.heng.sydata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by heng on 2017/6/25.
 */

public class CostListAdapter extends BaseAdapter {
    private List<CostBean> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public CostListAdapter(Context context,List<CostBean> list){
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
       return mList.size();
    }

    @Override
    public long getItemId(int i) {
       return i;
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder= null ;
        if(viewHolder == null){
            viewHolder = new ViewHolder();
            view =mLayoutInflater.inflate(R.layout.list_item,null);
            viewHolder.mTvCostTitle = (TextView) view.findViewById(R.id.tv_title);
            viewHolder.tmTvCostDate = (TextView) view.findViewById(R.id.tv_data);
            viewHolder.mTvCostMoney = (TextView) view.findViewById(R.id.tv_cost);
            view.setTag(viewHolder);
        }else {
           // viewHolder = (ViewHolder) view.getTag();
            view.getTag();
        }
        CostBean bean= mList.get(i);
        viewHolder.mTvCostTitle.setText(bean.costTitle);
        viewHolder.tmTvCostDate.setText(bean.costDate);
        viewHolder.mTvCostMoney.setText(bean.costMoney);
        return view;
    }
    private static class ViewHolder{
        public TextView mTvCostTitle;
        public TextView tmTvCostDate;
        public TextView mTvCostMoney;
    }
}
