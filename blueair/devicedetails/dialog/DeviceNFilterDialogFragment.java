package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.activity.FilterVideoActivity;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.adapter.DeviceFilterAdapter;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.SelectDeviceFilterDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020&H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNFilterDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceNFilterBinding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/DeviceFilterAdapter;", "device", "Lcom/blueair/core/model/HasSKU;", "deviceSku", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "onlyBuy", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showDeviceOfflinePrompt", "refreshFilterScrollIndicators", "onStart", "showProgress", "shouldShowProgress", "onResume", "onPause", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNFilterDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
   private static final String EXTRA_ONLY_BUY = "EXTRA_ONLY_BUY";
   private static final String EXTRA_TYPE = "EXTRA_TYPE";
   private static boolean shouldDismiss;
   private String _screenName;
   private DialogfragmentDeviceNFilterBinding binding;
   private HasSKU device;
   private String deviceSku;
   private final DeviceFilterAdapter filterAdapter = new DeviceFilterAdapter((Function1)null);
   private boolean fromNotification;
   private boolean onlyBuy;
   private DeviceFilterType type;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$1nIGjxlDvLlA_CLLqZzH5Gc0prM/* $FF was: $r8$lambda$1nIGjxlDvLlA-CLLqZzH5Gc0prM*/(DeviceNFilterDialogFragment var0, String var1, View var2) {
      onViewCreated$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$6CRuLIM_ko8407AH170ks2IQpkk(DeviceNFilterDialogFragment var0, String var1, List var2, String var3, View var4) {
      onViewCreated$lambda$30(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DBAyXMMlqYXpzC4u5xoY30QcvIY(DeviceNFilterDialogFragment var0, List var1, String var2, FilterInfo var3) {
      return onViewCreated$lambda$30$lambda$29$lambda$28(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Ey0pSEtyvvXFnWlmfDeIY0iogr4(DeviceNFilterDialogFragment var0, String var1, List var2, String var3, View var4) {
      onViewCreated$lambda$24(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NNqy9zcsdUBaIgF6Kj_2jraSfiw/* $FF was: $r8$lambda$NNqy9zcsdUBaIgF6Kj-2jraSfiw*/(DeviceNFilterDialogFragment var0, List var1, String var2, View var3) {
      onViewCreated$lambda$15(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NhudVMcW18aK5m7UsMA4Idsk6I4(DeviceNFilterDialogFragment var0, View var1) {
      onViewCreated$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$RfvFC_4TnrjfVku1dzoTrLcKrdw(DeviceNFilterDialogFragment var0, List var1, String var2, FilterInfo var3) {
      return onViewCreated$lambda$24$lambda$23$lambda$22(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$oKQAjtkWGg5i_8tqNjoJTGUg0VM/* $FF was: $r8$lambda$oKQAjtkWGg5i-8tqNjoJTGUg0VM*/(DeviceNFilterDialogFragment var0, int var1, int var2, View var3) {
      onViewCreated$lambda$11$lambda$10(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qFwU0KdsZtajCDCRKYLjRCktoZ0(DeviceNFilterDialogFragment var0, List var1, String var2, View var3) {
      onViewCreated$lambda$18(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$qb9AMgt_34j6VyH5RETzxC0lZOc/* $FF was: $r8$lambda$qb9AMgt-34j6VyH5RETzxC0lZOc*/(DeviceNFilterDialogFragment var0, FilterLifeResetResult var1) {
      return onViewCreated$lambda$34(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$raqseRQvpukwLvyH0d3oQOPHGmw(DeviceNFilterDialogFragment var0, View var1) {
      onViewCreated$lambda$11$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zJJnyx_txMSLERqmmDKhNk9vYv8(DeviceNFilterDialogFragment var0, boolean var1) {
      return onViewCreated$lambda$11$lambda$10$lambda$9$lambda$8(var0, var1);
   }

   public DeviceNFilterDialogFragment() {
      this.type = DeviceFilterType.FILTER;
   }

   private final String getSku() {
      HasSKU var1 = this.device;
      if (var1 != null) {
         String var3 = var1.getSku();
         if (var3 != null) {
            return var3;
         }
      }

      String var2 = this.deviceSku;
      String var4 = var2;
      if (var2 == null) {
         var4 = "";
      }

      return var4;
   }

   private static final void onViewCreated$lambda$11$lambda$10(DeviceNFilterDialogFragment var0, int var1, int var2, View var3) {
      HasSKU var4 = var0.device;
      ConnectivityStatus var5;
      if (var4 != null) {
         var5 = var4.getConnectivityStatus();
      } else {
         var5 = null;
      }

      if (var5 == ConnectivityStatus.ONLINE) {
         FragmentManager var6 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var6, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var6.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var6.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var1, (Integer)null, var2, R.string.confirm, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new DeviceNFilterDialogFragment$$ExternalSyntheticLambda2(var0), 3680, (Object)null)).show(var6, "ConfirmationDialogLeftAligned");
         }

      } else {
         var0.showDeviceOfflinePrompt();
      }
   }

   private static final Unit onViewCreated$lambda$11$lambda$10$lambda$9$lambda$8(DeviceNFilterDialogFragment var0, boolean var1) {
      if (var1) {
         HasSKU var2 = var0.device;
         if (var2 != null) {
            var0.showProgress(true);
            var0.getViewModel().resetFilterLife(var2, var0.type);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$11$lambda$6(DeviceNFilterDialogFragment var0, View var1) {
      Actions var2 = Actions.INSTANCE;
      Context var3 = var0.requireContext();
      Intrinsics.checkNotNullExpressionValue(var3, "requireContext(...)");
      var0.startActivity(var2.openAntiFakeScanIntent(var3, var0.device, var0.type));
   }

   private static final void onViewCreated$lambda$12(DeviceNFilterDialogFragment var0, String var1, View var2) {
      FilterVideoActivity.Companion var4 = FilterVideoActivity.Companion;
      Context var3 = var0.requireContext();
      Intrinsics.checkNotNullExpressionValue(var3, "requireContext(...)");
      var4.launch(var3, var1);
   }

   private static final void onViewCreated$lambda$15(DeviceNFilterDialogFragment var0, List var1, String var2, View var3) {
      HasSKU var10 = var0.device;
      if (var10 != null) {
         DeviceDetailsViewModel var5 = var0.getViewModel();
         Device var6 = var10;
         DeviceFilterType var7 = var0.type;
         String var4 = ((FilterInfo)CollectionsKt.first(var1)).getName().getValue();
         String var11 = var4;
         if (var4 == null) {
            var11 = "";
         }

         var5.analyticsLogFilterClickEvent(var6, false, false, var7, var11, var0.fromNotification);
      }

      String var9 = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo)CollectionsKt.first(var1)).getLinkSubscribe());
      if (var9 != null) {
         DeviceDetailsViewModel var12 = var0.getViewModel();
         Context var8 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var8, "requireContext(...)");
         var12.openFilterUrl(var8, var9, var2);
      }

   }

   private static final void onViewCreated$lambda$18(DeviceNFilterDialogFragment var0, List var1, String var2, View var3) {
      HasSKU var10 = var0.device;
      if (var10 != null) {
         DeviceDetailsViewModel var5 = var0.getViewModel();
         Device var7 = var10;
         DeviceFilterType var6 = var0.type;
         String var4 = ((FilterInfo)CollectionsKt.first(var1)).getName().getValue();
         String var11 = var4;
         if (var4 == null) {
            var11 = "";
         }

         var5.analyticsLogFilterClickEvent(var7, true, false, var6, var11, var0.fromNotification);
      }

      String var9 = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo)CollectionsKt.first(var1)).getLinkPurchase());
      if (var9 != null) {
         DeviceDetailsViewModel var12 = var0.getViewModel();
         Context var8 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var8, "requireContext(...)");
         var12.openFilterUrl(var8, var9, var2);
      }

   }

   private static final void onViewCreated$lambda$2(DeviceNFilterDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$24(DeviceNFilterDialogFragment var0, String var1, List var2, String var3, View var4) {
      FragmentManager var5 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("SelectDeviceFilterDialogFragment", "getSimpleName(...)");
      if (!(var5.findFragmentByTag("SelectDeviceFilterDialogFragment") instanceof SelectDeviceFilterDialogFragment) && !var5.isStateSaved()) {
         HasSKU var6 = var0.device;
         if (var6 != null) {
            var0.getViewModel().analyticsLogFilterClickEvent(var6, false, false, var0.type, "", var0.fromNotification);
         }

         ((DialogFragment)SelectDeviceFilterDialogFragment.Companion.newInstance(var1, var2, new DeviceNFilterDialogFragment$$ExternalSyntheticLambda11(var0, var2, var3))).show(var5, "SelectDeviceFilterDialogFragment");
      }

   }

   private static final Unit onViewCreated$lambda$24$lambda$23$lambda$22(DeviceNFilterDialogFragment var0, List var1, String var2, FilterInfo var3) {
      Intrinsics.checkNotNullParameter(var3, "filter");
      HasSKU var4 = var0.device;
      if (var4 != null) {
         DeviceDetailsViewModel var5 = var0.getViewModel();
         Device var6 = var4;
         DeviceFilterType var7 = var0.type;
         String var12 = var3.getName().getValue();
         String var10 = var12;
         if (var12 == null) {
            var10 = "";
         }

         var5.analyticsLogFilterClickEvent(var6, false, true, var7, var10, var0.fromNotification);
      }

      String var11 = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo)CollectionsKt.first(var1)).getLinkSubscribe());
      if (var11 != null) {
         DeviceDetailsViewModel var9 = var0.getViewModel();
         Context var8 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var8, "requireContext(...)");
         var9.openFilterUrl(var8, var11, var2);
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$30(DeviceNFilterDialogFragment var0, String var1, List var2, String var3, View var4) {
      FragmentManager var5 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("SelectDeviceFilterDialogFragment", "getSimpleName(...)");
      if (!(var5.findFragmentByTag("SelectDeviceFilterDialogFragment") instanceof SelectDeviceFilterDialogFragment) && !var5.isStateSaved()) {
         HasSKU var6 = var0.device;
         if (var6 != null) {
            var0.getViewModel().analyticsLogFilterClickEvent(var6, true, false, var0.type, "", var0.fromNotification);
         }

         ((DialogFragment)SelectDeviceFilterDialogFragment.Companion.newInstance(var1, var2, new DeviceNFilterDialogFragment$$ExternalSyntheticLambda1(var0, var2, var3))).show(var5, "SelectDeviceFilterDialogFragment");
      }

   }

   private static final Unit onViewCreated$lambda$30$lambda$29$lambda$28(DeviceNFilterDialogFragment var0, List var1, String var2, FilterInfo var3) {
      Intrinsics.checkNotNullParameter(var3, "filter");
      HasSKU var4 = var0.device;
      if (var4 != null) {
         DeviceDetailsViewModel var5 = var0.getViewModel();
         Device var7 = var4;
         DeviceFilterType var6 = var0.type;
         String var12 = var3.getName().getValue();
         String var10 = var12;
         if (var12 == null) {
            var10 = "";
         }

         var5.analyticsLogFilterClickEvent(var7, true, true, var6, var10, var0.fromNotification);
      }

      String var9 = DeviceConfigProvider.INSTANCE.getIpConfigValue(((FilterInfo)CollectionsKt.first(var1)).getLinkPurchase());
      if (var9 != null) {
         DeviceDetailsViewModel var11 = var0.getViewModel();
         Context var8 = var0.requireContext();
         Intrinsics.checkNotNullExpressionValue(var8, "requireContext(...)");
         var11.openFilterUrl(var8, var9, var2);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$34(DeviceNFilterDialogFragment var0, FilterLifeResetResult var1) {
      if (var1 != null) {
         var0.showProgress(false);
         int var2 = DeviceNFilterDialogFragment.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
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
            DeviceDetailsDialogFragment.Companion var3 = DeviceDetailsDialogFragment.Companion;
            DeviceFilterType var5 = var0.type;
            var2 = DeviceNFilterDialogFragment.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
            String var6;
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     throw new NoWhenBranchMatchedException();
                  }

                  var6 = "refresher_status";
               } else {
                  var6 = "wick_status";
               }
            } else {
               var6 = "filter_status";
            }

            var3.setJumpToAction(var6);
            ToastUtils var7 = ToastUtils.INSTANCE;
            Context var9 = var0.requireContext();
            Intrinsics.checkNotNullExpressionValue(var9, "requireContext(...)");
            var7.showCenterToast(var9, R.string.reset_successful, 1);
            FragmentKt.setFragmentResult((Fragment)var0, "REQUEST_KEY_HANDLE_ACTION", BundleKt.bundleOf());
            var0.dismiss();
         }
      }

      return Unit.INSTANCE;
   }

   private final void refreshFilterScrollIndicators() {
      DialogfragmentDeviceNFilterBinding var6 = this.binding;
      Object var5 = null;
      DialogfragmentDeviceNFilterBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ImageView var7 = var4.filterScrollLeft;
      var6 = this.binding;
      var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      boolean var3 = var4.filterList.canScrollHorizontally(-1);
      byte var2 = 0;
      byte var1;
      if (var3) {
         var1 = 0;
      } else {
         var1 = 4;
      }

      var7.setVisibility(var1);
      var6 = this.binding;
      var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ImageView var14 = var4.filterScrollRight;
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (DialogfragmentDeviceNFilterBinding)var5;
      }

      if (var4.filterList.canScrollHorizontally(1)) {
         var1 = var2;
      } else {
         var1 = 4;
      }

      var14.setVisibility(var1);
   }

   private final void showDeviceOfflinePrompt() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      if (!(var1.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer)null, R.string.device_offline_retry_prompt, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var1, "DEVICE_OFFLINE");
      }

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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      shouldDismiss = false;
      this.setStyle(0, R.style.DialogTheme);
      Dialog var9 = this.getDialog();
      if (var9 != null) {
         Window var10 = var9.getWindow();
         if (var10 != null) {
            var10.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var10.setWindowAnimations(R.style.dialog_animation);
            var10.setGravity(80);
         }
      }

      Bundle var4 = this.requireArguments();
      this._screenName = var4.getString("screen_name");
      this.device = (HasSKU)var4.getParcelable("device");
      this.deviceSku = var4.getString("device_sku");
      String var11 = var4.getString("EXTRA_TYPE", "FILTER");
      Intrinsics.checkNotNullExpressionValue(var11, "getString(...)");
      this.type = DeviceFilterType.valueOf(var11);
      this.onlyBuy = var4.getBoolean("EXTRA_ONLY_BUY", false);
      this.fromNotification = var4.getBoolean("extra_from_notification", false);
      DialogfragmentDeviceNFilterBinding var5 = DialogfragmentDeviceNFilterBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      DialogfragmentDeviceNFilterBinding var8 = this.binding;
      var5 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      View var7 = var5.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      return var7;
   }

   public void onPause() {
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

      super.onPause();
   }

   public void onResume() {
      super.onResume();
      if (shouldDismiss) {
         shouldDismiss = false;
         this.dismiss();
      } else {
         this.refreshFilterScrollIndicators();
      }
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentDeviceNFilterBinding var49 = this.binding;
      DialogfragmentDeviceNFilterBinding var13 = var49;
      if (var49 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var13 = null;
      }

      var13.closeBtn.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda0(this));
      FilterConfig var10 = DeviceConfigProvider.INSTANCE.getFilterConfig(this.getSku(), this.type);
      DeviceFilterType var14 = this.type;
      int var3 = DeviceNFilterDialogFragment.WhenMappings.$EnumSwitchMapping$0[var14.ordinal()];
      String var24;
      String var58;
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            DialogfragmentDeviceNFilterBinding var50 = this.binding;
            DialogfragmentDeviceNFilterBinding var15 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var15 = null;
            }

            TextView var16 = var15.title;
            if (this.onlyBuy) {
               var3 = R.string.action_buy_refresher;
            } else {
               var3 = R.string.how_to_replace_your_refresher;
            }

            var16.setText(var3);
            var50 = this.binding;
            DialogfragmentDeviceNFilterBinding var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.whyIsThisImportant.setText(R.string.why_is_this_important_wick);
            var50 = this.binding;
            var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.videoSummary.setText(R.string.video_summary_refresher);
            var50 = this.binding;
            var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.availableFilters.setText(R.string.available_refreshers);
            var50 = this.binding;
            var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.btnAntiFake.setText(R.string.replace_water_refresher);
            var50 = this.binding;
            var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.btnResetFilter.setText(R.string.action_reset_refresher);
            var50 = this.binding;
            var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.buyNewFilter.setText(R.string.action_buy_refresher);
            var50 = this.binding;
            var17 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var17 = null;
            }

            var17.btnSubscribe.setText(R.string.action_goto_subscription);
            var58 = this.getString(R.string.select_refresher);
            Intrinsics.checkNotNullExpressionValue(var58, "getString(...)");
            var24 = this.getString(R.string.order_refresher);
            Intrinsics.checkNotNullExpressionValue(var24, "getString(...)");
            Unit var8 = Unit.INSTANCE;
         } else {
            DialogfragmentDeviceNFilterBinding var59 = this.binding;
            DialogfragmentDeviceNFilterBinding var25 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var25 = null;
            }

            TextView var26 = var25.title;
            if (this.onlyBuy) {
               var3 = R.string.buy_new_wick_filter;
            } else {
               var3 = R.string.how_to_replace_wick_filter;
            }

            var26.setText(var3);
            var59 = this.binding;
            DialogfragmentDeviceNFilterBinding var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.whyIsThisImportant.setText(R.string.why_is_this_important_wick);
            var59 = this.binding;
            var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.videoSummary.setText(R.string.video_summary_wick);
            var59 = this.binding;
            var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.availableFilters.setText(R.string.available_wicks);
            var59 = this.binding;
            var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.btnAntiFake.setText(R.string.replace_wick_filter);
            var59 = this.binding;
            var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.btnResetFilter.setText(R.string.reset_wick_life);
            var59 = this.binding;
            var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.buyNewFilter.setText(R.string.buy_new_wick_filter);
            var59 = this.binding;
            var27 = var59;
            if (var59 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = null;
            }

            var27.btnSubscribe.setText(R.string.wick_start_subscription);
            var58 = this.getString(R.string.select_wick);
            Intrinsics.checkNotNullExpressionValue(var58, "getString(...)");
            var24 = this.getString(R.string.order_wick);
            Intrinsics.checkNotNullExpressionValue(var24, "getString(...)");
            Unit var99 = Unit.INSTANCE;
         }
      } else {
         DialogfragmentDeviceNFilterBinding var67 = this.binding;
         DialogfragmentDeviceNFilterBinding var34 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var34 = null;
         }

         TextView var35 = var34.title;
         if (this.onlyBuy) {
            var3 = R.string.buy_new_filter;
         } else {
            var3 = R.string.how_to_replace_filter;
         }

         var35.setText(var3);
         var67 = this.binding;
         DialogfragmentDeviceNFilterBinding var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.whyIsThisImportant.setText(R.string.why_is_this_important);
         var67 = this.binding;
         var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.videoSummary.setText(R.string.video_summary);
         var67 = this.binding;
         var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.availableFilters.setText(R.string.available_filters);
         var67 = this.binding;
         var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.btnAntiFake.setText(R.string.replace_filter);
         var67 = this.binding;
         var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.btnResetFilter.setText(R.string.reset_filter_life);
         var67 = this.binding;
         var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.buyNewFilter.setText(R.string.buy_new_filter);
         var67 = this.binding;
         var36 = var67;
         if (var67 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.btnSubscribe.setText(R.string.filter_start_subscription);
         var58 = this.getString(R.string.select_filter);
         Intrinsics.checkNotNullExpressionValue(var58, "getString(...)");
         var24 = this.getString(R.string.order_filter);
         Intrinsics.checkNotNullExpressionValue(var24, "getString(...)");
         Unit var100 = Unit.INSTANCE;
      }

      DeviceConfigProvider var9 = DeviceConfigProvider.INSTANCE;
      AwsLinkConfig var101;
      if (var10 != null) {
         var101 = var10.getVideo();
      } else {
         var101 = null;
      }

      String var11 = var9.getAwsLinkValue(var101);
      CharSequence var12 = (CharSequence)var11;
      if (var12 == null || var12.length() == 0) {
         DialogfragmentDeviceNFilterBinding var124 = this.binding;
         DialogfragmentDeviceNFilterBinding var102 = var124;
         if (var124 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var102 = null;
         }

         Group var103 = var102.replaceGroup;
         Intrinsics.checkNotNullExpressionValue(var103, "replaceGroup");
         ViewExtensionsKt.hide((View)var103);
      }

      if (var10 != null && !var10.getFilters().isEmpty()) {
         boolean var5;
         label357: {
            Iterable var107 = (Iterable)var10.getFilters();
            if (!(var107 instanceof Collection) || !((Collection)var107).isEmpty()) {
               for(FilterInfo var132 : var107) {
                  CharSequence var133 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var132.getLinkPurchase());
                  if (var133 != null && var133.length() != 0) {
                     var3 = 0;
                  } else {
                     var3 = 1;
                  }

                  if (!var3) {
                     var5 = true;
                     break label357;
                  }
               }
            }

            var5 = false;
         }

         boolean var6;
         label359: {
            Iterable var109 = (Iterable)var10.getFilters();
            if (!(var109 instanceof Collection) || !((Collection)var109).isEmpty()) {
               for(FilterInfo var134 : var109) {
                  CharSequence var135 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var134.getLinkSubscribe());
                  if (var135 != null && var135.length() != 0) {
                     var3 = 0;
                  } else {
                     var3 = 1;
                  }

                  if (!var3) {
                     var6 = true;
                     break label359;
                  }
               }
            }

            var6 = false;
         }

         DialogfragmentDeviceNFilterBinding var136 = this.binding;
         DialogfragmentDeviceNFilterBinding var111 = var136;
         if (var136 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var111 = null;
         }

         if (!this.onlyBuy) {
            boolean var7 = this.getViewModel().deviceSupportAntiFake(this.device);
            MaterialButton var137 = var111.btnAntiFake;
            Intrinsics.checkNotNullExpressionValue(var137, "btnAntiFake");
            ViewExtensionsKt.show((View)var137, var7);
            var137 = var111.btnResetFilter;
            Intrinsics.checkNotNullExpressionValue(var137, "btnResetFilter");
            View var139 = (View)var137;
            if (!var7 && !(this.device instanceof DeviceBlue)) {
               var7 = true;
            } else {
               var7 = false;
            }

            ViewExtensionsKt.show(var139, var7);
            DeviceFilterType var140 = this.type;
            var3 = DeviceNFilterDialogFragment.WhenMappings.$EnumSwitchMapping$0[var140.ordinal()];
            int var4;
            if (var3 != 1) {
               if (var3 != 2) {
                  if (var3 != 3) {
                     throw new NoWhenBranchMatchedException();
                  }

                  var3 = R.string.action_reset_refresher;
                  var4 = R.string.reset_refresher_msg_lower;
                  Unit var141 = Unit.INSTANCE;
               } else {
                  var3 = R.string.reset_wick_life;
                  var4 = R.string.reset_wick_life_confirm_msg;
                  Unit var142 = Unit.INSTANCE;
               }
            } else {
               var3 = R.string.reset_filter_life;
               var4 = R.string.reset_filter_life_confirm_msg;
               Unit var143 = Unit.INSTANCE;
            }

            var111.btnAntiFake.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda3(this));
            var111.btnResetFilter.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda4(this, var3, var4));
         }

         TextView var144 = var111.buyNewFilter;
         Intrinsics.checkNotNullExpressionValue(var144, "buyNewFilter");
         View var145 = (View)var144;
         boolean var98;
         if (this.onlyBuy || !var5 && !var6) {
            var98 = false;
         } else {
            var98 = true;
         }

         ViewExtensionsKt.show(var145, var98);
         MaterialButton var146 = var111.btnPurchase;
         Intrinsics.checkNotNullExpressionValue(var146, "btnPurchase");
         ViewExtensionsKt.show((View)var146, var5);
         var146 = var111.btnSubscribe;
         Intrinsics.checkNotNullExpressionValue(var146, "btnSubscribe");
         ViewExtensionsKt.show((View)var146, var6);
         TextView var112 = var111.discountHint;
         Intrinsics.checkNotNullExpressionValue(var112, "discountHint");
         ViewExtensionsKt.show((View)var112, var6);
         Unit var113 = Unit.INSTANCE;
      } else {
         DialogfragmentDeviceNFilterBinding var125 = this.binding;
         DialogfragmentDeviceNFilterBinding var104 = var125;
         if (var125 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var104 = null;
         }

         TextView var126 = var104.availableFilters;
         Intrinsics.checkNotNullExpressionValue(var126, "availableFilters");
         ViewExtensionsKt.hide((View)var126);
         RecyclerView var127 = var104.filterList;
         Intrinsics.checkNotNullExpressionValue(var127, "filterList");
         ViewExtensionsKt.hide((View)var127);
         MaterialButton var128 = var104.btnAntiFake;
         Intrinsics.checkNotNullExpressionValue(var128, "btnAntiFake");
         ViewExtensionsKt.hide((View)var128);
         TextView var129 = var104.buyNewFilter;
         Intrinsics.checkNotNullExpressionValue(var129, "buyNewFilter");
         ViewExtensionsKt.hide((View)var129);
         MaterialButton var130 = var104.btnPurchase;
         Intrinsics.checkNotNullExpressionValue(var130, "btnPurchase");
         ViewExtensionsKt.hide((View)var130);
         var130 = var104.btnSubscribe;
         Intrinsics.checkNotNullExpressionValue(var130, "btnSubscribe");
         ViewExtensionsKt.hide((View)var130);
         TextView var105 = var104.discountHint;
         Intrinsics.checkNotNullExpressionValue(var105, "discountHint");
         ViewExtensionsKt.hide((View)var105);
         Unit var106 = Unit.INSTANCE;
      }

      if (var12 != null && var12.length() != 0) {
         DialogfragmentDeviceNFilterBinding var148 = this.binding;
         DialogfragmentDeviceNFilterBinding var114 = var148;
         if (var148 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var114 = null;
         }

         AppCompatImageView var115 = var114.videoThumbnail;
         Intrinsics.checkNotNull(var10);
         var115.setImageResource(var10.getVideoThumbnail());
         var148 = this.binding;
         DialogfragmentDeviceNFilterBinding var116 = var148;
         if (var148 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var116 = null;
         }

         var116.iconPlay.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda5(this, var11));
         var148 = this.binding;
         var116 = var148;
         if (var148 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var116 = null;
         }

         var116.filterList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext(), 0, false)));
         var148 = this.binding;
         var116 = var148;
         if (var148 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var116 = null;
         }

         var116.filterList.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            final DeviceNFilterDialogFragment this$0;

            {
               this.this$0 = var1;
            }

            public void onScrolled(RecyclerView var1, int var2, int var3) {
               Intrinsics.checkNotNullParameter(var1, "recyclerView");
               this.this$0.refreshFilterScrollIndicators();
            }
         });
         var148 = this.binding;
         var116 = var148;
         if (var148 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var116 = null;
         }

         var116.filterList.setAdapter(this.filterAdapter);
         List var155 = var10.getFilters();
         this.filterAdapter.setFilters(var155);
         if (!((Collection)var155).isEmpty()) {
            if (var155.size() == 1) {
               var116 = this.binding;
               DialogfragmentDeviceNFilterBinding var75 = var116;
               if (var116 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var75 = null;
               }

               var75.btnSubscribe.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda6(this, var155, var24));
               var116 = this.binding;
               var75 = var116;
               if (var116 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var75 = null;
               }

               var75.btnPurchase.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda7(this, var155, var24));
            } else {
               var148 = this.binding;
               var116 = var148;
               if (var148 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var116 = null;
               }

               var116.btnSubscribe.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda8(this, var58, var155, var24));
               var148 = this.binding;
               var116 = var148;
               if (var148 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var116 = null;
               }

               var116.btnPurchase.setOnClickListener(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda9(this, var58, var155, var24));
            }
         }
      }

      if (this.device == null) {
         DialogfragmentDeviceNFilterBinding var77 = this.binding;
         DialogfragmentDeviceNFilterBinding var43 = var77;
         if (var77 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var43 = null;
         }

         Group var78 = var43.replaceGroup;
         Intrinsics.checkNotNullExpressionValue(var78, "replaceGroup");
         ViewExtensionsKt.show$default((View)var78, false, 1, (Object)null);
         TextView var79 = var43.availableFilters;
         Intrinsics.checkNotNullExpressionValue(var79, "availableFilters");
         ViewExtensionsKt.hide((View)var79);
         RecyclerView var80 = var43.filterList;
         Intrinsics.checkNotNullExpressionValue(var80, "filterList");
         ViewExtensionsKt.hide((View)var80);
         MaterialButton var81 = var43.btnAntiFake;
         Intrinsics.checkNotNullExpressionValue(var81, "btnAntiFake");
         ViewExtensionsKt.hide((View)var81);
         TextView var82 = var43.buyNewFilter;
         Intrinsics.checkNotNullExpressionValue(var82, "buyNewFilter");
         ViewExtensionsKt.hide((View)var82);
         MaterialButton var83 = var43.btnSubscribe;
         Intrinsics.checkNotNullExpressionValue(var83, "btnSubscribe");
         ViewExtensionsKt.hide((View)var83);
         var83 = var43.btnPurchase;
         Intrinsics.checkNotNullExpressionValue(var83, "btnPurchase");
         ViewExtensionsKt.hide((View)var83);
         TextView var44 = var43.discountHint;
         Intrinsics.checkNotNullExpressionValue(var44, "discountHint");
         ViewExtensionsKt.hide((View)var44);
         Unit var45 = Unit.INSTANCE;
      } else if (this.onlyBuy) {
         DialogfragmentDeviceNFilterBinding var85 = this.binding;
         DialogfragmentDeviceNFilterBinding var46 = var85;
         if (var85 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var46 = null;
         }

         Group var86 = var46.replaceGroup;
         Intrinsics.checkNotNullExpressionValue(var86, "replaceGroup");
         ViewExtensionsKt.hide((View)var86);
         TextView var87 = var46.availableFilters;
         Intrinsics.checkNotNullExpressionValue(var87, "availableFilters");
         ViewExtensionsKt.hide((View)var87);
         RecyclerView var88 = var46.filterList;
         Intrinsics.checkNotNullExpressionValue(var88, "filterList");
         ViewExtensionsKt.hide((View)var88);
         MaterialButton var89 = var46.btnAntiFake;
         Intrinsics.checkNotNullExpressionValue(var89, "btnAntiFake");
         ViewExtensionsKt.hide((View)var89);
         TextView var47 = var46.buyNewFilter;
         Intrinsics.checkNotNullExpressionValue(var47, "buyNewFilter");
         ViewExtensionsKt.hide((View)var47);
         Unit var48 = Unit.INSTANCE;
      }

      this.getViewModel().getResetFilterLifeResult().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNFilterDialogFragment$$ExternalSyntheticLambda10(this)) {
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

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      DialogfragmentDeviceNFilterBinding var3 = this.binding;
      DialogfragmentDeviceNFilterBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNFilterDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_ONLY_BUY", "", "EXTRA_TYPE", "EXTRA_FROM_NOTIFICATION", "shouldDismiss", "", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNFilterDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onlyBuy", "fromNotification", "devicedetails_otherRelease"},
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
      public static DeviceNFilterDialogFragment newInstance$default(Companion var0, Device var1, String var2, DeviceFilterType var3, boolean var4, boolean var5, int var6, Object var7) {
         if ((var6 & 16) != 0) {
            var5 = false;
         }

         return var0.newInstance(var1, var2, var3, var4, var5);
      }

      public final boolean getShouldDismiss() {
         return DeviceNFilterDialogFragment.shouldDismiss;
      }

      public final DeviceNFilterDialogFragment newInstance(Device var1, String var2, DeviceFilterType var3, boolean var4, boolean var5) {
         Intrinsics.checkNotNullParameter(var3, "type");
         String var6;
         if (var5) {
            var6 = "notifications_filter";
         } else {
            var6 = "device_details_filter";
         }

         DeviceNFilterDialogFragment var7 = new DeviceNFilterDialogFragment();
         var7.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("screen_name", var6), TuplesKt.to("device", var1), TuplesKt.to("device_sku", var2), TuplesKt.to("EXTRA_TYPE", var3.name()), TuplesKt.to("EXTRA_ONLY_BUY", var4), TuplesKt.to("extra_from_notification", var5)}));
         return var7;
      }

      public final void setShouldDismiss(boolean var1) {
         DeviceNFilterDialogFragment.shouldDismiss = var1;
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
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[DeviceFilterType.values().length];

         try {
            var0[DeviceFilterType.FILTER.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceFilterType.WICK.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceFilterType.REFRESHER.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[FilterLifeResetResult.values().length];

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

         $EnumSwitchMapping$1 = var0;
      }
   }
}
