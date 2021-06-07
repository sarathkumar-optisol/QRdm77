package com.droid.zxingdm77

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class MainActivity : AppCompatActivity() , ZXingScannerView.ResultHandler {

    val TAG ="MAINACTIVITY"
    lateinit var zXingScannerView: ZXingScannerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        zXingScannerView = ZXingScannerView(this)
        setContentView(zXingScannerView)
    }

    override fun onResume() {
        super.onResume()
        zXingScannerView.setResultHandler(this)
        zXingScannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        zXingScannerView.stopCamera()
    }

    override fun handleResult(rawResult: Result?) {
        // Do something with the result here
//        Log.v(TAG, rawResult!!.getText()); // Prints scan results
//        Log.v(TAG, rawResult!!.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        Log.d(TAG,"Start Time ${System.nanoTime()}")
        val start = System.nanoTime()
        Log.d(TAG,"${rawResult!!.text}")
        Log.d(TAG,"${rawResult!!.barcodeFormat}")
        Log.d(TAG, "End Time"+((System.nanoTime() - start) / 1000000).toString())
        // If you would like to resume scanning, call this method below:
        zXingScannerView.resumeCameraPreview(this);
    }
}