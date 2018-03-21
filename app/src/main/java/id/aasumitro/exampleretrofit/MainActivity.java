package id.aasumitro.exampleretrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiClient mApiClient = new ApiClient();
    private Button mBtnShow, mBtnHide;
    private TextView mTextFull, mTextDetailOne, mTextDetailTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init View from id
        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        int id = 1;
        loadData(id);
    }

    //Function for find View
    private void initView() {
        mBtnShow = findViewById(R.id.show_details);
        mBtnHide = findViewById(R.id.hide_details);
        mTextFull = findViewById(R.id.full_text);

        //init button onClick function
        btnOnPressed();

    }

    //Function for button pressed
    private void btnOnPressed() {

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnShow.setVisibility(View.GONE);
                mBtnHide.setVisibility(View.VISIBLE);
            }
        });

        mBtnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnHide.setVisibility(View.GONE);
                mBtnShow.setVisibility(View.VISIBLE);
            }
        });

    }

    //Function for get data
    private void loadData(int ID) {

        mApiClient
                .ApiServices()
                .getData(ID)
                .enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(@NonNull Call<JsonObject> call,
                                   @NonNull Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    JsonObject successResponse = response.body();
                    mTextFull.setText(String.valueOf(successResponse));

                } else {

                    ResponseBody errorResponse = response.errorBody();
                    Log.e("ErrorMessage", String.valueOf(errorResponse));

                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call,
                                  @NonNull Throwable t) {
                t.printStackTrace();
            }

        });

    }

}
