package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import com.blueair.devicedetails.databinding.DialogfragmentSimpleWhPermissionsBinding;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtilsKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "},
   d2 = {"Lcom/blueair/devicedetails/dialog/SimpleWelcomeHomePermissionsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentSimpleWhPermissionsBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "resultListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "openSettings", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleWelcomeHomePermissionsDialogFragment extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogfragmentSimpleWhPermissionsBinding binding;
   private Function1 resultListener;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$L52GLKRASz3s_FJs1Td_9iCHwRY/* $FF was: $r8$lambda$L52GLKRASz3s-FJs1Td_9iCHwRY*/(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      return onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$RwNZiPdqhiBo7OeDtq_07tsW1t0(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      onViewCreated$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Y_rt74Mm4rRUwd8OR4Xd2AE7gic/* $FF was: $r8$lambda$Y-rt74Mm4rRUwd8OR4Xd2AE7gic*/(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      onViewCreated$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$bhfNmdYZ4OZt_pkgZ01GNCt202A(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      onViewCreated$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jK20yHiaQRUJE_dQ_rWxeqZJwLo/* $FF was: $r8$lambda$jK20yHiaQRUJE-dQ_rWxeqZJwLo*/(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      return onViewCreated$lambda$2(var0, var1);
   }

   public SimpleWelcomeHomePermissionsDialogFragment() {
      Fragment var1 = (Fragment)this;
      Function0 var2 = new Function0(var1) {
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final Fragment invoke() {
            return this.$this_viewModels;
         }
      };
      Lazy var3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0(var2) {
         final Function0 $ownerProducer;

         public {
            this.$ownerProducer = var1;
         }

         public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner)this.$ownerProducer.invoke();
         }
      });
      this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(var1, Reflection.getOrCreateKotlinClass(DeviceWelcomeHomeViewModel.class), new Function0(var3) {
         final Lazy $owner$delegate;

         public {
            this.$owner$delegate = var1;
         }

         public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate).getViewModelStore();
         }
      }, new Function0((Function0)null, var3) {
         final Function0 $extrasProducer;
         final Lazy $owner$delegate;

         public {
            this.$extrasProducer = var1;
            this.$owner$delegate = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            ViewModelStoreOwner var3 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var4;
            if (var3 instanceof HasDefaultViewModelProviderFactory) {
               var4 = (HasDefaultViewModelProviderFactory)var3;
            } else {
               var4 = null;
            }

            return var4 != null ? var4.getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         }
      }, new Function0(var1, var3) {
         final Lazy $owner$delegate;
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
            this.$owner$delegate = var2;
         }

         public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner var1 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var2;
            if (var1 instanceof HasDefaultViewModelProviderFactory) {
               var2 = (HasDefaultViewModelProviderFactory)var1;
            } else {
               var2 = null;
            }

            if (var2 != null) {
               ViewModelProvider.Factory var3 = var2.getDefaultViewModelProviderFactory();
               if (var3 != null) {
                  return var3;
               }
            }

            ViewModelProvider.Factory var4 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(var4, "defaultViewModelProviderFactory");
            return var4;
         }
      });
   }

   private final DeviceWelcomeHomeViewModel getViewModel() {
      return (DeviceWelcomeHomeViewModel)this.viewModel$delegate.getValue();
   }

   private static final void onViewCreated$lambda$0(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      var0.openSettings();
   }

   private static final void onViewCreated$lambda$1(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      var0.openSettings();
   }

   private static final Unit onViewCreated$lambda$2(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Function1 var2 = var0.resultListener;
      if (var2 != null) {
         var2.invoke(true);
      }

      var0.dismissAllowingStateLoss();
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$3(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Function1 var2 = var0.resultListener;
      if (var2 != null) {
         var2.invoke(false);
      }

      var0.dismissAllowingStateLoss();
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$4(SimpleWelcomeHomePermissionsDialogFragment var0, View var1) {
      var0.dismissAllowingStateLoss();
   }

   private final void openSettings() {
      Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      StringBuilder var3 = new StringBuilder("package:");
      Context var1 = this.getContext();
      String var4;
      if (var1 != null) {
         var4 = var1.getPackageName();
      } else {
         var4 = null;
      }

      var3.append(var4);
      var2.setData(Uri.parse(var3.toString()));
      Context var5 = this.getContext();
      if (var5 != null) {
         var5.startActivity(var2);
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentSimpleWhPermissionsBinding var6 = DialogfragmentSimpleWhPermissionsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentSimpleWhPermissionsBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      LinearLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var2.setGravity(48);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.setStyle(0, R.style.DialogTheme);
      DialogfragmentSimpleWhPermissionsBinding var3 = this.binding;
      Object var11 = null;
      DialogfragmentSimpleWhPermissionsBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnGtsAutostart.setOnClickListener(new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda0(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnGtsPowerManagement.setOnClickListener(new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda1(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      MaterialButton var7 = var4.btnNext;
      Intrinsics.checkNotNullExpressionValue(var7, "btnNext");
      ViewUtilsKt.setOnClickListener((View)var7, 200L, new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda2(this));
      var3 = this.binding;
      DialogfragmentSimpleWhPermissionsBinding var8 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      MaterialButton var9 = var8.btnBack;
      Intrinsics.checkNotNullExpressionValue(var9, "btnBack");
      ViewUtilsKt.setOnClickListener((View)var9, 200L, new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda3(this));
      DialogfragmentSimpleWhPermissionsBinding var10 = this.binding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = (DialogfragmentSimpleWhPermissionsBinding)var11;
      }

      var10.ivClose.setOnClickListener(new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda4(this));
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/dialog/SimpleWelcomeHomePermissionsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/SimpleWelcomeHomePermissionsDialogFragment;", "resultListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static SimpleWelcomeHomePermissionsDialogFragment newInstance$default(Companion var0, Function1 var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = null;
         }

         return var0.newInstance(var1);
      }

      public final SimpleWelcomeHomePermissionsDialogFragment newInstance(Function1 var1) {
         new Bundle();
         SimpleWelcomeHomePermissionsDialogFragment var2 = new SimpleWelcomeHomePermissionsDialogFragment();
         var2.resultListener = var1;
         return var2;
      }
   }
}
