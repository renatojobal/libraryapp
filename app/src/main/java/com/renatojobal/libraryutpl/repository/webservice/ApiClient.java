package com.renatojobal.libraryutpl.repository.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * ApiClient provides a retrofit instance for make the call to the server
 */
public class ApiClient {

    // Singleton
    private static Retrofit retrofit = null;


    /**
     * Interceptor that catch the responses and you can do something here, like validate the
     * response code
     */
    private static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            okhttp3.Response response = chain.proceed(request);

            Timber.d("Response code: %s", response.code());
            // Deal with the issues the way we need to
            if (response.code() == 401) {
                // Unauthorized
                // Do something ...
            }


            return response;
        }
    };

    /**
     *
     * @return a retrofit instance to allow build services
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().create();
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(ServiceConstants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
