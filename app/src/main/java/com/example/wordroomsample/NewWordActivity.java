package com.example.wordroomsample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewWordActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.wordroomsample.REPLY";
    private EditText mEditWordView;
    private String originalWord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);

        // Check if editing existing word
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_REPLY)) {
            originalWord = intent.getStringExtra(EXTRA_REPLY);
            mEditWordView.setText(originalWord);
        }

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditWordView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditWordView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                if (originalWord != null) {
                    replyIntent.putExtra("original_word", originalWord);
                }
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
