package commerce.productmanagement.rest;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

public class Parser<E> {

    Gson gson = new Gson();

    public List<E> parse(String json, Class<E> clazz){
        Gson gson = new Gson();

        Type collectionType = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null,List.class,clazz);
        return gson.fromJson(json,collectionType);
    }
}
