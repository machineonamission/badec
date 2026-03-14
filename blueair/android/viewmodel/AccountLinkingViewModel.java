package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import com.blueair.android.BlueairApp;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.crypto.tink.subtle.Base64;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.preferenceshelper2.PrefsBackend;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
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
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010G\u001a\u00020H2\u0006\u0010C\u001a\u00020BJ\u0006\u0010I\u001a\u00020JJ\u0018\u0010K\u001a\u00020J2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020 J\u0010\u0010O\u001a\u00020H2\b\u0010L\u001a\u0004\u0018\u00010MJ\b\u0010P\u001a\u00020\u001cH\u0002J\u0012\u0010Q\u001a\u00020 2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\b\u0010R\u001a\u00020 H\u0002J\u0006\u0010S\u001a\u00020HJ\u000e\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020 J\u0006\u0010V\u001a\u00020JR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0011\u0010$\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u001a\u0010&\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010)R+\u0010.\u001a\u00020 2\u0006\u0010-\u001a\u00020 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b/\u0010!\"\u0004\b0\u0010)R+\u00104\u001a\u0002032\u0006\u0010-\u001a\u0002038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u00102\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\u00020;X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020B0D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006X"},
   d2 = {"Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "securePrefs", "Lcom/blueair/core/service/SecurePrefs;", "getSecurePrefs", "()Lcom/blueair/core/service/SecurePrefs;", "securePrefs$delegate", "Lkotlin/Lazy;", "unsecurePrefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getUnsecurePrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "unsecurePrefs$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "isUserLoggedIn", "", "()Z", "googleClientId", "getGoogleClientId", "googleDeeplink", "getGoogleDeeplink", "startFromAlexa", "getStartFromAlexa", "setStartFromAlexa", "(Z)V", "alexaRedirectUrlRequested", "getAlexaRedirectUrlRequested", "setAlexaRedirectUrlRequested", "<set-?>", "googleLinkRequested", "getGoogleLinkRequested", "setGoogleLinkRequested", "googleLinkRequested$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/blueair/viewcore/activity/LoginPendingAction;", "loginPendingAction", "getLoginPendingAction", "()Lcom/blueair/viewcore/activity/LoginPendingAction;", "setLoginPendingAction", "(Lcom/blueair/viewcore/activity/LoginPendingAction;)V", "loginPendingAction$delegate", "accountType", "Lcom/blueair/android/fragment/integration/Integration;", "getAccountType", "()Lcom/blueair/android/fragment/integration/Integration;", "setAccountType", "(Lcom/blueair/android/fragment/integration/Integration;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/blueair/android/viewmodel/LinkingState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setState", "", "startLinking", "Lkotlinx/coroutines/Job;", "startAlexaLinking", "uri", "Landroid/net/Uri;", "accepted", "finishAlexaLinking", "generateAlexaState", "validateAlexaState", "doesAlexaAppSupportAppToApp", "finishGoogleLinking", "fetchLinkingStatus", "expected", "unlink", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AccountLinkingViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AccountLinkingViewModel.class, "securePrefs", "getSecurePrefs()Lcom/blueair/core/service/SecurePrefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AccountLinkingViewModel.class, "unsecurePrefs", "getUnsecurePrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AccountLinkingViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AccountLinkingViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AccountLinkingViewModel.class, "googleLinkRequested", "getGoogleLinkRequested()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AccountLinkingViewModel.class, "loginPendingAction", "getLoginPendingAction()Lcom/blueair/viewcore/activity/LoginPendingAction;", 0)))};
   public static final int $stable = 8;
   private static final String ALEXA_PACKAGE_NAME = "com.amazon.dee.app";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final int REQUIRED_MINIMUM_VERSION_CODE = 866607211;
   private static final long STATE_VALID_FOR;
   private final MutableStateFlow _state;
   public Integration accountType;
   private boolean alexaRedirectUrlRequested;
   private final Lazy authService$delegate;
   private final ReadWriteProperty googleLinkRequested$delegate;
   private final Lazy locationService$delegate;
   private final ReadWriteProperty loginPendingAction$delegate;
   private final Lazy securePrefs$delegate;
   private boolean startFromAlexa;
   private final StateFlow state;
   private final Lazy unsecurePrefs$delegate;

   static {
      STATE_VALID_FOR = TimeUnit.MINUTES.toMillis(15L);
   }

   public AccountLinkingViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, SecurePrefs.class)), (Object)null);
      KProperty[] var8 = $$delegatedProperties;
      this.securePrefs$delegate = var3.provideDelegate(this, var8[0]);
      JVMTypeToken var11 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.unsecurePrefs$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var11, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var8[1]);
      var11 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var11, AuthService.class)), (Object)null).provideDelegate(this, var8[2]);
      var11 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var11, LocationService.class)), (Object)null).provideDelegate(this, var8[3]);
      Prefs var9 = this.getSecurePrefs();
      Boolean var5 = false;
      this.googleLinkRequested$delegate = (ReadWriteProperty)(new ObservableProperty(var9, "KEY_GOOGLE_LINK_REQUESTED", var5, PreferencesHelper.INSTANCE.get(var9.getBackend(), "KEY_GOOGLE_LINK_REQUESTED", var5, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            Intrinsics.checkNotNullParameter(var2, "oldValue");
            Intrinsics.checkNotNullParameter(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }

         public Object getValue(Object var1, KProperty var2) {
            Intrinsics.checkNotNullParameter(var2, "property");
            Prefs var3 = this.$prefs;
            String var5 = this.$key;
            var1 = this.$initialDefault;
            return PreferencesHelper.INSTANCE.get(var3.getBackend(), var5, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
         }

         public void setValue(Object var1, KProperty var2, Object var3) {
            Intrinsics.checkNotNullParameter(var2, "property");
            Intrinsics.checkNotNullParameter(var3, "value");
            var1 = this.getValue(var1, var2);
            if (this.beforeChange(var2, var1, var3)) {
               this.afterChange(var2, var1, var3);
            }
         }
      });
      Prefs var6 = this.getUnsecurePrefs();
      LoginPendingAction var10 = LoginPendingAction.Companion.getEMPTY();
      this.loginPendingAction$delegate = (ReadWriteProperty)(new ObservableProperty(var6, "KEY_LOGIN_PENDING_ACTION", var10, PreferencesHelper.INSTANCE.get(var6.getBackend(), "KEY_LOGIN_PENDING_ACTION", var10, Reflection.getOrCreateKotlinClass(LoginPendingAction.class))) {
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
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(LoginPendingAction.class));
            }

         }
      });
      MutableStateFlow var7 = StateFlowKt.MutableStateFlow(LinkingState.Idle.INSTANCE);
      this._state = var7;
      this.state = FlowKt.asStateFlow(var7);
   }

   private final boolean doesAlexaAppSupportAppToApp() {
      long var2;
      label69: {
         int var1;
         PackageManager var4;
         try {
            var4 = ((BlueairApp)this.getApplication()).getPackageManager();
            var1 = VERSION.SDK_INT;
         } catch (PackageManager.NameNotFoundException var8) {
            boolean var10001 = false;
            return false;
         }

         PackageInfo var9;
         if (var1 >= 33) {
            try {
               var9 = BlueairApp$$ExternalSyntheticApiModelOutline0.m(var4, "com.amazon.dee.app", BlueairApp$$ExternalSyntheticApiModelOutline0.m(0L));
            } catch (PackageManager.NameNotFoundException var7) {
               boolean var10 = false;
               return false;
            }
         } else {
            try {
               var9 = var4.getPackageInfo("com.amazon.dee.app", 0);
            } catch (PackageManager.NameNotFoundException var6) {
               boolean var11 = false;
               return false;
            }
         }

         try {
            if (VERSION.SDK_INT >= 28) {
               var2 = BlueairApp$$ExternalSyntheticApiModelOutline0.m(var9);
               break label69;
            }
         } catch (PackageManager.NameNotFoundException var5) {
            boolean var12 = false;
            return false;
         }

         if (var9 != null) {
            return true;
         }

         return false;
      }

      if (var2 > 866607211L) {
         return true;
      } else {
         return false;
      }
   }

   private final String generateAlexaState() {
      byte[] var1 = new byte[30];
      (new SecureRandom()).nextBytes(var1);
      String var2 = Base64.urlSafeEncode(var1);
      StringBuilder var3 = new StringBuilder("android.");
      var3.append((new Date()).getTime());
      var3.append('.');
      var3.append(var2);
      String var4 = var3.toString();
      Prefs var5 = this.getSecurePrefs();
      PreferencesHelper.INSTANCE.set(var5.getBackend(), "KEY_ALEXA_LINKING_STATE", var4, Reflection.getOrCreateKotlinClass(String.class));
      return var4;
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final SecurePrefs getSecurePrefs() {
      return (SecurePrefs)this.securePrefs$delegate.getValue();
   }

   private final UnsecurePrefs getUnsecurePrefs() {
      return (UnsecurePrefs)this.unsecurePrefs$delegate.getValue();
   }

   private final boolean validateAlexaState(Uri var1) {
      Prefs var2 = this.getSecurePrefs();
      PreferencesHelper var3 = PreferencesHelper.INSTANCE;
      PrefsBackend var5 = var2.getBackend();
      KClass var4 = Reflection.getOrCreateKotlinClass(String.class);
      Object var7 = null;
      Object var9 = var3.get(var5, "KEY_ALEXA_LINKING_STATE", (Object)null, var4);
      if (((CharSequence)((String)var9)).length() > 0) {
         var7 = var9;
      }

      String var8 = (String)var7;
      if (var8 == null) {
         return false;
      } else {
         this.getSecurePrefs().remove("KEY_ALEXA_LINKING_STATE");
         if (var1 != null) {
            String var6 = var1.getQueryParameter("state");
            if (var6 != null) {
               if (!Intrinsics.areEqual(var6, var8)) {
                  return false;
               }

               if ((new Date()).getTime() - Long.parseLong((String)StringsKt.split$default((CharSequence)var6, new String[]{"."}, false, 0, 6, (Object)null).get(1)) > STATE_VALID_FOR) {
                  return false;
               }

               return true;
            }
         }

         return false;
      }
   }

   public final void fetchLinkingStatus(boolean var1) {
      this._state.setValue(LinkingState.Loading.INSTANCE);
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final boolean $expected;
         int I$0;
         int I$1;
         int label;
         final AccountLinkingViewModel this$0;

         {
            this.$expected = var1;
            this.this$0 = var2;
         }

         // $FF: synthetic method
         public static final Object access$invokeSuspend$getStatus(AccountLinkingViewModel var0, Continuation var1) {
            return invokeSuspend$getStatus(var0, var1);
         }

         private static final Object invokeSuspend$getStatus(AccountLinkingViewModel var0, Continuation var1) {
            return var0.getAccountType() == Integration.GoogleAssistant ? var0.getDeviceManager().getGoogleLinkStatus(var0.getGoogleClientId(), var1) : var0.getDeviceManager().getAlexaLinkStatus(var1);
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$expected, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            int var14;
            label55: {
               Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               var14 = this.label;
               byte var5 = 1;
               int var3;
               if (var14 != 0) {
                  if (var14 != 1) {
                     if (var14 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = this.I$1;
                     var14 = this.I$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     var14 = this.I$1;
                     var3 = this.I$0;
                     ResultKt.throwOnFailure(var1);
                     if ((Boolean)var1 == this.$expected) {
                        break label55;
                     }

                     int var4 = var3 + 1;
                     if (var4 > 3) {
                        var14 = var5;
                        break label55;
                     }

                     Continuation var8 = (Continuation)this;
                     this.I$0 = var4;
                     this.I$1 = var14;
                     this.label = 2;
                     var3 = var14;
                     var14 = var4;
                     if (DelayKt.delay(3000L, var8) == var6) {
                        return var6;
                     }
                  }
               } else {
                  ResultKt.throwOnFailure(var1);
                  var3 = 0;
                  var14 = 0;
               }

               while(true) {
                  AccountLinkingViewModel var9 = this.this$0;
                  Continuation var7 = (Continuation)this;
                  this.I$0 = var14;
                  this.I$1 = var3;
                  this.label = 1;
                  Object var10 = invokeSuspend$getStatus(var9, var7);
                  if (var10 == var6) {
                     return var6;
                  }

                  int var17 = var3;
                  var3 = var14;
                  var14 = var17;
                  if ((Boolean)var10 == this.$expected) {
                     break;
                  }

                  var17 = var3 + 1;
                  if (var17 > 3) {
                     var14 = var5;
                     break;
                  }

                  Continuation var11 = (Continuation)this;
                  this.I$0 = var17;
                  this.I$1 = var14;
                  this.label = 2;
                  var3 = var14;
                  var14 = var17;
                  if (DelayKt.delay(3000L, var11) == var6) {
                     return var6;
                  }
               }
            }

            MutableStateFlow var19 = this.this$0._state;
            if (var14 != 0) {
               var1 = LinkingState.Failed.INSTANCE;
            } else {
               var1 = LinkingState.Success.INSTANCE;
            }

            var19.setValue((LinkingState)var1);
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final void finishAlexaLinking(Uri var1) {
      if (var1 != null) {
         String var2 = var1.getQueryParameter("error");
         if (var2 != null && ((CharSequence)var2).length() > 0 && Intrinsics.areEqual(var2, "access_denied")) {
            this._state.setValue(LinkingState.Cancel.INSTANCE);
         } else {
            var2 = var1.getQueryParameter("code");
            if (this.validateAlexaState(var1) && var2 != null) {
               BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var2, (Continuation)null) {
                  final String $code;
                  Object L$0;
                  int label;
                  final AccountLinkingViewModel this$0;

                  {
                     this.this$0 = var1;
                     this.$code = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, this.$code, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     MutableStateFlow var3;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var3 = (MutableStateFlow)this.L$0;
                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
                        var3 = this.this$0._state;
                        DeviceManager var6 = this.this$0.getDeviceManager();
                        String var5 = this.$code;
                        Continuation var7 = (Continuation)this;
                        this.L$0 = var3;
                        this.label = 1;
                        var1 = (LinkingState)var6.alexaLinkAccount(var5, var7);
                        if (var1 == var4) {
                           return var4;
                        }
                     }

                     if ((Boolean)var1) {
                        var1 = LinkingState.Success.INSTANCE;
                     } else {
                        var1 = LinkingState.Failed.INSTANCE;
                     }

                     var3.setValue(var1);
                     return Unit.INSTANCE;
                  }
               }, 3, (Object)null);
            } else {
               this._state.setValue(LinkingState.Failed.INSTANCE);
            }
         }
      }
   }

   public final void finishGoogleLinking() {
      this._state.setValue(LinkingState.Loading.INSTANCE);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final AccountLinkingViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label152: {
               Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  try {
                     ResultKt.throwOnFailure(var1);
                  } catch (Throwable var18) {
                     boolean var10001 = false;
                     break label152;
                  }
               } else {
                  ResultKt.throwOnFailure(var1);

                  Object var21;
                  try {
                     DeviceManager var6 = this.this$0.getDeviceManager();
                     String var19 = this.this$0.getGoogleClientId();
                     String var5 = this.this$0.getAuthService().getGigyaJwt();
                     Continuation var3 = (Continuation)this;
                     this.label = 1;
                     var21 = var6.googleLinkGetAuthCode(var19, var5, var3);
                  } catch (Throwable var17) {
                     boolean var24 = false;
                     break label152;
                  }

                  var1 = (LinkingState.AuthCodeGot)var21;
                  if (var21 == var4) {
                     return var4;
                  }
               }

               label143:
               try {
                  String var23 = (String)var1;
                  MutableStateFlow var22 = this.this$0._state;
                  var1 = new LinkingState.AuthCodeGot(var23);
                  var22.setValue(var1);
                  return Unit.INSTANCE;
               } catch (Throwable var16) {
                  boolean var25 = false;
                  break label143;
               }
            }

            this.this$0._state.setValue(new LinkingState.AuthCodeGot(""));
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final Integration getAccountType() {
      Integration var1 = this.accountType;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("accountType");
         return null;
      }
   }

   public final boolean getAlexaRedirectUrlRequested() {
      return this.alexaRedirectUrlRequested;
   }

   public final String getGoogleClientId() {
      return LocationService.getGoogleClientId$default(this.getLocationService(), false, 1, (Object)null);
   }

   public final String getGoogleDeeplink() {
      return LocationService.getGoogleDeeplink$default(this.getLocationService(), false, 1, (Object)null);
   }

   public final boolean getGoogleLinkRequested() {
      return (Boolean)this.googleLinkRequested$delegate.getValue(this, $$delegatedProperties[4]);
   }

   public final LoginPendingAction getLoginPendingAction() {
      return (LoginPendingAction)this.loginPendingAction$delegate.getValue(this, $$delegatedProperties[5]);
   }

   public final boolean getStartFromAlexa() {
      return this.startFromAlexa;
   }

   public final StateFlow getState() {
      return this.state;
   }

   public final String getUsername() {
      return this.getAuthService().getUsername();
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.getAuthService().isUserLoggedIn().getValue();
   }

   public final void setAccountType(Integration var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.accountType = var1;
   }

   public final void setAlexaRedirectUrlRequested(boolean var1) {
      this.alexaRedirectUrlRequested = var1;
   }

   public final void setGoogleLinkRequested(boolean var1) {
      this.googleLinkRequested$delegate.setValue(this, $$delegatedProperties[4], var1);
   }

   public final void setLoginPendingAction(LoginPendingAction var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.loginPendingAction$delegate.setValue(this, $$delegatedProperties[5], var1);
   }

   public final void setStartFromAlexa(boolean var1) {
      this.startFromAlexa = var1;
   }

   public final void setState(LinkingState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      this._state.setValue(var1);
   }

   public final Job startAlexaLinking(Uri var1, boolean var2) {
      return BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, this, var2, (Continuation)null) {
         final boolean $accepted;
         final Uri $uri;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         int label;
         final AccountLinkingViewModel this$0;

         {
            this.$uri = var1;
            this.this$0 = var2;
            this.$accepted = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$uri, this.this$0, this.$accepted, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            String var4;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var4 = (String)this.L$4;
               String var5 = (String)this.L$3;
               var5 = (String)this.L$2;
               var5 = (String)this.L$1;
               var5 = (String)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Uri var11 = this.$uri;
               if (var11 == null) {
                  return Unit.INSTANCE;
               }

               String var12 = var11.getQueryParameter("client_id");
               if (var12 == null) {
                  var12 = "";
               }

               var4 = this.$uri.getQueryParameter("response_type");
               if (var4 == null) {
                  var4 = "";
               }

               String var18 = this.$uri.getQueryParameter("state");
               if (var18 == null) {
                  var18 = "";
               }

               String var6 = this.$uri.getQueryParameter("scope");
               if (var6 == null) {
                  var6 = "";
               }

               String var7 = this.$uri.getQueryParameter("redirect_uri");
               if (var7 == null) {
                  return Unit.INSTANCE;
               }

               this.this$0.setStartFromAlexa(true);
               this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
               DeviceManager var10 = this.this$0.getDeviceManager();
               boolean var3 = this.$accepted;
               Continuation var9 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var12);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
               this.L$2 = SpillingKt.nullOutSpilledVariable(var18);
               this.L$3 = SpillingKt.nullOutSpilledVariable(var6);
               this.L$4 = var7;
               this.label = 1;
               var1 = var10.getAlexaRedirectUrl(var12, var4, var18, var6, var7, var3, var9);
               if (var1 == var8) {
                  return var8;
               }

               var4 = var7;
            }

            String var13 = (String)var1;
            CharSequence var19 = (CharSequence)var13;
            if (var19 == null || var19.length() == 0) {
               var13 = Uri.parse(var4).buildUpon().appendQueryParameter("error", "access_denied").appendQueryParameter("state", "authorizationRequestState").appendQueryParameter("error_description", "get auth code failed").build().toString();
            }

            this.this$0.setAlexaRedirectUrlRequested(true);
            this.this$0._state.setValue(new LinkingState.UrlGot(var13));
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final Job startLinking() {
      return BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final AccountLinkingViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label36: {
               Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  String var3 = (String)this.L$0;
                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
                  Integration var6 = this.this$0.getAccountType();
                  var2 = null.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
                  if (var2 != 1) {
                     if (var2 != 2) {
                        return Unit.INSTANCE;
                     }

                     var1 = new LinkingState.UrlGot(this.this$0.getGoogleDeeplink());
                     break label36;
                  }

                  String var11 = this.this$0.generateAlexaState();
                  DeviceManager var7 = this.this$0.getDeviceManager();
                  Continuation var5 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var11);
                  this.label = 1;
                  Object var12 = var7.getAlexaLinkingUrls(var11, var5);
                  var1 = (LinkingState.UrlGot)var12;
                  if (var12 == var4) {
                     return var4;
                  }
               }

               Pair var13 = (Pair)var1;
               if (var13 == null) {
                  this.this$0._state.setValue(LinkingState.Failed.INSTANCE);
                  return Unit.INSTANCE;
               }

               String var8 = (String)var13.component1();
               String var14 = (String)var13.component2();
               if (!this.this$0.doesAlexaAppSupportAppToApp()) {
                  var8 = var14;
               }

               var1 = new LinkingState.UrlGot(var8);
            }

            this.this$0._state.setValue(var1);
            return Unit.INSTANCE;
         }

         // $FF: synthetic class
         @Metadata(
            k = 3,
            mv = {2, 2, 0},
            xi = 48
         )
         public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
               int[] var0 = new int[Integration.values().length];

               try {
                  var0[Integration.AmazonAlexa.ordinal()] = 1;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[Integration.GoogleAssistant.ordinal()] = 2;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var0;
            }
         }
      }, 3, (Object)null);
   }

   public final Job unlink() {
      return BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final AccountLinkingViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var3;
            label36: {
               label35: {
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 == 1) {
                        ResultKt.throwOnFailure(var1);
                        break label35;
                     }

                     if (var2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     this.this$0._state.setValue(LinkingState.Loading.INSTANCE);
                     Integration var7 = this.this$0.getAccountType();
                     if (null.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()] == 1) {
                        DeviceManager var9 = this.this$0.getDeviceManager();
                        Continuation var12 = (Continuation)this;
                        this.label = 1;
                        Object var13 = var9.unlinkAlexa(var12);
                        var1 = var13;
                        if (var13 == var5) {
                           return var5;
                        }
                        break label35;
                     }

                     DeviceManager var6 = this.this$0.getDeviceManager();
                     String var8 = this.this$0.getGoogleClientId();
                     Continuation var4 = (Continuation)this;
                     this.label = 2;
                     Object var11 = var6.unlinkGoogle(var8, var4);
                     var1 = var11;
                     if (var11 == var5) {
                        return var5;
                     }
                  }

                  var3 = (Boolean)var1;
                  break label36;
               }

               var3 = (Boolean)var1;
            }

            MutableStateFlow var14 = this.this$0._state;
            if (var3) {
               var1 = LinkingState.Success.INSTANCE;
            } else {
               var1 = LinkingState.Failed.INSTANCE;
            }

            var14.setValue((LinkingState)var1);
            return Unit.INSTANCE;
         }

         // $FF: synthetic class
         @Metadata(
            k = 3,
            mv = {2, 2, 0},
            xi = 48
         )
         public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
               int[] var1 = new int[Integration.values().length];

               try {
                  var1[Integration.AmazonAlexa.ordinal()] = 1;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var1;
            }
         }
      }, 3, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/android/viewmodel/AccountLinkingViewModel$Companion;", "", "<init>", "()V", "STATE_VALID_FOR", "", "ALEXA_PACKAGE_NAME", "", "REQUIRED_MINIMUM_VERSION_CODE", "", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
