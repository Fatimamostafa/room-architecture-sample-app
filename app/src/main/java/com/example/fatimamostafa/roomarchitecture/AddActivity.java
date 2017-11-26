package com.example.fatimamostafa.roomarchitecture;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.etValue)
    EditText etValue;
    @BindView(R.id.etDate)
    EditText etDate;
    @BindView(R.id.btnAdd)
    Button btnAdd;

    private Date date;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    private MetricsListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        calendar = Calendar.getInstance();
        viewModel = ViewModelProviders.of(this).get(MetricsListViewModel.class);

        datePickerDialog = new DatePickerDialog(this, AddActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etTitle.getText() == null || etValue.getText() == null || date == null)
                    Toast.makeText(AddActivity.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    viewModel.addItem(new MetricsModel(
                            etTitle.getText().toString(),
                            etValue.getText().toString(),
                           date
                    ));
                    finish();
                }
            }
        });


        etDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                datePickerDialog.show();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();
        etDate.setText(date.toString());

    }



}
