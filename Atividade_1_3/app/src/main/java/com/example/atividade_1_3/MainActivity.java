package com.example.atividade_1_3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Intent;
import android.content.Context;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            EditText editText1 = (EditText)findViewById(R.id.edittext_id1);
            editText1.setHint("SensorX:     " + String.valueOf(sensorX));
            EditText editText2 = (EditText)findViewById(R.id.edittext_id2);
            editText2.setHint("SensorY:     " + String.valueOf(sensorY));
            EditText editText3 = (EditText)findViewById(R.id.edittext_id3);
            editText3.setHint("SensorZ:     " + String.valueOf(sensorZ));
            if ((sensorX > 15) || (sensorY > 15) || (sensorZ > 15)){
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}