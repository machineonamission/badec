package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build.VERSION;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010H\u001a\u00020BJ\b\u0010I\u001a\u00020BH\u0002J\u0006\u0010J\u001a\u00020BJ\u0006\u0010K\u001a\u00020BJ$\u0010L\u001a\u00020B2\u0006\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020B0NJ\u0010\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020BH\u0002J\u0016\u0010S\u001a\u00020B2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0UH\u0002J\u000e\u0010V\u001a\u00020B2\u0006\u0010W\u001a\u00020XJ\u000e\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020[R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR*\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010(\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001a\u0010+\u001a\u00020,X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00107\u001a\u0004\u0018\u0001062\b\u0010 \u001a\u0004\u0018\u000106@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020B0=8F¢\u0006\u0006\u001a\u0004\bC\u0010?R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020B0=8F¢\u0006\u0006\u001a\u0004\bF\u0010?R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020B0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/CreateUpdateWelcomeHomeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "geocoder", "Landroid/location/Geocoder;", "car", "Landroidx/lifecycle/MutableLiveData;", "", "getCar", "()Landroidx/lifecycle/MutableLiveData;", "bicycle", "getBicycle", "walk", "getWalk", "commute", "getCommute", "welcomeHomeExist", "getWelcomeHomeExist", "gotAddress", "getGotAddress", "address", "", "getAddress", "shortAddress", "getShortAddress", "city", "getCity", "saveEnabled", "getSaveEnabled", "value", "", "lat", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng", "setLng", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "getDevice", "()Lcom/blueair/core/model/HasWelcomeHome;", "setDevice", "(Lcom/blueair/core/model/HasWelcomeHome;)V", "useShortAddress", "getUseShortAddress", "()Z", "setUseShortAddress", "(Z)V", "Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "selectedRadius", "getSelectedRadius", "()Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "setSelectedRadius", "(Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;)V", "loading", "Landroidx/lifecycle/LiveData;", "getLoading", "()Landroidx/lifecycle/LiveData;", "_loading", "failure", "", "getFailure", "_failure", "success", "getSuccess", "_success", "loadHomeLocation", "validateSettings", "saveHomeLocation", "deleteWelcomeHome", "setAddressFromLatLng", "onAddressFetch", "Lkotlin/Function0;", "fetchAddress", "addr", "Landroid/location/Address;", "fetchCity", "extractCity", "addressList", "", "setCustomPlace", "place", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "setTrackedLocation", "location", "Lcom/blueair/core/model/TrackedLocation;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CreateUpdateWelcomeHomeViewModel extends BaseViewModel {
   private final MutableLiveData _failure;
   private final MutableLiveData _loading;
   private final MutableLiveData _success;
   private final MutableLiveData address;
   private final MutableLiveData bicycle;
   private final MutableLiveData car;
   private final MutableLiveData city;
   private final MutableLiveData commute;
   public HasWelcomeHome device;
   private final Geocoder geocoder;
   private final MutableLiveData gotAddress;
   private Double lat;
   private Double lng;
   private final MutableLiveData saveEnabled;
   private WelcomeHomeLocation.WelcomeHomeRadius selectedRadius;
   private final MutableLiveData shortAddress;
   private boolean useShortAddress;
   private final MutableLiveData walk;
   private final MutableLiveData welcomeHomeExist;

   // $FF: synthetic method
   public static void $r8$lambda$WDCfzqWFfdnf_CdrT2Ahx3tEkdE(CreateUpdateWelcomeHomeViewModel var0, double var1, double var3, Function0 var5, List var6) {
      setAddressFromLatLng$lambda$3(var0, var1, var3, var5, var6);
   }

   // $FF: synthetic method
   public static void $r8$lambda$aM_bLiA_Zna7ipUT_Q6wBa1_XRg/* $FF was: $r8$lambda$aM-bLiA_Zna7ipUT_Q6wBa1_XRg*/(CreateUpdateWelcomeHomeViewModel var0, List var1) {
      fetchCity$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$dGduX0gpO9G8H3WO_Krey8LhiUc(CreateUpdateWelcomeHomeViewModel var0, String var1) {
      return address$lambda$1$lambda$0(var0, var1);
   }

   public CreateUpdateWelcomeHomeViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.geocoder = new Geocoder((Context)var1);
      this.car = new MutableLiveData();
      this.bicycle = new MutableLiveData();
      this.walk = new MutableLiveData();
      this.commute = new MutableLiveData();
      this.welcomeHomeExist = new MutableLiveData();
      Boolean var2 = false;
      this.gotAddress = new MutableLiveData(var2);
      MutableLiveData var3 = new MutableLiveData();
      var3.observeForever(new Observer(new CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda1(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.address = var3;
      this.shortAddress = new MutableLiveData();
      this.city = new MutableLiveData();
      this.saveEnabled = new MutableLiveData(var2);
      this._loading = new MutableLiveData();
      this._failure = new MutableLiveData();
      this._success = new MutableLiveData();
   }

   private static final Unit address$lambda$1$lambda$0(CreateUpdateWelcomeHomeViewModel var0, String var1) {
      var0.validateSettings();
      MutableLiveData var3 = var0.gotAddress;
      Intrinsics.checkNotNull(var1);
      boolean var2;
      if (((CharSequence)var1).length() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var3.setValue(var2);
      return Unit.INSTANCE;
   }

   private final void extractCity(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         String var3 = ((Address)var2.next()).getLocality();
         if (var3 != null && ((CharSequence)var3).length() > 0) {
            this.city.postValue(var3);
            return;
         }
      }

      this.city.postValue("");
   }

   private final void fetchAddress(Address var1) {
      String var6 = var1.getAddressLine(0);
      this.address.postValue(var6);
      Intrinsics.checkNotNull(var6);
      CharSequence var3 = (CharSequence)var6;
      boolean var2 = StringsKt.contains$default(var3, (CharSequence)",", false, 2, (Object)null);
      String var4 = "";
      if (var2) {
         this.shortAddress.postValue(CollectionsKt.firstOrNull(StringsKt.split$default(var3, new String[]{","}, false, 0, 6, (Object)null)));
      } else {
         StringBuilder var7 = new StringBuilder();
         String var5 = var1.getThoroughfare();
         String var10 = var5;
         if (var5 == null) {
            var10 = "";
         }

         var7.append(var10);
         var5 = var1.getSubThoroughfare();
         var10 = var5;
         if (var5 == null) {
            var10 = "";
         }

         var7.append(var10);
         var10 = var7.toString();
         if (((CharSequence)var10).length() > 0) {
            this.shortAddress.postValue(var10);
         } else {
            this.shortAddress.postValue(var6);
         }
      }

      MutableLiveData var13 = this.city;
      String var8 = var1.getLocality();
      if (var8 == null) {
         var8 = var4;
      }

      var13.postValue(var8);
      CharSequence var9 = (CharSequence)this.city.getValue();
      if (var9 == null || var9.length() == 0) {
         this.fetchCity();
      }
   }

   private final void fetchCity() {
      Double var5 = this.lat;
      if (var5 != null) {
         double var1 = var5;
         var5 = this.lng;
         if (var5 != null) {
            double var3 = var5;
            if (VERSION.SDK_INT >= 33) {
               BlueairApp$$ExternalSyntheticApiModelOutline0.m(this.geocoder, var1, var3, 10, new CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda3(this));
               return;
            }

            BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, var3, (Continuation)null) {
               final double $curLat;
               final double $curLng;
               int label;
               final CreateUpdateWelcomeHomeViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$curLat = var2;
                  this.$curLng = var4;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$curLat, this.$curLng, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     List var2 = this.this$0.geocoder.getFromLocation(this.$curLat, this.$curLng, 10);
                     if (var2 != null) {
                        this.this$0.extractCity(var2);
                     }

                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            }, 3, (Object)null);
         }
      }

   }

   private static final void fetchCity$lambda$4(CreateUpdateWelcomeHomeViewModel var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "addressList");
      var0.extractCity(var1);
   }

   private static final void setAddressFromLatLng$lambda$3(CreateUpdateWelcomeHomeViewModel var0, double var1, double var3, Function0 var5, List var6) {
      Intrinsics.checkNotNullParameter(var6, "addressList");
      Address var7 = (Address)CollectionsKt.firstOrNull(var6);
      if (var7 != null) {
         var0.setLat(var1);
         var0.setLng(var3);
         var0.fetchAddress(var7);
         var5.invoke();
      }

   }

   private final void validateSettings() {
      MutableLiveData var2 = this.saveEnabled;
      boolean var1;
      if (this.lat != null && this.lng != null && this.selectedRadius != null && this.address.getValue() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.postValue(var1);
   }

   public final void deleteWelcomeHome() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final CreateUpdateWelcomeHomeViewModel this$0;

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
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var5 = this.this$0.getDeviceManager();
               String var6 = this.this$0.getDevice().getUid();
               Continuation var3 = (Continuation)this;
               this.label = 1;
               Object var8 = var5.deleteWelcomeHome(var6, var3);
               var1 = var8;
               if (var8 == var4) {
                  return var4;
               }
            }

            CreateUpdateWelcomeHomeViewModel var9 = this.this$0;
            ApiResult var7 = (ApiResult)var1;
            var9._loading.setValue(Boxing.boxBoolean(false));
            if (var7.isSuccess()) {
               var9._success.setValue(Unit.INSTANCE);
            } else {
               var9._failure.setValue(Unit.INSTANCE);
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final MutableLiveData getAddress() {
      return this.address;
   }

   public final MutableLiveData getBicycle() {
      return this.bicycle;
   }

   public final MutableLiveData getCar() {
      return this.car;
   }

   public final MutableLiveData getCity() {
      return this.city;
   }

   public final MutableLiveData getCommute() {
      return this.commute;
   }

   public final HasWelcomeHome getDevice() {
      HasWelcomeHome var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public final LiveData getFailure() {
      return (LiveData)this._failure;
   }

   public final MutableLiveData getGotAddress() {
      return this.gotAddress;
   }

   public final Double getLat() {
      return this.lat;
   }

   public final Double getLng() {
      return this.lng;
   }

   public final LiveData getLoading() {
      return (LiveData)this._loading;
   }

   public final MutableLiveData getSaveEnabled() {
      return this.saveEnabled;
   }

   public final WelcomeHomeLocation.WelcomeHomeRadius getSelectedRadius() {
      return this.selectedRadius;
   }

   public final MutableLiveData getShortAddress() {
      return this.shortAddress;
   }

   public final LiveData getSuccess() {
      return (LiveData)this._success;
   }

   public final boolean getUseShortAddress() {
      return this.useShortAddress;
   }

   public final MutableLiveData getWalk() {
      return this.walk;
   }

   public final MutableLiveData getWelcomeHomeExist() {
      return this.welcomeHomeExist;
   }

   public final void loadHomeLocation() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         Object L$0;
         int label;
         final CreateUpdateWelcomeHomeViewModel this$0;

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
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               WelcomeHomeLocation var10 = (WelcomeHomeLocation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Iterable var6 = (Iterable)this.this$0.getDeviceManager().getDevices();
               CreateUpdateWelcomeHomeViewModel var4 = this.this$0;
               Iterator var5 = var6.iterator();

               do {
                  if (!var5.hasNext()) {
                     var7 = null;
                     break;
                  }

                  var7 = var5.next();
               } while(!Intrinsics.areEqual(((Device)var7).getUid(), var4.getDevice().getUid()));

               HasWelcomeHome var8;
               if (var7 instanceof HasWelcomeHome) {
                  var8 = (HasWelcomeHome)var7;
               } else {
                  var8 = null;
               }

               if (var8 != null) {
                  WelcomeHomeLocation var9 = var8.getWelcomeHome();
                  if (var9 != null) {
                     CreateUpdateWelcomeHomeViewModel var12 = this.this$0;
                     CoroutineContext var11 = (CoroutineContext)Dispatchers.getMain();
                     Function2 var13 = new Function2(var12, var9, (Continuation)null) {
                        final WelcomeHomeLocation $it;
                        int label;
                        final CreateUpdateWelcomeHomeViewModel this$0;

                        {
                           this.this$0 = var1;
                           this.$it = var2;
                        }

                        public final Continuation create(Object var1, Continuation var2) {
                           return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var2));
                        }

                        public final Object invoke(CoroutineScope var1, Continuation var2) {
                           return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           if (this.label == 0) {
                              ResultKt.throwOnFailure(var1);
                              this.this$0.setLat(Boxing.boxDouble(this.$it.getLat()));
                              this.this$0.setLng(Boxing.boxDouble(this.$it.getLng()));
                              this.this$0.setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.Companion.fromValue(Boxing.boxFloat((float)this.$it.getRadius())));
                              this.this$0.getAddress().setValue(this.$it.getTextValue());
                              this.this$0.getShortAddress().setValue(this.$it.getTextValue());
                              this.this$0.getWelcomeHomeExist().postValue(Boxing.boxBoolean(true));
                              this.this$0.fetchCity();
                              return Unit.INSTANCE;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        }
                     };
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var9);
                     this.I$0 = 0;
                     this.label = 1;
                     if (BuildersKt.withContext(var11, var13, this) == var3) {
                        return var3;
                     }
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void saveHomeLocation() {
      Object var1 = this.saveEnabled.getValue();
      Boolean var2 = true;
      if (Intrinsics.areEqual(var1, var2)) {
         this._loading.setValue(var2);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final CreateUpdateWelcomeHomeViewModel this$0;

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
               Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var6 = this.label;
               if (var6 != 0) {
                  if (var6 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  DeviceManager var7 = this.this$0.getDeviceManager();
                  Device var9 = this.this$0.getDevice();
                  Double var11 = this.this$0.getLat();
                  Intrinsics.checkNotNull(var11);
                  double var4 = var11;
                  var11 = this.this$0.getLng();
                  Intrinsics.checkNotNull(var11);
                  double var2 = var11;
                  WelcomeHomeLocation.WelcomeHomeRadius var13 = this.this$0.getSelectedRadius();
                  Intrinsics.checkNotNull(var13);
                  var6 = (int)var13.getValue();
                  MutableLiveData var14;
                  if (this.this$0.getUseShortAddress()) {
                     var14 = this.this$0.getShortAddress();
                  } else {
                     var14 = this.this$0.getAddress();
                  }

                  Object var15 = var14.getValue();
                  Intrinsics.checkNotNull(var15);
                  WelcomeHomeLocation var16 = new WelcomeHomeLocation(var4, var2, var6, (String)var15, true);
                  Continuation var10 = (Continuation)this;
                  this.label = 1;
                  Object var19 = var7.addWelcomeHomeLocation(var9, var16, var10);
                  var1 = var19;
                  if (var19 == var8) {
                     return var8;
                  }
               }

               CreateUpdateWelcomeHomeViewModel var20 = this.this$0;
               ApiResult var17 = (ApiResult)var1;
               var20._loading.setValue(Boxing.boxBoolean(false));
               if (var17.isSuccess()) {
                  var20._success.setValue(Unit.INSTANCE);
               } else {
                  var20._failure.setValue(Unit.INSTANCE);
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

   }

   public final void setAddressFromLatLng(double var1, double var3, Function0 var5) {
      Intrinsics.checkNotNullParameter(var5, "onAddressFetch");
      if (VERSION.SDK_INT >= 33) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(this.geocoder, var1, var3, 1, new CreateUpdateWelcomeHomeViewModel$$ExternalSyntheticLambda2(this, var1, var3, var5));
      } else {
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, var3, var5, (Continuation)null) {
            final double $lat;
            final double $lng;
            final Function0 $onAddressFetch;
            int I$0;
            Object L$0;
            int label;
            final CreateUpdateWelcomeHomeViewModel this$0;

            {
               this.this$0 = var1;
               this.$lat = var2;
               this.$lng = var4;
               this.$onAddressFetch = var6;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$lat, this.$lng, this.$onAddressFetch, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var6 = this.label;
               if (var6 != 0) {
                  if (var6 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  Address var12 = (Address)this.L$0;
                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  List var10 = this.this$0.geocoder.getFromLocation(this.$lat, this.$lng, 1);
                  if (var10 != null) {
                     Address var11 = (Address)CollectionsKt.firstOrNull(var10);
                     if (var11 != null) {
                        CreateUpdateWelcomeHomeViewModel var9 = this.this$0;
                        double var2 = this.$lat;
                        double var4 = this.$lng;
                        Function0 var8 = this.$onAddressFetch;
                        var9.setLat(Boxing.boxDouble(var2));
                        var9.setLng(Boxing.boxDouble(var4));
                        var9.fetchAddress(var11);
                        CoroutineContext var14 = (CoroutineContext)Dispatchers.getMain();
                        Function2 var13 = new Function2(var8, (Continuation)null) {
                           final Function0 $onAddressFetch;
                           int label;

                           {
                              this.$onAddressFetch = var1;
                           }

                           public final Continuation create(Object var1, Continuation var2) {
                              return (Continuation)(new <anonymous constructor>(this.$onAddressFetch, var2));
                           }

                           public final Object invoke(CoroutineScope var1, Continuation var2) {
                              return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                           }

                           public final Object invokeSuspend(Object var1) {
                              IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              if (this.label == 0) {
                                 ResultKt.throwOnFailure(var1);
                                 this.$onAddressFetch.invoke();
                                 return Unit.INSTANCE;
                              } else {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }
                           }
                        };
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var11);
                        this.I$0 = 0;
                        this.label = 1;
                        if (BuildersKt.withContext(var14, var13, this) == var7) {
                           return var7;
                        }
                     }
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }
   }

   public final void setCustomPlace(CustomPlace var1) {
      Intrinsics.checkNotNullParameter(var1, "place");
      MutableLiveData var5 = this.address;
      String var4 = var1.getAddress();
      String var3 = "";
      String var2 = var4;
      if (var4 == null) {
         var2 = "";
      }

      var5.setValue(var2);
      MutableLiveData var7 = this.shortAddress;
      var2 = var1.getShortAddress();
      if (var2 == null) {
         var2 = var3;
      }

      var7.setValue(var2);
      this.setLat(var1.getLat());
      this.setLng(var1.getLng());
      this.fetchCity();
   }

   public final void setDevice(HasWelcomeHome var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final void setLat(Double var1) {
      this.lat = var1;
      this.validateSettings();
   }

   public final void setLng(Double var1) {
      this.lng = var1;
      this.validateSettings();
   }

   public final void setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius var1) {
      this.selectedRadius = var1;
      int var2;
      if (var1 == null) {
         var2 = -1;
      } else {
         var2 = CreateUpdateWelcomeHomeViewModel.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      }

      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               if (var2 == 4) {
                  this.car.setValue(false);
                  this.bicycle.setValue(false);
                  this.walk.setValue(false);
                  this.commute.setValue(true);
               }
            } else {
               this.car.setValue(false);
               this.bicycle.setValue(false);
               this.walk.setValue(true);
               this.commute.setValue(false);
            }
         } else {
            this.car.setValue(false);
            this.bicycle.setValue(true);
            this.walk.setValue(false);
            this.commute.setValue(false);
         }
      } else {
         this.car.setValue(true);
         this.bicycle.setValue(false);
         this.walk.setValue(false);
         this.commute.setValue(false);
      }

      this.validateSettings();
   }

   public final void setTrackedLocation(TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "location");
      MutableLiveData var2 = this.address;
      StringBuilder var3 = new StringBuilder();
      var3.append(var1.getLocationName());
      var3.append(". ");
      var3.append(var1.getCityName());
      var3.append(". ");
      var3.append(var1.getCountryName());
      var2.setValue(var3.toString());
      this.shortAddress.setValue(String.valueOf(var1.getLocationName()));
      this.setLat(var1.getLat());
      this.setLng(var1.getLon());
      MutableLiveData var6 = this.city;
      String var5 = var1.getCityName();
      String var4 = var5;
      if (var5 == null) {
         var4 = "";
      }

      var6.setValue(var4);
   }

   public final void setUseShortAddress(boolean var1) {
      this.useShortAddress = var1;
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
         int[] var0 = new int[WelcomeHomeLocation.WelcomeHomeRadius.values().length];

         try {
            var0[WelcomeHomeLocation.WelcomeHomeRadius.CAR.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[WelcomeHomeLocation.WelcomeHomeRadius.BICYCLE.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[WelcomeHomeLocation.WelcomeHomeRadius.WALK.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[WelcomeHomeLocation.WelcomeHomeRadius.COMMUTE.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
