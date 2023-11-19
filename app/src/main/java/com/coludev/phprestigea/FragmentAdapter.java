package com.coludev.phprestigea;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.checkerframework.checker.nullness.qual.NonNull;

public class FragmentAdapter extends FragmentStateAdapter{
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            default:
                return new FragmentCrear();
            case 1:
                return new FragmentRecibos();
            case 2:
                return new FragmentBuscar();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
