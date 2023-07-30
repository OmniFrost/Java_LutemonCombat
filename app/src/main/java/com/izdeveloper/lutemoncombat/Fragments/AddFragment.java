package com.izdeveloper.lutemoncombat.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.izdeveloper.lutemoncombat.Lutemon;
import com.izdeveloper.lutemoncombat.LutemonColors.Black;
import com.izdeveloper.lutemoncombat.LutemonColors.Green;
import com.izdeveloper.lutemoncombat.LutemonColors.Orange;
import com.izdeveloper.lutemoncombat.LutemonColors.Pink;
import com.izdeveloper.lutemoncombat.LutemonColors.White;
import com.izdeveloper.lutemoncombat.R;
import com.izdeveloper.lutemoncombat.Storage;

public class AddFragment extends Fragment {

    private EditText textName;
    private RadioGroup radiogroupColor, radiogroupAvatar;
    private Button buttonAddLutemon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        textName = view.findViewById(R.id.txtName);
        radiogroupColor = view.findViewById(R.id.rgColor);
        radiogroupAvatar = view.findViewById(R.id.rgAvatars);
        buttonAddLutemon = view.findViewById(R.id.btnAddLutemon);

        buttonAddLutemon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view2) {
                addLutemonToStorage();
            }
        });

        return view;
    }

//Interpret user choises and input and add a Lutemon to the singleton storage
    private void addLutemonToStorage() {
        String Name, tempColor;
        int ColorID, AvatarID, tempAvatarID;
        Name = textName.getText().toString();
        ColorID = radiogroupColor.getCheckedRadioButtonId();
        AvatarID = radiogroupAvatar.getCheckedRadioButtonId();

        tempColor = "";
        tempAvatarID = 0;

        switch (ColorID) {
            case R.id.rbWhite:
                tempColor = "White";
                break;
            case R.id.rbGreen:
                tempColor = "Green";
                break;
            case R.id.rbPink:
                tempColor = "Pink";
                break;
            case R.id.rbOrange:
                tempColor = "Orange";
                break;
            case R.id.rbBlack:
                tempColor = "Black";
                break;
        }

        switch (AvatarID) {
            case R.id.rbA1:
                tempAvatarID = R.drawable.av1;
                break;
            case R.id.rbA2:
                tempAvatarID = R.drawable.av2;
                break;
            case R.id.rbA3:
                tempAvatarID = R.drawable.av3;
                break;
            case R.id.rbA4:
                tempAvatarID = R.drawable.av4;
                break;
            case R.id.rbA5:
                tempAvatarID = R.drawable.av5;
                break;
            case R.id.rbA6:
                tempAvatarID = R.drawable.av6;
                break;
            case R.id.rbA7:
                tempAvatarID = R.drawable.av7;
                break;
            case R.id.rbA8:
                tempAvatarID = R.drawable.av8;
                break;
        }

        Lutemon newLutemon = null;
        switch (tempColor) {
            case "White":
                newLutemon = new White(Name, tempAvatarID);
                break;
            case "Green":
                newLutemon = new Green(Name, tempAvatarID);
                break;
            case "Pink":
                newLutemon = new Pink(Name, tempAvatarID);
                break;
            case "Orange":
                newLutemon = new Orange(Name, tempAvatarID);
                break;
            case "Black":
                newLutemon = new Black(Name, tempAvatarID);
                break;
        }

        Storage.getSingle().addLutemon(newLutemon);
    }

}
