package com.example.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {
    public static void askForPermission(Context context, String... permissions){
        List<String> notAuthoziedList = new ArrayList<>();
        for(String permission : permissions){
            if(ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED){
                notAuthoziedList.add(permission);
            }
        }

        if(!notAuthoziedList.isEmpty()){
            ActivityCompat.requestPermissions((Activity) context, notAuthoziedList.toArray(new String[notAuthoziedList.size()]), 1);
        }
    }

    public static boolean checkPermission(Context context, String... permissions){
        for(String permission : permissions){
            if(ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }
}
