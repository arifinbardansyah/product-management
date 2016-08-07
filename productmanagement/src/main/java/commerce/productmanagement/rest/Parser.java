package commerce.productmanagement.rest;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

//import commerce.productmanagement.utility.RealmString;
//import commerce.productmanagement.utility.RealmStringDeserializer;
//import io.realm.RealmList;
//import io.realm.RealmObject;

//import commerce.productmanagement.display.model.CategoryModel;

/**
 * Created by adamm on 7/14/2016.
 */
public class Parser<E> {

    Gson gson = new Gson();

    public List<E> parse(String json, Class<E> clazz){
        Gson gson = new Gson();

        Type collectionType = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null,List.class,clazz);
        return gson.fromJson(json,collectionType);
    }
}
