package com.example.sqlite_demo.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "credentials")
public class Credential {
    @PrimaryKey
    @ColumnInfo(name = "access_token")
    private String access_token;

    @ColumnInfo(name = "refresh_token")
    private String refresh_token;

    @ColumnInfo(name = "account_id")
    private int account_id;

    @ColumnInfo(name = "expire_time")
    private String expire_time;

    @ColumnInfo(name = "created_at")
    private String created_at;

    @ColumnInfo(name = "updated_at")
    private String updated_at;

    @ColumnInfo(name = "status")
    private int status;

    public Credential() {
    }

    public Credential(String access_token, String refresh_token, int account_id, String expire_time, String created_at, String updated_at, int status) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.account_id = account_id;
        this.expire_time = expire_time;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
