package com.blueair.outdoor;

import android.content.Context;
import android.content.res.Resources;
import com.blueair.api.client.MbGeoClient;
import com.blueair.api.client.OutdoorClient;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.repository.TrackedLocationRepository;
import com.blueair.outdoor.service.GeocodeService;
import com.blueair.outdoor.service.OutdoorService;
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
import org.kodein.di.bindings.Provider;
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
   d2 = {"Lcom/blueair/outdoor/OutdoorKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorKodeinModule {
   public static final OutdoorKodeinModule INSTANCE = new OutdoorKodeinModule();
   public static final String moduleName = "Outdoor";

   // $FF: synthetic method
   public static MbGeoClient $r8$lambda$FCSErfK0U2ioSRjw2VvRDu1gvRM(NoArgBindingDI var0) {
      return getModule$lambda$5$lambda$1(var0);
   }

   // $FF: synthetic method
   public static OutdoorService $r8$lambda$Fi4i7BzMJUpRxlG3XL6bNcncPkE(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$5$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GUhOE4ZNIMI9DTSmSDkzUD6KbDk(Context var0, DI.Builder var1) {
      return getModule$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static TrackedLocationRepository $r8$lambda$MqpZXFBhaRhTfIIcM4l8AVYY7KE(NoArgBindingDI var0) {
      return getModule$lambda$5$lambda$0(var0);
   }

   // $FF: synthetic method
   public static GeocodeService $r8$lambda$x17KpcNmh_fCDp2tKClwof0brMk(Context var0, NoArgBindingDI var1) {
      return getModule$lambda$5$lambda$4(var0, var1);
   }

   private OutdoorKodeinModule() {
   }

   private static final Unit getModule$lambda$5(Context var0, DI.Builder var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$Module");
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var7 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var3, TrackedLocationRepository.class)), (Object)null, (Boolean)null);
      DI.BindBuilder.WithScope var13 = (DI.BindBuilder.WithScope)var1;
      OutdoorKodeinModule$$ExternalSyntheticLambda0 var4 = new OutdoorKodeinModule$$ExternalSyntheticLambda0();
      Scope var8 = var13.getScope();
      TypeToken var5 = var13.getContextType();
      boolean var2 = var13.getExplicitContext();
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var7.with((DIBinding)(new Singleton(var8, var5, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, TrackedLocationRepository.class)), (RefMaker)null, true, var4)));
      JVMTypeToken var15 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var15, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var21 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var15, MbGeoClient.class)), (Object)null, (Boolean)null);
      DI.BindBuilder var24 = (DI.BindBuilder)var1;
      OutdoorKodeinModule$$ExternalSyntheticLambda1 var16 = new OutdoorKodeinModule$$ExternalSyntheticLambda1();
      TypeToken var25 = var24.getContextType();
      JVMTypeToken var27 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var27, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var21.with((DIBinding)(new Provider(var25, (TypeToken)(new GenericJVMTypeTokenDelegate(var27, MbGeoClient.class)), var16)));
      JVMTypeToken var17 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var17, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var28 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var17, OutdoorService.class)), (Object)null, (Boolean)null);
      OutdoorKodeinModule$$ExternalSyntheticLambda2 var29 = new OutdoorKodeinModule$$ExternalSyntheticLambda2(var0);
      Scope var22 = var13.getScope();
      var25 = var13.getContextType();
      var2 = var13.getExplicitContext();
      var17 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var17, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var28.with((DIBinding)(new Singleton(var22, var25, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var17, OutdoorService.class)), (RefMaker)null, true, var29)));
      var17 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var17, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      DI.Builder.TypeBinder var10 = var1.Bind((TypeToken)(new GenericJVMTypeTokenDelegate(var17, GeocodeService.class)), (Object)null, (Boolean)null);
      OutdoorKodeinModule$$ExternalSyntheticLambda3 var9 = new OutdoorKodeinModule$$ExternalSyntheticLambda3(var0);
      var22 = var13.getScope();
      TypeToken var20 = var13.getContextType();
      var2 = var13.getExplicitContext();
      JVMTypeToken var14 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      var10.with((DIBinding)(new Singleton(var22, var20, var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var14, GeocodeService.class)), (RefMaker)null, true, var9)));
      return Unit.INSTANCE;
   }

   private static final TrackedLocationRepository getModule$lambda$5$lambda$0(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$singleton");
      DirectDI var2 = ((DirectDIAware)var0).getDirectDI();
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new TrackedLocationRepository((BlueairDatabase)var2.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var1, BlueairDatabase.class)), (Object)null));
   }

   private static final MbGeoClient getModule$lambda$5$lambda$1(NoArgBindingDI var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$provider");
      return new MbGeoClient();
   }

   private static final OutdoorService getModule$lambda$5$lambda$3(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDIAware var2 = (DirectDIAware)var1;
      DirectDI var4 = var2.getDirectDI();
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      TrackedLocationRepository var9 = (TrackedLocationRepository)var4.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var3, TrackedLocationRepository.class)), (Object)null);
      DirectDI var5 = var2.getDirectDI();
      JVMTypeToken var10 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      Resources var6 = (Resources)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var10, Resources.class)), (Object)null);
      var5 = var2.getDirectDI();
      var10 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      OutdoorClient var12 = new OutdoorClient(var6, (AuthService)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var10, AuthService.class)), (Object)null), (Interceptor)null, 4, (DefaultConstructorMarker)null);
      var5 = var2.getDirectDI();
      JVMTypeToken var16 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var16, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      GeocodeService var15 = (GeocodeService)var5.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var16, GeocodeService.class)), (Object)null);
      DirectDI var8 = var2.getDirectDI();
      var16 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var16, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      OutdoorService var7 = new OutdoorService(var0, var9, var12, var15, (AuthService)var8.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var16, AuthService.class)), (Object)null));
      LogOutService.Companion.registerLogOutable(var1, var7);
      return var7;
   }

   private static final GeocodeService getModule$lambda$5$lambda$4(Context var0, NoArgBindingDI var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$singleton");
      DirectDIAware var5 = (DirectDIAware)var1;
      DirectDI var3 = var5.getDirectDI();
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      MbGeoClient var7 = (MbGeoClient)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var2, MbGeoClient.class)), (Object)null);
      var3 = var5.getDirectDI();
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LocationService var9 = (LocationService)var3.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, LocationService.class)), (Object)null);
      DirectDI var6 = var5.getDirectDI();
      var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      return new GeocodeService(var0, var7, var9, (LocationNamePlaceholderProvider)var6.Instance((TypeToken)(new GenericJVMTypeTokenDelegate(var4, LocationNamePlaceholderProvider.class)), (Object)null));
   }

   public final DI.Module getModule(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      return new DI.Module("Outdoor", false, (String)null, new OutdoorKodeinModule$$ExternalSyntheticLambda4(var1), 6, (DefaultConstructorMarker)null);
   }
}
