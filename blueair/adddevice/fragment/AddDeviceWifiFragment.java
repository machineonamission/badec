package com.blueair.adddevice.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.FragmentAddDeviceWifiBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.Ssid;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\u0016\u00102\u001a\u00020\"2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c04H\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b#\u0010\u001eR\u0012\u00105\u001a\u000206X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u00109\u001a\u00020\u0002X\u0096\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006>"},
   d2 = {"Lcom/blueair/adddevice/fragment/AddDeviceWifiFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceWifiBinding;", "ssidAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/adddevice/fragment/RegularSsidItem;", "hiddenNetworkAdapter", "Lcom/blueair/adddevice/fragment/HiddenSsidItem;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ssidSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/Ssid;", "getSsidSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "ssidSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "hiddenNetworkSelectPublisher", "", "getHiddenNetworkSelectPublisher", "hiddenNetworkSelectPublisher$delegate", "showProgress", "shouldShowProgress", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "updateSsidList", "newList", "", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceWifiFragment extends BaseFragment implements ProgressFragment, BaseFragmentInterface {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceWifiFragment.class, "ssidSelectPublisher", "getSsidSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceWifiFragment.class, "hiddenNetworkSelectPublisher", "getHiddenNetworkSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   private final AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
   private final ItemAdapter hiddenNetworkAdapter;
   private final LazyPublishSubject hiddenNetworkSelectPublisher$delegate;
   private ProgressBlockerView progressBlockerView;
   private final String screenName = "add_device_wifi_list";
   private final ItemAdapter ssidAdapter = new ItemAdapter();
   private final LazyPublishSubject ssidSelectPublisher$delegate;
   private FragmentAddDeviceWifiBinding viewDataBinding;

   // $FF: synthetic method
   public static void $r8$lambda$4xmxSG6Bes91NvVVuBH_YDnjgGQ(Function1 var0, Object var1) {
      onResume$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$RxROMdBPk98_Hi7U6FqSADEae4k(Throwable var0) {
      return onResume$lambda$7(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$XjkwJEw0PglQybUBCUtKuSuWvQw(AddDeviceWifiFragment var0, Ssid var1) {
      return onResume$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YY_EVys5pYwHncSWcMH8V2yF6yE(AddDeviceWifiFragment var0, BleDeviceState var1) {
      return onResume$lambda$11$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_0zQbLR0VS403z1G4StfJmK4bSg(AddDeviceWifiFragment var0, Unit var1) {
      return onResume$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iSOinFjPOZXXjYQw4gS6__vRz7M(AddDeviceWifiFragment var0, Boolean var1) {
      return onResume$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$sI4K0EcYcYJndFgIuy1CDHj4GnY(Function1 var0, Object var1) {
      onResume$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$wP9pbarCTc5w8aHWihFg_xyPDFI(AddDeviceWifiFragment var0, View var1, IAdapter var2, AbstractBindingItem var3, int var4) {
      return onCreateView$lambda$2(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xO0WFzHtbZ49hVLmTF9I7wxlbEQ(AddDeviceWifiFragment var0, BleDeviceError var1) {
      return onResume$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ynZpYjZuYF2SRaAWzq_5byyVtNc(AddDeviceWifiFragment var0, View var1) {
      onResume$lambda$13(var0, var1);
   }

   public AddDeviceWifiFragment() {
      ItemAdapter var1 = new ItemAdapter();
      var1.add(new HiddenSsidItem[]{HiddenSsidItem.INSTANCE});
      this.hiddenNetworkAdapter = var1;
      this.ssidSelectPublisher$delegate = new LazyPublishSubject();
      this.hiddenNetworkSelectPublisher$delegate = new LazyPublishSubject();
   }

   private final PublishSubject getHiddenNetworkSelectPublisher() {
      return this.hiddenNetworkSelectPublisher$delegate.getValue(this, $$delegatedProperties[1]);
   }

   private final PublishSubject getSsidSelectPublisher() {
      return this.ssidSelectPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private static final boolean onCreateView$lambda$2(AddDeviceWifiFragment var0, View var1, IAdapter var2, AbstractBindingItem var3, int var4) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "item");
      if (var3 instanceof RegularSsidItem) {
         var0.getSsidSelectPublisher().onNext(((RegularSsidItem)var3).getSsid());
      } else if (Intrinsics.areEqual(var3, HiddenSsidItem.INSTANCE)) {
         var0.getHiddenNetworkSelectPublisher().onNext(Unit.INSTANCE);
      }

      return true;
   }

   private static final Unit onResume$lambda$11$lambda$10(AddDeviceWifiFragment var0, BleDeviceState var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("selectedBleDeviceStateObserver: state = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      if (Intrinsics.areEqual(var1, BleDeviceState.WifiConnected.INSTANCE)) {
         var0.getViewModel().gotoSuccessScreen();
      } else if (Intrinsics.areEqual(var1, BleDeviceState.Disconnected.INSTANCE)) {
         var0.getViewModel().showConnectionLost();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$12(AddDeviceWifiFragment var0, Unit var1) {
      var0.getViewModel().gotoWifiPassword((Ssid)null, true);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$13(AddDeviceWifiFragment var0, View var1) {
      var0.updateSsidList(CollectionsKt.emptyList());
      BuildersKt.launch$default(var0, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(var0, (Continuation)null) {
         int label;
         final AddDeviceWifiFragment this$0;

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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               this.this$0.getViewModel().refreshSsidsList();
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }, 2, (Object)null);
   }

   private static final Unit onResume$lambda$4$lambda$3(AddDeviceWifiFragment var0, BleDeviceError var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("selectedBleDeviceErrorObserver: error = ");
      var3.append(var1);
      var2.w(var3.toString(), new Object[0]);
      var0.getViewModel().showConnectionLost();
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$5(AddDeviceWifiFragment var0, Boolean var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("connectionChangedObserver: hasBluetooth = ");
      var2.append(var1);
      var2.append(", hasSelectedBleDevice = ");
      var2.append(var0.getViewModel().getHasSelectedBleDevice());
      var3.d(var2.toString(), new Object[0]);
      if (!var1) {
         var0.getViewModel().showConnectionLost();
      }

      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$6(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$7(Throwable var0) {
      Intrinsics.checkNotNullParameter(var0, "t");
      Timber.Forest.e(var0, "Connection Change Observer failed", new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$8(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$9(AddDeviceWifiFragment var0, Ssid var1) {
      var0.getViewModel().gotoWifiPassword(var1, false);
      return Unit.INSTANCE;
   }

   private final void updateSsidList(List var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("new list = ");
      var3.append(var1);
      var2.i(var3.toString(), new Object[0]);
      this.ssidAdapter.clear();
      ItemAdapter var5 = this.ssidAdapter;
      Iterable var6 = (Iterable)var1;
      Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var6, 10)));
      Iterator var7 = var6.iterator();

      while(var7.hasNext()) {
         var4.add(new RegularSsidItem((Ssid)var7.next()));
      }

      var5.add((List)var4);
      this.hideProgress(this.getContext());
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentAddDeviceWifiBinding var2 = this.viewDataBinding;
      FragmentAddDeviceWifiBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "rootLayout");
      return var3;
   }

   public CompositeDisposable getRxSubs() {
      return this.$$delegate_0.getRxSubs();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public AddDeviceViewModel getViewModel() {
      return this.$$delegate_0.getViewModel();
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentAddDeviceWifiBinding var16 = FragmentAddDeviceWifiBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var16, "inflate(...)");
      FragmentActivity var5 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
      var16.setAddDeviceViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(AddDeviceViewModel.class)));
      var16.setLifecycleOwner((LifecycleOwner)this.requireActivity());
      this.viewDataBinding = var16;
      Object var15 = null;
      FragmentAddDeviceWifiBinding var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      this.setProgressBlockerView(var6.progressView);
      var16 = this.viewDataBinding;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.swipeToRefresh.setEnabled(false);
      var16 = this.viewDataBinding;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      AddDeviceViewModel var9 = var6.getAddDeviceViewModel();
      Intrinsics.checkNotNull(var9);
      this.setViewModel(var9);
      Flow var19 = FlowKt.onEach((Flow)this.getViewModel().isRefreshingSsids(), new Function2(this, (Continuation)null) {
         boolean Z$0;
         int label;
         final AddDeviceWifiFragment this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.Z$0 = (Boolean)var1;
            return (Continuation)var3;
         }

         public final Object invoke(boolean var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var2 = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               FragmentAddDeviceWifiBinding var3 = this.this$0.viewDataBinding;
               FragmentAddDeviceWifiBinding var4 = var3;
               if (var3 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var4 = null;
               }

               var4.swipeToRefresh.setRefreshing(var2);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
      LifecycleOwner var10 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var10, "getViewLifecycleOwner(...)");
      FlowKt.launchIn(var19, (CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var10));
      var10 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var10, "getViewLifecycleOwner(...)");
      LifecycleOwnerKt.getLifecycleScope(var10).launchWhenResumed(new Function2(this, (Continuation)null) {
         private Object L$0;
         int label;
         final AddDeviceWifiFragment this$0;

         {
            this.this$0 = var1;
         }

         // $FF: synthetic method
         private static final Object invokeSuspend$updateSsidList(AddDeviceWifiFragment var0, List var1, Continuation var2) {
            var0.updateSsidList(var1);
            return Unit.INSTANCE;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            CoroutineScope var2 = (CoroutineScope)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               FlowKt.launchIn(FlowKt.onEach((Flow)this.this$0.getViewModel().getSsids(), new Function2(this.this$0) {
                  public final Object invoke(List var1, Continuation var2) {
                     return null.invokeSuspend$updateSsidList((AddDeviceWifiFragment)this.receiver, var1, var2);
                  }
               }), var2);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
      FastAdapter var4 = FastAdapter.Companion.with((Collection)CollectionsKt.listOf(new ItemAdapter[]{this.ssidAdapter, this.hiddenNetworkAdapter}));
      var4.setOnClickListener(new AddDeviceWifiFragment$$ExternalSyntheticLambda0(this));
      FragmentAddDeviceWifiBinding var20 = this.viewDataBinding;
      FragmentAddDeviceWifiBinding var12 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var12 = null;
      }

      var12.recyclerViewSsid.setAdapter((RecyclerView.Adapter)var4);
      var12 = this.viewDataBinding;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var12 = (FragmentAddDeviceWifiBinding)var15;
      }

      View var14 = var12.getRoot();
      Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
      return var14;
   }

   public void onDestroy() {
      this.clearProgressFragment();
      super.onDestroy();
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().recordResume("wifi_list");
      Observable var2 = this.getViewModel().getSelectedBleDeviceErrorObserver();
      if (var2 != null) {
         CompositeDisposable var1 = this.getRxSubs();
         var2 = var2.observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var2, "observeOn(...)");
         var1.add(RxExtensionsKt.subscribeAndLogE(var2, new AddDeviceWifiFragment$$ExternalSyntheticLambda1(this)));
      }

      this.getRxSubs().add(RxExtensionsKt.uiThread(this.getViewModel().getBluetoothConnectionStateObserver()).subscribe(new AddDeviceWifiFragment$$ExternalSyntheticLambda3(new AddDeviceWifiFragment$$ExternalSyntheticLambda2(this)), new AddDeviceWifiFragment$$ExternalSyntheticLambda5(new AddDeviceWifiFragment$$ExternalSyntheticLambda4())));
      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getSsidSelectPublisher(), new AddDeviceWifiFragment$$ExternalSyntheticLambda6(this)));
      var2 = this.getViewModel().getSelectedBleDeviceStateObserver();
      if (var2 != null) {
         CompositeDisposable var3 = this.getRxSubs();
         var2 = var2.observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var2, "observeOn(...)");
         var3.add(RxExtensionsKt.subscribeAndLogE(var2, new AddDeviceWifiFragment$$ExternalSyntheticLambda7(this)));
      }

      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getHiddenNetworkSelectPublisher(), new AddDeviceWifiFragment$$ExternalSyntheticLambda8(this)));
      FragmentAddDeviceWifiBinding var8 = this.viewDataBinding;
      FragmentAddDeviceWifiBinding var4 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      var4.btnRefresh.setOnClickListener(new AddDeviceWifiFragment$$ExternalSyntheticLambda9(this));
      this.getViewModel().refreshSsidsList();
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(AddDeviceViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.$$delegate_0.setViewModel(var1);
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   public void showProgress(boolean var1) {
      ProgressFragment$_CC.showProgress$default(this, this.getContext(), var1, (Integer)null, 4, (Object)null);
   }
}
