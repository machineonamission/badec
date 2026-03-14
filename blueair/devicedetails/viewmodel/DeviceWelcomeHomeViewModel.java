package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.util.DeviceWelcomeHomeProvider;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0#2\u0006\u0010$\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010!J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020\u0015J\b\u0010/\u001a\u00020\u001cH\u0016J\b\u00100\u001a\u00020\u0015H\u0016J\b\u00101\u001a\u00020\u0015H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "getWelcomeHomeService", "()Lcom/blueair/devicemanager/WelcomeHomeService;", "welcomeHomeService$delegate", "Lkotlin/Lazy;", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "getDevice", "()Lcom/blueair/core/model/HasWelcomeHome;", "setDevice", "(Lcom/blueair/core/model/HasWelcomeHome;)V", "welcomeHomeExist", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getWelcomeHomeExist", "()Landroidx/lifecycle/MutableLiveData;", "welcomeHomeEnabled", "getWelcomeHomeEnabled", "address", "", "getAddress", "radius", "getRadius", "welcomeHomeLocation", "Lcom/blueair/core/model/WelcomeHomeLocation;", "getLiveDeviceWelcomeHome", "Landroidx/lifecycle/LiveData;", "deviceId", "loadHomeLocation", "", "whLocation", "setWelcomeHomeEnabled", "enabled", "setAddHomeInstructionShowed", "isAddHomeInstructionsShowed", "homeAddress", "getHomeAddress", "()Ljava/lang/String;", "fetchRadius", "isEnabled", "isHomeLocationExist", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceWelcomeHomeViewModel extends BaseViewModel implements DeviceWelcomeHomeProvider {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceWelcomeHomeViewModel.class, "welcomeHomeService", "getWelcomeHomeService()Lcom/blueair/devicemanager/WelcomeHomeService;", 0)))};
   private final MutableLiveData address;
   public HasWelcomeHome device;
   private final MutableLiveData radius;
   private final MutableLiveData welcomeHomeEnabled;
   private final MutableLiveData welcomeHomeExist;
   private WelcomeHomeLocation welcomeHomeLocation;
   private final Lazy welcomeHomeService$delegate;

   // $FF: synthetic method
   public static boolean $r8$lambda$pP9xvApPb7pRmv2WSuVcTPbeIdA(WelcomeHomeLocation var0, WelcomeHomeLocation var1) {
      return getLiveDeviceWelcomeHome$lambda$1(var0, var1);
   }

   public DeviceWelcomeHomeViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var4, WelcomeHomeService.class)), (Object)null);
      KProperty[] var6 = $$delegatedProperties;
      Boolean var5 = false;
      this.welcomeHomeService$delegate = var3.provideDelegate(this, var6[0]);
      this.welcomeHomeExist = new MutableLiveData(var5);
      this.welcomeHomeEnabled = new MutableLiveData(var5);
      this.address = new MutableLiveData();
      this.radius = new MutableLiveData();
   }

   private static final boolean getLiveDeviceWelcomeHome$lambda$1(WelcomeHomeLocation var0, WelcomeHomeLocation var1) {
      boolean var2 = Intrinsics.areEqual(var0, var1);
      Object var5 = null;
      if (var2) {
         Boolean var3;
         if (var0 != null) {
            var3 = var0.isEnabled();
         } else {
            var3 = null;
         }

         Boolean var4;
         if (var1 != null) {
            var4 = var1.isEnabled();
         } else {
            var4 = null;
         }

         Intrinsics.areEqual(var3, var4);
      }

      if (Intrinsics.areEqual(var0, var1)) {
         Boolean var6;
         if (var0 != null) {
            var6 = var0.isEnabled();
         } else {
            var6 = null;
         }

         Boolean var7 = (Boolean)var5;
         if (var1 != null) {
            var7 = var1.isEnabled();
         }

         if (Intrinsics.areEqual(var6, var7)) {
            return true;
         }
      }

      return false;
   }

   private final WelcomeHomeService getWelcomeHomeService() {
      return (WelcomeHomeService)this.welcomeHomeService$delegate.getValue();
   }

   public String fetchRadius() {
      String var2 = (String)this.radius.getValue();
      String var1 = var2;
      if (var2 == null) {
         var1 = "";
      }

      return var1;
   }

   public final MutableLiveData getAddress() {
      return this.address;
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

   public String getHomeAddress() {
      String var2 = (String)this.address.getValue();
      String var1 = var2;
      if (var2 == null) {
         var1 = "";
      }

      return var1;
   }

   public final LiveData getLiveDeviceWelcomeHome(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(new Flow(this.getDeviceManager().getFlowHasWelcomeHomeDevice(var1)) {
         final Flow $this_unsafeTransform$inlined;

         public {
            this.$this_unsafeTransform$inlined = var1;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
               final FlowCollector $this_unsafeFlow;

               public {
                  this.$this_unsafeFlow = var1;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label23: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var4 = (<undefinedtype>)var2;
                        if ((var4.label & Integer.MIN_VALUE) != 0) {
                           var4.label += Integer.MIN_VALUE;
                           var11 = var4;
                           break label23;
                        }
                     }

                     var11 = new ContinuationImpl(this, var2) {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var13 = ((<undefinedtype>)var11).result;
                  Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var11).label;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = ((<undefinedtype>)var11).I$0;
                     FlowCollector var7 = (FlowCollector)((<undefinedtype>)var11).L$3;
                     Object var8 = ((<undefinedtype>)var11).L$2;
                     <undefinedtype> var9 = (<undefinedtype>)((<undefinedtype>)var11).L$1;
                     Object var10 = ((<undefinedtype>)var11).L$0;
                     ResultKt.throwOnFailure(var13);
                  } else {
                     ResultKt.throwOnFailure(var13);
                     FlowCollector var14 = this.$this_unsafeFlow;
                     Continuation var6 = (Continuation)var11;
                     WelcomeHomeLocation var15 = ((HasWelcomeHome)var1).getWelcomeHome();
                     ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                     ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                     ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var14);
                     ((<undefinedtype>)var11).I$0 = 0;
                     ((<undefinedtype>)var11).label = 1;
                     if (var14.emit(var15, (Continuation)var11) == var5) {
                        return var5;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, new DeviceWelcomeHomeViewModel$$ExternalSyntheticLambda0()), ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final MutableLiveData getRadius() {
      return this.radius;
   }

   public final MutableLiveData getWelcomeHomeEnabled() {
      return this.welcomeHomeEnabled;
   }

   public final MutableLiveData getWelcomeHomeExist() {
      return this.welcomeHomeExist;
   }

   public final boolean isAddHomeInstructionsShowed() {
      return this.getWelcomeHomeService().getAddHomeInstructionsShowed();
   }

   public boolean isEnabled() {
      if (this.isHomeLocationExist()) {
         Boolean var2 = (Boolean)this.welcomeHomeEnabled.getValue();
         boolean var1;
         if (var2 != null) {
            var1 = var2;
         } else {
            var1 = false;
         }

         if (var1) {
            return true;
         }
      }

      return false;
   }

   public boolean isHomeLocationExist() {
      Boolean var1 = (Boolean)this.welcomeHomeExist.getValue();
      return var1 != null ? var1 : false;
   }

   public final void loadHomeLocation(WelcomeHomeLocation var1) {
      if (var1 != null) {
         this.welcomeHomeExist.setValue(true);
         if (!Intrinsics.areEqual(this.welcomeHomeEnabled.getValue(), var1.isEnabled())) {
            this.welcomeHomeEnabled.setValue(var1.isEnabled());
         }

         this.address.setValue(var1.getTextValue());
         MutableLiveData var3 = this.radius;
         WelcomeHomeLocation.WelcomeHomeRadius var2 = WelcomeHomeLocation.WelcomeHomeRadius.Companion.fromValue((float)var1.getRadius());
         String var4;
         if (var2 != null) {
            var4 = var2.getTextValue();
         } else {
            var4 = null;
         }

         var3.setValue(var4);
      } else {
         DeviceWelcomeHomeViewModel var5 = this;
         this.welcomeHomeExist.setValue(false);
      }

      this.welcomeHomeLocation = var1;
   }

   public final void setAddHomeInstructionShowed() {
      this.getWelcomeHomeService().setAddHomeInstructionsShowed(true);
   }

   public final void setDevice(HasWelcomeHome var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final void setWelcomeHomeEnabled(boolean var1) {
      this.getDeviceManager().setWelcomeHomeEnabled(this.getDevice(), this.welcomeHomeLocation, var1);
   }
}
