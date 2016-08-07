package commerce.productmanagement.display.controller;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
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
public class Controller<E> {
    private GetRequest getRequest;
    private Parser parser;
    private PostRequest postRequest;
    private RecyclerView.LayoutManager layoutManager;

    public void setLayout(Context context, int layout){
        if (layout == 0){
            this.layoutManager = new LinearLayoutManager(context);
        }
        if (layout == 1){
            this.layoutManager = new GridLayoutManager(context, 2);
        }
    }

    public List<E> getData(String url, Class<E> model) throws ExecutionException, InterruptedException {
        getRequest = new GetRequest();
        String result = getRequest.execute(url).get();
        parser = new Parser();
        return parser.parse(result, model);
    }
    public List<E> postData(String url, String parameter, String value, Class<E> model) throws ExecutionException, InterruptedException {
        postRequest = new PostRequest(parameter,value);
        String result = postRequest.execute(url).get();
        parser = new Parser();
        return parser.parse(result, model);
    }
    public void displayData(Context context, List<E> data, Class<E> model, Class<? extends BindableFrameLayout> view, RecyclerView recyclerView, ViewEventListener viewEventListener){
        recyclerView.setLayoutManager(layoutManager);
        SmartAdapter.items(data).map(model,view).listener(viewEventListener).into(recyclerView);
    }

}
