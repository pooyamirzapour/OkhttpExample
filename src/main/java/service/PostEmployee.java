package service;

import okhttp3.*;

import java.io.IOException;

public class PostEmployee {

    public static void post()
            throws IOException {
        RequestBody formBody = new FormBody.Builder()
//                .add("username", "test")
//                .add("password", "test")
                .build();

        Request request = new Request.Builder()
                .url("http://dummy.restapiexample.com/api/v1/create")
                .post(formBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response);

    }
}
