package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceControlsAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceMessagesBinding;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceControlGroup;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
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
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R%\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceMessagesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceMessagesBinding;", "controlActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "getControlActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "controlActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "dpToPx1", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "handlePadding", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceMessagesFragment extends BaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceMessagesFragment.class, "controlActionPublisher", "getControlActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy adapter$delegate = LazyKt.lazy(new DeviceMessagesFragment$$ExternalSyntheticLambda1(this));
   private FragmentDeviceMessagesBinding binding;
   private final LazyPublishSubject controlActionPublisher$delegate = new LazyPublishSubject();
   private float dpToPx1;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$C5xdw59U2notuUNTeDM57wVf3i4(DeviceMessagesFragment var0, Device var1) {
      return onCreateView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceControlsAdapter $r8$lambda$W74YtHV7PVTVfkx4vEW0Lxe6Kxw(DeviceMessagesFragment var0) {
      return adapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$b_rySPfI4SN2APMzdtuBD_8iyL8/* $FF was: $r8$lambda$b-rySPfI4SN2APMzdtuBD_8iyL8*/(DeviceMessagesFragment var0, AttributeAction var1) {
      return onResume$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pF1NSYlNASeIjkyYWLZMtTI7GsU(DeviceMessagesFragment var0, boolean var1) {
      return onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$z9aJqx_yC9x4UzBdwx4reCJXuJg(DeviceMessagesFragment var0) {
      return onCreateView$lambda$1(var0);
   }

   private static final DeviceControlsAdapter adapter_delegate$lambda$0(DeviceMessagesFragment var0) {
      return new DeviceControlsAdapter(DeviceControlGroup.MESSAGE, var0.getControlActionPublisher());
   }

   private final DeviceControlsAdapter getAdapter() {
      return (DeviceControlsAdapter)this.adapter$delegate.getValue();
   }

   private final PublishSubject getControlActionPublisher() {
      return this.controlActionPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final void handlePadding() {
      FragmentDeviceMessagesBinding var2 = this.binding;
      FragmentDeviceMessagesBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      RecyclerView var3 = var1.messageList;
      if (this.getAdapter().getItemCount() == 0) {
         var3.setPadding(var3.getPaddingLeft(), 0, var3.getPaddingRight(), 0);
      } else {
         var3.setPadding(var3.getPaddingLeft(), MathKt.roundToInt(this.dpToPx1 * (float)24), var3.getPaddingRight(), 0);
      }
   }

   private static final Unit onCreateView$lambda$1(DeviceMessagesFragment var0) {
      var0.handlePadding();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$2(DeviceMessagesFragment var0, Device var1) {
      var0.getAdapter().setDevice(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$3(DeviceMessagesFragment var0, boolean var1) {
      var0.getAdapter().setForceOffline(var1 ^ true);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$6(DeviceMessagesFragment var0, AttributeAction var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("throttleLatest action: ");
      var2.append(var1);
      var3.v(var2.toString(), new Object[0]);
      if (var0.getViewModel().getDevice() != null && var1 instanceof AttributeAction.TroubleShootAction) {
         FragmentManager var4 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
         if (!(var4.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var4.isStateSaved()) {
            ((DialogFragment)TroubleshootingDialog.Companion.newInstance("action_type_device_offline", var0.getAdapter().getDevice())).show(var4, "TroubleshootingDialog");
            var4.executePendingTransactions();
         }
      }

      return Unit.INSTANCE;
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      BaseFragment var11 = this;
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class)));
      FragmentDeviceMessagesBinding var12 = FragmentDeviceMessagesBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var12, "inflate(...)");
      this.binding = var12;
      Object var10 = null;
      FragmentDeviceMessagesBinding var4 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.messageList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
      var12 = this.binding;
      var4 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.messageList.setAdapter(this.getAdapter());
      this.dpToPx1 = TypedValueCompat.dpToPx(1.0F, this.requireContext().getResources().getDisplayMetrics());
      this.getAdapter().setOnItemCountChangedListener(new DeviceMessagesFragment$$ExternalSyntheticLambda2(this));
      LiveData var6 = this.getViewModel().getLiveDevice();
      LifecycleOwner var14 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var14, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var6, var14, new DeviceMessagesFragment$$ExternalSyntheticLambda3(this));
      var6 = this.getViewModel().getNetworkAvailable();
      var14 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var14, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var6, var14, new DeviceMessagesFragment$$ExternalSyntheticLambda4(this));
      FragmentDeviceMessagesBinding var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (FragmentDeviceMessagesBinding)var10;
      }

      RecyclerView var9 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
      return (View)var9;
   }

   public void onResume() {
      super.onResume();
      CompositeDisposable var1 = this.getRxSubs();
      Observable var2 = this.getControlActionPublisher().throttleLatest(300L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var2, "throttleLatest(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new DeviceMessagesFragment$$ExternalSyntheticLambda0(this)));
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceMessagesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceMessagesFragment;", "devicedetails_otherRelease"},
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

      public final DeviceMessagesFragment newInstance() {
         return new DeviceMessagesFragment();
      }
   }
}
