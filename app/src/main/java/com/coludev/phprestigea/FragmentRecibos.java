package com.coludev.phprestigea;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FragmentRecibos extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Recibo> elements;
    RecyclerView recyclerView;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recibos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewRecibos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        elements = new ArrayList<>();
        adapter = new ListAdapter(elements, getContext());
        recyclerView.setAdapter(adapter); // Set the adapter immediately

        EventChangeListener();
    }

    private void EventChangeListener() {
        db.collection("Pagos").orderBy("", Query.Direction.valueOf("desc"))
                .addSnapshotListener((value, error) -> {
                    if (error != null) {
                        Log.e("Firestore Error", Objects.requireNonNull(error.getMessage()));
                        return;
                    }

                    assert value != null;
                    for (DocumentChange dc : value.getDocumentChanges()) {
                        if (dc.getType() == DocumentChange.Type.ADDED) {
                            elements.add(dc.getDocument().toObject(Recibo.class));
                            adapter.notifyItemInserted(elements.size() - 1);
                        }
                        // Handle other cases like MODIFIED and REMOVED if needed
                    }
                });
    }
}
