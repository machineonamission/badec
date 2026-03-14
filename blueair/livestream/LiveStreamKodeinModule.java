package com.blueair.livestream;

import android.content.Context;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.auth.AuthService;
import com.blueair.core.util.NetworkMonitor;
import io.flatcircle.ble.BleIcpController;
import io.flatcircle.ble.BleService;
import io.flatcircle.mqtt.MqttService;
import io.flatcircle.stomp.StompService;
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
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"},
   d2 = {"Lcom/blueair/livestream/LiveStreamKodeinModule;", "", "<init>", "()V", "MODULE_NAME", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "livestream_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LiveStreamKodeinModule {
   public static final LiveStreamKodeinModule INSTANCE = new LiveStreamKodeinModule();
   private static final String MODULE_NAME = "LiveStream";

   // $FF: synthetic method
   public static BleService $r8$lambda$1oa_WReKwh8_45sOYBPd1cUqwRc/* $FF was: $r8$lambda$1oa-WReKwh8-45sOYBPd1cUqwRc*/(NoArgBindingDI var0) {
      return getModule$lambda$4$lambda$3(var0);
   }

   // $FF: synthetic method
   public static StompService $r8$lambda$A8A7P6NmYgX2h1sAJXnenpQy2VI(NoArgBindingDI var0) {
      return getModule$lambda$4$lambda$2(var0);
   }

   // $FF: synthetic method
   public static MqttService $r8$lambda$RFdEu1gVbXtTPD8bVpREP_JokEE(NoArgBindingDI var0) {
      return getModule$lambda$4$lambda$1(var0);
   }

   // $FF: synthetic method
   public static StreamService $r8$lambda$ZIoXlwt_I7DXRavl4ZicPqBJPgo/* $FF was: $r8$lambda$ZIoXlwt-I7DXRavl4ZicPqBJPgo*/(NoArgBindingDI var0) {
      return getModule$lambda$4$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ZcXQTyFYBXvzxX18F7sO041v6SA(DI.Builder var0) {
      return getModule$lambda$4(var0);
   }

   private LiveStreamKodeinModule() {
   }

   private static final Unit getModule$lambda$4(DI.Builder var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$Module");
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var7 = var0.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var2, StreamService.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var12 = (DI.BindBuilder.WithScope)var0;
      LiveStreamKodeinModule$$ExternalSyntheticLambda1 var5 = new LiveStreamKodeinModule$$ExternalSyntheticLambda1();
      Scope var4 = var12.getScope();
      TypeToken var6 = var12.getContextType();
      boolean var1 = var12.getExplicitContext();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var7.with((DIBinding)(new Singleton(var4, var6, var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, StreamService.class)), (RefMaker)null, true, var5)));
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var7 = var0.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, MqttService.class)), (Object)null, (Boolean)null);
      LiveStreamKodeinModule$$ExternalSyntheticLambda2 var26 = new LiveStreamKodeinModule$$ExternalSyntheticLambda2();
      var4 = var12.getScope();
      TypeToken var23 = var12.getContextType();
      var1 = var12.getExplicitContext();
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var7.with((DIBinding)(new Singleton(var4, var23, var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, MqttService.class)), (RefMaker)null, true, var26)));
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var24 = var0.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, StompService.class)), (Object)null, (Boolean)null);
      LiveStreamKodeinModule$$ExternalSyntheticLambda3 var21 = new LiveStreamKodeinModule$$ExternalSyntheticLambda3();
      Scope var27 = var12.getScope();
      TypeToken var29 = var12.getContextType();
      var1 = var12.getExplicitContext();
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var24.with((DIBinding)(new Singleton(var27, var29, var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, StompService.class)), (RefMaker)null, true, var21)));
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var8 = var0.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, BleService.class)), (Object)null, (Boolean)null);
      LiveStreamKodeinModule$$ExternalSyntheticLambda4 var22 = new LiveStreamKodeinModule$$ExternalSyntheticLambda4();
      Scope var19 = var12.getScope();
      TypeToken var25 = var12.getContextType();
      var1 = var12.getExplicitContext();
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var8.with((DIBinding)(new Singleton(var19, var25, var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var13, BleService.class)), (RefMaker)null, true, var22)));
      return Unit.INSTANCE;
   }

   private static final StreamService getModule$lambda$4$lambda$0(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var1 = (DirectDIAware)var0;
      DirectDI var5 = var1.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      MqttService var6 = (MqttService)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, MqttService.class)), (Object)null);
      DirectDI var3 = var1.getDirectDI();
      var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      StompService var9 = (StompService)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, StompService.class)), (Object)null);
      DirectDI var4 = var1.getDirectDI();
      JVMTypeToken var10 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      BleService var11 = (BleService)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var10, BleService.class)), (Object)null);
      var4 = var1.getDirectDI();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new StreamService(var6, var9, var11, (NetworkMonitor)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var7, NetworkMonitor.class)), (Object)null));
   }

   private static final MqttService getModule$lambda$4$lambda$1(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDI var1 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new MqttService((AuthService)var1.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null));
   }

   private static final StompService getModule$lambda$4$lambda$2(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDI var2 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new StompService((AuthService)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var1, AuthService.class)), (Object)null));
   }

   private static final BleService getModule$lambda$4$lambda$3(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var1 = (DirectDIAware)var0;
      DirectDI var3 = var1.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      BlueAirManager var4 = (BlueAirManager)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, BlueAirManager.class)), (Object)null);
      DirectDI var6 = var1.getDirectDI();
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new BleService(new BleIcpController(var4, (AuthService)var6.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var5, AuthService.class)), (Object)null)));
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("LiveStream", false, (String)null, new LiveStreamKodeinModule$$ExternalSyntheticLambda0(), 6, (DefaultConstructorMarker)null);
   }
}
