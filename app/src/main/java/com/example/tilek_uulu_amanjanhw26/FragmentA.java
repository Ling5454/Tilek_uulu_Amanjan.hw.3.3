package com.example.tilek_uulu_amanjanhw26;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class FragmentA extends Fragment {
    private Integer counter = 0;
    private MaterialButton btn_plus,btn_minus;
    private Button nextFragment;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_plus = requireActivity().findViewById(R.id.btn_plus);
        btn_minus = requireActivity().findViewById(R.id.btn_minus);
        textView = requireView().findViewById(R.id.tv_result);
        nextFragment = requireActivity().findViewById(R.id.fragmentForContainer);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(String.valueOf(counter++));
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(String.valueOf(counter--));
            }
        });

        nextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("KEY_FROM_RESULT", textView.getText().toString());
                NextFragment nextFragment = new NextFragment();
                nextFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentForContainer, nextFragment).addToBackStack(null).commit();
            }
        });
    }
}