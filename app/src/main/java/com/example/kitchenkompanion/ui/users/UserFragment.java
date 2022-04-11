package com.example.kitchenkompanion.ui.users;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kitchenkompanion.MainActivity;
import com.example.kitchenkompanion.R;

import com.example.kitchenkompanion.databinding.FragmentUsersBinding;
import com.google.android.material.button.MaterialButton;

public class UserFragment extends Fragment {

    private FragmentUsersBinding binding;

    private EditText username;
    private EditText password;
    private TextView current_user;
    private ImageView current_user_image;
    private MaterialButton loginbtn;
    private TextView passwords;
    private LinearLayout socials;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserViewModel UserViewModel =
                new ViewModelProvider(this).get(UserViewModel.class);

        binding = FragmentUsersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        username = root.findViewById(R.id.username);
        password = root.findViewById(R.id.password);
        current_user = root.findViewById(R.id.current_user_text_var);
        current_user_image = root.findViewById(R.id.curret_user_image_var);

        current_user.setText(MainActivity.curr_user);
        if (MainActivity.curr_user.equals("Charlie")) {
            current_user_image.setImageResource(R.drawable.private_list_owner1);
        } else if (MainActivity.curr_user.equals("Max")) {
            current_user_image.setImageResource(R.drawable.private_list_owner2);
        } else if (MainActivity.curr_user.equals("Zach")) {
            current_user_image.setImageResource(R.drawable.private_list_owner3);
        } else {
            current_user_image.setImageResource(R.drawable.private_list_owner4);
        }

        loginbtn = root.findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equalsIgnoreCase("Charlie") && password.getText().toString().equals("user1")){
                    //correct
                    Toast.makeText(getActivity(),"LOGIN SUCCESSFUL, WELCOME CHARLIE",Toast.LENGTH_SHORT).show();
                    MainActivity.curr_user = "Charlie";
                    username.setText("");
                    password.setText("");
                    current_user.setText(MainActivity.curr_user);
                    current_user_image.setImageResource(R.drawable.private_list_owner1);
                }else if(username.getText().toString().equalsIgnoreCase("Max") && password.getText().toString().equals("user2")){
                    //correct
                    Toast.makeText(getActivity(),"LOGIN SUCCESSFUL, WELCOME MAX",Toast.LENGTH_SHORT).show();
                    MainActivity.curr_user = "Max";
                    username.setText("");
                    password.setText("");
                    current_user.setText(MainActivity.curr_user);
                    current_user_image.setImageResource(R.drawable.private_list_owner2);
                }else if(username.getText().toString().equalsIgnoreCase("Zach") && password.getText().toString().equals("user3")){
                    //correct
                    Toast.makeText(getActivity(),"LOGIN SUCCESSFUL, WELCOME ZACH",Toast.LENGTH_SHORT).show();
                    MainActivity.curr_user = "Zach";
                    username.setText("");
                    password.setText("");
                    current_user.setText(MainActivity.curr_user);
                    current_user_image.setImageResource(R.drawable.private_list_owner3);
                }else if(username.getText().toString().equalsIgnoreCase("Matarr") && password.getText().toString().equals("user4")){
                    //correct
                    Toast.makeText(getActivity(),"LOGIN SUCCESSFUL, WELCOME MATARR",Toast.LENGTH_SHORT).show();
                    MainActivity.curr_user = "Matarr";
                    username.setText("");
                    password.setText("");
                    current_user.setText(MainActivity.curr_user);
                    current_user_image.setImageResource(R.drawable.private_list_owner4);
                }else
                    //incorrect
                    Toast.makeText(getActivity(),"LOGIN FAILED. INCORRECT USERNAME OR PASSWORD",Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
            }
        });

        passwords = root.findViewById(R.id.forgotpass);
        passwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                String toast_text = "User 1: “Charlie”,  Password: “user1”\n" +
                                    "User 2: “Max”,  Password: “user2”\n" +
                                    "User 3: “Zach”,  Password: “user3”\n" +
                                    "User 4: “Matarr”,  Password: “user4”";
                Toast.makeText(getActivity(),toast_text,Toast.LENGTH_LONG).show();
            }
        });

        socials = root.findViewById(R.id.socialicons);
        socials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                String toast_text = "SOCIAL MEDIA LOGIN NOT IMPLEMENTED";
                Toast.makeText(getActivity(),toast_text,Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
