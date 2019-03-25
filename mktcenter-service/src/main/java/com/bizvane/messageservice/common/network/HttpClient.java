package com.bizvane.messageservice.common.network;

import okhttp3.*;
import okhttp3.Request.Builder;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: lijunwei
 * @Time: 2018/7/16 22:07
 */
@Component
public class HttpClient {
    OkHttpClient okHttpClient = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public HttpClient() {
    }

    public Response get(String url) throws IOException {
        Request request = (new Builder()).url(url).build();
        Response response = this.okHttpClient.newCall(request).execute();
        return response;
    }

    public Response post(Request request) throws IOException {
        Response response = this.okHttpClient.newCall(request).execute();
        return response;
    }

    public Response Post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = (new Builder()).url(url).post(body).build();
        Response response = this.okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public Response delete(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = (new Builder()).url(url).delete(body).build();
        Response response = this.okHttpClient.newCall(request).execute();
        return response;
    }

    public Response put(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = (new Builder()).url(url).put(body).build();
        Response response = this.okHttpClient.newCall(request).execute();
        return response;
    }
}
