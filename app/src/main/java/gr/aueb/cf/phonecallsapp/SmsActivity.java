package gr.aueb.cf.phonecallsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity for sending SMS messages.
 * The user can enter recipients phone number, message and press send.
 *
 * @author Kountouris Panagiotis
 */
public class SmsActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                String message = messageEditText.getText().toString();

                if (phoneNumber.isEmpty() || message.isEmpty()) {
                    Toast.makeText(SmsActivity.this, "Please enter phone number and message", Toast.LENGTH_SHORT).show();
                    return;
                }

                sendSms(phoneNumber, message);
            }
        });
    }

    private void sendSms(String phoneNumber, String message) {
        Uri smsUri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, smsUri);
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
}