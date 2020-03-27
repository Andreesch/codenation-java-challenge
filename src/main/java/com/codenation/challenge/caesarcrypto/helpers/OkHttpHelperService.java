package com.codenation.challenge.caesarcrypto.helpers;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.HttpUrl.Builder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
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

    public String doChallengePostRequestSync(String url, String fileURL, Map<String, String> parameters) {
        Request request = new Request.Builder()
                .url(buildURLWithParameters(url, parameters))
                .post(createSendChallengeRequestBody(fileURL))
                .build();

        try {
            Response response = okHttpClient.newCall(request)
                    .execute();

            System.out.println(response);
            System.out.println(response.body().string());

            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public RequestBody createSendChallengeRequestBody(String file) {
        File answer = new File(file);

        return new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addFormDataPart("answer", "answer", RequestBody.create(MediaType.parse("application/json"), answer))
                .build();
    }

    private String buildURLWithParameters(String url, Map<String, String> parameters) {
        Builder urlBuilder = HttpUrl.parse(url)
                .newBuilder();

        parameters.forEach(urlBuilder::addQueryParameter);

        return urlBuilder.build().toString();
    }
}
