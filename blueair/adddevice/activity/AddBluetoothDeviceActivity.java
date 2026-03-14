package com.blueair.adddevice.activity;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.adddevice.databinding.ActivityAddDeviceBinding;
import com.blueair.adddevice.databinding.ViewcoreAppbarBinding;
import com.blueair.adddevice.viewmodel.AddDeviceAction;
import com.blueair.adddevice.viewmodel.AddDeviceScreen;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import com.blueair.bluetooth.utils.BluetoothConnectivityBroadcastReceiver;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.StartOnboardingHelpGuideEvent;
import com.blueair.viewcore.Header;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewCoreAppbar;
import com.blueair.viewcore.ViewCoreAppbar$_CC;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000205H\u0014J\b\u00108\u001a\u000203H\u0002J\b\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u000203H\u0002J\b\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u000203H\u0014J\b\u0010=\u001a\u000203H\u0014J\b\u0010>\u001a\u000203H\u0014J\b\u0010?\u001a\u000203H\u0016J\b\u0010@\u001a\u000203H\u0017J\u0010\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u000203H\u0002J\b\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u000203H\u0002J \u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020HH\u0002J\u0010\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020MH\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b/\u00100¨\u0006O²\u0006\n\u0010P\u001a\u00020QX\u008a\u0084\u0002"},
   d2 = {"Lcom/blueair/adddevice/activity/AddBluetoothDeviceActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/blueair/viewcore/ViewCoreAppbar;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "addDeviceBinding", "Lcom/blueair/adddevice/databinding/ActivityAddDeviceBinding;", "viewModel", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "helpButtonsState", "Lcom/blueair/adddevice/activity/AddBluetoothDeviceActivity$HelpButtonsState;", "headerTitle", "Landroid/widget/TextView;", "getHeaderTitle", "()Landroid/widget/TextView;", "headerMsg", "getHeaderMsg", "progressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "getProgressIndicator", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "actionBar", "Landroidx/appcompat/app/ActionBar;", "getActionBar", "()Landroidx/appcompat/app/ActionBar;", "bluetoothScanHeader", "Lcom/blueair/viewcore/Header;", "getBluetoothScanHeader", "()Lcom/blueair/viewcore/Header;", "bluetoothScanHeader$delegate", "networkBroadcastReceiver", "Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "getNetworkBroadcastReceiver", "()Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "networkBroadcastReceiver$delegate", "currentScreen", "Lcom/blueair/adddevice/viewmodel/AddDeviceScreen;", "onboardingSteps", "", "getOnboardingSteps", "()Ljava/util/List;", "onboardingSteps$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "setupEndButton", "bindViewModel", "observeViewModel", "setBluetoothScanHeader", "onResume", "onPause", "onDestroy", "finish", "onBackPressed", "goForwardToScreen", "nextScreen", "goBackOneScreen", "restartScreens", "showConnectionLost", "setHelpButtonsVisibility", "isHelpVisible", "", "isCustomerSupportVisible", "isTroubleshootingVisible", "deviceSetupHeader", "stepOrdinal", "", "HelpButtonsState", "adddevice_otherRelease", "connectionService", "Lcom/blueair/bluetooth/service/BluetoothConnectivityService;"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddBluetoothDeviceActivity extends BaseActivity implements ViewCoreAppbar {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property0((PropertyReference0)(new PropertyReference0Impl(AddBluetoothDeviceActivity.class, "connectionService", "<v#0>", 0)))};
   private ActivityAddDeviceBinding addDeviceBinding;
   private final Lazy bluetoothScanHeader$delegate;
   private AddDeviceScreen currentScreen;
   private HelpButtonsState helpButtonsState;
   private final Lazy networkBroadcastReceiver$delegate;
   private final Lazy onboardingSteps$delegate;
   private final String screenName = "add_device";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$0cQV__sR5rNAZLl9yljAeYD2JEA/* $FF was: $r8$lambda$0cQV-_sR5rNAZLl9yljAeYD2JEA*/(AddBluetoothDeviceActivity var0, View var1) {
      onCreate$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$0wfEoEo_Jw9u3kulj60pQSJ5GkU(AddBluetoothDeviceActivity var0, String var1, Bundle var2) {
      return onCreate$lambda$11$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$13dyJBeen9sCcXicv4t0sH6c12c(AddBluetoothDeviceActivity var0, String var1, Bundle var2) {
      return showConnectionLost$lambda$20$lambda$19$lambda$18(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$35506roYpumTGMUpxBWhc_NvZhs/* $FF was: $r8$lambda$35506roYpumTGMUpxBWhc-NvZhs*/(AddBluetoothDeviceActivity var0, boolean var1) {
      return showConnectionLost$lambda$20$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SUkM0OfeZBMpAij0wlw1qto8CB0(AddBluetoothDeviceActivity var0, Boolean var1) {
      return observeViewModel$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Header $r8$lambda$V8dEVxCxDi1pQ90DlUS4erBzXU4(AddBluetoothDeviceActivity var0) {
      return bluetoothScanHeader_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static List $r8$lambda$ZhuWbo6yDqJ05fyCBFpPyn1ZYrw(AddBluetoothDeviceActivity var0) {
      return onboardingSteps_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static BluetoothConnectivityBroadcastReceiver $r8$lambda$bXTwcAJ0vHHO10j5mLflDy3aK2A(AddBluetoothDeviceActivity var0) {
      return networkBroadcastReceiver_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$eoukhvkroMfr9Jz7EmDliFLp7rE(AddBluetoothDeviceActivity var0, boolean var1) {
      return onCreate$lambda$8$lambda$7$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fokfi8m7g3hwiGpyvxHYF2cNRqA(AddBluetoothDeviceActivity var0, AddDeviceAction var1) {
      return onResume$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$owdRoJFvpkF42v0GtDYXkKYpgrM(AddBluetoothDeviceActivity var0, AddDeviceScreen var1) {
      return observeViewModel$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$qjAirXdezXqRAKZxw9RP5C8ka18(AddBluetoothDeviceActivity var0, Boolean var1) {
      return observeViewModel$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$wdI7QJOrsELeKeAIN2bhtGK8rAU(AddBluetoothDeviceActivity var0, View var1) {
      onCreate$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zAaYirozlFYsdzlK9cNRKmI2uKw(AddBluetoothDeviceActivity var0, View var1) {
      onCreate$lambda$5(var0, var1);
   }

   public AddBluetoothDeviceActivity() {
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
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AddDeviceViewModel.class), new Function0(var1) {
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
      this.helpButtonsState = AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant;
      this.bluetoothScanHeader$delegate = LazyKt.lazy(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda13(this));
      this.networkBroadcastReceiver$delegate = LazyKt.lazy(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda1(this));
      this.currentScreen = AddDeviceScreen.ChooseDevice;
      this.onboardingSteps$delegate = LazyKt.lazy(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda2(this));
   }

   private final void bindViewModel() {
      ActivityAddDeviceBinding var2 = this.addDeviceBinding;
      ActivityAddDeviceBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var1 = null;
      }

      var1.setAddDeviceViewModel(this.getViewModel());
      var1.setLifecycleOwner((LifecycleOwner)this);
   }

   private static final Header bluetoothScanHeader_delegate$lambda$0(AddBluetoothDeviceActivity var0) {
      String var1 = var0.getResources().getString(R.string.your_devices_title);
      Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
      String var2 = var0.getResources().getString(R.string.get_started_subtitle);
      Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
      return new Header(var1, var2, R.drawable.ic_arrow_back_white, 1);
   }

   private final Header deviceSetupHeader(int var1) {
      String var4;
      label11: {
         BluetoothDevice var2 = this.getViewModel().getSelectedUiDevice();
         if (var2 != null) {
            String var3 = var2.getFamilyName();
            var4 = var3;
            if (var3 != null) {
               break label11;
            }
         }

         var4 = "";
      }

      String var5 = this.getString(R.string.add_device);
      Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
      return new Header(var5, var4, R.drawable.ic_arrow_back_white, var1);
   }

   private final Header getBluetoothScanHeader() {
      return (Header)this.bluetoothScanHeader$delegate.getValue();
   }

   private final BluetoothConnectivityBroadcastReceiver getNetworkBroadcastReceiver() {
      return (BluetoothConnectivityBroadcastReceiver)this.networkBroadcastReceiver$delegate.getValue();
   }

   private final AddDeviceViewModel getViewModel() {
      return (AddDeviceViewModel)this.viewModel$delegate.getValue();
   }

   private final void goBackOneScreen() {
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("goBackOneScreen: currentScreen = ");
      var6.append(this.currentScreen);
      String var13 = var6.toString();
      boolean var4 = false;
      var5.d(var13, new Object[0]);
      AddDeviceScreen var8 = this.currentScreen;
      int var1 = AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()];
      if (var1 == 1) {
         this.finish();
      } else {
         label68: {
            if (var1 != 2 && var1 != 3) {
               if (var1 == 4) {
                  var8 = AddDeviceScreen.WifiList;
                  break label68;
               }

               if (var1 != 5) {
                  throw new NoWhenBranchMatchedException();
               }
            }

            var8 = AddDeviceScreen.ChooseDevice;
         }

         this.currentScreen = var8;
         if (var8 == AddDeviceScreen.ChooseDevice) {
            this.getSupportFragmentManager().popBackStackImmediate((String)null, 1);
         } else {
            this.getSupportFragmentManager().popBackStackImmediate(this.currentScreen.toString(), 0);
         }

         Timber.Forest var10 = Timber.Forest;
         StringBuilder var14 = new StringBuilder("goBackOneScreen: new screen = ");
         var14.append(this.currentScreen);
         var10.d(var14.toString(), new Object[0]);
         AddDeviceScreen var11 = this.currentScreen;
         var1 = AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0[var11.ordinal()];
         Header var12;
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  if (var1 != 4) {
                     if (var1 != 5) {
                        throw new NoWhenBranchMatchedException();
                     }

                     throw new IllegalStateException("Could not go back to a final step");
                  }

                  var12 = this.deviceSetupHeader(2);
               } else {
                  var12 = this.deviceSetupHeader(2);
               }
            } else {
               var12 = this.deviceSetupHeader(3);
            }
         } else {
            var12 = this.getBluetoothScanHeader();
         }

         this.setHeader(var12);
         if (this.currentScreen == AddDeviceScreen.ChooseDevice) {
            this.setHelpButtonsVisibility(false, false, false);
         } else {
            if (this.currentScreen == AddDeviceScreen.WifiList) {
               boolean var2;
               if (this.helpButtonsState == AddBluetoothDeviceActivity.HelpButtonsState.HelpVisible) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.helpButtonsState == AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               if (this.helpButtonsState == AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible) {
                  var4 = true;
               }

               this.setHelpButtonsVisibility(var2, var3, var4);
               this.helpButtonsState = AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant;
            }

         }
      }
   }

   private final void goForwardToScreen(AddDeviceScreen var1) {
      AddDeviceScreen var7 = this.currentScreen;
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("goForwardToScreen: nextScreen = ");
      var3.append(var1);
      var3.append(", currentScreen = ");
      var3.append(var7);
      var4.d(var3.toString(), new Object[0]);
      if (var7 == AddDeviceScreen.ChooseDevice || var7 != var1) {
         Fragment var6 = var1.fragment();
         var4 = Timber.Forest;
         var3 = new StringBuilder("goForwardToScreen: new Fragment = ");
         var3.append(var6);
         var4.d(var3.toString(), new Object[0]);
         FragmentTransaction var8 = this.getSupportFragmentManager().beginTransaction();
         Intrinsics.checkNotNullExpressionValue(var8, "beginTransaction(...)");
         this.currentScreen = var1;
         ViewHelperUtil var9 = ViewHelperUtil.INSTANCE;
         ActivityAddDeviceBinding var5 = this.addDeviceBinding;
         Object var19 = null;
         ActivityAddDeviceBinding var14 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            var14 = null;
         }

         var9.hideSoftKeyboard((View)var14.contentFragment);
         Timber.Forest var20 = Timber.Forest;
         StringBuilder var15 = new StringBuilder("goForwardToScreen: add old fragment to backstack ");
         var15.append(var7);
         var20.d(var15.toString(), new Object[0]);
         ActivityAddDeviceBinding var21 = this.addDeviceBinding;
         ActivityAddDeviceBinding var16 = var21;
         if (var21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
            var16 = null;
         }

         var16.contentFragment.removeAllViews();
         var8.replace(com.blueair.adddevice.R.id.content_fragment, var6, var1.toString());
         if (var1 != AddDeviceScreen.ChooseDevice) {
            var8.addToBackStack(var1.toString());
         }

         var8.commitAllowingStateLoss();
         ActionBar var17 = this.getSupportActionBar();
         if (var17 != null) {
            var17.setDisplayHomeAsUpEnabled(true);
         }

         int var2 = AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 3) {
            if (var2 != 4) {
               this.helpButtonsState = AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant;
               this.setHelpButtonsVisibility(false, false, false);
            } else {
               ActivityAddDeviceBinding var10 = this.addDeviceBinding;
               if (var10 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
                  var10 = (ActivityAddDeviceBinding)var19;
               }

               AppCompatTextView var11 = var10.helpButton;
               Intrinsics.checkNotNullExpressionValue(var11, "helpButton");
               HelpButtonsState var12;
               if (((View)var11).getVisibility() == 0) {
                  var12 = AddBluetoothDeviceActivity.HelpButtonsState.HelpVisible;
               } else {
                  var12 = AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible;
               }

               this.helpButtonsState = var12;
               this.setHelpButtonsVisibility(true, false, false);
            }
         } else {
            this.helpButtonsState = AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant;
            this.setHelpButtonsVisibility(true, false, false);
         }
      }
   }

   private static final BluetoothConnectivityBroadcastReceiver networkBroadcastReceiver_delegate$lambda$2(AddBluetoothDeviceActivity var0) {
      DIAware var2 = var0;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      Lazy var3 = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, BluetoothConnectivityService.class)), (Object)null).provideDelegate((Object)null, $$delegatedProperties[0]);
      networkBroadcastReceiver_delegate$lambda$2$lambda$1(var3).updateBluetoothConnectivityState(BluetoothUtils.INSTANCE.isBluetoothEnabled((Context)var0));
      return new BluetoothConnectivityBroadcastReceiver(networkBroadcastReceiver_delegate$lambda$2$lambda$1(var3));
   }

   private static final BluetoothConnectivityService networkBroadcastReceiver_delegate$lambda$2$lambda$1(Lazy var0) {
      return (BluetoothConnectivityService)var0.getValue();
   }

   private final void observeViewModel() {
      // $FF: Couldn't be decompiled
   }

   private static final Unit observeViewModel$lambda$13(AddBluetoothDeviceActivity var0, AddDeviceScreen var1) {
      Intrinsics.checkNotNullParameter(var1, "nextScreen");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("changing screen to ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      int var2 = AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 != 3) {
               if (var2 != 4) {
                  if (var2 != 5) {
                     throw new NoWhenBranchMatchedException();
                  }

                  var0.setHeader(var0.deviceSetupHeader(4));
               } else {
                  var0.setHeader(var0.deviceSetupHeader(2));
               }
            } else {
               var0.setHeader(var0.deviceSetupHeader(2));
            }
         } else {
            var0.getViewModel().unbindNetwork((Activity)var0);
            var0.setHeader(var0.deviceSetupHeader(3));
         }
      } else {
         var0.getViewModel().unbindNetwork((Activity)var0);
         var0.setHeader(var0.getBluetoothScanHeader());
      }

      var0.goForwardToScreen(var1);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$14(AddBluetoothDeviceActivity var0, Boolean var1) {
      ActivityAddDeviceBinding var4 = var0.addDeviceBinding;
      Object var3 = null;
      ActivityAddDeviceBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var2 = null;
      }

      var2.viewcoreAppbar.btnBack.setEnabled(var1 ^ true);
      ActivityAddDeviceBinding var5 = var0.addDeviceBinding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var5 = (ActivityAddDeviceBinding)var3;
      }

      var5.viewcoreAppbar.btnClose.setEnabled(var1 ^ true);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$15(AddBluetoothDeviceActivity var0, Boolean var1) {
      if (var0.currentScreen == AddDeviceScreen.ChooseDevice) {
         var0.setBluetoothScanHeader();
      }

      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$11(AddBluetoothDeviceActivity var0, View var1) {
      var0.getAnalytics().amplitudeLog(StartOnboardingHelpGuideEvent.INSTANCE);
      FragmentManager var4 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
      boolean var2 = var4.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog;
      Object var3 = null;
      TroubleshootingDialog var5 = (TroubleshootingDialog)var3;
      if (!var2) {
         var5 = (TroubleshootingDialog)var3;
         if (!var4.isStateSaved()) {
            var5 = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, "action_type_wifi_guide", (Device)null, 2, (Object)null);
            ((DialogFragment)var5).show(var4, "TroubleshootingDialog");
         }
      }

      var5 = var5;
      if (var5 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var5, "TroubleshootingDialog", new AddBluetoothDeviceActivity$$ExternalSyntheticLambda0(var0));
      }

   }

   private static final Unit onCreate$lambda$11$lambda$10(AddBluetoothDeviceActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_retry") && var0.currentScreen == AddDeviceScreen.WifiList) {
         var0.getViewModel().refreshSsidsList();
      }

      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$5(AddBluetoothDeviceActivity var0, View var1) {
      var0.onBackPressed();
   }

   private static final void onCreate$lambda$8(AddBluetoothDeviceActivity var0, View var1) {
      if (var0.currentScreen == AddDeviceScreen.ChooseDevice) {
         var0.startActivity(Actions.INSTANCE.openHomeIntent((Context)var0));
         var0.finish();
      } else {
         FragmentManager var6 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var6, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var6.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var6.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion var5 = ConfirmationDialogLeftAligned.Companion;
            int var2 = R.string.label_ensure_leave;
            int var3 = R.string.quit_device_setup_confirmation;
            int var4 = R.string.action_leave;
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var5, var2, (Integer)null, var3, R.string.action_continue, var4, false, false, false, false, (String[])null, (String)null, (Integer)null, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda4(var0), 3936, (Object)null)).show(var6, "ConfirmationDialogLeftAligned");
         }

      }
   }

   private static final Unit onCreate$lambda$8$lambda$7$lambda$6(AddBluetoothDeviceActivity var0, boolean var1) {
      if (!var1) {
         var0.startActivity(Actions.INSTANCE.openHomeIntent((Context)var0));
         var0.finish();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$16(AddBluetoothDeviceActivity var0, AddDeviceAction var1) {
      Intrinsics.checkNotNullParameter(var1, "action");
      int var2 = AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            throw new NoWhenBranchMatchedException();
         }

         var0.showConnectionLost();
      } else {
         var0.restartScreens();
      }

      return Unit.INSTANCE;
   }

   private static final List onboardingSteps_delegate$lambda$4(AddBluetoothDeviceActivity var0) {
      ActivityAddDeviceBinding var1 = var0.addDeviceBinding;
      ActivityAddDeviceBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var2 = null;
      }

      ViewcoreAppbarBinding var3 = var2.viewcoreAppbar;
      return CollectionsKt.emptyList();
   }

   private final void restartScreens() {
      this.currentScreen = AddDeviceScreen.ChooseDevice;

      while(this.getSupportFragmentManager().getBackStackEntryCount() > 0) {
         this.getSupportFragmentManager().popBackStackImmediate();
      }

      this.setBluetoothScanHeader();
      this.setHelpButtonsVisibility(false, false, false);
   }

   private final void setBluetoothScanHeader() {
      if (Intrinsics.areEqual(this.getViewModel().getLvDeviceScanned().getValue(), true)) {
         this.setHeader(this.getBluetoothScanHeader());
      } else {
         Header var2 = this.getBluetoothScanHeader();
         String var1 = this.getString(R.string.add_device);
         Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
         this.setHeader(Header.copy$default(var2, var1, "", (Integer)null, (Integer)null, 12, (Object)null));
      }
   }

   private final void setHelpButtonsVisibility(boolean var1, boolean var2, boolean var3) {
      ActivityAddDeviceBinding var6 = this.addDeviceBinding;
      ActivityAddDeviceBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var5 = null;
      }

      AppCompatTextView var7 = var5.helpButton;
      Intrinsics.checkNotNullExpressionValue(var7, "helpButton");
      View var8 = (View)var7;
      byte var4;
      if (var1) {
         var4 = 0;
      } else {
         var4 = 8;
      }

      var8.setVisibility(var4);
   }

   private final void setupEndButton() {
      ActivityAddDeviceBinding var2 = this.addDeviceBinding;
      ActivityAddDeviceBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var1 = null;
      }

      var1.helpButton.setText((CharSequence)this.getString(R.string.support_need_help));
   }

   private final void showConnectionLost() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.connection_to_purifier_lost, (Integer)null, R.string.connection_to_purifier_hint, R.string.connection_to_purifier_try_again, R.string.action_read_tips, false, false, false, false, (String[])null, (String)null, (Integer)null, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda12(this), 3936, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
      }

   }

   private static final Unit showConnectionLost$lambda$20$lambda$19(AddBluetoothDeviceActivity var0, boolean var1) {
      if (var1) {
         var0.getViewModel().restart();
      } else {
         FragmentManager var3 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
         DialogFragment var2;
         if (!(var3.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var3.isStateSaved()) {
            var2 = TroubleshootingDialog.Companion.newInstanceForBluetooth(var0.getViewModel().getSelectedUiDevice());
            ((DialogFragment)var2).show(var3, "TroubleshootingDialog");
            var3.executePendingTransactions();
         } else {
            var2 = null;
         }

         var2 = var2;
         if (var2 != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var2, "TroubleshootingDialog", new AddBluetoothDeviceActivity$$ExternalSyntheticLambda11(var0));
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit showConnectionLost$lambda$20$lambda$19$lambda$18(AddBluetoothDeviceActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_retry")) {
         var0.getViewModel().restart();
      }

      return Unit.INSTANCE;
   }

   public void finish() {
      AddDeviceScreen var1 = this.currentScreen;
      if (AddBluetoothDeviceActivity.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] != 2) {
         this.getViewModel().disableSoftAp();
      }

      super.finish();
   }

   public ActionBar getActionBar() {
      return this.getSupportActionBar();
   }

   public TextView getHeaderMsg() {
      ActivityAddDeviceBinding var2 = this.addDeviceBinding;
      ActivityAddDeviceBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var1 = null;
      }

      AppCompatTextView var3 = var1.viewcoreAppbar.headerMsg;
      Intrinsics.checkNotNullExpressionValue(var3, "headerMsg");
      return (TextView)var3;
   }

   public TextView getHeaderTitle() {
      ActivityAddDeviceBinding var2 = this.addDeviceBinding;
      ActivityAddDeviceBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var1 = null;
      }

      AppCompatTextView var3 = var1.viewcoreAppbar.headerTitle;
      Intrinsics.checkNotNullExpressionValue(var3, "headerTitle");
      return (TextView)var3;
   }

   public List getOnboardingSteps() {
      return (List)this.onboardingSteps$delegate.getValue();
   }

   public LinearProgressIndicator getProgressIndicator() {
      ActivityAddDeviceBinding var2 = this.addDeviceBinding;
      ActivityAddDeviceBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var1 = null;
      }

      LinearProgressIndicator var3 = var1.viewcoreAppbar.progressIndicator;
      Intrinsics.checkNotNullExpressionValue(var3, "progressIndicator");
      return var3;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onBackPressed() {
      if (!Intrinsics.areEqual(this.getViewModel().getLvBlockNavigation().getValue(), true)) {
         this.goBackOneScreen();
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ViewDataBinding var6 = DataBindingUtil.setContentView((Activity)this, com.blueair.adddevice.R.layout.activity_add_device);
      Intrinsics.checkNotNullExpressionValue(var6, "setContentView(...)");
      this.addDeviceBinding = (ActivityAddDeviceBinding)var6;
      BaseLokaliseActivity var7 = this;
      boolean var5 = false;
      Object var12 = null;
      BaseLokaliseActivity.immersiveStatusBar$default(var7, false, 1, (Object)null);
      this.setStatusMode(true);
      HelpButtonsState[] var13 = AddBluetoothDeviceActivity.HelpButtonsState.values();
      int var2;
      if (var1 != null) {
         var2 = var1.getInt("KEY_HELP_BUTTONS_STATE", AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant.ordinal());
      } else {
         var2 = AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant.ordinal();
      }

      HelpButtonsState var8 = var13[var2];
      this.helpButtonsState = var8;
      if (var8 != AddBluetoothDeviceActivity.HelpButtonsState.Irrelevant) {
         boolean var3;
         if (this.helpButtonsState == AddBluetoothDeviceActivity.HelpButtonsState.HelpVisible) {
            var3 = true;
         } else {
            var3 = false;
         }

         boolean var4;
         if (this.helpButtonsState == AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible) {
            var4 = true;
         } else {
            var4 = false;
         }

         if (this.helpButtonsState == AddBluetoothDeviceActivity.HelpButtonsState.TroubleshootingAndCustomerSupportVisible) {
            var5 = true;
         }

         this.setHelpButtonsVisibility(var3, var4, var5);
      }

      this.bindViewModel();
      this.setHeader(this.getBluetoothScanHeader());
      this.observeViewModel();
      this.setupEndButton();
      ActivityAddDeviceBinding var14 = this.addDeviceBinding;
      ActivityAddDeviceBinding var9 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var9 = null;
      }

      var9.viewcoreAppbar.btnBack.setOnClickListener(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda8(this));
      var14 = this.addDeviceBinding;
      var9 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var9 = null;
      }

      var9.viewcoreAppbar.btnClose.setOnClickListener(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda9(this));
      var9 = this.addDeviceBinding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("addDeviceBinding");
         var9 = (ActivityAddDeviceBinding)var12;
      }

      var9.helpButton.setOnClickListener(new AddBluetoothDeviceActivity$$ExternalSyntheticLambda10(this));
   }

   protected void onDestroy() {
      this.getViewModel().unbindNetwork((Activity)this);
      super.onDestroy();
   }

   protected void onPause() {
      this.unregisterReceiver(this.getNetworkBroadcastReceiver());
      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      this.registerReceiver(this.getNetworkBroadcastReceiver(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
      if (!this.getViewModel().isUserLoggedIn()) {
         this.finish();
      }

      CompositeDisposable var2 = this.getRxSubs();
      Observable var1 = RxExtensionsKt.filterRapidClicks((Observable)this.getViewModel().getActionPublisher());
      Intrinsics.checkNotNullExpressionValue(var1, "filterRapidClicks(...)");
      var2.add(RxExtensionsKt.subscribeAndLogE(var1, new AddBluetoothDeviceActivity$$ExternalSyntheticLambda3(this)));
   }

   protected void onSaveInstanceState(Bundle var1) {
      Intrinsics.checkNotNullParameter(var1, "outState");
      var1.putInt("KEY_HELP_BUTTONS_STATE", this.helpButtonsState.ordinal());
      super.onSaveInstanceState(var1);
   }

   public void setHeader(Header var1) {
      ViewCoreAppbar$_CC.$default$setHeader(this, var1);
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/adddevice/activity/AddBluetoothDeviceActivity$HelpButtonsState;", "", "<init>", "(Ljava/lang/String;I)V", "HelpVisible", "TroubleshootingAndCustomerSupportVisible", "Irrelevant", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static enum HelpButtonsState {
      private static final EnumEntries $ENTRIES;
      private static final HelpButtonsState[] $VALUES;
      HelpVisible,
      Irrelevant,
      TroubleshootingAndCustomerSupportVisible;

      // $FF: synthetic method
      private static final HelpButtonsState[] $values() {
         return new HelpButtonsState[]{HelpVisible, TroubleshootingAndCustomerSupportVisible, Irrelevant};
      }

      static {
         HelpButtonsState[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
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
         int[] var0 = new int[AddDeviceScreen.values().length];

         try {
            var0[AddDeviceScreen.ChooseDevice.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[AddDeviceScreen.Success.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[AddDeviceScreen.WifiList.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[AddDeviceScreen.WifiPassword.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[AddDeviceScreen.EnterDeviceName.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[AddDeviceAction.values().length];

         try {
            var0[AddDeviceAction.Restart.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[AddDeviceAction.ShowConnectionLost.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
