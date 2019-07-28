package com.example.aly.hiddenhands.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.aly.hiddenhands.DataStructures.Chat;
import com.example.aly.hiddenhands.DataStructures.Message;
import com.example.aly.hiddenhands.R;
import com.example.aly.hiddenhands.adapters.ChatAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Chats extends Fragment {
    FirebaseAuth firebaseAuth;


    public Chats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chats, container, false);
        firebaseAuth=FirebaseAuth.getInstance();

        ListView chatList=(ListView) view.findViewById(R.id.chatlist);
        ArrayList<Chat> chats=new ArrayList<Chat>();
        Message mess=new Message("noooor","noortany");
        chats.add(new Chat("noooooooooooor",mess,firebaseAuth.getCurrentUser().getUid()));
        ChatAdapter adapter=new ChatAdapter(getContext(),0,chats);
        chatList.setAdapter(adapter);
        return view;
    }

}
