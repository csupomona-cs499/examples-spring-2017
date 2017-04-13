package edu.cpp.l04_ui_listview;

/**
 * Created by yusun on 4/12/17.
 */

public class PhoneType {

    private String name;
    private boolean isCompatible;

    public PhoneType(String name, boolean isCompatible) {
        this.name = name;
        this.isCompatible = isCompatible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompatible() {
        return isCompatible;
    }

    public void setCompatible(boolean compatible) {
        isCompatible = compatible;
    }
}
