package com.guifa.store;

import android.content.Context;
import android.os.Parcelable;

import com.tencent.mmkv.MMKV;

import java.io.File;

/**
 * mmkv实现类
 */
public class MMKVDataStoreImp implements IDataStore {

    private final MMKV mmkv;

    public MMKVDataStoreImp(Context context) {
        File parentFile = context.getFilesDir().getParentFile();
        if (parentFile != null) {
            MMKV.initialize(context, parentFile.getAbsolutePath() + "/mmkv");
        } else {
            MMKV.initialize(context);
        }
        mmkv = MMKV.defaultMMKV(MMKV.MULTI_PROCESS_MODE, null);
    }

    @Override
    public void putString(String key, String value) {
        mmkv.encode(key, value);
    }

    @Override
    public void putInt(String key, int value) {
        mmkv.encode(key, value);
    }

    @Override
    public void putBoolean(String key, boolean value) {
        mmkv.encode(key, value);
    }

    @Override
    public void putFloat(String key, float value) {
        mmkv.encode(key, value);
    }

    @Override
    public void putLong(String key, long value) {
        mmkv.encode(key, value);
    }

    @Override
    public void putParcelable(String key, Parcelable value) {
        mmkv.encode(key, value);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return mmkv.decodeString(key, defaultValue);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return mmkv.decodeInt(key, defaultValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return mmkv.decodeBool(key, defaultValue);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return mmkv.decodeFloat(key, defaultValue);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return mmkv.decodeLong(key, defaultValue);
    }

    @Override
    public <T extends Parcelable> T getParcelable(String key, Class<T> tClass) {
        return mmkv.decodeParcelable(key, tClass);
    }
}