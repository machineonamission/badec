package com.blueair.core.service;

import android.content.Context;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/service/SecurePrefs;", "Lio/flatcircle/preferenceshelper2/Prefs;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SecurePrefs.kt */
public final class SecurePrefs extends Prefs {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecurePrefs(Context context) {
        super(new ArmadilloPrefsBackend(context));
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
