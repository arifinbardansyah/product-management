package commerce.productmanagement.utility;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by adamm on 7/29/2016.
 */
public class Sort {
    public <E extends RealmObject> RealmResults<E> sorting(RealmResults<E> realmResults, Class<E> eClass, String fieldName, boolean ascending) {
        if (!ascending) {
            return realmResults.sort(fieldName, io.realm.Sort.DESCENDING);
        }else{
            return realmResults.sort(fieldName);
        }
    }
}
