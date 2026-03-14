package com.blueair.android;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import com.blueair.adddevice.AddDeviceKodeinModule;
import com.blueair.auth.AuthKodeinModule;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaServer;
import com.blueair.auth.GigyaService;
import com.blueair.auth.LocationService;
import com.blueair.bluetooth.BluetoothKodeinModule;
import com.blueair.core.AblEnvironment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.core.util.PhoneUtil;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.DeviceManagerKodeinModule;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.outdoor.OutdoorKodeinModule;
import com.blueair.push.NotificationService;
import com.blueair.push.PushKodeinModule;
import com.blueair.sdk.BugfenderSdk;
import com.blueair.sdk.KlaviyoSdk;
import com.blueair.sdk.LokaliseSdk;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ResourcesLocationNamePlaceholderProvider;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.gigya.android.sdk.Gigya;
import com.jacquessmuts.rxextensions.RxHelper;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.joda.time.LocalDateTime;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.LazyDI;
import org.kodein.di.LazyDelegate;
import org.kodein.di.DI.Companion;
import org.kodein.di.DI.Builder.DefaultImpls;
import org.kodein.di.bindings.DIBinding;
import org.kodein.di.bindings.InstanceBinding;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.Provider;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002"},
   d2 = {"Lcom/blueair/android/BlueairApp;", "Landroid/app/Application;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/LazyDI;", "getDi", "()Lorg/kodein/di/LazyDI;", "di$delegate", "isInChinaLauncherProcess", "", "onCreate", "", "onAppUpgrade", "oldVersionCode", "", "oldVersionName", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "InMemoryTree", "BugfenderTree", "app_otherRelease", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "authService", "Lcom/blueair/auth/AuthService;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "locationService", "Lcom/blueair/auth/LocationService;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "notificationService", "Lcom/blueair/push/NotificationService;", "gigyaService", "Lcom/blueair/auth/GigyaService;"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueairApp extends Application implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BlueairApp.class, "di", "getDi()Lorg/kodein/di/LazyDI;", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "analyticsService", "<v#0>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "authService", "<v#1>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "prefs", "<v#2>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "happyUserService", "<v#3>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "locationService", "<v#4>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "deviceManager", "<v#5>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "welcomeHomeService", "<v#6>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "notificationService", "<v#7>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "analyticsService", "<v#8>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "gigyaService", "<v#9>", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(BlueairApp.class, "authService", "<v#10>", 0)))};
   public static final int $stable = 8;
   private final LazyDI di$delegate;
   private final boolean isInChinaLauncherProcess;

   // $FF: synthetic method
   public static void $r8$lambda$6Pub07nIEoi69N60IXiMhj_83dU/* $FF was: $r8$lambda$6Pub07nIEoi69N60IXiMhj-83dU*/(Function1 var0, Object var1) {
      onCreate$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static LocationPermissionTracker $r8$lambda$AOrcfHpZ1Xi0MNsIA58c6kLwn2c(NoArgBindingDI var0) {
      return di_delegate$lambda$8$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$G6wMKwJ2iLe5kHKoBz3KhbO2URo(Throwable var0) {
      return onCreate$lambda$10(var0);
   }

   // $FF: synthetic method
   public static WelcomeHomeService $r8$lambda$Q70TNVSpx8T73O4HEyRL_Y8RImw/* $FF was: $r8$lambda$Q70TNVSpx8T73O4HEyRL-Y8RImw*/(BlueairApp var0, NoArgBindingDI var1) {
      return di_delegate$lambda$8$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static UnsecurePrefs $r8$lambda$Ri2aK2awhfR7afGJWIk_vHx8k3Y/* $FF was: $r8$lambda$Ri2aK2awhfR7afGJWIk-vHx8k3Y*/(BlueairApp var0, NoArgBindingDI var1) {
      return di_delegate$lambda$8$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static ResourcesLocationNamePlaceholderProvider $r8$lambda$VoD6NOUVBq7wGGLeapasEatK1sI(BlueairApp var0, NoArgBindingDI var1) {
      return di_delegate$lambda$8$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$alS6qVv8DiqrW_35NY45K2djFy4/* $FF was: $r8$lambda$alS6qVv8DiqrW-35NY45K2djFy4*/(BlueairApp var0, DI.MainBuilder var1) {
      return di_delegate$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static AnalyticsService $r8$lambda$nLoaq958hSn5ZoNBwhgstGCk_oo/* $FF was: $r8$lambda$nLoaq958hSn5ZoNBwhgstGCk-oo*/(BlueairApp var0, NoArgBindingDI var1) {
      return di_delegate$lambda$8$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static SecurePrefs $r8$lambda$rlqJ2e_y0MK5zUZOEDAWJ6_ydho/* $FF was: $r8$lambda$rlqJ2e-y0MK5zUZOEDAWJ6-ydho*/(BlueairApp var0, NoArgBindingDI var1) {
      return di_delegate$lambda$8$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static HappyUserService $r8$lambda$vxetUFXeLeGsBdU16IcxTgeQcxs(NoArgBindingDI var0) {
      return di_delegate$lambda$8$lambda$6(var0);
   }

   // $FF: synthetic method
   public static NetworkMonitor $r8$lambda$wHxeTnqFkglNSreEvYJ9snU_TSU/* $FF was: $r8$lambda$wHxeTnqFkglNSreEvYJ9snU-TSU*/(BlueairApp var0, NoArgBindingDI var1) {
      return di_delegate$lambda$8$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$x1mkIecv9_kaOI6VmUI7lc7UDBo/* $FF was: $r8$lambda$x1mkIecv9-kaOI6VmUI7lc7UDBo*/(Throwable var0) {
      return onCreate$lambda$20(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xoHlR5lkY6SIwQCLJA_UukDdOy0(Thread var0, Throwable var1) {
      onCreate$lambda$9(var0, var1);
   }

   public BlueairApp() {
      this.di$delegate = Companion.lazy$default(DI.Companion, false, new BlueairApp$$ExternalSyntheticLambda4(this), 1, (Object)null);
      this.isInChinaLauncherProcess = StringsKt.startsWith$default(FilesKt.readText$default(new File("/proc/self/cmdline"), (Charset)null, 1, (Object)null), ".china_launcher", false, 2, (Object)null);
   }

   private static final Unit di_delegate$lambda$8(BlueairApp var0, DI.MainBuilder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$lazy");
      DI.Builder var3 = (DI.Builder)var1;
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var5 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var4, Application.class)), (Object)null, (Boolean)null);
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var5.with((DIBinding)(new InstanceBinding((TypeToken)(new GenericJVMTypeTokenDelegate(var4, BlueairApp.class)), var0)));
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var5 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var4, Context.class)), (Object)null, (Boolean)null);
      Context var6 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var6, "getApplicationContext(...)");
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var5.with((DIBinding)(new InstanceBinding((TypeToken)(new GenericJVMTypeTokenDelegate(var4, Context.class)), var6)));
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var57 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var4, Resources.class)), (Object)null, (Boolean)null);
      Resources var44 = var0.getApplicationContext().getResources();
      Intrinsics.checkNotNullExpressionValue(var44, "getResources(...)");
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var57.with((DIBinding)(new InstanceBinding((TypeToken)(new GenericJVMTypeTokenDelegate(var4, Resources.class)), var44)));
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var8 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var4, LocationNamePlaceholderProvider.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var36 = (DI.BindBuilder.WithScope)var1;
      BlueairApp$$ExternalSyntheticLambda5 var45 = new BlueairApp$$ExternalSyntheticLambda5(var0);
      Scope var9 = var36.getScope();
      TypeToken var58 = var36.getContextType();
      boolean var2 = var36.getExplicitContext();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var8.with((DIBinding)(new Singleton(var9, var58, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, ResourcesLocationNamePlaceholderProvider.class)), (RefMaker)null, true, var45)));
      JVMTypeToken var46 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var46, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var47 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var46, AnalyticsService.class)), (Object)null, (Boolean)null);
      BlueairApp$$ExternalSyntheticLambda6 var79 = new BlueairApp$$ExternalSyntheticLambda6(var0);
      Scope var67 = var36.getScope();
      var58 = var36.getContextType();
      var2 = var36.getExplicitContext();
      JVMTypeToken var74 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var74, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var47.with((DIBinding)(new Singleton(var67, var58, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var74, AnalyticsService.class)), (RefMaker)null, true, var79)));
      JVMTypeToken var48 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var48, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var75 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var48, UnsecurePrefs.class)), (Object)null, (Boolean)null);
      BlueairApp$$ExternalSyntheticLambda7 var49 = new BlueairApp$$ExternalSyntheticLambda7(var0);
      Scope var80 = var36.getScope();
      var58 = var36.getContextType();
      var2 = var36.getExplicitContext();
      JVMTypeToken var68 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var68, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var75.with((DIBinding)(new Singleton(var80, var58, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var68, UnsecurePrefs.class)), (RefMaker)null, true, var49)));
      JVMTypeToken var50 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var50, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var69 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var50, SecurePrefs.class)), (Object)null, (Boolean)null);
      BlueairApp$$ExternalSyntheticLambda8 var51 = new BlueairApp$$ExternalSyntheticLambda8(var0);
      Scope var76 = var36.getScope();
      TypeToken var81 = var36.getContextType();
      var2 = var36.getExplicitContext();
      JVMTypeToken var61 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var61, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var69.with((DIBinding)(new Singleton(var76, var81, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var61, SecurePrefs.class)), (RefMaker)null, true, var51)));
      JVMTypeToken var52 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var52, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var53 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var52, LocationPermissionTracker.class)), (Object)null, (Boolean)null);
      DI.BindBuilder var62 = (DI.BindBuilder)var1;
      BlueairApp$$ExternalSyntheticLambda9 var11 = new BlueairApp$$ExternalSyntheticLambda9();
      TypeToken var70 = var62.getContextType();
      JVMTypeToken var63 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var63, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var53.with((DIBinding)(new Provider(var70, (TypeToken)(new GenericJVMTypeTokenDelegate(var63, LocationPermissionTracker.class)), var11)));
      JVMTypeToken var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var77 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var12, NetworkMonitor.class)), (Object)null, (Boolean)null);
      BlueairApp$$ExternalSyntheticLambda10 var64 = new BlueairApp$$ExternalSyntheticLambda10(var0);
      Scope var71 = var36.getScope();
      TypeToken var54 = var36.getContextType();
      var2 = var36.getExplicitContext();
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var77.with((DIBinding)(new Singleton(var71, var54, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, NetworkMonitor.class)), (RefMaker)null, true, var64)));
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var72 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var12, HappyUserService.class)), (Object)null, (Boolean)null);
      BlueairApp$$ExternalSyntheticLambda11 var65 = new BlueairApp$$ExternalSyntheticLambda11();
      Scope var78 = var36.getScope();
      TypeToken var15 = var36.getContextType();
      var2 = var36.getExplicitContext();
      JVMTypeToken var55 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var55, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var72.with((DIBinding)(new Singleton(var78, var15, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var55, HappyUserService.class)), (RefMaker)null, true, var65)));
      JVMTypeToken var16 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var16, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var66 = var3.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var16, WelcomeHomeService.class)), (Object)null, (Boolean)null);
      BlueairApp$$ExternalSyntheticLambda12 var73 = new BlueairApp$$ExternalSyntheticLambda12(var0);
      Scope var56 = var36.getScope();
      TypeToken var17 = var36.getContextType();
      var2 = var36.getExplicitContext();
      JVMTypeToken var37 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var37, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var66.with((DIBinding)(new Singleton(var56, var17, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var37, WelcomeHomeService.class)), (RefMaker)null, true, var73)));
      AuthKodeinModule var18 = AuthKodeinModule.INSTANCE;
      Context var38 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var38, "getApplicationContext(...)");
      DefaultImpls.importOnce$default(var3, var18.getModule(var38), false, 2, (Object)null);
      AddDeviceKodeinModule var19 = AddDeviceKodeinModule.INSTANCE;
      var38 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var38, "getApplicationContext(...)");
      DefaultImpls.importOnce$default(var3, var19.getModule(var38), false, 2, (Object)null);
      DeviceManagerKodeinModule var20 = DeviceManagerKodeinModule.INSTANCE;
      var38 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var38, "getApplicationContext(...)");
      DefaultImpls.importOnce$default(var3, var20.getModule(var38), false, 2, (Object)null);
      PushKodeinModule var21 = PushKodeinModule.INSTANCE;
      var38 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var38, "getApplicationContext(...)");
      DefaultImpls.importOnce$default(var3, var21.getModule(var38), false, 2, (Object)null);
      BluetoothKodeinModule var22 = BluetoothKodeinModule.INSTANCE;
      var38 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var38, "getApplicationContext(...)");
      DefaultImpls.importOnce$default(var3, var22.getModule(var38), false, 2, (Object)null);
      OutdoorKodeinModule var23 = OutdoorKodeinModule.INSTANCE;
      Context var10 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var10, "getApplicationContext(...)");
      DefaultImpls.importOnce$default(var3, var23.getModule(var10), false, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final ResourcesLocationNamePlaceholderProvider di_delegate$lambda$8$lambda$0(BlueairApp var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      Context var2 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getApplicationContext(...)");
      return new ResourcesLocationNamePlaceholderProvider(var2);
   }

   private static final AnalyticsService di_delegate$lambda$8$lambda$1(BlueairApp var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      return new AnalyticsService(var0);
   }

   private static final UnsecurePrefs di_delegate$lambda$8$lambda$2(BlueairApp var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      Context var2 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getApplicationContext(...)");
      return new UnsecurePrefs(var2);
   }

   private static final SecurePrefs di_delegate$lambda$8$lambda$3(BlueairApp var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      Context var2 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getApplicationContext(...)");
      return new SecurePrefs(var2);
   }

   private static final LocationPermissionTracker di_delegate$lambda$8$lambda$4(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$provider");
      DirectDI var1 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new LocationPermissionTracker((UnsecurePrefs)var1.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, UnsecurePrefs.class)), (Object)null));
   }

   private static final NetworkMonitor di_delegate$lambda$8$lambda$5(BlueairApp var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      Context var2 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getApplicationContext(...)");
      return new NetworkMonitor(var2);
   }

   private static final HappyUserService di_delegate$lambda$8$lambda$6(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDI var1 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new HappyUserService((UnsecurePrefs)var1.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, UnsecurePrefs.class)), (Object)null));
   }

   private static final WelcomeHomeService di_delegate$lambda$8$lambda$7(BlueairApp var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      Context var3 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var3, "getApplicationContext(...)");
      DirectDI var2 = ((DirectDIAware)var1).getDirectDI();
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new WelcomeHomeService(var3, (UnsecurePrefs)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, UnsecurePrefs.class)), (Object)null));
   }

   private final void onAppUpgrade(int var1, String var2) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("onAppUpgrade: from ");
      var4.append(var2);
      var4.append('(');
      var4.append(var1);
      var4.append(") to 4.5.2(2366)");
      var3.d(var4.toString(), new Object[0]);
      DIAware var7 = this;
      JVMTypeToken var9 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var10 = DIAwareKt.Instance(var7, (TypeToken)(new GenericJVMTypeTokenDelegate(var9, AnalyticsService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      Lazy var11 = var10.provideDelegate((Object)null, var5[9]);
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      Lazy var8 = DIAwareKt.Instance(var7, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, GigyaService.class)), (Object)null).provideDelegate((Object)null, var5[10]);
      onAppUpgrade$lambda$23(var11).event(new AnalyticEvent.AppUpgradeEvent(onAppUpgrade$lambda$24(var8).getGigyaUid(), var1, var2, 2366, "4.5.2"));
   }

   private static final AnalyticsService onAppUpgrade$lambda$23(Lazy var0) {
      return (AnalyticsService)var0.getValue();
   }

   private static final GigyaService onAppUpgrade$lambda$24(Lazy var0) {
      return (GigyaService)var0.getValue();
   }

   private static final AuthService onConfigurationChanged$lambda$25(Lazy var0) {
      return (AuthService)var0.getValue();
   }

   private static final Unit onCreate$lambda$10(Throwable var0) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("RxJavaError: ");
      var1.append(var0.getMessage());
      var2.e(var0, var1.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$11(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final AnalyticsService onCreate$lambda$12(Lazy var0) {
      return (AnalyticsService)var0.getValue();
   }

   private static final AuthService onCreate$lambda$13(Lazy var0) {
      return (AuthService)var0.getValue();
   }

   private static final UnsecurePrefs onCreate$lambda$14(Lazy var0) {
      return (UnsecurePrefs)var0.getValue();
   }

   private static final HappyUserService onCreate$lambda$15(Lazy var0) {
      return (HappyUserService)var0.getValue();
   }

   private static final LocationService onCreate$lambda$16(Lazy var0) {
      return (LocationService)var0.getValue();
   }

   private static final DeviceManager onCreate$lambda$17(Lazy var0) {
      return (DeviceManager)var0.getValue();
   }

   private static final WelcomeHomeService onCreate$lambda$18(Lazy var0) {
      return (WelcomeHomeService)var0.getValue();
   }

   private static final NotificationService onCreate$lambda$19(Lazy var0) {
      return (NotificationService)var0.getValue();
   }

   private static final Unit onCreate$lambda$20(Throwable var0) {
      Intrinsics.checkNotNullParameter(var0, "throwable");
      Timber.Forest.e(var0);
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$9(Thread var0, Throwable var1) {
      Timber.Forest.e(var1, "Uncaught exception", new Object[0]);
      System.exit(-1);
      throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
   }

   public LazyDI getDi() {
      return this.di$delegate.getValue(this, $$delegatedProperties[0]);
   }

   public DIContext getDiContext() {
      return org.kodein.di.DIAware.DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return org.kodein.di.DIAware.DefaultImpls.getDiTrigger(this);
   }

   public void onConfigurationChanged(Configuration var1) {
      Intrinsics.checkNotNullParameter(var1, "newConfig");
      super.onConfigurationChanged(var1);
      if (!this.isInChinaLauncherProcess) {
         DIAware var3 = this;
         JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var4 = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null).provideDelegate((Object)null, $$delegatedProperties[11]);
         BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var4, (Continuation)null) {
            final Lazy $authService$delegate;
            int label;

            {
               this.$authService$delegate = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.$authService$delegate, var2));
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
                  var1 = BlueairApp.onConfigurationChanged$lambda$25(this.$authService$delegate);
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var1.updateLanguage(var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }
   }

   public void onCreate() {
      super.onCreate();
      if (this.isInChinaLauncherProcess) {
         if (VERSION.SDK_INT >= 28) {
            BlueairApp$$ExternalSyntheticApiModelOutline0.m(".china_launcher");
         }

      } else {
         BuildEnvironment.INSTANCE.setVersionName("4.5.2");
         BuildEnvironment.INSTANCE.setVersionCode(2366);
         BuildEnvironment.INSTANCE.setApplicationId("com.blueair.android");
         BuildVariant var3 = BuildEnvironment.INSTANCE.getVariant();
         int var1 = BlueairApp.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               Timber.Forest.plant(new AnalyticsService.CrashlyticsTree());
               Timber.Forest.plant(new BugfenderTree());
            } else {
               Timber.Forest.plant((Timber.Tree)(new Timber.DebugTree()));
               Timber.Forest.plant(new AnalyticsService.CrashlyticsTree());
               Timber.Forest.plant(new BugfenderTree());
            }
         } else {
            Timber.Forest.plant((Timber.Tree)(new Timber.DebugTree()));
         }

         Timber.Forest.plant((Timber.Tree)(new InMemoryTree()));
         Thread.setDefaultUncaughtExceptionHandler(new BlueairApp$$ExternalSyntheticLambda13());
         CustomViewModelStoreOwner.Companion var17 = CustomViewModelStoreOwner.Companion;
         Application var8 = this;
         var17.setApplication(var8);
         LokaliseSdk.INSTANCE.init(var8);
         SkuConfigurationManager var18 = SkuConfigurationManager.INSTANCE;
         Context var7 = (Context)this;
         var18.loadFromFile(var7);
         UserInfoCollectionsManager.INSTANCE.initialize(var7);
         RxJavaPlugins.setErrorHandler(new BlueairApp$$ExternalSyntheticLambda2(new BlueairApp$$ExternalSyntheticLambda1()));
         DIAware var19 = this;
         JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         LazyDelegate var36 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var4, AnalyticsService.class)), (Object)null);
         KProperty[] var13 = $$delegatedProperties;
         Lazy var12 = var36.provideDelegate((Object)null, var13[1]);
         JVMTypeToken var37 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var37, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var38 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var37, AuthService.class)), (Object)null).provideDelegate((Object)null, var13[2]);
         JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var39 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, UnsecurePrefs.class)), (Object)null).provideDelegate((Object)null, var13[3]);
         JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var9 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, HappyUserService.class)), (Object)null).provideDelegate((Object)null, var13[4]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var10 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null).provideDelegate((Object)null, var13[5]);
         var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var42 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, DeviceManager.class)), (Object)null).provideDelegate((Object)null, var13[6]);
         JVMTypeToken var11 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var45 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var11, WelcomeHomeService.class)), (Object)null).provideDelegate((Object)null, var13[7]);
         JVMTypeToken var14 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         Lazy var46 = DIAwareKt.Instance(var19, (TypeToken)(new GenericJVMTypeTokenDelegate(var14, NotificationService.class)), (Object)null).provideDelegate((Object)null, var13[8]);
         DeviceConfigProvider.INSTANCE.init(onCreate$lambda$16(var10));
         Prefs var20 = onCreate$lambda$14(var39);
         if ((Boolean)PreferencesHelper.INSTANCE.get(var20.getBackend(), "KEY_UAT_MODE", false, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            AblEnvironment.INSTANCE.setBaseUrl("https://api-uat.blueair.io/");
         }

         GigyaServer.Companion var21 = GigyaServer.Companion;
         Prefs var47 = onCreate$lambda$14(var39);
         var21.setUseSandbox((Boolean)PreferencesHelper.INSTANCE.get(var47.getBackend(), "KEY_USE_GIGYA_SANDBOX", false, Reflection.getOrCreateKotlinClass(Boolean.class)));
         Prefs var22 = onCreate$lambda$14(var39);
         String var23;
         if ((Boolean)PreferencesHelper.INSTANCE.get(var22.getBackend(), "KEY_DEV_KLAVIYO", false, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            var23 = "UGGizX";
         } else {
            var23 = "WaDDdd";
         }

         KlaviyoSdk.INSTANCE.initialize(var23, var8);
         LokaliseSdk var24 = LokaliseSdk.INSTANCE;
         var47 = onCreate$lambda$14(var39);
         boolean var2 = BuildEnvironment.INSTANCE.isRelease();
         var24.updateTranslations((Boolean)PreferencesHelper.INSTANCE.get(var47.getBackend(), "KEY_LOKALISE_PRE_RELEASE", var2 ^ true, Reflection.getOrCreateKotlinClass(Boolean.class)));
         BugfenderSdk.INSTANCE.init(var8);
         DialogUtils.INSTANCE.init(var7);
         Gigya.setApplication(var8);
         onCreate$lambda$16(var10).fetchRegion();
         onCreate$lambda$13(var38).updateHomeHost();
         var2 = onCreate$lambda$16(var10).isInChina();
         AnalyticsService var25 = onCreate$lambda$12(var12);
         Prefs var43 = onCreate$lambda$14(var39);
         var25.initAmplitude((Boolean)PreferencesHelper.INSTANCE.get(var43.getBackend(), "KEY_AMPLITUDE_DEBUG", false, Reflection.getOrCreateKotlinClass(Boolean.class)), var2);
         LocationService var44 = onCreate$lambda$16(var10);
         String var26;
         if (var2) {
            if (PhoneUtil.INSTANCE.isHuaweiServicesAvailable(var7)) {
               var26 = "https://appgallery.huawei.com/#/app/C102387123";
            } else {
               var26 = "https://sj.qq.com/myapp/detail.htm?apkName=com.blueair.android&info=158CA4C865D3B9A3F0FD335059CBD22C";
            }
         } else {
            var26 = "https://play.google.com/store/apps/details?id=com.blueair.android";
         }

         var44.setMarketLink(var26);
         RxHelper.INSTANCE.setDefaultErrorHandling(new BlueairApp$$ExternalSyntheticLambda3());
         onCreate$lambda$19(var46).initialize();
         onCreate$lambda$15(var9).setCountryAvailable(onCreate$lambda$16(var10).isInRateUsRegion());
         onCreate$lambda$15(var9).reset(onCreate$lambda$16(var10).getRateUsResetTimestamp());
         onCreate$lambda$15(var9).initResetTimeStamp();
         onCreate$lambda$18(var45).setCountryAvailable(onCreate$lambda$16(var10).isInWelcomeHomeRegion());
         if (!onCreate$lambda$15(var9).isRateUsShown() && onCreate$lambda$15(var9).getG4NewBlueOnboardStamp() != -1L) {
            HappyUserService var27 = onCreate$lambda$15(var9);
            var27.setAppLaunchCount(var27.getAppLaunchCount() + 1);
         }

         onCreate$lambda$14(var39).remove("KEY_LOGIN_PENDING_ACTION");
         Prefs var28 = onCreate$lambda$14(var39);
         Object var29 = PreferencesHelper.INSTANCE.get(var28.getBackend(), "KEY_LEGACY_DEVICE_TO_DELETE", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
         if (((CharSequence)((String)var29)).length() <= 0) {
            var29 = null;
         }

         String var30 = (String)var29;
         if (var30 != null) {
            BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var30, var42, var39, (Continuation)null) {
               final Lazy $deviceManager$delegate;
               final String $it;
               final Lazy $prefs$delegate;
               int label;

               {
                  this.$it = var1;
                  this.$deviceManager$delegate = var2;
                  this.$prefs$delegate = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$it, this.$deviceManager$delegate, this.$prefs$delegate, var2));
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
                     var1 = BlueairApp.onCreate$lambda$17(this.$deviceManager$delegate);
                     String var4 = this.$it;
                     Continuation var5 = (Continuation)this;
                     this.label = 1;
                     if (var1.removeAblDeviceRemote(var4, var5) == var3) {
                        return var3;
                     }
                  }

                  BlueairApp.onCreate$lambda$14(this.$prefs$delegate).remove("KEY_LEGACY_DEVICE_TO_DELETE");
                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         }

         Prefs var31 = onCreate$lambda$14(var39);
         if (!(Boolean)PreferencesHelper.INSTANCE.get(var31.getBackend(), "temp_unit_was_set", false, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var39, var42, (Continuation)null) {
               final Lazy $deviceManager$delegate;
               final Lazy $prefs$delegate;
               Object L$0;
               int label;

               {
                  this.$prefs$delegate = var1;
                  this.$deviceManager$delegate = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.$prefs$delegate, this.$deviceManager$delegate, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  String var3;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var3 = (String)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     var3 = (String)this.L$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     String var7;
                     if (BlueairApp.onCreate$lambda$14(this.$prefs$delegate).isTempCelsius()) {
                        var7 = "Celsius";
                     } else {
                        var7 = "Fahrenheit";
                     }

                     DeviceManager var4 = BlueairApp.onCreate$lambda$17(this.$deviceManager$delegate);
                     Continuation var10 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                     this.label = 1;
                     Object var11 = var4.setTemperatureSettings(var7, var10);
                     var3 = var7;
                     var1 = var11;
                     if (var11 == var5) {
                        return var5;
                     }
                  }

                  ApiResult var6 = (ApiResult)var1;
                  Function2 var8 = new Function2(this.$prefs$delegate, (Continuation)null) {
                     final Lazy $prefs$delegate;
                     int label;

                     {
                        this.$prefs$delegate = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.$prefs$delegate, var2));
                     }

                     public final Object invoke(Unit var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           Prefs var3 = BlueairApp.onCreate$lambda$14(this.$prefs$delegate);
                           Boolean var2 = Boxing.boxBoolean(true);
                           PreferencesHelper.INSTANCE.set(var3.getBackend(), "temp_unit_was_set", var2, Reflection.getOrCreateKotlinClass(Boolean.class));
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var12 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                  this.label = 2;
                  if (ApiResultKt.onSuccess(var6, var8, var12) == var5) {
                     return var5;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, 3, (Object)null);
         }

         var31 = onCreate$lambda$14(var39);
         var1 = ((Number)PreferencesHelper.INSTANCE.get(var31.getBackend(), "KEY_PREVIOUS_VERSION_CODE", 0, Reflection.getOrCreateKotlinClass(Integer.class))).intValue();
         if (var1 > 0 && 2366 > var1) {
            var31 = onCreate$lambda$14(var39);
            this.onAppUpgrade(var1, (String)PreferencesHelper.INSTANCE.get(var31.getBackend(), "KEY_PREVIOUS_VERSION_NAME", "unknown", Reflection.getOrCreateKotlinClass(String.class)));
         }

         var31 = onCreate$lambda$14(var39);
         PreferencesHelper.INSTANCE.set(var31.getBackend(), "KEY_PREVIOUS_VERSION_CODE", 2366, Reflection.getOrCreateKotlinClass(Integer.class));
         var31 = onCreate$lambda$14(var39);
         PreferencesHelper.INSTANCE.set(var31.getBackend(), "KEY_PREVIOUS_VERSION_NAME", "4.5.2", Reflection.getOrCreateKotlinClass(String.class));
         BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var38, (Continuation)null) {
            final Lazy $authService$delegate;
            int label;

            {
               this.$authService$delegate = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.$authService$delegate, var2));
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
                  var1 = BlueairApp.onCreate$lambda$13(this.$authService$delegate);
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var1.updateLanguage(var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000f"},
      d2 = {"Lcom/blueair/android/BlueairApp$BugfenderTree;", "Ltimber/log/Timber$Tree;", "<init>", "()V", "log", "", "priority", "", "tag", "", "message", "t", "", "findCaller", "Ljava/lang/StackTraceElement;", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BugfenderTree extends Timber.Tree {
      public static final int $stable = 8;

      private final StackTraceElement findCaller(Throwable var1) {
         StackTraceElement[] var4 = var1.getStackTrace();
         int var3 = var4.length;

         for(int var2 = 2; var2 < var3; ++var2) {
            String var5 = var4[var2].getClassName();
            Intrinsics.checkNotNullExpressionValue(var5, "getClassName(...)");
            if (!StringsKt.startsWith$default(var5, "timber.log.", false, 2, (Object)null)) {
               return var4[var2];
            }
         }

         return null;
      }

      protected void log(int var1, String var2, String var3, Throwable var4) {
         Intrinsics.checkNotNullParameter(var3, "message");
         StackTraceElement var8 = this.findCaller((Throwable)(new Exception()));
         if (var8 != null) {
            String var6 = var8.getClassName();
            Intrinsics.checkNotNullExpressionValue(var6, "getClassName(...)");
            if (StringsKt.endsWith$default(var6, "StompService", false, 2, (Object)null)) {
               StringBuilder var10 = new StringBuilder();
               var10.append(var8.getClassName());
               var10.append('.');
               var10.append(var8.getMethodName());
               String var11 = var10.toString();
               BugfenderSdk var7 = BugfenderSdk.INSTANCE;
               int var5 = var8.getLineNumber();
               String var9 = var8.getFileName();
               Intrinsics.checkNotNullExpressionValue(var9, "getFileName(...)");
               var7.log(var5, var11, var9, var1, var2, var3);
            }
         }

      }
   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002"},
      d2 = {"Lcom/blueair/android/BlueairApp$InMemoryTree;", "Ltimber/log/Timber$DebugTree;", "<init>", "(Lcom/blueair/android/BlueairApp;)V", "logCount", "", "tempContent", "", "isResizing", "", "logWriter", "Ljava/io/BufferedWriter;", "log", "", "priority", "tag", "message", "t", "", "checkFileSizeLimit", "sizeInMb", "app_otherRelease", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public final class InMemoryTree extends Timber.DebugTree {
      private volatile boolean isResizing;
      private int logCount;
      private final BufferedWriter logWriter;
      private String tempContent;
      final BlueairApp this$0;

      public InMemoryTree() {
         this.this$0 = BlueairApp.this;
         this.tempContent = "";
         FileOutputStream var2 = BlueairApp.this.openFileOutput("debug_log", 32768);
         Intrinsics.checkNotNullExpressionValue(var2, "openFileOutput(...)");
         Writer var3 = (Writer)(new OutputStreamWriter((OutputStream)var2, Charsets.UTF_8));
         BufferedWriter var4;
         if (var3 instanceof BufferedWriter) {
            var4 = (BufferedWriter)var3;
         } else {
            var4 = new BufferedWriter(var3, 8192);
         }

         this.logWriter = var4;
      }

      public final void checkFileSizeLimit(int var1) {
         synchronized(this){}

         Throwable var10000;
         label1162: {
            try {
               Log.d("BlueairApp", "checkLogFileSizeLimit");
               this.isResizing = true;
            } catch (Throwable var141) {
               var10000 = var141;
               boolean var10001 = false;
               break label1162;
            }

            label1163: {
               label1164: {
                  long var2;
                  File var9;
                  try {
                     var9 = this.this$0.getFileStreamPath("debug_log");
                     var2 = var9.length();
                  } catch (Throwable var140) {
                     var10000 = var140;
                     boolean var149 = false;
                     break label1164;
                  }

                  long var4 = (long)var1 * 1048576L;
                  if (var2 <= var4) {
                     break label1163;
                  }

                  RandomAccessFile var8;
                  try {
                     Log.d("BlueairApp", "doLogFileResize");
                     var8 = new RandomAccessFile(var9, "rw");
                     var8.seek(var2 - var4);
                     var8.readLine();
                     var4 = var8.getFilePointer();
                     var147 = new byte[1024];
                     var1 = var8.read(var147);
                  } catch (Throwable var139) {
                     var10000 = var139;
                     boolean var150 = false;
                     break label1164;
                  }

                  var2 = 0L;

                  while(var1 >= 0) {
                     try {
                        var8.seek(var2);
                        var8.write(var147, 0, var1);
                     } catch (Throwable var138) {
                        var10000 = var138;
                        boolean var151 = false;
                        break label1164;
                     }

                     long var6 = (long)var1;
                     var4 += var6;
                     var2 += var6;

                     try {
                        var8.seek(var4);
                        var1 = var8.read(var147);
                     } catch (Throwable var137) {
                        var10000 = var137;
                        boolean var152 = false;
                        break label1164;
                     }
                  }

                  label1133:
                  try {
                     var8.setLength(var2);
                     var8.close();
                     break label1163;
                  } catch (Throwable var136) {
                     var10000 = var136;
                     boolean var153 = false;
                     break label1133;
                  }
               }

               Throwable var145 = var10000;

               try {
                  this.isResizing = false;
                  if (((CharSequence)this.tempContent).length() > 0) {
                     this.logWriter.append((CharSequence)this.tempContent).flush();
                  }
               } catch (Throwable var133) {
                  var10000 = var133;
                  boolean var154 = false;
                  break label1162;
               }

               try {
                  this.tempContent = "";
                  throw var145;
               } catch (Throwable var132) {
                  var10000 = var132;
                  boolean var155 = false;
                  break label1162;
               }
            }

            try {
               this.isResizing = false;
               if (((CharSequence)this.tempContent).length() > 0) {
                  this.logWriter.append((CharSequence)this.tempContent).flush();
               }
            } catch (Throwable var135) {
               var10000 = var135;
               boolean var156 = false;
               break label1162;
            }

            label1125:
            try {
               this.tempContent = "";
               return;
            } catch (Throwable var134) {
               var10000 = var134;
               boolean var157 = false;
               break label1125;
            }
         }

         while(true) {
            Throwable var146 = var10000;

            try {
               throw var146;
            } catch (Throwable var131) {
               var10000 = var131;
               boolean var158 = false;
               continue;
            }
         }
      }

      protected void log(int var1, String var2, String var3, Throwable var4) {
         Intrinsics.checkNotNullParameter(var3, "message");
         String var5;
         switch (var1) {
            case 2:
               return;
            case 3:
               var5 = "D";
               break;
            case 4:
               var5 = "I";
               break;
            case 5:
               var5 = "W";
               break;
            case 6:
               var5 = "E";
               break;
            case 7:
               var5 = "A";
               break;
            default:
               var5 = "U";
         }

         StringBuilder var6 = new StringBuilder();
         var6.append(LocalDateTime.now());
         var6.append(" | ");
         var6.append(var5);
         var6.append(" | ");
         if (var2 == null) {
            var2 = "";
         }

         var6.append(StringsKt.padEnd$default(var2, 35, '\u0000', 2, (Object)null));
         var6.append(" | ");
         var6.append(var3);
         var6.append(" | ");
         Serializable var8;
         if (var4 != null) {
            var8 = (Serializable)var4;
         } else {
            var8 = (Serializable)"";
         }

         var6.append(var8);
         var6.append('\n');
         String var9 = var6.toString();
         if (this.isResizing) {
            StringBuilder var10 = new StringBuilder();
            var10.append(this.tempContent);
            var10.append(var9);
            this.tempContent = var10.toString();
         } else {
            this.logWriter.append((CharSequence)var9).flush();
         }

         var1 = this.logCount + 1;
         this.logCount = var1;
         if (var1 > 10000) {
            this.logCount = 0;
            BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this.this$0, this, (Continuation)null) {
               static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property0((PropertyReference0)(new PropertyReference0Impl(InMemoryTree.class, "prefs", "<v#0>", 0)))};
               int label;
               final BlueairApp this$0;
               final InMemoryTree this$1;

               {
                  this.this$0 = var1;
                  this.this$1 = var2;
               }

               private static final UnsecurePrefs invokeSuspend$lambda$0(Lazy var0) {
                  return (UnsecurePrefs)var0.getValue();
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.this$1, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     DIAware var3 = this.this$0;
                     JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
                     }).getSuperType());
                     Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
                     Prefs var6 = invokeSuspend$lambda$0(DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var4, UnsecurePrefs.class)), (Object)null).provideDelegate((Object)null, $$delegatedProperties[0]));
                     Integer var5 = Boxing.boxInt(100);
                     int var2 = ((Number)PreferencesHelper.INSTANCE.get(var6.getBackend(), "KEY_MAX_LOG_FILE_SIZE", var5, Reflection.getOrCreateKotlinClass(Integer.class))).intValue();
                     this.this$1.checkFileSizeLimit(var2);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            }, 2, (Object)null);
         }

      }
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
         int[] var0 = new int[BuildVariant.values().length];

         try {
            var0[BuildVariant.DEBUG.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[BuildVariant.BETA.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[BuildVariant.RELEASE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
