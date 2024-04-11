package vn.hcmute.lab7.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.hcmute.lab7.R;
import vn.hcmute.lab7.models.NotesModel;

public class NotesAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<NotesModel> notesList;

    public NotesAdapter(Context context, int layout, List<NotesModel> notesList) {
        this.context = context;
        this.layout = layout;
        this.notesList = notesList;
    }

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Object getItem(int position) {
        return notesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return notesList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, layout, null);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        NotesModel notes = notesList.get(position);
        holder.tvTitle.setText(notes.getContent());
        return convertView;
    }

    private class ViewHolder {
        TextView tvTitle;
    }
}
