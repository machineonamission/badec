package com.blueair.core.service;

import android.content.Context;
import android.content.SharedPreferences;
import at.favre.lib.armadillo.Armadillo;
import at.favre.lib.armadillo.ArmadilloSharedPreferences;
import io.flatcircle.preferenceshelper2.BasicPrefsBackend;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078TX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/blueair/core/service/ArmadilloPrefsBackend;", "Lio/flatcircle/preferenceshelper2/BasicPrefsBackend;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "sharedPrefs$delegate", "Lkotlin/Lazy;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SecurePrefs.kt */
public final class ArmadilloPrefsBackend extends BasicPrefsBackend {
    private final Lazy sharedPrefs$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArmadilloPrefsBackend(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPrefs$delegate = LazyKt.lazy(new ArmadilloPrefsBackend$$ExternalSyntheticLambda0(context));
    }

    /* access modifiers changed from: protected */
    public SharedPreferences getSharedPrefs() {
        Object value = this.sharedPrefs$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    /* access modifiers changed from: private */
    public static final ArmadilloSharedPreferences sharedPrefs_delegate$lambda$0(Context context) {
        return Armadillo.create(context, "blueair_secure_prefs").encryptionFingerprint(context).enableDerivedPasswordCache(true).build();
    }
}
