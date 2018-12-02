package com.example.hanprovip.cloneiconpack;

public class LauncherInfo {
    private String Label;
    private String PackageName;
    private int ResID;

    public LauncherInfo(String label, String packageName, int resID) {
        Label = label;
        PackageName = packageName;
        ResID = resID;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public int getResID() {
        return ResID;
    }

    public void setResID(int resID) {
        ResID = resID;
    }
}
