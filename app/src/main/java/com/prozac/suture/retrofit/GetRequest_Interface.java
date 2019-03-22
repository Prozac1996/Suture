package com.prozac.suture.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface GetRequest_Interface {
    /**
     * 拼接参数
     * @param id
     * @return
     */
    @HTTP(method = "GET",path = "/haha/{id}",hasBody = false)
    Call<ResponseBody> getBody(@Path("id") int id);

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();

    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    @FormUrlEncoded
    Call<Translation1> getCall(@Field("i") String targetSentence);
}
