package vn.hcmute.lab7.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vn.hcmute.lab7.PrefManager;
import vn.hcmute.lab7.R;

public class SharedPrefActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    CheckBox cbRememberMe;
    SharedPreferences sharePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        MappingElement();

        sharePreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
    }

    private void MappingElement() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtUsername = (EditText) findViewById(R.id.usernameTxt);
        edtPassword = (EditText) findViewById(R.id.passwordTxt);
        cbRememberMe = (CheckBox) findViewById(R.id.cbrememberme);
    }

    private void attemptLogin() {
        edtUsername.setError(null);
        edtPassword.setError(null);

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            edtPassword.setError(getString(R.string.error_invalid_password));
            focusView = edtPassword;
            cancel = true;
        }
        if (TextUtils.isEmpty(username)) {
            edtUsername.setError(getString(R.string.error_field_required));
            focusView = edtUsername;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            if (cbRememberMe.isChecked()) {
                saveLoginDetails(username, password, true);
            } else {
                saveLoginDetails(username, "", false);
            }
            Toast.makeText(SharedPrefActivity.this, "Login success", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
    private void saveLoginDetails(String username, String password, boolean checked) {
        new PrefManager(this).saveLoginDetails(username, password, checked);
    }
}