package com.blueair.devicemanager;

import android.content.Context;
import android.content.res.Resources;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.repository.DeviceRepository;
import com.blueair.database.repository.DeviceScheduleRepository;
import com.blueair.database.repository.NotificationRepository;
import com.blueair.database.repository.TrackedLocationRepository;
import com.blueair.livestream.LiveStreamKodeinModule;
import com.blueair.livestream.StreamService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DI;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.DI.Builder.DefaultImpls;
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
   d2 = {"Lcom/blueair/devicemanager/DeviceManagerKodeinModule;", "", "<init>", "()V", "MODULE_NAME", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceManagerKodeinModule {
   public static final DeviceManagerKodeinModule INSTANCE = new DeviceManagerKodeinModule();
   private static final String MODULE_NAME = "DeviceManager";

   // $FF: synthetic method
   public static NotificationRepository $r8$lambda$_PZVBUXN1gwcHHNG35GagKrNk7Q/* $FF was: $r8$lambda$-PZVBUXN1gwcHHNG35GagKrNk7Q*/(NoArgBindingDI var0) {
      return getModule$lambda$7$lambda$6(var0);
   }

   // $FF: synthetic method
   public static BlueairDatabase $r8$lambda$LF_SN278AJfHYVf5yt6bWiI__kY/* $FF was: $r8$lambda$LF-SN278AJfHYVf5yt6bWiI--kY*/(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$7$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$NuYYi_BS5ZWEd4crJzENtMEHOJw(Context var0, DI.Builder var1) {
      return getModule$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceScheduleService $r8$lambda$Ve5hpJBMHb8xtZVz8pF_obglcEY/* $FF was: $r8$lambda$Ve5hpJBMHb8xtZVz8pF-obglcEY*/(NoArgBindingDI var0) {
      return getModule$lambda$7$lambda$5(var0);
   }

   // $FF: synthetic method
   public static DeviceScheduleRepository $r8$lambda$agp59sTDN8GfTqWnmp9r9Yj1NTc(NoArgBindingDI var0) {
      return getModule$lambda$7$lambda$2(var0);
   }

   // $FF: synthetic method
   public static DeviceManager $r8$lambda$kvDNQGip0g2sbTGE51NoUtGL_BE/* $FF was: $r8$lambda$kvDNQGip0g2sbTGE51NoUtGL-BE*/(NoArgBindingDI var0) {
      return getModule$lambda$7$lambda$4(var0);
   }

   // $FF: synthetic method
   public static DeviceRepository $r8$lambda$pIy7RwrHnWKSsAZYEXs81eYQ5ZU(NoArgBindingDI var0) {
      return getModule$lambda$7$lambda$1(var0);
   }

   private DeviceManagerKodeinModule() {
   }

   private static final Unit getModule$lambda$7(Context var0, DI.Builder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$Module");
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var4 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, BlueairDatabase.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var14 = (DI.BindBuilder.WithScope)var1;
      DeviceManagerKodeinModule$$ExternalSyntheticLambda1 var8 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda1(var0);
      Scope var5 = var14.getScope();
      TypeToken var6 = var14.getContextType();
      boolean var2 = var14.getExplicitContext();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var4.with((DIBinding)(new Singleton(var5, var6, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, BlueairDatabase.class)), (RefMaker)null, true, var8)));
      JVMTypeToken var16 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var16, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var41 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var16, DeviceRepository.class)), (Object)null, (Boolean)null);
      DeviceManagerKodeinModule$$ExternalSyntheticLambda2 var17 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda2();
      Scope var31 = var14.getScope();
      TypeToken var26 = var14.getContextType();
      var2 = var14.getExplicitContext();
      var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var41.with((DIBinding)(new Singleton(var31, var26, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, DeviceRepository.class)), (RefMaker)null, true, var17)));
      JVMTypeToken var18 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var18, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var37 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var18, DeviceScheduleRepository.class)), (Object)null, (Boolean)null);
      DeviceManagerKodeinModule$$ExternalSyntheticLambda3 var19 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda3();
      Scope var27 = var14.getScope();
      TypeToken var42 = var14.getContextType();
      var2 = var14.getExplicitContext();
      JVMTypeToken var32 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var32, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var37.with((DIBinding)(new Singleton(var27, var42, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var32, DeviceScheduleRepository.class)), (RefMaker)null, true, var19)));
      JVMTypeToken var20 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var20, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var37 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var20, DeviceManager.class)), (Object)null, (Boolean)null);
      DeviceManagerKodeinModule$$ExternalSyntheticLambda4 var21 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda4();
      Scope var43 = var14.getScope();
      TypeToken var28 = var14.getContextType();
      var2 = var14.getExplicitContext();
      var32 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var32, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var37.with((DIBinding)(new Singleton(var43, var28, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var32, DeviceManager.class)), (RefMaker)null, true, var21)));
      JVMTypeToken var22 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var22, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var37 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var22, DeviceScheduleService.class)), (Object)null, (Boolean)null);
      DeviceManagerKodeinModule$$ExternalSyntheticLambda5 var44 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda5();
      Scope var29 = var14.getScope();
      TypeToken var34 = var14.getContextType();
      var2 = var14.getExplicitContext();
      var22 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var22, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var37.with((DIBinding)(new Singleton(var29, var34, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var22, DeviceScheduleService.class)), (RefMaker)null, true, var44)));
      var22 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var22, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var35 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var22, NotificationRepository.class)), (Object)null, (Boolean)null);
      DeviceManagerKodeinModule$$ExternalSyntheticLambda6 var25 = new DeviceManagerKodeinModule$$ExternalSyntheticLambda6();
      var29 = var14.getScope();
      TypeToken var40 = var14.getContextType();
      var2 = var14.getExplicitContext();
      JVMTypeToken var15 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var15, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var35.with((DIBinding)(new Singleton(var29, var40, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var15, NotificationRepository.class)), (RefMaker)null, true, var25)));
      DefaultImpls.importOnce$default(var1, LiveStreamKodeinModule.INSTANCE.getModule(var0), false, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final BlueairDatabase getModule$lambda$7$lambda$0(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      return BlueairDatabase.Companion.getDatabase(var0);
   }

   private static final DeviceRepository getModule$lambda$7$lambda$1(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var6 = (DirectDIAware)var0;
      DirectDI var2 = var6.getDirectDI();
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      BlueairDatabase var8 = (BlueairDatabase)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var1, BlueairDatabase.class)), (Object)null);
      var2 = var6.getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      TrackedLocationRepository var10 = (TrackedLocationRepository)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, TrackedLocationRepository.class)), (Object)null);
      DirectDI var4 = var6.getDirectDI();
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      UnsecurePrefs var12 = (UnsecurePrefs)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, UnsecurePrefs.class)), (Object)null);
      DirectDI var5 = var6.getDirectDI();
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      AnalyticsService var14 = (AnalyticsService)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var13, AnalyticsService.class)), (Object)null);
      var5 = var6.getDirectDI();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new DeviceRepository(var8, var10, var12, var14, (LocationService)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var7, LocationService.class)), (Object)null));
   }

   private static final DeviceScheduleRepository getModule$lambda$7$lambda$2(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDI var1 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new DeviceScheduleRepository((BlueairDatabase)var1.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, BlueairDatabase.class)), (Object)null));
   }

   private static final DeviceManager getModule$lambda$7$lambda$4(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var1 = (DirectDIAware)var0;
      DirectDI var2 = var1.getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      Resources var15 = (Resources)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, Resources.class)), (Object)null);
      DirectDI var16 = var1.getDirectDI();
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DeviceRepository var17 = (DeviceRepository)var16.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, DeviceRepository.class)), (Object)null);
      DirectDI var18 = var1.getDirectDI();
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DeviceScheduleRepository var19 = (DeviceScheduleRepository)var18.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var5, DeviceScheduleRepository.class)), (Object)null);
      DirectDI var20 = var1.getDirectDI();
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      NotificationRepository var21 = (NotificationRepository)var20.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var6, NotificationRepository.class)), (Object)null);
      DirectDI var22 = var1.getDirectDI();
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      AuthService var23 = (AuthService)var22.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var7, AuthService.class)), (Object)null);
      DirectDI var8 = var1.getDirectDI();
      var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      StreamService var25 = (StreamService)var8.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var7, StreamService.class)), (Object)null);
      var8 = var1.getDirectDI();
      JVMTypeToken var9 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      UnsecurePrefs var27 = (UnsecurePrefs)var8.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var9, UnsecurePrefs.class)), (Object)null);
      DirectDI var10 = var1.getDirectDI();
      var9 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      AnalyticsService var29 = (AnalyticsService)var10.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var9, AnalyticsService.class)), (Object)null);
      var10 = var1.getDirectDI();
      JVMTypeToken var11 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LocationService var31 = (LocationService)var10.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var11, LocationService.class)), (Object)null);
      DirectDI var32 = var1.getDirectDI();
      JVMTypeToken var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      HappyUserService var33 = (HappyUserService)var32.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var12, HappyUserService.class)), (Object)null);
      DirectDI var34 = var1.getDirectDI();
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DeviceManager var14 = new DeviceManager(var15, var17, var19, var21, var23, var25, var27, var29, var31, var33, (WelcomeHomeService)var34.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var13, WelcomeHomeService.class)), (Object)null));
      LogOutService.Companion.registerLogOutable(var0, var14);
      return var14;
   }

   private static final DeviceScheduleService getModule$lambda$7$lambda$5(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var3 = (DirectDIAware)var0;
      DirectDI var1 = var3.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DeviceManager var5 = (DeviceManager)var1.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, DeviceManager.class)), (Object)null);
      DirectDI var4 = var3.getDirectDI();
      var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new DeviceScheduleService(var5, (DeviceScheduleRepository)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, DeviceScheduleRepository.class)), (Object)null));
   }

   private static final NotificationRepository getModule$lambda$7$lambda$6(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDIAware var1 = (DirectDIAware)var0;
      DirectDI var3 = var1.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      BlueairDatabase var4 = (BlueairDatabase)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, BlueairDatabase.class)), (Object)null);
      DirectDI var5 = var1.getDirectDI();
      var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new NotificationRepository(var4, (DeviceRepository)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, DeviceRepository.class)), (Object)null));
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("DeviceManager", false, (String)null, new DeviceManagerKodeinModule$$ExternalSyntheticLambda0(var1), 6, (DefaultConstructorMarker)null);
   }
}
