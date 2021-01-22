package com.example.project_soccerinfo.player;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.project_soccerinfo.player.Frag_P_LaLiga;
import com.example.project_soccerinfo.player.Frag_P_Premier;
import com.example.project_soccerinfo.player.Frag_P_Serie;

public class TeamViewPagerAdapter extends FragmentPagerAdapter {

    public TeamViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    // 프래그먼트 교체
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Frag_P_Premier.newInstance();
            case 1:
                return Frag_P_LaLiga.newInstance();
            case 2:
                return Frag_P_Serie.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    // 상단의 탭 레이아웃 텍스트 선언
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Premier League";
            case 1:
                return "LaLiga";
            case 2:
                return "SERIE A";
            default:
                return null;
        }
    }
}