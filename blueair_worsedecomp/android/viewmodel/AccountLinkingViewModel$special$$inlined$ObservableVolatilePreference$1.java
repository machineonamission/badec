package com.blueair.android.viewmodel;

import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0002\u001a\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010¸\u0006\u0000"}, d2 = {"com/blueair/core/util/PrefUtilsKt$ObservableVolatilePreference$1", "Lkotlin/properties/ObservableProperty;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "afterChange", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PrefUtils.kt */
public final class AccountLinkingViewModel$special$$inlined$ObservableVolatilePreference$1 extends ObservableProperty<Boolean> {
    final /* synthetic */ Object $initialDefault;
    final /* synthetic */ String $key;
    final /* synthetic */ Prefs $prefs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountLinkingViewModel$special$$inlined$ObservableVolatilePreference$1(Prefs prefs, String str, Object obj, Object obj2) {
        super(obj2);
        this.$prefs = prefs;
        this.$key = str;
        this.$initialDefault = obj;
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Boolean, java.lang.Object] */
    public Boolean getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Prefs prefs = this.$prefs;
        return PreferencesHelper.INSTANCE.get(prefs.getBackend(), this.$key, this.$initialDefault, Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public void setValue(Object obj, KProperty<?> kProperty, Boolean bool) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(bool, "value");
        Object value = getValue(obj, kProperty);
        if (beforeChange(kProperty, value, bool)) {
            afterChange(kProperty, value, bool);
        }
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(bool, "oldValue");
        Intrinsics.checkNotNullParameter(bool2, "newValue");
        if (!Intrinsics.areEqual((Object) bool2, (Object) bool)) {
            Prefs prefs = this.$prefs;
            PreferencesHelper.INSTANCE.set(prefs.getBackend(), this.$key, bool2, Reflection.getOrCreateKotlinClass(Boolean.class));
        }
    }
}
