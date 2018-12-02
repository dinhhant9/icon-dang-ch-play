package com.example.hanprovip.cloneiconpack;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnChoose;
    ArrayList<LauncherInfo> launcherInfoArrayList;
    LauncherAdapter adapter;
    ListView lvLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gọi hàm hiển thị Dialog
                DialogChoose();
            }
        });
    }
    //Đây là hàm hiển thị Dialog
    private void DialogChoose(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//Tắt Title của Dialog
        dialog.setContentView(R.layout.custom_dialog);//Truyền vào giao diện của Custom Dialog nằm trong layout
//        dialog.setCanceledOnTouchOutside(false);//Ngăn không cho dismiss Dialog khi bấm ra ngoài

        //Anh xa
        lvLauncher = (ListView) dialog.findViewById(R.id.lvLauncher);
        launcherInfoArrayList = new ArrayList<>();
        /*
        Bắt xem các launcher có đc cài trên thiết bị không
        Nếu có thì thêm vào ArrayList
         */
        if (isInstalled(MainActivity.this, "com.teslacoilsw.launcher"))
            launcherInfoArrayList.add(new LauncherInfo("Nova Launcher", "com.nova.launcher", R.drawable.ic_nova_48dp));
        if (isInstalled(MainActivity.this, "org.adw.launcher"))
            launcherInfoArrayList.add(new LauncherInfo("ADW Launcher", "org.adw.launcher", R.drawable.ic_adw_48dp));
        if (isInstalled(MainActivity.this, "com.actionlauncher.playstore"))
            launcherInfoArrayList.add(new LauncherInfo("Action Launcher","com.actionlauncher.playstore", R.drawable.ic_action_48dp));
        if (isInstalled(MainActivity.this, "ginlemon.flowerfree"))
            launcherInfoArrayList.add(new LauncherInfo("Smart Launcher", "ginlemon.flowerfree", R.drawable.ic_sl_48dp));
        if (isInstalled(MainActivity.this, "ginlemon.flowerpro"))
            launcherInfoArrayList.add(new LauncherInfo("Smart Launcher Pro 3","ginlemon.flowerpro", R.drawable.ic_sl_48dp));
        if (isInstalled(MainActivity.this, "com.anddoes.launcher"))
            launcherInfoArrayList.add(new LauncherInfo("Apex Launcher","com.anddoes.launcher", R.drawable.ic_apex_48dp));
        if (isInstalled(MainActivity.this, "com.mobint.hololauncher"))
            launcherInfoArrayList.add(new LauncherInfo("Holo Launcher", "com.mobint.hololauncher", R.drawable.ic_holo_48dp));
        if (isInstalled(MainActivity.this,"com.gau.go.launcherex"))
            launcherInfoArrayList.add(new LauncherInfo("Go Launcher","com.gau.go.launcherex", R.drawable.ic_go_48dp));
        //Đụ má nhiều vãi lồn
        //Thêm custom dòng lisview vào adapter
        adapter = new LauncherAdapter(this, R.layout.dong_listview, launcherInfoArrayList);
        lvLauncher.setAdapter(adapter);
        /*
        Bắt điều kiện nếu chưa cài launcher nào sẽ chuyển màn hình yêu cầu cài launcher
        Nếu có cài launcher mới show Dialog
         */
        if (launcherInfoArrayList.size() == 0){
            Intent intent = new Intent(MainActivity.this, NoLauncherInstalled.class);
            startActivity(intent);
        }
        else dialog.show();
        //Bat su kien khi chon vai item tren list view
        lvLauncher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LauncherInfo launcherInfo = launcherInfoArrayList.get(position);
                Intent intent;
                switch (launcherInfo.getResID()){
                    case R.drawable.ic_nova_48dp :
                        intent = new Intent("com.teslacoilsw.launcher.APPLY_ICON_THEME");
                        intent.setPackage("com.teslacoilsw.launcher");
                        intent.putExtra("com.teslacoilsw.launcher.extra.ICON_THEME_TYPE", "GO");
                        intent.putExtra("com.teslacoilsw.launcher.extra.ICON_THEME_PACKAGE", getPackageName());
                        try {
                            startActivity(intent);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    case R.drawable.ic_adw_48dp :
                        Intent adw = new Intent("org.adw.launcher.SET_THEME");
                        adw.putExtra("org.adw.launcher.theme.NAME", getPackageName());
                        try {
                            startActivity(adw);
                        } catch (Exception e) {
                        }
                        finish();
                        return;
                    case R.drawable.ic_action_48dp :
                        Intent al = getPackageManager().getLaunchIntentForPackage("com.actionlauncher.playstore");
                        if (al != null) {
                            al.putExtra("apply_icon_pack", getPackageName());
                            startActivity(al);
                            return;
                        }
                        return;
                    case R.drawable.ic_sl_48dp :
                        Intent actionIntent;
                        actionIntent = new Intent("ginlemon.smartlauncher.setGSLTHEME");
                        actionIntent.putExtra("package", getPackageName());
                        actionIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            startActivity(actionIntent);
                            return;
                        } catch (Exception e5) {
                            return;
                        }
                    case R.drawable.ic_apex_48dp :
                        Intent apex = new Intent("com.anddoes.launcher.SET_THEME");
                        apex.putExtra("com.anddoes.launcher.THEME_PACKAGE_NAME", getPackageName());
                        apex.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            startActivity(apex);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    case R.drawable.ic_holo_48dp :
                        intent = new Intent("android.intent.action.MAIN");
                        intent.setComponent(new ComponentName("com.mobint.hololauncher", "com.mobint.hololauncher.SettingsActivity"));
                        try {
                            startActivity(intent);
                            return;
                        } catch (Exception e6) {
                            return;
                        }
                    case R.drawable.ic_go_48dp :
                        Intent goApply = getPackageManager().getLaunchIntentForPackage("com.gau.go.launcherex");
                        if (goApply != null) {
                            intent = new Intent("com.gau.go.launcherex.MyThemes.mythemeaction");
                            intent.putExtra("type", 1);
                            intent.putExtra("pkgname", getPackageName());
                            sendBroadcast(intent);
                            startActivity(goApply);
                            return;
                        }
                        return;
                }
            }
        });


    }
    /*
    Đây là hàm kiểm tra xem launcher có đc cài đặt hay ko
    Hàm trả về kiểu boolean
     */
    @SuppressLint("WrongConstant")
    public static boolean isInstalled(Context context, String packagename) {
        try {
            context.getPackageManager().getApplicationInfo(packagename, 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

