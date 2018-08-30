package yichunyen.governmentapi.example.adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yichun on 8/29/18.
 */

public class ParkItem {
    @Expose
    @SerializedName("ParkName")
    private String parkName;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Image")
    private String url;

    public String getParkName() {
        return parkName;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
