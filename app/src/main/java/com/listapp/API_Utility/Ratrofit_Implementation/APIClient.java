package com.listapp.API_Utility.Ratrofit_Implementation;

import android.util.Base64;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nivesh on 6/24/2017.
 */

public class APIClient {

    private static Retrofit retrofit = null;

    private final static String BASE_URL = "https://listapp.in";

    public static Retrofit getClient() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();

        logInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(240, TimeUnit.SECONDS)
                .connectTimeout(180,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                String credentials = "syscraft" + ":" + "sis123";
                final String basic =
                        "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization",basic); // <-- this is the important line

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        }).addInterceptor(logInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
