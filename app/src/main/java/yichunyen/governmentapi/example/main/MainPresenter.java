package yichunyen.governmentapi.example.main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yichunyen.governmentapi.example.api.Client;
import yichunyen.governmentapi.example.api.ParkItemResponse;

/**
 * Created by yichun on 8/31/18.
 */

public class MainPresenter implements MainMvpView.Presenter {
    private String scope = "resourceAquire";
    private String rid = "bf073841-c734-49bf-a97f-3757a6013812";
    private MainMvpView.View mainMvpView;

    public MainPresenter(MainMvpView.View mainMvpView) {
        this.mainMvpView = mainMvpView;
        mainMvpView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchParkData();
    }

    @Override
    public void stop() {

    }

    private void fetchParkData() {
        Client.getInterface().getParkList(scope, rid).enqueue(new Callback<ParkItemResponse>() {
            @Override
            public void onResponse(Call<ParkItemResponse> call, Response<ParkItemResponse> response) {
                if (response.body() != null)
                    mainMvpView.updateData(response.body().getResults());
                else
                    mainMvpView.showErrorToast();
            }

            @Override
            public void onFailure(Call<ParkItemResponse> call, Throwable t) {
                mainMvpView.showErrorToast();
            }
        });
    }
}
