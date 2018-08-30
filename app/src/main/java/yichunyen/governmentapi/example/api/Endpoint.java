package yichunyen.governmentapi.example.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yichun on 8/28/18.
 */

public interface Endpoint {
    // scope=resourceAquire
    // rid=bf073841-c734-49bf-a97f-3757a6013812
    @GET("datalist/apiAccess")
    Call<ParkItemResponse> getParkList(
            @Query("scope") String scope,
            @Query("rid") String rid);

}
