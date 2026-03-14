package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.devicedetails.activity.FilterVideoActivity;
import com.blueair.devicedetails.adapter.DeviceFilterPageAdapter;
import com.blueair.devicedetails.databinding.BottomSheetFilterOrderBinding;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0012\u0010*\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010+\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020'H\u0016J\u0012\u0010-\u001a\u00020.2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00105\u001a\u00020'2\u0006\u00106\u001a\u0002002\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00107\u001a\u00020'H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020'H\u0002J\b\u0010?\u001a\u00020'H\u0002J\b\u0010@\u001a\u00020'H\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006B"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFilterPageDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceFilterPageBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "filterConfig", "Lcom/blueair/core/model/FilterConfig;", "fromNotification", "", "openFilterVideoPublisher", "Lio/reactivex/subjects/PublishSubject;", "getOpenFilterVideoPublisher", "()Lio/reactivex/subjects/PublishSubject;", "openFilterVideoPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "openFilterSelectionPublisher", "getOpenFilterSelectionPublisher", "openFilterSelectionPublisher$delegate", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceFilterPageAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceFilterPageAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "showProgress", "shouldShowProgress", "bindViewModel", "showDeviceOfflinePrompt", "onResetFilterClick", "onOrderFilterClick", "showFilterPurchaseOptionDialog", "onFilterOneTimePurchase", "onFilterSubscription", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterPageDialogFragment extends BaseDialogFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceFilterPageDialogFragment.class, "openFilterVideoPublisher", "getOpenFilterVideoPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceFilterPageDialogFragment.class, "openFilterSelectionPublisher", "getOpenFilterSelectionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_FROM_NOTIFICATION = "EXTRA_FROM_NOTIFICATION";
   private String _screenName;
   private final Lazy adapter$delegate = LazyKt.lazy(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda3(this));
   private Device device;
   private FilterConfig filterConfig;
   private boolean fromNotification;
   private final LazyPublishSubject openFilterSelectionPublisher$delegate = new LazyPublishSubject();
   private final LazyPublishSubject openFilterVideoPublisher$delegate = new LazyPublishSubject();
   private DialogfragmentDeviceFilterPageBinding viewDataBinding;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$_Hbjghf8hIwehx0v2wxVY43POqE/* $FF was: $r8$lambda$-Hbjghf8hIwehx0v2wxVY43POqE*/(DeviceFilterPageDialogFragment var0, FilterLifeResetResult var1) {
      return bindViewModel$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceFilterPageAdapter $r8$lambda$0nKMohX7ukRndHfOnU78iY3vS_c(DeviceFilterPageDialogFragment var0) {
      return adapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$KY7IH4WSHAaSX_lVZCnSZVO5YYc(DeviceFilterPageDialogFragment var0, boolean var1) {
      return onResetFilterClick$lambda$13$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KvWrf22Y8CxMzf3iE2Mt0LSHrQw(DeviceFilterPageDialogFragment var0, BottomSheetDialog var1, View var2) {
      showFilterPurchaseOptionDialog$lambda$16(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_vUQ9NG2NukREmg6z6RhqoYJ0Ww(DeviceFilterPageDialogFragment var0, Boolean var1) {
      return onResume$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$enPLPF5LtdbMmxgPbfJMmVHeq6c(DeviceFilterPageDialogFragment var0, BottomSheetDialog var1, View var2) {
      showFilterPurchaseOptionDialog$lambda$17(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$hAEa1b_Hz4JrD_9XgB2f_kt25zI/* $FF was: $r8$lambda$hAEa1b-Hz4JrD-9XgB2f_kt25zI*/(BottomSheetDialog var0, View var1) {
      showFilterPurchaseOptionDialog$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$i8meTHhiretancAuMJO9J7lBcJE(DeviceFilterPageDialogFragment var0, Device var1) {
      return bindViewModel$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$iPHxYz46_rRGMLrf6zPzj9vzpAI/* $FF was: $r8$lambda$iPHxYz46-rRGMLrf6zPzj9vzpAI*/(DeviceFilterPageDialogFragment var0, MenuItem var1) {
      return onCreateView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$upg_W6R3ShyWGZok_J1uIuPy2So(DeviceFilterPageDialogFragment var0, Device var1) {
      return onResume$lambda$7(var0, var1);
   }

   private static final DeviceFilterPageAdapter adapter_delegate$lambda$0(DeviceFilterPageDialogFragment var0) {
      return new DeviceFilterPageAdapter(var0.getOpenFilterVideoPublisher(), var0.getOpenFilterSelectionPublisher());
   }

   private final void bindViewModel() {
      LiveData var1 = this.getViewModel().getLiveDevice();
      LifecycleOwner var2 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var2, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var1, var2, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda8(this));
      this.getViewModel().getResetFilterLifeResult().observe(this.getViewLifecycleOwner(), new Observer(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda9(this)) {
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
   }

   private static final Unit bindViewModel$lambda$10(DeviceFilterPageDialogFragment var0, FilterLifeResetResult var1) {
      if (var1 != null) {
         var0.showProgress(false);
         int var2 = DeviceFilterPageDialogFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var0.showDeviceOfflinePrompt();
            } else {
               FragmentManager var4 = var0.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
               if (!(var4.findFragmentByTag("FAILED") instanceof ConfirmationDialogLeftAligned) && !var4.isStateSaved()) {
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_failed, (Integer)null, R.string.troubleshotting_reset_filter_internal_error, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var4, "FAILED");
               }
            }
         } else {
            DeviceDetailsDialogFragment.Companion.setJumpToAction("filter_status");
            ToastUtils var3 = ToastUtils.INSTANCE;
            Context var5 = var0.requireContext();
            Intrinsics.checkNotNullExpressionValue(var5, "requireContext(...)");
            var3.showCenterToast(var5, R.string.reset_successful, 1);
            FragmentKt.setFragmentResult((Fragment)var0, "REQUEST_KEY_HANDLE_ACTION", BundleKt.bundleOf());
            var0.dismiss();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$8(DeviceFilterPageDialogFragment var0, Device var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("liveDevice = ");
      var2.append(var1);
      var3.v(var2.toString(), new Object[0]);
      var0.getViewModel().setDevice(var1);
      return Unit.INSTANCE;
   }

   private final DeviceFilterPageAdapter getAdapter() {
      return (DeviceFilterPageAdapter)this.adapter$delegate.getValue();
   }

   private final PublishSubject getOpenFilterSelectionPublisher() {
      return this.openFilterSelectionPublisher$delegate.getValue(this, $$delegatedProperties[1]);
   }

   private final PublishSubject getOpenFilterVideoPublisher() {
      return this.openFilterVideoPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private static final boolean onCreateView$lambda$4(DeviceFilterPageDialogFragment var0, MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.dismiss();
      return true;
   }

   private final void onFilterOneTimePurchase() {
      FilterConfig var2 = this.filterConfig;
      if (var2 != null) {
         List var8 = var2.getFilters();
         if (var8 != null) {
            Iterator var4 = ((Iterable)var8).iterator();
            String var9 = null;

            boolean var1;
            Object var3;
            do {
               if (!var4.hasNext()) {
                  var3 = null;
                  break;
               }

               var3 = var4.next();
               FilterInfo var10 = (FilterInfo)var3;
               var9 = DeviceConfigProvider.INSTANCE.getIpConfigValue(var10.getLinkPurchase());
               CharSequence var5 = (CharSequence)var9;
               if (var5 != null && var5.length() != 0) {
                  var1 = false;
               } else {
                  var1 = true;
               }
            } while(var1);

            FilterInfo var13 = (FilterInfo)var3;
            if (var13 != null) {
               DeviceDetailsViewModel var6 = this.getViewModel();
               Device var11 = this.device;
               if (var11 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("device");
                  var11 = null;
               }

               DeviceFilterType var7 = DeviceFilterType.FILTER;
               String var16 = var13.getName().getValue();
               String var14 = var16;
               if (var16 == null) {
                  var14 = "";
               }

               var6.analyticsLogFilterClickEvent(var11, true, false, var7, var14, this.fromNotification);
               if (var9 != null) {
                  DeviceDetailsViewModel var17 = this.getViewModel();
                  Context var15 = this.requireContext();
                  Intrinsics.checkNotNullExpressionValue(var15, "requireContext(...)");
                  String var12 = this.getString(R.string.order_filter);
                  Intrinsics.checkNotNullExpressionValue(var12, "getString(...)");
                  var17.openFilterUrl(var15, var9, var12);
               }
            }
         }
      }

   }

   private final void onFilterSubscription() {
      FilterConfig var2 = this.filterConfig;
      if (var2 != null) {
         List var8 = var2.getFilters();
         if (var8 != null) {
            Iterator var4 = ((Iterable)var8).iterator();
            String var9 = null;

            boolean var1;
            Object var3;
            do {
               if (!var4.hasNext()) {
                  var3 = null;
                  break;
               }

               var3 = var4.next();
               FilterInfo var10 = (FilterInfo)var3;
               var9 = DeviceConfigProvider.INSTANCE.getIpConfigValue(var10.getLinkSubscribe());
               CharSequence var5 = (CharSequence)var9;
               if (var5 != null && var5.length() != 0) {
                  var1 = false;
               } else {
                  var1 = true;
               }
            } while(var1);

            FilterInfo var13 = (FilterInfo)var3;
            if (var13 != null) {
               DeviceDetailsViewModel var6 = this.getViewModel();
               Device var11 = this.device;
               if (var11 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("device");
                  var11 = null;
               }

               DeviceFilterType var7 = DeviceFilterType.FILTER;
               String var16 = var13.getName().getValue();
               String var14 = var16;
               if (var16 == null) {
                  var14 = "";
               }

               var6.analyticsLogFilterClickEvent(var11, false, false, var7, var14, this.fromNotification);
               if (var9 != null) {
                  DeviceDetailsViewModel var12 = this.getViewModel();
                  Context var17 = this.requireContext();
                  Intrinsics.checkNotNullExpressionValue(var17, "requireContext(...)");
                  var14 = this.getString(R.string.order_filter);
                  Intrinsics.checkNotNullExpressionValue(var14, "getString(...)");
                  var12.openFilterUrl(var17, var9, var14);
               }
            }
         }
      }

   }

   private final void onOrderFilterClick() {
      boolean var3;
      boolean var6;
      label93: {
         FilterConfig var4 = this.filterConfig;
         var3 = true;
         if (var4 != null) {
            List var8 = var4.getFilters();
            if (var8 != null) {
               Iterable var9 = (Iterable)var8;
               if (!(var9 instanceof Collection) || !((Collection)var9).isEmpty()) {
                  for(FilterInfo var5 : var9) {
                     CharSequence var15 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var5.getLinkPurchase());
                     if (var15 != null && var15.length() != 0) {
                        var6 = false;
                     } else {
                        var6 = true;
                     }

                     if (!var6) {
                        var6 = true;
                        break label93;
                     }
                  }
               }
            }
         }

         var6 = false;
      }

      boolean var7;
      label72: {
         FilterConfig var11 = this.filterConfig;
         if (var11 != null) {
            List var12 = var11.getFilters();
            if (var12 != null) {
               Iterable var13 = (Iterable)var12;
               if (!(var13 instanceof Collection) || !((Collection)var13).isEmpty()) {
                  for(FilterInfo var16 : var13) {
                     CharSequence var17 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var16.getLinkSubscribe());
                     if (var17 != null && var17.length() != 0) {
                        var7 = false;
                     } else {
                        var7 = true;
                     }

                     if (!var7) {
                        var7 = var3;
                        break label72;
                     }
                  }
               }
            }
         }

         var7 = false;
      }

      if (var6 && var7) {
         this.showFilterPurchaseOptionDialog();
      } else if (var6 && !var7) {
         this.onFilterOneTimePurchase();
      } else {
         if (!var6 && var7) {
            this.onFilterSubscription();
         }

      }
   }

   private final void onResetFilterClick() {
      Device var2 = this.device;
      Device var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var1 = null;
      }

      if (var1.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
         FragmentManager var3 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var3.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_filter_life, (Integer)null, R.string.reset_filter_life_confirm_msg, R.string.confirm, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda6(this), 3680, (Object)null)).show(var3, "ConfirmationDialogLeftAligned");
         }

      } else {
         this.showDeviceOfflinePrompt();
      }
   }

   private static final Unit onResetFilterClick$lambda$13$lambda$12(DeviceFilterPageDialogFragment var0, boolean var1) {
      if (var1) {
         var0.showProgress(true);
         DeviceDetailsViewModel var3 = var0.getViewModel();
         Device var2 = var0.device;
         Device var4 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var4 = null;
         }

         var3.resetFilterLife(var4, DeviceFilterType.FILTER);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$5(DeviceFilterPageDialogFragment var0, Boolean var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("open video ");
      var3.append(var1);
      var2.v(var3.toString(), new Object[0]);
      DeviceConfigProvider var8 = DeviceConfigProvider.INSTANCE;
      FilterConfig var5 = var0.filterConfig;
      AwsLinkConfig var6;
      if (var5 != null) {
         var6 = var5.getVideo();
      } else {
         var6 = null;
      }

      String var7 = var8.getAwsLinkValue(var6);
      CharSequence var9 = (CharSequence)var7;
      if (var9 != null && var9.length() != 0) {
         FilterVideoActivity.Companion var10 = FilterVideoActivity.Companion;
         Context var4 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var4, "requireContext(...)");
         var10.launch(var4, var7);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$7(DeviceFilterPageDialogFragment var0, Device var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("open filter select screen: ");
      var3.append(var1);
      var2.v(var3.toString(), new Object[0]);
      FragmentManager var5 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("FilterSelectionDialogFragment", "getSimpleName(...)");
      if (!(var5.findFragmentByTag("FilterSelectionDialogFragment") instanceof FilterSelectionDialogFragment) && !var5.isStateSaved()) {
         FilterSelectionDialogFragment.Companion var4 = FilterSelectionDialogFragment.Companion;
         Intrinsics.checkNotNull(var1);
         ((DialogFragment)var4.newInstance(var1)).show(var5, "FilterSelectionDialogFragment");
      }

      return Unit.INSTANCE;
   }

   private final void showDeviceOfflinePrompt() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      if (!(var1.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer)null, R.string.device_offline_retry_prompt, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var1, "DEVICE_OFFLINE");
      }

   }

   private final void showFilterPurchaseOptionDialog() {
      BottomSheetDialog var1 = new BottomSheetDialog(this.requireContext(), R.style.BottomSheetDialog);
      BottomSheetFilterOrderBinding var2 = BottomSheetFilterOrderBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      var2.buttonFilterOneTimePurchase.setOnClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda0(this, var1));
      var2.buttonFilterSubscription.setOnClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda1(this, var1));
      var2.btnCancel.setOnClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda2(var1));
      var1.setContentView((View)var2.getRoot());
      var1.show();
   }

   private static final void showFilterPurchaseOptionDialog$lambda$16(DeviceFilterPageDialogFragment var0, BottomSheetDialog var1, View var2) {
      var0.onFilterOneTimePurchase();
      var1.dismiss();
   }

   private static final void showFilterPurchaseOptionDialog$lambda$17(DeviceFilterPageDialogFragment var0, BottomSheetDialog var1, View var2) {
      var0.onFilterSubscription();
      var1.dismiss();
   }

   private static final void showFilterPurchaseOptionDialog$lambda$18(BottomSheetDialog var0, View var1) {
      var0.dismiss();
   }

   protected String getScreenName() {
      return this._screenName;
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

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Window var3 = var2.getWindow();
         if (var3 != null) {
            WindowManager.LayoutParams var4 = var3.getAttributes();
            if (var4 != null) {
               var4.windowAnimations = R.style.dialog_animation;
            }
         }
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, R.style.DialogTheme);
   }

   public Dialog onCreateDialog(Bundle var1) {
      Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
      Dialog var4 = new Dialog(this.requireContext());
      var1 = this.getArguments();
      Object var3 = null;
      String var7;
      if (var1 != null) {
         var7 = var1.getString("screen_name");
      } else {
         var7 = null;
      }

      this._screenName = var7;
      Bundle var8 = this.getArguments();
      Device var9;
      if (var8 != null) {
         var9 = (Device)var8.getParcelable("device");
      } else {
         var9 = null;
      }

      if (var9 != null) {
         this.device = var9;
         DeviceConfigProvider var5 = DeviceConfigProvider.INSTANCE;
         var9 = this.device;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var9 = (Device)var3;
         }

         this.filterConfig = var5.getFilterConfig(var9, DeviceFilterType.FILTER);
         Bundle var11 = this.getArguments();
         boolean var2;
         if (var11 != null) {
            var2 = var11.getBoolean("EXTRA_FROM_NOTIFICATION");
         } else {
            var2 = this.fromNotification;
         }

         this.fromNotification = var2;
         Timber.Forest var12 = Timber.Forest;
         StringBuilder var14 = new StringBuilder("onCreateDialog: dialog = ");
         var14.append(var4);
         var12.d(var14.toString(), new Object[0]);
         FragmentActivity var15 = this.getActivity();
         if (var15 != null) {
            Window var13 = var4.getWindow();
            if (var13 != null) {
               var13.setBackgroundDrawable(ContextCompat.getDrawable((Context)var15, R.drawable.top_rounded_rectangle_white));
            }
         }

         return var4;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentDeviceFilterPageBinding var15 = DialogfragmentDeviceFilterPageBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var15, "inflate(...)");
      var15.setDeviceDetailViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      var15.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var15;
      Object var23 = null;
      DialogfragmentDeviceFilterPageBinding var6 = var15;
      if (var15 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      DeviceDetailsViewModel var7 = var6.getDeviceDetailViewModel();
      if (var7 != null) {
         this.setViewModel(var7);
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("onViewCreated: viewModel = ");
         var4.append(this.getViewModel());
         var4.append(",  device = ");
         Device var16 = this.device;
         Device var8 = var16;
         if (var16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var8 = null;
         }

         var4.append(var8);
         var5.d(var4.toString(), new Object[0]);
         DeviceDetailsViewModel var24 = this.getViewModel();
         var16 = this.device;
         var8 = var16;
         if (var16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var8 = null;
         }

         var24.setDevice(var8);
         DeviceFilterPageAdapter var25 = this.getAdapter();
         var8 = this.device;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var8 = null;
         }

         label37: {
            FilterConfig var18 = this.filterConfig;
            if (var18 != null) {
               List var19 = var18.getFilters();
               if (var19 != null) {
                  var20 = (FilterInfo)CollectionsKt.firstOrNull(var19);
                  break label37;
               }
            }

            var20 = null;
         }

         var25.setDevice(var8, var20, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(this.filterConfig), new Function0(this) {
            public final void invoke() {
               ((DeviceFilterPageDialogFragment)this.receiver).onOrderFilterClick();
            }
         }, new Function0(this) {
            public final void invoke() {
               ((DeviceFilterPageDialogFragment)this.receiver).onResetFilterClick();
            }
         });
         DialogfragmentDeviceFilterPageBinding var21 = this.viewDataBinding;
         DialogfragmentDeviceFilterPageBinding var11 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = null;
         }

         var11.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda7(this));
         var21 = this.viewDataBinding;
         var11 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = null;
         }

         var11.filterWidgets.setAdapter(this.getAdapter());
         var11 = this.viewDataBinding;
         if (var11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var11 = (DialogfragmentDeviceFilterPageBinding)var23;
         }

         View var14 = var11.getRoot();
         Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
         return var14;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onResume() {
      super.onResume();
      CompositeDisposable var1 = this.getRxSubs();
      Observable var2 = RxExtensionsKt.filterRapidClicks((Observable)this.getOpenFilterVideoPublisher());
      Intrinsics.checkNotNullExpressionValue(var2, "filterRapidClicks(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda4(this)));
      var1 = this.getRxSubs();
      var2 = RxExtensionsKt.filterRapidClicks((Observable)this.getOpenFilterSelectionPublisher());
      Intrinsics.checkNotNullExpressionValue(var2, "filterRapidClicks(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new DeviceFilterPageDialogFragment$$ExternalSyntheticLambda5(this)));
   }

   public void onStart() {
      super.onStart();
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Point var3;
         Display var5;
         label24: {
            var3 = new Point();
            Window var1 = var2.getWindow();
            if (var1 != null) {
               WindowManager var4 = var1.getWindowManager();
               if (var4 != null) {
                  var5 = var4.getDefaultDisplay();
                  break label24;
               }
            }

            var5 = null;
         }

         if (var5 != null) {
            var5.getSize(var3);
         }

         Window var6 = var2.getWindow();
         if (var6 != null) {
            var6.setLayout(-1, -1);
         }

         var6 = var2.getWindow();
         if (var6 != null) {
            var6.setGravity(80);
         }
      }

   }

   public void onStop() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onStop();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("onViewCreated: viewModel = ");
      var5.append(this.getViewModel());
      var5.append(",  device = ");
      Device var3 = this.device;
      Object var8 = null;
      Device var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var6 = null;
      }

      var5.append(var6);
      var4.d(var5.toString(), new Object[0]);
      DeviceDetailsViewModel var9 = this.getViewModel();
      var6 = this.device;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var6 = (Device)var8;
      }

      var9.setDeviceId(var6.getUid());
      this.bindViewModel();
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      DialogfragmentDeviceFilterPageBinding var3 = this.viewDataBinding;
      DialogfragmentDeviceFilterPageBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceFilterPageDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_FROM_NOTIFICATION", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceFilterPageDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "fromNotification", "", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static DeviceFilterPageDialogFragment newInstance$default(Companion var0, Device var1, boolean var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         return var0.newInstance(var1, var2);
      }

      public final DeviceFilterPageDialogFragment newInstance(Device var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceFilterPageDialogFragment var5 = new DeviceFilterPageDialogFragment();
         Bundle var4 = new Bundle();
         String var3;
         if (var2) {
            var3 = "notifications_filter";
         } else {
            var3 = "device_details_filter";
         }

         var4.putString("screen_name", var3);
         var4.putParcelable("device", var1);
         var4.putBoolean("EXTRA_FROM_NOTIFICATION", var2);
         var5.setArguments(var4);
         return var5;
      }
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
         int[] var0 = new int[FilterLifeResetResult.values().length];

         try {
            var0[FilterLifeResetResult.SUCCESS.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[FilterLifeResetResult.FAILED.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[FilterLifeResetResult.DEVICE_OFFLINE.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
