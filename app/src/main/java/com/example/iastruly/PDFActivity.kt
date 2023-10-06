package com.example.iastruly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class PDFActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfactivity)


        pdfView = findViewById(R.id.pdfView)
        showHandout()
    }
    private fun showHandout() {
        pdfView.fromAsset("ias.pdf").load()
    }
}