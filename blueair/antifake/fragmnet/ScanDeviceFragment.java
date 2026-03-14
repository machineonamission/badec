package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.Lifecycle.State;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.antifake.adapter.SearchedDevice;
import com.blueair.antifake.adapter.SearchedDeviceAdapter;
import com.blueair.antifake.databinding.FragmentScanDeviceBinding;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.GuidesData;
import com.blueair.viewcore.dialog.StepGuideDialogFragment;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/antifake/fragmnet/ScanDeviceFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentScanDeviceBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "adapter", "Lcom/blueair/antifake/adapter/SearchedDeviceAdapter;", "deviceFounded", "", "pendingConnectableDevice", "Lcom/blueair/core/model/BluetoothDevice;", "connectInstructionsDialog", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "launchTroubleshootingTask", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "showProgress", "shouldShowProgress", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScanDeviceFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final SearchedDeviceAdapter adapter = new SearchedDeviceAdapter();
   private FragmentScanDeviceBinding binding;
   private ConnectInstructionsDialog connectInstructionsDialog;
   private boolean deviceFounded;
   private BluetoothDevice pendingConnectableDevice;
   public AntiFakeViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$6fOk_BmNoSec6szkufIaZFC4xxg/* $FF was: $r8$lambda$6fOk-BmNoSec6szkufIaZFC4xxg*/(ScanDeviceFragment var0, String var1, Bundle var2) {
      return onCreateView$lambda$3$lambda$2$lambda$1(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Or6Ib1Mgj9wRE9laAj_cpETlzWg(ScanDeviceFragment var0, SearchedDevice var1) {
      return onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$yEkhls8nE1HjlIDoyD6_xD49G0c/* $FF was: $r8$lambda$yEkhls8nE1HjlIDoyD6-xD49G0c*/(ScanDeviceFragment var0, View var1) {
      onCreateView$lambda$4(var0, var1);
   }

   private final void launchTroubleshootingTask() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final ScanDeviceFragment this$0;

         // $FF: synthetic method
         public static Unit $r8$lambda$URbr6nhO5BU6MPvCaQpNG9DMf5A(ScanDeviceFragment var0, String var1, Bundle var2) {
            return invokeSuspend$lambda$1(var0, var1, var2);
         }

         {
            this.this$0 = var1;
         }

         private static final Unit invokeSuspend$lambda$1(ScanDeviceFragment var0, String var1, Bundle var2) {
            var0.launchTroubleshootingTask();
            return Unit.INSTANCE;
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
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (DelayKt.delay(20000L, var4) == var3) {
                  return var3;
               }
            }

            if (((CharSequence)this.this$0.getViewModel().getResetDeviceWifiMac()).length() > 0 && !this.this$0.deviceFounded || ((CharSequence)this.this$0.getViewModel().getResetDeviceWifiMac()).length() == 0 && this.this$0.adapter.getItemCount() == 0) {
               FragmentManager var9 = this.this$0.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var9, "getChildFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("StepGuideDialogFragment", "getSimpleName(...)");
               DialogFragment var5;
               if (!(var9.findFragmentByTag("StepGuideDialogFragment") instanceof StepGuideDialogFragment) && !var9.isStateSaved()) {
                  var5 = StepGuideDialogFragment.Companion.newInstance(GuidesData.INSTANCE.getONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN());
                  ((DialogFragment)var5).show(var9, "StepGuideDialogFragment");
               } else {
                  var5 = null;
               }

               var5 = var5;
               if (var5 != null) {
                  FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var5, GuidesData.INSTANCE.getONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN().getRequestKey(), new ScanDeviceFragment$launchTroubleshootingTask$1$$ExternalSyntheticLambda0(this.this$0));
               }

               FragmentScanDeviceBinding var10 = this.this$0.binding;
               FragmentScanDeviceBinding var7 = var10;
               if (var10 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var7 = null;
               }

               MaterialButton var8 = var7.btnCustomerSupport;
               Intrinsics.checkNotNullExpressionValue(var8, "btnCustomerSupport");
               ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   private static final Unit onCreateView$lambda$3(ScanDeviceFragment var0, SearchedDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "searchedDevice");
      BluetoothDevice var2 = var1.getBluetoothDevice();
      if (var2 == null) {
         return Unit.INSTANCE;
      } else {
         if (var2.getConnectable()) {
            var0.getViewModel().resetFilterByBluetooth(var2);
         } else {
            FragmentManager var3 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConnectInstructionsDialog", "getSimpleName(...)");
            DialogFragment var4;
            if (!(var3.findFragmentByTag("ConnectInstructionsDialog") instanceof ConnectInstructionsDialog) && !var3.isStateSaved()) {
               String var5;
               if (var2.getHasNoAutoButton()) {
                  var5 = "action_fan_speed";
               } else {
                  var5 = "action_auto";
               }

               var4 = ConnectInstructionsDialog.Companion.newInstance$default(ConnectInstructionsDialog.Companion, var2.getFamilyName(), var5, var2, false, 8, (Object)null);
               ((DialogFragment)var4).show(var3, "ConnectInstructionsDialog");
            } else {
               var4 = null;
            }

            var4 = var4;
            if (var4 != null) {
               var0.pendingConnectableDevice = var2;
               var0.connectInstructionsDialog = var4;
               FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var4, "ConnectInstructionsDialog", new ScanDeviceFragment$$ExternalSyntheticLambda2(var0));
            }
         }

         return Unit.INSTANCE;
      }
   }

   private static final Unit onCreateView$lambda$3$lambda$2$lambda$1(ScanDeviceFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      var0.pendingConnectableDevice = null;
      var0.connectInstructionsDialog = null;
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$4(ScanDeviceFragment var0, View var1) {
      var0.startActivity(Actions.INSTANCE.openDialerIntent("400-006-9693"));
   }

   public AntiFakeViewModel getViewModel() {
      AntiFakeViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentScanDeviceBinding var5 = FragmentScanDeviceBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      FragmentActivity var6 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var6, "requireActivity(...)");
      this.setViewModel((AntiFakeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var6)).get(AntiFakeViewModel.class)));
      this.getViewModel().startBluetoothScanning();
      this.showProgress(true);
      this.launchTroubleshootingTask();
      int var4 = ((CharSequence)this.getViewModel().getResetDeviceWifiMac()).length();
      Object var14 = null;
      if (var4 == 0) {
         FragmentScanDeviceBinding var15 = this.binding;
         FragmentScanDeviceBinding var7 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         var7.deviceList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext(), 1, false)));
         var15 = this.binding;
         var7 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var7 = null;
         }

         var7.deviceList.setAdapter(this.adapter);
         this.adapter.setAcceptedSkus(CollectionsKt.toSet((Iterable)this.getViewModel().getFilterSupportedDeviceSku()));
         this.adapter.setOnDeviceSelectedListener(new ScanDeviceFragment$$ExternalSyntheticLambda0(this));
         LifecycleOwner var9 = this.getViewLifecycleOwner();
         Intrinsics.checkNotNullExpressionValue(var9, "getViewLifecycleOwner(...)");
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var9), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final ScanDeviceFragment this$0;

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
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  LifecycleOwner var7 = this.this$0.getViewLifecycleOwner();
                  Intrinsics.checkNotNullExpressionValue(var7, "getViewLifecycleOwner(...)");
                  Lifecycle.State var6 = State.STARTED;
                  Function2 var5 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final ScanDeviceFragment this$0;

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
                           if (var2 != 1) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           StateFlow var4 = this.this$0.getViewModel().getBleDevicesFlow();
                           FlowCollector var6 = new FlowCollector(this.this$0) {
                              final ScanDeviceFragment this$0;

                              {
                                 this.this$0 = var1;
                              }

                              public final Object emit(List var1, Continuation var2) {
                                 this.this$0.adapter.updateBluetoothDevices(var1);
                                 if (this.this$0.adapter.getItemCount() > 0) {
                                    this.this$0.showProgress(false);
                                    FragmentScanDeviceBinding var3 = this.this$0.binding;
                                    FragmentScanDeviceBinding var7 = var3;
                                    if (var3 == null) {
                                       Intrinsics.throwUninitializedPropertyAccessException("binding");
                                       var7 = null;
                                    }

                                    ConstraintLayout var8 = var7.scanningViewBottom;
                                    Intrinsics.checkNotNullExpressionValue(var8, "scanningViewBottom");
                                    ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
                                 }

                                 BluetoothDevice var10 = this.this$0.pendingConnectableDevice;
                                 if (var10 != null) {
                                    ScanDeviceFragment var9 = this.this$0;
                                    Iterator var4 = ((Iterable)var1).iterator();

                                    do {
                                       if (!var4.hasNext()) {
                                          var5 = null;
                                          break;
                                       }

                                       var5 = var4.next();
                                    } while(!Intrinsics.areEqual(((BluetoothDevice)var5).getMac(), var10.getMac()));

                                    var10 = (BluetoothDevice)var5;
                                    if (var10 != null && var10.getConnectable()) {
                                       var9.pendingConnectableDevice = null;
                                       ConnectInstructionsDialog var6 = var9.connectInstructionsDialog;
                                       if (var6 != null) {
                                          var6.dismiss();
                                       }

                                       var9.getViewModel().resetFilterByBluetooth(var10);
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }
                           };
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           if (var4.collect(var6, var5) == var3) {
                              return var3;
                           }
                        }

                        throw new KotlinNothingValueException();
                     }
                  };
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (RepeatOnLifecycleKt.repeatOnLifecycle(var7, var6, var5, var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      } else {
         LifecycleOwner var10 = this.getViewLifecycleOwner();
         Intrinsics.checkNotNullExpressionValue(var10, "getViewLifecycleOwner(...)");
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var10), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final ScanDeviceFragment this$0;

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
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  LifecycleOwner var7 = this.this$0.getViewLifecycleOwner();
                  Intrinsics.checkNotNullExpressionValue(var7, "getViewLifecycleOwner(...)");
                  Lifecycle.State var5 = State.STARTED;
                  Function2 var4 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final ScanDeviceFragment this$0;

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
                           if (var2 != 1) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           StateFlow var6 = this.this$0.getViewModel().getBleDevicesFlow();
                           FlowCollector var5 = new FlowCollector(this.this$0) {
                              final ScanDeviceFragment this$0;

                              // $FF: synthetic method
                              public static Unit $r8$lambda$thv7c_GJVpGTDnQTf8lJwhU22jM(ScanDeviceFragment var0, String var1, Bundle var2) {
                                 return emit$lambda$4$lambda$3$lambda$2(var0, var1, var2);
                              }

                              {
                                 this.this$0 = var1;
                              }

                              private static final Unit emit$lambda$4$lambda$3$lambda$2(ScanDeviceFragment var0, String var1, Bundle var2) {
                                 Intrinsics.checkNotNullParameter(var1, "<unused var>");
                                 Intrinsics.checkNotNullParameter(var2, "<unused var>");
                                 if (var0.pendingConnectableDevice != null) {
                                    var0.getViewModel().goBack();
                                 }

                                 var0.pendingConnectableDevice = null;
                                 var0.connectInstructionsDialog = null;
                                 return Unit.INSTANCE;
                              }

                              public final Object emit(List var1, Continuation var2) {
                                 Iterable var7 = (Iterable)var1;
                                 ScanDeviceFragment var4 = this.this$0;
                                 Iterator var5 = var7.iterator();

                                 do {
                                    boolean var3 = var5.hasNext();
                                    var13 = null;
                                    if (!var3) {
                                       var8 = null;
                                       break;
                                    }

                                    var8 = var5.next();
                                 } while(!StringsKt.equals(((BluetoothDevice)var8).getWifiMac(), var4.getViewModel().getResetDeviceWifiMac(), true));

                                 BluetoothDevice var15 = (BluetoothDevice)var8;
                                 if (var15 != null) {
                                    var4 = this.this$0;
                                    var4.showProgress(false);
                                    var4.deviceFounded = true;
                                    if (var15.getConnectable()) {
                                       var4.pendingConnectableDevice = null;
                                       ConnectInstructionsDialog var9 = var4.connectInstructionsDialog;
                                       if (var9 != null) {
                                          var9.dismiss();
                                       }

                                       var4.getViewModel().resetFilterByBluetooth(var15);
                                    } else {
                                       FragmentManager var6 = var4.getChildFragmentManager();
                                       Intrinsics.checkNotNullExpressionValue(var6, "getChildFragmentManager(...)");
                                       Intrinsics.checkNotNullExpressionValue("ConnectInstructionsDialog", "getSimpleName(...)");
                                       ConnectInstructionsDialog var10 = (ConnectInstructionsDialog)var13;
                                       if (!(var6.findFragmentByTag("ConnectInstructionsDialog") instanceof ConnectInstructionsDialog)) {
                                          var10 = (ConnectInstructionsDialog)var13;
                                          if (!var6.isStateSaved()) {
                                             String var11;
                                             if (var15.getHasNoAutoButton()) {
                                                var11 = "action_fan_speed";
                                             } else {
                                                var11 = "action_auto";
                                             }

                                             var10 = ConnectInstructionsDialog.Companion.newInstance$default(ConnectInstructionsDialog.Companion, var15.getFamilyName(), var11, var15, false, 8, (Object)null);
                                             ((DialogFragment)var10).show(var6, "ConnectInstructionsDialog");
                                          }
                                       }

                                       var10 = var10;
                                       if (var10 != null) {
                                          var4.pendingConnectableDevice = var15;
                                          var4.connectInstructionsDialog = var10;
                                          FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var10, "ConnectInstructionsDialog", new ScanDeviceFragment$onCreateView$3$1$1$$ExternalSyntheticLambda0(var4));
                                       }
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }
                           };
                           Continuation var4 = (Continuation)this;
                           this.label = 1;
                           if (var6.collect(var5, var4) == var3) {
                              return var3;
                           }
                        }

                        throw new KotlinNothingValueException();
                     }
                  };
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (RepeatOnLifecycleKt.repeatOnLifecycle(var7, var5, var4, var6) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

      FragmentScanDeviceBinding var17 = this.binding;
      FragmentScanDeviceBinding var11 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.btnCustomerSupport.setOnClickListener(new ScanDeviceFragment$$ExternalSyntheticLambda1(this));
      var11 = this.binding;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = (FragmentScanDeviceBinding)var14;
      }

      ConstraintLayout var13 = var11.getRoot();
      Intrinsics.checkNotNullExpressionValue(var13, "getRoot(...)");
      return (View)var13;
   }

   public void onPause() {
      super.onPause();
      if (this.getViewModel().isBluetoothScanning()) {
         this.getViewModel().resetBluetoothScanning();
      }

   }

   public void onResume() {
      super.onResume();
      if (this.getViewModel().isBluetoothEnabled() && !this.getViewModel().isBluetoothScanning()) {
         this.getViewModel().startBluetoothScanning();
      }

   }

   public void setViewModel(AntiFakeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      FragmentScanDeviceBinding var3 = this.binding;
      FragmentScanDeviceBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      LinearLayout var4 = var2.scanningViewCenter;
      Intrinsics.checkNotNullExpressionValue(var4, "scanningViewCenter");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/antifake/fragmnet/ScanDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/ScanDeviceFragment;", "antifake_otherRelease"},
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

      public final ScanDeviceFragment newInstance() {
         return new ScanDeviceFragment();
      }
   }
}
