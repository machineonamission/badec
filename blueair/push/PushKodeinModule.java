package com.blueair.push;

import android.content.Context;
import com.blueair.auth.AuthService;
import com.blueair.auth.LogOutService;
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
   d2 = {"Lcom/blueair/push/PushKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "push_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PushKodeinModule {
   public static final PushKodeinModule INSTANCE = new PushKodeinModule();
   public static final String moduleName = "Push";

   // $FF: synthetic method
   public static JPushSdkService $r8$lambda$iSWWGjXFBvY3fXeh1dm4VoKZI9M(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$3$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$myeKdpbJl5c9k1m7c_b5fQNmvpM(Context var0, DI.Builder var1) {
      return getModule$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static NotificationService $r8$lambda$v_MRES1AFC4X08_7WpDdx7XFtKI(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$3$lambda$0(var0, var1);
   }

   private PushKodeinModule() {
   }

   private static final Unit getModule$lambda$3(Context var0, DI.Builder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$Module");
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var6 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, NotificationService.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var12 = (DI.BindBuilder.WithScope)var1;
      PushKodeinModule$$ExternalSyntheticLambda0 var7 = new PushKodeinModule$$ExternalSyntheticLambda0(var0);
      Scope var4 = var12.getScope();
      TypeToken var8 = var12.getContextType();
      boolean var2 = var12.getExplicitContext();
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var6.with((DIBinding)(new Singleton(var4, var8, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, NotificationService.class)), (RefMaker)null, true, var7)));
      JVMTypeToken var14 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var10 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var14, JPushSdkService.class)), (Object)null, (Boolean)null);
      PushKodeinModule$$ExternalSyntheticLambda1 var16 = new PushKodeinModule$$ExternalSyntheticLambda1(var0);
      Scope var15 = var12.getScope();
      TypeToken var9 = var12.getContextType();
      var2 = var12.getExplicitContext();
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var10.with((DIBinding)(new Singleton(var15, var9, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var13, JPushSdkService.class)), (RefMaker)null, true, var16)));
      return Unit.INSTANCE;
   }

   private static final NotificationService getModule$lambda$3$lambda$0(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDIAware var3 = (DirectDIAware)var1;
      DirectDI var4 = var3.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, DeviceManager.class)), (Object)null);
      var4 = var3.getDirectDI();
      var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new NotificationService(var0, (AuthService)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null));
   }

   private static final JPushSdkService getModule$lambda$3$lambda$2(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDI var2 = ((DirectDIAware)var1).getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      JPushSdkService var4 = new JPushSdkService(var0, (DeviceManager)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, DeviceManager.class)), (Object)null));
      LogOutService.Companion.registerLogOutable(var1, var4);
      return var4;
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("Push", false, (String)null, new PushKodeinModule$$ExternalSyntheticLambda2(var1), 6, (DefaultConstructorMarker)null);
   }
}
