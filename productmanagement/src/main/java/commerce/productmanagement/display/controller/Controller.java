package commerce.productmanagement.display.controller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import commerce.productmanagement.rest.GetRequest;
import commerce.productmanagement.rest.Parser;
import commerce.productmanagement.rest.PostRequest;
import io.nlopez.smartadapters.SmartAdapter;
import io.nlopez.smartadapters.utils.ViewEventListener;
import io.nlopez.smartadapters.views.BindableFrameLayout;

/**
 * Created by adamm on 7/29/2016.
 */
public class Controller {

    public <E> List<E> getData(String url, Class<E> model) throws ExecutionException, InterruptedException {
        GetRequest getRequest = new GetRequest();
        String result = getRequest.execute(url).get();
        Parser parser = new Parser();
        return parser.parse(result, model);
    }
    public <E> List<E> postData(String url, String parameter, String value, Class<E> model) throws ExecutionException, InterruptedException {
        PostRequest postRequest = new PostRequest(parameter,value);
        String result = postRequest.execute(url).get();
        Parser parser = new Parser();
        return parser.parse(result, model);
    }
    public <E> void displayData(Context context, List<E> data, Class<E> model, Class<? extends BindableFrameLayout> view, RecyclerView recyclerView, ViewEventListener viewEventListener){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        SmartAdapter.items(data).map(model,view).listener(viewEventListener).into(recyclerView);
    }

}
