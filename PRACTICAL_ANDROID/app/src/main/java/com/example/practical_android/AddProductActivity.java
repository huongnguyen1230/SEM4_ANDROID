package com.example.practical_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical_android.database.AppDatabase;
import com.example.practical_android.entity.Product;

public class AddProductActivity extends AppCompatActivity {

    Button btnView;
    Button btnAdd;
    EditText etName,etQuantity;
    AppDatabase db;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        initData();
        initListener();
        db = AppDatabase.getAppDatabase(this);
        context = this;
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
                String quantity = etQuantity.getText().toString();
                try {
                    Product product = new Product();
                    product.setName(productName);
                    product.setQuantity(Integer.parseInt(quantity));
                    db.productDao().insertProduct(product);
                    CharSequence charSequence = "Successfully !";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                    context.startActivity(new Intent(context, MainActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}