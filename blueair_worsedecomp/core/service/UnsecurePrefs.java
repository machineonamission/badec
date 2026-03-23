package com.blueair.core.service;

import android.content.Context;
import com.blueair.core.PrefKeys;
import com.blueair.core.util.LocaleUtils;
import io.flatcircle.preferenceshelper2.BasicPrefsBackend;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/service/UnsecurePrefs;", "Lio/flatcircle/preferenceshelper2/Prefs;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isTempCelsius", "", "()Z", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SecurePrefs.kt */
public final class UnsecurePrefs extends Prefs {
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsecurePrefs(Context context2) {
        super(new BasicPrefsBackend(context2));
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final boolean isTempCelsius() {
        return ((Boolean) PreferencesHelper.INSTANCE.get(getBackend(), PrefKeys.TempIsCelsius, Boolean.valueOf(!LocaleUtils.INSTANCE.isUsLocale(this.context)), Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }
}
