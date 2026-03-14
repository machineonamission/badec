package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010E\u001a\u0004\u0018\u0001HF\"\u0004\b\u0000\u0010F2\u0006\u0010G\u001a\u00020)H\u0002¢\u0006\u0002\u0010HJ\u0012\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020OH\u0002R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u008b\u0001\u0010\u000b\u001as\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b#\u0010 R\u001b\u0010%\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b&\u0010\u001bR\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b.\u0010 R\u001d\u00100\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001d\u001a\u0004\b1\u0010 R\u001b\u00103\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u001d\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001d\u001a\u0004\b8\u00105R\u001b\u0010:\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001d\u001a\u0004\b;\u00105R\u001b\u0010=\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001d\u001a\u0004\b>\u00105R#\u0010@\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u001d\u001a\u0004\bB\u0010C¨\u0006Q"},
   d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "resultListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "viewBinder", "Lkotlin/Function5;", "Landroid/widget/TextView;", "title", "subTitle", "body", "Lcom/google/android/material/button/MaterialButton;", "positiveBtn", "negativeBtn", "getViewBinder", "()Lkotlin/jvm/functions/Function5;", "setViewBinder", "(Lkotlin/jvm/functions/Function5;)V", "argTitleTextResId", "", "getArgTitleTextResId", "()I", "argTitleTextResId$delegate", "Lkotlin/Lazy;", "argTitleIconResId", "getArgTitleIconResId", "()Ljava/lang/Integer;", "argTitleIconResId$delegate", "argSubTitleTextResId", "getArgSubTitleTextResId", "argSubTitleTextResId$delegate", "argBodyTextResId", "getArgBodyTextResId", "argBodyTextResId$delegate", "argTitleText", "", "getArgTitleText", "()Ljava/lang/String;", "argTitleText$delegate", "argPositiveTextResId", "getArgPositiveTextResId", "argPositiveTextResId$delegate", "argNegativeTextResId", "getArgNegativeTextResId", "argNegativeTextResId$delegate", "primaryButtonDestructive", "getPrimaryButtonDestructive", "()Z", "primaryButtonDestructive$delegate", "primaryButtonAsSecondary", "getPrimaryButtonAsSecondary", "primaryButtonAsSecondary$delegate", "buttonsVertical", "getButtonsVertical", "buttonsVertical$delegate", "centeredAndMultiLinedTitle", "getCenteredAndMultiLinedTitle", "centeredAndMultiLinedTitle$delegate", "bodyTextArgs", "", "getBodyTextArgs", "()[Ljava/lang/String;", "bodyTextArgs$delegate", "getArgument", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "bind", "view", "Landroid/view/View;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConfirmationDialogLeftAligned extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String KEY_BODY_TEXT_ARGS = "bodyTextArgs";
   private static final String KEY_BODY_TEXT_RES_ID = "bodyTextResId";
   private static final String KEY_BUTTONS_VERTICAL = "buttonsVertical";
   private static final String KEY_CENTERED_AND_MULTILINED_TITLE = "centeredAndMultiLinedTitle";
   private static final String KEY_NEGATIVE_TEXT_RES_ID = "negativeTextResId";
   private static final String KEY_POSITIVE_TEXT_RES_ID = "positiveTextResId";
   private static final String KEY_PRIMARY_BUTTON_AS_SECONDARY = "primaryButtonAsSecondary";
   private static final String KEY_PRIMARY_BUTTON_DESTRUCTIVE = "primaryButtonDestructive";
   private static final String KEY_SUB_TITLE_TEXT_RES_ID = "subTitleTextResId";
   private static final String KEY_TITLE_ICON_RES_ID = "titleIconResId";
   private static final String KEY_TITLE_TEXT = "titleText";
   private static final String KEY_TITLE_TEXT_RES_ID = "titleTextResId";
   private final Lazy argBodyTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda13(this));
   private final Lazy argNegativeTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda2(this));
   private final Lazy argPositiveTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda1(this));
   private final Lazy argSubTitleTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda12(this));
   private final Lazy argTitleIconResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda11(this));
   private final Lazy argTitleText$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda14(this));
   private final Lazy argTitleTextResId$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda8(this));
   private final Lazy bodyTextArgs$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda10(this));
   private final Lazy buttonsVertical$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda5(this));
   private final Lazy centeredAndMultiLinedTitle$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda9(this));
   private final Lazy primaryButtonAsSecondary$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda4(this));
   private final Lazy primaryButtonDestructive$delegate = LazyKt.lazy(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda3(this));
   private Function1 resultListener;
   private Function5 viewBinder;

   // $FF: synthetic method
   public static void $r8$lambda$2P3WLnoBZMeeZVQj3T_Lcc2vW7o/* $FF was: $r8$lambda$2P3WLnoBZMeeZVQj3T-Lcc2vW7o*/(ConfirmationDialogLeftAligned var0, View var1) {
      bind$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static int $r8$lambda$3VlAIp9aR0fPvxjBswYfypo_IgI(ConfirmationDialogLeftAligned var0) {
      return argTitleIconResId_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$DLIsdWbREO4mt5TeprxfmviKfbQ(ConfirmationDialogLeftAligned var0) {
      return buttonsVertical_delegate$lambda$9(var0);
   }

   // $FF: synthetic method
   public static String $r8$lambda$EgzgmnJA0uJE5on_JBmqT2QTcsQ(ConfirmationDialogLeftAligned var0) {
      return argTitleText_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Integer $r8$lambda$FRrYw3zraHPbCwXFCAEPFQCfw_Q(ConfirmationDialogLeftAligned var0) {
      return argPositiveTextResId_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static int $r8$lambda$Mjmtc9CWTL_edfzy9Y7Y_KOBLcg/* $FF was: $r8$lambda$Mjmtc9CWTL-edfzy9Y7Y-KOBLcg*/(ConfirmationDialogLeftAligned var0) {
      return argTitleTextResId_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$QVu6YxbO8MD1xT15M2KPiXQ_ATI/* $FF was: $r8$lambda$QVu6YxbO8MD1xT15M2KPiXQ-ATI*/(ConfirmationDialogLeftAligned var0, View var1) {
      bind$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static Integer $r8$lambda$W71wVOooJXY9ZqlRs4L_s9mnFgM(ConfirmationDialogLeftAligned var0) {
      return argNegativeTextResId_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static int $r8$lambda$Xv7T4tct8aa8F1jhd4fWKuHB5vA(ConfirmationDialogLeftAligned var0) {
      return argBodyTextResId_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static String[] $r8$lambda$izDPpvt94qwCH45UpiqvQjiJHsY(ConfirmationDialogLeftAligned var0) {
      return bodyTextArgs_delegate$lambda$11(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$kOUcuKhahMskOZRn_dCFRmRS4gs/* $FF was: $r8$lambda$kOUcuKhahMskOZRn-dCFRmRS4gs*/(ConfirmationDialogLeftAligned var0) {
      return centeredAndMultiLinedTitle_delegate$lambda$10(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$lgPTEI0Xt0Ra3tEq4ktkdK74C_Y(ConfirmationDialogLeftAligned var0) {
      return primaryButtonAsSecondary_delegate$lambda$8(var0);
   }

   // $FF: synthetic method
   public static Integer $r8$lambda$o9UpTBuivqlcOcXpGPZtokJ99Nk(ConfirmationDialogLeftAligned var0) {
      return argSubTitleTextResId_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$u7lgofd9nakXeT53FHUO4kmW1BQ(ConfirmationDialogLeftAligned var0, View var1) {
      bind$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$yjGtjiFaZFyzFFDczSYijbDZxh0(ConfirmationDialogLeftAligned var0) {
      return primaryButtonDestructive_delegate$lambda$7(var0);
   }

   private static final int argBodyTextResId_delegate$lambda$3(ConfirmationDialogLeftAligned var0) {
      return var0.requireArguments().getInt("bodyTextResId");
   }

   private static final Integer argNegativeTextResId_delegate$lambda$6(ConfirmationDialogLeftAligned var0) {
      return (Integer)var0.getArgument("negativeTextResId");
   }

   private static final Integer argPositiveTextResId_delegate$lambda$5(ConfirmationDialogLeftAligned var0) {
      return (Integer)var0.getArgument("positiveTextResId");
   }

   private static final Integer argSubTitleTextResId_delegate$lambda$2(ConfirmationDialogLeftAligned var0) {
      return (Integer)var0.getArgument("subTitleTextResId");
   }

   private static final int argTitleIconResId_delegate$lambda$1(ConfirmationDialogLeftAligned var0) {
      return var0.requireArguments().getInt("titleIconResId");
   }

   private static final int argTitleTextResId_delegate$lambda$0(ConfirmationDialogLeftAligned var0) {
      return var0.requireArguments().getInt("titleTextResId");
   }

   private static final String argTitleText_delegate$lambda$4(ConfirmationDialogLeftAligned var0) {
      return var0.requireArguments().getString("titleText");
   }

   private final void bind(View var1) {
      Context var8 = var1.getContext();
      TextView var7 = (TextView)var1.findViewById(R.id.title);
      String var5 = this.getArgTitleText();
      if (var5 == null) {
         var5 = var8.getString(this.getArgTitleTextResId());
         Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
      }

      var7.setText((CharSequence)var5);
      Integer var19 = this.getArgTitleIconResId();
      boolean var4 = false;
      if (var19 != null) {
         var7.setCompoundDrawablesRelativeWithIntrinsicBounds(((Number)var19).intValue(), 0, 0, 0);
      }

      TextView var9 = (TextView)var1.findViewById(R.id.subtitle);
      Integer var6 = this.getArgSubTitleTextResId();
      String var20 = "";
      if (var6 != null) {
         var9.setText((CharSequence)var8.getString(var6));
         var9.setVisibility(0);
      } else {
         var9.setText((CharSequence)"");
         var9.setVisibility(4);
      }

      if (this.getCenteredAndMultiLinedTitle()) {
         var7.setGravity(17);
         Intrinsics.checkNotNull(var7);
         View var27 = (View)var7;
         ViewGroup.LayoutParams var10 = var27.getLayoutParams();
         if (var10 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
         }

         ViewGroup.LayoutParams var11 = (ViewGroup.LayoutParams)((ConstraintLayout.LayoutParams)var10);
         ConstraintLayout.LayoutParams var32 = (ConstraintLayout.LayoutParams)var11;
         var32.width = 0;
         var32.endToStart = R.id.end_guideline;
         var27.setLayoutParams(var11);
         Intrinsics.checkNotNull(var9);
         ViewExtensionsKt.show((View)var9, false);
      }

      if (this.getArgBodyTextResId() != 0) {
         var20 = var8.getString(this.getArgBodyTextResId());
      }

      Intrinsics.checkNotNull(var20);
      String[] var33 = this.getBodyTextArgs();
      String var28 = var20;
      if (var33 != null) {
         boolean var2;
         if (var33.length == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         var28 = var20;
         if (!var2) {
            Object[] var29 = Arrays.copyOf(var33, var33.length);
            var28 = String.format(var20, Arrays.copyOf(var29, var29.length));
            Intrinsics.checkNotNullExpressionValue(var28, "format(...)");
         }
      }

      TextView var34 = (TextView)var1.findViewById(R.id.body);
      CharSequence var21 = (CharSequence)var28;
      var34.setText(var21);
      Intrinsics.checkNotNull(var34);
      View var30 = (View)var34;
      boolean var3;
      if (var21.length() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      ViewExtensionsKt.show(var30, var3);
      MaterialButton var35 = (MaterialButton)var1.findViewById(R.id.confirm_button);
      Intrinsics.checkNotNull(var35);
      View var22 = (View)var35;
      if (this.getArgPositiveTextResId() != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      ViewExtensionsKt.show(var22, var3);
      Integer var23 = this.getArgPositiveTextResId();
      Object var31 = null;
      if (var23 != null) {
         int var16 = ((Number)var23).intValue();
         String var24;
         if (var8 != null) {
            var24 = var8.getString(var16);
         } else {
            var24 = null;
         }

         var35.setText((CharSequence)var24);
      }

      if (this.getPrimaryButtonDestructive()) {
         var35.setBackgroundTintList(ContextCompat.getColorStateList(var8, R.color.button_primary_destructive));
      }

      var35.setOnClickListener(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda0(this));
      View var25 = var1.findViewById(R.id.iv_close);
      if (var25 != null) {
         var25.setOnClickListener(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda6(this));
      }

      MaterialButton var26 = (MaterialButton)var1.findViewById(R.id.dismiss_button);
      Integer var12 = this.getArgNegativeTextResId();
      Intrinsics.checkNotNull(var26);
      var1 = (View)var26;
      var3 = var4;
      if (var12 != null) {
         var3 = true;
      }

      ViewExtensionsKt.show(var1, var3);
      if (var12 != null) {
         String var14 = (String)var31;
         if (var8 != null) {
            var14 = var8.getString(var12);
         }

         var26.setText((CharSequence)var14);
         var26.setOnClickListener(new ConfirmationDialogLeftAligned$$ExternalSyntheticLambda7(this));
      }

      Function5 var15 = this.viewBinder;
      if (var15 != null) {
         Intrinsics.checkNotNull(var7);
         Intrinsics.checkNotNull(var9);
         var15.invoke(var7, var9, var34, var35, var26);
      }

   }

   private static final void bind$lambda$20(ConfirmationDialogLeftAligned var0, View var1) {
      var0.dismissAllowingStateLoss();
      Function1 var2 = var0.resultListener;
      if (var2 != null) {
         var2.invoke(true);
      }

   }

   private static final void bind$lambda$21(ConfirmationDialogLeftAligned var0, View var1) {
      var0.dismiss();
   }

   private static final void bind$lambda$22(ConfirmationDialogLeftAligned var0, View var1) {
      var0.dismissAllowingStateLoss();
      Function1 var2 = var0.resultListener;
      if (var2 != null) {
         var2.invoke(false);
      }

   }

   private static final String[] bodyTextArgs_delegate$lambda$11(ConfirmationDialogLeftAligned var0) {
      return (String[])var0.getArgument("bodyTextArgs");
   }

   private static final boolean buttonsVertical_delegate$lambda$9(ConfirmationDialogLeftAligned var0) {
      Boolean var1 = (Boolean)var0.getArgument("buttonsVertical");
      return var1 != null ? var1 : true;
   }

   private static final boolean centeredAndMultiLinedTitle_delegate$lambda$10(ConfirmationDialogLeftAligned var0) {
      Boolean var1 = (Boolean)var0.getArgument("centeredAndMultiLinedTitle");
      return var1 != null ? var1 : true;
   }

   private final int getArgBodyTextResId() {
      return ((Number)this.argBodyTextResId$delegate.getValue()).intValue();
   }

   private final Integer getArgNegativeTextResId() {
      return (Integer)this.argNegativeTextResId$delegate.getValue();
   }

   private final Integer getArgPositiveTextResId() {
      return (Integer)this.argPositiveTextResId$delegate.getValue();
   }

   private final Integer getArgSubTitleTextResId() {
      return (Integer)this.argSubTitleTextResId$delegate.getValue();
   }

   private final Integer getArgTitleIconResId() {
      return (Integer)this.argTitleIconResId$delegate.getValue();
   }

   private final String getArgTitleText() {
      return (String)this.argTitleText$delegate.getValue();
   }

   private final int getArgTitleTextResId() {
      return ((Number)this.argTitleTextResId$delegate.getValue()).intValue();
   }

   private final Object getArgument(String var1) {
      Bundle var2 = this.getArguments();
      if (var2 != null && var2.containsKey(var1)) {
         Object var3 = var2.get(var1);
         return var3 == null ? null : var3;
      } else {
         return null;
      }
   }

   private final String[] getBodyTextArgs() {
      return (String[])this.bodyTextArgs$delegate.getValue();
   }

   private final boolean getButtonsVertical() {
      return (Boolean)this.buttonsVertical$delegate.getValue();
   }

   private final boolean getCenteredAndMultiLinedTitle() {
      return (Boolean)this.centeredAndMultiLinedTitle$delegate.getValue();
   }

   private final boolean getPrimaryButtonAsSecondary() {
      return (Boolean)this.primaryButtonAsSecondary$delegate.getValue();
   }

   private final boolean getPrimaryButtonDestructive() {
      return (Boolean)this.primaryButtonDestructive$delegate.getValue();
   }

   private static final boolean primaryButtonAsSecondary_delegate$lambda$8(ConfirmationDialogLeftAligned var0) {
      Boolean var1 = (Boolean)var0.getArgument("primaryButtonAsSecondary");
      return var1 != null ? var1 : false;
   }

   private static final boolean primaryButtonDestructive_delegate$lambda$7(ConfirmationDialogLeftAligned var0) {
      Boolean var1 = (Boolean)var0.getArgument("primaryButtonDestructive");
      return var1 != null ? var1 : false;
   }

   public final Function5 getViewBinder() {
      return this.viewBinder;
   }

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var5 = this.getActivity();
      View var3 = null;
      LayoutInflater var6;
      if (var5 != null) {
         var6 = var5.getLayoutInflater();
      } else {
         var6 = null;
      }

      int var2;
      if (this.getButtonsVertical()) {
         var2 = R.layout.confirmation_dialog_left_aligned_vertical;
      } else if (this.getPrimaryButtonAsSecondary()) {
         var2 = R.layout.confirmation_dialog_left_aligned_horizontal_secondary;
      } else {
         var2 = R.layout.confirmation_dialog_left_aligned_horizontal;
      }

      if (var6 != null) {
         var3 = var6.inflate(var2, (ViewGroup)null);
      }

      Dialog var7 = new Dialog(this.requireContext());
      if (var3 != null) {
         var7.setContentView(var3);
         this.bind(var3);
      }

      FragmentActivity var4 = this.getActivity();
      if (var4 != null) {
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable(ContextCompat.getDrawable((Context)var4, R.drawable.rounded_rectangle_white));
         }
      }

      return var7;
   }

   public final void setViewBinder(Function5 var1) {
      this.viewBinder = var1;
   }

   @Metadata(
      d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J²\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142%\b\u0002\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010#¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"},
      d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned$Companion;", "", "<init>", "()V", "KEY_TITLE_TEXT_RES_ID", "", "KEY_TITLE_TEXT", "KEY_TITLE_ICON_RES_ID", "KEY_SUB_TITLE_TEXT_RES_ID", "KEY_BODY_TEXT_RES_ID", "KEY_POSITIVE_TEXT_RES_ID", "KEY_NEGATIVE_TEXT_RES_ID", "KEY_PRIMARY_BUTTON_AS_SECONDARY", "KEY_PRIMARY_BUTTON_DESTRUCTIVE", "KEY_BUTTONS_VERTICAL", "KEY_CENTERED_AND_MULTILINED_TITLE", "KEY_BODY_TEXT_ARGS", "newInstance", "Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned;", "titleTextResId", "", "subTitleResId", "bodyTextResId", "positiveTextResId", "negativeTextResId", "primaryButtonDestructive", "", "primaryButtonAsSecondary", "buttonsVertical", "centeredAndMultiLinedTitle", "bodyTextArgs", "", "preferTitleText", "titleIconResId", "resultListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "(ILjava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;ZZZZ[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Lcom/blueair/viewcore/dialog/ConfirmationDialogLeftAligned;", "viewcore_otherRelease"},
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
      public static ConfirmationDialogLeftAligned newInstance$default(Companion var0, int var1, Integer var2, int var3, Integer var4, Integer var5, boolean var6, boolean var7, boolean var8, boolean var9, String[] var10, String var11, Integer var12, Function1 var13, int var14, Object var15) {
         if ((var14 & 32) != 0) {
            var6 = false;
         }

         if ((var14 & 64) != 0) {
            var7 = false;
         }

         if ((var14 & 128) != 0) {
            var8 = true;
         }

         if ((var14 & 256) != 0) {
            var9 = false;
         }

         if ((var14 & 512) != 0) {
            var10 = null;
         }

         if ((var14 & 1024) != 0) {
            var11 = null;
         }

         if ((var14 & 2048) != 0) {
            var12 = null;
         }

         if ((var14 & 4096) != 0) {
            var13 = null;
         }

         return var0.newInstance(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
      }

      public final ConfirmationDialogLeftAligned newInstance(int var1, Integer var2, int var3, Integer var4, Integer var5, boolean var6, boolean var7, boolean var8, boolean var9, String[] var10, String var11, Integer var12, Function1 var13) {
         Bundle var14 = new Bundle();
         var14.putInt("titleTextResId", var1);
         if (var11 != null) {
            var14.putString("titleText", var11);
         }

         if (var12 != null) {
            var14.putInt("titleIconResId", ((Number)var12).intValue());
         }

         if (var2 != null) {
            var14.putInt("subTitleTextResId", ((Number)var2).intValue());
         }

         var14.putInt("bodyTextResId", var3);
         if (var4 != null) {
            var14.putInt("positiveTextResId", ((Number)var4).intValue());
         }

         if (var5 != null) {
            var14.putInt("negativeTextResId", ((Number)var5).intValue());
         }

         var14.putBoolean("primaryButtonDestructive", var6);
         var14.putBoolean("primaryButtonAsSecondary", var7);
         var14.putBoolean("buttonsVertical", var8);
         var14.putBoolean("centeredAndMultiLinedTitle", var9);
         if (var10 != null) {
            var14.putStringArray("bodyTextArgs", var10);
         }

         ConfirmationDialogLeftAligned var15 = new ConfirmationDialogLeftAligned();
         var15.setArguments(var14);
         var15.resultListener = var13;
         return var15;
      }
   }
}
