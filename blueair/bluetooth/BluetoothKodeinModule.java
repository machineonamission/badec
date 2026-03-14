package com.blueair.bluetooth;

import android.content.Context;
import com.blueair.bluetooth.service.BleScanningService;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DI;
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
   d2 = {"Lcom/blueair/bluetooth/BluetoothKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothKodeinModule {
   public static final BluetoothKodeinModule INSTANCE = new BluetoothKodeinModule();
   public static final String moduleName = "Bluetooth";

   // $FF: synthetic method
   public static BleScanningService $r8$lambda$8tOFgPKQffRJIEg_JRCw1FdZBa0(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$2$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static BluetoothConnectivityService $r8$lambda$fqcUSb7WNXm2kcsgli_PLGFEQt8/* $FF was: $r8$lambda$fqcUSb7WNXm2kcsgli-PLGFEQt8*/(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gPPIr_9ByWzvBlSjP531g3L4rZw/* $FF was: $r8$lambda$gPPIr-9ByWzvBlSjP531g3L4rZw*/(Context var0, DI.Builder var1) {
      return getModule$lambda$2(var0, var1);
   }

   private BluetoothKodeinModule() {
   }

   private static final Unit getModule$lambda$2(Context var0, DI.Builder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$Module");
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var8 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, BleScanningService.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var12 = (DI.BindBuilder.WithScope)var1;
      BluetoothKodeinModule$$ExternalSyntheticLambda1 var6 = new BluetoothKodeinModule$$ExternalSyntheticLambda1(var0);
      Scope var7 = var12.getScope();
      TypeToken var4 = var12.getContextType();
      boolean var2 = var12.getExplicitContext();
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var8.with((DIBinding)(new Singleton(var7, var4, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, BleScanningService.class)), (RefMaker)null, true, var6)));
      JVMTypeToken var14 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var10 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var14, BluetoothConnectivityService.class)), (Object)null, (Boolean)null);
      BluetoothKodeinModule$$ExternalSyntheticLambda2 var9 = new BluetoothKodeinModule$$ExternalSyntheticLambda2(var0);
      Scope var16 = var12.getScope();
      TypeToken var15 = var12.getContextType();
      var2 = var12.getExplicitContext();
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var10.with((DIBinding)(new Singleton(var16, var15, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var13, BluetoothConnectivityService.class)), (RefMaker)null, true, var9)));
      return Unit.INSTANCE;
   }

   private static final BleScanningService getModule$lambda$2$lambda$0(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      return new BleScanningService(var0);
   }

   private static final BluetoothConnectivityService getModule$lambda$2$lambda$1(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      return new BluetoothConnectivityService(var0);
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("Bluetooth", false, (String)null, new BluetoothKodeinModule$$ExternalSyntheticLambda0(var1), 6, (DefaultConstructorMarker)null);
   }
}
