package com.blueair.login;

import android.app.Application;
import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.service.AnalyticsService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/blueair/login/ForgotPasswordViewModel;", "Lcom/blueair/login/BaseLoginViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "Lkotlin/Lazy;", "email", "Landroidx/lifecycle/MutableLiveData;", "", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "emailValid", "Landroidx/lifecycle/LiveData;", "", "getEmailValid", "()Landroidx/lifecycle/LiveData;", "_emailValid", "forgotFinished", "", "getForgotFinished", "_forgotFinished", "_forgotPasswordFailure", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/blueair/login/LoginFailure;", "forgotPasswordFailure", "Lkotlinx/coroutines/flow/StateFlow;", "getForgotPasswordFailure", "()Lkotlinx/coroutines/flow/StateFlow;", "checkEmailInput", "forgotPassword", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ForgotPasswordViewModel.kt */
public final class ForgotPasswordViewModel extends BaseLoginViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ForgotPasswordViewModel.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0))};
    private final MutableLiveData<Boolean> _emailValid = new MutableLiveData<>(false);
    /* access modifiers changed from: private */
    public final MutableLiveData<Unit> _forgotFinished = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableStateFlow<LoginFailure> _forgotPasswordFailure;
    private final Lazy analyticsService$delegate;
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final StateFlow<LoginFailure> forgotPasswordFailure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForgotPasswordViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new ForgotPasswordViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analyticsService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        MutableStateFlow<LoginFailure> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._forgotPasswordFailure = MutableStateFlow;
        this.forgotPasswordFailure = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final AnalyticsService getAnalyticsService() {
        return (AnalyticsService) this.analyticsService$delegate.getValue();
    }

    public final MutableLiveData<String> getEmail() {
        return this.email;
    }

    public final LiveData<Boolean> getEmailValid() {
        return this._emailValid;
    }

    public final LiveData<Unit> getForgotFinished() {
        return this._forgotFinished;
    }

    public final StateFlow<LoginFailure> getForgotPasswordFailure() {
        return this.forgotPasswordFailure;
    }

    public final void checkEmailInput() {
        this._emailValid.setValue(Boolean.valueOf(Patterns.EMAIL_ADDRESS.matcher(String.valueOf(this.email.getValue())).matches()));
    }

    public final void forgotPassword() {
        Boolean value = getEmailValid().getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue()) {
            loadingLaunch(new ForgotPasswordViewModel$forgotPassword$1(this, (Continuation<? super ForgotPasswordViewModel$forgotPassword$1>) null));
        }
    }
}
