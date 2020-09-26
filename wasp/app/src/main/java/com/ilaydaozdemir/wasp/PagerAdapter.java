package com.ilaydaozdemir.wasp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
      switch (position){
          case 0:
              return new requestFragment();
          case 1:
              return new friendsFragment();
          default:
              return new chatsFragment();
      }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
