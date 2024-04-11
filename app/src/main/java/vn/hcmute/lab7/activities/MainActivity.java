package vn.hcmute.lab7.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import vn.hcmute.lab7.R;
import vn.hcmute.lab7.databinding.ActivityMainBinding;
import vn.hcmute.lab7.models.User;

public class MainActivity extends AppCompatActivity {

    private User userModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userModel = new User("Hoang Phuc", "Tran");
        binding.setUser(userModel);
    }
}