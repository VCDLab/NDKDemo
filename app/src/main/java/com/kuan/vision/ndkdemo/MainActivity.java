package com.kuan.vision.ndkdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Button btnProc;
    private ImageView imageView;
    private Bitmap bmp;
    public static native int[] grapyproc(int[] pixels, int w, int h);


    static{
        System.loadLibrary("gray-process");
    }

    private Mat mRgba;
    private Mat mGray;

    private CameraBridgeViewBase mOpenCvCameraView;
    public MainActivity(){
        Log.i(TAG, "Instantiated new " + this.getClass());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"called onCreate");
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        btnProc = (Button) findViewById(R.id.btn_gray_process);
        imageView = (ImageView) findViewById(R.id.imageView);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.pic);
        imageView.setImageBitmap(bmp);
        btnProc.setOnClickListener(this);


        //TextView textView = (TextView) findViewById(R.id.tv);
        //textView.setText(NativeMethod.getStrinFromC());
    }


    @Override
    public void onClick(View v){
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        int[] pixels = new int[w*h];

        bmp.getPixels(pixels, 0, w, 0,0, w,h);
        int[] resultInt = grapyproc(pixels, w, h);
        Bitmap resultImg = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);

        resultImg.setPixels(resultInt,0,w,0,0,w,h);
        imageView.setImageBitmap(resultImg);
    }

    @Override
    public void onResume(){
        super.onResume();
    }
}
