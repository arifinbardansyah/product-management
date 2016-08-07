package commerce.productmanagement.utility;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * kelas search untuk pencarian data dari database
 * @param <E> parameter kelas model extends RealmObject
 */
public class Search<E extends RealmObject> {
    /**
     * method search digunakan untuk pencarian data dari database menggunakan realm
     * @param realm inisialisasi realm
     * @param model kelas model extends realm object
     * @param params parameter searching. string pertama dan seterusnya untuk parameter. string terakhir untuk value dari parameter
     * @return method ini akan mereturnkan data hasil filtering berbentuk RealmResults
     */
    public RealmResults<E> searching(Realm realm, Class<E> model, String... params) {
        RealmQuery<E> query = realm.where(model);
        query.contains(params[0], params[params.length-1], Case.INSENSITIVE);
        if (params.length > 2) {
            for (int i = 1; i < params.length-2; i++)
                query.or().contains(params[i], params[params.length],Case.INSENSITIVE);
        }
        return query.findAll();
    }
}
