package com.blueair.auth;

import com.blueair.auth.retrofit.AblUserApi;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Delegates.kt */
public final class AuthService$special$$inlined$observable$1 extends ObservableProperty<AblUserApi.AblUser> {
    final /* synthetic */ AuthService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthService$special$$inlined$observable$1(Object obj, AuthService authService) {
        super(obj);
        this.this$0 = authService;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, AblUserApi.AblUser ablUser, AblUserApi.AblUser ablUser2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        AblUserApi.AblUser ablUser3 = ablUser2;
        if (!Intrinsics.areEqual((Object) ablUser3, (Object) ablUser)) {
            if (Intrinsics.areEqual((Object) ablUser3, (Object) new AblUserApi.AblUser(0, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 4095, (DefaultConstructorMarker) null))) {
                this.this$0.securePrefs.remove(PrefKeys.AblUser);
            } else {
                PreferencesHelper.INSTANCE.set(this.this$0.securePrefs.getBackend(), PrefKeys.AblUser, ablUser3, Reflection.getOrCreateKotlinClass(AblUserApi.AblUser.class));
            }
            this.this$0.setUsername(ablUser3.getUsername());
        }
    }
}
