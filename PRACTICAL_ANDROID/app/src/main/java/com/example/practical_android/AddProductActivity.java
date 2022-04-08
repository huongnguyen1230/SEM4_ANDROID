package com.example.practical_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical_android.database.AppDatabase;
import com.example.practical_android.database.ProductDao;
import com.example.practical_android.entity.Product;

import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    Button btnView;
    Button btnAdd;
    EditText etName,etQuantity;
    AppDatabase db;
    ProductDao productDao ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        initData();
        initListener();
//        getAllProduct();
        db  = AppDatabase.buildDatabaseInstance(  this, "android_exam" , false);
        Toast.makeText(this,  db.doesDatabaseExist(this,"android_exam"), Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
    }
    private void initListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = etName.getText().toString();
                int  quantity = Integer.parseInt(etQuantity.getText().toString());
                Product  p  = new Product(productName , quantity) ;
                addProduct(p);
                Intent intent = new Intent(AddProductActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
    void addProduct(Product p ){
        productDao = db.productDao() ;
        productDao.add(p);
        Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
    }

}