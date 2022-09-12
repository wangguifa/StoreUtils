package com.guifa.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.Gson;

/**
 * SharedPreferences实现类
 */
public class SPDataStoreImp implements IDataStore {

    private final SharedPreferences.Editor edit;
    private final SharedPreferences appSp;

    @SuppressLint("CommitPrefEdits")
    public SPDataStoreImp(Context context, String spFileName) {
        appSp = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        edit = appSp.edit();
    }

    @Override
    public void putString(String key, String value) {
        edit.putString(key, value).apply();
    }

    @Override
    public void putInt(String key, int value) {
        edit.putInt(key, value).apply();
    }

    @Override
    public void putBoolean(String key, boolean value) {
        edit.putBoolean(key, value).apply();
    }

    @Override
    public void putFloat(String key, float value) {
        edit.putFloat(key, value).apply();
    }

    @Override
    public void putLong(String key, long value) {
        edit.putLong(key, value).apply();
    }

    @Override
    public void putParcelable(String key, Parcelable value) {
        try {
            String s = new Gson().toJson(value);
            edit.putString(key, s).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getString(String key, String defaultValue) {
        return appSp.getString(key, defaultValue);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return appSp.getInt(key, defaultValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return appSp.getBoolean(key, defaultValue);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return appSp.getFloat(key, defaultValue);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return appSp.getLong(key, defaultValue);
    }

    @Override
    public <T extends Parcelable> T getParcelable(String key, Class<T> tClass) {
        try {
            String string = getString(key, "");
            if (!TextUtils.isEmpty(string)) {
                return new Gson().fromJson(string, tClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}