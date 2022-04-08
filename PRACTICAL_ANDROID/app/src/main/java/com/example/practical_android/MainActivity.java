package com.example.practical_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practical_android.database.AppDatabase;
import com.example.practical_android.database.ProductDao;
import com.example.practical_android.entity.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    ProductDao productDao ;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db  = AppDatabase.buildDatabaseInstance(  this, "android_exam" , false);
        Toast.makeText(this,  db.doesDatabaseExist(this,"android_exam"), Toast.LENGTH_SHORT).show();
        listAllProduct().forEach(p -> {
            Log.d("demo" , p.getName());
        });
    }
    public List<Product> listAllProduct(){
        productDao = db.productDao() ;
       return  productDao.getlAll();
    }




}