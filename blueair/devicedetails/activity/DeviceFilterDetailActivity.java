package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.core.util.LinkUtils;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.devicedetails.databinding.ActivityDeviceFilterDetailBinding;
import com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.adapter.FilterTypeAdapter;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u0010,\u001a\u00020*H\u0002J\b\u00102\u001a\u00020#H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u001eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"},
   d2 = {"Lcom/blueair/devicedetails/activity/DeviceFilterDetailActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceFilterDetailBinding;", "filterAdapter", "Lcom/blueair/viewcore/adapter/FilterTypeAdapter;", "replaceFilterLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "filterConfig", "Lcom/blueair/core/model/FilterConfig;", "hasBuyFilterLink", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configureView", "observeViewModel", "hydrateFilterLife", "getResetTitleRes", "", "getResetMsgRes", "leftLifePercentage", "hydrateDeviceFilters", "replaceNewline", "source", "hydrateResetFilterCard", "hydrateFilterInfo", "showDeviceOfflinePrompt", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterDetailActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
   private static final String EXTRA_TYPE = "EXTRA_TYPE";
   private String _screenName;
   private ActivityDeviceFilterDetailBinding binding;
   private Device device;
   private String deviceSku;
   private FilterTypeAdapter filterAdapter;
   private FilterConfig filterConfig;
   private boolean fromNotification;
   private boolean hasBuyFilterLink;
   private ActivityResultLauncher replaceFilterLauncher;
   private DeviceFilterType type;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$01MJ_MxF6PXe2bwehl_CWYO7Wg0/* $FF was: $r8$lambda$01MJ_MxF6PXe2bwehl-CWYO7Wg0*/(DeviceFilterDetailActivity var0, View var1) {
      hydrateDeviceFilters$lambda$27$lambda$26$lambda$25(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4_FAfHBKV9WPjHrExuGmiKQ0zCA(DeviceFilterDetailActivity var0, View var1) {
      configureView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4hmM9tJ_Qb29KU3kBjN3D6XkiG0/* $FF was: $r8$lambda$4hmM9tJ-Qb29KU3kBjN3D6XkiG0*/(ActivityResult var0) {
      onCreate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$D2pLTrnWhd5st0J3zhLrnIZYA2A(DeviceFilterDetailActivity var0, View var1) {
      configureView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$LtsNok9mBPjW4llyQZ1Y67u9H4Q(DeviceFilterDetailActivity var0, FilterLifeResetResult var1) {
      return observeViewModel$lambda$13$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Na_6ciLZj9SFROTygI1_O_hBSO0/* $FF was: $r8$lambda$Na-6ciLZj9SFROTygI1-O-hBSO0*/(DeviceFilterDetailActivity var0, Device var1) {
      return observeViewModel$lambda$13$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cjbzmCahwjXgOUm_IrciMR6uxno(DeviceFilterDetailActivity var0, View var1) {
      configureView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ewrn3WLT95x41uoh_mpp_yehk2g(DeviceFilterDetailActivity var0, FilterInfo var1) {
      return hydrateDeviceFilters$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$k7zwAPJfShl_k6j_FaE1La8KYYs/* $FF was: $r8$lambda$k7zwAPJfShl-k6j_FaE1La8KYYs*/(DeviceFilterDetailActivity var0, DeviceDetailsState var1) {
      return observeViewModel$lambda$13$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$lNdxd_J4tDLv4rlmGylAInAFo_c(DeviceFilterDetailActivity var0, String var1, View var2) {
      hydrateResetFilterCard$lambda$28(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mOBigrkr_0HXGlAx_ZRxuU_yFMI(DeviceFilterDetailActivity var0, int var1, FilterInfo var2) {
      return hydrateDeviceFilters$lambda$24(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pNBXr4C_eqqv64k2krN1fvrC7KQ/* $FF was: $r8$lambda$pNBXr4C-eqqv64k2krN1fvrC7KQ*/(DeviceFilterDetailActivity var0, View var1) {
      configureView$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$sx01MBEGtY8GU568NPI8UG0W4SY(DeviceFilterDetailActivity var0, View var1) {
      configureView$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$u__AxMmqRFDEtw0bcilmFUKtc_k/* $FF was: $r8$lambda$u-_AxMmqRFDEtw0bcilmFUKtc_k*/(DeviceFilterDetailActivity var0, boolean var1) {
      return hydrateFilterLife$lambda$20$lambda$19$lambda$18$lambda$16$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uw6K5cdxJBZu0F0FM8ILNr7GmCQ(boolean var0, DeviceFilterDetailActivity var1, boolean var2, Integer var3, View var4) {
      hydrateFilterLife$lambda$20$lambda$19$lambda$18(var0, var1, var2, var3, var4);
   }

   public DeviceFilterDetailActivity() {
      ComponentActivity var2 = (ComponentActivity)this;
      Function0 var1 = new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceDetailsViewModel.class), new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var1, new Function0((Function0)null, var2) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      this.type = DeviceFilterType.FILTER;
   }

   private final void configureView() {
      ActivityDeviceFilterDetailBinding var4 = this.binding;
      Object var3 = null;
      ActivityDeviceFilterDetailBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.closeBtn.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda1(this));
      var4 = this.binding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.btnBack.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda2(this));
      var4 = this.binding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.btnGetInstructions.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda3(this));
      var4 = this.binding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.btnBuy.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda4(this));
      DeviceConfigProvider var18 = DeviceConfigProvider.INSTANCE;
      String var5 = this.getSku();
      Device var9 = this.device;
      DeviceFilterType var10;
      if (var9 != null && DeviceKt.shouldMergeFilter(var9)) {
         var10 = null;
      } else {
         var10 = this.type;
      }

      this.filterConfig = var18.getFilterConfig(var5, var10);
      this.hasBuyFilterLink = DeviceConfigProvider.INSTANCE.hasBuyFilterLink(this.filterConfig);
      ActivityDeviceFilterDetailBinding var19 = this.binding;
      ActivityDeviceFilterDetailBinding var11 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      MaterialButton var12 = var11.btnBuy;
      Intrinsics.checkNotNullExpressionValue(var12, "btnBuy");
      View var13 = (View)var12;
      byte var1;
      if (DeviceConfigProvider.INSTANCE.hasBuyFilterLink(DeviceConfigProvider.INSTANCE.getFilterConfig(this.getSku(), this.type))) {
         var1 = 0;
      } else {
         var1 = 8;
      }

      var13.setVisibility(var1);
      this.hydrateFilterLife();
      this.hydrateDeviceFilters();
      this.hydrateResetFilterCard();
      ActivityDeviceFilterDetailBinding var14 = this.binding;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = (ActivityDeviceFilterDetailBinding)var3;
      }

      var14.ivInfo.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda5(this));
   }

   private static final void configureView$lambda$2(DeviceFilterDetailActivity var0, View var1) {
      var0.finish();
   }

   private static final void configureView$lambda$3(DeviceFilterDetailActivity var0, View var1) {
      var0.finish();
   }

   private static final void configureView$lambda$4(DeviceFilterDetailActivity var0, View var1) {
      ActivityResultLauncher var3 = var0.replaceFilterLauncher;
      ActivityResultLauncher var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("replaceFilterLauncher");
         var2 = null;
      }

      ReplaceFilterActivity.Companion var5 = ReplaceFilterActivity.Companion;
      Context var4 = var1.getContext();
      Intrinsics.checkNotNullExpressionValue(var4, "getContext(...)");
      var2.launch(var5.getLaunchIntent(var4, var0.device, var0.deviceSku, var0.type));
   }

   private static final void configureView$lambda$6(DeviceFilterDetailActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, var0.device, var0.deviceSku, var0.type, var0.fromNotification, (String)null, 16, (Object)null)).show(var2, "BuyFilterV2DialogFragment");
      }

   }

   private static final void configureView$lambda$8(DeviceFilterDetailActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var2.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_real_track_tech, (Integer)null, R.string.real_track_instruction, R.string.confirmation_positive_default, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var2, "ConfirmationDialogLeftAligned");
      }

   }

   private final int getResetMsgRes(int var1) {
      DeviceFilterType var3 = this.type;
      int var2 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$1[var3.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               return var1 > 10 ? R.string.reset_refresher_msg_normal : R.string.reset_refresher_msg_lower;
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            return var1 > 10 ? R.string.reset_wick_filter_life_msg_normal : R.string.reset_wick_filter_life_msg_lower;
         }
      } else {
         return var1 > 10 ? R.string.reset_filter_life_msg_normal : R.string.reset_filter_life_msg_lower;
      }
   }

   private final int getResetTitleRes() {
      DeviceFilterType var2 = this.type;
      int var1 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$1[var2.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 == 3) {
               return R.string.confirm_refresher_reset;
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            return R.string.confirm_reset_wick_filter;
         }
      } else {
         return R.string.confirm_reset;
      }
   }

   private final String getSku() {
      HasSKU var1 = this.device;
      if (var1 instanceof HasSKU) {
         var1 = var1;
      } else {
         var1 = null;
      }

      if (var1 != null) {
         String var4 = var1.getSku();
         if (var4 != null) {
            return var4;
         }
      }

      String var2 = this.deviceSku;
      String var5 = var2;
      if (var2 == null) {
         var5 = "";
      }

      return var5;
   }

   private final DeviceDetailsViewModel getViewModel() {
      return (DeviceDetailsViewModel)this.viewModel$delegate.getValue();
   }

   private final void hydrateDeviceFilters() {
      this.filterAdapter = new FilterTypeAdapter(new DeviceFilterDetailActivity$$ExternalSyntheticLambda0(this), new DeviceFilterDetailActivity$$ExternalSyntheticLambda6(this));
      if (this.device != null) {
         List var5;
         label31: {
            FilterConfig var1 = this.filterConfig;
            if (var1 != null) {
               List var2 = var1.getFilters();
               var5 = var2;
               if (var2 != null) {
                  break label31;
               }
            }

            var5 = CollectionsKt.emptyList();
         }

         if (!((Collection)var5).isEmpty()) {
            FilterTypeAdapter var3 = this.filterAdapter;
            FilterTypeAdapter var8 = var3;
            if (var3 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
               var8 = null;
            }

            var8.setFilters(var5);
            ActivityDeviceFilterDetailBinding var9 = this.binding;
            ActivityDeviceFilterDetailBinding var6 = var9;
            if (var9 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var6 = null;
            }

            MaterialButton var10 = var6.btnVisit;
            Intrinsics.checkNotNullExpressionValue(var10, "btnVisit");
            ViewExtensionsKt.show((View)var10, this.hasBuyFilterLink ^ true);
            if (StringsKt.contains$default((CharSequence)LinkUtils.INSTANCE.getVisitBlueairLinkFromCountryCode(DeviceConfigProvider.INSTANCE.getIp()), (CharSequence)"blueair.cn", false, 2, (Object)null)) {
               var6.btnVisit.setText((CharSequence)StringsKt.replace$default(var6.btnVisit.getText().toString(), ".com", ".cn", false, 4, (Object)null));
            }

            var6.btnVisit.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda7(this));
            RecyclerView var4 = var6.filterList;
            var3 = this.filterAdapter;
            FilterTypeAdapter var11 = var3;
            if (var3 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("filterAdapter");
               var11 = null;
            }

            var4.setAdapter(var11);
            TextView var12 = var6.availableFilters;
            Intrinsics.checkNotNullExpressionValue(var12, "availableFilters");
            ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
            RecyclerView var7 = var6.filterList;
            Intrinsics.checkNotNullExpressionValue(var7, "filterList");
            ViewExtensionsKt.show$default((View)var7, false, 1, (Object)null);
         }
      }

   }

   private static final Unit hydrateDeviceFilters$lambda$22(DeviceFilterDetailActivity var0, FilterInfo var1) {
      Intrinsics.checkNotNullParameter(var1, "filter");
      FragmentManager var5 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getSupportFragmentManager(...)");
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

   private static final Unit hydrateDeviceFilters$lambda$24(DeviceFilterDetailActivity var0, int var1, FilterInfo var2) {
      Intrinsics.checkNotNullParameter(var2, "filter");
      if (var0.hasBuyFilterLink) {
         FragmentManager var3 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !var3.isStateSaved()) {
            ((DialogFragment)BuyFilterV2DialogFragment.Companion.newInstance(var0.device, var0.deviceSku, var0.type, var0.fromNotification, var2.getName().getValue())).show(var3, "BuyFilterV2DialogFragment");
         }
      }

      return Unit.INSTANCE;
   }

   private static final void hydrateDeviceFilters$lambda$27$lambda$26$lambda$25(DeviceFilterDetailActivity var0, View var1) {
      Intent var2 = (new Intent("blueair.action.info")).putExtra("display_key", 9).putExtra("toolbar_key", var0.getString(R.string.app_name));
      Intrinsics.checkNotNullExpressionValue(var2, "putExtra(...)");
      var0.startActivity(var2);
   }

   private final void hydrateFilterInfo(int var1) {
      ActivityDeviceFilterDetailBinding var5 = this.binding;
      ActivityDeviceFilterDetailBinding var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.tvProgress.setText((CharSequence)this.getString(R.string.percentage_left, new Object[]{var1}));
      var5 = this.binding;
      var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.progressIndicator.setProgress(var1);
      if (var1 > 10) {
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.tvProgress.setPadding(0, 0, 0, 0);
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.tvProgress.setBackground((Drawable)null);
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.tvProgress.setTextSize(14.0F);
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.bgFilterInfo.setBackgroundResource(R.drawable.rounded_rectangle_dark_5_r16);
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.progressIndicator.setIndicatorColor(new int[]{this.getColor(R.color.colorPrimary)});
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         AppCompatTextView var19 = var4.tvChangeFilter;
         Intrinsics.checkNotNullExpressionValue(var19, "tvChangeFilter");
         ViewExtensionsKt.hide((View)var19);
         Set var6 = SetsKt.setOf(new DeviceType[]{DeviceType.Blue40.INSTANCE, DeviceType.Dehumidifier.INSTANCE, DeviceType.MiniRestful.INSTANCE, DeviceType.Combo2in120.INSTANCE, DeviceType.Pet20.INSTANCE});
         var5 = this.binding;
         ActivityDeviceFilterDetailBinding var20 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var20 = null;
         }

         AppCompatTextView var48 = var20.tvFilterInfo;
         DeviceFilterType var21 = this.type;
         var1 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$1[var21.ordinal()];
         String var22;
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var22 = this.getString(R.string.change_refresher_recommend);
            } else {
               Device var23 = this.device;
               if (!(var23 instanceof DeviceHumidifier) && !(var23 instanceof DeviceCombo2in1)) {
                  var1 = R.string.change_wick_filter_recommend;
               } else {
                  var1 = R.string.change_wick_filter_recommend_v2;
               }

               var22 = this.getString(var1);
            }
         } else {
            if (!var6.contains(DeviceType.Companion.fromSkuCompat(this.getSku())) && !SkuConfigurationManager.INSTANCE.getConfig().skuFilterLifeIs9To12(this.getSku())) {
               var1 = R.string.change_filter_recommend;
            } else {
               var1 = R.string.change_filter_recommend_v2;
            }

            var22 = this.getString(var1);
         }

         var48.setText((CharSequence)var22);
      } else {
         int var3 = (int)TypedValueCompat.dpToPx(8.0F, this.getResources().getDisplayMetrics());
         var5 = this.binding;
         var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         TextView var25 = var4.tvProgress;
         int var2 = var3 / 2;
         var25.setPadding(var3, var2, var3, var2);
         var5 = this.binding;
         ActivityDeviceFilterDetailBinding var26 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.tvProgress.setBackgroundResource(R.drawable.rounded_rectangle_warning_r8);
         var5 = this.binding;
         var26 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.tvProgress.setTextSize(12.0F);
         var5 = this.binding;
         var26 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.bgFilterInfo.setBackgroundResource(R.drawable.rounded_rectangle_warning_r16);
         var5 = this.binding;
         var26 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         var26.progressIndicator.setIndicatorColor(new int[]{this.getColor(R.color.fill_warning)});
         var5 = this.binding;
         var26 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = null;
         }

         AppCompatTextView var31 = var26.tvChangeFilter;
         Intrinsics.checkNotNullExpressionValue(var31, "tvChangeFilter");
         ViewExtensionsKt.show$default((View)var31, false, 1, (Object)null);
         var5 = this.binding;
         ActivityDeviceFilterDetailBinding var32 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var32 = null;
         }

         AppCompatTextView var56 = var32.tvFilterInfo;
         DeviceFilterType var33 = this.type;
         var2 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$1[var33.ordinal()];
         String var35;
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               if (var1 > 0) {
                  var35 = this.getString(R.string.change_refresher_warning, new Object[]{var1});
               } else {
                  var35 = this.getString(R.string.change_refresher_expired);
               }
            } else if (var1 > 0) {
               var35 = this.getString(R.string.change_wick_filter_warning, new Object[]{var1});
            } else {
               var35 = this.getString(R.string.change_wick_filter_expired);
            }
         } else if (var1 > 0) {
            var35 = this.getString(R.string.change_filter_warning, new Object[]{var1});
         } else {
            Device var34 = this.device;
            if (var34 != null && DeviceKt.isAfterG4(var34)) {
               var1 = R.string.change_filter_expired;
            } else {
               var1 = R.string.change_filter_expired_v2;
            }

            var35 = this.getString(var1);
         }

         var56.setText((CharSequence)var35);
      }

      var5 = this.binding;
      var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      AppCompatTextView var37 = var4.tvFilterInfo;
      Intrinsics.checkNotNullExpressionValue(var37, "tvFilterInfo");
      ViewExtensionsKt.show$default((View)var37, false, 1, (Object)null);
      var5 = this.binding;
      ActivityDeviceFilterDetailBinding var38 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var38 = null;
      }

      View var39 = var38.bgFilterInfo;
      Intrinsics.checkNotNullExpressionValue(var39, "bgFilterInfo");
      ViewExtensionsKt.show$default(var39, false, 1, (Object)null);
   }

   private final void hydrateFilterLife() {
      DeviceFilterType var5 = this.type;
      int var1 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$1[var5.ordinal()];
      Object var7 = null;
      Object var8 = null;
      boolean var3 = true;
      Integer var19;
      if (var1 != 1) {
         label179: {
            if (var1 != 2) {
               if (var1 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               ActivityDeviceFilterDetailBinding var52 = this.binding;
               ActivityDeviceFilterDetailBinding var20 = var52;
               if (var52 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var20 = null;
               }

               var20.title.setText(R.string.label_water_refresher);
               var52 = this.binding;
               var20 = var52;
               if (var52 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var20 = null;
               }

               var20.tvFilterLife.setText(R.string.label_water_refresher);
               var52 = this.binding;
               var20 = var52;
               if (var52 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var20 = null;
               }

               var20.leadingIcon.setImageResource(R.drawable.ic_water_refresher);
               var52 = this.binding;
               var20 = var52;
               if (var52 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var20 = null;
               }

               var20.btnBuy.setText(R.string.action_buy_refresher);
               var52 = this.binding;
               var20 = var52;
               if (var52 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var20 = null;
               }

               var20.btnResetFilter.setText(R.string.action_reset_refresher);
               var52 = this.binding;
               var20 = var52;
               if (var52 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var20 = null;
               }

               var20.tvChangeFilter.setText(R.string.label_change_your_refresher);
               Device var26 = this.device;
               HasRemoveYellowWater var27;
               if (var26 instanceof HasRemoveYellowWater) {
                  var27 = (HasRemoveYellowWater)var26;
               } else {
                  var27 = null;
               }

               if (var27 != null) {
                  var19 = var27.getRefresherLifeLeft();
                  break label179;
               }
            } else {
               ActivityDeviceFilterDetailBinding var58 = this.binding;
               ActivityDeviceFilterDetailBinding var28 = var58;
               if (var58 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var28 = null;
               }

               var28.title.setText(R.string.wick_filter);
               var58 = this.binding;
               var28 = var58;
               if (var58 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var28 = null;
               }

               var28.tvFilterLife.setText(R.string.wick_filter_life);
               var58 = this.binding;
               var28 = var58;
               if (var58 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var28 = null;
               }

               var28.btnBuy.setText(R.string.action_buy_wick_filter);
               var58 = this.binding;
               var28 = var58;
               if (var58 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var28 = null;
               }

               var28.leadingIcon.setImageResource(R.drawable.ic_humidity_wick);
               Device var32 = this.device;
               HasWick var33;
               if (var32 instanceof HasWick) {
                  var33 = (HasWick)var32;
               } else {
                  var33 = null;
               }

               if (var33 != null) {
                  var19 = var33.getWickLifeLeft();
                  break label179;
               }
            }

            var19 = null;
         }
      } else {
         ActivityDeviceFilterDetailBinding var6 = this.binding;
         ActivityDeviceFilterDetailBinding var12 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.title.setText(R.string.label_air_filter);
         var6 = this.binding;
         var12 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.tvFilterLife.setText(R.string.filter_life);
         var6 = this.binding;
         var12 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.btnBuy.setText(R.string.action_buy_air_filter);
         var6 = this.binding;
         var12 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.leadingIcon.setImageResource(R.drawable.ic_filter_status);
         var6 = this.binding;
         var12 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         ImageView var17 = var12.ivInfo;
         Intrinsics.checkNotNullExpressionValue(var17, "ivInfo");
         View var18 = (View)var17;
         Device var51 = this.device;
         boolean var2;
         if (var51 != null && DeviceKt.supportRealTrack(var51)) {
            var2 = true;
         } else {
            var2 = false;
         }

         ViewExtensionsKt.show(var18, var2);
         var19 = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(this.device);
      }

      Device var10 = this.device;
      if (var10 != null) {
         ActivityDeviceFilterDetailBinding var9 = this.binding;
         ActivityDeviceFilterDetailBinding var62 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var62 = null;
         }

         var62.tvSubtitle.setText((CharSequence)var10.getName());
         var9 = this.binding;
         var62 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var62 = null;
         }

         AppCompatTextView var64 = var62.tvSubtitle;
         Intrinsics.checkNotNullExpressionValue(var64, "tvSubtitle");
         ViewExtensionsKt.show$default((View)var64, false, 1, (Object)null);
         if (var19 == null) {
            ActivityDeviceFilterDetailBinding var45 = this.binding;
            if (var45 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var45 = (ActivityDeviceFilterDetailBinding)var8;
            }

            ShadowLayout var46 = var45.cvFilterLife;
            Intrinsics.checkNotNullExpressionValue(var46, "cvFilterLife");
            ViewExtensionsKt.hide((View)var46);
            return;
         }

         ActivityDeviceFilterDetailBinding var75 = this.binding;
         ActivityDeviceFilterDetailBinding var65 = var75;
         if (var75 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var65 = null;
         }

         boolean var4 = this.getViewModel().deviceSupportAntiFake(this.device);
         Device var76 = this.device;
         boolean var11;
         if (var76 != null && var76.supportResetFilterOnline()) {
            var11 = var3;
         } else {
            var11 = false;
         }

         if (var4) {
            var65.btnResetFilter.setIconResource(R.drawable.ic_scan_flat);
         }

         var65.btnResetFilter.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda11(var4, this, var11, var19));
         Device var66 = this.device;
         ConnectivityStatus var67;
         if (var66 != null) {
            var67 = var66.getConnectivityStatus();
         } else {
            var67 = null;
         }

         if (var67 == ConnectivityStatus.ONLINE) {
            this.hydrateFilterInfo(var19);
            return;
         }

         ActivityDeviceFilterDetailBinding var68 = this.binding;
         ActivityDeviceFilterDetailBinding var34 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var34 = null;
         }

         var34.tvProgress.setText((CharSequence)this.getString(R.string.offline_label));
         var68 = this.binding;
         var34 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var34 = null;
         }

         var34.progressIndicator.setProgress(0);
         var68 = this.binding;
         var34 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var34 = null;
         }

         AppCompatTextView var37 = var34.tvFilterInfo;
         Intrinsics.checkNotNullExpressionValue(var37, "tvFilterInfo");
         ViewExtensionsKt.hide((View)var37);
         var68 = this.binding;
         ActivityDeviceFilterDetailBinding var38 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var38 = null;
         }

         View var39 = var38.bgFilterInfo;
         Intrinsics.checkNotNullExpressionValue(var39, "bgFilterInfo");
         ViewExtensionsKt.hide(var39);
         var68 = this.binding;
         ActivityDeviceFilterDetailBinding var40 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var40 = null;
         }

         AppCompatTextView var41 = var40.tvChangeFilter;
         Intrinsics.checkNotNullExpressionValue(var41, "tvChangeFilter");
         ViewExtensionsKt.hide((View)var41);
         var68 = this.binding;
         ActivityDeviceFilterDetailBinding var42 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var42 = null;
         }

         var42.tvProgress.setPadding(0, 0, 0, 0);
         var68 = this.binding;
         var42 = var68;
         if (var68 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var42 = null;
         }

         var42.tvProgress.setBackground((Drawable)null);
         var42 = this.binding;
         if (var42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var42 = (ActivityDeviceFilterDetailBinding)var7;
         }

         var42.tvProgress.setTextSize(14.0F);
      }

   }

   private static final void hydrateFilterLife$lambda$20$lambda$19$lambda$18(boolean var0, DeviceFilterDetailActivity var1, boolean var2, Integer var3, View var4) {
      if (var0) {
         Actions var11 = Actions.INSTANCE;
         Context var5 = (Context)var1;
         Device var7 = var1.device;
         Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type com.blueair.core.model.HasSKU");
         var1.startActivity(var11.openAntiFakeScanIntent(var5, (HasSKU)var7, var1.type));
      } else {
         if (var2) {
            Device var8 = var1.device;
            ConnectivityStatus var9;
            if (var8 != null) {
               var9 = var8.getConnectivityStatus();
            } else {
               var9 = null;
            }

            if (var9 != ConnectivityStatus.ONLINE) {
               var1.showDeviceOfflinePrompt();
               return;
            }

            FragmentManager var10 = var1.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var10, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var10.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var10.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var1.getResetTitleRes(), (Integer)null, var1.getResetMsgRes(var3), R.string.confirm, R.string.btn_cancel, false, false, false, false, (String[])null, (String)null, (Integer)null, new DeviceFilterDetailActivity$$ExternalSyntheticLambda14(var1), 3936, (Object)null)).show(var10, "ConfirmationDialogLeftAligned");
               return;
            }
         } else {
            FragmentManager var6 = var1.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var6, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var6.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var6.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.confirm_reset_filter_manually, (Integer)null, R.string.reset_filter_life_msg_manual, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, R.drawable.ic_fanspeed, (Function1)null, 6112, (Object)null)).show(var6, "ConfirmationDialogLeftAligned");
            }
         }

      }
   }

   private static final Unit hydrateFilterLife$lambda$20$lambda$19$lambda$18$lambda$16$lambda$15(DeviceFilterDetailActivity var0, boolean var1) {
      if (var1 && var0.device != null) {
         var0.showProgress(true);
         DeviceDetailsViewModel var3 = var0.getViewModel();
         Device var2 = var0.device;
         Intrinsics.checkNotNull(var2);
         var3.resetFilterLife(var2, var0.type);
      }

      return Unit.INSTANCE;
   }

   private final void hydrateResetFilterCard() {
      DeviceConfigProvider var4 = DeviceConfigProvider.INSTANCE;
      FilterConfig var3 = this.filterConfig;
      Object var5 = null;
      Object var6 = null;
      Object var7 = null;
      AwsLinkConfig var11;
      if (var3 != null) {
         var11 = var3.getVideo();
      } else {
         var11 = null;
      }

      String var9 = var4.getAwsLinkValue(var11);
      FilterConfig var12 = this.filterConfig;
      Integer var13;
      if (var12 != null) {
         var13 = var12.getVideoThumbnail();
      } else {
         var13 = null;
      }

      boolean var2 = false;
      boolean var1;
      if (var9 != null && var13 != null) {
         ActivityDeviceFilterDetailBinding var8 = this.binding;
         ActivityDeviceFilterDetailBinding var31 = var8;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var31 = null;
         }

         var31.videoThumbnail.setImageResource(var13);
         var31 = this.binding;
         ActivityDeviceFilterDetailBinding var18 = var31;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var18 = null;
         }

         var18.videoThumbnail.setOnClickListener(new DeviceFilterDetailActivity$$ExternalSyntheticLambda13(this, var9));
         var1 = 0;
      } else {
         ActivityDeviceFilterDetailBinding var29 = this.binding;
         ActivityDeviceFilterDetailBinding var14 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var14 = null;
         }

         ShapeableImageView var15 = var14.videoThumbnail;
         Intrinsics.checkNotNullExpressionValue(var15, "videoThumbnail");
         ViewExtensionsKt.hide((View)var15);
         var29 = this.binding;
         ActivityDeviceFilterDetailBinding var16 = var29;
         if (var29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var16 = null;
         }

         ImageView var17 = var16.iconPlay;
         Intrinsics.checkNotNullExpressionValue(var17, "iconPlay");
         ViewExtensionsKt.hide((View)var17);
         var1 = 1;
      }

      if (DeviceConfigProvider.INSTANCE.getUserManual(this.getSku()) == null && var1) {
         ActivityDeviceFilterDetailBinding var34 = this.binding;
         ActivityDeviceFilterDetailBinding var21 = var34;
         if (var34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var21 = null;
         }

         Group var22 = var21.groupUserManual;
         Intrinsics.checkNotNullExpressionValue(var22, "groupUserManual");
         ViewExtensionsKt.hide((View)var22);
      } else {
         ActivityDeviceFilterDetailBinding var33 = this.binding;
         ActivityDeviceFilterDetailBinding var19 = var33;
         if (var33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var19 = null;
         }

         Group var20 = var19.groupUserManual;
         Intrinsics.checkNotNullExpressionValue(var20, "groupUserManual");
         ViewExtensionsKt.show$default((View)var20, false, 1, (Object)null);
         var1 = var2;
      }

      if (var1) {
         ActivityDeviceFilterDetailBinding var35 = this.binding;
         ActivityDeviceFilterDetailBinding var23 = var35;
         if (var35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var23 = null;
         }

         ShadowLayout var24 = var23.cvReplaceFilter;
         Intrinsics.checkNotNullExpressionValue(var24, "cvReplaceFilter");
         ViewExtensionsKt.hide((View)var24);
      }

      DeviceFilterType var25 = this.type;
      var1 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$1[var25.ordinal()];
      if (var1 != 2) {
         if (var1 != 3) {
            ActivityDeviceFilterDetailBinding var28 = this.binding;
            if (var28 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var28 = (ActivityDeviceFilterDetailBinding)var7;
            }

            var28.tvHowReplace.setText(R.string.how_to_replace_your_filter);
         } else {
            ActivityDeviceFilterDetailBinding var27 = this.binding;
            if (var27 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var27 = (ActivityDeviceFilterDetailBinding)var5;
            }

            var27.tvHowReplace.setText(R.string.how_to_replace_your_refresher);
         }
      } else {
         ActivityDeviceFilterDetailBinding var26 = this.binding;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var26 = (ActivityDeviceFilterDetailBinding)var6;
         }

         var26.tvHowReplace.setText(R.string.how_to_replace_your_wick_filter);
      }
   }

   private static final void hydrateResetFilterCard$lambda$28(DeviceFilterDetailActivity var0, String var1, View var2) {
      FilterVideoActivity.Companion.launch((Context)var0, var1);
   }

   private final void observeViewModel() {
      Device var1 = this.device;
      if (var1 != null) {
         this.getViewModel().setDeviceId(var1.getUid());
         LiveData var2 = this.getViewModel().getLiveDevice();
         LifecycleOwner var3 = (LifecycleOwner)this;
         LiveDataExtensionsKt.observeNonNull(var2, var3, new DeviceFilterDetailActivity$$ExternalSyntheticLambda8(this));
         LiveDataExtensionsKt.observeNonNull(this.getViewModel().getDeviceDetailsState(), var3, new DeviceFilterDetailActivity$$ExternalSyntheticLambda9(this));
         this.getViewModel().getResetFilterLifeResult().observe(var3, new Observer(new DeviceFilterDetailActivity$$ExternalSyntheticLambda10(this)) {
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

   }

   private static final Unit observeViewModel$lambda$13$lambda$10(DeviceFilterDetailActivity var0, DeviceDetailsState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      var0.device = var1.getDevice();
      var0.hydrateFilterLife();
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$13$lambda$12(DeviceFilterDetailActivity var0, FilterLifeResetResult var1) {
      if (var1 != null) {
         var0.showProgress(false);
         int var2 = DeviceFilterDetailActivity.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var0.showDeviceOfflinePrompt();
            } else {
               FragmentManager var3 = var0.getSupportFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
               if (!(var3.findFragmentByTag("FAILED") instanceof ConfirmationDialogLeftAligned) && !var3.isStateSaved()) {
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_failed, (Integer)null, R.string.troubleshotting_reset_filter_internal_error, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var3, "FAILED");
               }
            }
         } else {
            ToastUtils.INSTANCE.showCenterToast((Context)var0, R.string.reset_successful, 1);
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$13$lambda$9(DeviceFilterDetailActivity var0, Device var1) {
      var0.getViewModel().setDevice(var1);
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$1(ActivityResult var0) {
   }

   private final String replaceNewline(String var1) {
      CharSequence var2 = (CharSequence)var1;
      return (new Regex("\\s*\\R\\s*")).replace(var2, " ");
   }

   private final void showDeviceOfflinePrompt() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      if (!(var1.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.offline_title_device, (Integer)null, R.string.offline_subtitle, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null)).show(var1, "DEVICE_OFFLINE");
      }

   }

   protected String getScreenName() {
      return this._screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      var1 = this.getIntent().getExtras();
      if (var1 != null) {
         this._screenName = var1.getString("screen_name");
         this.device = (Device)var1.getParcelable("device");
         this.deviceSku = var1.getString("device_sku");
         String var2 = var1.getString("EXTRA_TYPE", "FILTER");
         Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
         this.type = DeviceFilterType.valueOf(var2);
         this.fromNotification = var1.getBoolean("extra_from_notification", false);
      }

      ViewDataBinding var4 = DataBindingUtil.setContentView((Activity)this, com.blueair.devicedetails.R.layout.activity_device_filter_detail);
      Intrinsics.checkNotNullExpressionValue(var4, "setContentView(...)");
      this.binding = (ActivityDeviceFilterDetailBinding)var4;
      ActivityResultLauncher var5 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new DeviceFilterDetailActivity$$ExternalSyntheticLambda12());
      Intrinsics.checkNotNullExpressionValue(var5, "registerForActivityResult(...)");
      this.replaceFilterLauncher = var5;
      this.configureView();
      this.observeViewModel();
   }

   public final void showProgress(boolean var1) {
      ActivityDeviceFilterDetailBinding var3 = this.binding;
      ActivityDeviceFilterDetailBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"},
      d2 = {"Lcom/blueair/devicedetails/activity/DeviceFilterDetailActivity$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "EXTRA_FROM_NOTIFICATION", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "fromNotification", "", "launch", "", "devicedetails_otherRelease"},
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
      public static Intent getLaunchIntent$default(Companion var0, Context var1, Device var2, String var3, DeviceFilterType var4, boolean var5, int var6, Object var7) {
         if ((var6 & 16) != 0) {
            var5 = false;
         }

         return var0.getLaunchIntent(var1, var2, var3, var4, var5);
      }

      // $FF: synthetic method
      public static void launch$default(Companion var0, Context var1, Device var2, String var3, DeviceFilterType var4, boolean var5, int var6, Object var7) {
         if ((var6 & 16) != 0) {
            var5 = false;
         }

         var0.launch(var1, var2, var3, var4, var5);
      }

      public final Intent getLaunchIntent(Context var1, Device var2, String var3, DeviceFilterType var4, boolean var5) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var4, "type");
         Intent var6 = new Intent(var1, DeviceFilterDetailActivity.class);
         String var7;
         if (var5) {
            var7 = "notifications_filter";
         } else {
            var7 = "device_details_filter";
         }

         var6.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("screen_name", var7), TuplesKt.to("device", var2), TuplesKt.to("device_sku", var3), TuplesKt.to("EXTRA_TYPE", var4.name()), TuplesKt.to("extra_from_notification", var5)}));
         return var6;
      }

      public final void launch(Context var1, Device var2, String var3, DeviceFilterType var4, boolean var5) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var4, "type");
         var1.startActivity(this.getLaunchIntent(var1, var2, var3, var4, var5));
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
         int[] var0 = new int[FilterLifeResetResult.values().length];

         try {
            var0[FilterLifeResetResult.SUCCESS.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[FilterLifeResetResult.FAILED.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[FilterLifeResetResult.DEVICE_OFFLINE.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[DeviceFilterType.values().length];

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

         $EnumSwitchMapping$1 = var0;
      }
   }
}
