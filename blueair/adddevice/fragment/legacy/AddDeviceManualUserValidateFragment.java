package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualUserValidateClassicBinding;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.auth.LocationService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualUserValidateFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateClassicBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateClassicBinding;", "classicBinding$delegate", "otherBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateBinding;", "getOtherBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualUserValidateBinding;", "otherBinding$delegate", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "confirmValidManualNetwork", "onResume", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceManualUserValidateFragment extends AddDeviceBaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceManualUserValidateFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private final Lazy classicBinding$delegate;
   private final Lazy locationService$delegate;
   private final Lazy otherBinding$delegate;
   private ConstraintLayout rootViewForProgress;

   // $FF: synthetic method
   public static Unit $r8$lambda$03pZGyIZzWadmH6pIdIMfdVzW0w(AddDeviceManualUserValidateFragment var0, AddDeviceUtils.NetValidation var1) {
      return confirmValidManualNetwork$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5VxqYWPooT0_vfLYRiI12yKO6yo/* $FF was: $r8$lambda$5VxqYWPooT0-vfLYRiI12yKO6yo*/(Function1 var0, Object var1) {
      confirmValidManualNetwork$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentAddDeviceManualUserValidateClassicBinding $r8$lambda$Ds7Kl_jWsf4yutS_jwWA9QtrYZQ(AddDeviceManualUserValidateFragment var0) {
      return classicBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$DuuJdzLqjG3u_c5o5WJpyaDCer4(boolean var0, AddDeviceManualUserValidateFragment var1, View var2) {
      onCreateView$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KjlKDXuGatCxfkO1u_YysW3X_fU/* $FF was: $r8$lambda$KjlKDXuGatCxfkO1u_YysW3X-fU*/(Function1 var0, Object var1) {
      confirmValidManualNetwork$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static FragmentAddDeviceManualUserValidateBinding $r8$lambda$ZQ3BStHV6XF_QzEP1serlkS1vDE/* $FF was: $r8$lambda$ZQ3BStHV6XF-QzEP1serlkS1vDE*/(AddDeviceManualUserValidateFragment var0) {
      return otherBinding_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ZT8jkkz_FEuHJl8SCh_OP4ujXHM(Throwable var0) {
      return confirmValidManualNetwork$lambda$6(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fEgjvLwLFIedm_YipP6CSU21FS0(AddDeviceManualUserValidateFragment var0, View var1) {
      onCreateView$lambda$3(var0, var1);
   }

   public AddDeviceManualUserValidateFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, LocationService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.classicBinding$delegate = LazyKt.lazy(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda0(this));
      this.otherBinding$delegate = LazyKt.lazy(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda1(this));
   }

   private static final FragmentAddDeviceManualUserValidateClassicBinding classicBinding_delegate$lambda$0(AddDeviceManualUserValidateFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceManualUserValidateClassicBinding)var2;
   }

   private final void confirmValidManualNetwork() {
      CompositeDisposable var2 = this.getAsyncSubs();
      AddDeviceUtils var1 = AddDeviceUtils.INSTANCE;
      FragmentActivity var3 = this.getActivity();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.content.Context");
      var2.add(var1.validateNet((Context)var3, this.getDeviceModelType()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda5(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda4(this)), new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda7(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda6())));
   }

   private static final Unit confirmValidManualNetwork$lambda$4(AddDeviceManualUserValidateFragment var0, AddDeviceUtils.NetValidation var1) {
      Intrinsics.checkNotNullParameter(var1, "netValidation");
      if (var1.getValid()) {
         var0.getAddService().validateManual();
      } else {
         String var4;
         if (var1.getConnectedWifiSSID() == null) {
            var4 = var0.getString(R.string.add_device_wrong_network_3);
         } else if (!Intrinsics.areEqual(var1.getConnectedWifiSSID(), var1.getNotAllowedWiFISSID())) {
            StringCompanionObject var2 = StringCompanionObject.INSTANCE;
            String var5 = var0.getString(R.string.add_device_wrong_network_2);
            Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
            var4 = String.format(var5, Arrays.copyOf(new Object[]{var1.getNotAllowedWiFISSID()}, 1));
            Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
         } else {
            var4 = var0.getString(R.string.offline_error);
         }

         Intrinsics.checkNotNull(var4);
         View var6 = var0.getView();
         if (var0.isAdded() && var6 != null) {
            ViewUtils var7 = ViewUtils.INSTANCE;
            FragmentActivity var3 = var0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(var3, "requireActivity(...)");
            var7.showError((Activity)var3, var4);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void confirmValidManualNetwork$lambda$5(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit confirmValidManualNetwork$lambda$6(Throwable var0) {
      Timber.Forest.e(var0);
      return Unit.INSTANCE;
   }

   private static final void confirmValidManualNetwork$lambda$7(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final FragmentAddDeviceManualUserValidateClassicBinding getClassicBinding() {
      return (FragmentAddDeviceManualUserValidateClassicBinding)this.classicBinding$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final FragmentAddDeviceManualUserValidateBinding getOtherBinding() {
      return (FragmentAddDeviceManualUserValidateBinding)this.otherBinding$delegate.getValue();
   }

   private static final void onCreateView$lambda$2(boolean var0, AddDeviceManualUserValidateFragment var1, View var2) {
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, (Continuation)null) {
         int I$0;
         Object L$0;
         Object L$1;
         int label;
         final AddDeviceManualUserValidateFragment this$0;

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

               DeviceInformationLegacy var7 = (DeviceInformationLegacy)this.L$1;
               var7 = (DeviceInformationLegacy)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceInformationLegacy var4 = this.this$0.getAddService().getState().getDeviceInfo();
               if (var4 != null) {
                  var1 = this.this$0.getDeviceManager();
                  String var5 = var4.getId();
                  this.L$0 = var4;
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var4);
                  this.I$0 = 0;
                  this.label = 1;
                  if (var1.removeAblDeviceRemote(var5, this) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      if (var0) {
         var1.getAddService().restartOnboarding(false);
      } else {
         var1.getAddService().restartManualConfig();
      }
   }

   private static final void onCreateView$lambda$3(AddDeviceManualUserValidateFragment var0, View var1) {
      var0.confirmValidManualNetwork();
   }

   private static final FragmentAddDeviceManualUserValidateBinding otherBinding_delegate$lambda$1(AddDeviceManualUserValidateFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceManualUserValidateBinding)var2;
   }

   public ConstraintLayout getRootView() {
      return this.rootViewForProgress;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      boolean var4;
      if (this.getDeviceModelType() == 3) {
         var4 = true;
      } else {
         var4 = false;
      }

      ViewBinding var6;
      if (var4) {
         FragmentAddDeviceManualUserValidateClassicBinding var5 = FragmentAddDeviceManualUserValidateClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var5);
         var6 = var5;
      } else {
         FragmentAddDeviceManualUserValidateBinding var7 = FragmentAddDeviceManualUserValidateBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var7);
         var6 = var7;
      }

      this.binding = var6;
      Object var19 = null;
      ViewBinding var16 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var16 = null;
      }

      this.rootViewForProgress = (ConstraintLayout)var16.getRoot().findViewById(com.blueair.adddevice.R.id.rootLayout);
      var16 = this.binding;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      View var9 = var6.getRoot().findViewById(com.blueair.adddevice.R.id.buttonNo);
      Button var10;
      if (var9 instanceof Button) {
         var10 = (Button)var9;
      } else {
         var10 = null;
      }

      if (var10 != null) {
         var10.setOnClickListener(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda2(var4, this));
      }

      var16 = this.binding;
      ViewBinding var11 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      View var12 = var11.getRoot().findViewById(com.blueair.adddevice.R.id.buttonYes);
      Button var13;
      if (var12 instanceof Button) {
         var13 = (Button)var12;
      } else {
         var13 = null;
      }

      if (var13 != null) {
         var13.setOnClickListener(new AddDeviceManualUserValidateFragment$$ExternalSyntheticLambda3(this));
      }

      ViewBinding var14 = this.binding;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = (ViewBinding)var19;
      }

      View var15 = var14.getRoot();
      Intrinsics.checkNotNullExpressionValue(var15, "getRoot(...)");
      return var15;
   }

   public void onResume() {
      super.onResume();
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.confirm));
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      int var3 = this.getDeviceModelType();
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 == 3) {
               BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
                  int I$0;
                  int label;
                  final AddDeviceManualUserValidateFragment this$0;

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

                        var2 = this.I$0;
                        ResultKt.throwOnFailure(var1);
                        --var2;
                     } else {
                        ResultKt.throwOnFailure(var1);
                        var2 = 25;
                     }

                     while(var2 > 0) {
                        this.this$0.getClassicBinding().txtCountdown.setText((CharSequence)String.valueOf(var2));
                        Continuation var4 = (Continuation)this;
                        this.I$0 = var2;
                        this.label = 1;
                        if (DelayKt.delay(1000L, var4) == var3) {
                           return var3;
                        }

                        --var2;
                     }

                     this.this$0.getClassicBinding().textAddDeviceSubtitleTwo.setText(R.string.add_device_confirm_subtitle2);
                     TextView var5 = this.this$0.getClassicBinding().txtCountdown;
                     Intrinsics.checkNotNullExpressionValue(var5, "txtCountdown");
                     ViewExtensionsKt.hide((View)var5);
                     Group var6 = this.this$0.getClassicBinding().groupButtons;
                     Intrinsics.checkNotNullExpressionValue(var6, "groupButtons");
                     ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
                     this.this$0.getClassicBinding().bgCountdown.setImageDrawable(ResourcesCompat.getDrawable(this.this$0.getResources(), com.blueair.adddevice.R.drawable.ic_wifi_blue_big, (Resources.Theme)null));
                     return Unit.INSTANCE;
                  }
               }, 3, (Object)null);
            }
         } else {
            this.getOtherBinding().imageAuto.setImageDrawable(this.getResources().getDrawable(com.blueair.adddevice.R.drawable.device_sense_confirmation));
         }
      } else {
         this.getOtherBinding().imageAuto.setImageDrawable(this.getResources().getDrawable(com.blueair.adddevice.R.drawable.device_aware_step1));
         this.getOtherBinding().textAddDeviceSubtitle.setText(R.string.aware_manual);
         this.getOtherBinding().textAddDeviceSubtitleThree.setText(R.string.isconnected);
      }

      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         int label;
         final AddDeviceManualUserValidateFragment this$0;

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
            AddDeviceManualUserValidateFragment var13;
            label55: {
               DeviceInformationLegacy var5;
               Function1 var7;
               Object var8;
               Object var9;
               int var12;
               Function1 var17;
               DeviceInformationLegacy var19;
               label56: {
                  var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  var12 = this.label;
                  DeviceInformationLegacy var3;
                  AddDeviceManualUserValidateFragment var4;
                  Function1 var6;
                  if (var12 != 0) {
                     if (var12 != 1) {
                        if (var12 != 2) {
                           if (var12 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           Function1 var14 = (Function1)this.L$4;
                           var14 = (Function1)this.L$3;
                           DeviceInformationLegacy var16 = (DeviceInformationLegacy)this.L$2;
                           var13 = (AddDeviceManualUserValidateFragment)this.L$1;
                           DeviceInformationLegacy var18 = (DeviceInformationLegacy)this.L$0;
                           ResultKt.throwOnFailure(var1);
                           break label55;
                        }

                        var12 = this.I$0;
                        var7 = (Function1)this.L$4;
                        var17 = (Function1)this.L$3;
                        var5 = (DeviceInformationLegacy)this.L$2;
                        var13 = (AddDeviceManualUserValidateFragment)this.L$1;
                        var19 = (DeviceInformationLegacy)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        var8 = var1;
                        break label56;
                     }

                     var12 = this.I$0;
                     var7 = (Function1)this.L$4;
                     var6 = (Function1)this.L$3;
                     var5 = (DeviceInformationLegacy)this.L$2;
                     var4 = (AddDeviceManualUserValidateFragment)this.L$1;
                     var3 = (DeviceInformationLegacy)this.L$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     var5 = this.this$0.getAddService().getState().getDeviceInfo();
                     if (var5 == null) {
                        return Unit.INSTANCE;
                     }

                     var4 = this.this$0;
                     var6 = new Function1(var4, var5, (Continuation)null) {
                        final DeviceInformationLegacy $it;
                        int label;
                        final AddDeviceManualUserValidateFragment this$0;

                        {
                           this.this$0 = var1;
                           this.$it = var2;
                        }

                        public final Continuation create(Continuation var1) {
                           return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var1));
                        }

                        public final Object invoke(Continuation var1) {
                           return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           if (var2 != 0) {
                              if (var2 == 1) {
                                 ResultKt.throwOnFailure(var1);
                                 return var1;
                              } else {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }
                           } else {
                              ResultKt.throwOnFailure(var1);
                              AddDeviceService var5 = this.this$0.getAddService();
                              String var4 = this.$it.getId();
                              Continuation var6 = (Continuation)this;
                              this.label = 1;
                              Object var7 = var5.fetchDeviceStatus(var4, var6);
                              return var7 == var3 ? var3 : var7;
                           }
                        }
                     };
                     var7 = new Function1(var4, var5, (Continuation)null) {
                        final DeviceInformationLegacy $it;
                        Object L$0;
                        int label;
                        final AddDeviceManualUserValidateFragment this$0;

                        {
                           this.this$0 = var1;
                           this.$it = var2;
                        }

                        public final Continuation create(Continuation var1) {
                           return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var1));
                        }

                        public final Object invoke(Continuation var1) {
                           return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           Object var4;
                           DeviceManager var8;
                           if (var2 != 0) {
                              if (var2 != 1) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              var8 = (DeviceManager)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              var4 = var1;
                           } else {
                              ResultKt.throwOnFailure(var1);
                              var1 = this.this$0.getDeviceManager();
                              DeviceManager var5 = this.this$0.getDeviceManager();
                              String var6 = this.$it.getId();
                              Continuation var9 = (Continuation)this;
                              this.L$0 = var1;
                              this.label = 1;
                              var4 = var5.isMigrationOtaRunning(var6, var9);
                              if (var4 == var3) {
                                 return var3;
                              }

                              var8 = var1;
                           }

                           return Boxing.boxBoolean(var8.isProbablyInMigrationOta((ApiResult)var4));
                        }
                     };
                     if (var4.getLocationService().isInChina()) {
                        return Unit.INSTANCE;
                     }

                     this.L$0 = var5;
                     this.L$1 = var4;
                     this.L$2 = var5;
                     this.L$3 = SpillingKt.nullOutSpilledVariable(var6);
                     this.L$4 = var7;
                     this.I$0 = 0;
                     this.label = 1;
                     var1 = (DeviceManager)var6.invoke(this);
                     if (var1 == var9) {
                        return var9;
                     }

                     var3 = var5;
                     var12 = 0;
                  }

                  if ((Boolean)var1) {
                     return Unit.INSTANCE;
                  }

                  this.L$0 = var3;
                  this.L$1 = var4;
                  this.L$2 = var5;
                  this.L$3 = SpillingKt.nullOutSpilledVariable(var6);
                  this.L$4 = SpillingKt.nullOutSpilledVariable(var7);
                  this.I$0 = var12;
                  this.label = 2;
                  var8 = var7.invoke(this);
                  if (var8 == var9) {
                     return var9;
                  }

                  Function1 var10 = var6;
                  var19 = var3;
                  var13 = var4;
                  var17 = var10;
               }

               if ((Boolean)var8) {
                  return Unit.INSTANCE;
               }

               Timber.Forest.i("Manual onboarding: device status is not online!", new Object[0]);
               var1 = var13.getDeviceManager();
               String var20 = var5.getId();
               this.L$0 = var19;
               this.L$1 = var13;
               this.L$2 = SpillingKt.nullOutSpilledVariable(var5);
               this.L$3 = SpillingKt.nullOutSpilledVariable(var17);
               this.L$4 = SpillingKt.nullOutSpilledVariable(var7);
               this.I$0 = var12;
               this.label = 3;
               if (var1.removeAblDeviceRemote(var20, this) == var9) {
                  return var9;
               }
            }

            AddDeviceService.restartOnboarding$default(var13.getAddService(), false, 1, (Object)null);
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualUserValidateFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualUserValidateFragment;", "deviceModelType", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final AddDeviceManualUserValidateFragment newInstance(int var1) {
         AddDeviceManualUserValidateFragment var2 = new AddDeviceManualUserValidateFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
