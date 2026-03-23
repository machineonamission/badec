package com.blueair.login;

import android.app.Application;
import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.FacebookService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u00130\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/login/SignInViewModel;", "Lcom/blueair/login/BaseLoginViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "facebookService", "Lcom/blueair/auth/FacebookService;", "getFacebookService", "()Lcom/blueair/auth/FacebookService;", "facebookService$delegate", "Lkotlin/Lazy;", "email", "Landroidx/lifecycle/MutableLiveData;", "", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "emailValid", "Landroidx/lifecycle/LiveData;", "", "getEmailValid", "()Landroidx/lifecycle/LiveData;", "_emailValid", "kotlin.jvm.PlatformType", "password", "getPassword", "passwordValid", "getPasswordValid", "_passwordValid", "confirmPrivacy", "getConfirmPrivacy", "privacyConfirmed", "getPrivacyConfirmed", "_privacyConfirmed", "emailLogin", "", "facebookLogout", "setPrivacyConfirmed", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SignInViewModel.kt */
public final class SignInViewModel extends BaseLoginViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SignInViewModel.class, "facebookService", "getFacebookService()Lcom/blueair/auth/FacebookService;", 0))};
    private final MutableLiveData<Boolean> _emailValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> _passwordValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> _privacyConfirmed = new MutableLiveData<>();
    private final MutableLiveData<Boolean> confirmPrivacy = new MutableLiveData<>();
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final Lazy facebookService$delegate;
    private final MutableLiveData<String> password = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignInViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new SignInViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.facebookService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, FacebookService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    private final FacebookService getFacebookService() {
        return (FacebookService) this.facebookService$delegate.getValue();
    }

    public final MutableLiveData<String> getEmail() {
        return this.email;
    }

    public final LiveData<Boolean> getEmailValid() {
        return this._emailValid;
    }

    public final MutableLiveData<String> getPassword() {
        return this.password;
    }

    public final LiveData<Boolean> getPasswordValid() {
        return this._passwordValid;
    }

    public final MutableLiveData<Boolean> getConfirmPrivacy() {
        return this.confirmPrivacy;
    }

    public final LiveData<Boolean> getPrivacyConfirmed() {
        return this._privacyConfirmed;
    }

    public final void emailLogin() {
        this._emailValid.setValue(Boolean.valueOf(Patterns.EMAIL_ADDRESS.matcher(String.valueOf(this.email.getValue())).matches()));
        this._passwordValid.setValue(Boolean.valueOf(String.valueOf(this.password.getValue()).length() > 5));
        Boolean value = getEmailValid().getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue()) {
            Boolean value2 = getPasswordValid().getValue();
            Intrinsics.checkNotNull(value2);
            if (value2.booleanValue()) {
                authenticateUser(new SignInViewModel$emailLogin$1(this, (Continuation<? super SignInViewModel$emailLogin$1>) null));
            }
        }
    }

    public final void facebookLogout() {
        getFacebookService().logOut();
    }

    public final void setPrivacyConfirmed() {
        this.confirmPrivacy.postValue(true);
    }
}
