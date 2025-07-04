package com.example.andsdk

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.Mat
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var originalImageView: ImageView
    private lateinit var grayImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpenCVLoader.initDebug()
        setContentView(R.layout.activity_main)

        originalImageView = findViewById(R.id.originalImageView)
        grayImageView = findViewById(R.id.grayImageView)

        findViewById<Button>(R.id.selectImageButton).setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK) {
            val uri = data?.data ?: return
            val bitmap = uriToBitmap(uri)
            val mat = Mat()
            Utils.bitmapToMat(bitmap, mat)

            val gray = Mat()
            GrayscaleConverter.convertToGrayscale(mat.nativeObjAddr, gray.nativeObjAddr)

            val grayBitmap = Bitmap.createBitmap(gray.cols(), gray.rows(), Bitmap.Config.ARGB_8888)
            Utils.matToBitmap(gray, grayBitmap)

            originalImageView.setImageBitmap(bitmap)
            grayImageView.setImageBitmap(grayBitmap)
        }
    }

    private fun uriToBitmap(uri: Uri): Bitmap {
        return contentResolver.openInputStream(uri)?.use {
            BitmapFactory.decodeStream(it)
        }!!
    }
}
