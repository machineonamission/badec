package com.blueair.adddevice.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.FragmentWifiPasswordBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.Ssid;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.ViewUtilsKt;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.jakewharton.rxbinding2.view.RxView;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004:\u0001EB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001aH\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u000eH\u0002J\b\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001cH\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\u0012\u0010:\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010=\u001a\u00020\u001a2\b\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010?\u001a\u00020\u001cH\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010@\u001a\u00020\u0002X\u0096\u000f¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"},
   d2 = {"Lcom/blueair/adddevice/fragment/WifiPasswordFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentWifiPasswordBinding;", "passwordErrorCount", "", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "showProgress", "", "shouldShowProgress", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "polling", "updateNextEnabled", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "displayLegalCharactersDescription", "doSuccess", "resetInputError", "showErrorMsg", "msgRes", "showInputError", "showNetworkError", "showInputWifiConnError", "showInputConnectError", "showRandRegisterError", "validateFields", "validator", "Lkotlin/text/Regex;", "validatePassword", "hideProgress", "context", "Landroid/content/Context;", "updateDebugView", "message", "isError", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WifiPasswordFragment extends BaseFragment implements ProgressFragment, BaseFragmentInterface {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String INCORRECT_PASSWORD_ERROR = "AuthError";
   private static final String WIFI_REGEX_PATTERN = "[A-Za-z0-9~!@#$%^&*()_+`\\-={}\\[\\]:;<>./\\\\]*";
   private final AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
   private int passwordErrorCount;
   private volatile boolean polling;
   private ProgressBlockerView progressBlockerView;
   private final String screenName = "add_device_wifi_password";
   private final Regex validator = new Regex("[A-Za-z0-9~!@#$%^&*()_+`\\-={}\\[\\]:;<>./\\\\]*");
   private FragmentWifiPasswordBinding viewDataBinding;

   // $FF: synthetic method
   public static Unit $r8$lambda$3ehZR2aJYptsZQhqUndng83Lu4g(WifiPasswordFragment var0, boolean var1) {
      return showInputError$lambda$20$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GhfvtfhH7UbGcbDAZs0hK1PUYOA(WifiPasswordFragment var0, Object var1) {
      return onResume$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$Hp0nCAuoPprr0UM7VrfP1aDuims(WifiPasswordFragment var0, BleDeviceError var1) {
      return onResume$lambda$11$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$IqZnxn3bHzhca6seGz7DqKZYiDw(WifiPasswordFragment var0, BleDeviceState var1) {
      return onResume$lambda$13$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$NPG6SX7mggdlGO_0XfANgzKM0bg(Observable var0, WifiPasswordFragment var1, BleDeviceError var2) {
      return onResume$lambda$11$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SXT_YY8un16VZtitas7zx_qizF4/* $FF was: $r8$lambda$SXT-YY8un16VZtitas7zx-qizF4*/(WifiPasswordFragment var0, String var1, Bundle var2) {
      return showRandRegisterError$lambda$24$lambda$23$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Tm_AlX1_4SDW6nsbW_zNjtgOp1s/* $FF was: $r8$lambda$Tm-AlX1-4SDW6nsbW_zNjtgOp1s*/(Function1 var0, Object var1) {
      onResume$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YUmXef1qEC5_bdLCDidr6KtWgH8/* $FF was: $r8$lambda$YUmXef1qEC5-bdLCDidr6KtWgH8*/(WifiPasswordFragment var0, Boolean var1) {
      return onResume$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$emnqm8fyZgqHAArKcUvhEFKm4zs(Function1 var0, Object var1) {
      return onResume$lambda$11$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jsxIYfIfTQkYFO_x1kcGguHdzBs(Function1 var0, Object var1) {
      onResume$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pbxQQPgJ_49GiCzVta8U1DPcRs8(WifiPasswordFragment var0, String var1, Bundle var2) {
      return showInputError$lambda$20$lambda$19$lambda$18(var0, var1, var2);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$sGuJbCqM6dyTHXXbnJYtQRidgNE(WifiPasswordFragment var0, Object var1) {
      return onResume$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vxMYM_vsZbi9oxwslmjHqp7PSi8/* $FF was: $r8$lambda$vxMYM-vsZbi9oxwslmjHqp7PSi8*/(WifiPasswordFragment var0, boolean var1) {
      return showRandRegisterError$lambda$24$lambda$23(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$w15RyqSf50p0G0w_CBqdOI7AsUI(Throwable var0) {
      return onResume$lambda$5(var0);
   }

   private final void displayLegalCharactersDescription() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.wifi_password_description_title, (Integer)null, R.string.wifi_password_description_content, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
      }

   }

   private final void doSuccess() {
      this.hideProgress(this.getContext());
      this.getViewModel().gotoSuccessScreen();
   }

   private static final Unit onResume$lambda$11$lambda$10(Observable var0, WifiPasswordFragment var1, BleDeviceError var2) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("selectedBleDeviceStateObserver: state = ");
      var4.append(var0);
      var4.append(", error = ");
      var4.append(var2);
      var3.d(var4.toString(), new Object[0]);
      var1.hideProgress(var1.getContext());
      if (var2.getStateOccurred() instanceof BleDeviceState.PollingWifiConfigStatus && Intrinsics.areEqual(var2.getMessage(), "AuthError")) {
         var1.showInputError();
      } else if (var2.getStateOccurred() instanceof BleDeviceState.PollingWifiConfigStatus && Intrinsics.areEqual(var2.getMessage(), "NetworkNotFound")) {
         var1.showNetworkError();
      }

      return Unit.INSTANCE;
   }

   private static final boolean onResume$lambda$11$lambda$8(WifiPasswordFragment var0, BleDeviceError var1) {
      Intrinsics.checkNotNullParameter(var1, "error");
      var0.updateDebugView(var1.getMessage(), true);
      return var0.polling;
   }

   private static final boolean onResume$lambda$11$lambda$9(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (Boolean)var0.invoke(var1);
   }

   private static final Unit onResume$lambda$13$lambda$12(WifiPasswordFragment var0, BleDeviceState var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("selectedBleDeviceStateObserver: state = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      if (Intrinsics.areEqual(var1, BleDeviceState.WifiConnected.INSTANCE)) {
         var0.doSuccess();
      } else if (Intrinsics.areEqual(var1, BleDeviceState.Disconnected.INSTANCE)) {
         var0.getViewModel().showConnectionLost();
      }

      var0.updateDebugView(var1.getName(), false);
      return Unit.INSTANCE;
   }

   private static final boolean onResume$lambda$14(WifiPasswordFragment var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return var0.validateFields();
   }

   private static final Unit onResume$lambda$15(WifiPasswordFragment var0, Object var1) {
      FragmentWifiPasswordBinding var2 = var0.viewDataBinding;
      FragmentWifiPasswordBinding var4 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      var4.buttonNext.setEnabled(false);
      BaseViewModel.showProgress$default(var0.getViewModel(), false, 1, (Object)null);
      AddDeviceViewModel.blockNavigation$default(var0.getViewModel(), false, 1, (Object)null);
      var0.resetInputError();
      AddDeviceViewModel var3 = var0.getViewModel();
      var2 = var0.viewDataBinding;
      var4 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      var3.setPassword$adddevice_otherRelease(String.valueOf(var4.passwordEditText.getText()));
      ViewHelperUtil.INSTANCE.hideSoftKeyboard(var0.getView());
      BuildersKt.launch$default(var0, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(var0, (Continuation)null) {
         Object L$0;
         boolean Z$0;
         int label;
         final WifiPasswordFragment this$0;

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
            WifiPasswordFragment var13;
            label46: {
               Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               Object var4 = null;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var13 = (WifiPasswordFragment)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     break label46;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  CoroutineContext var9 = (CoroutineContext)Dispatchers.getIO();
                  Function2 var5 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final WifiPasswordFragment this$0;

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
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 == 1) {
                              ResultKt.throwOnFailure(var1);
                              return var1;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        } else {
                           ResultKt.throwOnFailure(var1);
                           AddDeviceViewModel var5 = this.this$0.getViewModel();
                           Continuation var4 = (Continuation)this;
                           this.label = 1;
                           Object var6 = var5.provisionSelectedBleDevice(var4);
                           return var6 == var3 ? var3 : var6;
                        }
                     }
                  };
                  Continuation var7 = (Continuation)this;
                  this.label = 1;
                  Object var14 = BuildersKt.withContext(var9, var5, var7);
                  var1 = (WifiPasswordFragment)var14;
                  if (var14 == var6) {
                     return var6;
                  }
               }

               boolean var3 = (Boolean)var1;
               if (!var3) {
                  var1 = this.this$0;
                  var1.hideProgress(var1.getContext());
                  if (Intrinsics.areEqual(this.this$0.getViewModel().isSelectedBleDeviceConnected(), Boxing.boxBoolean(false))) {
                     this.this$0.showInputConnectError();
                     return Unit.INSTANCE;
                  } else {
                     if (this.this$0.getViewModel().isRandRegisterFailed()) {
                        this.this$0.showRandRegisterError();
                     } else if (Intrinsics.areEqual(this.this$0.getViewModel().isSelectedBleDeviceWifiConnected(), Boxing.boxBoolean(false))) {
                        this.this$0.showInputWifiConnError();
                        return Unit.INSTANCE;
                     }

                     return Unit.INSTANCE;
                  }
               }

               UserInfoCollectionsManager var15 = UserInfoCollectionsManager.INSTANCE;
               UserInfoItem var17 = UserInfoItem.NET_WIFI_SSID;
               Ssid var8 = (Ssid)this.this$0.getViewModel().getSelectedSsid().getValue();
               String var10 = (String)var4;
               if (var8 != null) {
                  var10 = var8.getSsid();
               }

               UserInfoCollectionsManager.addRecord$default(var15, var17, String.valueOf(var10), false, 4, (Object)null);
               var13 = this.this$0;
               AddDeviceViewModel var11 = var13.getViewModel();
               Continuation var16 = (Continuation)this;
               this.L$0 = var13;
               this.Z$0 = var3;
               this.label = 2;
               var1 = (WifiPasswordFragment)var11.pollwifiConnected(var16);
               if (var1 == var6) {
                  return var6;
               }
            }

            var13.polling = (Boolean)var1;
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$3(WifiPasswordFragment var0, Boolean var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("connectionChangedObserver: hasBluetooth = ");
      var3.append(var1);
      var3.append(", hasSelectedBleDevice = ");
      var3.append(var0.getViewModel().getHasSelectedBleDevice());
      var2.d(var3.toString(), new Object[0]);
      if (!var1) {
         var0.getViewModel().showConnectionLost();
      }

      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$4(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$5(Throwable var0) {
      Intrinsics.checkNotNullParameter(var0, "t");
      Timber.Forest.e(var0, "Connection Change Observer failed", new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$6(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final void resetInputError() {
      FragmentWifiPasswordBinding var3 = this.viewDataBinding;
      Object var2 = null;
      FragmentWifiPasswordBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.tvError.setText((CharSequence)null);
      var3 = this.viewDataBinding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.tvError.setVisibility(8);
      var1 = this.viewDataBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = (FragmentWifiPasswordBinding)var2;
      }

      TextInputLayout var6 = var1.inputPassword;
      Intrinsics.checkNotNullExpressionValue(var6, "inputPassword");
      ViewUtilsKt.bindSelected(var6, false);
   }

   private final void showErrorMsg(int var1) {
      this.polling = false;
      this.hideProgress(this.getContext());
      FragmentWifiPasswordBinding var4 = this.viewDataBinding;
      Object var3 = null;
      FragmentWifiPasswordBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.buttonNext.setEnabled(true);
      var4 = this.viewDataBinding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.tvError.setText((CharSequence)this.getString(var1));
      var4 = this.viewDataBinding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.tvError.setVisibility(0);
      var2 = this.viewDataBinding;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = (FragmentWifiPasswordBinding)var3;
      }

      TextInputLayout var8 = var2.inputPassword;
      Intrinsics.checkNotNullExpressionValue(var8, "inputPassword");
      ViewUtilsKt.bindSelected(var8, true);
   }

   private final void showInputConnectError() {
      this.showErrorMsg(R.string.connection_to_purifier_lost);
   }

   private final void showInputError() {
      this.showErrorMsg(R.string.password_error_msg);
      FragmentWifiPasswordBinding var3 = this.viewDataBinding;
      FragmentWifiPasswordBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      TextInputLayout var4 = var2.inputPassword;
      Intrinsics.checkNotNullExpressionValue(var4, "inputPassword");
      ViewUtilsKt.bindSelected(var4, true);
      this.getViewModel().postAnalyticsEvent(new AnalyticEvent.BT_INCORRECT_PW());
      int var1 = this.passwordErrorCount + 1;
      this.passwordErrorCount = var1;
      if (var1 >= 2) {
         FragmentManager var5 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var5.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var5.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_trouble_connecting_wifi, (Integer)null, R.string.hint_trouble_connecting_wifi, R.string.connection_to_purifier_try_again, R.string.action_read_tips, false, false, false, false, (String[])null, (String)null, (Integer)null, new WifiPasswordFragment$$ExternalSyntheticLambda0(this), 3936, (Object)null)).show(var5, "ConfirmationDialogLeftAligned");
            var5.executePendingTransactions();
         }
      }

   }

   private static final Unit showInputError$lambda$20$lambda$19(WifiPasswordFragment var0, boolean var1) {
      if (var1) {
         var0.getViewModel().restart();
      } else {
         FragmentManager var4 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
         var1 = var4.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog;
         Object var3 = null;
         TroubleshootingDialog var2 = (TroubleshootingDialog)var3;
         if (!var1) {
            var2 = (TroubleshootingDialog)var3;
            if (!var4.isStateSaved()) {
               var2 = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, "action_type_wifi_guide", (Device)null, 2, (Object)null);
               ((DialogFragment)var2).show(var4, "TroubleshootingDialog");
               var4.executePendingTransactions();
            }
         }

         var2 = var2;
         if (var2 != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var2, "TroubleshootingDialog", new WifiPasswordFragment$$ExternalSyntheticLambda4(var0));
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit showInputError$lambda$20$lambda$19$lambda$18(WifiPasswordFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_retry")) {
         var0.getViewModel().restart();
      }

      return Unit.INSTANCE;
   }

   private final void showInputWifiConnError() {
      this.showErrorMsg(R.string.wifi_disconnected);
   }

   private final void showNetworkError() {
      this.showErrorMsg(R.string.network_found_error);
   }

   private final void showRandRegisterError() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_failed_to_register_device, (Integer)null, R.string.hint_failed_to_register_device, R.string.connection_to_purifier_try_again, R.string.action_read_tips, false, false, false, false, (String[])null, (String)null, (Integer)null, new WifiPasswordFragment$$ExternalSyntheticLambda5(this), 3936, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
         var1.executePendingTransactions();
      }

   }

   private static final Unit showRandRegisterError$lambda$24$lambda$23(WifiPasswordFragment var0, boolean var1) {
      if (var1) {
         var0.getViewModel().restart();
      } else {
         FragmentManager var4 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
         var1 = var4.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog;
         Object var3 = null;
         TroubleshootingDialog var2 = (TroubleshootingDialog)var3;
         if (!var1) {
            var2 = (TroubleshootingDialog)var3;
            if (!var4.isStateSaved()) {
               var2 = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, "action_type_wifi_guide", (Device)null, 2, (Object)null);
               ((DialogFragment)var2).show(var4, "TroubleshootingDialog");
               var4.executePendingTransactions();
            }
         }

         var2 = var2;
         if (var2 != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var2, "TroubleshootingDialog", new WifiPasswordFragment$$ExternalSyntheticLambda3(var0));
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit showRandRegisterError$lambda$24$lambda$23$lambda$22(WifiPasswordFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_retry")) {
         var0.getViewModel().restart();
      }

      return Unit.INSTANCE;
   }

   private final void updateDebugView(String var1, boolean var2) {
   }

   private final void updateNextEnabled() {
      FragmentWifiPasswordBinding var6 = this.viewDataBinding;
      Object var5 = null;
      FragmentWifiPasswordBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      int var1 = ((CharSequence)String.valueOf(var4.ssidEditText.getText())).length();
      boolean var3 = true;
      if (var1 > 0) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      var6 = this.viewDataBinding;
      var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      boolean var2;
      if (String.valueOf(var4.passwordEditText.getText()).length() >= 8) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4 = this.viewDataBinding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = (FragmentWifiPasswordBinding)var5;
      }

      MaterialButton var10 = var4.buttonNext;
      if (this.getViewModel().isHiddenNetwork()) {
         if (var1 && var2) {
            var2 = var3;
         } else {
            var2 = false;
         }
      }

      var10.setEnabled(var2);
   }

   private final boolean validateFields() {
      if (this.getViewModel().isHiddenNetwork()) {
         FragmentWifiPasswordBinding var2 = this.viewDataBinding;
         FragmentWifiPasswordBinding var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = null;
         }

         String var3 = String.valueOf(var1.ssidEditText.getText());
         this.getViewModel().getSelectedSsid().setValue(new Ssid(var3, (String)null, 0, (String)null));
      }

      return this.validatePassword();
   }

   private final boolean validatePassword() {
      FragmentWifiPasswordBinding var3 = this.viewDataBinding;
      Object var2 = null;
      FragmentWifiPasswordBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      String.valueOf(var1.passwordEditText.getText());
      Ssid var6 = (Ssid)this.getViewModel().getSelectedSsid().getValue();
      String var4 = (String)var2;
      if (var6 != null) {
         var4 = var6.getSsid();
      }

      if (var4 == null) {
         FragmentActivity var5 = this.getActivity();
         if (var5 != null) {
            ViewUtils.INSTANCE.showSnackbar((Activity)var5, R.string.select_network_error, ViewUtils.MessageType.WARNING.INSTANCE);
         }

         return false;
      } else {
         return true;
      }
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentWifiPasswordBinding var2 = this.viewDataBinding;
      FragmentWifiPasswordBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "rootLayout");
      return var3;
   }

   public CompositeDisposable getRxSubs() {
      return super.getRxSubs();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public AddDeviceViewModel getViewModel() {
      return this.$$delegate_0.getViewModel();
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
      this.getViewModel().blockNavigation(false);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentWifiPasswordBinding var11 = FragmentWifiPasswordBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var11, "inflate(...)");
      FragmentActivity var4 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
      var11.setAddDeviceViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var4)).get(AddDeviceViewModel.class)));
      var11.setLifecycleOwner((LifecycleOwner)this.requireActivity());
      this.viewDataBinding = var11;
      Object var10 = null;
      FragmentWifiPasswordBinding var5 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      this.setProgressBlockerView(var5.progressView);
      var11 = this.viewDataBinding;
      var5 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var5 = null;
      }

      AddDeviceViewModel var7 = var5.getAddDeviceViewModel();
      Intrinsics.checkNotNull(var7);
      this.setViewModel(var7);
      FragmentWifiPasswordBinding var8 = this.viewDataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = (FragmentWifiPasswordBinding)var10;
      }

      View var9 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
      return var9;
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().recordResume("wifi_password");
      this.getRxSubs().add(RxExtensionsKt.uiThread(this.getViewModel().getBluetoothConnectionStateObserver()).subscribe(new WifiPasswordFragment$$ExternalSyntheticLambda7(new WifiPasswordFragment$$ExternalSyntheticLambda6(this)), new WifiPasswordFragment$$ExternalSyntheticLambda9(new WifiPasswordFragment$$ExternalSyntheticLambda8())));
      if (this.polling) {
         BleDeviceError var1 = this.getViewModel().getSelectedBleDeviceError();
         if (var1 != null) {
            Timber.Forest var2 = Timber.Forest;
            StringBuilder var3 = new StringBuilder("selectedBleDeviceError: error = ");
            var3.append(var1);
            var2.d(var3.toString(), new Object[0]);
            this.showInputError();
         }
      }

      Observable var9 = this.getViewModel().getSelectedBleDeviceErrorObserver();
      if (var9 != null) {
         CompositeDisposable var13 = this.getRxSubs();
         Observable var4 = var9.observeOn(AndroidSchedulers.mainThread()).filter(new WifiPasswordFragment$$ExternalSyntheticLambda11(new WifiPasswordFragment$$ExternalSyntheticLambda10(this)));
         Intrinsics.checkNotNullExpressionValue(var4, "filter(...)");
         var13.add(RxExtensionsKt.subscribeAndLogE(var4, new WifiPasswordFragment$$ExternalSyntheticLambda12(var9, this)));
      }

      if (Intrinsics.areEqual(this.getViewModel().isSelectedBleDeviceWifiConnected(), true)) {
         this.doSuccess();
      }

      var9 = this.getViewModel().getSelectedBleDeviceStateObserver();
      if (var9 != null) {
         CompositeDisposable var5 = this.getRxSubs();
         var9 = var9.observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var9, "observeOn(...)");
         var5.add(RxExtensionsKt.subscribeAndLogE(var9, new WifiPasswordFragment$$ExternalSyntheticLambda13(this)));
      }

      CompositeDisposable var14 = this.getRxSubs();
      FragmentWifiPasswordBinding var12 = this.viewDataBinding;
      FragmentWifiPasswordBinding var6 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      Observable var7 = RxView.clicks((View)var6.buttonNext);
      Intrinsics.checkNotNullExpressionValue(var7, "clicks(...)");
      var7 = RxExtensionsKt.filterRapidClicks(RxExtensionsKt.uiThread(var7)).filter(new WifiPasswordFragment$$ExternalSyntheticLambda1(this));
      Intrinsics.checkNotNullExpressionValue(var7, "filter(...)");
      var14.add(RxExtensionsKt.subscribeAndLogE(var7, new WifiPasswordFragment$$ExternalSyntheticLambda2(this)));
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      boolean var3 = this.getViewModel().isHiddenNetwork();
      Object var14 = null;
      if (var3) {
         FragmentWifiPasswordBinding var4 = this.viewDataBinding;
         FragmentWifiPasswordBinding var5 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = null;
         }

         var5.ssidEditTextLayout.setEnabled(true);
         var4 = this.viewDataBinding;
         var5 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = null;
         }

         var5.tvSubtitle.setText((CharSequence)this.getString(R.string.label_enter_wifi_info));
      }

      FragmentWifiPasswordBinding var16 = this.viewDataBinding;
      FragmentWifiPasswordBinding var7 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = null;
      }

      TextInputEditText var17 = var7.ssidEditText;
      Ssid var8 = (Ssid)this.getViewModel().getSelectedSsid().getValue();
      String var9;
      if (var8 != null) {
         var9 = var8.getSsid();
      } else {
         var9 = null;
      }

      var17.setText((CharSequence)var9);
      FragmentWifiPasswordBinding var18 = this.viewDataBinding;
      FragmentWifiPasswordBinding var10 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var10 = null;
      }

      TextInputEditText var11 = var10.ssidEditText;
      Intrinsics.checkNotNullExpressionValue(var11, "ssidEditText");
      ((TextView)var11).addTextChangedListener(new TextWatcher(this) {
         final WifiPasswordFragment this$0;

         public {
            this.this$0 = var1;
         }

         public void afterTextChanged(Editable var1) {
            this.this$0.updateNextEnabled();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      FragmentWifiPasswordBinding var12 = this.viewDataBinding;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var12 = (FragmentWifiPasswordBinding)var14;
      }

      TextInputEditText var13 = var12.passwordEditText;
      Intrinsics.checkNotNullExpressionValue(var13, "passwordEditText");
      ((TextView)var13).addTextChangedListener(new TextWatcher(this) {
         final WifiPasswordFragment this$0;

         public {
            this.this$0 = var1;
         }

         public void afterTextChanged(Editable var1) {
            this.this$0.updateNextEnabled();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
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

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/adddevice/fragment/WifiPasswordFragment$Companion;", "", "<init>", "()V", "INCORRECT_PASSWORD_ERROR", "", "WIFI_REGEX_PATTERN", "adddevice_otherRelease"},
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
   }
}
