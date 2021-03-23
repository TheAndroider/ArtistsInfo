package com.generalmotors.artists;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpClient {
    private static class InstanceHolder {
        private static final long SVC_TIMEOUT_SEC = 30;
        private volatile static OkHttpClient okHttpClient;

        /**
         * Gets instance (prod).
         *
         * @return the instance
         */
        public static OkHttpClient getInstance() {
            if (okHttpClient == null) {
                // Logging Interceptor for Request/Response Headers and Body
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.d("REST Service" ,message));
                // Logs request and response lines and their respective headers and bodies (if present)
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                okHttpClient = builder.connectTimeout(SVC_TIMEOUT_SEC, TimeUnit.SECONDS).readTimeout(SVC_TIMEOUT_SEC, TimeUnit.SECONDS).writeTimeout(SVC_TIMEOUT_SEC, TimeUnit.SECONDS).addInterceptor(interceptor).build();
            }

            return okHttpClient;
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static OkHttpClient getInstance() {
        return InstanceHolder.getInstance();
    }
}
