package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.Lifecycle.State;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.antifake.adapter.SearchedDevice;
import com.blueair.antifake.adapter.SearchedDeviceAdapter;
import com.blueair.antifake.databinding.FragmentSearchDeviceBinding;
import com.blueair.antifake.dialog.BluetoothInstructionsDialog;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.extensions.TextViewExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"},
   d2 = {"Lcom/blueair/antifake/fragmnet/SearchDeviceFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentSearchDeviceBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "adapter", "Lcom/blueair/antifake/adapter/SearchedDeviceAdapter;", "pendingConnectableDevice", "Lcom/blueair/core/model/BluetoothDevice;", "connectInstructionsDialog", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "doBluetoothReset", "", "device", "onViewCreated", "view", "onResume", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SearchDeviceFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final SearchedDeviceAdapter adapter = new SearchedDeviceAdapter();
   private FragmentSearchDeviceBinding binding;
   private ConnectInstructionsDialog connectInstructionsDialog;
   private BluetoothDevice pendingConnectableDevice;
   public AntiFakeViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$7DbphtNO2L1bJRSIhJzR5ogDCms(SearchDeviceFragment var0, HasSKU var1) {
      return onCreateView$lambda$4$lambda$3$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$B51ZfyhES6r_umJWDCTVGwcsX0A/* $FF was: $r8$lambda$B51ZfyhES6r-umJWDCTVGwcsX0A*/(SearchDeviceFragment var0, List var1) {
      return onCreateView$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$JC5NG0lxTdfY2ptPsR8_ha3zXI8/* $FF was: $r8$lambda$JC5NG0lxTdfY2ptPsR8-ha3zXI8*/(SearchDeviceFragment var0, View var1) {
      onCreateView$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$NipgZ2vtchYWf5MfXwFCPkGREFM(SearchDeviceFragment var0, HasSKU var1, boolean var2) {
      return onCreateView$lambda$4$lambda$1$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Pkhh1O_Rt76lbuA50y7Cb9dBQi4/* $FF was: $r8$lambda$Pkhh1O-Rt76lbuA50y7Cb9dBQi4*/(SearchDeviceFragment var0, String var1, Bundle var2) {
      return doBluetoothReset$lambda$12$lambda$11(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Q2X6qVVirTtbE4xUbrZdZxTb17g(SearchDeviceFragment var0, SearchedDevice var1) {
      return onCreateView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SLAgLAXq7MWtNe6ksMxax09xayU(SearchDeviceFragment var0) {
      return onCreateView$lambda$8$lambda$7$lambda$6(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Y6xXMm5QHOISctouaXltJFY1HFU(SearchDeviceFragment var0) {
      return onViewCreated$lambda$14$lambda$13(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$yDS30XdCrydulfCwvC0odcsrChQ(SearchDeviceFragment var0, View var1) {
      onCreateView$lambda$5(var0, var1);
   }

   private final void doBluetoothReset(BluetoothDevice var1) {
      if (var1.getConnectable()) {
         this.getViewModel().resetFilterByBluetooth(var1);
      } else {
         FragmentManager var3 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConnectInstructionsDialog", "getSimpleName(...)");
         DialogFragment var2;
         if (!(var3.findFragmentByTag("ConnectInstructionsDialog") instanceof ConnectInstructionsDialog) && !var3.isStateSaved()) {
            String var4;
            if (var1.getHasNoAutoButton()) {
               var4 = "action_fan_speed";
            } else {
               var4 = "action_auto";
            }

            var2 = ConnectInstructionsDialog.Companion.newInstance$default(ConnectInstructionsDialog.Companion, var1.getFamilyName(), var4, var1, false, 8, (Object)null);
            ((DialogFragment)var2).show(var3, "ConnectInstructionsDialog");
         } else {
            var2 = null;
         }

         var2 = var2;
         if (var2 != null) {
            this.pendingConnectableDevice = var1;
            this.connectInstructionsDialog = var2;
            FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var2, "ConnectInstructionsDialog", new SearchDeviceFragment$$ExternalSyntheticLambda0(this));
         }

      }
   }

   private static final Unit doBluetoothReset$lambda$12$lambda$11(SearchDeviceFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      var0.pendingConnectableDevice = null;
      var0.connectInstructionsDialog = null;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$4(SearchDeviceFragment var0, SearchedDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1.isOnboarded()) {
         Device var2 = var1.getDevice();
         Intrinsics.checkNotNull(var2);
         HasSKU var7 = (HasSKU)var2;
         if (var1.isOnline()) {
            FragmentManager var3 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var3.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var3.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.confirm_reset, (Integer)null, R.string.confirm_reset_desc, R.string.reset, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new SearchDeviceFragment$$ExternalSyntheticLambda5(var0, var7), 3680, (Object)null)).show(var3, "ConfirmationDialogLeftAligned");
            }
         } else if (var1.getBluetoothAvailable()) {
            BluetoothDevice var4 = var1.getBluetoothDevice();
            Intrinsics.checkNotNull(var4);
            var0.doBluetoothReset(var4);
         } else {
            FragmentManager var5 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
            if (!(var5.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !var5.isStateSaved()) {
               ((DialogFragment)BluetoothInstructionsDialog.Companion.newInstance(new SearchDeviceFragment$$ExternalSyntheticLambda6(var0, var7))).show(var5, "BluetoothInstructionsDialog");
            }
         }
      } else if (var1.getBluetoothAvailable()) {
         BluetoothDevice var6 = var1.getBluetoothDevice();
         Intrinsics.checkNotNull(var6);
         var0.doBluetoothReset(var6);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$4$lambda$1$lambda$0(SearchDeviceFragment var0, HasSKU var1, boolean var2) {
      if (var2) {
         var0.getViewModel().resetFilter(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$4$lambda$3$lambda$2(SearchDeviceFragment var0, HasSKU var1) {
      var0.getViewModel().scanBluetooth(var1.getMac());
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$5(SearchDeviceFragment var0, View var1) {
      var0.startActivity(Actions.INSTANCE.openDialerIntent("400-006-9693"));
   }

   private static final void onCreateView$lambda$8(SearchDeviceFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !var2.isStateSaved()) {
         ((DialogFragment)BluetoothInstructionsDialog.Companion.newInstance(new SearchDeviceFragment$$ExternalSyntheticLambda7(var0))).show(var2, "BluetoothInstructionsDialog");
      }

   }

   private static final Unit onCreateView$lambda$8$lambda$7$lambda$6(SearchDeviceFragment var0) {
      var0.getViewModel().scanBluetooth((String)null);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$9(SearchDeviceFragment var0, List var1) {
      SearchedDeviceAdapter var2 = var0.adapter;
      Intrinsics.checkNotNull(var1);
      var2.updateOnboardedDevices(var1);
      if (var0.adapter.getItemCount() == 0) {
         if (!var0.getViewModel().isBluetoothScanning()) {
            var0.showProgress(false);
            FragmentSearchDeviceBinding var5 = var0.binding;
            FragmentSearchDeviceBinding var3 = var5;
            if (var5 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var3 = null;
            }

            MaterialButton var4 = var3.btnCustomerSupport;
            Intrinsics.checkNotNullExpressionValue(var4, "btnCustomerSupport");
            ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
         }
      } else {
         var0.showProgress(false);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$14$lambda$13(SearchDeviceFragment var0) {
      var0.getViewModel().scanBluetooth(var0.getViewModel().getResetDeviceWifiMac());
      return Unit.INSTANCE;
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
      FragmentSearchDeviceBinding var4 = FragmentSearchDeviceBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      FragmentActivity var5 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
      this.setViewModel((AntiFakeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(AntiFakeViewModel.class)));
      FragmentSearchDeviceBinding var16 = this.binding;
      Object var15 = null;
      FragmentSearchDeviceBinding var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.deviceList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext(), 1, false)));
      var16 = this.binding;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.deviceList.setAdapter(this.adapter);
      this.adapter.setAcceptedSkus(CollectionsKt.toSet((Iterable)this.getViewModel().getFilterSupportedDeviceSku()));
      this.adapter.setOnDeviceSelectedListener(new SearchDeviceFragment$$ExternalSyntheticLambda1(this));
      var16 = this.binding;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnCustomerSupport.setOnClickListener(new SearchDeviceFragment$$ExternalSyntheticLambda2(this));
      var16 = this.binding;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      TextView var10 = var6.btnDeviceNotFound;
      Intrinsics.checkNotNullExpressionValue(var10, "btnDeviceNotFound");
      TextViewExtensionsKt.underlineText(var10);
      var16 = this.binding;
      FragmentSearchDeviceBinding var11 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.btnDeviceNotFound.setOnClickListener(new SearchDeviceFragment$$ExternalSyntheticLambda3(this));
      this.showProgress(true);
      if (this.getViewModel().isBluetoothEnabled()) {
         this.getViewModel().startBluetoothScanning();
         LifecycleOwner var12 = this.getViewLifecycleOwner();
         Intrinsics.checkNotNullExpressionValue(var12, "getViewLifecycleOwner(...)");
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var12), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final SearchDeviceFragment this$0;

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
                  LifecycleOwner var5 = this.this$0.getViewLifecycleOwner();
                  Intrinsics.checkNotNullExpressionValue(var5, "getViewLifecycleOwner(...)");
                  Lifecycle.State var6 = State.STARTED;
                  Function2 var7 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final SearchDeviceFragment this$0;

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
                           FlowCollector var4 = new FlowCollector(this.this$0) {
                              final SearchDeviceFragment this$0;

                              {
                                 this.this$0 = var1;
                              }

                              public final Object emit(List var1, Continuation var2) {
                                 this.this$0.adapter.updateBluetoothDevices(var1);
                                 if (this.this$0.adapter.getItemCount() > 0) {
                                    this.this$0.showProgress(false);
                                 }

                                 BluetoothDevice var3 = this.this$0.pendingConnectableDevice;
                                 if (var3 != null) {
                                    SearchDeviceFragment var8 = this.this$0;
                                    Iterator var4 = ((Iterable)var1).iterator();

                                    do {
                                       if (!var4.hasNext()) {
                                          var5 = null;
                                          break;
                                       }

                                       var5 = var4.next();
                                    } while(!Intrinsics.areEqual(((BluetoothDevice)var5).getMac(), var3.getMac()));

                                    BluetoothDevice var6 = (BluetoothDevice)var5;
                                    if (var6 != null && var6.getConnectable()) {
                                       var8.pendingConnectableDevice = null;
                                       ConnectInstructionsDialog var7 = var8.connectInstructionsDialog;
                                       if (var7 != null) {
                                          var7.dismiss();
                                       }

                                       var8.getViewModel().resetFilterByBluetooth(var3);
                                    }
                                 }

                                 return Unit.INSTANCE;
                              }
                           };
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           if (var6.collect(var4, var5) == var3) {
                              return var3;
                           }
                        }

                        throw new KotlinNothingValueException();
                     }
                  };
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (RepeatOnLifecycleKt.repeatOnLifecycle(var5, var6, var7, var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
         BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final SearchDeviceFragment this$0;

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
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(20000L, var4) == var3) {
                     return var3;
                  }
               }

               this.this$0.showProgress(false);
               if (this.this$0.adapter.getItemCount() == 0) {
                  FragmentSearchDeviceBinding var7 = this.this$0.binding;
                  var1 = var7;
                  if (var7 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var1 = null;
                  }

                  MaterialButton var6 = var1.btnCustomerSupport;
                  Intrinsics.checkNotNullExpressionValue(var6, "btnCustomerSupport");
                  ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

      this.getViewModel().getLiveDevices().observe(this.getViewLifecycleOwner(), new Observer(new SearchDeviceFragment$$ExternalSyntheticLambda4(this)) {
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
      var11 = this.binding;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = (FragmentSearchDeviceBinding)var15;
      }

      ConstraintLayout var14 = var11.getRoot();
      Intrinsics.checkNotNullExpressionValue(var14, "getRoot(...)");
      return (View)var14;
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

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      if (this.getViewModel().getRetryViaBluetooth()) {
         FragmentManager var3 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !var3.isStateSaved()) {
            ((DialogFragment)BluetoothInstructionsDialog.Companion.newInstance(new SearchDeviceFragment$$ExternalSyntheticLambda8(this))).show(var3, "BluetoothInstructionsDialog");
         }
      }

   }

   public void setViewModel(AntiFakeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
      FragmentSearchDeviceBinding var3 = this.binding;
      FragmentSearchDeviceBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ProgressBlockerView var4 = var2.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      ViewExtensionsKt.show((View)var4, var1);
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/antifake/fragmnet/SearchDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/SearchDeviceFragment;", "antifake_otherRelease"},
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

      public final SearchDeviceFragment newInstance() {
         return new SearchDeviceFragment();
      }
   }
}
