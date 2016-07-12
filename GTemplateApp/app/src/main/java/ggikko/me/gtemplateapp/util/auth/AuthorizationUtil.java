package ggikko.me.gtemplateapp.util.auth;

import android.content.SharedPreferences;

/**
 * Created by admin on 16. 7. 12..
 */
public class AuthorizationUtil {

    private SharedPreferences mSharedPreferences;

    /**
     * SHARED INJECTION FROM APP CONFIG
     * @param sharedPreferences
     */
    public AuthorizationUtil(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    /**
     * get token for LONG TOKEN
     * @return
     */
    public String getToken() {
        return mSharedPreferences.getString("accessToken", "accessToken");
    }

    /**
     * login checking
     * @return
     */
    public boolean isLogin() {
        String accessToken = mSharedPreferences.getString("accessToken", "accessToken");
        if (!accessToken.equals("accessToken")) return true;
        return false;
    }

    /**
     * 토큰 remove for logout
     */
    public void removeToken(){
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString("accessToken", "accessToken");
        edit.commit();
    }
}
