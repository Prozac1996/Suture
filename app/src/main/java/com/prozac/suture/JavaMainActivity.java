package com.prozac.suture;

import android.app.Activity;
import android.os.Bundle;
import com.prozac.suture.retrofit.GetRequest_Interface;
import com.prozac.suture.retrofit.Translation;
import com.prozac.suture.retrofit.Translation1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JavaMainActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request();

    }

    private void request() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(("http://fanyi.youdao.com/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetRequest_Interface requst = retrofit.create(GetRequest_Interface.class);

        Call<Translation1> call = requst.getCall("love");

        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {
                System.out.println("连接失败");
            }
        });
    }
}
