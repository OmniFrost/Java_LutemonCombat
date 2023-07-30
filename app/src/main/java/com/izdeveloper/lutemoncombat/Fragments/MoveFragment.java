package com.izdeveloper.lutemoncombat.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.izdeveloper.lutemoncombat.ArenaStorage;
import com.izdeveloper.lutemoncombat.Lutemon;
import com.izdeveloper.lutemoncombat.MoveRecyclerView.MoveListAdapter;
import com.izdeveloper.lutemoncombat.R;
import com.izdeveloper.lutemoncombat.Storage;
import com.izdeveloper.lutemoncombat.TrainingStorage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MoveFragment extends Fragment {

    private MoveListAdapter MLadapter;
    private RecyclerView RV;
    private Storage lutemons;
    private Button btnConfirm, btnSave, btnLoad;
    private RadioGroup rgTrorA;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lutemons = Storage.getSingle();
        MLadapter = new MoveListAdapter(getContext(), lutemons.listLutemons());
    }

    //Receive user choises and when Move button is clicked, Lutemons are moved to selected areas
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_move, container, false);

        RV = view.findViewById(R.id.rvFighters);

        RV.setLayoutManager(new LinearLayoutManager(getContext()));
        RV.setAdapter(MLadapter);

        rgTrorA = view.findViewById(R.id.rgTrorA);

        btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(v -> {
            ArrayList<Lutemon> selectedLutemons = MLadapter.getSelectedLutemons();

            int selectedRadioButtonId = rgTrorA.getCheckedRadioButtonId();

            if (selectedRadioButtonId == R.id.rbTraining) {

                TrainingStorage tS = TrainingStorage.getSingle();
                tS.addTrainingLutemons(selectedLutemons);

            } else if (selectedRadioButtonId == R.id.rbArena) {
                ArenaStorage aS = ArenaStorage.getSingle();
                aS.addArenaLutemons(selectedLutemons);
            }

            for (Lutemon lutemon : selectedLutemons) {
                Storage.getSingle().removeLutemon(lutemon);
            }

            MLadapter = new MoveListAdapter(getContext(), lutemons.listLutemons());
            RV.setAdapter(MLadapter);
            MLadapter.notifyDataSetChanged();
        });

        btnSave = view.findViewById(R.id.btnSave);
        btnLoad = view.findViewById(R.id.btnLoad);

        btnSave.setOnClickListener(v -> saveLutemonsHome(getContext(), MLadapter.getSelectedLutemons()));

        btnLoad.setOnClickListener(v -> {
            loadLutemonsHome(getContext());
        });

        return view;
    }

    //Update the adapter to display correct possible choises of Lutemons
    @Override
    public void onResume() {
        super.onResume();
        MLadapter = new MoveListAdapter(getContext(), lutemons.listLutemons());
        RV.setAdapter(MLadapter);
        MLadapter.notifyDataSetChanged();
    }

    //Method to save all selected Lutemons to file
    private void saveLutemonsHome(Context context, ArrayList<Lutemon> selectedLutemons) {
        try {
            ObjectOutputStream userSaver = new ObjectOutputStream(context.openFileOutput("LutemonStorage.data", Context.MODE_PRIVATE));
            userSaver.writeObject(selectedLutemons);

            userSaver.close();;

        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen tiedostoon epäonnistui.");
            e.printStackTrace();
        }
    }

    //Method to load all existing Lutemons from file
    public void loadLutemonsHome(Context context) {
        try {
            FileInputStream fileInputStream = context.openFileInput("LutemonStorage.data");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Lutemon> loadedLutemons = (ArrayList<Lutemon>) objectInputStream.readObject();
            objectInputStream.close();

            Storage storage = Storage.getSingle();
            storage.clearLutemons();
            storage.addLutemons(loadedLutemons);

            MLadapter = new MoveListAdapter(getContext(), storage.listLutemons());
            RV.setAdapter(MLadapter);
            MLadapter.notifyDataSetChanged();

        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen tiedostosta epäonnistui.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen tiedostosta epäonnistui.");
            e.printStackTrace();
        }
    }

}
