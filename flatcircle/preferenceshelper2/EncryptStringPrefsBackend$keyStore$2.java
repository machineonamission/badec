package io.flatcircle.preferenceshelper2;

import android.content.Context;
import java.security.KeyStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/security/KeyStore;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: EncryptStringPrefsBackend.kt */
final class EncryptStringPrefsBackend$keyStore$2 extends Lambda implements Function0<KeyStore> {
    final /* synthetic */ Context $context;
    final /* synthetic */ EncryptStringPrefsBackend this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EncryptStringPrefsBackend$keyStore$2(EncryptStringPrefsBackend encryptStringPrefsBackend, Context context) {
        super(0);
        this.this$0 = encryptStringPrefsBackend;
        this.$context = context;
    }

    public final KeyStore invoke() {
        return KeyStoreHelper.INSTANCE.getKeyStore(this.$context, "AndroidKeyStore", this.this$0.keyStoreAlias);
    }
}
