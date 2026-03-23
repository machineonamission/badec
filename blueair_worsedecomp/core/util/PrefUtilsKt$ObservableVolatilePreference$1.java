package com.blueair.core.util;

import androidx.exifinterface.media.ExifInterface;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.preferenceshelper2.PrefsBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0002\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"com/blueair/core/util/PrefUtilsKt$ObservableVolatilePreference$1", "Lkotlin/properties/ObservableProperty;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "afterChange", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 176)
/* compiled from: PrefUtils.kt */
public final class PrefUtilsKt$ObservableVolatilePreference$1 extends ObservableProperty<T> {
    final /* synthetic */ T $initialDefault;
    final /* synthetic */ String $key;
    final /* synthetic */ Prefs $prefs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrefUtilsKt$ObservableVolatilePreference$1(Prefs prefs, String str, T t, T t2) {
        super(t2);
        this.$prefs = prefs;
        this.$key = str;
        this.$initialDefault = t;
    }

    public T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Prefs prefs = this.$prefs;
        String str = this.$key;
        T t = this.$initialDefault;
        PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
        PrefsBackend backend = prefs.getBackend();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return preferencesHelper.get(backend, str, t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public void setValue(Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "value");
        Object value = getValue(obj, kProperty);
        if (beforeChange(kProperty, value, t)) {
            afterChange(kProperty, value, t);
        }
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "oldValue");
        Intrinsics.checkNotNullParameter(t2, "newValue");
        if (!Intrinsics.areEqual((Object) t2, (Object) t)) {
            Prefs prefs = this.$prefs;
            String str = this.$key;
            PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
            PrefsBackend backend = prefs.getBackend();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            preferencesHelper.set(backend, str, t2, Reflection.getOrCreateKotlinClass(Object.class));
        }
    }
}
