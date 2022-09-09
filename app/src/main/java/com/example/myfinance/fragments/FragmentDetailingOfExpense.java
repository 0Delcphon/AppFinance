package com.example.myfinance.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfinance.MainActivity;
import com.example.myfinance.R;
import com.example.myfinance.dialog_fragments.ErrorDialogFragment;
import com.example.myfinance.utils.DataProvider;
import com.example.myfinance.utils.DataSpentDetailing;
import com.example.myfinance.utils.DataSpentInMonth;
import com.example.myfinance.utils.DataStoreParent;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetailingOfExpense extends Fragment {


    ListView detailingOfExpenseList;
    AutoCompleteTextView monthList;

    public FragmentDetailingOfExpense() {
        super(R.layout.detailing_of_expense_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        monthList = view.findViewById(R.id.month_list_spent_detailing);
        detailingOfExpenseList = view.findViewById(R.id.detailing_spent_list);

    }

}

class MyAdapterForDetalingExpenseList extends ArrayAdapter<String> {

    Context context;
    private String[] date;
    private int[] spent;
    private String[] spentComment;

    public MyAdapterForDetalingExpenseList(@NonNull Context context, String[] date, int[] spent, String[] spentComment) {
        super(context, R.layout.costum_item_detailing_elemnt, R.id.text1, date);
        this.context = context;
        this.date = date;
        this.spent = spent;
        this.spentComment = spentComment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.costum_item_detailing_elemnt, parent, false);
        TextView dateTextView = customView.findViewById(R.id.detailing_date);
        dateTextView.setText(date[position]);
        TextView spentTextView = customView.findViewById(R.id.detailing_spent);
        spentTextView.setText(String.valueOf(spent[position]));
        TextView spentCommentTextView = customView.findViewById(R.id.detailing_spent_comment);
        spentCommentTextView.setText(spentComment[position]);

        return customView;
    }

}