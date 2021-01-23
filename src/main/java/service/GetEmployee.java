package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import employee.Employee;
import okhttp3.*;

import java.io.IOException;

public class GetEmployee {

    public static void get() throws IOException {
        Request request = new Request.Builder()
                .url("http://dummy.restapiexample.com/api/v1/employee/1")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        System.out.println(string);
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(string, Employee.class);
        System.out.println(employee.toString());
    }

    public static void AsyncGet() {
        Request request = new Request.Builder()
                .url("http://dummy.restapiexample.com/api/v1/employee/1")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                String string = response.body().string();
                Employee employee = objectMapper.readValue(string, Employee.class);
                System.out.println(employee.toString());

            }

            public void onFailure(Call call, IOException e) {
                System.out.println("Failed to get");
            }
        });
    }



}
