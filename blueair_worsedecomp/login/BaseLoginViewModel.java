package com.blueair.login;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.core.service.HappyUserService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.gigya.android.sdk.account.models.GigyaAccount;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020bJ\u0006\u0010d\u001a\u00020bJ\u0006\u0010e\u001a\u00020bJ\u0006\u0010f\u001a\u00020bJ+\u0010g\u001a\u00020b2\u001c\u0010h\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i\u0012\u0006\u0012\u0004\u0018\u00010k0]H\u0004¢\u0006\u0002\u0010lJ+\u0010m\u001a\u00020O2\u001c\u0010n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0i\u0012\u0006\u0012\u0004\u0018\u00010k0]H\u0004¢\u0006\u0002\u0010oJ\u0006\u0010p\u001a\u00020^R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138DX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188DX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8DX\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u00103R+\u00107\u001a\u0002062\u0006\u00105\u001a\u0002068F@FX\u0002¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b>\u0010@R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020?0B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020?0FX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020J0B8F¢\u0006\u0006\u001a\u0004\bK\u0010DR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020J0FX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010HR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020O0B8F¢\u0006\u0006\u001a\u0004\bP\u0010DR\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0FX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010R\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bS\u0010@R\u0011\u0010T\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bU\u0010@R\u0011\u0010V\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bW\u0010@R\u0011\u0010X\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bY\u0010@R\u0011\u0010Z\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b[\u0010@R%\u0010\\\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010^\u0012\u0004\u0012\u00020O0]0F8F¢\u0006\u0006\u001a\u0004\b_\u0010HR\"\u0010`\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010^\u0012\u0004\u0012\u00020O0]0FX\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/blueair/login/BaseLoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/kodein/di/DIAware;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "getPrefs", "()Lio/flatcircle/preferenceshelper2/Prefs;", "prefs$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "<set-?>", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "loginPendingAction", "getLoginPendingAction", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "setLoginPendingAction", "(Lcom/blueair/viewcore/activity/LoginPendingAction;)V", "loginPendingAction$delegate", "Lkotlin/properties/ReadWriteProperty;", "isUserLoggedIn", "", "()Z", "loading", "Landroidx/lifecycle/LiveData;", "getLoading", "()Landroidx/lifecycle/LiveData;", "_loading", "Landroidx/lifecycle/MutableLiveData;", "get_loading", "()Landroidx/lifecycle/MutableLiveData;", "failure", "Lcom/blueair/login/LoginFailure;", "getFailure", "_failure", "get_failure", "loginFinished", "", "getLoginFinished", "_loginFinished", "facebookLoginAvailable", "getFacebookLoginAvailable", "googleLoginAvailable", "getGoogleLoginAvailable", "appleLoginAvailable", "getAppleLoginAvailable", "weChatLoginAvailable", "getWeChatLoginAvailable", "qqLoginAvailable", "getQqLoginAvailable", "passwordGetter", "Lkotlin/Function1;", "", "getPasswordGetter", "_passwordGetter", "facebookLogin", "Lkotlinx/coroutines/Job;", "googleLogin", "appleLogin", "weChatLogin", "qqLogin", "authenticateUser", "accountGetter", "Lkotlin/coroutines/Continuation;", "Lcom/gigya/android/sdk/account/models/GigyaAccount;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "loadingLaunch", "bloc", "(Lkotlin/jvm/functions/Function1;)V", "getCountry", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLoginViewModel.kt */
public abstract class BaseLoginViewModel extends AndroidViewModel implements CoroutineScope, DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final MutableLiveData<LoginFailure> _failure = new MutableLiveData<>();
    private final MutableLiveData<Boolean> _loading = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Unit> _loginFinished = new MutableLiveData<>();
    private final MutableLiveData<Function1<String, Unit>> _passwordGetter;
    private final boolean appleLoginAvailable;
    private final Lazy authService$delegate;
    private final Lazy deviceManager$delegate;
    private final Lazy di$delegate;
    private final boolean facebookLoginAvailable;
    private final Lazy gigyaService$delegate;
    private final boolean googleLoginAvailable;
    private final Lazy happyUserService$delegate;
    private final Lazy locationService$delegate;
    private final ReadWriteProperty loginPendingAction$delegate;
    private final Lazy outdoorService$delegate;
    private final Lazy prefs$delegate;
    private final boolean qqLoginAvailable;
    private final boolean weChatLoginAvailable;

    static {
        Class<BaseLoginViewModel> cls = BaseLoginViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lio/flatcircle/preferenceshelper2/Prefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "loginPendingAction", "getLoginPendingAction()Lcom/blueair/viewcore/activity/LoginPendingAction;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x01bc, code lost:
        if (((java.lang.Boolean) io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), com.blueair.core.PrefKeys.KEY_GOOGLE_LOGIN_ENABLED, false, kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(java.lang.Boolean.class))).booleanValue() != false) goto L_0x01be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x01a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BaseLoginViewModel(android.app.Application r10) {
        /*
            r9 = this;
            java.lang.String r0 = "app"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r9.<init>(r10)
            r10 = r9
            androidx.lifecycle.AndroidViewModel r10 = (androidx.lifecycle.AndroidViewModel) r10
            org.kodein.di.android.LazyContextDIPropertyDelegateProvider r10 = org.kodein.di.android.x.ClosestKt.closestDI((androidx.lifecycle.AndroidViewModel) r10)
            kotlin.reflect.KProperty<java.lang.Object>[] r0 = $$delegatedProperties
            r1 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            r3 = r0[r1]
            kotlin.Lazy r10 = r10.provideDelegate(r9, r3)
            r9.di$delegate = r10
            r10 = r9
            org.kodein.di.DIAware r10 = (org.kodein.di.DIAware) r10
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$1 r4 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$1
            r4.<init>()
            java.lang.reflect.Type r4 = r4.getSuperType()
            org.kodein.type.JVMTypeToken r4 = org.kodein.type.TypeTokensJVMKt.typeToken(r4)
            java.lang.String r5 = "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r5)
            java.lang.Class<com.blueair.auth.GigyaService> r6 = com.blueair.auth.GigyaService.class
            r3.<init>(r4, r6)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            r4 = 0
            org.kodein.di.LazyDelegate r3 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r6 = 1
            r7 = r0[r6]
            kotlin.Lazy r3 = r3.provideDelegate(r9, r7)
            r9.gigyaService$delegate = r3
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$2 r7 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$2
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getSuperType()
            org.kodein.type.JVMTypeToken r7 = org.kodein.type.TypeTokensJVMKt.typeToken(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            java.lang.Class<com.blueair.auth.AuthService> r8 = com.blueair.auth.AuthService.class
            r3.<init>(r7, r8)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            org.kodein.di.LazyDelegate r3 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r7 = 2
            r7 = r0[r7]
            kotlin.Lazy r3 = r3.provideDelegate(r9, r7)
            r9.authService$delegate = r3
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$3 r7 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$3
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getSuperType()
            org.kodein.type.JVMTypeToken r7 = org.kodein.type.TypeTokensJVMKt.typeToken(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            java.lang.Class<com.blueair.auth.LocationService> r8 = com.blueair.auth.LocationService.class
            r3.<init>(r7, r8)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            org.kodein.di.LazyDelegate r3 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r7 = 3
            r7 = r0[r7]
            kotlin.Lazy r3 = r3.provideDelegate(r9, r7)
            r9.locationService$delegate = r3
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$4 r7 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$4
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getSuperType()
            org.kodein.type.JVMTypeToken r7 = org.kodein.type.TypeTokensJVMKt.typeToken(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            java.lang.Class<com.blueair.core.service.HappyUserService> r8 = com.blueair.core.service.HappyUserService.class
            r3.<init>(r7, r8)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            org.kodein.di.LazyDelegate r3 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r7 = 4
            r7 = r0[r7]
            kotlin.Lazy r3 = r3.provideDelegate(r9, r7)
            r9.happyUserService$delegate = r3
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$5 r7 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$5
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getSuperType()
            org.kodein.type.JVMTypeToken r7 = org.kodein.type.TypeTokensJVMKt.typeToken(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            java.lang.Class<com.blueair.core.service.UnsecurePrefs> r8 = com.blueair.core.service.UnsecurePrefs.class
            r3.<init>(r7, r8)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            org.kodein.di.LazyDelegate r3 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r7 = 5
            r7 = r0[r7]
            kotlin.Lazy r3 = r3.provideDelegate(r9, r7)
            r9.prefs$delegate = r3
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$6 r7 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$6
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getSuperType()
            org.kodein.type.JVMTypeToken r7 = org.kodein.type.TypeTokensJVMKt.typeToken(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            java.lang.Class<com.blueair.devicemanager.DeviceManager> r8 = com.blueair.devicemanager.DeviceManager.class
            r3.<init>(r7, r8)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            org.kodein.di.LazyDelegate r3 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r7 = 6
            r7 = r0[r7]
            kotlin.Lazy r3 = r3.provideDelegate(r9, r7)
            r9.deviceManager$delegate = r3
            org.kodein.type.GenericJVMTypeTokenDelegate r3 = new org.kodein.type.GenericJVMTypeTokenDelegate
            com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$7 r7 = new com.blueair.login.BaseLoginViewModel$special$$inlined$instance$default$7
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getSuperType()
            org.kodein.type.JVMTypeToken r7 = org.kodein.type.TypeTokensJVMKt.typeToken(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r5)
            java.lang.Class<com.blueair.outdoor.service.OutdoorService> r5 = com.blueair.outdoor.service.OutdoorService.class
            r3.<init>(r7, r5)
            org.kodein.type.TypeToken r3 = (org.kodein.type.TypeToken) r3
            org.kodein.di.LazyDelegate r10 = org.kodein.di.DIAwareKt.Instance(r10, r3, r4)
            r3 = 7
            r0 = r0[r3]
            kotlin.Lazy r10 = r10.provideDelegate(r9, r0)
            r9.outdoorService$delegate = r10
            io.flatcircle.preferenceshelper2.Prefs r10 = r9.getPrefs()
            com.blueair.viewcore.activity.LoginPendingAction$Companion r0 = com.blueair.viewcore.activity.LoginPendingAction.Companion
            com.blueair.viewcore.activity.LoginPendingAction r0 = r0.getEMPTY()
            io.flatcircle.preferenceshelper2.PreferencesHelper r3 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r4 = r10.getBackend()
            java.lang.Class<com.blueair.viewcore.activity.LoginPendingAction> r5 = com.blueair.viewcore.activity.LoginPendingAction.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            java.lang.String r7 = "KEY_LOGIN_PENDING_ACTION"
            java.lang.Object r3 = r3.get(r4, r7, r0, r5)
            com.blueair.login.BaseLoginViewModel$special$$inlined$ObservablePreference$1 r4 = new com.blueair.login.BaseLoginViewModel$special$$inlined$ObservablePreference$1
            r4.<init>(r10, r7, r0, r3)
            kotlin.properties.ReadWriteProperty r4 = (kotlin.properties.ReadWriteProperty) r4
            r9.loginPendingAction$delegate = r4
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r9._loading = r10
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r9._failure = r10
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r9._loginFinished = r10
            com.blueair.auth.LocationService r10 = r9.getLocationService()
            boolean r10 = r10.isInFacebookLoginRegion()
            if (r10 != 0) goto L_0x0193
            io.flatcircle.preferenceshelper2.Prefs r10 = r9.getPrefs()
            io.flatcircle.preferenceshelper2.PreferencesHelper r0 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r10 = r10.getBackend()
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.String r4 = "KEY_FACEBOOK_LOGIN_ENABLED"
            java.lang.Object r10 = r0.get(r10, r4, r2, r3)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0191
            goto L_0x0193
        L_0x0191:
            r10 = r1
            goto L_0x0194
        L_0x0193:
            r10 = r6
        L_0x0194:
            r9.facebookLoginAvailable = r10
            com.blueair.auth.LocationService r10 = r9.getLocationService()
            boolean r10 = r10.isInGoogleLoginRegion()
            if (r10 != 0) goto L_0x01be
            io.flatcircle.preferenceshelper2.Prefs r10 = r9.getPrefs()
            io.flatcircle.preferenceshelper2.PreferencesHelper r0 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r10 = r10.getBackend()
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.String r4 = "KEY_GOOGLE_LOGIN_ENABLED"
            java.lang.Object r10 = r0.get(r10, r4, r2, r3)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x01bf
        L_0x01be:
            r1 = r6
        L_0x01bf:
            r9.googleLoginAvailable = r1
            io.flatcircle.preferenceshelper2.Prefs r10 = r9.getPrefs()
            io.flatcircle.preferenceshelper2.PreferencesHelper r0 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r10 = r10.getBackend()
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r3 = "KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED"
            java.lang.Object r10 = r0.get(r10, r3, r2, r1)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r9.appleLoginAvailable = r10
            io.flatcircle.preferenceshelper2.Prefs r10 = r9.getPrefs()
            io.flatcircle.preferenceshelper2.PreferencesHelper r0 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r10 = r10.getBackend()
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.Object r10 = r0.get(r10, r3, r2, r1)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r9.weChatLoginAvailable = r10
            io.flatcircle.preferenceshelper2.Prefs r10 = r9.getPrefs()
            io.flatcircle.preferenceshelper2.PreferencesHelper r0 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r10 = r10.getBackend()
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.Object r10 = r0.get(r10, r3, r2, r1)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r9.qqLoginAvailable = r10
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r9._passwordGetter = r10
            com.blueair.auth.GigyaService r10 = r9.getGigyaService()
            com.blueair.login.BaseLoginViewModel$$ExternalSyntheticLambda0 r0 = new com.blueair.login.BaseLoginViewModel$$ExternalSyntheticLambda0
            r0.<init>(r9)
            r10.setGetPassword(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.BaseLoginViewModel.<init>(android.app.Application):void");
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public CoroutineContext getCoroutineContext() {
        return ViewModelKt.getViewModelScope(this).getCoroutineContext();
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final GigyaService getGigyaService() {
        return (GigyaService) this.gigyaService$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final HappyUserService getHappyUserService() {
        return (HappyUserService) this.happyUserService$delegate.getValue();
    }

    private final Prefs getPrefs() {
        return (Prefs) this.prefs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    public final LoginPendingAction getLoginPendingAction() {
        return (LoginPendingAction) this.loginPendingAction$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final void setLoginPendingAction(LoginPendingAction loginPendingAction) {
        Intrinsics.checkNotNullParameter(loginPendingAction, "<set-?>");
        this.loginPendingAction$delegate.setValue(this, $$delegatedProperties[8], loginPendingAction);
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final LiveData<Boolean> getLoading() {
        return this._loading;
    }

    /* access modifiers changed from: protected */
    public final MutableLiveData<Boolean> get_loading() {
        return this._loading;
    }

    public final LiveData<LoginFailure> getFailure() {
        return this._failure;
    }

    /* access modifiers changed from: protected */
    public final MutableLiveData<LoginFailure> get_failure() {
        return this._failure;
    }

    public final LiveData<Unit> getLoginFinished() {
        return this._loginFinished;
    }

    public final boolean getFacebookLoginAvailable() {
        return this.facebookLoginAvailable;
    }

    public final boolean getGoogleLoginAvailable() {
        return this.googleLoginAvailable;
    }

    public final boolean getAppleLoginAvailable() {
        return this.appleLoginAvailable;
    }

    public final boolean getWeChatLoginAvailable() {
        return this.weChatLoginAvailable;
    }

    public final boolean getQqLoginAvailable() {
        return this.qqLoginAvailable;
    }

    public final MutableLiveData<Function1<String, Unit>> getPasswordGetter() {
        return this._passwordGetter;
    }

    /* access modifiers changed from: private */
    public static final Unit _init_$lambda$0(BaseLoginViewModel baseLoginViewModel, Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "it");
        baseLoginViewModel._passwordGetter.setValue(function1);
        return Unit.INSTANCE;
    }

    public final Job facebookLogin() {
        return authenticateUser(new BaseLoginViewModel$facebookLogin$1(getGigyaService()));
    }

    public final Job googleLogin() {
        return authenticateUser(new BaseLoginViewModel$googleLogin$1(getGigyaService()));
    }

    public final Job appleLogin() {
        return authenticateUser(new BaseLoginViewModel$appleLogin$1(getGigyaService()));
    }

    public final Job weChatLogin() {
        return authenticateUser(new BaseLoginViewModel$weChatLogin$1(getGigyaService()));
    }

    public final Job qqLogin() {
        return authenticateUser(new BaseLoginViewModel$qqLogin$1(getGigyaService()));
    }

    /* access modifiers changed from: protected */
    public final Job authenticateUser(Function1<? super Continuation<? super GigyaAccount>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "accountGetter");
        return BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new BaseLoginViewModel$authenticateUser$1(this, function1, (Continuation<? super BaseLoginViewModel$authenticateUser$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void loadingLaunch(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "bloc");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new BaseLoginViewModel$loadingLaunch$1(this, function1, (Continuation<? super BaseLoginViewModel$loadingLaunch$1>) null), 3, (Object) null);
    }

    public final String getCountry() {
        return getLocationService().getCountry();
    }
}
