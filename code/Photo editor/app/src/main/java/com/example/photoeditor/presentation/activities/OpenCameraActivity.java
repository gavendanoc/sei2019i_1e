package com.example.photoeditor.presentation.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.photoeditor.R;

public class OpenCameraActivity extends AppCompatActivity {

    LinearLayout scroll_bar;
    Button[] filters;
    ImageView photo;
    Uri path;
    int n;
    String[] filter_names;
    int[] botones;
    Context contexto;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        photo = (ImageView) findViewById(R.id.photo);
        path = (Uri) getIntent().getParcelableExtra("photo");
        photo.setImageURI(path);
        contexto = this;

        //Número de filtros
        n=10;
        //Nombre de los filtros
        filter_names = new String[]{"Hola1", "Hola2", "Hola3", "Hola4", "Hola5", "Hola6", "Hola7", "Hola8", "Hola9", "Hola10"};
        //        //Actividades
        botones = new int[]{1,2,3,4,5,6,7,8,9,10};
        //Botones
        filters = new Button[n];
        scroll_bar = (LinearLayout) findViewById(R.id.FilterList);

        for(i=0;i<n;i++){
            filters[i] = new Button(this);
            filters[i].setText(filter_names[i]);
            filters[i].setId(botones[i]);
            filters[i].setOnClickListener(myClickBtn);
            scroll_bar.addView(filters[i]);
        }
    }

    View.OnClickListener myClickBtn = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                    case 1:
                        Toast.makeText(contexto, "hola1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(contexto, "hola2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(contexto, "hola3", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(contexto, "hola4", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(contexto, "hola5", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(contexto, "hola6", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(contexto, "hola7", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(contexto, "hola8", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(contexto, "hola9", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(contexto, "hola10", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
            }
        }
    };
}
