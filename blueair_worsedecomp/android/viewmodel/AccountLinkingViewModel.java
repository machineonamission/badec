package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.blueair.android.BlueairApp;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.viewmodel.LinkingState;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.PrefKeys;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.crypto.tink.subtle.Base64;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
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

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020BJ\u0006\u0010I\u001a\u00020JJ\u0018\u0010K\u001a\u00020J2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020 J\u0010\u0010O\u001a\u00020H2\b\u0010L\u001a\u0004\u0018\u00010MJ\b\u0010P\u001a\u00020\u001cH\u0002J\u0012\u0010Q\u001a\u00020 2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\b\u0010R\u001a\u00020 H\u0002J\u0006\u0010S\u001a\u00020HJ\u000e\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020 J\u0006\u0010V\u001a\u00020JR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0011\u0010$\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u001a\u0010&\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010)R+\u0010.\u001a\u00020 2\u0006\u0010-\u001a\u00020 8F@FX\u0002¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b/\u0010!\"\u0004\b0\u0010)R+\u00104\u001a\u0002032\u0006\u0010-\u001a\u0002038F@FX\u0002¢\u0006\u0012\n\u0004\b9\u00102\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\u00020;X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020B0D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006X"}, d2 = {"Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "getSecurePrefs", "()Lcom/blueair/core/service/SecurePrefs;", "securePrefs$delegate", "Lkotlin/Lazy;", "unsecurePrefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getUnsecurePrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "unsecurePrefs$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "isUserLoggedIn", "", "()Z", "googleClientId", "getGoogleClientId", "googleDeeplink", "getGoogleDeeplink", "startFromAlexa", "getStartFromAlexa", "setStartFromAlexa", "(Z)V", "alexaRedirectUrlRequested", "getAlexaRedirectUrlRequested", "setAlexaRedirectUrlRequested", "<set-?>", "googleLinkRequested", "getGoogleLinkRequested", "setGoogleLinkRequested", "googleLinkRequested$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "loginPendingAction", "getLoginPendingAction", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "setLoginPendingAction", "(Lcom/blueair/viewcore/activity/LoginPendingAction;)V", "loginPendingAction$delegate", "accountType", "Lcom/blueair/android/fragment/integration/Integration;", "getAccountType", "()Lcom/blueair/android/fragment/integration/Integration;", "setAccountType", "(Lcom/blueair/android/fragment/integration/Integration;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/blueair/android/viewmodel/LinkingState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setState", "", "startLinking", "Lkotlinx/coroutines/Job;", "startAlexaLinking", "uri", "Landroid/net/Uri;", "accepted", "finishAlexaLinking", "generateAlexaState", "validateAlexaState", "doesAlexaAppSupportAppToApp", "finishGoogleLinking", "fetchLinkingStatus", "expected", "unlink", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AccountLinkingViewModel.kt */
public final class AccountLinkingViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private static final String ALEXA_PACKAGE_NAME = "com.amazon.dee.app";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQUIRED_MINIMUM_VERSION_CODE = 866607211;
    private static final long STATE_VALID_FOR = TimeUnit.MINUTES.toMillis(15);
    /* access modifiers changed from: private */
    public final MutableStateFlow<LinkingState> _state;
    public Integration accountType;
    private boolean alexaRedirectUrlRequested;
    private final Lazy authService$delegate;
    private final ReadWriteProperty googleLinkRequested$delegate;
    private final Lazy locationService$delegate;
    private final ReadWriteProperty loginPendingAction$delegate;
    private final Lazy securePrefs$delegate;
    private boolean startFromAlexa;
    private final StateFlow<LinkingState> state;
    private final Lazy unsecurePrefs$delegate;

    static {
        Class<AccountLinkingViewModel> cls = AccountLinkingViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "securePrefs", "getSecurePrefs()Lcom/blueair/core/service/SecurePrefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "unsecurePrefs", "getUnsecurePrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "googleLinkRequested", "getGoogleLinkRequested()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "loginPendingAction", "getLoginPendingAction()Lcom/blueair/viewcore/activity/LoginPendingAction;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountLinkingViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AccountLinkingViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, SecurePrefs.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.securePrefs$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AccountLinkingViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.unsecurePrefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AccountLinkingViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, AuthService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AccountLinkingViewModel$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        Prefs securePrefs = getSecurePrefs();
        this.googleLinkRequested$delegate = new AccountLinkingViewModel$special$$inlined$ObservableVolatilePreference$1(securePrefs, PrefKeys.KEY_GOOGLE_LINK_REQUESTED, false, PreferencesHelper.INSTANCE.get(securePrefs.getBackend(), PrefKeys.KEY_GOOGLE_LINK_REQUESTED, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs unsecurePrefs = getUnsecurePrefs();
        LoginPendingAction empty = LoginPendingAction.Companion.getEMPTY();
        this.loginPendingAction$delegate = new AccountLinkingViewModel$special$$inlined$ObservablePreference$1(unsecurePrefs, PrefKeys.KEY_LOGIN_PENDING_ACTION, empty, PreferencesHelper.INSTANCE.get(unsecurePrefs.getBackend(), PrefKeys.KEY_LOGIN_PENDING_ACTION, empty, Reflection.getOrCreateKotlinClass(LoginPendingAction.class)));
        MutableStateFlow<LinkingState> MutableStateFlow = StateFlowKt.MutableStateFlow(LinkingState.Idle.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
    }

    private final SecurePrefs getSecurePrefs() {
        return (SecurePrefs) this.securePrefs$delegate.getValue();
    }

    private final UnsecurePrefs getUnsecurePrefs() {
        return (UnsecurePrefs) this.unsecurePrefs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public final String getUsername() {
        return getAuthService().getUsername();
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final String getGoogleClientId() {
        return LocationService.getGoogleClientId$default(getLocationService(), false, 1, (Object) null);
    }

    public final String getGoogleDeeplink() {
        return LocationService.getGoogleDeeplink$default(getLocationService(), false, 1, (Object) null);
    }

    public final boolean getStartFromAlexa() {
        return this.startFromAlexa;
    }

    public final void setStartFromAlexa(boolean z) {
        this.startFromAlexa = z;
    }

    public final boolean getAlexaRedirectUrlRequested() {
        return this.alexaRedirectUrlRequested;
    }

    public final void setAlexaRedirectUrlRequested(boolean z) {
        this.alexaRedirectUrlRequested = z;
    }

    public final boolean getGoogleLinkRequested() {
        return ((Boolean) this.googleLinkRequested$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public final void setGoogleLinkRequested(boolean z) {
        this.googleLinkRequested$delegate.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    public final LoginPendingAction getLoginPendingAction() {
        return (LoginPendingAction) this.loginPendingAction$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setLoginPendingAction(LoginPendingAction loginPendingAction) {
        Intrinsics.checkNotNullParameter(loginPendingAction, "<set-?>");
        this.loginPendingAction$delegate.setValue(this, $$delegatedProperties[5], loginPendingAction);
    }

    public final Integration getAccountType() {
        Integration integration = this.accountType;
        if (integration != null) {
            return integration;
        }
        Intrinsics.throwUninitializedPropertyAccessException("accountType");
        return null;
    }

    public final void setAccountType(Integration integration) {
        Intrinsics.checkNotNullParameter(integration, "<set-?>");
        this.accountType = integration;
    }

    public final StateFlow<LinkingState> getState() {
        return this.state;
    }

    public final void setState(LinkingState linkingState) {
        Intrinsics.checkNotNullParameter(linkingState, "state");
        this._state.setValue(linkingState);
    }

    public final Job startLinking() {
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AccountLinkingViewModel$startLinking$1(this, (Continuation<? super AccountLinkingViewModel$startLinking$1>) null), 3, (Object) null);
    }

    public final Job startAlexaLinking(Uri uri, boolean z) {
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AccountLinkingViewModel$startAlexaLinking$1(uri, this, z, (Continuation<? super AccountLinkingViewModel$startAlexaLinking$1>) null), 3, (Object) null);
    }

    public final void finishAlexaLinking(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("error");
            if (queryParameter == null || queryParameter.length() <= 0 || !Intrinsics.areEqual((Object) queryParameter, (Object) "access_denied")) {
                String queryParameter2 = uri.getQueryParameter("code");
                if (!validateAlexaState(uri) || queryParameter2 == null) {
                    this._state.setValue(LinkingState.Failed.INSTANCE);
                } else {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AccountLinkingViewModel$finishAlexaLinking$1(this, queryParameter2, (Continuation<? super AccountLinkingViewModel$finishAlexaLinking$1>) null), 3, (Object) null);
                }
            } else {
                this._state.setValue(LinkingState.Cancel.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: private */
    public final String generateAlexaState() {
        byte[] bArr = new byte[30];
        new SecureRandom().nextBytes(bArr);
        String str = "android." + new Date().getTime() + '.' + Base64.urlSafeEncode(bArr);
        PreferencesHelper.INSTANCE.set(getSecurePrefs().getBackend(), PrefKeys.KEY_ALEXA_LINKING_STATE, str, Reflection.getOrCreateKotlinClass(String.class));
        return str;
    }

    private final boolean validateAlexaState(Uri uri) {
        String queryParameter;
        String str = null;
        Object obj = PreferencesHelper.INSTANCE.get(getSecurePrefs().getBackend(), PrefKeys.KEY_ALEXA_LINKING_STATE, null, Reflection.getOrCreateKotlinClass(String.class));
        if (((String) obj).length() > 0) {
            str = obj;
        }
        String str2 = str;
        if (str2 == null) {
            return false;
        }
        getSecurePrefs().remove(PrefKeys.KEY_ALEXA_LINKING_STATE);
        if (uri == null || (queryParameter = uri.getQueryParameter("state")) == null || !Intrinsics.areEqual((Object) queryParameter, (Object) str2) || new Date().getTime() - Long.parseLong((String) StringsKt.split$default((CharSequence) queryParameter, new String[]{"."}, false, 0, 6, (Object) null).get(1)) > STATE_VALID_FOR) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean doesAlexaAppSupportAppToApp() {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = ((BlueairApp) getApplication()).getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = packageManager.getPackageInfo(ALEXA_PACKAGE_NAME, PackageManager.PackageInfoFlags.of(0));
            } else {
                packageInfo = packageManager.getPackageInfo(ALEXA_PACKAGE_NAME, 0);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                if (packageInfo.getLongVersionCode() > 866607211) {
                    return true;
                }
                return false;
            } else if (packageInfo != null) {
                return true;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void finishGoogleLinking() {
        this._state.setValue(LinkingState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new AccountLinkingViewModel$finishGoogleLinking$1(this, (Continuation<? super AccountLinkingViewModel$finishGoogleLinking$1>) null), 2, (Object) null);
    }

    public final void fetchLinkingStatus(boolean z) {
        this._state.setValue(LinkingState.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AccountLinkingViewModel$fetchLinkingStatus$1(z, this, (Continuation<? super AccountLinkingViewModel$fetchLinkingStatus$1>) null), 3, (Object) null);
    }

    public final Job unlink() {
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AccountLinkingViewModel$unlink$1(this, (Continuation<? super AccountLinkingViewModel$unlink$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/android/viewmodel/AccountLinkingViewModel$Companion;", "", "<init>", "()V", "STATE_VALID_FOR", "", "ALEXA_PACKAGE_NAME", "", "REQUIRED_MINIMUM_VERSION_CODE", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AccountLinkingViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
