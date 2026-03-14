package com.blueair.auth;

import android.content.Context;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
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
   d2 = {"Lcom/blueair/auth/AuthKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AuthKodeinModule {
   public static final AuthKodeinModule INSTANCE = new AuthKodeinModule();
   public static final String moduleName = "auth";

   // $FF: synthetic method
   public static Unit $r8$lambda$EHYpIJSE_qjrJSP8vZF7WAp_WY0/* $FF was: $r8$lambda$EHYpIJSE-qjrJSP8vZF7WAp-WY0*/(Context var0, DI.Builder var1) {
      return getModule$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static FacebookService $r8$lambda$HwAmBnNTAjAn89RHjNVRoonVugc(NoArgBindingDI var0) {
      return getModule$lambda$6$lambda$2(var0);
   }

   // $FF: synthetic method
   public static LogOutService $r8$lambda$Xgj3qP_xVntsBELQ4q7DEoF7Gec(NoArgBindingDI var0) {
      return getModule$lambda$6$lambda$5(var0);
   }

   // $FF: synthetic method
   public static AuthService $r8$lambda$_LKm02m7uljMR3xgoOM0N2ZgXm8(NoArgBindingDI var0) {
      return getModule$lambda$6$lambda$4(var0);
   }

   // $FF: synthetic method
   public static LocationService $r8$lambda$gywlVUtp4S0lwMDw09NQKvlbYjs(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$6$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static GigyaService $r8$lambda$uNiZRfecZ_yt6LPycgAGe_3U86A/* $FF was: $r8$lambda$uNiZRfecZ-yt6LPycgAGe_3U86A*/(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$6$lambda$1(var0, var1);
   }

   private AuthKodeinModule() {
   }

   private static final Unit getModule$lambda$6(Context var0, DI.Builder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$Module");
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var7 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, LocationService.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var21 = (DI.BindBuilder.WithScope)var1;
      AuthKodeinModule$$ExternalSyntheticLambda0 var4 = new AuthKodeinModule$$ExternalSyntheticLambda0(var0);
      Scope var5 = var21.getScope();
      TypeToken var8 = var21.getContextType();
      boolean var2 = var21.getExplicitContext();
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var7.with((DIBinding)(new Singleton(var5, var8, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (RefMaker)null, true, var4)));
      JVMTypeToken var23 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var23, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var24 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var23, GigyaService.class)), (Object)null, (Boolean)null);
      AuthKodeinModule$$ExternalSyntheticLambda1 var9 = new AuthKodeinModule$$ExternalSyntheticLambda1(var0);
      Scope var35 = var21.getScope();
      TypeToken var28 = var21.getContextType();
      var2 = var21.getExplicitContext();
      var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var24.with((DIBinding)(new Singleton(var35, var28, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, GigyaService.class)), (RefMaker)null, true, var9)));
      JVMTypeToken var10 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var33 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var10, FacebookService.class)), (Object)null, (Boolean)null);
      AuthKodeinModule$$ExternalSyntheticLambda2 var11 = new AuthKodeinModule$$ExternalSyntheticLambda2();
      Scope var25 = var21.getScope();
      TypeToken var36 = var21.getContextType();
      var2 = var21.getExplicitContext();
      JVMTypeToken var29 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var29, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var33.with((DIBinding)(new Singleton(var25, var36, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var29, FacebookService.class)), (RefMaker)null, true, var11)));
      JVMTypeToken var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var26 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var12, AuthService.class)), (Object)null, (Boolean)null);
      AuthKodeinModule$$ExternalSyntheticLambda3 var30 = new AuthKodeinModule$$ExternalSyntheticLambda3();
      Scope var34 = var21.getScope();
      var36 = var21.getContextType();
      var2 = var21.getExplicitContext();
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var26.with((DIBinding)(new Singleton(var34, var36, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, AuthService.class)), (RefMaker)null, true, var30)));
      var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var16 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var12, LogOutService.class)), (Object)null, (Boolean)null);
      AuthKodeinModule$$ExternalSyntheticLambda4 var31 = new AuthKodeinModule$$ExternalSyntheticLambda4();
      Scope var27 = var21.getScope();
      TypeToken var15 = var21.getContextType();
      var2 = var21.getExplicitContext();
      JVMTypeToken var22 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var22, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var16.with((DIBinding)(new Singleton(var27, var15, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var22, LogOutService.class)), (RefMaker)null, true, var31)));
      return Unit.INSTANCE;
   }

   private static final LocationService getModule$lambda$6$lambda$0(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDI var2 = ((DirectDIAware)var1).getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new LocationService(var0, (UnsecurePrefs)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, UnsecurePrefs.class)), (Object)null));
   }

   private static final GigyaService getModule$lambda$6$lambda$1(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDIAware var5 = (DirectDIAware)var1;
      DirectDI var2 = var5.getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LocationService var7 = (LocationService)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, LocationService.class)), (Object)null);
      DirectDI var4 = var5.getDirectDI();
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      SecurePrefs var9 = (SecurePrefs)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, SecurePrefs.class)), (Object)null);
      var4 = var5.getDirectDI();
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new GigyaService(var0, var7, var9, (AnalyticsService)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var6, AnalyticsService.class)), (Object)null));
   }

   private static final FacebookService getModule$lambda$6$lambda$2(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      return new FacebookService();
   }

   private static final AuthService getModule$lambda$6$lambda$4(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var2 = (DirectDIAware)var0;
      DirectDI var3 = var2.getDirectDI();
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      GigyaService var7 = (GigyaService)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var1, GigyaService.class)), (Object)null);
      var3 = var2.getDirectDI();
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      SecurePrefs var11 = (SecurePrefs)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, SecurePrefs.class)), (Object)null);
      DirectDI var12 = var2.getDirectDI();
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      UnsecurePrefs var13 = (UnsecurePrefs)var12.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var5, UnsecurePrefs.class)), (Object)null);
      DirectDI var14 = var2.getDirectDI();
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LocationService var15 = (LocationService)var14.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null);
      DirectDI var16 = var2.getDirectDI();
      JVMTypeToken var9 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      AuthService var8 = new AuthService(var7, var11, var13, var15, (AnalyticsService)var16.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var9, AnalyticsService.class)), (Object)null), (Interceptor)null, 32, (DefaultConstructorMarker)null);
      LogOutService.Companion.registerLogOutable(var0, var8);
      return var8;
   }

   private static final LogOutService getModule$lambda$6$lambda$5(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDI var1 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new LogOutService((AnalyticsService)var1.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, AnalyticsService.class)), (Object)null));
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("auth", false, (String)null, new AuthKodeinModule$$ExternalSyntheticLambda5(var1), 6, (DefaultConstructorMarker)null);
   }
}
