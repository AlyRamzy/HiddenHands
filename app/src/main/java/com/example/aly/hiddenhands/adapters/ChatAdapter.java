package com.example.aly.hiddenhands.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aly.hiddenhands.DataStructures.Chat;
import com.example.aly.hiddenhands.DataStructures.Message;
import com.example.aly.hiddenhands.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Nour Ahmed on 7/26/2019.
 */

public class ChatAdapter extends ArrayAdapter<Chat>
{

    private FirebaseDatabase mfirebase;
    private DatabaseReference mdataReference;

    private DatabaseReference musernameReference;
    public ChatAdapter(Context context, int resource, List<Chat> objects) {
            super(context, resource, objects);
            mfirebase=FirebaseDatabase.getInstance();
            mdataReference=mfirebase.getReference().child("Users");
            musernameReference=mfirebase.getReference().child("Users");

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.chat_listview_item, parent, false);
        }

        final CircleImageView doctorImageView = (CircleImageView) convertView.findViewById(R.id.doctorImage);
        final TextView doctorUsernameView = (TextView) convertView.findViewById(R.id.doctorUsername);
        final TextView messageView = (TextView) convertView.findViewById(R.id.message);

        Chat chat = getItem(position);

        mdataReference=mdataReference.child(chat.getUserId()).child("photoURL");
        musernameReference=musernameReference.child(chat.getUserId()).child("username");

        musernameReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String username=dataSnapshot.getValue(String.class);
                doctorUsernameView.setText(username);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mdataReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String urlphoto=dataSnapshot.getValue(String.class);
                Glide.with(doctorImageView.getContext())
                        .load(urlphoto)
                        .into(doctorImageView);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        messageView.setText(chat.getLastMessage().getContent());
        return convertView;
    }
}
