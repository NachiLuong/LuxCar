package com.luxcar.activities.admin.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luxcar.R;
import com.luxcar.adapters.UserAdapter;
import com.luxcar.configurations.DatabaseOpenHelper;
import com.luxcar.models.entities.User;
import com.luxcar.repositories.impls.UserRepository;

import java.util.List;



public class UserActivity extends Fragment  {
    List<User> users;
    UserAdapter adapter;
    DatabaseOpenHelper databaseOpenHelper;

    ListView lv;
    EditText txtSearch;
    ImageView imgSearch;
    Button btnAdd;
    private View userView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        userView= inflater.inflate(R.layout.admin_fragment_user, container,false);
        createComponents();
        createEvents();
        getData();
        return userView;
    }

    private void createComponents() {
        lv = userView.findViewById(R.id.lvUser);
        txtSearch = userView.findViewById(R.id.txtSearch);
        imgSearch = userView.findViewById(R.id.imgSearch);
        btnAdd = userView.findViewById(R.id.btnAdd);
    }
    private void createEvents() {
    }
    private void getData(){
        users = UserRepository.instance().findAll();
        adapter = new UserAdapter(this, R.layout.admin_single_item, users);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
      /*  try {
            Cursor users = databaseOpenHelper.GetData("SELECT * FROM user");
            arrayList.clear();
            while (users.moveToNext()){
                String name= users.getString(1);
                String email= users.getString(2);
                arrayList.add(new User(name, email));
            }
            adapter.notifyDataSetChanged();
        }catch (Exception e){
            System.out.println(e);
        }*/

    }
//    public void dialogUpdate(){
//
//    }
}
