package commerce.productmanagement.utility;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by adamm on 7/29/2016.
 */
public class Search {
    public <E extends RealmObject> RealmResults<E> searchingOR(Realm realm, Class<E> eClass, String... params) {
        RealmQuery<E> query = realm.where(eClass);
        query.contains(params[0], params[params.length-1], Case.INSENSITIVE);
        if (params.length > 2) {
            for (int i = 1; i < params.length-2; i++)
                query.or().contains(params[i], params[params.length],Case.INSENSITIVE);
        }
        return query.findAll();
    }
    public <E extends RealmObject> RealmResults<E> searchingAND(Realm realm, Class<E> eClass, String... params) {
        RealmQuery<E> query = realm.where(eClass);
        query.contains(params[0], params[params.length-1], Case.INSENSITIVE);
        if (params.length > 2) {
            for (int i = 1; i < params.length-2; i++)
                query.contains(params[i], params[params.length],Case.INSENSITIVE);
        }
        return query.findAll();
    }

//    public <E> List<E> searching(Realm realm){
//
//    }
//    public <E> List<E> searching(List<E> list, Object param, String key){
//        for (E e:list){
//
//        }
//        return
//    }
}