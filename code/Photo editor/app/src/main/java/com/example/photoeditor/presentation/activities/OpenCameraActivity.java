package com.example.photoeditor.presentation.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.ParametersController;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ColorOverlaySubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.SaturationSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.VignetteSubFilter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class OpenCameraActivity extends AppCompatActivity {

    LinearLayout scroll_bar;
    Button[] buttons;
    ImageView photo;
    Uri path;
    int lastid = 1, userRole, orientation, final_width;
    Bitmap original_image, outputImage, circle, filter_circle;
    Context context = this;
    Drawable thumbnail;
    String name;
    TextView back, save;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        System.loadLibrary("NativeImageProcessor");
        photo = (ImageView) findViewById(R.id.photo);
        back = (TextView) findViewById(R.id.back);
        back.setText("< Volver");
        save = (TextView) findViewById(R.id.save);
        save.setText("Guardar >");
        path = (Uri) getIntent().getParcelableExtra("photo");
        name = (String) getIntent().getStringExtra("name");
        userRole = getIntent().getExtras().getInt("userRole");
        photo.setImageURI(path);
        original_image = ((BitmapDrawable) photo.getDrawable()).getBitmap();
        circleThumbnail();
        ParametersController parametersController = new ParametersController(OpenCameraActivity.this);
        parametersController.getValidFilters(userRole);
    }

    public void circleThumbnail(){
        int height = (int) original_image.getHeight();
        int width = (int) original_image.getWidth();
        circle = original_image.copy(original_image.getConfig(),true);
        circle = getCircleBitmap(circle);
        circle = Bitmap.createScaledBitmap(circle,final_width,final_width*height/width,false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void createFilters(ArrayList<Integer> filters){
        buttons = new Button[filters.size()];
        scroll_bar = (LinearLayout) findViewById(R.id.FilterList);
        for(int i=0;i<filters.size();i++){
            buttons[i] = new Button(context);
            buttons[i].setBackgroundResource(R.drawable.shape);
            thumbnails(filters.get(i));
            buttons[i].setBackground(thumbnail);
            buttons[i].setId(filters.get(i));
            buttons[i].setOnClickListener(myClickBtn);
            buttons[i].setPadding(0,100,100,0);
            scroll_bar.addView(buttons[i]);
        }
    }

    View.OnClickListener myClickBtn = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case 1: {
                    photo.setImageURI(path);
                    lastid = v.getId();
                    break;
                }
                case 2:{
                    Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                    Filter myFilter = new Filter();
                    myFilter.addSubFilter(new VignetteSubFilter(context, 100));
                    outputImage = myFilter.processFilter(mutable);
                    photo.setImageBitmap(outputImage);
                    lastid = v.getId();
                    break;
                }
                case 3: {
                    Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                    Filter myFilter = new Filter();
                    myFilter.addSubFilter(new BrightnessSubFilter(30));
                    outputImage = myFilter.processFilter(mutable);
                    photo.setImageBitmap(outputImage);
                    lastid = v.getId();
                    break;
                }
                case 4: {
                    Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                    Filter myFilter = new Filter();
                    myFilter.addSubFilter(new ContrastSubFilter(1.2f));
                    outputImage = myFilter.processFilter(mutable);
                    photo.setImageBitmap(outputImage);
                    lastid = v.getId();
                    break;
                }
                case 5:{
                    Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                    Filter myFilter = new Filter();
                    myFilter.addSubFilter(new ColorOverlaySubFilter(100, .2f, .2f, .0f));
                    outputImage = myFilter.processFilter(mutable);
                    photo.setImageBitmap(outputImage);
                    lastid = v.getId();
                    break;
                }
                case 6:{
                    Bitmap mutable = original_image.copy(original_image.getConfig(),true);
                    Filter myFilter = new Filter();
                    myFilter.addSubFilter(new SaturationSubFilter(1.3f));
                    outputImage = myFilter.processFilter(mutable);
                    photo.setImageBitmap(outputImage);
                    lastid = v.getId();
                    break;
                }
                default: {
                    break;
                }
            }
        }
    };

    public void thumbnails (int id){
        switch (id) {
            case 1: {
                thumbnail = new BitmapDrawable(circle);
                break;
            }
            case 2:{
                thumbnail = new BitmapDrawable(circle);
                break;
            }
            case 3: {
                Bitmap mutable = circle.copy(circle.getConfig(),true);
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new BrightnessSubFilter(30));
                filter_circle = myFilter.processFilter(mutable);
                thumbnail = new BitmapDrawable(filter_circle);
                break;
            }
            case 4: {
                Bitmap mutable = circle.copy(circle.getConfig(),true);
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new ContrastSubFilter(1.2f));
                filter_circle = myFilter.processFilter(mutable);
                thumbnail = new BitmapDrawable(filter_circle);
                break;
            }
            case 5:{
                Bitmap mutable = circle.copy(circle.getConfig(),true);
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new ColorOverlaySubFilter(100, .2f, .2f, .0f));
                filter_circle = myFilter.processFilter(mutable);
                thumbnail = new BitmapDrawable(filter_circle);
                break;
            }
            case 6:{
                Bitmap mutable = circle.copy(circle.getConfig(),true);
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new SaturationSubFilter(1.3f));
                filter_circle = myFilter.processFilter(mutable);
                thumbnail = new BitmapDrawable(filter_circle);
                break;
            }
            default: {
                break;
            }
        }
    }

    private Bitmap getCircleBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);
        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect;
        if(bitmap.getWidth()>bitmap.getHeight()){
            final_width = 2000;
            rect = new Rect((bitmap.getWidth()-bitmap.getHeight())/2, 0, (bitmap.getWidth()-bitmap.getHeight())/2+bitmap.getHeight(), bitmap.getHeight());
        }else if(bitmap.getWidth()==bitmap.getHeight()){
            final_width = 1000;
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getWidth());
        }else{
            final_width = 1000;
            rect = new Rect(0, (bitmap.getHeight()-bitmap.getWidth())/2, bitmap.getWidth(), bitmap.getWidth() + (bitmap.getHeight()-bitmap.getWidth())/2);//rect = new Rect(0, (bitmap.getHeight()-bitmap.getWidth())/2, bitmap.getWidth(), bitmap.getHeight()/4+bitmap.getWidth());
        }
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0); paint.setColor(color);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return output;
    }

    public void Back(View view) {
        Intent home = new Intent(this, HomeActivity.class);
        home.putExtra("name",name);
        home.putExtra("userRole",userRole);
        startActivity(home);
    }

    public void Guardar(View view) {
        if(lastid!=1){
            photo.setImageURI(getImageUri(context, outputImage));
            outputImage.recycle();
            original_image.recycle();
            circle.recycle();
            filter_circle.recycle();
        }else{
            original_image.recycle();
            circle.recycle();
            filter_circle.recycle();
        }
        Intent save = new Intent(this, HomeActivity.class);
        save.putExtra("name",name);
        save.putExtra("userRole",userRole);
        startActivity(save);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}
