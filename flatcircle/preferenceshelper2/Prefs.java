package io.flatcircle.preferenceshelper2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\b\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\bJ\u0006\u0010\u000b\u001a\u00020\bJ.\u0010\f\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u0001H\tH\b¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u0012\u001a\u00020\b\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u0002H\tH\b¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lio/flatcircle/preferenceshelper2/Prefs;", "", "backend", "Lio/flatcircle/preferenceshelper2/PrefsBackend;", "(Lio/flatcircle/preferenceshelper2/PrefsBackend;)V", "getBackend", "()Lio/flatcircle/preferenceshelper2/PrefsBackend;", "addCustomAdapter", "", "T", "adapter", "clear", "get", "key", "", "default", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: Prefs.kt */
public class Prefs {
    private final PrefsBackend backend;

    public Prefs(PrefsBackend prefsBackend) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "backend");
        this.backend = prefsBackend;
    }

    public final PrefsBackend getBackend() {
        return this.backend;
    }

    private final <T> T get(String str, T t) throws IllegalArgumentException {
        PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
        PrefsBackend backend2 = getBackend();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return preferencesHelper.get(backend2, str, t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    private final <T> void set(String str, T t) {
        PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
        PrefsBackend backend2 = getBackend();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        preferencesHelper.set(backend2, str, t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final void remove(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        PreferencesHelper.INSTANCE.remove(this.backend, str);
    }

    public final void clear() {
        PreferencesHelper.INSTANCE.clear(this.backend);
    }

    private final <T> void addCustomAdapter(Object obj) {
        PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        preferencesHelper.addCustomAdapter(obj, Reflection.getOrCreateKotlinClass(Object.class));
    }

    static /* synthetic */ Object get$default(Prefs prefs, String str, Object obj, int i, Object obj2) throws IllegalArgumentException {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                obj = null;
            }
            PreferencesHelper preferencesHelper = PreferencesHelper.INSTANCE;
            PrefsBackend backend2 = prefs.getBackend();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return preferencesHelper.get(backend2, str, obj, Reflection.getOrCreateKotlinClass(Object.class));
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }
}
