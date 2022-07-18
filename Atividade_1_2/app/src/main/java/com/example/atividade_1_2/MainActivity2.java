package com.example.atividade_1_2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView ed1 = (TextView) findViewById(R.id.textView1);
        String dato = getIntent().getStringExtra("data");
        ed1.setText(dato);
    }
}
