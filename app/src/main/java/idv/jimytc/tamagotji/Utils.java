package idv.jimytc.tamagotji;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import retrofit.RestAdapter;

/**
 * Created by jimytc on 6/12/15.
 */
public class Utils {
    private static RestAdapter sRestAdapter;

    public static RestAdapter getRestAdapter() {
        if (sRestAdapter == null) {
            sRestAdapter = new RestAdapter.Builder()
                    .setEndpoint(Consts.TAMA_HOST)
                    .build();
        }
        return sRestAdapter;
    }

    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(Consts.PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void showToast(Context context, int resId) {
        showToast(context, context.getString(resId));
    }
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
