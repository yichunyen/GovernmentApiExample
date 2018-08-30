package yichunyen.governmentapi.example.main;

import java.util.ArrayList;

import yichunyen.governmentapi.example.Base;
import yichunyen.governmentapi.example.adapter.ParkItem;

/**
 * Created by yichun on 8/30/18.
 */

public interface MainMvpView {
    interface View extends Base.View<Presenter> {
        void showErrorToast();

        void updateData(ArrayList<ParkItem> list);
    }

    interface Presenter extends Base.Presenter {
    }
}
