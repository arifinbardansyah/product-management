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
 * Kelas Controller untuk get atau post data dari API, set layout recycler view dan display data
 * @param <E> parameter kelas model
 */
public class Controller<E> {
    private GetRequest getRequest;
    private Parser parser;
    private PostRequest postRequest;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * method untuk set layout manager recycler view. grid layout atau linear layout
     * @param context parameter context dari activity
     * @param layout int layout. 0 untuk linear layout, 1 untuk grid layout
     */
    public void setLayout(Context context, int layout){
        if (layout == 0){
            this.layoutManager = new LinearLayoutManager(context);
        }
        if (layout == 1){
            this.layoutManager = new GridLayoutManager(context, 2);
        }
    }

    /**
     * method untuk request data menggunakan method get dan parsing data
     * @param url parameter url untuk request get data dari API
     * @param model model untuk mapping data response dengan object model
     * @return mereturnkan data response yang telah diparsing berbentuk List
     * @throws ExecutionException penanganan error gagal eksekusi
     * @throws InterruptedException penanganan error interupsi
     */
    public List<E> getData(String url, Class<E> model) throws ExecutionException, InterruptedException {
        getRequest = new GetRequest();
        String result = getRequest.execute(url).get();
        parser = new Parser();
        return parser.parse(result, model);
    }

    /**
     * method untuk request data menggunakan method post dan parsing data
     * @param url parameter url untuk request post dari API
     * @param parameter parameter yg akan di request post
     * @param value parameter value yg akan di request post
     * @param model model untuk mapping data response dengan object model
     * @return mereturnkan data response yg telah diparsing berbentuk List
     * @throws ExecutionException penanganan error gagal eksekusi
     * @throws InterruptedException penanganan error interupsi
     */
    public List<E> postData(String url, String parameter, String value, Class<E> model) throws ExecutionException, InterruptedException {
        postRequest = new PostRequest(parameter,value);
        String result = postRequest.execute(url).get();
        parser = new Parser();
        return parser.parse(result, model);
    }

    /**
     * method untuk menampilkan data yg berbentuk List. membutuhkan model dan view untuk dipetakan kedalam recycler view
     * @param data data yg akan ditampilkan berbentuk List
     * @param model model dari data yang akan ditampilkan
     * @param view kelas view dari extends Display
     * @param recyclerView recycler view untuk menampilkan data
     * @param viewEventListener listener saat tampilan data di click
     */
    public void displayData(List<E> data, Class<E> model, Class<? extends BindableFrameLayout> view, RecyclerView recyclerView, ViewEventListener viewEventListener){
        recyclerView.setLayoutManager(layoutManager);
        SmartAdapter.items(data).map(model,view).listener(viewEventListener).into(recyclerView);
    }

}
