package ua.kiev.farmaco.inventory.fragments;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraDevice;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import ua.kiev.farmaco.inventory.R;


public class BarcodeScanFragment extends Fragment {


    public BarcodeScanFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_barcode_scan, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        IntentIntegrator scannerIntegrator = new IntentIntegrator(getActivity());
        scannerIntegrator.initiateScan();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult resultScan =  IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(resultScan != null){
            String scanContents = resultScan.getContents();
            String scanFormat = resultScan.getFormatName();
        }else{
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
