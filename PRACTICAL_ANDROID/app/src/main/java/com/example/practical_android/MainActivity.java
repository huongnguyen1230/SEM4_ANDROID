package com.example.practical_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.practical_android.database.AppDatabase;
import com.example.practical_android.entity.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        //INSERT
        insertProduct();
        //GET DATA
        getAllProduct();

    }

    private void insertProduct() {
    }

    private void getAllProduct() {
        List<Product> productList = db.productDao().getAll();
        for (Product product : productList){
            Log.d("Product",  "id: " + product.getId() +
                    "name: " + product.getName() +
                    "quantity: " + product.getQuantity());
        }
    }
}