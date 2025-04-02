package com.example.guangbo1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.IntentFilter;


    public class MainActivity extends AppCompatActivity {
        private NetworkChangeReceiver mNChangeReceiver;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        @Override
        protected void onResume() {
            super.onResume();

            mNChangeReceiver = new NetworkChangeReceiver();
            IntentFilter intentFilter=new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(mNChangeReceiver,intentFilter);
        }
        @Override
        protected void onPause() {
            super.onPause();
            unregisterReceiver(mNChangeReceiver);
        }
        @Override
        protected void onDestroy() {
            super.onDestroy();
        }
    }
