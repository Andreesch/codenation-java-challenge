package com.codenation.challenge.caesarcrypto.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.HttpUrl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class OkHttpHelperService {

    private OkHttpClient okHttpClient = new OkHttpClient();

    public String doGetRequestSync(String url, Map<String, String> parameters) throws IOException {
        Request request = new Request.Builder()
                .url(buildURLWithParameters(url, parameters))
                .build();

        Response response = okHttpClient.newCall(request)
                .execute();

        return response.body().string();
    }

    private String buildURLWithParameters(String url, Map<String, String> parameters) {
        Builder urlBuilder = HttpUrl.parse(url)
                .newBuilder();

        parameters.forEach(urlBuilder::addQueryParameter);

        return urlBuilder.build().toString();
    }
}
