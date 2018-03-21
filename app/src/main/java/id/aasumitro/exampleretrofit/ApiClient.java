package id.aasumitro.exampleretrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Agus Adhi Sumitro on 06/03/2018.
 * https://asmith.my.id
 * aasumitro@gmail.com
 */

class ApiClient {

    private OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private Retrofit provideRetrofit() {
        String API_URL = "http://192.168.43.70/a-rp/droidapi-v1/public/v1/content/article/";
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }

    ApiService ApiServices() {
        return provideRetrofit()
                .create(ApiService.class);
    }

}
