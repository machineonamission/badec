package com.blueair.core.util;

import androidx.exifinterface.media.ExifInterface;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.preferenceshelper2.PrefsBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a@\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0003H\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ObservableVolatilePreference", "Lkotlin/properties/ReadWriteProperty;", "", "T", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "key", "", "initialDefault", "(Lio/flatcircle/preferenceshelper2/Prefs;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "core_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: PrefUtils.kt */
public final class PrefUtilsKt {
    public static final /* synthetic */ <T> ReadWriteProperty<Object, T> ObservableVolatilePreference(Prefs prefs, String str, T t) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(t, "initialDefault");
        PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
        PrefsBackend backend = prefs.getBackend();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = preferencesHelper.get(backend, str, t, Reflection.getOrCreateKotlinClass(Object.class));
        Intrinsics.needClassReification();
        return new PrefUtilsKt$ObservableVolatilePreference$1(prefs, str, t, obj);
    }
}
