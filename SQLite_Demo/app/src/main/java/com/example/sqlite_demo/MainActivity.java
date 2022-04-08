package com.example.sqlite_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sqlite_demo.database.AppDatabase;
import com.example.sqlite_demo.database.Credential;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        //INSERT DATA
        insertDB();

        //GET DATA
        getAllCredential();

        //UPDATE
        update();

        //DELETE
        delete();
    }
    private void insertDB() {
        Credential credential = new Credential( "DaEhvF70NMAd2Itk4VIZia33cazkdDjp2OsJIzMDzcWY4eti2yjy81oj4z61gdsqKzzsWmoQj0SAFsRA1649075538",
                "lEzdMC5m5Cwk6I7YdJ7QSv1T1wp46kygwiVxNaOGfNQN2BKNfQkYvAEFsAvb73SbRHcrfgmpg3Ni2VHX1649075538",
                2,
                "2022-04-11T12:32:18.460428Z",
                "2022-04-04T12:32:18.000000Z",
                "2022-04-04T12:32:18.000000Z",
                1);
        db.credentialDao().insertCredential(credential);
    }
    private void update() {
        Credential credential = new Credential("DaEhvF70NMAd2Itk4VIZia33cazkdDjp2OsJIzMDzcWY4eti2yjy81oj4z61gdsqKzzsWmoQj0SAFsRA1649075538",
                "lEzdMC5m5Cwk6I7YdJ7QSv1T1wp46kygwiVxNaOGfNQN2BKNfQkYvAEFsAvb73SbRHcrfgmpg3Ni2VHX1649075538",
                2,
                "2022-04-11T12:32:18.460428Z",
                "2022-04-04T12:32:18.000000Z",
                "2022-04-04T12:32:18.000000Z",
                1);
    }
    private void getAllCredential() {
        List<Credential> credentialList = db.credentialDao().getAll();
        for (Credential credential :credentialList){
            Log.d("Credential",  "access_token: " + credential.getAccess_token() +
                    "refresh_token: " + credential.getRefresh_token() +
                    "account_id: " + credential.getAccount_id() +
                    "expire_time: " + credential.getExpire_time() +
                    "created_at: " + credential.getCreated_at() +
                    "updated_at: " + credential.getUpdated_at() +
                    "status: " + credential.getStatus());
        }
    }
    private void delete(){
        db.credentialDao().deleteAll();
    }
}