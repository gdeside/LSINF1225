package com.example.wishlist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wishlist.Classesapp.Friend;
import com.example.wishlist.Classesapp.FriendRepository;
import com.example.wishlist.Classesapp.UserRepository;

public class CreateFriendshipActivity extends AppCompatActivity {

    SearchView searchfriend;
    Button btn_friendship;
    EditText friendship_nickname;
    UserRepository userRepository;

    private View.OnClickListener create_friendship_listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String SearchQuerry = searchfriend.getQuery().toString();
            if(SearchQuerry.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Please fills Details",Toast.LENGTH_LONG).show();
            }
            else if(userRepository.isIDUsed(SearchQuerry.trim()) == false)
            {
                Toast.makeText(getApplicationContext(),"User doesn't exist",Toast.LENGTH_LONG).show();
            }
            else
            {
                String username = getUsername();
                FriendRepository friendRepository = new FriendRepository(getApplicationContext());
                if(friendRepository.isAlreadyFriend(username,SearchQuerry))
                {
                    Toast.makeText(getApplicationContext(),"You're already friend with this user",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Friend friend1 = new Friend(SearchQuerry,username,friendship_nickname.getText().toString());
                   friendRepository.InsertTask(friend1);
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_friendship);

        userRepository = new UserRepository(getApplicationContext());

        //éléments layout
        btn_friendship=findViewById(R.id.createfd_btn);
        friendship_nickname=findViewById(R.id.createfd_nickname_edt);
        searchfriend=findViewById(R.id.search_friend_sw);
        btn_friendship.setOnClickListener(create_friendship_listener);

    }

    public String getUsername(){
        // Retrieving the value using its keys
        // the file name must be same in both saving
        // and retrieving the data
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);

        // The value will be default as empty string
        // because for the very first time
        // when the app is opened,
        // there is nothing to show
        return sh.getString("ID", "");
    }
}