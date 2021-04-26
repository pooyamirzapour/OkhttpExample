package service;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostEmployee {

    public static void post()
            throws IOException {
        RequestBody formBody = new FormBody.Builder()
//                .add("username", "test")
//                .add("password", "test")
                .build();

        Map<String , String> header = new HashMap<String, String>();
        Headers headerbuild = Headers.of(header);
        Request request = new Request.Builder()
                .url("http://dummy.restapiexample.com/api/v1/create")
                .post(formBody)
                .headers(headerbuild)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());

    }
}
