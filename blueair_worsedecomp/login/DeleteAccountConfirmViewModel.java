package com.blueair.login;

import android.app.Application;
import androidx.lifecycle.ViewModelKt;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.login.DeleteAccountState;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\u001eR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/blueair/login/DeleteAccountConfirmViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "logoutService", "Lcom/blueair/auth/LogOutService;", "getLogoutService", "()Lcom/blueair/auth/LogOutService;", "logoutService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/blueair/login/DeleteAccountState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteAccount", "", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeleteAccountConfirmViewModel.kt */
public final class DeleteAccountConfirmViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public final MutableStateFlow<DeleteAccountState> _state;
    private final Lazy authService$delegate;
    private final Lazy locationService$delegate;
    private final Lazy logoutService$delegate;
    private final StateFlow<DeleteAccountState> state;

    static {
        Class<DeleteAccountConfirmViewModel> cls = DeleteAccountConfirmViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "logoutService", "getLogoutService()Lcom/blueair/auth/LogOutService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteAccountConfirmViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeleteAccountConfirmViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeleteAccountConfirmViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.logoutService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, LogOutService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DeleteAccountConfirmViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        MutableStateFlow<DeleteAccountState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DeleteAccountState.Idle(getLocationService().getCountry()));
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LogOutService getLogoutService() {
        return (LogOutService) this.logoutService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public final StateFlow<DeleteAccountState> getState() {
        return this.state;
    }

    public final void deleteAccount() {
        getLocationService().getCountry();
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountConfirmViewModel$deleteAccount$1(this, (Continuation<? super DeleteAccountConfirmViewModel$deleteAccount$1>) null), 3, (Object) null);
    }
}
