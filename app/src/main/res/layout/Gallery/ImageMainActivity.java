package com.cec.doctor.Gallery;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cec.doctor.R;

public class ImageMainActivity extends Activity implements MediaScannerConnection.MediaScannerConnectionClient {
    public String[] allFiles;
    private String SCAN_PATH ;
    private static final String FILE_TYPE = "*/*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_grid_layout);
//        getWindow().getDecorView().setBackgroundColor(Color.BLUE);

//        variable declaration

        GridView gridViewP = findViewById(R.id.gridViewP);
        GridView gridViewE = findViewById(R.id.gridViewE);

        // Instance of ImageAdapter Class
        gridViewP.setAdapter(new ImageAdapter(this));
        gridViewE.setAdapter(new ImageAdapter(this));


        /*
          On Click event for Single Gridview Item
          */
        gridViewE.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        gridViewP.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });

    }

    @Override
    public void onMediaScannerConnected() {

    }

    @Override
    public void onScanCompleted(String path,Uri uri) {

    }
}

