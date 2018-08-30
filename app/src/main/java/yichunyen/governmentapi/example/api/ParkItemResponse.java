package yichunyen.governmentapi.example.api;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

import yichunyen.governmentapi.example.adapter.ParkItem;

/**
 * Created by yichun on 8/29/18.
 */

public class ParkItemResponse {
    @Expose
    private Result result;

    public ArrayList<ParkItem> getResults() {
        return result == null ? new ArrayList<ParkItem>() : result.results;
    }

    class Result {
        @Expose
        private ArrayList<ParkItem> results;
    }

}
