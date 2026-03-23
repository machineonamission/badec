package io.flatcircle.preferenceshelper2;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068TX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lio/flatcircle/preferenceshelper2/BasicPrefsBackend;", "Lio/flatcircle/preferenceshelper2/PrefsBackend;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "sharedPrefs$delegate", "Lkotlin/Lazy;", "clear", "", "contains", "", "key", "", "getBoolean", "fallbackVal", "getFloat", "", "getInt", "", "getLong", "", "getString", "remove", "setBoolean", "value", "setFloat", "setInt", "setLong", "setString", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: BasicPrefsBackend.kt */
public class BasicPrefsBackend implements PrefsBackend {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(BasicPrefsBackend.class), "sharedPrefs", "getSharedPrefs()Landroid/content/SharedPreferences;"))};
    private final Lazy sharedPrefs$delegate;

    /* access modifiers changed from: protected */
    public SharedPreferences getSharedPrefs() {
        Lazy lazy = this.sharedPrefs$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (SharedPreferences) lazy.getValue();
    }

    public BasicPrefsBackend(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.sharedPrefs$delegate = LazyKt.lazy(new BasicPrefsBackend$sharedPrefs$2(context));
    }

    public boolean contains(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return getSharedPrefs().contains(str);
    }

    public void remove(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        getSharedPrefs().edit().remove(str).apply();
    }

    public void setLong(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        getSharedPrefs().edit().putLong(str, j).apply();
    }

    public long getLong(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return getSharedPrefs().getLong(str, j);
    }

    public void setInt(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        getSharedPrefs().edit().putInt(str, i).apply();
    }

    public int getInt(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return getSharedPrefs().getInt(str, i);
    }

    public void setFloat(String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        getSharedPrefs().edit().putFloat(str, f).apply();
    }

    public float getFloat(String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return getSharedPrefs().getFloat(str, f);
    }

    public void setString(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        getSharedPrefs().edit().putString(str, str2).apply();
    }

    public String getString(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "fallbackVal");
        String string = getSharedPrefs().getString(str, str2);
        Intrinsics.checkExpressionValueIsNotNull(string, "sharedPrefs.getString(key, fallbackVal)");
        return string;
    }

    public void setBoolean(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        getSharedPrefs().edit().putBoolean(str, z).apply();
    }

    public boolean getBoolean(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return getSharedPrefs().getBoolean(str, z);
    }

    public void clear() {
        getSharedPrefs().edit().clear().apply();
    }
}
