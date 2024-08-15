package com.example.button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView T1,T2;
    Button B1,B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T1=(TextView)findViewById(R.id.T1);
        T2=(TextView)findViewById(R.id.T2);
        B1=(Button)findViewById(R.id.B1);
        B2=(Button)findViewById(R.id.B2);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1.setTextSize(40);
                Toast.makeText(getApplicationContext(),
                        "Font Size Changed",Toast.LENGTH_LONG).show();
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T2.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(),
                        "Font Color Changed", Toast.LENGTH_LONG ).show();
            }
        });
    }
}