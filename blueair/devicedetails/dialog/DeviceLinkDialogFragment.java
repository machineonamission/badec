package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.devicedetails.adapter.LinkedDeviceSelectionAction;
import com.blueair.devicedetails.adapter.LinkedDevicesAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceLinkBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00100\u001a\u00020.H\u0016J\b\u00101\u001a\u00020.H\u0002J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u00066"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceLinkDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/HasLinkingCapability;", "getDevice", "()Lcom/blueair/core/model/HasLinkingCapability;", "setDevice", "(Lcom/blueair/core/model/HasLinkingCapability;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceLinkBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/adapter/LinkedDeviceSelectionAction;", "getDeviceSelectedPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceSelectedPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "onResume", "bindViewModel", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceLinkDialogFragment extends BaseDialogFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceLinkDialogFragment.class, "deviceSelectedPublisher", "getDeviceSelectedPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy adapter$delegate = LazyKt.lazy(new DeviceLinkDialogFragment$$ExternalSyntheticLambda2(this));
   public HasLinkingCapability device;
   private final LazyPublishSubject deviceSelectedPublisher$delegate = new LazyPublishSubject();
   private final String screenName;
   private DialogfragmentDeviceLinkBinding viewDataBinding;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$4ukawLaIaQpcTsE2pSA_1tl2GSw/* $FF was: $r8$lambda$4ukawLaIaQpcTsE2pSA-1tl2GSw*/(DeviceLinkDialogFragment var0, DeviceDetailsState var1) {
      return bindViewModel$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$52bHLlTBULwL2wpXBYdDXd6RuJo(DeviceLinkDialogFragment var0, View var1) {
      onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Agm5VaBQiNm1ZfFSi5K0ojtKvfI(DeviceLinkDialogFragment var0, LinkedDeviceSelectionAction var1) {
      return onResume$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KC_j1hd27xQzKYsgwX3RAdfb1FU/* $FF was: $r8$lambda$KC-j1hd27xQzKYsgwX3RAdfb1FU*/(DeviceLinkDialogFragment var0, View var1) {
      onResume$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$W8whfRtg0WO7eWffwecdJDlc_to(DeviceLinkDialogFragment var0, List var1) {
      return bindViewModel$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static LinkedDevicesAdapter $r8$lambda$vgjyAS26y3t7LBhjOBquIITAnqA(DeviceLinkDialogFragment var0) {
      return adapter_delegate$lambda$0(var0);
   }

   private static final LinkedDevicesAdapter adapter_delegate$lambda$0(DeviceLinkDialogFragment var0) {
      return new LinkedDevicesAdapter(var0.getDeviceSelectedPublisher());
   }

   private final void bindViewModel() {
      LiveData var2 = this.getViewModel().getLiveDevices();
      LifecycleOwner var1 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var1, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var2, var1, new DeviceLinkDialogFragment$$ExternalSyntheticLambda0(this));
      LiveData var3 = this.getViewModel().getDeviceDetailsState();
      LifecycleOwner var4 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var4, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var3, var4, new DeviceLinkDialogFragment$$ExternalSyntheticLambda1(this));
   }

   private static final Unit bindViewModel$lambda$7(DeviceLinkDialogFragment var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      LinkedDevicesAdapter var4 = var0.getAdapter();
      Iterable var2 = (Iterable)var1;
      Collection var5 = (Collection)(new ArrayList());

      for(Object var6 : var2) {
         if (var6 instanceof DeviceAware) {
            var5.add(var6);
         }
      }

      var4.setAwares((List)var5);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$8(DeviceLinkDialogFragment var0, DeviceDetailsState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      var0.getAdapter().setParentDevice(var0.getDevice());
      return Unit.INSTANCE;
   }

   private final LinkedDevicesAdapter getAdapter() {
      return (LinkedDevicesAdapter)this.adapter$delegate.getValue();
   }

   private final PublishSubject getDeviceSelectedPublisher() {
      return this.deviceSelectedPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private static final void onCreateView$lambda$3(DeviceLinkDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final Unit onResume$lambda$4(DeviceLinkDialogFragment var0, LinkedDeviceSelectionAction var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("selected aware : ");
      var3.append(var1.getLinkedDevice());
      var2.d(var3.toString(), new Object[0]);
      var0.getAdapter().setSelectedAware(var1.getLinkedDevice());
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$6(DeviceLinkDialogFragment var0, View var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("parent device  = ");
      DeviceDetailsState var4 = (DeviceDetailsState)var0.getViewModel().getDeviceDetailsState().getValue();
      Device var5;
      if (var4 != null) {
         var5 = var4.getDevice();
      } else {
         var5 = null;
      }

      var2.append(var5);
      var2.append("  & linkedDevice =  ");
      var2.append(var0.getAdapter().getSelectedAware());
      var3.d(var2.toString(), new Object[0]);
      DeviceDetailsState var6 = (DeviceDetailsState)var0.getViewModel().getDeviceDetailsState().getValue();
      if (var6 != null) {
         Device var7 = var6.getDevice();
         if (var7 != null && var7 instanceof HasLinkingCapability) {
            var0.getViewModel().linkDeviceSelected((HasLinkingCapability)var7, var0.getAdapter().getSelectedAware());
         }
      }

      var0.dismiss();
   }

   public final HasLinkingCapability getDevice() {
      HasLinkingCapability var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceDetailsViewModel getViewModel() {
      DeviceDetailsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public Dialog onCreateDialog(Bundle var1) {
      Dialog var3 = new Dialog(this.requireContext());
      FragmentActivity var2 = this.getActivity();
      if (var2 != null) {
         Window var4 = var3.getWindow();
         if (var4 != null) {
            var4.setBackgroundDrawable(ContextCompat.getDrawable((Context)var2, R.drawable.rounded_rectangle_white));
         }
      }

      return var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentDeviceLinkBinding var9 = DialogfragmentDeviceLinkBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var9, "inflate(...)");
      var9.setDeviceDetailsViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      var9.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var9;
      Object var8 = null;
      DialogfragmentDeviceLinkBinding var4 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      DeviceDetailsViewModel var5 = var4.getDeviceDetailsViewModel();
      if (var5 != null) {
         this.setViewModel(var5);
         var9 = this.viewDataBinding;
         DialogfragmentDeviceLinkBinding var6 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.closeBtn.setOnClickListener(new DeviceLinkDialogFragment$$ExternalSyntheticLambda5(this));
         var6 = this.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeviceLinkBinding)var8;
         }

         return var6.getRoot();
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onResume() {
      super.onResume();
      CompositeDisposable var1 = this.getRxSubs();
      Observable var2 = this.getDeviceSelectedPublisher().throttleFirst(100L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var2, "throttleFirst(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new DeviceLinkDialogFragment$$ExternalSyntheticLambda3(this)));
      DialogfragmentDeviceLinkBinding var4 = this.viewDataBinding;
      DialogfragmentDeviceLinkBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var3 = null;
      }

      var3.connectButton.setOnClickListener(new DeviceLinkDialogFragment$$ExternalSyntheticLambda4(this));
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Bundle var4 = this.getArguments();
      Object var8 = null;
      HasLinkingCapability var5;
      if (var4 != null) {
         var5 = (HasLinkingCapability)var4.getParcelable("device");
      } else {
         var5 = null;
      }

      if (var5 != null) {
         this.setDevice(var5);
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("onViewCreated: viewModel = ");
         var6.append(this.getViewModel());
         var6.append(",  device = ");
         var6.append(this.getDevice());
         var3.d(var6.toString(), new Object[0]);
         this.getViewModel().setDeviceId(this.getDevice().getUid());
         DialogfragmentDeviceLinkBinding var7 = this.viewDataBinding;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var7 = (DialogfragmentDeviceLinkBinding)var8;
         }

         var7.productList.setAdapter(this.getAdapter());
         this.bindViewModel();
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(HasLinkingCapability var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceLinkDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceLinkDialogFragment;", "device", "Lcom/blueair/core/model/HasLinkingCapability;", "devicedetails_otherRelease"},
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

      public final DeviceLinkDialogFragment newInstance(HasLinkingCapability var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceLinkDialogFragment var3 = new DeviceLinkDialogFragment();
         Bundle var2 = new Bundle();
         var2.putParcelable("device", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
