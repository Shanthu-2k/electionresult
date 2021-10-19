package com.example.agrishop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class AddVeg extends AppCompatActivity {
    private ImageView pImageView;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    private EditText ed1, ed2,ed3,ed4,ed5,ed6;
    Button b11,b12;
    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;
    private String[] cameraPermission;
    private String[] storagePermission;
    private Uri uri;
    private String name,price,category,contact,description,quantity;
    private DatabaseHelper dbHelper;
    long ins;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_veg);
        ed1 = findViewById(R.id.Name);
        ed2 = findViewById(R.id.Price);
        ed3=findViewById(R.id.Category);
        ed4=findViewById(R.id.Contact);
        ed5=findViewById(R.id.Desc);
        ed6=findViewById(R.id.quantity);
        pImageView=findViewById(R.id.Image);
        b11 = findViewById(R.id.add);

        cameraPermission = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        dbHelper=new DatabaseHelper(this);
        pImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePickDialog();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();

            }
        });

    }


    private void getData() {

        name = ""+ed1.getText().toString().trim();
        price = ""+ed2.getText().toString().trim();
        quantity = ""+ed6.getText().toString().trim();
        category = ""+ed3.getText().toString().trim();
        contact = ""+ed4.getText().toString().trim();
        description = ""+ed5.getText().toString().trim();
        if((name.equals(""))||(price.equals(""))||(quantity.equals(""))||(category.equals(""))||(contact.equals(""))||(description.equals("")))
        {
            Toast.makeText(this,"Don't make empty",Toast.LENGTH_SHORT).show();
        }
        if(!category.equals("Vegetables"))
        {
            Toast.makeText(this,"Category is Invalid !",Toast.LENGTH_SHORT).show();
        }
        if(!quantity.equals("1"))
        {
            Toast.makeText(this," Quantity is Invalid !",Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean regDetails = dbHelper.insertInfo("" + name, "" + price, "" + quantity, "" + category, "" + contact, "" + description, "" + uri);

            if (regDetails == true) {
                Toast.makeText(this, "Added Succesfully!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Added Failed!", Toast.LENGTH_SHORT).show();
            }
        }



    }
    private void imagePickDialog() {
        String[] options={"Camera","Gallery"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Select your image");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermission();
                    } else {
                        pickfromCamera();
                    }
                } else if (which == 1)
                {
                    if(!checkStoragePermission())
                    {
                        requestStoragePermission();
                    }
                    else
                    {
                        pickfromStorage();
                    }
                }

            }
        });
        builder.create().show();
    }
    private void pickfromStorage() {
        Intent galleryIntent=new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGE_PICK_GALLERY_CODE);
    }


    private void pickfromCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"Image Title");
        values.put(MediaStore.Images.Media.DESCRIPTION,"Image Descripttion");
        uri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
        Intent cameracontent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameracontent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(cameracontent,IMAGE_PICK_CAMERA_CODE);
    }

    private boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, storagePermission, STORAGE_REQUEST_CODE);

    }

    private boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result && result1;

    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermission, CAMERA_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case CAMERA_REQUEST_CODE:
            {
                if(grantResults.length>0)
                {
                    boolean cameraAccepted=grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted=grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted && storageAccepted)
                    {
                        pickfromCamera();
                    }
                    else
                    {
                        Toast.makeText(this,"Camera Permission requirerd",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
            case STORAGE_REQUEST_CODE:
            {
                if(grantResults.length>0)
                {
                    boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(storageAccepted)
                    {
                        pickfromStorage();
                    }
                    else
                    {
                        Toast.makeText(this,"Storage Permission requirerd",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK)
        {
            if(requestCode == IMAGE_PICK_GALLERY_CODE)
            {

                CropImage.activity(data.getData()).setGuidelines(CropImageView.Guidelines.ON).setAspectRatio(1,1).start(this);
            }
            else if (requestCode == IMAGE_PICK_CAMERA_CODE)
            {
                CropImage.activity(uri).setGuidelines(CropImageView.Guidelines.ON).setAspectRatio(1,1).start(this);

            }
            else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
            {
                CropImage.ActivityResult result=CropImage.getActivityResult(data);
                if(resultCode == RESULT_OK)
                {
                    Uri resultUri= result.getUri();
                    uri=resultUri;
                    pImageView.setImageURI(resultUri);
                }
                else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE)
                {
                    Exception error=result.getError();
                    Toast.makeText(this,""+error,Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}