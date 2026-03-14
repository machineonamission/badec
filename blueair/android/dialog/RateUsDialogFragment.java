package com.blueair.android.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ScrollView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.databinding.DialogfragmentRateUsBinding;
import com.blueair.core.util.PhoneUtil;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000b¨\u0006'"},
   d2 = {"Lcom/blueair/android/dialog/RateUsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "skip", "", "binding", "Lcom/blueair/android/databinding/DialogfragmentRateUsBinding;", "visitHuaweiStore", "", "getVisitHuaweiStore", "()Ljava/lang/String;", "visitHuaweiStore$delegate", "Lkotlin/Lazy;", "visitTencentStore", "getVisitTencentStore", "visitTencentStore$delegate", "viewModel", "Lcom/blueair/android/dialog/RateUsViewModel;", "trigger", "getTrigger", "trigger$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "redirectToMarket", "openFeedbackLink", "switchLayouts", "animateRateUsShow", "dismiss", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RateUsDialogFragment extends DialogFragment {
   public static final int $stable = 8;
   private static final String ARGUMENT_IS_IN_CHINA = "IS_IN_CHINA";
   private static final String ARGUMENT_TRIGGER = "TRIGGER";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogfragmentRateUsBinding binding;
   private boolean skip = true;
   private final Lazy trigger$delegate = LazyKt.lazy(new RateUsDialogFragment$$ExternalSyntheticLambda2(this));
   private RateUsViewModel viewModel;
   private final Lazy visitHuaweiStore$delegate = LazyKt.lazy(new RateUsDialogFragment$$ExternalSyntheticLambda0(this));
   private final Lazy visitTencentStore$delegate = LazyKt.lazy(new RateUsDialogFragment$$ExternalSyntheticLambda1(this));

   // $FF: synthetic method
   public static void $r8$lambda$1tbMkOrB3iK3dVQH5YvJ5gew8pU(RateUsDialogFragment var0, View var1) {
      onViewCreated$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$3guZ0m2WvoYVBLazx705sDYIXN8(RateUsDialogFragment var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$N7sQ2nwiL3tbPdbA0tj9pjk4syo(RateUsDialogFragment var0) {
      return visitTencentStore_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$PaQOr2i_AEBCewOKMiYTL3N180E/* $FF was: $r8$lambda$PaQOr2i-AEBCewOKMiYTL3N180E*/(RateUsDialogFragment var0, View var1) {
      onViewCreated$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$gp3ywtj2nc7eHv_GJ6z2bdDuqSk/* $FF was: $r8$lambda$gp3ywtj2nc7eHv-GJ6z2bdDuqSk*/(RateUsDialogFragment var0) {
      return visitHuaweiStore_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$jNFabmbsHi6DHvt4LIaUWYf_6Gg(RateUsDialogFragment var0) {
      return trigger_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$lfFEGjEocnwSU3kpb0fIzXGmmjc(RateUsDialogFragment var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$x0jEAf0ofJKhbuvpoYSA1NBoETI(RateUsDialogFragment var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   private final void animateRateUsShow() {
      DialogfragmentRateUsBinding var2 = this.binding;
      DialogfragmentRateUsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ViewPropertyAnimator var3 = var1.viewRateUs.animate();
      if (var3 != null) {
         var3 = var3.alpha(1.0F);
         if (var3 != null) {
            var3 = var3.setDuration(150L);
            if (var3 != null) {
               var3 = var3.setListener((Animator.AnimatorListener)(new AnimatorListenerAdapter(this) {
                  final RateUsDialogFragment this$0;

                  {
                     this.this$0 = var1;
                  }

                  public void onAnimationEnd(Animator var1) {
                     Intrinsics.checkNotNullParameter(var1, "animation");
                     DialogfragmentRateUsBinding var3 = this.this$0.binding;
                     Object var2 = null;
                     DialogfragmentRateUsBinding var4 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var4 = null;
                     }

                     var4.buttonRateCancel.setClickable(true);
                     var4 = this.this$0.binding;
                     if (var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var4 = (DialogfragmentRateUsBinding)var2;
                     }

                     var4.buttonRateRedirect.setClickable(true);
                  }
               }));
               if (var3 != null) {
                  var3.start();
               }
            }
         }
      }

   }

   private final String getTrigger() {
      return (String)this.trigger$delegate.getValue();
   }

   private final String getVisitHuaweiStore() {
      return (String)this.visitHuaweiStore$delegate.getValue();
   }

   private final String getVisitTencentStore() {
      return (String)this.visitTencentStore$delegate.getValue();
   }

   private static final void onViewCreated$lambda$3(RateUsDialogFragment var0, View var1) {
      var0.skip = false;
      RateUsViewModel var2 = var0.viewModel;
      RateUsViewModel var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var3 = null;
      }

      var3.onImprovePositive(var0.getTrigger());
      var0.switchLayouts();
   }

   private static final void onViewCreated$lambda$4(RateUsDialogFragment var0, View var1) {
      var0.skip = false;
      RateUsViewModel var2 = var0.viewModel;
      RateUsViewModel var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var3 = null;
      }

      var3.onImproveNegative(var0.getTrigger());
      var0.openFeedbackLink();
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$5(RateUsDialogFragment var0, View var1) {
      var0.redirectToMarket();
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$6(RateUsDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$7(RateUsDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private final void openFeedbackLink() {
      RateUsViewModel var2 = this.viewModel;
      RateUsViewModel var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var1 = null;
      }

      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1.getFeedbackLink())));
   }

   private final void redirectToMarket() {
      RateUsViewModel var2 = this.viewModel;
      RateUsViewModel var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var1 = null;
      }

      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1.getMarketLink())));
   }

   private final void switchLayouts() {
      DialogfragmentRateUsBinding var2 = this.binding;
      DialogfragmentRateUsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ViewPropertyAnimator var3 = var1.viewHelpUsImprove.animate();
      if (var3 != null) {
         var3 = var3.alpha(0.0F);
         if (var3 != null) {
            var3 = var3.setDuration(150L);
            if (var3 != null) {
               var3 = var3.setListener((Animator.AnimatorListener)(new AnimatorListenerAdapter(this) {
                  final RateUsDialogFragment this$0;

                  {
                     this.this$0 = var1;
                  }

                  public void onAnimationEnd(Animator var1) {
                     Intrinsics.checkNotNullParameter(var1, "animation");
                     DialogfragmentRateUsBinding var2 = this.this$0.binding;
                     DialogfragmentRateUsBinding var3 = var2;
                     if (var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var3 = null;
                     }

                     var3.viewHelpUsImprove.setVisibility(4);
                     this.this$0.animateRateUsShow();
                  }

                  public void onAnimationStart(Animator var1) {
                     Intrinsics.checkNotNullParameter(var1, "animation");
                     DialogfragmentRateUsBinding var3 = this.this$0.binding;
                     Object var2 = null;
                     DialogfragmentRateUsBinding var4 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var4 = null;
                     }

                     var4.buttonImproveNegative.setClickable(false);
                     var3 = this.this$0.binding;
                     var4 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var4 = null;
                     }

                     var4.buttonImprovePositive.setClickable(false);
                     var4 = this.this$0.binding;
                     if (var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var4 = (DialogfragmentRateUsBinding)var2;
                     }

                     var4.textDescription.setText((CharSequence)this.this$0.getString(R.string.rate_us_description_feedback));
                  }
               }));
               if (var3 != null) {
                  var3.start();
               }
            }
         }
      }

   }

   private static final String trigger_delegate$lambda$2(RateUsDialogFragment var0) {
      String var1 = var0.requireArguments().getString("TRIGGER", (String)null);
      if (var1 != null) {
         return var1;
      } else {
         throw new IllegalArgumentException("Required value was null.".toString());
      }
   }

   private static final String visitHuaweiStore_delegate$lambda$0(RateUsDialogFragment var0) {
      return var0.getString(R.string.rate_us_visit_huawei_store);
   }

   private static final String visitTencentStore_delegate$lambda$1(RateUsDialogFragment var0) {
      return var0.getString(R.string.rate_us_visit_tencent_store);
   }

   public void dismiss() {
      if (this.skip) {
         RateUsViewModel var2 = this.viewModel;
         RateUsViewModel var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            var1 = null;
         }

         var1.onSkip(this.getTrigger());
      }

      super.dismiss();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.viewModel = (RateUsViewModel)(new ViewModelProvider((ViewModelStoreOwner)this)).get(RateUsViewModel.class);
      DialogfragmentRateUsBinding var6 = DialogfragmentRateUsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentRateUsBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ScrollView var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      DialogfragmentRateUsBinding var3 = this.binding;
      Object var12 = null;
      DialogfragmentRateUsBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonImprovePositive.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda3(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonImproveNegative.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda4(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonRateRedirect.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda5(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.buttonRateCancel.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda6(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.imClose.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda7(this));
      if (this.requireArguments().getBoolean("IS_IN_CHINA")) {
         var4 = this.binding;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = (DialogfragmentRateUsBinding)var12;
         }

         MaterialButton var13 = var4.buttonRateRedirect;
         PhoneUtil var10 = PhoneUtil.INSTANCE;
         Context var18 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var18, "requireContext(...)");
         CharSequence var11;
         if (var10.isHuaweiServicesAvailable(var18)) {
            var11 = (CharSequence)this.getVisitHuaweiStore();
         } else {
            var11 = (CharSequence)this.getVisitTencentStore();
         }

         var13.setText(var11);
      }

   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/android/dialog/RateUsDialogFragment$Companion;", "", "<init>", "()V", "ARGUMENT_IS_IN_CHINA", "", "ARGUMENT_TRIGGER", "newInstance", "Lcom/blueair/android/dialog/RateUsDialogFragment;", "isInChina", "", "trigger", "app_otherRelease"},
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

      public final RateUsDialogFragment newInstance(boolean var1, String var2) {
         Intrinsics.checkNotNullParameter(var2, "trigger");
         RateUsDialogFragment var3 = new RateUsDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("IS_IN_CHINA", var1), TuplesKt.to("TRIGGER", var2)}));
         return var3;
      }
   }
}
