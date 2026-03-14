package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010%\u001a\u0004\u0018\u0001H&\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u00020!H\u0002¢\u0006\u0002\u0010(J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0017R#\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b\"\u0010#¨\u00062"},
   d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "argTitleTextResId", "", "getArgTitleTextResId", "()Ljava/lang/Integer;", "argTitleTextResId$delegate", "Lkotlin/Lazy;", "argBodyTextResId", "getArgBodyTextResId", "argBodyTextResId$delegate", "argPositiveTextResId", "getArgPositiveTextResId", "()I", "argPositiveTextResId$delegate", "argNegativeTextResId", "getArgNegativeTextResId", "argNegativeTextResId$delegate", "primaryButtonDestructive", "", "getPrimaryButtonDestructive", "()Z", "primaryButtonDestructive$delegate", "buttonsHorizontal", "getButtonsHorizontal", "buttonsHorizontal$delegate", "bodyTextStart", "getBodyTextStart", "bodyTextStart$delegate", "bodyTextArgs", "", "", "getBodyTextArgs", "()[Ljava/lang/String;", "bodyTextArgs$delegate", "getArgument", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "bind", "", "view", "Landroid/view/View;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConfirmationDialogCentered extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String FILTER_TAG = "Device_Details_Filter_Dialog";
   private static final String KEY_BODY_TEXT_ARGS = "bodyTextArgs";
   private static final String KEY_BODY_TEXT_RES_ID = "bodyTextResId";
   private static final String KEY_BODY_TEXT_START = "bodyTextStart";
   private static final String KEY_BUTTONS_HORIZONTAL = "KEY_BUTTONS_HORIZONTAL";
   private static final String KEY_NEGATIVE_TEXT_RES_ID = "negativeTextResId";
   private static final String KEY_POSITIVE_TEXT_RES_ID = "positiveTextResId";
   private static final String KEY_PRIMARY_BUTTON_DESTRUCTIVE = "primaryButtonDestructive";
   private static final String KEY_TITLE_TEXT_RES_ID = "titleTextResId";
   private static final String OFFLINE_TAG = "Device_Details_Offline_Dialog";
   private final Lazy argBodyTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda1(this));
   private final Lazy argNegativeTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda3(this));
   private final Lazy argPositiveTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda2(this));
   private final Lazy argTitleTextResId$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda0(this));
   private final Lazy bodyTextArgs$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda7(this));
   private final Lazy bodyTextStart$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda6(this));
   private final Lazy buttonsHorizontal$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda5(this));
   private final Lazy primaryButtonDestructive$delegate = LazyKt.lazy(new ConfirmationDialogCentered$$ExternalSyntheticLambda4(this));

   // $FF: synthetic method
   public static void $r8$lambda$5XY_O41_U0OP2Hqj_dK6ZmkXZD0/* $FF was: $r8$lambda$5XY-O41-U0OP2Hqj-dK6ZmkXZD0*/(ConfirmationDialogCentered var0, View var1) {
      bind$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Integer $r8$lambda$6mlyZ_XP6jAtN59zEUcN0VwGlpU(ConfirmationDialogCentered var0) {
      return argBodyTextResId_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Integer $r8$lambda$HjTL3zSZvOvXWdm6MZ2Bgu0DjFk(ConfirmationDialogCentered var0) {
      return argNegativeTextResId_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static String[] $r8$lambda$M6gKyf7H_BdoGyKyhYFwjFbsxOE(ConfirmationDialogCentered var0) {
      return bodyTextArgs_delegate$lambda$7(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$Oh3DgIo9PwqnmtB7G7ecFeTICE0(ConfirmationDialogCentered var0) {
      return buttonsHorizontal_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$ZG6gOnHJSNOwMsssDlO_ZKZn2XA/* $FF was: $r8$lambda$ZG6gOnHJSNOwMsssDlO-ZKZn2XA*/(ConfirmationDialogCentered var0) {
      return primaryButtonDestructive_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$n75lpsR7ErJHWqbEOgPB3bQNblk(ConfirmationDialogCentered var0, View var1) {
      bind$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$pE5boXBy6zx_qmx06bMb3at8Hbo/* $FF was: $r8$lambda$pE5boXBy6zx-qmx06bMb3at8Hbo*/(ConfirmationDialogCentered var0) {
      return bodyTextStart_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static Integer $r8$lambda$rjHU_csZ_ViB1i2gTJOGSoakfDQ/* $FF was: $r8$lambda$rjHU-csZ_ViB1i2gTJOGSoakfDQ*/(ConfirmationDialogCentered var0) {
      return argTitleTextResId_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static int $r8$lambda$xpoOLf2tR9JeT90Z86n4B8ft49o(ConfirmationDialogCentered var0) {
      return argPositiveTextResId_delegate$lambda$2(var0);
   }

   private static final Integer argBodyTextResId_delegate$lambda$1(ConfirmationDialogCentered var0) {
      return (Integer)var0.getArgument("bodyTextResId");
   }

   private static final Integer argNegativeTextResId_delegate$lambda$3(ConfirmationDialogCentered var0) {
      return (Integer)var0.getArgument("negativeTextResId");
   }

   private static final int argPositiveTextResId_delegate$lambda$2(ConfirmationDialogCentered var0) {
      return var0.requireArguments().getInt("positiveTextResId");
   }

   private static final Integer argTitleTextResId_delegate$lambda$0(ConfirmationDialogCentered var0) {
      return (Integer)var0.getArgument("titleTextResId");
   }

   private final void bind(View var1) {
      Context var7 = var1.getContext();
      boolean var4 = this.getButtonsHorizontal();
      boolean var3 = false;
      if (var4) {
         LinearLayoutCompat var5 = (LinearLayoutCompat)var1.findViewById(R.id.buttons_container);
         var5.setOrientation(0);
         Intrinsics.checkNotNull(var5);
         List var6 = CollectionsKt.reversed((Iterable)SequencesKt.toList(ViewGroupKt.getChildren((ViewGroup)var5)));
         var5.removeAllViews();
         Iterator var15 = ((Iterable)var6).iterator();

         while(var15.hasNext()) {
            var5.addView((View)var15.next());
         }
      }

      TextView var10 = (TextView)var1.findViewById(R.id.title);
      Integer var8 = this.getArgTitleTextResId();
      String var16 = "";
      if (var8 != null && var8 != 0) {
         var10.setText((CharSequence)var7.getString(var8));
         var10.setVisibility(0);
      } else {
         var10.setText((CharSequence)"");
         var10.setVisibility(8);
      }

      var8 = this.getArgBodyTextResId();
      String var11 = var16;
      if (var8 != null) {
         var11 = var16;
         if (var8 != 0) {
            var11 = var7.getString(var8);
         }
      }

      Intrinsics.checkNotNull(var11);
      String[] var22 = this.getBodyTextArgs();
      var16 = var11;
      if (var22 != null) {
         boolean var2;
         if (var22.length == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         var16 = var11;
         if (!var2) {
            Object[] var18 = Arrays.copyOf(var22, var22.length);
            var16 = String.format(var11, Arrays.copyOf(var18, var18.length));
            Intrinsics.checkNotNullExpressionValue(var16, "format(...)");
         }
      }

      TextView var12 = (TextView)var1.findViewById(R.id.body);
      var12.setText((CharSequence)var16);
      if (this.getBodyTextStart()) {
         var12.setGravity(8388611);
      }

      MaterialButton var19 = (MaterialButton)var1.findViewById(R.id.confirm_button);
      String var13;
      if (var7 != null) {
         var13 = var7.getString(this.getArgPositiveTextResId());
      } else {
         var13 = null;
      }

      var19.setText((CharSequence)var13);
      if (this.getPrimaryButtonDestructive()) {
         var19.setBackgroundTintList(ContextCompat.getColorStateList(var7, R.color.button_primary_destructive));
      }

      if (var19 != null) {
         var19.setOnClickListener(new ConfirmationDialogCentered$$ExternalSyntheticLambda8(this));
      }

      MaterialButton var9 = (MaterialButton)var1.findViewById(R.id.dismiss_button);
      Integer var14 = this.getArgNegativeTextResId();
      Intrinsics.checkNotNull(var9);
      View var20 = (View)var9;
      if (var14 != null) {
         var3 = true;
      }

      ViewExtensionsKt.show(var20, var3);
      if (var14 != null) {
         var9.setText((CharSequence)this.requireContext().getString(var14));
         var9.setOnClickListener(new ConfirmationDialogCentered$$ExternalSyntheticLambda9(this));
      }

   }

   private static final void bind$lambda$14(ConfirmationDialogCentered var0, View var1) {
      FragmentKt.setFragmentResult((Fragment)var0, "CONFIRMATION", BundleKt.bundleOf(new Pair[]{TuplesKt.to("IS_CONFIRMED", true)}));
      var0.dismiss();
   }

   private static final void bind$lambda$15(ConfirmationDialogCentered var0, View var1) {
      FragmentKt.setFragmentResult((Fragment)var0, "CONFIRMATION", BundleKt.bundleOf(new Pair[]{TuplesKt.to("IS_CONFIRMED", false)}));
      var0.dismiss();
   }

   private static final String[] bodyTextArgs_delegate$lambda$7(ConfirmationDialogCentered var0) {
      return (String[])var0.getArgument("bodyTextArgs");
   }

   private static final boolean bodyTextStart_delegate$lambda$6(ConfirmationDialogCentered var0) {
      Boolean var1 = (Boolean)var0.getArgument("bodyTextStart");
      return var1 != null ? var1 : false;
   }

   private static final boolean buttonsHorizontal_delegate$lambda$5(ConfirmationDialogCentered var0) {
      Boolean var1 = (Boolean)var0.getArgument("KEY_BUTTONS_HORIZONTAL");
      return var1 != null ? var1 : false;
   }

   private final Integer getArgBodyTextResId() {
      return (Integer)this.argBodyTextResId$delegate.getValue();
   }

   private final Integer getArgNegativeTextResId() {
      return (Integer)this.argNegativeTextResId$delegate.getValue();
   }

   private final int getArgPositiveTextResId() {
      return ((Number)this.argPositiveTextResId$delegate.getValue()).intValue();
   }

   private final Integer getArgTitleTextResId() {
      return (Integer)this.argTitleTextResId$delegate.getValue();
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

   private final boolean getBodyTextStart() {
      return (Boolean)this.bodyTextStart$delegate.getValue();
   }

   private final boolean getButtonsHorizontal() {
      return (Boolean)this.buttonsHorizontal$delegate.getValue();
   }

   private final boolean getPrimaryButtonDestructive() {
      return (Boolean)this.primaryButtonDestructive$delegate.getValue();
   }

   private static final boolean primaryButtonDestructive_delegate$lambda$4(ConfirmationDialogCentered var0) {
      Boolean var1 = (Boolean)var0.getArgument("primaryButtonDestructive");
      return var1 != null ? var1 : false;
   }

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var4 = this.getActivity();
      View var2 = null;
      LayoutInflater var5;
      if (var4 != null) {
         var5 = var4.getLayoutInflater();
      } else {
         var5 = null;
      }

      if (var5 != null) {
         var2 = var5.inflate(R.layout.confirmation_dialog_centered, (ViewGroup)null);
      }

      Dialog var6 = new Dialog(this.requireContext());
      if (var2 != null) {
         var6.setContentView(var2);
         this.bind(var2);
      }

      FragmentActivity var3 = this.getActivity();
      if (var3 != null) {
         Window var7 = var6.getWindow();
         if (var7 != null) {
            var7.setBackgroundDrawable(ContextCompat.getDrawable((Context)var3, R.drawable.rounded_rectangle_white));
         }
      }

      return var6;
   }

   @Metadata(
      d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"},
      d2 = {"Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered$Companion;", "", "<init>", "()V", "FILTER_TAG", "", "OFFLINE_TAG", "KEY_TITLE_TEXT_RES_ID", "KEY_BODY_TEXT_RES_ID", "KEY_POSITIVE_TEXT_RES_ID", "KEY_NEGATIVE_TEXT_RES_ID", "KEY_PRIMARY_BUTTON_DESTRUCTIVE", "KEY_BUTTONS_HORIZONTAL", "KEY_BODY_TEXT_START", "KEY_BODY_TEXT_ARGS", "newInstance", "Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered;", "titleTextResId", "", "bodyTextResId", "positiveTextResId", "negativeTextResId", "primaryButtonDestructive", "", "buttonsHorizontal", "bodyTextStart", "bodyTextArgs", "", "(Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;ZZZ[Ljava/lang/String;)Lcom/blueair/viewcore/dialog/ConfirmationDialogCentered;", "showFilterDoorOpenDialog", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "dismissFilterDoorOpenDialog", "showOfflineDialog", "dismissOfflineDialog", "viewcore_otherRelease"},
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
      public static ConfirmationDialogCentered newInstance$default(Companion var0, Integer var1, Integer var2, int var3, Integer var4, boolean var5, boolean var6, boolean var7, String[] var8, int var9, Object var10) {
         if ((var9 & 1) != 0) {
            var1 = null;
         }

         if ((var9 & 2) != 0) {
            var2 = null;
         }

         if ((var9 & 16) != 0) {
            var5 = false;
         }

         if ((var9 & 32) != 0) {
            var6 = false;
         }

         if ((var9 & 64) != 0) {
            var7 = true;
         }

         if ((var9 & 128) != 0) {
            var8 = null;
         }

         return var0.newInstance(var1, var2, var3, var4, var5, var6, var7, var8);
      }

      public final void dismissFilterDoorOpenDialog(FragmentManager var1) {
         Intrinsics.checkNotNullParameter(var1, "fragmentManager");
         Fragment var2 = var1.findFragmentByTag("Device_Details_Filter_Dialog");
         DialogFragment var3;
         if (var2 instanceof DialogFragment) {
            var3 = (DialogFragment)var2;
         } else {
            var3 = null;
         }

         if (var3 != null) {
            var3.dismiss();
         }

      }

      public final void dismissOfflineDialog(FragmentManager var1) {
         Intrinsics.checkNotNullParameter(var1, "fragmentManager");
         Fragment var2 = var1.findFragmentByTag("Device_Details_Offline_Dialog");
         DialogFragment var3;
         if (var2 instanceof DialogFragment) {
            var3 = (DialogFragment)var2;
         } else {
            var3 = null;
         }

         if (var3 != null) {
            var3.dismiss();
         }

      }

      public final ConfirmationDialogCentered newInstance(Integer var1, Integer var2, int var3, Integer var4, boolean var5, boolean var6, boolean var7, String[] var8) {
         Bundle var9 = new Bundle();
         if (var1 != null) {
            var9.putInt("titleTextResId", ((Number)var1).intValue());
         }

         if (var2 != null) {
            var9.putInt("bodyTextResId", ((Number)var2).intValue());
         }

         var9.putInt("positiveTextResId", var3);
         if (var4 != null) {
            var9.putInt("negativeTextResId", ((Number)var4).intValue());
         }

         var9.putBoolean("primaryButtonDestructive", var5);
         var9.putBoolean("KEY_BUTTONS_HORIZONTAL", var6);
         var9.putBoolean("bodyTextStart", var7);
         if (var8 != null) {
            var9.putStringArray("bodyTextArgs", var8);
         }

         ConfirmationDialogCentered var10 = new ConfirmationDialogCentered();
         var10.setArguments(var9);
         return var10;
      }

      public final void showFilterDoorOpenDialog(FragmentManager var1) {
         Intrinsics.checkNotNullParameter(var1, "fragmentManager");
         if (!(var1.findFragmentByTag("Device_Details_Filter_Dialog") instanceof ConfirmationDialogCentered) && !var1.isStateSaved()) {
            ((DialogFragment)newInstance$default(ConfirmationDialogCentered.Companion, R.string.filter_door_open, R.string.filter_door_open_content, R.string.close, (Integer)null, false, false, false, (String[])null, 224, (Object)null)).show(var1, "Device_Details_Filter_Dialog");
         }

      }

      public final void showOfflineDialog(FragmentManager var1) {
         Intrinsics.checkNotNullParameter(var1, "fragmentManager");
         if (!(var1.findFragmentByTag("Device_Details_Offline_Dialog") instanceof ConfirmationDialogCentered) && !var1.isStateSaved()) {
            ((DialogFragment)newInstance$default(ConfirmationDialogCentered.Companion, (Integer)null, R.string.generic_offline_error, R.string.close, (Integer)null, false, false, false, (String[])null, 224, (Object)null)).show(var1, "Device_Details_Offline_Dialog");
         }

      }
   }
}
