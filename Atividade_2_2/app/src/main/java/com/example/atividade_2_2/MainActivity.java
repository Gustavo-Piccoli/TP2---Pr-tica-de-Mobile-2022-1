package com.example.atividade_2_2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLight;
    private Sensor mGiroscopio;
    TextView luzinha;
    TextView giragira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout. activity_main);
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        luzinha = (TextView)findViewById(R.id.textView1);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null ) {
            mSensorManager.registerListener(MainActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            luzinha.setText("Sensor Luminoso Não Suportado");
        }

        giragira = (TextView)findViewById(R.id.textView2);
        mGiroscopio = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGiroscopio != null ) {
            mSensorManager.registerListener(MainActivity.this, mGiroscopio, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            giragira.setText("Sensor Giroscopio Não Suportado");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGiroscopio, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor1 = event.sensor;
        if(sensor1.getType() == Sensor.TYPE_LIGHT) {
            luzinha.setText("Intensidade Luminosa:\n" + event.values[0]);
        }
        Sensor sensor2 = event.sensor;
        if(sensor2.getType() == Sensor.TYPE_GYROSCOPE) {
            giragira.setText("Intensidade Rotacional no Eixo X:\n" + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}