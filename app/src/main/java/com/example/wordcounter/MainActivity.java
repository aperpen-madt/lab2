package com.example.wordcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import utils.Counter;

public class MainActivity extends AppCompatActivity {
    private EditText inpText;
    private TextView tvResult;
    private Spinner spnWtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inpText = (EditText) findViewById(R.id.inputText);
        this.tvResult = (TextView) findViewById(R.id.tvResult);
        this.spnWtc = (Spinner) findViewById(R.id.spinnerWtc);

        Button button = (Button) findViewById(R.id.btnCount);
        button.setOnClickListener(v -> onFormSubmit());
    }

    protected void onFormSubmit() {
        String text = this.inpText.getText().toString();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, (String) getString(R.string.error_empty_text),
                    Toast.LENGTH_LONG).show();
        } else {
            String selectedElement = this.spnWtc.getSelectedItem().toString();
            String wordSelection = getResources().getString(R.string.wtc_option_words);

            int result = 0;
            Counter counter = new Counter(text);
            if (selectedElement.equals(wordSelection)) {
                result = counter.countWords();
            } else {
                result = counter.countChars();
            }

            this.tvResult.setText(Integer.toString(result));
        }
    }
}