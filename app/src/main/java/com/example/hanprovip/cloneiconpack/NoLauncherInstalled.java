package com.example.hanprovip.cloneiconpack;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoLauncherInstalled extends AppCompatActivity {
    ArrayList<LauncherInfo> NoLauncherInfoArrayList;
    LauncherAdapter adapter;
    ListView lvNoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_launcher_installed);

        lvNoLauncher = (ListView) findViewById(R.id.lvNoLauncher);
        NoLauncherInfoArrayList = new ArrayList<>();

        NoLauncherInfoArrayList.add(new LauncherInfo("Nova Launcher", "com.nova.launcher", R.drawable.ic_nova_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("ADW Launcher", "org.adw.launcher", R.drawable.ic_adw_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("Action Launcher","com.actionlauncher.playstore", R.drawable.ic_action_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("Smart Launcher", "ginlemon.flowerfree", R.drawable.ic_sl_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("Smart Launcher Pro 3","ginlemon.flowerpro", R.drawable.ic_sl_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("Apex Launcher","com.anddoes.launcher", R.drawable.ic_apex_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("Holo Launcher", "com.mobint.hololauncher", R.drawable.ic_holo_48dp));
        NoLauncherInfoArrayList.add(new LauncherInfo("Go Launcher","com.gau.go.launcherex", R.drawable.ic_go_48dp));
        //Đụ má nhiều vãi lồn
        //Thêm custom dòng lisview vào adapter
        adapter = new LauncherAdapter(this, R.layout.dong_listview, NoLauncherInfoArrayList);
        lvNoLauncher.setAdapter(adapter);

        lvNoLauncher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.teslacoilsw.launcher")));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.teslacoilsw.launcher")));
                    }

                }
                if (position==1)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
                if (position==2)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
                if (position==3)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
                if (position==4)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
                if (position==5)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
                if (position==6)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
                if (position==7)
                {
                    try{
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }catch (android.content.ActivityNotFoundException anfe){
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NoLauncherInfoArrayList.get(position).getPackageName())));
                    }

                }
            }
        });
    }
}
