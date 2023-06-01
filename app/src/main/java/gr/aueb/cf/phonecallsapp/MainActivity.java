package gr.aueb.cf.phonecallsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Multifunctional Application. Provides Activities for:
 * - Making PhoneCalls
 * - Sending Emails
 * - Sending SMS messages
 * Can also navigate to browse phone photos and use Camera
 *
 * @author Kountouris Panagiotis
 */
public class MainActivity extends AppCompatActivity {

    private Button phoneCallButton;
    private Button emailButton;
    private Button messageButton;
    private Button galleryButton;
    private Button cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneCallButton = findViewById(R.id.phoneCallButton);
        emailButton = findViewById(R.id.emailButton);
        messageButton = findViewById(R.id.messageButton);
        galleryButton = findViewById(R.id.galleryButton);
        cameraButton = findViewById(R.id.cameraButton);

        // Navigates to the PhoneCalling Activity
        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

        // Navigates to the Email Sending activity
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });

        // Navigates to the SMS sending activity
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });

        // Navigates to the phone Photo Gallery
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(intent);
            }
        });

        // Opens the phone Camera
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
            }
        });
    }
}