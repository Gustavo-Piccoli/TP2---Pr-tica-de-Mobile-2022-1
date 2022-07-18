package com.example.atividade_1_1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText1 = (EditText)findViewById(R.id.edittext_id1);
        EditText editText2 = (EditText)findViewById(R.id.edittext_id2);
        Button button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();
                Integer aux1 = Integer.valueOf(num1);
                Integer aux2 = Integer.valueOf(num2);
                Integer aux3 = aux1 + aux2;
                String soma = String.valueOf(aux3);
                TextView texto = (TextView) findViewById(R.id.textView1);
                texto.setText(soma);
            }
        });
    }
}