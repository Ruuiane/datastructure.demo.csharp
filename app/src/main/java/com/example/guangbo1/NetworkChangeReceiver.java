package com.example.guangbo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.widget.Toast;
public class NetworkChangeReceiver extends BroadcastReceiver {
    //第一步，创建广播接收器子类NetworkChangeReceiver
    //重载onReceive方法
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager=
                (ConnectivityManager)context.getSystemService
                        (Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        Network network=connectivityManager.getActiveNetwork();
        if (network != null) {

            NetworkCapabilities
                    capabilities=connectivityManager.getNetworkCapabilities(network);
            if
            (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
            {
                Toast.makeText(context,"当前使用的是WIFI",
                        Toast.LENGTH_LONG).show();
            }
            if
            (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
            {
                Toast.makeText(context,"当前使用的是手机流量",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}