package com.blueair.devicedetails.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.blueair.devicedetails.databinding.DialogfragmentWhPermissionsBinding;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtilsKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\tR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\tR\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001d¨\u0006."},
   d2 = {"Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentWhPermissionsBinding;", "stringNext", "", "getStringNext", "()Ljava/lang/String;", "stringNext$delegate", "Lkotlin/Lazy;", "stringGotIt", "getStringGotIt", "stringGotIt$delegate", "stringBack", "getStringBack", "stringBack$delegate", "stringTryLater", "getStringTryLater", "stringTryLater$delegate", "value", "Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage;", "currentPage", "setCurrentPage", "(Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage;)V", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updatePage", "page", "openSettings", "PermissionsInstructionsPage", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomePermissionsDialogFragment extends DialogFragment {
   private DialogfragmentWhPermissionsBinding binding;
   private PermissionsInstructionsPage currentPage;
   private final Lazy stringBack$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda2(this));
   private final Lazy stringGotIt$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda1(this));
   private final Lazy stringNext$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda0(this));
   private final Lazy stringTryLater$delegate = LazyKt.lazy(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda3(this));
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$7fwjYGx_G5xJMjqYICi1X_poPI8/* $FF was: $r8$lambda$7fwjYGx-G5xJMjqYICi1X-poPI8*/(WelcomeHomePermissionsDialogFragment var0, View var1) {
      onViewCreated$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$FLvI15tcWtQr4OUiLOpGmOheMqs(WelcomeHomePermissionsDialogFragment var0) {
      return stringNext_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GVGPro3THzkEEOWl3tgO1pgBBiM(WelcomeHomePermissionsDialogFragment var0, View var1) {
      return onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$IHU87I8_8pzgV5F2BjMO_s_au6U/* $FF was: $r8$lambda$IHU87I8-8pzgV5F2BjMO-s-au6U*/(WelcomeHomePermissionsDialogFragment var0) {
      return stringBack_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$V3LyLIvaZVYwOez_N9FJqOqB4JE/* $FF was: $r8$lambda$V3LyLIvaZVYwOez-N9FJqOqB4JE*/(WelcomeHomePermissionsDialogFragment var0) {
      return stringTryLater_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_9iofaUYpnMNqR1pglwBsWlsrXs(WelcomeHomePermissionsDialogFragment var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$oNA1h7JFbQtH1QLzKDBRXUyP0K4(WelcomeHomePermissionsDialogFragment var0) {
      return stringGotIt_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tn5PDkXlFm89q5V6ibge9r1AzMc(WelcomeHomePermissionsDialogFragment var0, View var1) {
      return onViewCreated$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$wwIh2qWOiwHV0KmAxOhilQmar1w(WelcomeHomePermissionsDialogFragment var0, View var1) {
      onViewCreated$lambda$4(var0, var1);
   }

   public WelcomeHomePermissionsDialogFragment() {
      this.currentPage = WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.SECOND;
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

   private final String getStringBack() {
      return (String)this.stringBack$delegate.getValue();
   }

   private final String getStringGotIt() {
      return (String)this.stringGotIt$delegate.getValue();
   }

   private final String getStringNext() {
      return (String)this.stringNext$delegate.getValue();
   }

   private final String getStringTryLater() {
      return (String)this.stringTryLater$delegate.getValue();
   }

   private final DeviceWelcomeHomeViewModel getViewModel() {
      return (DeviceWelcomeHomeViewModel)this.viewModel$delegate.getValue();
   }

   private static final void onViewCreated$lambda$4(WelcomeHomePermissionsDialogFragment var0, View var1) {
      var0.openSettings();
   }

   private static final void onViewCreated$lambda$5(WelcomeHomePermissionsDialogFragment var0, View var1) {
      var0.openSettings();
   }

   private static final void onViewCreated$lambda$6(WelcomeHomePermissionsDialogFragment var0, View var1) {
      var0.openSettings();
   }

   private static final Unit onViewCreated$lambda$7(WelcomeHomePermissionsDialogFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      PermissionsInstructionsPage var3 = var0.currentPage;
      int var2 = WelcomeHomePermissionsDialogFragment.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      if (var2 != 1) {
         if (var2 == 2) {
            var0.getViewModel().setAddHomeInstructionShowed();
            var0.dismiss();
         }
      } else {
         var0.setCurrentPage(WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.THIRD);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$8(WelcomeHomePermissionsDialogFragment var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      PermissionsInstructionsPage var3 = var0.currentPage;
      int var2 = WelcomeHomePermissionsDialogFragment.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      if (var2 != 1) {
         if (var2 == 2) {
            var0.setCurrentPage(WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.SECOND);
         }
      } else {
         var0.dismiss();
      }

      return Unit.INSTANCE;
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

   private final void setCurrentPage(PermissionsInstructionsPage var1) {
      this.currentPage = var1;
      this.updatePage(var1);
   }

   private static final String stringBack_delegate$lambda$2(WelcomeHomePermissionsDialogFragment var0) {
      return var0.getString(R.string.button_back);
   }

   private static final String stringGotIt_delegate$lambda$1(WelcomeHomePermissionsDialogFragment var0) {
      return var0.getString(R.string.button_got_it);
   }

   private static final String stringNext_delegate$lambda$0(WelcomeHomePermissionsDialogFragment var0) {
      return var0.getString(R.string.button_next);
   }

   private static final String stringTryLater_delegate$lambda$3(WelcomeHomePermissionsDialogFragment var0) {
      return var0.getString(R.string.button_try_later);
   }

   private final void updatePage(PermissionsInstructionsPage var1) {
      int var2 = WelcomeHomePermissionsDialogFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      Object var5 = null;
      Object var3 = null;
      Object var4 = null;
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               DialogfragmentWhPermissionsBinding var23 = this.binding;
               DialogfragmentWhPermissionsBinding var16 = var23;
               if (var23 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var16 = null;
               }

               var16.tvPermissionsTitle.setVisibility(8);
               var23 = this.binding;
               var16 = var23;
               if (var23 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var16 = null;
               }

               var16.tvScheduleAffect.setVisibility(0);
               var23 = this.binding;
               var16 = var23;
               if (var23 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var16 = null;
               }

               var16.containerSecondPage.setVisibility(8);
               var16 = this.binding;
               if (var16 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var16 = (DialogfragmentWhPermissionsBinding)var4;
               }

               var16.btnBack.setText((CharSequence)this.getStringTryLater());
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            DialogfragmentWhPermissionsBinding var20 = this.binding;
            DialogfragmentWhPermissionsBinding var12 = var20;
            if (var20 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = null;
            }

            var12.containerSecondPage.setVisibility(8);
            var20 = this.binding;
            var12 = var20;
            if (var20 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = null;
            }

            var12.containerThirdPage.setVisibility(0);
            var20 = this.binding;
            var12 = var20;
            if (var20 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = null;
            }

            var12.btnNext.setText((CharSequence)this.getStringGotIt());
            var12 = this.binding;
            if (var12 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = (DialogfragmentWhPermissionsBinding)var5;
            }

            var12.btnBack.setText((CharSequence)this.getStringBack());
         }
      } else {
         DialogfragmentWhPermissionsBinding var26 = this.binding;
         DialogfragmentWhPermissionsBinding var6 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.tvPermissionsTitle.setVisibility(0);
         var26 = this.binding;
         var6 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.tvScheduleAffect.setVisibility(8);
         var26 = this.binding;
         var6 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.containerSecondPage.setVisibility(0);
         var26 = this.binding;
         var6 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.containerThirdPage.setVisibility(8);
         var26 = this.binding;
         var6 = var26;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.btnNext.setText((CharSequence)this.getStringNext());
         var6 = this.binding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = (DialogfragmentWhPermissionsBinding)var3;
         }

         var6.btnBack.setText((CharSequence)this.getStringTryLater());
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentWhPermissionsBinding var6 = DialogfragmentWhPermissionsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentWhPermissionsBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      LinearLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentWhPermissionsBinding var3 = this.binding;
      Object var11 = null;
      DialogfragmentWhPermissionsBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnGtsLocation.setOnClickListener(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda4(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnGtsAutostart.setOnClickListener(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda5(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnGtsPowerManagement.setOnClickListener(new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda6(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      MaterialButton var8 = var4.btnNext;
      Intrinsics.checkNotNullExpressionValue(var8, "btnNext");
      ViewUtilsKt.setOnClickListener((View)var8, 200L, new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda7(this));
      DialogfragmentWhPermissionsBinding var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = (DialogfragmentWhPermissionsBinding)var11;
      }

      MaterialButton var10 = var9.btnBack;
      Intrinsics.checkNotNullExpressionValue(var10, "btnBack");
      ViewUtilsKt.setOnClickListener((View)var10, 200L, new WelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda8(this));
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/devicedetails/dialog/WelcomeHomePermissionsDialogFragment$PermissionsInstructionsPage;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "SECOND", "THIRD", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static enum PermissionsInstructionsPage {
      private static final EnumEntries $ENTRIES;
      private static final PermissionsInstructionsPage[] $VALUES;
      FIRST,
      SECOND,
      THIRD;

      // $FF: synthetic method
      private static final PermissionsInstructionsPage[] $values() {
         return new PermissionsInstructionsPage[]{FIRST, SECOND, THIRD};
      }

      static {
         PermissionsInstructionsPage[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.values().length];

         try {
            var0[WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.SECOND.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.THIRD.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[WelcomeHomePermissionsDialogFragment.PermissionsInstructionsPage.FIRST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
