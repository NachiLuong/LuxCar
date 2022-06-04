package com.luxcar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.luxcar.R;
import com.luxcar.activities.admin.fragment.UserActivity;
import com.luxcar.models.entities.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    UserActivity context;
    int layout;
    List<User> list;

    public UserAdapter(UserActivity context, int layout, List<User> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private static class ViewHolder {
        TextView email, password, name, phone, address, dob;
        RadioGroup rdgSex, rdgRole;
        ImageView imgEdit, imgDelete;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

            viewHolder.imgDelete = view.findViewById(R.id.adminItemDelete);
            viewHolder.imgEdit= view.findViewById(R.id.adminItemEdit);
            viewHolder.name = view.findViewById(R.id.adminItemDown);
            viewHolder.email = view.findViewById(R.id.adminItemTop);

            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        User user = list.get(i);


        viewHolder.name.setText(user.getName());
        viewHolder.email.setText(user.getEmail());

        viewHolder.imgEdit.setOnClickListener(view12 ->
                context.dialogUpdate(user.getEmail(), user.getName(), user.getPassword(),
                        user.getPhone(), user.getAddress(), user.getDob() ,user.getId())
        );
        viewHolder.imgDelete.setOnClickListener(view1 ->
                context.dialogDelete(user.getName(), user.getId())
        );
        return view;
    }
}
