package gml.template.androidtemplate;

import android.app.Application;
import android.graphics.Typeface;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.norbsoft.typefacehelper.TypefaceCollection;
import com.norbsoft.typefacehelper.TypefaceHelper;
import com.squareup.leakcanary.LeakCanary;

import gml.template.androidtemplate.tools.util.AppConstants;

/**
 * Application
 * Created by gml on 2015/9/12.
 */
public class MyApplication extends Application {
    private static RequestQueue requestQueue;
    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        initTypeface();
        LeakCanary.install(this);
        Fresco.initialize(this);
        instance = this;
    }

    /**
     * 初始化APP字体
     */
    private void initTypeface() {
        // Initialize typeface helper
        TypefaceCollection typeface = new TypefaceCollection.Builder()
                .set(Typeface.NORMAL, Typeface.createFromAsset(getAssets(), AppConstants.ASSETS_FONTS))
                .create();
        TypefaceHelper.init(typeface);
    }

    /**
     * 获取RequestQueue
     * @return
     */
    public static RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueueOkHttp(instance);
        return requestQueue;
    }
}
