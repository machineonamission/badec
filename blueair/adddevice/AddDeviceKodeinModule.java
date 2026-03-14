package com.blueair.adddevice;

import android.content.Context;
import android.content.res.Resources;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.adddevice.service.DfuService;
import com.blueair.auth.AuthService;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DI;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.bindings.DIBinding;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"},
   d2 = {"Lcom/blueair/adddevice/AddDeviceKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceKodeinModule {
   public static final AddDeviceKodeinModule INSTANCE = new AddDeviceKodeinModule();
   public static final String moduleName = "AddDevice";

   // $FF: synthetic method
   public static Unit $r8$lambda$HYTwZDEutxFVf2O4BGVTPrAVPoo(Context var0, DI.Builder var1) {
      return getModule$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static AddDeviceService $r8$lambda$Wqnif5xXDzrv6X_s6Ay9i_XMZew/* $FF was: $r8$lambda$Wqnif5xXDzrv6X_s6Ay9i-XMZew*/(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$2$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static BlueAirManager $r8$lambda$j_17IW07lqmoQGWh7gnpYu3ES1M(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$2$lambda$1(var0, var1);
   }

   private AddDeviceKodeinModule() {
   }

   private static final Unit getModule$lambda$2(Context var0, DI.Builder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$Module");
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var8 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, AddDeviceService.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var12 = (DI.BindBuilder.WithScope)var1;
      AddDeviceKodeinModule$$ExternalSyntheticLambda0 var4 = new AddDeviceKodeinModule$$ExternalSyntheticLambda0(var0);
      Scope var6 = var12.getScope();
      TypeToken var5 = var12.getContextType();
      boolean var2 = var12.getExplicitContext();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var8.with((DIBinding)(new Singleton(var6, var5, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, AddDeviceService.class)), (RefMaker)null, true, var4)));
      JVMTypeToken var14 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var10 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var14, BlueAirManager.class)), (Object)null, (Boolean)null);
      AddDeviceKodeinModule$$ExternalSyntheticLambda1 var16 = new AddDeviceKodeinModule$$ExternalSyntheticLambda1(var0);
      Scope var15 = var12.getScope();
      TypeToken var9 = var12.getContextType();
      var2 = var12.getExplicitContext();
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var10.with((DIBinding)(new Singleton(var15, var9, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var13, BlueAirManager.class)), (RefMaker)null, true, var16)));
      return Unit.INSTANCE;
   }

   private static final AddDeviceService getModule$lambda$2$lambda$0(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDIAware var8 = (DirectDIAware)var1;
      DirectDI var3 = var8.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      Resources var10 = (Resources)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, Resources.class)), (Object)null);
      var3 = var8.getDirectDI();
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DeviceManager var12 = (DeviceManager)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, DeviceManager.class)), (Object)null);
      DirectDI var5 = var8.getDirectDI();
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      AuthService var14 = (AuthService)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, AuthService.class)), (Object)null);
      DirectDI var6 = var8.getDirectDI();
      JVMTypeToken var15 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var15, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      SecurePrefs var16 = (SecurePrefs)var6.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var15, SecurePrefs.class)), (Object)null);
      var6 = var8.getDirectDI();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      UnsecurePrefs var18 = (UnsecurePrefs)var6.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var7, UnsecurePrefs.class)), (Object)null);
      DirectDI var9 = var8.getDirectDI();
      var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new AddDeviceService(var0, var10, var12, var14, var16, var18, (AnalyticsService)var9.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var7, AnalyticsService.class)), (Object)null));
   }

   private static final BlueAirManager getModule$lambda$2$lambda$1(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDI var2 = ((DirectDIAware)var1).getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new BlueAirManager(var0, DfuService.class, (AnalyticsService)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, AnalyticsService.class)), (Object)null));
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("AddDevice", false, (String)null, new AddDeviceKodeinModule$$ExternalSyntheticLambda2(var1), 6, (DefaultConstructorMarker)null);
   }
}
