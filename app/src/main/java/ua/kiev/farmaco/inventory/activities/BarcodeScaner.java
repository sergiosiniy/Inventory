package ua.kiev.farmaco.inventory.activities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

/**
 * Created by Admin on 28.04.2017.
 */

public class BarcodeScaner extends AppCompatActivity implements DecoratedBarcodeView.TorchListener {

    private CameraManager mCameraManager;
    private String mCameraId;
    private Boolean isTorchOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!isFlashAvailable) {
            Toast.makeText(this,"Your device doesn't support flash light!",Toast.LENGTH_LONG).show();
        }
        isTorchOn = false;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            try {
                mCameraId = mCameraManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }else{
            //TODO write code for API lower than 21
        }
    }

    @Override
    protected DecoratedBarcodeView initializeContent() {
        return super.initializeContent();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    public BarcodeScaner() {
        super();
    }

    @Override
    protected void onResume() {
        super.onResume();
        turnOnFlashLight();
    }

    @Override
    protected void onPause() {
        super.onPause();
        turnOffFlashLight();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        turnOffFlashLight();
    }

    public void turnOnFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, true);
                isTorchOn = true;
            }
        } catch (Exception e) {
            Toast.makeText(BarcodeScaner.this,"Cant use flash!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void turnOffFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, false);
                isTorchOn = false;
            }

        } catch (Exception e) {
            Toast.makeText(BarcodeScaner.this,"Cant use flash!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
