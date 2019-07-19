package com.example.photoeditor.presentation.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.photoeditor.R;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ColorOverlaySubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.SaturationSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.VignetteSubFilter;

public class OpenCameraActivity extends AppCompatActivity {

    LinearLayout scroll_bar;
    Button[] filters;
    ImageView photo;
    Uri path;
    int n, i;
    String[] filter_names;
    int[] buttons;
    Bitmap original_image, outputImage;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        System.loadLibrary("NativeImageProcessor");
        photo = (ImageView) findViewById(R.id.photo);
        path = (Uri) getIntent().getParcelableExtra("photo");
        photo.setImageURI(path);
        original_image = ((BitmapDrawable) photo.getDrawable()).getBitmap();

        //Número de filtros
        n=6;
        //Nombre de los filtros
        filter_names = new String[]{"No filter", "Vignette", "Brightness", "Contrast", "Color Overlay", "Saturation"};
        //Actividades
        buttons = new int[]{1,2,3,4,5,6};
        //Botones
        filters = new Button[n];
        scroll_bar = (LinearLayout) findViewById(R.id.FilterList);

        for(i=0;i<n;i++){
            filters[i] = new Button(this);
            filters[i].setText(filter_names[i]);
            filters[i].setId(buttons[i]);
            filters[i].setOnClickListener(myClickBtn);
            scroll_bar.addView(filters[i]);
        }
    }

    View.OnClickListener myClickBtn = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                    case 1: {
                        photo.setImageURI(path);
                        break;
                    }
                    case 2:{
                        Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                        Filter myFilter = new Filter();
                        myFilter.addSubFilter(new VignetteSubFilter(context, 100));
                        outputImage = myFilter.processFilter(mutable);
                        photo.setImageBitmap(outputImage);
                        break;
                    }
                    case 3: {
                        Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                        Filter myFilter = new Filter();
                        myFilter.addSubFilter(new BrightnessSubFilter(30));
                        outputImage = myFilter.processFilter(mutable);
                        photo.setImageBitmap(outputImage);
                        break;
                    }
                    case 4: {
                        Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                        Filter myFilter = new Filter();
                        myFilter.addSubFilter(new ContrastSubFilter(1.2f));
                        outputImage = myFilter.processFilter(mutable);
                        photo.setImageBitmap(outputImage);
                        break;
                    }
                    case 5:{
                        Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                        Filter myFilter = new Filter();
                        myFilter.addSubFilter(new ColorOverlaySubFilter(100, .2f, .2f, .0f));
                        outputImage = myFilter.processFilter(mutable);
                        photo.setImageBitmap(outputImage);
                        break;
                    }
                    case 6:{
                        Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                        Filter myFilter = new Filter();
                        myFilter.addSubFilter(new SaturationSubFilter(1.3f));
                        outputImage = myFilter.processFilter(mutable);
                        photo.setImageBitmap(outputImage);
                        break;
                    }
                    case 7:{
                        /*Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                        Filter myFilter = new Filter();
                        Point[] rgbKnots;
                        rgbKnots = new Point[3];
                        rgbKnots[0] = new Point(0, 0);
                        rgbKnots[1] = new Point(175, 139);
                        rgbKnots[2] = new Point(255, 255);

                        myFilter.addSubFilter(new ToneCurveSubFilter(rgbKnots, null, null, null));
                        Bitmap outputImage = myFilter.processFilter(mutable);*/
                        break;
                    }
                    case 8: {
                        Toast.makeText(context, "hola8", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 9: {
                        Toast.makeText(context, "hola9", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 10: {
                        Toast.makeText(context, "hola10", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default: {
                        break;
                    }
            }
        }
    };

    /*
    * Comprobaciones
    *
    * if (outputImage.sameAs(emptyBitmap)){
     *   photo.setImageURI(getImageUri(context, outputImage));
     * }
    *
    * */
}
