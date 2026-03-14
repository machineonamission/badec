package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blueair.viewcore.databinding.DialogfragmentStepGuideBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0014H\u0002J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"},
   d2 = {"Lcom/blueair/viewcore/dialog/StepGuideDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/DialogfragmentStepGuideBinding;", "stepGuides", "Lcom/blueair/viewcore/dialog/StepGuides;", "getStepGuides", "()Lcom/blueair/viewcore/dialog/StepGuides;", "stepGuides$delegate", "Lkotlin/Lazy;", "currentStep", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "currentStepValue", "getCurrentStepValue", "()I", "isCompleteBtnClicked", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setPage", "", "title", "", "content", "btn", "backEnabled", "onViewCreated", "view", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StepGuideDialogFragment extends DialogFragment {
   private static final String ARG_STEP_GUIDES = "ARG_STEP_GUIDES";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DATA_COMPLETED = "DATA_COMPLETED";
   public static final String DEFAULT_REQUEST_KEY = "StepGuideDialogFragment";
   private DialogfragmentStepGuideBinding binding;
   private MutableLiveData currentStep = new MutableLiveData(0);
   private boolean isCompleteBtnClicked;
   private final Lazy stepGuides$delegate = LazyKt.lazy(new StepGuideDialogFragment$$ExternalSyntheticLambda0(this));

   // $FF: synthetic method
   public static StepGuides $r8$lambda$1QUQ_2ZN3tAx6r1KZJsjxLKDoIo(StepGuideDialogFragment var0) {
      return stepGuides_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DFEqVzEzJrurJEeIkJGlHwEDwyY(int var0, StepGuideDialogFragment var1, StepGuides var2, Integer var3) {
      return onViewCreated$lambda$5$lambda$4(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Pg8CRfe5pnVAgieuvbxP5eP1__g/* $FF was: $r8$lambda$Pg8CRfe5pnVAgieuvbxP5eP1-_g*/(StepGuideDialogFragment var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cO6s5wfwjD6oMLRWAWvKH6MVrCY(StepGuideDialogFragment var0, View var1) {
      onViewCreated$lambda$5$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jlHPtZzedQo1McWvN1dYweW_q7Y(StepGuideDialogFragment var0, StepGuides var1, View var2) {
      onViewCreated$lambda$5$lambda$3(var0, var1, var2);
   }

   private final int getCurrentStepValue() {
      Object var1 = this.currentStep.getValue();
      Intrinsics.checkNotNull(var1);
      return ((Number)var1).intValue();
   }

   private final StepGuides getStepGuides() {
      return (StepGuides)this.stepGuides$delegate.getValue();
   }

   private static final void onViewCreated$lambda$5$lambda$2(StepGuideDialogFragment var0, View var1) {
      var0.currentStep.setValue(var0.getCurrentStepValue() - 1);
   }

   private static final void onViewCreated$lambda$5$lambda$3(StepGuideDialogFragment var0, StepGuides var1, View var2) {
      if (var0.getCurrentStepValue() == var1.getPageSize() - 1) {
         var0.isCompleteBtnClicked = true;
         var0.dismiss();
      } else {
         var0.currentStep.setValue(var0.getCurrentStepValue() + 1);
      }
   }

   private static final Unit onViewCreated$lambda$5$lambda$4(int var0, StepGuideDialogFragment var1, StepGuides var2, Integer var3) {
      boolean var6 = false;
      if (var3 != null && var3 == var0) {
         var3 = var2.getHeadTitle();
         Intrinsics.checkNotNull(var3);
         String var15 = var1.getString(var3);
         Intrinsics.checkNotNullExpressionValue(var15, "getString(...)");
         Integer var22 = var2.getHeadMessage();
         Intrinsics.checkNotNull(var22);
         var0 = var22;
         Integer var12 = var2.getHeadBtn();
         Intrinsics.checkNotNull(var12);
         var1.setPage(var15, var0, var12, false);
      } else {
         int var4 = var2.getPageSize();
         if (var3 != null && var3 == var4 - 1) {
            String var13 = var1.getString(var2.getCompleteTitle());
            Intrinsics.checkNotNullExpressionValue(var13, "getString(...)");
            var1.setPage(var13, var2.getCompleteMessage(), var2.getCompleteBtn(), true);
         } else {
            IntRange var7 = new IntRange(var0 + 1, var2.getPageSize());
            int var5 = var7.getFirst();
            var0 = var7.getLast();
            Intrinsics.checkNotNull(var3);
            var4 = var3;
            if (var5 <= var4 && var4 <= var0) {
               var4 = var3;
               if (var2.getHeadTitle() == null) {
                  var0 = 0;
               } else {
                  var0 = 1;
               }

               var4 -= var0;
               var0 = ((Number)var2.getStepMessages().get(var4)).intValue();
               StringBuilder var20 = new StringBuilder();
               var20.append(var1.getString(var2.getStepTitle()));
               var20.append(' ');
               var20.append(var4 + 1);
               var20.append('/');
               var20.append(var2.getStepMessages().size());
               String var21 = var20.toString();
               var4 = var2.getStepBtn();
               if (var3 > 0) {
                  var6 = true;
               }

               var1.setPage(var21, var0, var4, var6);
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$6(StepGuideDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private final void setPage(String var1, int var2, int var3, boolean var4) {
      DialogfragmentStepGuideBinding var6 = this.binding;
      DialogfragmentStepGuideBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.txtStepTitle.setText((CharSequence)var1);
      var5.txtStepDescription.setText((CharSequence)HtmlCompat.fromHtml(this.getString(var2), 0));
      var5.btnNext.setText(var3);
      ImageButton var7 = var5.btnBack;
      Intrinsics.checkNotNullExpressionValue(var7, "btnBack");
      ViewExtensionsKt.show((View)var7, var4);
   }

   private static final StepGuides stepGuides_delegate$lambda$0(StepGuideDialogFragment var0) {
      return (StepGuides)var0.requireArguments().getParcelable("ARG_STEP_GUIDES");
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentStepGuideBinding var6 = DialogfragmentStepGuideBinding.inflate(var1);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      DialogfragmentStepGuideBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      View var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
   }

   public void onDismiss(DialogInterface var1) {
      Fragment var3;
      label11: {
         Intrinsics.checkNotNullParameter(var1, "dialog");
         super.onDismiss(var1);
         var3 = (Fragment)this;
         StepGuides var4 = this.getStepGuides();
         if (var4 != null) {
            String var2 = var4.getRequestKey();
            var5 = var2;
            if (var2 != null) {
               break label11;
            }
         }

         var5 = "StepGuideDialogFragment";
      }

      FragmentKt.setFragmentResult(var3, var5, BundleKt.bundleOf(new Pair[]{TuplesKt.to("DATA_COMPLETED", this.isCompleteBtnClicked)}));
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
            var2.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      StepGuides var5 = this.getStepGuides();
      Object var10 = null;
      if (var5 != null) {
         byte var3;
         if (var5.getHeadTitle() == null) {
            var3 = -1;
         } else {
            var3 = 0;
         }

         DialogfragmentStepGuideBinding var4 = this.binding;
         DialogfragmentStepGuideBinding var6 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.txtStepDescription.setMinLines(var5.getMinLines());
         var4 = this.binding;
         var6 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.btnBack.setOnClickListener(new StepGuideDialogFragment$$ExternalSyntheticLambda1(this));
         var4 = this.binding;
         var6 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var6 = null;
         }

         var6.btnNext.setOnClickListener(new StepGuideDialogFragment$$ExternalSyntheticLambda2(this, var5));
         this.currentStep.observe(this.getViewLifecycleOwner(), new Observer(new StepGuideDialogFragment$$ExternalSyntheticLambda3(var3, this, var5)) {
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

      DialogfragmentStepGuideBinding var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = (DialogfragmentStepGuideBinding)var10;
      }

      var9.btnClose.setOnClickListener(new StepGuideDialogFragment$$ExternalSyntheticLambda4(this));
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/viewcore/dialog/StepGuideDialogFragment$Companion;", "", "<init>", "()V", "DEFAULT_REQUEST_KEY", "", "DATA_COMPLETED", "ARG_STEP_GUIDES", "newInstance", "Lcom/blueair/viewcore/dialog/StepGuideDialogFragment;", "stepGuides", "Lcom/blueair/viewcore/dialog/StepGuides;", "viewcore_otherRelease"},
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

      public final StepGuideDialogFragment newInstance(StepGuides var1) {
         Intrinsics.checkNotNullParameter(var1, "stepGuides");
         StepGuideDialogFragment var2 = new StepGuideDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_STEP_GUIDES", var1)}));
         return var2;
      }
   }
}
