package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.activity.WelcomeHomeConfigActivity;
import com.blueair.devicedetails.databinding.FragmentDeviceNWelcomeHomeBinding;
import com.blueair.devicedetails.util.WelcomeHomePermissionManager;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
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

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNWelcomeHomeFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;)V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceNWelcomeHomeBinding;", "locationPermissionManager", "Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "openCreateUpdateWelcomeHome", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNWelcomeHomeFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentDeviceNWelcomeHomeBinding binding;
   private final WelcomeHomePermissionManager locationPermissionManager = new WelcomeHomePermissionManager(this);
   public DeviceWelcomeHomeViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$5Jf_QNCq1soyURVb6F6NQo4h6ms(DeviceNWelcomeHomeFragment var0, View var1) {
      onViewCreated$lambda$8$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Ay9jNaolR7zcz_SPwTn87Aw56_M/* $FF was: $r8$lambda$Ay9jNaolR7zcz-SPwTn87Aw56-M*/(DeviceNWelcomeHomeFragment var0, Boolean var1) {
      return onViewCreated$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DiXQ6JEp1_97Bd1qdF3rUNZonos/* $FF was: $r8$lambda$DiXQ6JEp1-97Bd1qdF3rUNZonos*/(DeviceNWelcomeHomeFragment var0, WelcomeHomeLocation var1) {
      return onViewCreated$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$HIQvgYPKRsLA37CnLFmYJOgPy9k(DeviceNWelcomeHomeFragment var0, View var1) {
      onViewCreated$lambda$8$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$LRrYBFfI7Wqnk_BYtNWEQc6tgKo/* $FF was: $r8$lambda$LRrYBFfI7Wqnk-BYtNWEQc6tgKo*/(DeviceNWelcomeHomeFragment var0) {
      return onViewCreated$lambda$8$lambda$6$lambda$5(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YPoqKCftU2bAf9M45GTRuP8pGK8(FragmentDeviceNWelcomeHomeBinding var0, DeviceNWelcomeHomeFragment var1, String var2) {
      return onViewCreated$lambda$8$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$es2PjI054S0ThkJFaIe4tOsu9YY(DeviceNWelcomeHomeFragment var0, FragmentDeviceNWelcomeHomeBinding var1, CompoundButton var2, boolean var3) {
      onViewCreated$lambda$8$lambda$4(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fnD3l23WAw_AkzgNvvm4VjsxAJk/* $FF was: $r8$lambda$fnD3l23WAw-AkzgNvvm4VjsxAJk*/(FragmentDeviceNWelcomeHomeBinding var0, DeviceNWelcomeHomeFragment var1) {
      return onViewCreated$lambda$8$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$rQg_UtPF7HjbqrGYhrmaDSkp2qw(DeviceNWelcomeHomeFragment var0) {
      return onViewCreated$lambda$8$lambda$1$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vuZHUzWVpjwHDyLp_yGaKFZzbZM(FragmentDeviceNWelcomeHomeBinding var0) {
      return onViewCreated$lambda$8$lambda$4$lambda$2(var0);
   }

   private static final Unit onViewCreated$lambda$10(DeviceNWelcomeHomeFragment var0, WelcomeHomeLocation var1) {
      var0.getViewModel().loadHomeLocation(var1);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$8$lambda$1(DeviceNWelcomeHomeFragment var0, View var1) {
      WelcomeHomePermissionManager.checkAndRequest$default(var0.locationPermissionManager, (Function0)null, new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda9(var0), 1, (Object)null);
   }

   private static final Unit onViewCreated$lambda$8$lambda$1$lambda$0(DeviceNWelcomeHomeFragment var0) {
      var0.openCreateUpdateWelcomeHome();
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$8$lambda$4(DeviceNWelcomeHomeFragment var0, FragmentDeviceNWelcomeHomeBinding var1, CompoundButton var2, boolean var3) {
      if (var3) {
         var0.locationPermissionManager.checkAndRequest(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda7(var1), new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda8(var1, var0));
      } else {
         var0.getViewModel().setWelcomeHomeEnabled(false);
      }
   }

   private static final Unit onViewCreated$lambda$8$lambda$4$lambda$2(FragmentDeviceNWelcomeHomeBinding var0) {
      var0.switchBtn.setCheckedSilence(false);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$8$lambda$4$lambda$3(FragmentDeviceNWelcomeHomeBinding var0, DeviceNWelcomeHomeFragment var1) {
      var0.switchBtn.setCheckedSilence(true);
      var1.getViewModel().setWelcomeHomeEnabled(true);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$8$lambda$6(DeviceNWelcomeHomeFragment var0, View var1) {
      WelcomeHomePermissionManager.checkAndRequest$default(var0.locationPermissionManager, (Function0)null, new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda6(var0), 1, (Object)null);
   }

   private static final Unit onViewCreated$lambda$8$lambda$6$lambda$5(DeviceNWelcomeHomeFragment var0) {
      var0.openCreateUpdateWelcomeHome();
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$8$lambda$7(FragmentDeviceNWelcomeHomeBinding var0, DeviceNWelcomeHomeFragment var1, String var2) {
      TextView var3 = var0.radiusText;
      StringBuilder var4 = new StringBuilder();
      var4.append(var1.getString(R.string.welcome_home_radius));
      var4.append(" <b>");
      var4.append(var2);
      var4.append("</b>");
      var3.setText((CharSequence)HtmlCompat.fromHtml(var4.toString(), 0));
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$9(DeviceNWelcomeHomeFragment var0, Boolean var1) {
      FragmentDeviceNWelcomeHomeBinding var2 = var0.binding;
      FragmentDeviceNWelcomeHomeBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      SwitchCompat var4 = var3.switchBtn;
      Intrinsics.checkNotNull(var1);
      var4.setCheckedSilence(var1);
      return Unit.INSTANCE;
   }

   private final void openCreateUpdateWelcomeHome() {
      Context var1 = this.getContext();
      if (var1 != null) {
         this.startActivity(WelcomeHomeConfigActivity.Companion.getLaunchIntent(var1, this.getViewModel().getDevice()));
      }

   }

   public DeviceWelcomeHomeViewModel getViewModel() {
      DeviceWelcomeHomeViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      var3 = this.getArguments();
      Object var4 = null;
      Parcelable var13;
      if (var3 != null) {
         var13 = var3.getParcelable("device");
      } else {
         var13 = null;
      }

      if (var13 != null) {
         this.setViewModel((DeviceWelcomeHomeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceWelcomeHomeViewModel.class)));
         DeviceWelcomeHomeViewModel var5 = this.getViewModel();
         Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type com.blueair.core.model.HasWelcomeHome");
         var5.setDevice((HasWelcomeHome)var13);
         FragmentDeviceNWelcomeHomeBinding var10 = FragmentDeviceNWelcomeHomeBinding.inflate(var1, var2, false);
         Intrinsics.checkNotNullExpressionValue(var10, "inflate(...)");
         this.binding = var10;
         FragmentDeviceNWelcomeHomeBinding var6 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.setVm(this.getViewModel());
         var10 = this.binding;
         var6 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.setLifecycleOwner(this.getViewLifecycleOwner());
         var6 = this.binding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = (FragmentDeviceNWelcomeHomeBinding)var4;
         }

         View var9 = var6.getRoot();
         Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
         return var9;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentDeviceNWelcomeHomeBinding var4 = this.binding;
      FragmentDeviceNWelcomeHomeBinding var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      var3.addBtn.setOnClickListener(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda0(this));
      var3.switchBtn.setOnCheckedChangeListener(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda1(this, var3));
      var3.addressContainer.setOnClickListener(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda2(this));
      this.getViewModel().getRadius().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda3(var3, this)) {
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
      this.getViewModel().getWelcomeHomeEnabled().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda4(this)) {
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
      this.getViewModel().getLiveDeviceWelcomeHome(this.getViewModel().getDevice().getUid()).observe(this.getViewLifecycleOwner(), new Observer(new DeviceNWelcomeHomeFragment$$ExternalSyntheticLambda5(this)) {
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

   public void setViewModel(DeviceWelcomeHomeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceNWelcomeHomeFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceNWelcomeHomeFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceNWelcomeHomeFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceNWelcomeHomeFragment var2 = new DeviceNWelcomeHomeFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1)}));
         return var2;
      }
   }
}
