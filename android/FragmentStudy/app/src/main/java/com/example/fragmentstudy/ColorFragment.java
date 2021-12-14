package com.example.fragmentstudy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        // 아무것도 비춰지지 않는 투명한 뷰를 리턴값으로 받음
        return new View(getActivity());
    }
        // 색상 기능 정의
    public void setColor(int color) {
        getView().setBackgroundColor(color);
    }
}
