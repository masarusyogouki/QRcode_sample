package com.example.qrcode_sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var qrButton = findViewById<Button>(R.id.scanner)

        // ボタンを押した時にQR読み取り画面に遷移する
        qrButton.setOnClickListener{
            IntentIntegrator(this).apply {
                captureActivity=QRCodeCaptureActivity::class.java
            }.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //読み取り結果
        val result = IntentIntegrator.parseActivityResult(resultCode,data)
        if (result.contents != null) {
            Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
        }
    }
}

