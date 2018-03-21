package id.aasumitro.exampleretrofit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Agus Adhi Sumitro on 06/03/2018.
 * https://asmith.my.id
 * aasumitro@gmail.com
 */

interface ApiService {

    @GET("detail")
    Call<JsonObject> getData(@Query("id") int ArticleID);

}
