package io.flatcircle.preferenceshelper2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"io/flatcircle/preferenceshelper2/DelegatesKt$ObservablePreference$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: Delegates.kt */
public final class DelegatesKt$ObservablePreference$1 extends ObservableProperty<T> {
    final /* synthetic */ Object $initialDefault;
    final /* synthetic */ String $key;
    final /* synthetic */ Prefs $prefs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DelegatesKt$ObservablePreference$1(Prefs prefs, String str, Object obj, Object obj2) {
        super(obj2);
        this.$prefs = prefs;
        this.$key = str;
        this.$initialDefault = obj;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        Intrinsics.checkParameterIsNotNull(t, "oldValue");
        Intrinsics.checkParameterIsNotNull(t2, "newValue");
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
