package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.auth.LocationService;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasScheduling;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.TrackedLocation;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsBinding;
import com.blueair.devicedetails.fragment.DeviceAttributesFragment;
import com.blueair.devicedetails.fragment.DeviceBannersFragment;
import com.blueair.devicedetails.fragment.DeviceHSensorsFragment;
import com.blueair.devicedetails.fragment.DeviceNSchedulesFragment;
import com.blueair.devicedetails.fragment.DeviceNWelcomeHomeFragment;
import com.blueair.devicedetails.fragment.DeviceSchedulesFragment;
import com.blueair.devicedetails.fragment.DeviceSensorsFragment;
import com.blueair.devicedetails.fragment.DeviceSettingsFragment;
import com.blueair.devicedetails.fragment.DeviceWelcomeHomeFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0002J\b\u00101\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0002J\u0010\u00106\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020,H\u0016J\b\u00109\u001a\u00020\u0018H\u0016J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceDetailsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "actionType", "onStart", "", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showSensorLayout", "Lcom/blueair/core/model/HasSensorData;", "hideSensorLayout", "scrollToFilterStatus", "scrollToWickStatus", "onResume", "handleActions", "refreshDeviceAttributes", "", "bindViewModel", "showDeviceAttributes", "showDeviceSchedules", "showDeviceWelcomeHome", "showDeviceSettingsButton", "shouldShowStartWarningDialog", "state", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsState;", "shouldShowFilterDoorOpenDialog", "showBanners", "showProgress", "shouldShowProgress", "dismiss", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetailsDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String REQUEST_KEY_HANDLE_ACTION = "REQUEST_KEY_HANDLE_ACTION";
   public static final String TAG = "Device_Details_Dialog";
   private static String jumpToAction;
   private String actionType;
   public Device device;
   private final String screenName = "device_details";
   private DialogfragmentDeviceDetailsBinding viewDataBinding;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static DeviceHSensorsFragment $r8$lambda$_T5S0N0uCGDeeN27sOkObfWDiWo/* $FF was: $r8$lambda$-T5S0N0uCGDeeN27sOkObfWDiWo*/(HasSensorData var0) {
      return showSensorLayout$lambda$4(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5UPDTwJ44NfIUJOxj5mc6caHsaY(DeviceDetailsDialogFragment var0, View var1) {
      onCreateView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceSensorsFragment $r8$lambda$D3zgzOLAjuY_Hp_r4witjobRJE8/* $FF was: $r8$lambda$D3zgzOLAjuY-Hp-r4witjobRJE8*/(HasSensorData var0) {
      return showSensorLayout$lambda$5(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DlO58BcJ4LJDSoLAj0S_jsgd9Uc/* $FF was: $r8$lambda$DlO58BcJ4LJDSoLAj0S-jsgd9Uc*/(DeviceDetailsDialogFragment var0, boolean var1) {
      return bindViewModel$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Qid6pWRggl6qc8vKa8AdFtt7Lww(DeviceDetailsDialogFragment var0, View var1) {
      bindViewModel$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bdjwFTycswoeDkTQ3_wFBE70vzU(DeviceDetailsDialogFragment var0, Device var1) {
      return bindViewModel$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$d9ciXqoX_FBqmAYGo8eZnPd1KHs(DeviceDetailsDialogFragment var0, String var1, Bundle var2) {
      onViewCreated$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$dMqbTR1ttwjcPEFSsFi_rtV31Qw(DeviceDetailsDialogFragment var0, TrackedLocation var1) {
      return bindViewModel$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kXlvcpRQwaNqzjGwe17_FIZZojY(NestedScrollView var0, int var1) {
      scrollToFilterStatus$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$rqfgI_JVyOQqhDru8HFE8jd9PAM/* $FF was: $r8$lambda$rqfgI-JVyOQqhDru8HFE8jd9PAM*/(NestedScrollView var0) {
      scrollToWickStatus$lambda$10(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zp9Dq0JDVBfUj4DcJVcVI9flYQQ(DeviceDetailsDialogFragment var0, DeviceDetailsState var1) {
      return bindViewModel$lambda$11(var0, var1);
   }

   private final void bindViewModel() {
      boolean var1 = DeviceKt.isAfterG4(this.getDevice());
      Object var3 = null;
      if (!var1) {
         DialogfragmentDeviceDetailsBinding var4 = this.viewDataBinding;
         DialogfragmentDeviceDetailsBinding var2 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var2 = null;
         }

         var2.scrollable.setBackground((Drawable)(new ColorDrawable(-1)));
      }

      LiveData var5 = this.getViewModel().getDeviceDetailsState();
      LifecycleOwner var11 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var11, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var5, var11, new DeviceDetailsDialogFragment$$ExternalSyntheticLambda4(this));
      this.getViewModel().getLiveDevice().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda5(this)) {
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
      if (this.getDevice() instanceof HasLocation) {
         DialogfragmentDeviceDetailsBinding var12 = this.viewDataBinding;
         DialogfragmentDeviceDetailsBinding var6 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         TextView var7 = var6.location;
         Intrinsics.checkNotNullExpressionValue(var7, "location");
         ViewExtensionsKt.show((View)var7, true);
         DialogfragmentDeviceDetailsBinding var8 = this.viewDataBinding;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = (DialogfragmentDeviceDetailsBinding)var3;
         }

         var8.location.setOnClickListener(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda6(this));
         this.getViewModel().getLiveLocation().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda7(this)) {
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

      var5 = this.getViewModel().getNetworkAvailable();
      LifecycleOwner var10 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var10, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var5, var10, new DeviceDetailsDialogFragment$$ExternalSyntheticLambda8(this));
      if (this.getDevice() instanceof HasScheduling) {
         this.showDeviceSchedules();
      }

      if (this.getDevice() instanceof HasWelcomeHome && this.getViewModel().isInWelcomeHomeRegion()) {
         this.showDeviceWelcomeHome();
      }

      this.showDeviceSettingsButton();
   }

   private static final Unit bindViewModel$lambda$11(DeviceDetailsDialogFragment var0, DeviceDetailsState var1) {
      Intrinsics.checkNotNullParameter(var1, "state");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("device state: ");
      var4.append(var1);
      String var7 = var4.toString();
      int var2 = 0;
      var3.d(var7, new Object[0]);
      DialogfragmentDeviceDetailsBinding var8 = var0.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var5 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      AppCompatImageView var9 = var5.deviceIcon;
      DeviceImage var6 = DeviceConfigProvider.INSTANCE.getDeviceImage(var1.getDevice());
      if (var6 != null) {
         var2 = var6.getDevice();
      }

      var9.setImageResource(var2);
      var0.setDevice(var1.getDevice());
      var0.shouldShowStartWarningDialog(var1);
      if (var1.getDevice() instanceof HasSensorData) {
         var0.showSensorLayout((HasSensorData)var1.getDevice());
      } else {
         var0.hideSensorLayout();
      }

      var0.showBanners(var1.getDevice());
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$12(DeviceDetailsDialogFragment var0, Device var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("liveDevice = ");
      var4.append(var1);
      String var12 = var4.toString();
      boolean var2 = false;
      var3.v(var12, new Object[0]);
      if (var1 == null) {
         var0.dismiss();
      } else {
         DialogfragmentDeviceDetailsBinding var5 = var0.viewDataBinding;
         Object var13 = null;
         DialogfragmentDeviceDetailsBinding var10 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var10 = null;
         }

         var10.deviceName.setText((CharSequence)var1.getName());
         var0.getViewModel().setDevice(var1);
         if (var1.getConnectivityStatus() == ConnectivityStatus.UPDATING) {
            var2 = true;
         }

         var10 = var0.viewDataBinding;
         DialogfragmentDeviceDetailsBinding var8 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var8 = null;
         }

         FrameLayout var9 = var8.deviceSchedulesContainer;
         Intrinsics.checkNotNullExpressionValue(var9, "deviceSchedulesContainer");
         ViewExtensionsKt.show((View)var9, var2 ^ true);
         DialogfragmentDeviceDetailsBinding var6 = var0.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeviceDetailsBinding)var13;
         }

         FrameLayout var7 = var6.welcomeHomeContainer;
         Intrinsics.checkNotNullExpressionValue(var7, "welcomeHomeContainer");
         ViewExtensionsKt.show((View)var7, var2 ^ true);
      }

      return Unit.INSTANCE;
   }

   private static final void bindViewModel$lambda$13(DeviceDetailsDialogFragment var0, View var1) {
      TrackedLocation var7 = (TrackedLocation)var0.getViewModel().getLiveLocation().getValue();
      String var8;
      if (var7 != null) {
         var8 = var7.getId();
      } else {
         var8 = null;
      }

      Actions var4 = Actions.INSTANCE;
      Context var5 = var0.requireContext();
      Intrinsics.checkNotNullExpressionValue(var5, "requireContext(...)");
      LocationService.MapType var6 = var0.getViewModel().getMapType();
      CharSequence var3 = (CharSequence)var8;
      boolean var2;
      if (var3 != null && var3.length() != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      String var9 = var8;
      if (var8 == null) {
         var9 = "";
      }

      var0.startActivity(Actions.openMapIntent$default(var4, var5, var6, var9, var2, false, var0.getDevice().getUid(), 16, (Object)null));
   }

   private static final Unit bindViewModel$lambda$14(DeviceDetailsDialogFragment var0, TrackedLocation var1) {
      DialogfragmentDeviceDetailsBinding var3 = var0.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      label15: {
         var7 = var2.location;
         if (var1 != null) {
            String var6 = var1.getLocationName();
            if (var6 != null) {
               var5 = (CharSequence)var6;
               break label15;
            }
         }

         String var4 = var0.getString(R.string.assign_location);
         Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
         var5 = (CharSequence)var4;
      }

      var7.setText(var5);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$15(DeviceDetailsDialogFragment var0, boolean var1) {
      Device var3 = var0.getViewModel().getDevice();
      Device var2 = var3;
      if (var3 == null) {
         var2 = var0.getDevice();
      }

      var0.showBanners(var2);
      return Unit.INSTANCE;
   }

   private final void handleActions(boolean var1) {
      String var3 = this.actionType;
      String var2 = var3;
      if (var3 == null) {
         var2 = jumpToAction;
      }

      if (var2 != null) {
         switch (var2.hashCode()) {
            case -2123968024:
               if (var2.equals("filter_purchase") && DeviceKt.useNewFilterConfig(this.getDevice()) && DeviceConfigProvider.getFilterConfig$default(DeviceConfigProvider.INSTANCE, (Device)this.getDevice(), (DeviceFilterType)null, 2, (Object)null) == null) {
                  this.scrollToFilterStatus();
                  this.actionType = null;
                  jumpToAction = null;
               }
               break;
            case -1774126825:
               if (var2.equals("wick_status")) {
                  this.scrollToWickStatus();
               }
               break;
            case -1274492040:
               if (var2.equals("filter") && (DeviceKt.isAfterG4(this.getDevice()) || StringsKt.contains$default((CharSequence)this.getDevice().getModelName(), (CharSequence)"511i", false, 2, (Object)null))) {
                  this.scrollToFilterStatus();
                  this.actionType = null;
               }
               break;
            case -757923495:
               var2.equals("device_details");
               break;
            case -547902823:
               if (var2.equals("filter_status")) {
                  this.scrollToFilterStatus();
               }
               break;
            case 590772454:
               if (var2.equals("wick_purchase") && DeviceKt.useNewFilterConfig(this.getDevice()) && DeviceConfigProvider.getFilterConfig$default(DeviceConfigProvider.INSTANCE, (Device)this.getDevice(), (DeviceFilterType)null, 2, (Object)null) == null) {
                  this.scrollToWickStatus();
                  this.actionType = null;
                  jumpToAction = null;
               }
         }
      }

      if (var1) {
         this.showDeviceAttributes();
      }

      this.actionType = null;
      jumpToAction = null;
   }

   private final void hideSensorLayout() {
      DialogfragmentDeviceDetailsBinding var2 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.graphContainer.setVisibility(8);
      Fragment var3 = this.getChildFragmentManager().findFragmentByTag(DeviceSensorsFragment.Companion.getTAG());
      if (var3 != null) {
         this.getChildFragmentManager().beginTransaction().remove(var3).commitAllowingStateLoss();
      }

   }

   private static final void onCreateView$lambda$2(DeviceDetailsDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$3(DeviceDetailsDialogFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      var0.handleActions(false);
   }

   private final void scrollToFilterStatus() {
      int var1;
      if (DeviceKt.isAfterG4(this.getDevice())) {
         var1 = com.blueair.devicedetails.R.id.holder_device_n_filter_status;
      } else {
         var1 = com.blueair.devicedetails.R.id.holder_device_filter_status;
      }

      DialogfragmentDeviceDetailsBinding var3 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      NestedScrollView var4 = var2.scrollable;
      Intrinsics.checkNotNullExpressionValue(var4, "scrollable");
      var4.postDelayed(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda3(var4, var1), 500L);
   }

   private static final void scrollToFilterStatus$lambda$8(NestedScrollView var0, int var1) {
      View var2 = var0.findViewById(var1);
      if (var2 != null) {
         var0.smoothScrollTo(0, (int)var2.getY() - var2.getHeight() / 2 + var0.getHeight() / 2);
      }

   }

   private final void scrollToWickStatus() {
      DialogfragmentDeviceDetailsBinding var2 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      NestedScrollView var3 = var1.scrollable;
      Intrinsics.checkNotNullExpressionValue(var3, "scrollable");
      var3.postDelayed(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda1(var3), 500L);
   }

   private static final void scrollToWickStatus$lambda$10(NestedScrollView var0) {
      View var1 = var0.findViewById(com.blueair.devicedetails.R.id.holder_device_h_wick_status);
      if (var1 != null) {
         var0.smoothScrollTo(0, (int)var1.getY() - var1.getHeight() / 2 + var0.getHeight() / 2);
      }

   }

   private final void shouldShowFilterDoorOpenDialog(DeviceDetailsState var1) {
      if (var1.getDevice() instanceof HasSafetySwitch) {
         if (ViewUtils.INSTANCE.shouldShowFilterDoorPopup((HasSafetySwitch)var1.getDevice())) {
            ConfirmationDialogCentered.Companion var4 = ConfirmationDialogCentered.Companion;
            FragmentManager var5 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
            var4.showFilterDoorOpenDialog(var5);
            return;
         }

         if (((HasSafetySwitch)var1.getDevice()).isSafetySwitchOn()) {
            ConfirmationDialogCentered.Companion var3 = ConfirmationDialogCentered.Companion;
            FragmentManager var2 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
            var3.dismissFilterDoorOpenDialog(var2);
         }
      }

   }

   private final void shouldShowStartWarningDialog(DeviceDetailsState var1) {
      Context var2 = this.getContext();
      if (var2 == null || NetUtil.INSTANCE.isProbablyOnline(var2)) {
         ConfirmationDialogCentered.Companion var3 = ConfirmationDialogCentered.Companion;
         FragmentManager var4 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         var3.dismissOfflineDialog(var4);
         this.shouldShowFilterDoorOpenDialog(var1);
      }
   }

   private final void showBanners(Device var1) {
      boolean var2;
      label33: {
         if (var1 instanceof HasWick || var1 instanceof DevicePet20) {
            Object var3 = this.getViewModel().getDeviceOffline().getValue();
            var2 = true;
            if (!Intrinsics.areEqual(var3, true)) {
               break label33;
            }
         }

         var2 = false;
      }

      DialogfragmentDeviceDetailsBinding var5 = this.viewDataBinding;
      Object var4 = null;
      DialogfragmentDeviceDetailsBinding var7 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = null;
      }

      FrameLayout var8 = var7.bannersContainer;
      Intrinsics.checkNotNullExpressionValue(var8, "bannersContainer");
      ViewExtensionsKt.show((View)var8, var2);
      if (var2 && this.getChildFragmentManager().findFragmentByTag("DeviceBannersFragment") == null) {
         FragmentTransaction var9 = this.getChildFragmentManager().beginTransaction();
         Intrinsics.checkNotNullExpressionValue(var9, "beginTransaction(...)");
         DeviceBannersFragment var10 = DeviceBannersFragment.Companion.newInstance(var1);
         DialogfragmentDeviceDetailsBinding var6 = this.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeviceDetailsBinding)var4;
         }

         var9.replace(var6.bannersContainer.getId(), var10, "DeviceBannersFragment");
         var9.commitAllowingStateLoss();
      }

   }

   private final void showDeviceAttributes() {
      FragmentTransaction var3 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var3, "beginTransaction(...)");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("showDeviceAttributes device: ");
      var1.append(this.getViewModel().getDevice());
      var2.d(var1.toString(), new Object[0]);
      DeviceAttributesFragment var4 = DeviceAttributesFragment.Companion.newInstance(this.getDevice(), this.actionType);
      DialogfragmentDeviceDetailsBinding var6 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      var3.replace(var5.devicesAttributesContainer.getId(), var4);
      var3.commitAllowingStateLoss();
   }

   private final void showDeviceSchedules() {
      FragmentTransaction var4 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var4, "beginTransaction(...)");
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("showDeviceSchedules device: ");
      var2.append(this.getViewModel().getDevice());
      var1.d(var2.toString(), new Object[0]);
      BaseFragment var5;
      if (DeviceKt.isAfterG4(this.getDevice())) {
         var5 = DeviceNSchedulesFragment.Companion.newInstance(this.getDevice());
      } else {
         var5 = DeviceSchedulesFragment.Companion.newInstance(this.getDevice());
      }

      DialogfragmentDeviceDetailsBinding var3 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var4.replace(var6.deviceSchedulesContainer.getId(), var5);
      var4.commitAllowingStateLoss();
   }

   private final void showDeviceSettingsButton() {
      FragmentTransaction var3 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var3, "beginTransaction(...)");
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("showDeviceSettings device: ");
      var2.append(this.getViewModel().getDevice());
      var1.d(var2.toString(), new Object[0]);
      DeviceSettingsFragment var4 = DeviceSettingsFragment.Companion.newInstance(this.getDevice());
      DialogfragmentDeviceDetailsBinding var6 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      var3.replace(var5.deviceSettingsContainer.getId(), var4);
      var3.commitAllowingStateLoss();
   }

   private final void showDeviceWelcomeHome() {
      FragmentTransaction var4 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var4, "beginTransaction(...)");
      BaseFragment var1;
      if (this.getDevice() instanceof DeviceNewClassic) {
         var1 = DeviceNWelcomeHomeFragment.Companion.newInstance(this.getDevice());
      } else {
         var1 = DeviceWelcomeHomeFragment.Companion.newInstance(this.getDevice());
      }

      DialogfragmentDeviceDetailsBinding var3 = this.viewDataBinding;
      DialogfragmentDeviceDetailsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var4.replace(var2.welcomeHomeContainer.getId(), var1);
      var4.commitAllowingStateLoss();
   }

   private final void showSensorLayout(HasSensorData var1) {
      Pair var5;
      if (DeviceKt.isAfterG4(var1) && !(var1 instanceof DeviceNewClassic)) {
         var5 = new Pair(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda0(var1), DeviceHSensorsFragment.Companion.getTAG());
      } else {
         var5 = new Pair(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda2(var1), DeviceSensorsFragment.Companion.getTAG());
      }

      Function0 var3 = (Function0)var5.component1();
      String var4 = (String)var5.component2();
      if (this.getChildFragmentManager().findFragmentByTag(var4) == null) {
         DialogfragmentDeviceDetailsBinding var2 = this.viewDataBinding;
         DialogfragmentDeviceDetailsBinding var6 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.graphContainer.setVisibility(0);
         this.getChildFragmentManager().beginTransaction().replace(com.blueair.devicedetails.R.id.graph_container, (Fragment)var3.invoke(), var4).commitAllowingStateLoss();
      }

   }

   private static final DeviceHSensorsFragment showSensorLayout$lambda$4(HasSensorData var0) {
      return DeviceHSensorsFragment.Companion.newInstance(var0);
   }

   private static final DeviceSensorsFragment showSensorLayout$lambda$5(HasSensorData var0) {
      return DeviceSensorsFragment.Companion.newInstance(var0);
   }

   public void dismiss() {
      Fragment var1 = this.getTargetFragment();
      if (var1 != null) {
         var1.onActivityResult(this.getTargetRequestCode(), -1, (Intent)null);
      }

      super.dismiss();
   }

   public final Device getDevice() {
      Device var1 = this.device;
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

   public void onCancel(DialogInterface var1) {
      Intrinsics.checkNotNullParameter(var1, "dialog");
      Fragment var2 = this.getTargetFragment();
      if (var2 != null) {
         var2.onActivityResult(this.getTargetRequestCode(), -1, (Intent)null);
      }

      super.onCancel(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var10 = this.getDialog();
      if (var10 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var11 = var10.getWindow();
         if (var11 != null) {
            var11.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var12 = this.getDialog();
         if (var12 != null) {
            Window var13 = var12.getWindow();
            if (var13 != null) {
               var13.setWindowAnimations(R.style.dialog_animation);
            }
         }
      }

      DialogfragmentDeviceDetailsBinding var14 = DialogfragmentDeviceDetailsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      var14.setDeviceDetailViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      var14.setLifecycleOwner((LifecycleOwner)this);
      this.viewDataBinding = var14;
      Object var9 = null;
      DialogfragmentDeviceDetailsBinding var4 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      DeviceDetailsViewModel var5 = var4.getDeviceDetailViewModel();
      if (var5 != null) {
         this.setViewModel(var5);
         var14 = this.viewDataBinding;
         DialogfragmentDeviceDetailsBinding var6 = var14;
         if (var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.closeBtn.setOnClickListener(new DeviceDetailsDialogFragment$$ExternalSyntheticLambda10(this));
         var6 = this.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeviceDetailsBinding)var9;
         }

         View var8 = var6.getRoot();
         Intrinsics.checkNotNullExpressionValue(var8, "getRoot(...)");
         return var8;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
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
      this.handleActions(true);
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -1);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Bundle var3 = this.getArguments();
      Device var4;
      if (var3 != null) {
         var4 = (Device)var3.getParcelable("device");
      } else {
         var4 = null;
      }

      if (var4 != null) {
         this.setDevice(var4);
         Bundle var5 = this.getArguments();
         String var6;
         if (var5 != null) {
            var6 = var5.getString("action_type");
         } else {
            var6 = null;
         }

         this.actionType = var6;
         jumpToAction = null;
         Timber.Forest var8 = Timber.Forest;
         StringBuilder var7 = new StringBuilder("onViewCreated: viewModel = ");
         var7.append(this.getViewModel());
         var7.append(",  device = ");
         var7.append(this.getDevice());
         var7.append(", actionType = ");
         var7.append(this.actionType);
         var8.d(var7.toString(), new Object[0]);
         this.getViewModel().setAttachedToDeviceDetailsDialogFragment(true);
         this.getViewModel().setDeviceId(this.getDevice().getUid());
         this.bindViewModel();
         this.getChildFragmentManager().setFragmentResultListener("REQUEST_KEY_HANDLE_ACTION", (LifecycleOwner)this, new DeviceDetailsDialogFragment$$ExternalSyntheticLambda9(this));
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(Device var1) {
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
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY_HANDLE_ACTION", "jumpToAction", "getJumpToAction", "()Ljava/lang/String;", "setJumpToAction", "(Ljava/lang/String;)V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceDetailsDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "actionType", "devicedetails_otherRelease"},
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
      public static DeviceDetailsDialogFragment newInstance$default(Companion var0, Device var1, String var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.newInstance(var1, var2);
      }

      public final String getJumpToAction() {
         return DeviceDetailsDialogFragment.jumpToAction;
      }

      public final DeviceDetailsDialogFragment newInstance(Device var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceDetailsDialogFragment var3 = new DeviceDetailsDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1), TuplesKt.to("action_type", var2)}));
         return var3;
      }

      public final void setJumpToAction(String var1) {
         DeviceDetailsDialogFragment.jumpToAction = var1;
      }
   }
}
