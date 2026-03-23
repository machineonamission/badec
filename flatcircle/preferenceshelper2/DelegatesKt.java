package io.flatcircle.preferenceshelper2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a@\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0003H\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ObservablePreference", "Lkotlin/properties/ReadWriteProperty;", "", "T", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "key", "", "initialDefault", "(Lio/flatcircle/preferenceshelper2/Prefs;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "preferenceshelper2_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: Delegates.kt */
public final class DelegatesKt {
    private static final <T> ReadWriteProperty<Object, T> ObservablePreference(Prefs prefs, String str, T t) {
        Intrinsics.needClassReification();
        PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
        PrefsBackend backend = prefs.getBackend();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new DelegatesKt$ObservablePreference$1(prefs, str, t, preferencesHelper.get(backend, str, t, Reflection.getOrCreateKotlinClass(Object.class)));
    }
}
