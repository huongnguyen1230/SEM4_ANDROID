package com.example.practical_android.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practical_android.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("Select * from products limit 100")
    List<Product> getlAll();
    @Insert
    void add(Product c);
    @Update
    void update(Product c);
    @Delete
    void delete(Product c );
    @Query("select * from products where id = :id")
    Product getyId(int id);
}
