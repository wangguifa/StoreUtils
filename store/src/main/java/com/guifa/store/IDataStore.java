package com.guifa.store;

import android.os.Parcelable;

public interface IDataStore {

    void putString(String key, String value);

    void putInt(String key, int value);

    void putBoolean(String key, boolean value);

    void putFloat(String key, float value);

    void putLong(String key, long value);

    void putParcelable(String key, Parcelable value);

    String getString(String key, String defaultValue);

    int getInt(String key, int defaultValue);

    boolean getBoolean(String key, boolean defaultValue);

    float getFloat(String key, float defaultValue);

    long getLong(String key, long defaultValue);

    <T extends Parcelable> T getParcelable(String key, Class<T> tClass);
}