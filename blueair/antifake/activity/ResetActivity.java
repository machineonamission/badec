package com.blueair.antifake.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.antifake.databinding.ActivityResetBinding;
import com.blueair.antifake.fragmnet.ResetFilterFragment;
import com.blueair.antifake.fragmnet.ScanDeviceFragment;
import com.blueair.antifake.fragmnet.ScanResultFragment;
import com.blueair.antifake.fragmnet.ScanVerifyingFragment;
import com.blueair.antifake.fragmnet.SearchDeviceFragment;
import com.blueair.antifake.viewmodel.AntiFakePage;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.bluetooth.utils.BluetoothConnectivityBroadcastReceiver;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.activity.BaseActivity;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0014J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"},
   d2 = {"Lcom/blueair/antifake/activity/ResetActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/antifake/databinding/ActivityResetBinding;", "networkBroadcastReceiver", "Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "getNetworkBroadcastReceiver", "()Lcom/blueair/bluetooth/utils/BluetoothConnectivityBroadcastReceiver;", "networkBroadcastReceiver$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "setPage", "page", "Lcom/blueair/antifake/viewmodel/AntiFakePage;", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ResetActivity extends BaseActivity {
   private static final String CODE = "CODE";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityResetBinding binding;
   private final Lazy networkBroadcastReceiver$delegate;
   private final String screenName = "antifake_reset";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$1_rorsOKBca6FDx3RzqpNp9fLP4/* $FF was: $r8$lambda$1-rorsOKBca6FDx3RzqpNp9fLP4*/(ResetActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2sz4H3qRKbegbp4OQvKBxzIQAiU(ResetActivity var0, AntiFakePage var1) {
      return onCreate$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$6o0oaB7CAlqwcT2r7DZ9Jbc4oAk(ResetActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$afQ1hzG0OGpmKpOq9HcJz63DFEc(ResetActivity var0, OnBackPressedCallback var1) {
      return onCreate$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static BluetoothConnectivityBroadcastReceiver $r8$lambda$rzAhiMCKAv5VVXpBo5sLNbBBaBY(ResetActivity var0) {
      return networkBroadcastReceiver_delegate$lambda$0(var0);
   }

   public ResetActivity() {
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
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AntiFakeViewModel.class), new Function0(var2) {
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
      this.networkBroadcastReceiver$delegate = LazyKt.lazy(new ResetActivity$$ExternalSyntheticLambda0(this));
   }

   private final BluetoothConnectivityBroadcastReceiver getNetworkBroadcastReceiver() {
      return (BluetoothConnectivityBroadcastReceiver)this.networkBroadcastReceiver$delegate.getValue();
   }

   private final AntiFakeViewModel getViewModel() {
      return (AntiFakeViewModel)this.viewModel$delegate.getValue();
   }

   private static final BluetoothConnectivityBroadcastReceiver networkBroadcastReceiver_delegate$lambda$0(ResetActivity var0) {
      var0.getViewModel().getBtConnectivityService().updateBluetoothConnectivityState(BluetoothUtils.INSTANCE.isBluetoothEnabled((Context)var0));
      return new BluetoothConnectivityBroadcastReceiver(var0.getViewModel().getBtConnectivityService());
   }

   private static final void onCreate$lambda$1(ResetActivity var0, View var1) {
      if (!(var0.getViewModel().getCurrentPage().getValue() instanceof AntiFakePage.ResetByWifi) && !(var0.getViewModel().getCurrentPage().getValue() instanceof AntiFakePage.ResetByBluetooth)) {
         var0.finish();
      } else {
         var0.getOnBackPressedDispatcher().onBackPressed();
      }
   }

   private static final void onCreate$lambda$2(ResetActivity var0, View var1) {
      var0.getOnBackPressedDispatcher().onBackPressed();
   }

   private static final Unit onCreate$lambda$4(ResetActivity var0, OnBackPressedCallback var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$addCallback");
      if (!var0.getViewModel().goBack()) {
         var0.finish();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreate$lambda$5(ResetActivity var0, AntiFakePage var1) {
      var0.setPage(var1);
      return Unit.INSTANCE;
   }

   private final void setPage(AntiFakePage var1) {
      if (var1 != null) {
         ActivityResetBinding var6 = this.binding;
         Object var5 = null;
         ActivityResetBinding var4 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         AppCompatImageView var18 = var4.btnBack;
         Intrinsics.checkNotNullExpressionValue(var18, "btnBack");
         ViewExtensionsKt.show((View)var18, var1.getBackBtnEnabled());
         var6 = this.binding;
         ActivityResetBinding var19 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var19 = null;
         }

         AppCompatImageView var20 = var19.btnClose;
         Intrinsics.checkNotNullExpressionValue(var20, "btnClose");
         ViewExtensionsKt.show((View)var20, var1.getCloseBtnEnabled());
         var6 = this.binding;
         ActivityResetBinding var21 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var21 = null;
         }

         var21.title.setText(var1.getTitle());
         if (var1.getHeader() == 0) {
            var6 = this.binding;
            var21 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var21 = null;
            }

            ConstraintLayout var23 = var21.headerBar;
            Intrinsics.checkNotNullExpressionValue(var23, "headerBar");
            ViewExtensionsKt.hide((View)var23);
         } else {
            var6 = this.binding;
            var21 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var21 = null;
            }

            ConstraintLayout var25 = var21.headerBar;
            Intrinsics.checkNotNullExpressionValue(var25, "headerBar");
            ViewExtensionsKt.show$default((View)var25, false, 1, (Object)null);
            var6 = this.binding;
            ActivityResetBinding var26 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var26 = null;
            }

            var26.headerTitle.setText(var1.getHeader());
            var6 = this.binding;
            var26 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var26 = null;
            }

            var26.headerProgress.setProgress(var1.getStep());
            var6 = this.binding;
            var26 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var26 = null;
            }

            TextView var7 = var26.step1;
            var6 = this.binding;
            var26 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var26 = null;
            }

            TextView var8 = var26.step2;
            var6 = this.binding;
            var26 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var26 = null;
            }

            Iterator var31 = ((Iterable)CollectionsKt.listOf(new TextView[]{var7, var8, var26.step3})).iterator();

            for(int var2 = 0; var31.hasNext(); ++var2) {
               var6 = (ActivityResetBinding)var31.next();
               if (var2 < 0) {
                  CollectionsKt.throwIndexOverflow();
               }

               TextView var46 = (TextView)var6;
               boolean var3;
               if (var2 <= var1.getStep()) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var46.setEnabled(var3);
            }
         }

         boolean var17;
         label135: {
            if (Intrinsics.areEqual(var1, AntiFakePage.CodeVerifying.INSTANCE)) {
               var32 = ScanVerifyingFragment.Companion.newInstance();
            } else if (var1 instanceof AntiFakePage.CodeVerifyResult) {
               var32 = ScanResultFragment.Companion.newInstance();
            } else {
               label134: {
                  if (Intrinsics.areEqual(var1, AntiFakePage.SelectDevice.INSTANCE)) {
                     var32 = SearchDeviceFragment.Companion.newInstance();
                  } else if (var1 instanceof AntiFakePage.ScanBluetooth) {
                     var32 = ScanDeviceFragment.Companion.newInstance();
                  } else {
                     if (var1 instanceof AntiFakePage.ResetByWifi) {
                        var32 = ResetFilterFragment.Companion.newInstance();
                        break label134;
                     }

                     if (!(var1 instanceof AntiFakePage.ResetByBluetooth)) {
                        throw new NoWhenBranchMatchedException();
                     }

                     var32 = ResetFilterFragment.Companion.newInstance();
                  }

                  var17 = false;
                  break label135;
               }
            }

            var17 = true;
         }

         AnalyticsService var47 = this.getAnalytics();
         String var49 = var1.getScreenName();
         String var9 = var32.getClass().getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var9, "getSimpleName(...)");
         var47.event(new AnalyticEvent.ScreenViewEvent(var49, var9));
         FragmentTransaction var50 = this.getSupportFragmentManager().beginTransaction();
         ActivityResetBinding var48 = this.binding;
         ActivityResetBinding var10 = var48;
         if (var48 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = null;
         }

         var50.replace(var10.containerFragment.getId(), var32).commit();
         if (this.getViewModel().getDevice() != null && var17) {
            var21 = this.binding;
            var10 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = null;
            }

            var10.headerProgress.setMax(1);
            var10 = this.binding;
            if (var10 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = (ActivityResetBinding)var5;
            }

            TextView var16 = var10.step3;
            Intrinsics.checkNotNullExpressionValue(var16, "step3");
            ViewExtensionsKt.hide((View)var16);
         } else {
            var21 = this.binding;
            var10 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = null;
            }

            var10.headerProgress.setMax(2);
            var21 = this.binding;
            var10 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = null;
            }

            TextView var13 = var10.step3;
            Intrinsics.checkNotNullExpressionValue(var13, "step3");
            ViewExtensionsKt.show$default((View)var13, false, 1, (Object)null);
         }
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityResetBinding var3 = ActivityResetBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      Object var2 = null;
      ActivityResetBinding var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      this.setContentView((View)var5.getRoot());
      var3 = this.binding;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.btnClose.setOnClickListener(new ResetActivity$$ExternalSyntheticLambda1(this));
      var3 = this.binding;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.btnBack.setOnClickListener(new ResetActivity$$ExternalSyntheticLambda2(this));
      HasSKU var16 = (HasSKU)this.getIntent().getParcelableExtra("device");
      String var4 = this.getIntent().getStringExtra("filter_type");
      DeviceFilterType var8 = (DeviceFilterType)var2;
      if (var4 != null) {
         var8 = DeviceFilterType.valueOf(var4);
      }

      label21: {
         this.getViewModel().init(var16, var8);
         OnBackPressedDispatcher var12 = this.getOnBackPressedDispatcher();
         Intrinsics.checkNotNullExpressionValue(var12, "<get-onBackPressedDispatcher>(...)");
         LifecycleOwner var9 = (LifecycleOwner)this;
         OnBackPressedDispatcherKt.addCallback$default(var12, var9, false, new ResetActivity$$ExternalSyntheticLambda3(this), 2, (Object)null);
         this.getViewModel().getCurrentPage().observe(var9, new Observer(new ResetActivity$$ExternalSyntheticLambda4(this)) {
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
         var17 = this.getViewModel();
         Bundle var10 = this.getIntent().getExtras();
         if (var10 != null) {
            String var13 = var10.getString("CODE");
            var11 = var13;
            if (var13 != null) {
               break label21;
            }
         }

         var11 = "";
      }

      var17.validateCode(var11);
   }

   protected void onPause() {
      super.onPause();
      this.unregisterReceiver(this.getNetworkBroadcastReceiver());
   }

   protected void onResume() {
      super.onResume();
      this.registerReceiver(this.getNetworkBroadcastReceiver(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/antifake/activity/ResetActivity$Companion;", "", "<init>", "()V", "CODE", "", "launch", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/HasSKU;", "targetType", "Lcom/blueair/core/model/DeviceFilterType;", "code", "antifake_otherRelease"},
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

      public final void launch(Context var1, HasSKU var2, DeviceFilterType var3, String var4) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var4, "code");
         Intent var5 = (new Intent(var1, ResetActivity.class)).putExtra("device", var2);
         String var6;
         if (var3 != null) {
            var6 = var3.name();
         } else {
            var6 = null;
         }

         var1.startActivity(var5.putExtra("filter_type", var6).putExtra("CODE", var4));
      }
   }
}
