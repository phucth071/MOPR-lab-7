package vn.hcmute.lab7.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.lab7.R;
import vn.hcmute.lab7.adapters.ListUserAdapter;
import vn.hcmute.lab7.databinding.ActivityHomeBinding;
import vn.hcmute.lab7.models.User;

public class HomeActivity extends AppCompatActivity {

    public ObservableField<String> title = new ObservableField<>();
    private ListUserAdapter listUserAdapter;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        title.set("Vi du ve DataBinding cho RecyclerView");
        binding.setHome(this);
        setData();
        listUserAdapter.setOnItemClickListener(
                new ListUserAdapter.OnItemClickListener() {
                    @Override
                    public void itemClick(User user) {
                        Toast.makeText(getApplicationContext(), "bạn vừa click", Toast.LENGTH_SHORT).show();
                    }

                }
        );
        binding.rvListUser.setLayoutManager(new LinearLayoutManager(this));
        binding.rvListUser.setAdapter(listUserAdapter);
    }

    private void setData() {
        List<User> listUser = new ArrayList<>();

        for (int i=0; i < 10; i++) {
            User user = new User();
            user.setFirstName("Hoang Phuc " + i);
            user.setLastName("Tran");
            listUser.add(user);
        }

        listUserAdapter = new ListUserAdapter(listUser);
    }

}