package com.example.atividade_2_1;
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
    TextView luzinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout. activity_main );
        luzinha = (TextView)findViewById(R.id.textView1);
        mSensorManager = (SensorManager)
                getSystemService(Context. SENSOR_SERVICE );
        mLight = mSensorManager.getDefaultSensor(Sensor. TYPE_LIGHT );
        if ( mLight != null )
        {
            mSensorManager .registerListener(MainActivity. this , mLight ,
                    SensorManager. SENSOR_DELAY_NORMAL );
        } else
        {
            luzinha .setText( "Light sensor not supported" );
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT) {
            luzinha.setText("Intensidade Luminosa:\n" + event. values [ 0 ]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}