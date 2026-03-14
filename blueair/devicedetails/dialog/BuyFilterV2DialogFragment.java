package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2Binding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.adapter.FilterTypeAdapter;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.R.color;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

@Metadata(
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020%H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"},
   d2 = {"Lcom/blueair/devicedetails/dialog/BuyFilterV2DialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentBuyFilterV2Binding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/FilterTypeAdapter;", "device", "Lcom/blueair/core/model/HasSKU;", "deviceSku", "preferFilterName", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "replaceNewline", "source", "updateButtonVisibility", "filter", "Lcom/blueair/core/model/FilterInfo;", "subscribeFor", "purchase", "getOrderFilterTitle", "filterType", "onStart", "showProgress", "shouldShowProgress", "onResume", "onPause", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BuyFilterV2DialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_FILTER_NAME = "EXTRA_FILTER_NAME";
   private static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
   private static final String EXTRA_TYPE = "EXTRA_TYPE";
   private static boolean shouldDismiss;
   private DialogfragmentBuyFilterV2Binding binding;
   private HasSKU device;
   private String deviceSku;
   private FilterTypeAdapter filterAdapter;
   private boolean fromNotification;
   private String preferFilterName;
   private final String screenName = "device_filter_buy";
   private DeviceFilterType type;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$ALOsj8ShsTCNes1ZRMl_sicOsd4(BuyFilterV2DialogFragment var0, View var1) {
      onViewCreated$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$FNQKowHzDicnn233OVuX3hjoNRA(BuyFilterV2DialogFragment var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$HF27fuzLEdg6XKAwqAb88v1lh_s/* $FF was: $r8$lambda$HF27fuzLEdg6XKAwqAb88v1lh-s*/(RecyclerView var0, Ref.IntRef var1) {
      onViewCreated$lambda$11$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$l49mjjAgR8bXrMbsXZFGxxGWyqY(BuyFilterV2DialogFragment var0, View var1) {
      onViewCreated$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mN_6DJRg__GsTRGeQyXOWxqo_rw/* $FF was: $r8$lambda$mN_6DJRg_-GsTRGeQyXOWxqo-rw*/(BuyFilterV2DialogFragment var0, FilterInfo var1) {
      return onViewCreated$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pZ8NmlHVowNNPyeEshDgCMQMyWA(BuyFilterV2DialogFragment var0, int var1, FilterInfo var2) {
      return onViewCreated$lambda$6(var0, var1, var2);
   }

   public BuyFilterV2DialogFragment() {
      this.type = DeviceFilterType.FILTER;
   }

   private final String getOrderFilterTitle(DeviceFilterType var1) {
      int var2 = BuyFilterV2DialogFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               String var5 = this.getString(R.string.order_refresher);
               Intrinsics.checkNotNull(var5);
               return var5;
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            String var4 = this.getString(R.string.order_wick);
            Intrinsics.checkNotNull(var4);
            return var4;
         }
      } else {
         String var3 = this.getString(R.string.order_filter);
         Intrinsics.checkNotNull(var3);
         return var3;
      }
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

   private static final void onViewCreated$lambda$11$lambda$10(RecyclerView var0, Ref.IntRef var1) {
      var0.smoothScrollToPosition(var1.element);
   }

   private static final void onViewCreated$lambda$2(BuyFilterV2DialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final Unit onViewCreated$lambda$5(BuyFilterV2DialogFragment var0, FilterInfo var1) {
      Intrinsics.checkNotNullParameter(var1, "filter");
      FragmentManager var5 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var5.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var5.isStateSaved()) {
         ConfirmationDialogLeftAligned.Companion var6 = ConfirmationDialogLeftAligned.Companion;
         int var3 = var1.getSummary();
         int var2 = R.string.confirmation_positive_default;
         String var4 = var1.getName().getValue();
         String var7 = var4;
         if (var4 == null) {
            var7 = "";
         }

         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var6, 0, (Integer)null, var3, var2, (Integer)null, false, false, false, false, (String[])null, var0.replaceNewline(var7), (Integer)null, (Function1)null, 7008, (Object)null)).show(var5, "ConfirmationDialogLeftAligned");
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$6(BuyFilterV2DialogFragment var0, int var1, FilterInfo var2) {
      Intrinsics.checkNotNullParameter(var2, "filter");
      FilterTypeAdapter var5 = var0.filterAdapter;
      DialogfragmentBuyFilterV2Binding var4 = null;
      FilterTypeAdapter var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
         var3 = null;
      }

      DialogfragmentBuyFilterV2Binding var7 = var0.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
      } else {
         var4 = var7;
      }

      RecyclerView var6 = var4.filterList;
      Intrinsics.checkNotNullExpressionValue(var6, "filterList");
      var3.selectFilter(var1, var6);
      var0.updateButtonVisibility(var2);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$7(BuyFilterV2DialogFragment var0, View var1) {
      FilterTypeAdapter var2 = var0.filterAdapter;
      FilterTypeAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
         var3 = null;
      }

      var0.subscribeFor(var3.getSelectedFilter());
   }

   private static final void onViewCreated$lambda$8(BuyFilterV2DialogFragment var0, View var1) {
      FilterTypeAdapter var2 = var0.filterAdapter;
      FilterTypeAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
         var3 = null;
      }

      var0.purchase(var3.getSelectedFilter());
   }

   private final void purchase(FilterInfo var1) {
      if (var1 != null) {
         HasSKU var2 = this.device;
         if (var2 != null) {
            DeviceDetailsViewModel var4 = this.getViewModel();
            Device var5 = var2;
            DeviceFilterType var6 = var1.getType();
            String var3 = var1.getName().getValue();
            String var7 = var3;
            if (var3 == null) {
               var7 = "";
            }

            var4.analyticsLogFilterClickEvent(var5, true, false, var6, var7, this.fromNotification);
         }

         String var9 = DeviceConfigProvider.INSTANCE.getIpConfigValue(var1.getLinkPurchase());
         if (var9 != null) {
            DeviceConfigProvider var8 = DeviceConfigProvider.INSTANCE;
            Context var10 = this.requireContext();
            Intrinsics.checkNotNullExpressionValue(var10, "requireContext(...)");
            var8.openFilterUrl(var10, var9, this.getOrderFilterTitle(var1.getType()));
         }
      }

   }

   private final String replaceNewline(String var1) {
      CharSequence var2 = (CharSequence)var1;
      return (new Regex("\\s*\\R\\s*")).replace(var2, " ");
   }

   private final void subscribeFor(FilterInfo var1) {
      if (var1 != null) {
         HasSKU var2 = this.device;
         if (var2 != null) {
            DeviceDetailsViewModel var4 = this.getViewModel();
            Device var5 = var2;
            DeviceFilterType var6 = var1.getType();
            String var3 = var1.getName().getValue();
            String var7 = var3;
            if (var3 == null) {
               var7 = "";
            }

            var4.analyticsLogFilterClickEvent(var5, false, false, var6, var7, this.fromNotification);
         }

         String var8 = DeviceConfigProvider.INSTANCE.getIpConfigValue(var1.getLinkSubscribe());
         if (var8 != null) {
            DeviceConfigProvider var9 = DeviceConfigProvider.INSTANCE;
            Context var10 = this.requireContext();
            Intrinsics.checkNotNullExpressionValue(var10, "requireContext(...)");
            var9.openFilterUrl(var10, var8, this.getOrderFilterTitle(var1.getType()));
         }
      }

   }

   private final void updateButtonVisibility(FilterInfo var1) {
      CharSequence var6 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var1.getLinkSubscribe());
      byte var4 = 1;
      boolean var2;
      if (var6 != null && var6.length() != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      CharSequence var8 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var1.getLinkPurchase());
      boolean var3 = (boolean)var4;
      if (var8 != null) {
         if (var8.length() == 0) {
            var3 = (boolean)var4;
         } else {
            var3 = false;
         }
      }

      DialogfragmentBuyFilterV2Binding var7 = this.binding;
      Object var23 = null;
      DialogfragmentBuyFilterV2Binding var9 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      MaterialButton var10 = var9.btnSubscribe;
      Intrinsics.checkNotNullExpressionValue(var10, "btnSubscribe");
      View var11 = (View)var10;
      byte var5 = 8;
      if (!var2) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      var11.setVisibility(var4);
      var7 = this.binding;
      DialogfragmentBuyFilterV2Binding var12 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      TextView var13 = var12.discountHint;
      Intrinsics.checkNotNullExpressionValue(var13, "discountHint");
      View var14 = (View)var13;
      if (!var2) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      var14.setVisibility(var4);
      var7 = this.binding;
      DialogfragmentBuyFilterV2Binding var15 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var15 = null;
      }

      MaterialButton var16 = var15.btnPurchase;
      Intrinsics.checkNotNullExpressionValue(var16, "btnPurchase");
      View var17 = (View)var16;
      var4 = var5;
      if (!var3) {
         var4 = 0;
      }

      var17.setVisibility(var4);
      if (!var3) {
         DialogfragmentBuyFilterV2Binding var18 = this.binding;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var18 = (DialogfragmentBuyFilterV2Binding)var23;
         }

         MaterialButton var19 = var18.btnPurchase;
         if (!var2) {
            var19.setStrokeColor(AppCompatResources.getColorStateList(var19.getContext(), R.color.timberwolf));
            var19.setRippleColor(AppCompatResources.getColorStateList(var19.getContext(), R.color.lightbluegrey));
            var19.setBackgroundTintList(AppCompatResources.getColorStateList(var19.getContext(), R.color.button_secondary));
            var19.setTextColor(AppCompatResources.getColorStateList(var19.getContext(), R.color.button_secondary_text));
            return;
         }

         var19.setStrokeColor(ColorStateList.valueOf(0));
         var19.setRippleColor(AppCompatResources.getColorStateList(var19.getContext(), color.mtrl_btn_ripple_color));
         var19.setBackgroundTintList(AppCompatResources.getColorStateList(var19.getContext(), R.color.button_primary));
         var19.setTextColor(AppCompatResources.getColorStateList(var19.getContext(), R.color.white));
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

      Bundle var11 = this.requireArguments();
      this.device = (HasSKU)var11.getParcelable("device");
      this.deviceSku = var11.getString("device_sku");
      this.preferFilterName = var11.getString("EXTRA_FILTER_NAME");
      String var4 = var11.getString("EXTRA_TYPE", "FILTER");
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      this.type = DeviceFilterType.valueOf(var4);
      this.fromNotification = var11.getBoolean("extra_from_notification", false);
      DialogfragmentBuyFilterV2Binding var5 = DialogfragmentBuyFilterV2Binding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      DialogfragmentBuyFilterV2Binding var8 = this.binding;
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
      }

   }

   public void onStart() {
      super.onStart();
      int var1 = (int)TypedValueCompat.dpToPx(468.0F, this.getResources().getDisplayMetrics());
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Window var3 = var2.getWindow();
         if (var3 != null) {
            var3.setLayout(-1, var1);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentBuyFilterV2Binding var6 = this.binding;
      Object var5 = null;
      Object var20 = null;
      DialogfragmentBuyFilterV2Binding var8 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      var8.closeBtn.setOnClickListener(new BuyFilterV2DialogFragment$$ExternalSyntheticLambda0(this));
      DeviceFilterType var9 = this.type;
      int var4 = BuyFilterV2DialogFragment.WhenMappings.$EnumSwitchMapping$0[var9.ordinal()];
      int var3 = 1;
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var6 = this.binding;
            DialogfragmentBuyFilterV2Binding var10 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = null;
            }

            var10.title.setText(R.string.select_refresher_type);
         } else {
            var6 = this.binding;
            DialogfragmentBuyFilterV2Binding var11 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var11 = null;
            }

            var11.title.setText(R.string.select_wick_filter_type);
         }
      } else {
         var6 = this.binding;
         DialogfragmentBuyFilterV2Binding var12 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.title.setText(R.string.select_air_filter_type);
      }

      HasSKU var13 = this.device;
      if (var13 == null || !DeviceKt.shouldMergeFilter(var13)) {
         var3 = 0;
      }

      if (var3) {
         var6 = this.binding;
         DialogfragmentBuyFilterV2Binding var14 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var14 = null;
         }

         var14.title.setText(R.string.select_filters_accessories);
      }

      DeviceConfigProvider var7 = DeviceConfigProvider.INSTANCE;
      String var38 = this.getSku();
      DeviceFilterType var15;
      if (var3) {
         var15 = null;
      } else {
         var15 = this.type;
      }

      label109: {
         FilterConfig var16 = var7.getFilterConfig(var38, var15);
         if (var16 != null) {
            var17 = var16.getFilters();
            if (var17 != null) {
               break label109;
            }
         }

         var17 = CollectionsKt.emptyList();
      }

      if (var17.isEmpty()) {
         DialogfragmentBuyFilterV2Binding var18 = this.binding;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var18 = (DialogfragmentBuyFilterV2Binding)var20;
         }

         RecyclerView var29 = var18.filterList;
         Intrinsics.checkNotNullExpressionValue(var29, "filterList");
         ViewExtensionsKt.hide((View)var29);
         MaterialButton var30 = var18.btnPurchase;
         Intrinsics.checkNotNullExpressionValue(var30, "btnPurchase");
         ViewExtensionsKt.hide((View)var30);
         var30 = var18.btnSubscribe;
         Intrinsics.checkNotNullExpressionValue(var30, "btnSubscribe");
         ViewExtensionsKt.hide((View)var30);
         TextView var19 = var18.discountHint;
         Intrinsics.checkNotNullExpressionValue(var19, "discountHint");
         ViewExtensionsKt.hide((View)var19);
      } else {
         this.filterAdapter = new FilterTypeAdapter(new BuyFilterV2DialogFragment$$ExternalSyntheticLambda1(this), new BuyFilterV2DialogFragment$$ExternalSyntheticLambda2(this));
         DialogfragmentBuyFilterV2Binding var39 = this.binding;
         DialogfragmentBuyFilterV2Binding var21 = var39;
         if (var39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var21 = null;
         }

         RecyclerView var46 = var21.filterList;
         FilterTypeAdapter var40 = this.filterAdapter;
         FilterTypeAdapter var22 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
            var22 = null;
         }

         var46.setAdapter(var22);
         var40 = this.filterAdapter;
         var22 = var40;
         if (var40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
            var22 = null;
         }

         var22.setFilters(var17);
         DialogfragmentBuyFilterV2Binding var42 = this.binding;
         DialogfragmentBuyFilterV2Binding var24 = var42;
         if (var42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var24 = null;
         }

         var24.btnSubscribe.setOnClickListener(new BuyFilterV2DialogFragment$$ExternalSyntheticLambda3(this));
         var42 = this.binding;
         var24 = var42;
         if (var42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var24 = null;
         }

         var24.btnPurchase.setOnClickListener(new BuyFilterV2DialogFragment$$ExternalSyntheticLambda4(this));
         Ref.IntRef var47 = new Ref.IntRef();
         Iterator var26 = var17.iterator();
         var3 = 0;

         while(true) {
            if (!var26.hasNext()) {
               var3 = -1;
               break;
            }

            if (Intrinsics.areEqual(((FilterInfo)var26.next()).getName().getValue(), this.preferFilterName)) {
               break;
            }

            ++var3;
         }

         var47.element = var3;
         var42 = this.binding;
         DialogfragmentBuyFilterV2Binding var27 = var42;
         if (var42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var27 = null;
         }

         RecyclerView var45 = var27.filterList;
         if (var47.element == -1) {
            var47.element = 0;
         }

         FilterTypeAdapter var28 = this.filterAdapter;
         if (var28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
            var28 = (FilterTypeAdapter)var5;
         }

         var3 = var47.element;
         Intrinsics.checkNotNull(var45);
         var28.selectFilter(var3, var45);
         this.updateButtonVisibility((FilterInfo)var17.get(var47.element));
         if (var47.element > 0) {
            var45.post(new BuyFilterV2DialogFragment$$ExternalSyntheticLambda5(var45, var47));
         }

      }
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      DialogfragmentBuyFilterV2Binding var3 = this.binding;
      DialogfragmentBuyFilterV2Binding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"},
      d2 = {"Lcom/blueair/devicedetails/dialog/BuyFilterV2DialogFragment$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "EXTRA_FILTER_NAME", "EXTRA_FROM_NOTIFICATION", "shouldDismiss", "", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "newInstance", "Lcom/blueair/devicedetails/dialog/BuyFilterV2DialogFragment;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "preferFilterName", "devicedetails_otherRelease"},
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
      public static BuyFilterV2DialogFragment newInstance$default(Companion var0, Device var1, String var2, DeviceFilterType var3, boolean var4, String var5, int var6, Object var7) {
         if ((var6 & 8) != 0) {
            var4 = false;
         }

         if ((var6 & 16) != 0) {
            var5 = null;
         }

         return var0.newInstance(var1, var2, var3, var4, var5);
      }

      public final boolean getShouldDismiss() {
         return BuyFilterV2DialogFragment.shouldDismiss;
      }

      public final BuyFilterV2DialogFragment newInstance(Device var1, String var2, DeviceFilterType var3, boolean var4, String var5) {
         Intrinsics.checkNotNullParameter(var3, "type");
         BuyFilterV2DialogFragment var6 = new BuyFilterV2DialogFragment();
         var6.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1), TuplesKt.to("device_sku", var2), TuplesKt.to("EXTRA_TYPE", var3.name()), TuplesKt.to("extra_from_notification", var4), TuplesKt.to("EXTRA_FILTER_NAME", var5)}));
         return var6;
      }

      public final void setShouldDismiss(boolean var1) {
         BuyFilterV2DialogFragment.shouldDismiss = var1;
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
         int[] var0 = new int[DeviceFilterType.values().length];

         try {
            var0[DeviceFilterType.FILTER.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceFilterType.WICK.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceFilterType.REFRESHER.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
