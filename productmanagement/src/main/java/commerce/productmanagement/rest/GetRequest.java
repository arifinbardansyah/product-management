package commerce.productmanagement.rest;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by adamm on 7/19/2016.
 */
public class GetRequest extends AsyncRequest {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {
        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);
        Request request = builder.build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
