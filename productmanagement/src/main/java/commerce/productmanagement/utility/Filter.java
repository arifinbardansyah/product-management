package commerce.productmanagement.utility;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * kelas filter untuk filter data dari database.
 * @param <E> parameter kelas model extends RealmObject
 */
public class Filter<E extends RealmObject> {
    /**
     * method filter dengan OR logic digunakan untuk filter data dari database menggunakan realm
     * @param realm inisialisasi realm
     * @param model kelas model realm object
     * @param params parameter untuk filter. string pertama untuk parameter, kedua untuk value dan seterusnya
     * @return method ini akan mereturnkan data hasil filtering berbentuk RealmResults
     */
    public RealmResults<E> filterOR(Realm realm, Class<E> model, String... params) {
        RealmQuery<E> query = realm.where(model);
        query.contains(params[0], params[1], Case.INSENSITIVE);
        if (params.length > 1) {
            for (int i = 3; i < params.length; i++)
                query.or().contains(params[i-1], params[i],Case.INSENSITIVE);
        }
        return query.findAll();
    }

    /**
     * method filter dengan AND logic digunakan untuk filter data dari database menggunakan realm
     * @param realm inisialisasi realm
     * @param model kelas model realm object
     * @param params parameter untuk filter. string pertama untuk parameter, kedua untuk value dan seterusnya
     * @return method ini akan mereturnkan data hasil filtering berbentuk RealmResults
     */
    public RealmResults<E> filterAND(Realm realm, Class<E> model, String... params) {
        RealmQuery<E> query = realm.where(model);
        query.contains(params[0], params[1], Case.INSENSITIVE);
        if (params.length > 1) {
            for (int i = 3; i < params.length; i++)
                query.or().contains(params[i-1], params[i],Case.INSENSITIVE);
        }
        return query.findAll();
    }
}
