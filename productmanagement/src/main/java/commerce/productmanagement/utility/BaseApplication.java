package commerce.productmanagement.utility;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * kelas application digunakan pada manifest application name untuk konfigurasi database realm
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
