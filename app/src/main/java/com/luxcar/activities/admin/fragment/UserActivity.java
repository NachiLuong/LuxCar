package com.luxcar.activities.admin.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.luxcar.R;
import com.luxcar.adapters.UserAdapter;
import com.luxcar.configurations.DatabaseOpenHelper;
import com.luxcar.models.entities.User;
import com.luxcar.models.types.Gender;
import com.luxcar.models.types.Role;
import com.luxcar.models.types.Status;
import com.luxcar.repositories.impls.UserRepository;
import com.luxcar.services.UserService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        btnAdd.setOnClickListener(v -> {
            Dialog dialog= new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.admin_user_editadd);
            Button btnHuy = dialog.findViewById(R.id.btnAdminCancel);
            Button btnEdit = dialog.findViewById(R.id.btnAdminSave);
            EditText cemail = dialog.findViewById(R.id.etAdminEmail);
            EditText cpass = dialog.findViewById(R.id.etAdminPassword);
            EditText cname = dialog.findViewById(R.id.etAdminName);
            EditText cphone = dialog.findViewById(R.id.etAdminPhone);
            EditText caddress = dialog.findViewById(R.id.etAdminAddress);


            btnHuy.setOnClickListener(view -> {
                dialog.dismiss();
            });
            btnEdit.setOnClickListener(view -> {
                String newEmail = cemail.getText().toString();
                String newName = cname.getText().toString();
                String newPass = cpass.getText().toString();
                String newPhone = cphone.getText().toString();
                String newAddress = caddress.getText().toString();


                if (TextUtils.isEmpty(newEmail) || TextUtils.isEmpty(newName)){
                    Toast.makeText(getActivity(), "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    return;
                }
                User user = new User(newEmail,newPass, newName, Gender.FEMALE,
                        Timestamp.valueOf("2021-03-24 16:48:05.591"),  newPhone, Role.CUSTOMER, Status.ACTIVE, newAddress);
               UserService.instance().addUser(user);
//            baiHocHelper.QueryData("UPDATE NoiDung SET ten = '"+tenmoi+"', noidung= '"+noidungmoi+"' WHERE id = '"+id+"' ");
                dialog.dismiss();
                getData();
            });
            dialog.show();
        });
    }
    private void getData(){
        users = UserRepository.instance().findAll();
        adapter = new UserAdapter(this, R.layout.admin_single_item, users);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public  void dialogDelete(String ten, int id){
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setMessage("Bạn chắc chắn xóa '"+ten+"' hông");
        builder.setPositiveButton("Có", (dialogInterface, i) -> {
            String idd = String.valueOf(id);
            UserService.instance().deleteUser("id = ?", new String[]{idd});
            getData();
        });
        builder.setNegativeButton("Không", (dialogInterface, i) -> {

        });
        builder.show();
    }
    public void dialogUpdate(String email, String name, String pass, String phone, String address, Timestamp dob, int id){
        Dialog dialog= new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.admin_user_editadd);

        Button btnHuy = dialog.findViewById(R.id.btnAdminCancel);
        Button btnEdit = dialog.findViewById(R.id.btnAdminSave);
        EditText cemail = dialog.findViewById(R.id.etAdminEmail);
        EditText cpass = dialog.findViewById(R.id.etAdminPassword);
        EditText cname = dialog.findViewById(R.id.etAdminName);
        EditText cphone = dialog.findViewById(R.id.etAdminPhone);
        EditText caddress = dialog.findViewById(R.id.etAdminAddress);

        cemail.setText(email);
        cname.setText(name);
        cpass.setText(pass);
        cphone.setText(phone);
        caddress.setText(address);


        btnHuy.setOnClickListener(view -> {
            dialog.dismiss();
        });
        btnEdit.setOnClickListener(view -> {
            String newEmail = cemail.getText().toString();
            String newName = cname.getText().toString();
            String newPass = cpass.getText().toString();
            String newPhone = cphone.getText().toString();
            String newAddress = caddress.getText().toString();


            if (TextUtils.isEmpty(newEmail) || TextUtils.isEmpty(newName)){
                Toast.makeText(getActivity(), "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                return;
            }
            User user = UserService.instance().finOneUser(id);
            user.setEmail(newEmail);
            user.setName(newName);
            user.setPassword(newPass);
            user.setPhone(newPhone);
            user.setAddress(newAddress);
            UserService.instance().updateUser(user,"id= ?", new String[]{String.valueOf(id)});
//            baiHocHelper.QueryData("UPDATE NoiDung SET ten = '"+tenmoi+"', noidung= '"+noidungmoi+"' WHERE id = '"+id+"' ");
            dialog.dismiss();
            getData();
        });
        dialog.show();
    }
}
