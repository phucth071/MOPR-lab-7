package vn.hcmute.lab7;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    Context context;

    public PrefManager(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String username, String password, boolean checked) {
        context.getSharedPreferences("dataLogin", Context.MODE_PRIVATE)
                .edit()
                .putString("username", username)
                .putString("password", password)
                .putBoolean("checked", checked)
                .apply();
    }

    public String getUsername() {
        return context.getSharedPreferences("dataLogin", Context.MODE_PRIVATE)
                .getString("username", "");
    }

    public String getPassword() {
        return context.getSharedPreferences("dataLogin", Context.MODE_PRIVATE)
                .getString("password", "");
    }

    public boolean getChecked() {
        return context.getSharedPreferences("dataLogin", Context.MODE_PRIVATE)
                .getBoolean("checked", false);
    }

    public boolean isUserLogout() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("dataLogin", Context.MODE_PRIVATE);
        boolean isUserNameEmpty = sharedPreferences.getString("username", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("password", "").isEmpty();
        return isUserNameEmpty || isPasswordEmpty;
    }
}
