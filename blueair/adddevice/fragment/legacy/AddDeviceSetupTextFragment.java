package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetupTextBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceSetupTextClassicBinding;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetupTextFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "btnNext", "Landroid/widget/Button;", "txtWrongWifi", "Landroid/widget/TextView;", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "Lkotlin/Lazy;", "binding", "Landroidx/viewbinding/ViewBinding;", "rootViewForProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceSetupTextFragment extends AddDeviceBaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSetupTextFragment.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private Button btnNext;
   private final Lazy networkMonitor$delegate;
   private ConstraintLayout rootViewForProgress;
   private TextView txtWrongWifi;

   // $FF: synthetic method
   public static void $r8$lambda$UeI_vEpbmm9HJa0ewHrWAQktRyU(AddDeviceSetupTextFragment var0, View var1) {
      onCreateView$lambda$0(var0, var1);
   }

   public AddDeviceSetupTextFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, NetworkMonitor.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final NetworkMonitor getNetworkMonitor() {
      return (NetworkMonitor)this.networkMonitor$delegate.getValue();
   }

   private static final void onCreateView$lambda$0(AddDeviceSetupTextFragment var0, View var1) {
      if (((CharSequence)var0.getAddService().getCurrentNetworkSSIDEstimate()).length() == 0) {
         ViewUtils var3 = ViewUtils.INSTANCE;
         FragmentActivity var2 = var0.requireActivity();
         Intrinsics.checkNotNullExpressionValue(var2, "requireActivity(...)");
         var3.showError((Activity)var2, R.string.error_connect_to_network);
      } else {
         var0.getAddService().setupTextCompleted();
      }
   }

   public ConstraintLayout getRootView() {
      return this.rootViewForProgress;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewBinding var5;
      if (this.getDeviceModelType() == 3) {
         FragmentAddDeviceSetupTextClassicBinding var4 = FragmentAddDeviceSetupTextClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var4);
         var5 = var4;
      } else {
         FragmentAddDeviceSetupTextBinding var6 = FragmentAddDeviceSetupTextBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var6);
         var5 = var6;
      }

      this.binding = var5;
      Object var18 = null;
      ViewBinding var14 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = null;
      }

      this.rootViewForProgress = (ConstraintLayout)var14.getRoot().findViewById(com.blueair.adddevice.R.id.rootLayout);
      var14 = this.binding;
      var5 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      View var8 = var5.getRoot().findViewById(com.blueair.adddevice.R.id.buttonNext);
      Intrinsics.checkNotNullExpressionValue(var8, "findViewById(...)");
      this.btnNext = (Button)var8;
      var14 = this.binding;
      ViewBinding var9 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      View var10 = var9.getRoot().findViewById(com.blueair.adddevice.R.id.textWrongWifi);
      Intrinsics.checkNotNullExpressionValue(var10, "findViewById(...)");
      this.txtWrongWifi = (TextView)var10;
      Button var17 = this.btnNext;
      Button var11 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("btnNext");
         var11 = null;
      }

      var11.setOnClickListener(new AddDeviceSetupTextFragment$$ExternalSyntheticLambda0(this));
      ViewBinding var12 = this.binding;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = (ViewBinding)var18;
      }

      View var13 = var12.getRoot();
      Intrinsics.checkNotNullExpressionValue(var13, "getRoot(...)");
      return var13;
   }

   public void onResume() {
      super.onResume();
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.add_device));
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final AddDeviceSetupTextFragment this$0;

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
               Flow var6 = this.this$0.getNetworkMonitor().getWifiStatus();
               FlowCollector var4 = new FlowCollector(this.this$0) {
                  final AddDeviceSetupTextFragment this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(boolean var1, Continuation var2) {
                     boolean var4 = false;
                     Object var5 = null;
                     if (!var1) {
                        Button var15 = this.this$0.btnNext;
                        Button var12 = var15;
                        if (var15 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                           var12 = null;
                        }

                        var12.setEnabled(false);
                        TextView var16 = this.this$0.txtWrongWifi;
                        TextView var13 = var16;
                        if (var16 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                           var13 = null;
                        }

                        var13.setText((CharSequence)this.this$0.getString(R.string.setup_check_wifi));
                        var16 = this.this$0.txtWrongWifi;
                        var13 = var16;
                        if (var16 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                           var13 = null;
                        }

                        ViewExtensionsKt.show$default((View)var13, false, 1, (Object)null);
                        return Unit.INSTANCE;
                     } else {
                        WifiInfo var8 = NetUtil.INSTANCE.getActiveWifiInfo(this.this$0.requireContext());
                        int var3;
                        if (var8 != null) {
                           var3 = var8.getFrequency();
                        } else {
                           var3 = 0;
                        }

                        var1 = var4;
                        if (var3 > 3000) {
                           var1 = true;
                        }

                        TextView var6 = this.this$0.txtWrongWifi;
                        TextView var9 = var6;
                        if (var6 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                           var9 = null;
                        }

                        var9.setText((CharSequence)this.this$0.getString(R.string.setup_wrong_wifi));
                        var6 = this.this$0.txtWrongWifi;
                        var9 = var6;
                        if (var6 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("txtWrongWifi");
                           var9 = null;
                        }

                        ViewExtensionsKt.show((View)var9, var1);
                        Button var11 = this.this$0.btnNext;
                        if (var11 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                           var11 = (Button)var5;
                        }

                        var11.setEnabled(true);
                        return Unit.INSTANCE;
                     }
                  }
               };
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var6.collect(var4, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetupTextFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceSetupTextFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceSetupTextFragment newInstance(int var1) {
         AddDeviceSetupTextFragment var2 = new AddDeviceSetupTextFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
