package com.guifa.store;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;

public class AppDataStore implements IDataStore {

    // mmkv实现
    public static final int SP_TYPE_MMKV = 0;
    // SharedPreferences实现
    public static final int SP_TYPE_SP = 1;

    private static final class ClassHolder {
        @SuppressLint("StaticFieldLeak")
        public static final AppDataStore INSTANCE = new AppDataStore();
    }

    public static AppDataStore getImpl() {
        return ClassHolder.INSTANCE;
    }

    private IDataStore iDataStore;
    private Context context;

    public void init(Context context) {
        init(context, SP_TYPE_MMKV, "app_sp_name");
    }

    /**
     * 默认使用mmkv方式存取
     *
     * @param spFileName 为 SharedPreferences 的名字，sp实现的时候需要传，mmkv不需要
     */
    public void init(Context context, int spType, String spFileName) {
        this.context = context;
        if (spType == SP_TYPE_SP) {
            iDataStore = new SPDataStoreImp(context, spFileName);
        } else {
            iDataStore = new MMKVDataStoreImp(context);
        }
    }

    public Context getContext() {
        return this.context;
    }

    @Override
    public void putString(String key, String value) {
        iDataStore.putString(key, value);
    }

    @Override
    public void putInt(String key, int value) {
        iDataStore.putInt(key, value);
    }

    @Override
    public void putBoolean(String key, boolean value) {
        iDataStore.putBoolean(key, value);
    }

    @Override
    public void putFloat(String key, float value) {
        iDataStore.putFloat(key, value);
    }

    @Override
    public void putLong(String key, long value) {
        iDataStore.putLong(key, value);
    }

    @Override
    public void putParcelable(String key, Parcelable value) {
        iDataStore.putParcelable(key, value);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return iDataStore.getString(key, defaultValue);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return iDataStore.getInt(key, defaultValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return iDataStore.getBoolean(key, defaultValue);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return iDataStore.getFloat(key, defaultValue);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return iDataStore.getLong(key, defaultValue);
    }

    @Override
    public <T extends Parcelable> T getParcelable(String key, Class<T> tClass) {
        return iDataStore.getParcelable(key, tClass);
    }
}