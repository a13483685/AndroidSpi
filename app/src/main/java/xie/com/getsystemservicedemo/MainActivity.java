package xie.com.getsystemservicedemo;

import android.os.IDemoService;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    IDemoService demoService = null;
    private String TAG = MainActivity.class.getName();
    Button bt1 = null;
    Button bt2 = null;
    Button bt3 = null;
    Button bt4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.one);
        bt2 = findViewById(R.id.two);
        bt3 = findViewById(R.id.three);
        bt4 = findViewById(R.id.four);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        demoService = IDemoService.Stub.asInterface(ServiceManager.getService("demo"));
        try {
            demoService.cancelVibrate(1);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.one:
                try {
                    Toast.makeText(MainActivity.this,String.valueOf(demoService.cancelVibrate(1)),Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"val is :"+demoService.cancelVibrate(1));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.two:
                try {
                    Toast.makeText(MainActivity.this,String.valueOf(demoService.cancelVibrate(2)),Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"val is :"+demoService.cancelVibrate(2));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.three:
                try {
                    Toast.makeText(MainActivity.this,String.valueOf(demoService.cancelVibrate(3)),Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"val is :"+demoService.cancelVibrate(3));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.four:
                try {
                    Toast.makeText(MainActivity.this,String.valueOf(demoService.cancelVibrate(4)),Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"val is :"+demoService.cancelVibrate(4));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
