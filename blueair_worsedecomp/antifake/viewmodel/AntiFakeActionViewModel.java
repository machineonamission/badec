package com.blueair.antifake.viewmodel;

import android.app.Application;
import com.blueair.auth.AuthService;
import com.blueair.core.PrefKeys;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "unsecurePrefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getUnsecurePrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "unsecurePrefs$delegate", "isUserLoggedIn", "", "()Z", "<set-?>", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "loginPendingAction", "getLoginPendingAction", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "setLoginPendingAction", "(Lcom/blueair/viewcore/activity/LoginPendingAction;)V", "loginPendingAction$delegate", "Lkotlin/properties/ReadWriteProperty;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AntiFakeActionViewModel.kt */
public final class AntiFakeActionViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final Lazy authService$delegate;
    private final ReadWriteProperty loginPendingAction$delegate;
    private final Lazy unsecurePrefs$delegate;

    static {
        Class<AntiFakeActionViewModel> cls = AntiFakeActionViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "unsecurePrefs", "getUnsecurePrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "loginPendingAction", "getLoginPendingAction()Lcom/blueair/viewcore/activity/LoginPendingAction;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AntiFakeActionViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AntiFakeActionViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AntiFakeActionViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.unsecurePrefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        Prefs unsecurePrefs = getUnsecurePrefs();
        LoginPendingAction empty = LoginPendingAction.Companion.getEMPTY();
        this.loginPendingAction$delegate = new AntiFakeActionViewModel$special$$inlined$ObservablePreference$1(unsecurePrefs, PrefKeys.KEY_LOGIN_PENDING_ACTION, empty, PreferencesHelper.INSTANCE.get(unsecurePrefs.getBackend(), PrefKeys.KEY_LOGIN_PENDING_ACTION, empty, Reflection.getOrCreateKotlinClass(LoginPendingAction.class)));
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final UnsecurePrefs getUnsecurePrefs() {
        return (UnsecurePrefs) this.unsecurePrefs$delegate.getValue();
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final LoginPendingAction getLoginPendingAction() {
        return (LoginPendingAction) this.loginPendingAction$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setLoginPendingAction(LoginPendingAction loginPendingAction) {
        Intrinsics.checkNotNullParameter(loginPendingAction, "<set-?>");
        this.loginPendingAction$delegate.setValue(this, $$delegatedProperties[2], loginPendingAction);
    }
}
