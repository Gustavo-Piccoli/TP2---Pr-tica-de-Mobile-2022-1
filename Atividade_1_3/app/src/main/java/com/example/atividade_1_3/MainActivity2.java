package com.example.atividade_1_3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView ed1 = (TextView) findViewById(R.id.textView1);
        ed1.setText("Você moveu o celular em alguma direção com uma aceleração maior que 15 metros por segundo!");
    }
}
