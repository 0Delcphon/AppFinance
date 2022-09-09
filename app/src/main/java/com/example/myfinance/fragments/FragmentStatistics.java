package com.example.myfinance.fragments;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfinance.MainActivity;
import com.example.myfinance.R;
import com.example.myfinance.dialog_fragments.ErrorDialogFragment;
import com.example.myfinance.utils.DataProvider;
import com.example.myfinance.utils.DataStoreStatistics;

import java.util.ArrayList;
import java.util.List;

public class FragmentStatistics extends Fragment {
    private final static String EMPTY_STRING = "";


    TextView textEarnedField;
    TextView textSpentField;
    TextView textEarned;
    TextView textSpent;
    AutoCompleteTextView monthList;
    ImageView rubleEarned;
    ImageView rubleSpent;

    public FragmentStatistics() {
        super(R.layout.statictics_fragment);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textEarnedField = view.findViewById(R.id.text_output_earned);
        textSpentField = view.findViewById(R.id.text_output_spent);
        textEarned = view.findViewById(R.id.text_earted);
        textSpent = view.findViewById(R.id.text_spent);
        monthList = view.findViewById(R.id.month_list);
        rubleEarned = view.findViewById(R.id.ruble_earned);
        rubleSpent = view.findViewById(R.id.ruble_spent);

        //пока не выбран период отображения данных, скрываем все элементы из видимости
        rubleEarned.setImageDrawable(null);
        rubleSpent.setImageDrawable(null);
        textEarnedField.setText(EMPTY_STRING);
        textSpentField.setText(EMPTY_STRING);
        textEarned.setText(R.string.choose_period);
        textSpent.setText(EMPTY_STRING);


            monthList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //возобнавляем видимость элементов
                    textEarned.setText(R.string.earned);
                    textSpent.setText(R.string.spent);
                    rubleEarned.setImageResource(R.drawable.ruble);
                    rubleSpent.setImageResource(R.drawable.ruble);

                }
            });

        }



    }
