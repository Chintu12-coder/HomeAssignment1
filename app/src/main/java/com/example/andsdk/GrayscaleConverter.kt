package com.example.andsdk

object GrayscaleConverter {
    init {
        System.loadLibrary("native-lib")
    }

    external fun convertToGrayscale(inputMatAddr: Long, outputMatAddr: Long)
}
