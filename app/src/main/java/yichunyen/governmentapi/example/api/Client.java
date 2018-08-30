package yichunyen.governmentapi.example.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yichun on 8/28/18.
 */

public class Client {
    private static Endpoint endpoint;
    private static OkHttpClient okHttpClient;

    private static String url = "http://data.taipei/opendata/";
    public static Endpoint getInterface() {
        if (endpoint == null) {
            Retrofit retrofit =
                        new Retrofit.Builder()
                                .baseUrl(url)
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(getOkHttpClient())
                                .build();

            endpoint = retrofit.create(Endpoint.class);
        }
        return endpoint;
    }


    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }

        return okHttpClient;
    }
}
