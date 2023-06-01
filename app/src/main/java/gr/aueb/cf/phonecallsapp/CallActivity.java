package gr.aueb.cf.phonecallsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity for making phone Calls.
 * User adds phone number and presses "Dial"
 *
 * @author Kountouris Panagiotis
 */
public class CallActivity extends AppCompatActivity {
    private EditText phoneET;
    private Button dialBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        phoneET = findViewById(R.id.phoneET);
        dialBtn = findViewById(R.id.dialBtn);

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneET.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                System.out.println("tel:" + phoneNumber);
                startActivity(intent);

            }
        });
    }
}