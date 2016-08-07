package commerce.productmanagement.utility;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by adamm on 7/29/2016.
 */
public class Filter<E extends RealmObject> {
    public RealmResults<E> filterOR(Realm realm, Class<E> eClass, String... params) {
        RealmQuery<E> query = realm.where(eClass);
        query.contains(params[0], params[1], Case.INSENSITIVE);
        if (params.length > 1) {
            for (int i = 3; i < params.length; i++)
                query.or().contains(params[i-1], params[i],Case.INSENSITIVE);
        }
        return query.findAll();
    }
    public RealmResults<E> filterAND(Realm realm, Class<E> eClass, String... params) {
        RealmQuery<E> query = realm.where(eClass);
        query.contains(params[0], params[1], Case.INSENSITIVE);
        if (params.length > 1) {
            for (int i = 3; i < params.length; i++)
                query.or().contains(params[i-1], params[i],Case.INSENSITIVE);
        }
        return query.findAll();
    }
}
