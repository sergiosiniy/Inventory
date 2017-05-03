package ua.kiev.farmaco.inventory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import ua.kiev.farmaco.inventory.R;

/**
 * Author:  Serhii Synohub
 * Date:    01.05.2017
 */

public class Task extends AppCompatActivity {


    private Intent illumService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        illumService = new Intent(this, FlashControllerService.class);

        final Button scan = (Button) findViewById(R.id.scan_button);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIlluminationService();
                startScan();
            }
        });
    }

    private void startScan(){
        IntentIntegrator scanBarCode = new IntentIntegrator(this);
        scanBarCode.setBarcodeImageEnabled(true);
        scanBarCode.setBeepEnabled(false);
        scanBarCode.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        scanBarCode.setBeepEnabled(true);
        scanBarCode.setOrientationLocked(true);
        scanBarCode.setCameraId(0);
        scanBarCode.initiateScan();
    }

    private void startIlluminationService(){

        startService(illumService);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult resultScan = IntentIntegrator
                .parseActivityResult(requestCode, resultCode, data);
        if (resultScan != null) {
            String scanContents = resultScan.getContents();
            String scanFormat = resultScan.getFormatName();
            TextView contents = (TextView) findViewById(R.id.scan_content_textview);
            TextView format = (TextView) findViewById(R.id.scan_format_textview);

            contents.setText(getResources().getString(R.string.bar_content_textview) + " " +
                    scanContents);
            format.setText(getResources().getString(R.string.bar_format_textview)+ " " +
                    scanFormat);
        } else {

            Toast toast = Toast.makeText(getApplicationContext(), getResources()
                    .getString(R.string.bar_content_textview) + " " +
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        stopService(illumService);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }


}
