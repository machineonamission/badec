package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.UserManual;
import com.blueair.devicedetails.databinding.ActivityDeviceReplaceFilterBinding;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.FilterLifeResetResult;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ToastUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.dd.ShadowLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"},
   d2 = {"Lcom/blueair/devicedetails/activity/ReplaceFilterActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceReplaceFilterBinding;", "device", "Lcom/blueair/core/model/HasSKU;", "deviceSku", "sku", "getSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "getResetTitleRes", "", "getResetMsgRes", "leftLifePercentage", "showDeviceOfflinePrompt", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ReplaceFilterActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_TYPE = "EXTRA_TYPE";
   private ActivityDeviceReplaceFilterBinding binding;
   private HasSKU device;
   private String deviceSku;
   private final String screenName = "device_filter_replace";
   private DeviceFilterType type;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$4CMHAut_PoOWdrGHK6P8N1Wp7Fg(ReplaceFilterActivity var0, View var1) {
      configure$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ClmwQeZaUl8lRyR1DG2dZ1Ed39Q(ReplaceFilterActivity var0, View var1) {
      configure$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DBEfv37SzE2H4S4fX_fld4N2fWM(ReplaceFilterActivity var0, boolean var1) {
      return configure$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WdBjVsiiaG3H3Lk_6JE6Pgu7rRk/* $FF was: $r8$lambda$WdBjVsiiaG3H3Lk-6JE6Pgu7rRk*/(ReplaceFilterActivity var0, FilterLifeResetResult var1) {
      return configure$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$oNHM9_EjuKdzY_Br3cPWPkB0OmI(ReplaceFilterActivity var0, UserManual var1, String var2, View var3) {
      configure$lambda$3(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$r5VrDuAZpkK1TmkM4lmEIRCQbxA(boolean var0, ReplaceFilterActivity var1, boolean var2, Integer var3, View var4) {
      configure$lambda$12$lambda$11$lambda$10(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void $r8$lambda$x_xdYXMwEv03A_b1XeIDWWzwn88(ReplaceFilterActivity var0, String var1, View var2) {
      configure$lambda$5(var0, var1, var2);
   }

   public ReplaceFilterActivity() {
      ComponentActivity var1 = (ComponentActivity)this;
      Function0 var2 = new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceDetailsViewModel.class), new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var2, new Function0((Function0)null, var1) {
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

   private final void configure() {
      ActivityDeviceReplaceFilterBinding var6 = this.binding;
      Object var8 = null;
      ActivityDeviceReplaceFilterBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.closeBtn.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda0(this));
      var6 = this.binding;
      var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.btnBack.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda1(this));
      UserManual var12;
      if (this.type == DeviceFilterType.REFRESHER) {
         var12 = DeviceConfigProvider.INSTANCE.getRefresherManual(this.getSku());
      } else {
         var12 = DeviceConfigProvider.INSTANCE.getUserManual(this.getSku());
      }

      String var44;
      if (var12 != null) {
         var44 = var12.getLink();
      } else {
         var44 = null;
      }

      CharSequence var7 = (CharSequence)var44;
      boolean var3 = false;
      if (var7 != null && var7.length() != 0) {
         ActivityDeviceReplaceFilterBinding var9 = this.binding;
         ActivityDeviceReplaceFilterBinding var66 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var66 = null;
         }

         Group var67 = var66.groupUserManual;
         Intrinsics.checkNotNullExpressionValue(var67, "groupUserManual");
         ViewExtensionsKt.show$default((View)var67, false, 1, (Object)null);
         var9 = this.binding;
         ActivityDeviceReplaceFilterBinding var68 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var68 = null;
         }

         var68.slUserManual.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda2(this, var12, var44));
      }

      FilterConfig var69 = DeviceConfigProvider.INSTANCE.getFilterConfig(this.getSku(), this.type);
      DeviceFilterType var13 = this.type;
      int var1 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$0[var13.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            ActivityDeviceReplaceFilterBinding var45 = this.binding;
            ActivityDeviceReplaceFilterBinding var14 = var45;
            if (var45 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            var14.title.setText(R.string.replace_water_refresher);
            var45 = this.binding;
            var14 = var45;
            if (var45 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            var14.whyIsThisImportant.setText(R.string.why_is_this_important);
            var45 = this.binding;
            var14 = var45;
            if (var45 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            var14.videoSummary.setText(R.string.video_summary_refresher);
            var45 = this.binding;
            var14 = var45;
            if (var45 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            var14.tvManualInfo.setText(R.string.how_to_replace_your_refresher);
            var45 = this.binding;
            var14 = var45;
            if (var45 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            var14.btnResetFilter.setText(R.string.reset_refresher_life);
         } else {
            ActivityDeviceReplaceFilterBinding var50 = this.binding;
            ActivityDeviceReplaceFilterBinding var19 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var19 = null;
            }

            var19.title.setText(R.string.replace_wick_filter);
            var50 = this.binding;
            var19 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var19 = null;
            }

            var19.whyIsThisImportant.setText(R.string.why_is_this_important_wick);
            var50 = this.binding;
            var19 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var19 = null;
            }

            var19.videoSummary.setText(R.string.video_summary_wick_v2);
            var50 = this.binding;
            var19 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var19 = null;
            }

            var19.tvManualInfo.setText(R.string.how_to_replace_your_wick_filter);
         }
      } else {
         ActivityDeviceReplaceFilterBinding var54 = this.binding;
         ActivityDeviceReplaceFilterBinding var23 = var54;
         if (var54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var23 = null;
         }

         var23.title.setText(R.string.replace_filter);
         var54 = this.binding;
         var23 = var54;
         if (var54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var23 = null;
         }

         var23.whyIsThisImportant.setText(R.string.why_is_this_important);
         var54 = this.binding;
         var23 = var54;
         if (var54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var23 = null;
         }

         var23.videoSummary.setText(R.string.video_summary);
         var54 = this.binding;
         var23 = var54;
         if (var54 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var23 = null;
         }

         var23.tvManualInfo.setText(R.string.how_to_replace_your_filter);
      }

      HasSKU var74 = this.device;
      if (var74 != null) {
         ActivityDeviceReplaceFilterBinding var58 = this.binding;
         ActivityDeviceReplaceFilterBinding var27 = var58;
         if (var58 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var27 = null;
         }

         var27.tvSubtitle.setText((CharSequence)var74.getName());
         var58 = this.binding;
         var27 = var58;
         if (var58 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var27 = null;
         }

         AppCompatTextView var29 = var27.tvSubtitle;
         Intrinsics.checkNotNullExpressionValue(var29, "tvSubtitle");
         ViewExtensionsKt.show$default((View)var29, false, 1, (Object)null);
      }

      DeviceConfigProvider var60 = DeviceConfigProvider.INSTANCE;
      AwsLinkConfig var30;
      if (var69 != null) {
         var30 = var69.getVideo();
      } else {
         var30 = null;
      }

      String var75 = var60.getAwsLinkValue(var30);
      Integer var31;
      if (var69 != null) {
         var31 = var69.getVideoThumbnail();
      } else {
         var31 = null;
      }

      if (var75 != null && var31 != null) {
         ActivityDeviceReplaceFilterBinding var70 = this.binding;
         ActivityDeviceReplaceFilterBinding var63 = var70;
         if (var70 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var63 = null;
         }

         var63.videoThumbnail.setImageResource(var31);
         var63 = this.binding;
         ActivityDeviceReplaceFilterBinding var36 = var63;
         if (var63 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var36 = null;
         }

         var36.iconPlay.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda3(this, var75));
      } else {
         ActivityDeviceReplaceFilterBinding var61 = this.binding;
         ActivityDeviceReplaceFilterBinding var32 = var61;
         if (var61 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var32 = null;
         }

         ShadowLayout var33 = var32.slReplaceFilter;
         Intrinsics.checkNotNullExpressionValue(var33, "slReplaceFilter");
         ViewExtensionsKt.hide((View)var33);
         var61 = this.binding;
         ActivityDeviceReplaceFilterBinding var34 = var61;
         if (var61 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var34 = null;
         }

         TextView var35 = var34.tvWatchVideo;
         Intrinsics.checkNotNullExpressionValue(var35, "tvWatchVideo");
         ViewExtensionsKt.hide((View)var35);
      }

      ActivityDeviceReplaceFilterBinding var37 = this.binding;
      ActivityDeviceReplaceFilterBinding var65 = var37;
      if (var37 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var65 = null;
      }

      boolean var4 = this.getViewModel().deviceSupportAntiFake(this.device);
      HasSKU var38 = this.device;
      boolean var2 = var3;
      if (var38 != null) {
         var2 = var3;
         if (var38.supportResetFilterOnline()) {
            var2 = true;
         }
      }

      if (var4) {
         var65.btnResetFilter.setIconResource(R.drawable.ic_scan_flat);
      }

      DeviceFilterType var39 = this.type;
      var1 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$0[var39.ordinal()];
      Integer var41;
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            HasSKU var40 = this.device;
            HasRemoveYellowWater var71;
            if (var40 instanceof HasRemoveYellowWater) {
               var71 = (HasRemoveYellowWater)var40;
            } else {
               var71 = null;
            }

            var41 = (Integer)var8;
            if (var71 != null) {
               var41 = var71.getRefresherLifeLeft();
            }
         } else {
            HasSKU var42 = this.device;
            HasWick var72;
            if (var42 instanceof HasWick) {
               var72 = (HasWick)var42;
            } else {
               var72 = null;
            }

            var41 = (Integer)var8;
            if (var72 != null) {
               var41 = var72.getWickLifeLeft();
            }
         }
      } else {
         var41 = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(this.device);
      }

      if (var41 != null) {
         ((Number)var41).intValue();
         var65.btnResetFilter.setOnClickListener(new ReplaceFilterActivity$$ExternalSyntheticLambda4(var4, this, var2, var41));
      }

      this.getViewModel().getResetFilterLifeResult().observe((LifecycleOwner)this, new Observer(new ReplaceFilterActivity$$ExternalSyntheticLambda5(this)) {
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

   private static final void configure$lambda$1(ReplaceFilterActivity var0, View var1) {
      var0.finish();
   }

   private static final void configure$lambda$12$lambda$11$lambda$10(boolean var0, ReplaceFilterActivity var1, boolean var2, Integer var3, View var4) {
      if (var0) {
         Actions var11 = Actions.INSTANCE;
         Context var5 = (Context)var1;
         HasSKU var7 = var1.device;
         Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type com.blueair.core.model.HasSKU");
         var1.startActivity(var11.openAntiFakeScanIntent(var5, var7, var1.type));
      } else {
         if (var2) {
            HasSKU var8 = var1.device;
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
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var1.getResetTitleRes(), (Integer)null, var1.getResetMsgRes(var3), R.string.confirm, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new ReplaceFilterActivity$$ExternalSyntheticLambda6(var1), 3680, (Object)null)).show(var10, "ConfirmationDialogLeftAligned");
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

   private static final Unit configure$lambda$12$lambda$11$lambda$10$lambda$8$lambda$7(ReplaceFilterActivity var0, boolean var1) {
      if (var1) {
         HasSKU var2 = var0.device;
         if (var2 != null) {
            var0.showProgress(true);
            var0.getViewModel().resetFilterLife(var2, var0.type);
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$14(ReplaceFilterActivity var0, FilterLifeResetResult var1) {
      if (var1 != null) {
         var0.showProgress(false);
         int var2 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var0.showDeviceOfflinePrompt();
            } else {
               FragmentManager var4 = var0.getSupportFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
               if (!(var4.findFragmentByTag("FAILED") instanceof ConfirmationDialogLeftAligned) && !var4.isStateSaved()) {
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.reset_failed, (Integer)null, R.string.troubleshotting_reset_filter_internal_error, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var4, "FAILED");
               }
            }
         } else {
            DeviceDetailsDialogFragment.Companion var3 = DeviceDetailsDialogFragment.Companion;
            DeviceFilterType var5 = var0.type;
            var2 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
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
            ToastUtils.INSTANCE.showCenterToast((Context)var0, R.string.reset_successful, 1);
            var0.finish();
         }
      }

      return Unit.INSTANCE;
   }

   private static final void configure$lambda$2(ReplaceFilterActivity var0, View var1) {
      var0.finish();
   }

   private static final void configure$lambda$3(ReplaceFilterActivity var0, UserManual var1, String var2, View var3) {
      DeviceFilterType var5 = var0.type;
      int var4 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var4 = var1.getRefresherIndex();
         } else {
            var4 = var1.getWickIndex();
         }
      } else {
         var4 = var1.getFilterIndex();
      }

      UserManualActivity.Companion.launch((Context)var0, "device_filter_manual", var2, var4);
   }

   private static final void configure$lambda$5(ReplaceFilterActivity var0, String var1, View var2) {
      FilterVideoActivity.Companion.launch((Context)var0, var1);
   }

   private final int getResetMsgRes(int var1) {
      DeviceFilterType var3 = this.type;
      int var2 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
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
      int var1 = ReplaceFilterActivity.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
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

   private final DeviceDetailsViewModel getViewModel() {
      return (DeviceDetailsViewModel)this.viewModel$delegate.getValue();
   }

   private final void showDeviceOfflinePrompt() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      if (!(var1.findFragmentByTag("DEVICE_OFFLINE") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.offline_title_device, (Integer)null, R.string.offline_subtitle, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var1, "DEVICE_OFFLINE");
      }

   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      var1 = this.getIntent().getExtras();
      if (var1 != null) {
         this.device = (HasSKU)var1.getParcelable("device");
         this.deviceSku = var1.getString("device_sku");
         String var3 = var1.getString("EXTRA_TYPE", "FILTER");
         Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
         this.type = DeviceFilterType.valueOf(var3);
      }

      ViewDataBinding var4 = DataBindingUtil.setContentView((Activity)this, com.blueair.devicedetails.R.layout.activity_device_replace_filter);
      Intrinsics.checkNotNullExpressionValue(var4, "setContentView(...)");
      this.binding = (ActivityDeviceReplaceFilterBinding)var4;
      this.configure();
   }

   public final void showProgress(boolean var1) {
      ActivityDeviceReplaceFilterBinding var3 = this.binding;
      ActivityDeviceReplaceFilterBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/activity/ReplaceFilterActivity$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "deviceSku", "type", "Lcom/blueair/core/model/DeviceFilterType;", "launch", "", "devicedetails_otherRelease"},
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

      public final Intent getLaunchIntent(Context var1, Device var2, String var3, DeviceFilterType var4) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var4, "type");
         Intent var5 = new Intent(var1, ReplaceFilterActivity.class);
         var5.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var2), TuplesKt.to("device_sku", var3), TuplesKt.to("EXTRA_TYPE", var4.name())}));
         return var5;
      }

      public final void launch(Context var1, Device var2, String var3, DeviceFilterType var4) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var4, "type");
         var1.startActivity(this.getLaunchIntent(var1, var2, var3, var4));
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
