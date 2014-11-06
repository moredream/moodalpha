package com.comfyard.moodalpha.custom;

/**
 * Created by moredream on 11/6/14.
 */
public class DrawerItem {
    private String ItemName;
    private int imgResID;

    public DrawerItem(String itemName, int imgResID) {
        super();
        this.ItemName = itemName;
        this.imgResID = imgResID;
    }

    public String getItemName() {
        return ItemName;
    }
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    public int getImgResID() {
        return imgResID;
    }
    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }
}
