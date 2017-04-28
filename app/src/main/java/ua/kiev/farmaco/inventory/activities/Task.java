package ua.kiev.farmaco.inventory.activities;

import android.app.Activity;
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


public class Task extends AppCompatActivity {

    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Button scan = (Button) findViewById(R.id.scan_button);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scanBarCode = new IntentIntegrator(activity);
                scanBarCode.setBarcodeImageEnabled(true);
                scanBarCode.setBeepEnabled(false);
                scanBarCode.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);


                scanBarCode.initiateScan();
            }
        });
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

            contents.setText("Contents: " + scanContents);
            format.setText("Format: " + scanFormat);
        } else {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Override
    protected void onPause() {

        super.onPause();
    }
}
