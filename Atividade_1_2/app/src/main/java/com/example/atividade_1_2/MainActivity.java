package com.example.atividade_1_2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText editText1 = (EditText)findViewById(R.id.edittext_id1);
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("data",editText1.getText().toString());
                startActivity(i);
            }
        });
    }
}