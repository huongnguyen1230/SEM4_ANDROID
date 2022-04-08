package com.example.sqlite_demo.database;

import static android.icu.text.MessagePattern.ArgType.SELECT;
import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CredentialDao {
    @Insert(onConflict = REPLACE)
    void insertCredential(Credential credential);

    @Update
    void updateCredential(Credential credential);

    @Delete
    void deleteCredential(Credential credential);

    @Query("SELECT * FROM credentials")
    List<Credential> getAll();

    @Query("SELECT * FROM credentials WHERE account_id = :account_id")
    Credential getCredential(int account_id);

    @Query("DELETE FROM credentials")
    void deleteAll();
}
