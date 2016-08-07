package commerce.productmanagement.utility;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * kelas sort untuk pengurutan data dari database
 * @param <E> parameter kelas model extends RealmObject
 */
public class Sort<E extends RealmObject> {
    /**
     * method sorting digunakan untuk penurutan data dari database
     * @param realmResults data RealmResults yg akan diurutkan
     * @param model kelas model extends RealmObject
     * @param fieldName parameter untuk pengurutan
     * @param ascending jika true maka ascending, jika false maka descending
     * @return method ini akan mereturnkan RealmResults hasil pengurutan
     */
    public RealmResults<E> sorting(RealmResults<E> realmResults, Class<E> eClass, String fieldName, boolean ascending) {
        if (!ascending) {
            return realmResults.sort(fieldName, io.realm.Sort.DESCENDING);
        }else{
            return realmResults.sort(fieldName);
        }
    }
}
