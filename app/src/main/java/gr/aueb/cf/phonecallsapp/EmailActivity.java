package gr.aueb.cf.phonecallsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity for sending E-mails
 * User can and recipients email, subject, message and
 * send by pressing send
 *
 * @author Kountouris Panagiotis
 */
public class EmailActivity extends AppCompatActivity {

    private EditText toEditText;
    private EditText subjectEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        toEditText = findViewById(R.id.toEditText);
        subjectEditText = findViewById(R.id.subjectEditText);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toEmail = toEditText.getText().toString().trim();
                String[] recipientEmails = {toEmail};
                String subject = subjectEditText.getText().toString().trim();
                String message = messageEditText.getText().toString().trim();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipientEmails);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(emailIntent, "Choose an Email client:"));
            }
        });
    }
}