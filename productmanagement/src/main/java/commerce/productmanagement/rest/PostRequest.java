package commerce.productmanagement.rest;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostRequest extends AsyncRequest {
    String param;
    String value;
    OkHttpClient client = new OkHttpClient();

    public PostRequest(String param, String value) {
        this.param = param;
        this.value = value;
    }

    @Override
    protected String doInBackground(String... params) {
        RequestBody body = new FormBody.Builder()
                .add(param, value).build();
        Request request = new Request.Builder()
                .url(params[0]).post(body).build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code" + response.toString());
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
