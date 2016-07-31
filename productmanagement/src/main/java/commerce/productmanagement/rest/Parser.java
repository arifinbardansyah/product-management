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
public class Parser {

    Gson gson = new Gson();

    public <E> List<E> parse(String json, Class<E> clazz){
        Gson gson = new Gson();

        Type collectionType = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null,List.class,clazz);
        return gson.fromJson(json,collectionType);
    }


//    public <E> List<E> realmParse(String json, Class<E> clazz){
//        GsonBuilder gsonBuilder = new GsonBuilder()
//                .setExclusionStrategies(new ExclusionStrategy() {
//                    @Override
//                    public boolean shouldSkipField(FieldAttributes f) {
//                        return f.getDeclaringClass().equals(RealmObject.class);
//                    }
//
//                    @Override
//                    public boolean shouldSkipClass(Class<?> clazz) {
//                        return false;
//                    }
//                });
//// register the deserializer
//        gsonBuilder.registerTypeAdapter(new TypeToken<RealmList<RealmString>>() {
//        }.getType(), new RealmStringDeserializer());
//
//        Gson gson = gsonBuilder.create();
//// parse the Json
//        return (List<E>) gson.fromJson(json, clazz);
//    }
}
