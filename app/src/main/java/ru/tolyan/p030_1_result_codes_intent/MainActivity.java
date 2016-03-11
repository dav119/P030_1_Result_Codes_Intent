package ru.tolyan.p030_1_result_codes_intent;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int MY_CODE_COLOR = 1;
    final int MY_CODE_GRAVITY = 2;

    Button btnColor;
    Button btnGravity;
    TextView txtMainText;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColor = (Button) findViewById(R.id.btnColor);
        btnGravity = (Button) findViewById(R.id.btnGravity);
        txtMainText = (TextView) findViewById(R.id.txtMainText);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnColor:
                        intent = new Intent(getApplicationContext(), ColorActivity.class);
                        startActivityForResult(intent, MY_CODE_COLOR);
                        break;
                    case R.id.btnGravity:
                        intent = new Intent(getApplicationContext(), GravityActivity.class);
                        startActivityForResult(intent, MY_CODE_GRAVITY);
                        break;
                }
            }
        };

        btnGravity.setOnClickListener(onClickListener);
        btnColor.setOnClickListener(onClickListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case MY_CODE_COLOR:
                    txtMainText.setTextColor(data.getIntExtra("color", Color.WHITE));
                    break;
                case MY_CODE_GRAVITY:
                    txtMainText.setGravity(data.getIntExtra("gravity", Gravity.CENTER));
                    break;
            }
        } else {
            Toast.makeText(this, "Press Button instead of Back!!!", Toast.LENGTH_SHORT).show();
        }



    }
}
