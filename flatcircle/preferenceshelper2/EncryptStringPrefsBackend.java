package io.flatcircle.preferenceshelper2;

import android.content.Context;
import java.security.KeyStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/flatcircle/preferenceshelper2/EncryptStringPrefsBackend;", "Lio/flatcircle/preferenceshelper2/BasicPrefsBackend;", "keyStoreAlias", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "keyStore", "Ljava/security/KeyStore;", "getKeyStore", "()Ljava/security/KeyStore;", "keyStore$delegate", "Lkotlin/Lazy;", "getString", "key", "fallbackVal", "setString", "", "value", "Companion", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: EncryptStringPrefsBackend.kt */
public final class EncryptStringPrefsBackend extends BasicPrefsBackend {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(EncryptStringPrefsBackend.class), "keyStore", "getKeyStore()Ljava/security/KeyStore;"))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_STORE_PROVIDER = "AndroidKeyStore";
    private final Lazy keyStore$delegate;
    /* access modifiers changed from: private */
    public final String keyStoreAlias;

    private final KeyStore getKeyStore() {
        Lazy lazy = this.keyStore$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (KeyStore) lazy.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EncryptStringPrefsBackend(String str, Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(str, "keyStoreAlias");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.keyStoreAlias = str;
        if (str.length() > 0) {
            this.keyStore$delegate = LazyKt.lazy(new EncryptStringPrefsBackend$keyStore$2(this, context));
            return;
        }
        throw new IllegalStateException("keyStoreAlias should be non-null".toString());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/flatcircle/preferenceshelper2/EncryptStringPrefsBackend$Companion;", "", "()V", "KEY_STORE_PROVIDER", "", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: EncryptStringPrefsBackend.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void setString(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        super.setString(str, KeyStoreHelper.INSTANCE.encryptString(getKeyStore(), this.keyStoreAlias, str2));
    }

    public String getString(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "fallbackVal");
        return KeyStoreHelper.INSTANCE.decryptString(getKeyStore(), this.keyStoreAlias, super.getString(str, str2));
    }
}
