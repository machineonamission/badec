package com.blueair.adddevice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.FragmentAddDeviceSuccessBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.OnboardingFailureEvent;
import com.blueair.core.model.OnboardingSuccessEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.jakewharton.rxbinding2.view.RxView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u001c\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001cH\u0096\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\u00020\u0002X\u0096\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"},
   d2 = {"Lcom/blueair/adddevice/fragment/AddDeviceSuccessFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceSuccessBinding;", "troubleShowTime", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "showSuccess", "isSuccess", "", "errorMessage", "showProgress", "shouldShowProgress", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceSuccessFragment extends BaseFragment implements BaseFragmentInterface {
   private final AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
   private final String screenName = "add_device_connecting";
   private long troubleShowTime;
   private FragmentAddDeviceSuccessBinding viewDataBinding;

   // $FF: synthetic method
   public static boolean $r8$lambda$Im5a_7RGoE3xVC_BybW4tkTITXM/* $FF was: $r8$lambda$Im5a-7RGoE3xVC-BybW4tkTITXM*/(AddDeviceSuccessFragment var0, BleDeviceError var1) {
      return onResume$lambda$5$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$Oz64dghCA3JmBH35mpS_j_dbhr0/* $FF was: $r8$lambda$Oz64dghCA3JmBH35mpS_j-dbhr0*/(Function1 var0, Object var1) {
      return onResume$lambda$5$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WqvuZRJ3M_pdtP8aQDUu0_gd3jA/* $FF was: $r8$lambda$WqvuZRJ3M_pdtP8aQDUu0-gd3jA*/(AddDeviceSuccessFragment var0, Object var1) {
      return onResume$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$dkPv_cZmKZdqdjAkYU0PbBUlsQo(AddDeviceSuccessFragment var0, BleDeviceState var1) {
      return onResume$lambda$7$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zURKQpFEz9SdsD6uafRN5nA6rNo(AddDeviceSuccessFragment var0, BleDeviceError var1) {
      return onResume$lambda$5$lambda$4(var0, var1);
   }

   private static final boolean onResume$lambda$5$lambda$2(AddDeviceSuccessFragment var0, BleDeviceError var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return var0.getViewModel().getPolling();
   }

   private static final boolean onResume$lambda$5$lambda$3(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (Boolean)var0.invoke(var1);
   }

   private static final Unit onResume$lambda$5$lambda$4(AddDeviceSuccessFragment var0, BleDeviceError var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("selectedBleDeviceStateObserver: state = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      if (Intrinsics.areEqual(var1.getStateOccurred(), BleDeviceState.WifiConnected.INSTANCE)) {
         var0.showSuccess(false, var1.getMessage());
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$7$lambda$6(AddDeviceSuccessFragment var0, BleDeviceState var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("selectedBleDeviceStateObserver: state = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      if (Intrinsics.areEqual(var1, BleDeviceState.Bounded.INSTANCE)) {
         showSuccess$default(var0, true, (String)null, 2, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$8(AddDeviceSuccessFragment var0, Object var1) {
      var0.getViewModel().gotoEnterNameScreen();
      return Unit.INSTANCE;
   }

   private final void showSuccess(boolean var1, String var2) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("showSuccess: isSuccess = ");
      var4.append(var1);
      var4.append(", errorMessage = ");
      var4.append(var2);
      var3.d(var4.toString(), new Object[0]);
      Object var6 = null;
      if (var1) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final AddDeviceSuccessFragment this$0;

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
               Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  String var3;
                  AnalyticsService var6;
                  label47: {
                     ResultKt.throwOnFailure(var1);
                     var6 = this.this$0.getAnalytics();
                     var1 = this.this$0.getViewModel().getSelectedUiDevice();
                     var3 = "";
                     if (var1 != null) {
                        var1 = var1.getDeviceType();
                        if (var1 != null) {
                           String var4 = var1.getName();
                           var9 = var4;
                           if (var4 != null) {
                              break label47;
                           }
                        }
                     }

                     var9 = "";
                  }

                  String var21 = this.this$0.getViewModel().getDetectedDeviceUuid();
                  if (var21 != null) {
                     var3 = var21;
                  }

                  var6.amplitudeLog(new OnboardingSuccessEvent(var9, var3, false));
                  AddDeviceViewModel.logStep5OnboardingSuccess$default(this.this$0.getViewModel(), (String)null, 1, (Object)null);
                  FragmentAddDeviceSuccessBinding var16 = this.this$0.viewDataBinding;
                  FragmentAddDeviceSuccessBinding var10 = var16;
                  if (var16 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                     var10 = null;
                  }

                  ProgressBlockerView var11 = var10.progressView;
                  Intrinsics.checkNotNullExpressionValue(var11, "progressView");
                  ViewExtensionsKt.hide((View)var11);
                  if (this.this$0.getContext() != null) {
                     AddDeviceSuccessFragment var22 = this.this$0;
                     var16 = var22.viewDataBinding;
                     FragmentAddDeviceSuccessBinding var12 = var16;
                     if (var16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                        var12 = null;
                     }

                     var12.ivIndicator.setImageResource(R.drawable.ic_success_flat);
                     var16 = var22.viewDataBinding;
                     var12 = var16;
                     if (var16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                        var12 = null;
                     }

                     var12.tvStatus.setText(R.string.label_connected);
                     var16 = var22.viewDataBinding;
                     var12 = var16;
                     if (var16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                        var12 = null;
                     }

                     var12.tvContent.setText(R.string.msg_wifi_connection_successful);
                  }

                  CoroutineContext var20 = (CoroutineContext)Dispatchers.getIO();
                  Function2 var15 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final AddDeviceSuccessFragment this$0;

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
                           this.this$0.getViewModel().addDevice();
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var23 = (Continuation)this;
                  this.label = 1;
                  if (BuildersKt.withContext(var20, var15, var23) == var5) {
                     return var5;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
         FragmentAddDeviceSuccessBinding var5 = this.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (FragmentAddDeviceSuccessBinding)var6;
         }

         var5.buttonContinue.setVisibility(0);
      } else {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, var2, (Continuation)null) {
            final String $errorMessage;
            int label;
            final AddDeviceSuccessFragment this$0;

            // $FF: synthetic method
            public static Unit $r8$lambda$IIWCab0LrLx77mPOhQZWlxyFZcE(AddDeviceSuccessFragment var0, String var1, Bundle var2) {
               return invokeSuspend$lambda$3$lambda$2$lambda$1(var0, var1, var2);
            }

            // $FF: synthetic method
            public static Unit $r8$lambda$QqYp22KrsZXv8fpePmD1vrNGdOY(AddDeviceSuccessFragment var0, boolean var1) {
               return invokeSuspend$lambda$3$lambda$2(var0, var1);
            }

            {
               this.this$0 = var1;
               this.$errorMessage = var2;
            }

            private static final Unit invokeSuspend$lambda$3$lambda$2(AddDeviceSuccessFragment var0, boolean var1) {
               if (var1) {
                  var0.getViewModel().restart();
               } else {
                  var0.getAnalytics().event(new AnalyticEvent.TAP_TROUBLESHOOTING());
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
                     FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var2, "TroubleshootingDialog", new AddDeviceSuccessFragment$showSuccess$2$$ExternalSyntheticLambda1(var0));
                  }
               }

               return Unit.INSTANCE;
            }

            private static final Unit invokeSuspend$lambda$3$lambda$2$lambda$1(AddDeviceSuccessFragment var0, String var1, Bundle var2) {
               if (var2.getBoolean("action_retry")) {
                  var0.getViewModel().restart();
               }

               return Unit.INSTANCE;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$errorMessage, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  long var2 = System.currentTimeMillis();
                  if (var2 - this.this$0.troubleShowTime < 1000L) {
                     return Unit.INSTANCE;
                  } else {
                     String var4;
                     AnalyticsService var6;
                     label37: {
                        this.this$0.troubleShowTime = var2;
                        var6 = this.this$0.getAnalytics();
                        var1 = this.this$0.getViewModel().getSelectedUiDevice();
                        var4 = "";
                        if (var1 != null) {
                           var1 = var1.getDeviceType();
                           if (var1 != null) {
                              String var5 = var1.getName();
                              var9 = var5;
                              if (var5 != null) {
                                 break label37;
                              }
                           }
                        }

                        var9 = "";
                     }

                     String var17 = this.$errorMessage;
                     if (var17 != null) {
                        var4 = var17;
                     }

                     var6.amplitudeLog(new OnboardingFailureEvent(var9, false, var4));
                     AddDeviceViewModel var10 = this.this$0.getViewModel();
                     Object var15 = null;
                     AddDeviceViewModel.logStep5OnboardingFailure$default(var10, (String)null, 1, (Object)null);
                     FragmentAddDeviceSuccessBinding var18 = this.this$0.viewDataBinding;
                     FragmentAddDeviceSuccessBinding var11 = var18;
                     if (var18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                        var11 = null;
                     }

                     ProgressBlockerView var12 = var11.progressView;
                     Intrinsics.checkNotNullExpressionValue(var12, "progressView");
                     ViewExtensionsKt.hide((View)var12);
                     FragmentAddDeviceSuccessBinding var13 = this.this$0.viewDataBinding;
                     if (var13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                        var13 = (FragmentAddDeviceSuccessBinding)var15;
                     }

                     var13.buttonContinue.setVisibility(8);
                     FragmentManager var14 = this.this$0.getChildFragmentManager();
                     Intrinsics.checkNotNullExpressionValue(var14, "getChildFragmentManager(...)");
                     AddDeviceSuccessFragment var16 = this.this$0;
                     Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                     if (!(var14.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var14.isStateSaved()) {
                        ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_trouble_adding_device, (Integer)null, R.string.hint_trouble_adding_device, Boxing.boxInt(R.string.connection_to_purifier_try_again), Boxing.boxInt(R.string.action_read_tips), false, false, false, false, (String[])null, (String)null, (Integer)null, new AddDeviceSuccessFragment$showSuccess$2$$ExternalSyntheticLambda0(var16), 3936, (Object)null)).show(var14, "ConfirmationDialogLeftAligned");
                        var14.executePendingTransactions();
                     }

                     return Unit.INSTANCE;
                  }
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         }, 2, (Object)null);
      }
   }

   // $FF: synthetic method
   static void showSuccess$default(AddDeviceSuccessFragment var0, boolean var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.showSuccess(var1, var2);
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentActivity var7 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var7, "requireActivity(...)");
      AddDeviceViewModel var8 = (AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var7)).get(AddDeviceViewModel.class));
      FragmentAddDeviceSuccessBinding var6 = FragmentAddDeviceSuccessBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      var6.setAddDeviceViewModel(var8);
      this.setViewModel(var8);
      var6.setLifecycleOwner((LifecycleOwner)this.requireActivity());
      this.viewDataBinding = var6;
      FragmentAddDeviceSuccessBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      View var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().recordResume("onboarding");
      Boolean var2 = this.getViewModel().isSelectedBleDeviceBounded();
      BleDeviceError var4 = this.getViewModel().getSelectedBleDeviceError();
      boolean var1 = Intrinsics.areEqual(var2, true);
      Object var3 = null;
      if (var1) {
         showSuccess$default(this, true, (String)null, 2, (Object)null);
      } else if (this.getViewModel().getPolling()) {
         BleDeviceState var5;
         if (var4 != null) {
            var5 = var4.getStateOccurred();
         } else {
            var5 = null;
         }

         if (Intrinsics.areEqual(var5, BleDeviceState.WifiConnected.INSTANCE)) {
            this.showSuccess(false, var4.getMessage());
         }
      }

      Observable var11 = this.getViewModel().getSelectedBleDeviceErrorObserver();
      if (var11 != null) {
         CompositeDisposable var6 = this.getRxSubs();
         var11 = var11.observeOn(AndroidSchedulers.mainThread()).filter(new AddDeviceSuccessFragment$$ExternalSyntheticLambda1(new AddDeviceSuccessFragment$$ExternalSyntheticLambda0(this)));
         Intrinsics.checkNotNullExpressionValue(var11, "filter(...)");
         var6.add(RxExtensionsKt.subscribeAndLogE(var11, new AddDeviceSuccessFragment$$ExternalSyntheticLambda2(this)));
      }

      var11 = this.getViewModel().getSelectedBleDeviceStateObserver();
      if (var11 != null) {
         CompositeDisposable var7 = this.getRxSubs();
         var11 = var11.observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var11, "observeOn(...)");
         var7.add(RxExtensionsKt.subscribeAndLogE(var11, new AddDeviceSuccessFragment$$ExternalSyntheticLambda3(this)));
      }

      CompositeDisposable var15 = this.getRxSubs();
      FragmentAddDeviceSuccessBinding var8 = this.viewDataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var8 = (FragmentAddDeviceSuccessBinding)var3;
      }

      Observable var9 = RxView.clicks((View)var8.buttonContinue);
      Intrinsics.checkNotNullExpressionValue(var9, "clicks(...)");
      var9 = RxExtensionsKt.filterRapidClicks(var9);
      Intrinsics.checkNotNullExpressionValue(var9, "filterRapidClicks(...)");
      var15.add(RxExtensionsKt.subscribeAndLogE(var9, new AddDeviceSuccessFragment$$ExternalSyntheticLambda4(this)));
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      BluetoothDevice var4 = this.getViewModel().getSelectedUiDevice();
      if (var4 != null) {
         FragmentAddDeviceSuccessBinding var7 = this.viewDataBinding;
         FragmentAddDeviceSuccessBinding var5 = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = null;
         }

         AppCompatImageView var6 = var5.ivDevice;
         DeviceImage var8 = DeviceConfigProvider.INSTANCE.getDeviceImage(var4);
         int var3;
         if (var8 != null) {
            var3 = var8.getDevice();
         } else {
            var3 = 0;
         }

         var6.setImageResource(var3);
      }

   }

   public void setViewModel(AddDeviceViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.$$delegate_0.setViewModel(var1);
   }

   public void showProgress(boolean var1) {
      this.$$delegate_0.showProgress(var1);
   }
}
