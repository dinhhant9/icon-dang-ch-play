package com.example.hanprovip.cloneiconpack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LauncherAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<LauncherInfo>  launcherInfoList;

    public LauncherAdapter(Context context, int layout, List<LauncherInfo> launcherInfoList) {
        this.context = context;
        this.layout = layout;
        this.launcherInfoList = launcherInfoList;
    }

    @Override
    public int getCount() {
        return launcherInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        //Anh xa
        TextView txtLabel = (TextView) convertView.findViewById(R.id.txtLabel);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imgViewIcon);
        //gan gia tri
        LauncherInfo launcherInfo = launcherInfoList.get(position);
        txtLabel.setText(launcherInfo.getLabel());
        imgIcon.setImageResource(launcherInfo.getResID());
        return convertView;
    }
}
