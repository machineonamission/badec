package com.blueair.adddevice.fragment;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.FragmentEnterDeviceNameBinding;
import com.blueair.adddevice.dialog.FinalizeDialog;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.auth.LocationService;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001cH\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010*\u001a\u00020+X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0018\u0010.\u001a\u00020\u0002X\u0096\u000f¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"},
   d2 = {"Lcom/blueair/adddevice/fragment/EnterDeviceNameFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentEnterDeviceNameBinding;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showProgress", "", "shouldShowProgress", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "observeViewModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class EnterDeviceNameFragment extends BaseFragment implements BaseFragmentInterface, ProgressFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(EnterDeviceNameFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   private final AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
   private final Lazy locationService$delegate;
   private ProgressBlockerView progressBlockerView;
   private final String screenName = "add_device_set_name";
   private FragmentEnterDeviceNameBinding viewDataBinding;

   // $FF: synthetic method
   public static void $r8$lambda$YcVBYVpPLm0DAOoRl81rZZYtkZk(EnterDeviceNameFragment var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$trPvlUGF6EtqX7C6Pec1Lc8dYos(EnterDeviceNameFragment var0, String var1) {
      return observeViewModel$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vYrLwB8sIAeWYBas5KKjn3Ldw4s(EnterDeviceNameFragment var0, String var1, Bundle var2) {
      return onViewCreated$lambda$3$lambda$2(var0, var1, var2);
   }

   public EnterDeviceNameFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, LocationService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final void observeViewModel() {
      this.getViewModel().getLiveSelectedDeviceName().observe(this.getViewLifecycleOwner(), new Observer(new EnterDeviceNameFragment$$ExternalSyntheticLambda0(this)) {
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

   private static final Unit observeViewModel$lambda$5(EnterDeviceNameFragment var0, String var1) {
      FragmentEnterDeviceNameBinding var6 = var0.viewDataBinding;
      Object var5 = null;
      FragmentEnterDeviceNameBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      MaterialButton var13 = var4.buttonDone;
      String var11;
      if (var1 != null) {
         var11 = StringsKt.trim((CharSequence)var1).toString();
      } else {
         var11 = null;
      }

      CharSequence var12 = (CharSequence)var11;
      boolean var3 = false;
      boolean var2;
      if (var12 != null && var12.length() != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      var13.setEnabled(var2 ^ true);
      FragmentEnterDeviceNameBinding var7 = var0.viewDataBinding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var7 = (FragmentEnterDeviceNameBinding)var5;
      }

      label25: {
         var8 = var7.inputDeviceName;
         CharSequence var9 = (CharSequence)var1;
         if (var9 != null) {
            var2 = var3;
            if (var9.length() != 0) {
               break label25;
            }
         }

         var2 = true;
      }

      var8.setEndIconVisible(var2 ^ true);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$3(EnterDeviceNameFragment var0, View var1) {
      FragmentManager var4 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("FinalizeDialog", "getSimpleName(...)");
      DialogFragment var6;
      if (!(var4.findFragmentByTag("FinalizeDialog") instanceof FinalizeDialog) && !var4.isStateSaved()) {
         FinalizeDialog.Companion var5 = FinalizeDialog.Companion;
         String var7 = var0.getViewModel().getDetectedDeviceUuid();
         String var2 = var7;
         if (var7 == null) {
            var2 = "";
         }

         String var3 = var0.getViewModel().getSelectedDeviceName();
         var7 = var3;
         if (var3 == null) {
            if (var0.getLocationService().isInG4ProtectRegion()) {
               var7 = "Protect";
            } else {
               var7 = "HealthProtect";
            }
         }

         BluetoothDevice var10 = var0.getViewModel().getSelectedUiDevice();
         Intrinsics.checkNotNull(var10);
         var6 = var5.newInstance(var2, var7, var10);
         ((DialogFragment)var6).show(var4, "FinalizeDialog");
      } else {
         var6 = null;
      }

      var6 = var6;
      if (var6 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var6, "FinalizeDialog", new EnterDeviceNameFragment$$ExternalSyntheticLambda1(var0));
      }

   }

   private static final Unit onViewCreated$lambda$3$lambda$2(EnterDeviceNameFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_choose_device")) {
         var0.getViewModel().clearOnboardedDevices();
         var0.getViewModel().reset();
         var0.getViewModel().restart();
      }

      return Unit.INSTANCE;
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentEnterDeviceNameBinding var2 = this.viewDataBinding;
      FragmentEnterDeviceNameBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "rootLayout");
      return var3;
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

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentEnterDeviceNameBinding var9 = FragmentEnterDeviceNameBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var9, "inflate(...)");
      FragmentActivity var4 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
      var9.setAddDeviceViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var4)).get(AddDeviceViewModel.class)));
      AddDeviceViewModel var5 = var9.getAddDeviceViewModel();
      Intrinsics.checkNotNull(var5);
      this.setViewModel(var5);
      var9.setLifecycleOwner((LifecycleOwner)this.requireActivity());
      this.viewDataBinding = var9;
      Object var10 = null;
      FragmentEnterDeviceNameBinding var6 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      this.setProgressBlockerView(var6.progressView);
      var6 = this.viewDataBinding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = (FragmentEnterDeviceNameBinding)var10;
      }

      View var8 = var6.getRoot();
      Intrinsics.checkNotNullExpressionValue(var8, "getRoot(...)");
      return var8;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.observeViewModel();
      FragmentEnterDeviceNameBinding var3 = this.viewDataBinding;
      FragmentEnterDeviceNameBinding var9 = null;
      FragmentEnterDeviceNameBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      var4.buttonDone.setOnClickListener(new EnterDeviceNameFragment$$ExternalSyntheticLambda2(this));
      var3 = this.viewDataBinding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      label25: {
         TextInputEditText var6 = var4.etDeviceName;
         Intrinsics.checkNotNullExpressionValue(var6, "etDeviceName");
         ((TextView)var6).addTextChangedListener(new TextWatcher(this) {
            final EnterDeviceNameFragment this$0;

            public {
               this.this$0 = var1;
            }

            public void afterTextChanged(Editable var1) {
               if (var1 == null) {
                  this.this$0.getViewModel().setDeviceName("");
               } else {
                  this.this$0.getViewModel().setDeviceName(var1.toString());
               }
            }

            public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }

            public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }
         });
         BluetoothDevice var7 = this.getViewModel().getSelectedUiDevice();
         if (var7 != null) {
            String var11 = var7.getFamilyName();
            var8 = var11;
            if (var11 != null) {
               break label25;
            }
         }

         var8 = "";
      }

      CharSequence var12 = (CharSequence)var8;
      if (StringsKt.contains$default(var12, (CharSequence)"\n", false, 2, (Object)null)) {
         var8 = (String)CollectionsKt.first(StringsKt.split$default(var12, new String[]{"\n"}, false, 0, 6, (Object)null));
      }

      FragmentEnterDeviceNameBinding var13 = this.viewDataBinding;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
      } else {
         var9 = var13;
      }

      var9.etDeviceName.setText((CharSequence)var8);
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
}
