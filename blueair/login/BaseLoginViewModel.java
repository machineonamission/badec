package com.blueair.login;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.gigya.android.sdk.account.models.GigyaAccount;
import com.gigya.android.sdk.account.models.Profile;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020bJ\u0006\u0010d\u001a\u00020bJ\u0006\u0010e\u001a\u00020bJ\u0006\u0010f\u001a\u00020bJ+\u0010g\u001a\u00020b2\u001c\u0010h\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i\u0012\u0006\u0012\u0004\u0018\u00010k0]H\u0004¢\u0006\u0002\u0010lJ+\u0010m\u001a\u00020O2\u001c\u0010n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0i\u0012\u0006\u0012\u0004\u0018\u00010k0]H\u0004¢\u0006\u0002\u0010oJ\u0006\u0010p\u001a\u00020^R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u00103R+\u00107\u001a\u0002062\u0006\u00105\u001a\u0002068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b>\u0010@R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020?0B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020?0FX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020J0B8F¢\u0006\u0006\u001a\u0004\bK\u0010DR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020J0FX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010HR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020O0B8F¢\u0006\u0006\u001a\u0004\bP\u0010DR\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010R\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bS\u0010@R\u0011\u0010T\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bU\u0010@R\u0011\u0010V\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bW\u0010@R\u0011\u0010X\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\bY\u0010@R\u0011\u0010Z\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b[\u0010@R%\u0010\\\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010^\u0012\u0004\u0012\u00020O0]0F8F¢\u0006\u0006\u001a\u0004\b_\u0010HR\"\u0010`\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010^\u0012\u0004\u0012\u00020O0]0FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"},
   d2 = {"Lcom/blueair/login/BaseLoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/kodein/di/DIAware;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "getPrefs", "()Lio/flatcircle/preferenceshelper2/Prefs;", "prefs$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "<set-?>", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "loginPendingAction", "getLoginPendingAction", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "setLoginPendingAction", "(Lcom/blueair/viewcore/activity/LoginPendingAction;)V", "loginPendingAction$delegate", "Lkotlin/properties/ReadWriteProperty;", "isUserLoggedIn", "", "()Z", "loading", "Landroidx/lifecycle/LiveData;", "getLoading", "()Landroidx/lifecycle/LiveData;", "_loading", "Landroidx/lifecycle/MutableLiveData;", "get_loading", "()Landroidx/lifecycle/MutableLiveData;", "failure", "Lcom/blueair/login/LoginFailure;", "getFailure", "_failure", "get_failure", "loginFinished", "", "getLoginFinished", "_loginFinished", "facebookLoginAvailable", "getFacebookLoginAvailable", "googleLoginAvailable", "getGoogleLoginAvailable", "appleLoginAvailable", "getAppleLoginAvailable", "weChatLoginAvailable", "getWeChatLoginAvailable", "qqLoginAvailable", "getQqLoginAvailable", "passwordGetter", "Lkotlin/Function1;", "", "getPasswordGetter", "_passwordGetter", "facebookLogin", "Lkotlinx/coroutines/Job;", "googleLogin", "appleLogin", "weChatLogin", "qqLogin", "authenticateUser", "accountGetter", "Lkotlin/coroutines/Continuation;", "Lcom/gigya/android/sdk/account/models/GigyaAccount;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "loadingLaunch", "bloc", "(Lkotlin/jvm/functions/Function1;)V", "getCountry", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseLoginViewModel extends AndroidViewModel implements CoroutineScope, DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "prefs", "getPrefs()Lio/flatcircle/preferenceshelper2/Prefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseLoginViewModel.class, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(BaseLoginViewModel.class, "loginPendingAction", "getLoginPendingAction()Lcom/blueair/viewcore/activity/LoginPendingAction;", 0)))};
   private final MutableLiveData _failure;
   private final MutableLiveData _loading;
   private final MutableLiveData _loginFinished;
   private final MutableLiveData _passwordGetter;
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

   // $FF: synthetic method
   public static Unit $r8$lambda$s66DkClMILBnqA0pz5g24PoxQ7Y(BaseLoginViewModel var0, Function1 var1) {
      return _init_$lambda$0(var0, var1);
   }

   public BaseLoginViewModel(Application var1) {
      boolean var2;
      boolean var3;
      label21: {
         Intrinsics.checkNotNullParameter(var1, "app");
         super(var1);
         LazyContextDIPropertyDelegateProvider var5 = ClosestKt.closestDI(this);
         KProperty[] var4 = $$delegatedProperties;
         var3 = false;
         var7 = false;
         this.di$delegate = var5.provideDelegate(this, var4[0]);
         DIAware var15 = this;
         JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.gigyaService$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, GigyaService.class)), (Object)null).provideDelegate(this, var4[1]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.authService$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, AuthService.class)), (Object)null).provideDelegate(this, var4[2]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.locationService$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null).provideDelegate(this, var4[3]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.happyUserService$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, HappyUserService.class)), (Object)null).provideDelegate(this, var4[4]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.prefs$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var4[5]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.deviceManager$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, DeviceManager.class)), (Object)null).provideDelegate(this, var4[6]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         this.outdoorService$delegate = DIAwareKt.Instance(var15, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, OutdoorService.class)), (Object)null).provideDelegate(this, var4[7]);
         Prefs var9 = this.getPrefs();
         LoginPendingAction var16 = LoginPendingAction.Companion.getEMPTY();
         this.loginPendingAction$delegate = (ReadWriteProperty)(new ObservableProperty(var9, "KEY_LOGIN_PENDING_ACTION", var16, PreferencesHelper.INSTANCE.get(var9.getBackend(), "KEY_LOGIN_PENDING_ACTION", var16, Reflection.getOrCreateKotlinClass(LoginPendingAction.class))) {
            final Object $initialDefault;
            final String $key;
            final Prefs $prefs;

            public {
               this.$prefs = var1;
               this.$key = var2;
               this.$initialDefault = var3;
            }

            protected void afterChange(KProperty var1, Object var2, Object var3) {
               Intrinsics.checkParameterIsNotNull(var1, "property");
               Intrinsics.checkParameterIsNotNull(var2, "oldValue");
               Intrinsics.checkParameterIsNotNull(var3, "newValue");
               if (!Intrinsics.areEqual(var3, var2)) {
                  Prefs var5 = this.$prefs;
                  String var4 = this.$key;
                  PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(LoginPendingAction.class));
               }

            }
         });
         this._loading = new MutableLiveData();
         this._failure = new MutableLiveData();
         this._loginFinished = new MutableLiveData();
         if (!this.getLocationService().isInFacebookLoginRegion()) {
            var9 = this.getPrefs();
            if (!(Boolean)PreferencesHelper.INSTANCE.get(var9.getBackend(), "KEY_FACEBOOK_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
               var2 = false;
               break label21;
            }
         }

         var2 = true;
      }

      label16: {
         this.facebookLoginAvailable = var2;
         if (!this.getLocationService().isInGoogleLoginRegion()) {
            Prefs var11 = this.getPrefs();
            var2 = var3;
            if (!(Boolean)PreferencesHelper.INSTANCE.get(var11.getBackend(), "KEY_GOOGLE_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class))) {
               break label16;
            }
         }

         var2 = true;
      }

      this.googleLoginAvailable = var2;
      Prefs var12 = this.getPrefs();
      this.appleLoginAvailable = (Boolean)PreferencesHelper.INSTANCE.get(var12.getBackend(), "KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class));
      var12 = this.getPrefs();
      this.weChatLoginAvailable = (Boolean)PreferencesHelper.INSTANCE.get(var12.getBackend(), "KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class));
      var12 = this.getPrefs();
      this.qqLoginAvailable = (Boolean)PreferencesHelper.INSTANCE.get(var12.getBackend(), "KEY_WECHAT_QQ_APPLE_LOGIN_ENABLED", var7, Reflection.getOrCreateKotlinClass(Boolean.class));
      this._passwordGetter = new MutableLiveData();
      this.getGigyaService().setGetPassword(new BaseLoginViewModel$$ExternalSyntheticLambda0(this));
   }

   private static final Unit _init_$lambda$0(BaseLoginViewModel var0, Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0._passwordGetter.setValue(var1);
      return Unit.INSTANCE;
   }

   private final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
   }

   private final HappyUserService getHappyUserService() {
      return (HappyUserService)this.happyUserService$delegate.getValue();
   }

   private final OutdoorService getOutdoorService() {
      return (OutdoorService)this.outdoorService$delegate.getValue();
   }

   private final Prefs getPrefs() {
      return (Prefs)this.prefs$delegate.getValue();
   }

   public final Job appleLogin() {
      return this.authenticateUser(new Function1(this.getGigyaService()) {
         public final Object invoke(Continuation var1) {
            return ((GigyaService)this.receiver).appleLogin(var1);
         }
      });
   }

   protected final Job authenticateUser(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "accountGetter");
      return BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final Function1 $accountGetter;
         int I$0;
         private Object L$0;
         Object L$1;
         int label;
         final BaseLoginViewModel this$0;

         {
            this.this$0 = var1;
            this.$accountGetter = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, this.$accountGetter, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label227: {
               Object var4;
               CoroutineScope var5;
               label226: {
                  Throwable var10000;
                  label225: {
                     var5 = (CoroutineScope)this.L$0;
                     var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                           break label227;
                        }

                        CoroutineScope var3 = (CoroutineScope)this.L$1;

                        try {
                           ResultKt.throwOnFailure(var1);
                        } catch (Throwable var19) {
                           var10000 = var19;
                           boolean var10001 = false;
                           break label225;
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.get_loading().setValue(Boxing.boxBoolean(true));
                        Function1 var20 = this.$accountGetter;

                        Object var25;
                        try {
                           Result.Companion var24 = Result.Companion;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                           this.L$1 = SpillingKt.nullOutSpilledVariable(var5);
                           this.I$0 = 0;
                           this.label = 1;
                           var25 = var20.invoke(this);
                        } catch (Throwable var18) {
                           var10000 = var18;
                           boolean var29 = false;
                           break label225;
                        }

                        var1 = (LoginFailure)var25;
                        if (var25 == var4) {
                           return var4;
                        }
                     }

                     label216:
                     try {
                        var1 = Result.constructor-impl((GigyaAccount)var1);
                        break label226;
                     } catch (Throwable var17) {
                        var10000 = var17;
                        boolean var30 = false;
                        break label216;
                     }
                  }

                  Throwable var21 = var10000;
                  Result.Companion var26 = Result.Companion;
                  var1 = Result.constructor-impl(ResultKt.createFailure(var21));
               }

               CoroutineContext var6 = (CoroutineContext)Dispatchers.getIO();
               Function2 var27 = new Function2(var1, this.this$0, (Continuation)null) {
                  final Object $accountResult;
                  Object L$0;
                  Object L$1;
                  Object L$2;
                  int label;
                  final BaseLoginViewModel this$0;

                  {
                     this.$accountResult = var1;
                     this.this$0 = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$accountResult, this.this$0, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     String var3;
                     String var4;
                     Object var6;
                     label69: {
                        label74: {
                           var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           GigyaAccount var5;
                           if (var2 != 0) {
                              if (var2 != 1) {
                                 if (var2 != 2) {
                                    if (var2 != 3) {
                                       if (var2 != 4) {
                                          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                       }

                                       var3 = (String)this.L$2;
                                       var3 = (String)this.L$1;
                                       GigyaAccount var18 = (GigyaAccount)this.L$0;
                                       ResultKt.throwOnFailure(var1);
                                       return null;
                                    }

                                    var3 = (String)this.L$2;
                                    var4 = (String)this.L$1;
                                    var5 = (GigyaAccount)this.L$0;
                                    ResultKt.throwOnFailure(var1);
                                    var9 = var5;
                                    break label69;
                                 }

                                 var3 = (String)this.L$2;
                                 var4 = (String)this.L$1;
                                 var5 = (GigyaAccount)this.L$0;
                                 ResultKt.throwOnFailure(var1);
                                 var9 = var5;
                                 break label74;
                              }

                              var3 = (String)this.L$2;
                              var4 = (String)this.L$1;
                              var5 = (GigyaAccount)this.L$0;
                              ResultKt.throwOnFailure(var1);
                           } else {
                              ResultKt.throwOnFailure(var1);
                              if (Result.isFailure-impl(this.$accountResult)) {
                                 if (Result.exceptionOrNull-impl(this.$accountResult) instanceof CancellationException) {
                                    return LoginFailure.Companion.getCANCELED();
                                 }

                                 return LoginFailure.Companion.fromCode$default(LoginFailure.Companion, Result.exceptionOrNull-impl(this.$accountResult), false, 2, (Object)null);
                              }

                              var1 = this.$accountResult;
                              ResultKt.throwOnFailure(var1);
                              var5 = (GigyaAccount)var1;
                              Profile var11 = var5.getProfile();
                              String var12;
                              if (var11 != null) {
                                 var12 = var11.getEmail();
                              } else {
                                 var12 = null;
                              }

                              Pair var13 = TuplesKt.to(var12, var5.getUID());
                              var4 = (String)var13.component1();
                              var3 = (String)var13.component2();
                              if (var4 == null) {
                                 return LoginFailure.Companion.getSERVER_ERROR();
                              }

                              if (var3 == null) {
                                 return LoginFailure.Companion.getSERVER_ERROR();
                              }

                              GigyaService var7 = this.this$0.getGigyaService();
                              Continuation var14 = (Continuation)this;
                              this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                              this.L$1 = var4;
                              this.L$2 = var3;
                              this.label = 1;
                              var1 = var7.refreshGigyaJwt(var14);
                              if (var1 == var6) {
                                 return var6;
                              }
                           }

                           if ((String)var1 == null) {
                              return LoginFailure.Companion.getSERVER_ERROR();
                           }

                           UserInfoCollectionsManager.INSTANCE.initializeCollections(var4, (Context)this.this$0.getApplication());
                           AuthService var23 = this.this$0.getAuthService();
                           Continuation var15 = (Continuation)this;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                           this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
                           this.L$2 = SpillingKt.nullOutSpilledVariable(var3);
                           this.label = 2;
                           if (var23.authenticateAblUser(var4, var3, var15) == var6) {
                              return var6;
                           }

                           var9 = var5;
                        }

                        DeviceManager.Companion var21 = DeviceManager.Companion;
                        DeviceManager var24 = this.this$0.getDeviceManager();
                        Continuation var8 = (Continuation)this;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var9);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(var3);
                        this.label = 3;
                        if (var21.downloadDeviceList(var24, var8) == var6) {
                           return var6;
                        }
                     }

                     OutdoorService var25 = this.this$0.getOutdoorService();
                     Continuation var22 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var9);
                     this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
                     this.L$2 = SpillingKt.nullOutSpilledVariable(var3);
                     this.label = 4;
                     if (var25.downloadTrackedLocations(var22) == var6) {
                        return var6;
                     } else {
                        return null;
                     }
                  }
               };
               Continuation var7 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var1);
               this.label = 2;
               Object var28 = BuildersKt.withContext(var6, var27, var7);
               var1 = (LoginFailure)var28;
               if (var28 == var4) {
                  return var4;
               }
            }

            var1 = var1;
            this.this$0.get_loading().setValue(Boxing.boxBoolean(false));
            if (var1 != null) {
               this.this$0.get_failure().setValue(var1);
            } else {
               this.this$0._loginFinished.setValue(Unit.INSTANCE);
               this.this$0.getHappyUserService().setSignUpStamp(System.currentTimeMillis());
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final Job facebookLogin() {
      return this.authenticateUser(new Function1(this.getGigyaService()) {
         public final Object invoke(Continuation var1) {
            return ((GigyaService)this.receiver).facebookLogin(var1);
         }
      });
   }

   public final boolean getAppleLoginAvailable() {
      return this.appleLoginAvailable;
   }

   protected final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   public CoroutineContext getCoroutineContext() {
      return ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext();
   }

   public final String getCountry() {
      return this.getLocationService().getCountry();
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final boolean getFacebookLoginAvailable() {
      return this.facebookLoginAvailable;
   }

   public final LiveData getFailure() {
      return (LiveData)this._failure;
   }

   protected final GigyaService getGigyaService() {
      return (GigyaService)this.gigyaService$delegate.getValue();
   }

   public final boolean getGoogleLoginAvailable() {
      return this.googleLoginAvailable;
   }

   public final LiveData getLoading() {
      return (LiveData)this._loading;
   }

   protected final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   public final LiveData getLoginFinished() {
      return (LiveData)this._loginFinished;
   }

   public final LoginPendingAction getLoginPendingAction() {
      return (LoginPendingAction)this.loginPendingAction$delegate.getValue(this, $$delegatedProperties[8]);
   }

   public final MutableLiveData getPasswordGetter() {
      return this._passwordGetter;
   }

   public final boolean getQqLoginAvailable() {
      return this.qqLoginAvailable;
   }

   public final boolean getWeChatLoginAvailable() {
      return this.weChatLoginAvailable;
   }

   protected final MutableLiveData get_failure() {
      return this._failure;
   }

   protected final MutableLiveData get_loading() {
      return this._loading;
   }

   public final Job googleLogin() {
      return this.authenticateUser(new Function1(this.getGigyaService()) {
         public final Object invoke(Continuation var1) {
            return ((GigyaService)this.receiver).googleLogin(var1);
         }
      });
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.getAuthService().isUserLoggedIn().getValue();
   }

   protected final void loadingLaunch(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "bloc");
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final Function1 $bloc;
         int label;
         final BaseLoginViewModel this$0;

         {
            this.this$0 = var1;
            this.$bloc = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$bloc, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               this.this$0.get_loading().setValue(Boxing.boxBoolean(true));
               Function1 var4 = this.$bloc;
               this.label = 1;
               if (var4.invoke(this) == var3) {
                  return var3;
               }
            }

            this.this$0.get_loading().setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final Job qqLogin() {
      return this.authenticateUser(new Function1(this.getGigyaService()) {
         public final Object invoke(Continuation var1) {
            return ((GigyaService)this.receiver).qqLogin(var1);
         }
      });
   }

   public final void setLoginPendingAction(LoginPendingAction var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.loginPendingAction$delegate.setValue(this, $$delegatedProperties[8], var1);
   }

   public final Job weChatLogin() {
      return this.authenticateUser(new Function1(this.getGigyaService()) {
         public final Object invoke(Continuation var1) {
            return ((GigyaService)this.receiver).weChatLogin(var1);
         }
      });
   }
}
