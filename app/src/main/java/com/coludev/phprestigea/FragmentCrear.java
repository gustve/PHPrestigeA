package com.coludev.phprestigea;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FragmentCrear extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<AptInquilino> inquilinoslist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAutoCompleteTextView();
    }

    private void initAutoCompleteTextView() {
        db.collection("Inquilinos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            inquilinoslist = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                AptInquilino inquilino = document.toObject(AptInquilino.class);
                                inquilinoslist.add(inquilino);
                            }
                            List<String> elemento = new ArrayList<>();
                            for (AptInquilino inquilino : inquilinoslist) {
                                elemento.add(inquilino.getAptId()+" - "+inquilino.getNombreInquilino());
                            }
                            // Actualizar el AutoCompleteTextView
                            actualizarAutoCompleteTextView(elemento);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    private void actualizarAutoCompleteTextView(List<String> elemento) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line, elemento);
        AutoCompleteTextView editText = getView().findViewById(R.id.actvApt);
        editText.setAdapter(adapter);
    }


}