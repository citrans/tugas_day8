package com.example.penyimpanan_internal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME = "namafile.txt";
    Button buatFile, ubahFile, bacaFile, deleteFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buatFile = findViewById(R.id.btn_create);
        ubahFile = findViewById(R.id.btn_update);
        bacaFile = findViewById(R.id.btn_read);
        deleteFile = findViewById(R.id.btn_delete);
        textBaca = findViewById(R.id.text_baca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { jalankanPerintah(v.getId());  }

    public void jalankanPerintah(int id) {
        switch (id){
            case R.id.btn_create:
                buatFile();
                break;
            case R.id.btn_read:
                bacaFile();
                break;
            case R.id.btn_update:
                ubahFile();
                break;
            case R.id.btn_delete:
                hapusFile();
                break;
        }
    }

    public void ubahFile() {
    }

    public void bacaFile() {
    }

    void buatFile(){
        String isiFile = "Coba Isi Data File Text";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void hapusFile(){
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()){
            file.delete();
        }
    }


}