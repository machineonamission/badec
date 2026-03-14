package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepTwoBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepTwoClassicBinding;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.connectivityhelper.NetUtil;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
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
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepTwoFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "Lkotlin/Lazy;", "binding", "Landroidx/viewbinding/ViewBinding;", "otherBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepTwoBinding;", "getOtherBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepTwoBinding;", "otherBinding$delegate", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getSpannableStringForDevice", "Landroid/text/SpannableString;", "deviceNetwork", "", "fullText", "onViewCreated", "", "view", "handleNext", "onResume", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceManualStepTwoFragment extends AddDeviceBaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceManualStepTwoFragment.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ViewBinding binding;
   private final Lazy networkMonitor$delegate;
   private final Lazy otherBinding$delegate;

   // $FF: synthetic method
   public static FragmentAddDeviceManualStepTwoBinding $r8$lambda$AUzJUFGnjwl7PkoJFGxWL3NVLy4(AddDeviceManualStepTwoFragment var0) {
      return otherBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$EGIpzykphevsEX9R8qPjS9Lo_7M(AddDeviceManualStepTwoFragment var0, View var1) {
      onViewCreated$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$sGdccLUNlNlPdYw9Nvfbfw0pJBs(AddDeviceManualStepTwoFragment var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   public AddDeviceManualStepTwoFragment() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, NetworkMonitor.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.otherBinding$delegate = LazyKt.lazy(new AddDeviceManualStepTwoFragment$$ExternalSyntheticLambda2(this));
   }

   private final NetworkMonitor getNetworkMonitor() {
      return (NetworkMonitor)this.networkMonitor$delegate.getValue();
   }

   private final FragmentAddDeviceManualStepTwoBinding getOtherBinding() {
      return (FragmentAddDeviceManualStepTwoBinding)this.otherBinding$delegate.getValue();
   }

   private final SpannableString getSpannableStringForDevice(String var1, String var2) {
      CharSequence var6 = (CharSequence)var2;
      SpannableString var5 = new SpannableString(var6);
      int var3 = StringsKt.indexOf$default(var6, var1, 0, false, 6, (Object)null);
      int var4 = var1.length();
      if (var3 >= 0) {
         var5.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(this.getResources(), R.color.yellow_jasmine, (Resources.Theme)null)), var3, var4 + var3, 33);
      }

      return var5;
   }

   private final void handleNext() {
      String var2 = NetUtil.INSTANCE.getActiveWifiSSID((Context)this.getActivity());
      String var1;
      if (var2 != null && Intrinsics.areEqual(var2, "WiredSSID")) {
         var1 = var2;
      } else {
         var1 = DeviceUtilsLegacy.INSTANCE.getManualModeWiFiSSID(this.getDeviceModelType());
      }

      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("connectedWifiSSID: ");
      var3.append(var2);
      var3.append(", requiredWiFISSID = ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      if (var2 != null && Intrinsics.areEqual(var2, var1)) {
         this.getAddService().manualStepCompleted();
      } else {
         ViewUtils var6 = ViewUtils.INSTANCE;
         FragmentActivity var7 = this.requireActivity();
         Intrinsics.checkNotNullExpressionValue(var7, "requireActivity(...)");
         Activity var8 = (Activity)var7;
         StringCompanionObject var9 = StringCompanionObject.INSTANCE;
         String var10 = this.getString(R.string.add_device_wrong_network);
         Intrinsics.checkNotNullExpressionValue(var10, "getString(...)");
         var1 = String.format(var10, Arrays.copyOf(new Object[]{var1}, 1));
         Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
         var6.showError(var8, var1);
      }
   }

   private static final void onViewCreated$lambda$1(AddDeviceManualStepTwoFragment var0, View var1) {
      var0.handleNext();
   }

   private static final void onViewCreated$lambda$3(AddDeviceManualStepTwoFragment var0, View var1) {
      Intent var2 = new Intent("android.settings.WIFI_SETTINGS");
      var2.setFlags(268435456);
      var0.startActivity(var2);
   }

   private static final FragmentAddDeviceManualStepTwoBinding otherBinding_delegate$lambda$0(AddDeviceManualStepTwoFragment var0) {
      ViewBinding var1 = var0.binding;
      ViewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      return (FragmentAddDeviceManualStepTwoBinding)var2;
   }

   public ConstraintLayout getRootView() {
      ViewBinding var2 = this.binding;
      ViewBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      View var3 = var1.getRoot();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
      return (ConstraintLayout)var3;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewBinding var6;
      if (this.getDeviceModelType() == 3) {
         FragmentAddDeviceManualStepTwoClassicBinding var5 = FragmentAddDeviceManualStepTwoClassicBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var5);
         var6 = var5;
      } else {
         FragmentAddDeviceManualStepTwoBinding var7 = FragmentAddDeviceManualStepTwoBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNull(var7);
         var6 = var7;
      }

      this.binding = var6;
      Object var15 = null;
      ViewBinding var11 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      TextView var8 = (TextView)var11.getRoot().findViewById(com.blueair.adddevice.R.id.textAddDeviceSubtitle);
      String var12 = DeviceUtilsLegacy.getDeviceModelNameForDisplay(this.getDeviceModelType());
      int var4 = this.getDeviceModelType();
      if (var4 != 1) {
         if (var4 != 2) {
            Html.fromHtml(this.getResources().getString(R.string.device_manual_wifi));
         } else {
            var12 = this.getResources().getString(R.string.device_manual_wifi, new Object[]{"sense-config", var12});
            Intrinsics.checkNotNullExpressionValue(var12, "getString(...)");
            if (var8 != null) {
               var8.setText((CharSequence)this.getSpannableStringForDevice("sense-config", var12), BufferType.SPANNABLE);
            }
         }
      } else {
         var12 = this.getResources().getString(R.string.device_manual_wifi, new Object[]{"aware-config", var12});
         Intrinsics.checkNotNullExpressionValue(var12, "getString(...)");
         if (var8 != null) {
            var8.setText((CharSequence)this.getSpannableStringForDevice("aware-config", var12), BufferType.SPANNABLE);
         }
      }

      ViewBinding var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = (ViewBinding)var15;
      }

      View var10 = var9.getRoot();
      Intrinsics.checkNotNullExpressionValue(var10, "getRoot(...)");
      return var10;
   }

   public void onResume() {
      super.onResume();
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(R.string.add_device_title_join_config_network));
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      if (this.getDeviceModelType() == 1 || this.getDeviceModelType() == 2 || this.getDeviceModelType() == 3) {
         ViewBinding var4 = this.binding;
         ViewBinding var6 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.getRoot().findViewById(com.blueair.adddevice.R.id.buttonNext).setOnClickListener(new AddDeviceManualStepTwoFragment$$ExternalSyntheticLambda0(this));
      }

      Button var5 = (Button)var1.findViewById(com.blueair.adddevice.R.id.btnSettings);
      if (var5 != null) {
         var5.setOnClickListener(new AddDeviceManualStepTwoFragment$$ExternalSyntheticLambda1(this));
      }

      int var3 = this.getDeviceModelType();
      if (var3 != 1) {
         if (var3 == 2) {
            this.getOtherBinding().imageAuto.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), com.blueair.adddevice.R.drawable.ic_sense_manual, (Resources.Theme)null));
         }
      } else {
         this.getOtherBinding().imageAuto.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), com.blueair.adddevice.R.drawable.ic_aware_manual, (Resources.Theme)null));
      }

      if (this.getDeviceModelType() == 3) {
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final AddDeviceManualStepTwoFragment this$0;

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
                  FlowCollector var5 = new FlowCollector(this.this$0) {
                     final AddDeviceManualStepTwoFragment this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Object emit(boolean var1, Continuation var2) {
                        if (var1 && Intrinsics.areEqual(NetUtil.INSTANCE.getActiveWifiSSID((Context)this.this$0.getActivity()), "classic-config")) {
                           this.this$0.getAddService().manualStepCompleted();
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

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      } else {
         this.getAddService().setSettingsWiFiNetworkPassword("");
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepTwoFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepTwoFragment;", "deviceModelType", "", "adddevice_otherRelease"},
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

      public final AddDeviceManualStepTwoFragment newInstance(int var1) {
         AddDeviceManualStepTwoFragment var2 = new AddDeviceManualStepTwoFragment();
         Bundle var3 = new Bundle();
         var3.putInt("deviceModelType", var1);
         var2.setArguments(var3);
         return var2;
      }
   }
}
