package vn.hcmute.lab7.adapters;

import android.database.Observable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.hcmute.lab7.R;
import vn.hcmute.lab7.databinding.ItemListUserBinding;
import vn.hcmute.lab7.models.User;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.MyViewHolder> {

    private List<User> userList;
    private OnItemClickListener onItemClickListener;

    public ListUserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ListUserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListUserBinding binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new MyViewHolder(binding, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserAdapter.MyViewHolder holder, int position) {
        holder.setBinding(userList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ObservableField<String> stt = new ObservableField<>();
        public ObservableField<String> firstName = new ObservableField<>();
        public ObservableField<String> lastName = new ObservableField<>();
        private ItemListUserBinding binding;
        private OnItemClickListener onItemClickListener;
        private User user;

        public MyViewHolder(ItemListUserBinding itemView, OnItemClickListener onItemClickListener) {
            super(itemView.getRoot());
            this.binding = itemView;
            this.onItemClickListener = onItemClickListener;
            itemView.getRoot().setOnClickListener(this);
        }

        public void setBinding(User user, int position) {
            if (binding.getViewHolder() == null) {
                binding.setViewHolder(this);
            }
            stt.set(String.valueOf(position + 1));
            firstName.set(user.getFirstName());
            lastName.set(user.getLastName());
        }

        @Override
        public void onClick(View v) {
            this.onItemClickListener.itemClick(user);
        }
    }

    public interface OnItemClickListener {
        void itemClick(User user);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
