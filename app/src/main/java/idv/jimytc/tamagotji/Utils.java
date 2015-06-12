package idv.jimytc.tamagotji;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.Executor;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by jimytc on 6/12/15.
 */
public class Utils {
    private static final Gson sGson = new Gson();
    private static JiService sJiService;

    // Executors
    public static Executor sUiThreadExecutor = new Executor() {

        @Override
        public void execute(Runnable command) {
            new Handler(Looper.getMainLooper()).post(command);
        }
    };

    public static JiService getJiService() {
        if (sJiService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Consts.TAMA_HOST)
                    .setConverter(new GsonConverter(sGson))
                    .build();

            sJiService = restAdapter.create(JiService.class);
        }
        return sJiService;
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

    public static void saveJi(Context context, JiModel ji) {
        getSharedPreference(context).edit().putString(Consts.PREF_JI_ID, ji.mId).apply();
    }

    public static String getJiId(Context context) {
        return getSharedPreference(context).getString(Consts.PREF_JI_ID, null);
    }
}
