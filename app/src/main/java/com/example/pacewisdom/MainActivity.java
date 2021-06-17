package com.example.pacewisdom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pacewisdom.Const.FileUtils;
import com.example.pacewisdom.Retrofit.ApiClient;
import com.example.pacewisdom.Retrofit.ApiInterface;
import com.example.pacewisdom.Services.Utility;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    ProgressDialog progressDialog;
    ImageView image_upload;
    Button btn_gallery,btn_submit;
    String profile_imageString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_upload=findViewById(R.id.image_upload);
        btn_gallery=findViewById(R.id.btn_gallery);
        btn_submit=findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveGallery();
            }
        });

        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryIntent();
            }
        });
    }
    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    profile_imageString= FileUtils.getPath(getApplicationContext(),data.getData());
                    onSelectFromGalleryResult(data);
                }


        }
    }
    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

            Bitmap bm=null;
            if (data != null) {
                try {
                    bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
            byte[] imageBytes = bytes.toByteArray();
            profile_imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            image_upload.setImageBitmap(bm);
            // DOC_TYPE="Image.jpg";
          //  DOC_TYPE = current_image+".png";
            Log.e("IMAGE",profile_imageString);


    }


    private void SaveGallery(){

        progressDialog = Utility.showProgressDialog(this);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<JsonElement> call = apiService.SaveGallery(profile_imageString);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.e("TAG", "uploaddata: " +response.body()+"//"+response.message());
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        alert();
                        //JSONObject dataobj = dataArray.getJSONObject(0);

                    }else{
                        //  Toast.makeText(getApplicationContext(), "Network error. Try again", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                } else {
                    //  Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.toString());
                progressDialog.dismiss();
                // Log error here since request failed
            }
        });





    }
    private  void alert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Data save successfully")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });
                /*.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    }
                });*/
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Successfully");
        alert.show();
    }

}