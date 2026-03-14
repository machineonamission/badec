package com.blueair.viewcore.extensions;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001aE\u0010\t\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001aJ\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000526\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"},
   d2 = {"findByTag", "DF", "Landroidx/fragment/app/DialogFragment;", "Landroidx/fragment/app/FragmentManager;", "tag", "", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "hasTag", "", "show", "commitNow", "factory", "Lkotlin/Function0;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)Landroidx/fragment/app/DialogFragment;", "setFragmentResultListenerWithClear", "", "Landroidx/fragment/app/Fragment;", "requestKey", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/os/Bundle;", "bundle", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class FragmentExtensionsKt {
   // $FF: synthetic method
   public static void $r8$lambda$HJ5llWnpuVXPOF3a5t5GIzXCs7E(Function2 var0, String var1, Bundle var2) {
      setFragmentResultListenerWithClear$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static final DialogFragment findByTag(FragmentManager var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "tag");
      Fragment var2 = var0.findFragmentByTag(var1);
      Intrinsics.reifiedOperationMarker(2, "DF");
      return (DialogFragment)var2;
   }

   // $FF: synthetic method
   public static DialogFragment findByTag$default(FragmentManager var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         Intrinsics.reifiedOperationMarker(4, "DF");
         Class var5 = DialogFragment.class;
         var1 = DialogFragment.class.getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var1, "getSimpleName(...)");
         String var6 = var1;
      }

      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "tag");
      Fragment var4 = var0.findFragmentByTag(var1);
      Intrinsics.reifiedOperationMarker(2, "DF");
      return (DialogFragment)var4;
   }

   // $FF: synthetic method
   public static final boolean hasTag(FragmentManager var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "tag");
      Fragment var2 = var0.findFragmentByTag(var1);
      Intrinsics.reifiedOperationMarker(3, "DF");
      return var2 instanceof DialogFragment;
   }

   // $FF: synthetic method
   public static boolean hasTag$default(FragmentManager var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         Intrinsics.reifiedOperationMarker(4, "DF");
         Class var5 = DialogFragment.class;
         var1 = DialogFragment.class.getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var1, "getSimpleName(...)");
         String var6 = var1;
      }

      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "tag");
      Fragment var4 = var0.findFragmentByTag(var1);
      Intrinsics.reifiedOperationMarker(3, "DF");
      return var4 instanceof DialogFragment;
   }

   public static final void setFragmentResultListenerWithClear(Fragment var0, String var1, Function2 var2) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "requestKey");
      Intrinsics.checkNotNullParameter(var2, "listener");
      var0.getParentFragmentManager().clearFragmentResult(var1);
      var0.getParentFragmentManager().setFragmentResultListener(var1, (LifecycleOwner)var0, new FragmentExtensionsKt$$ExternalSyntheticLambda0(var2));
   }

   private static final void setFragmentResultListenerWithClear$lambda$0(Function2 var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      Intrinsics.checkNotNullParameter(var2, "p1");
      var0.invoke(var1, var2);
   }

   // $FF: synthetic method
   public static final DialogFragment show(FragmentManager var0, String var1, boolean var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "tag");
      Intrinsics.checkNotNullParameter(var3, "factory");
      Fragment var4 = var0.findFragmentByTag(var1);
      Intrinsics.reifiedOperationMarker(3, "DF");
      if (!(var4 instanceof DialogFragment) && !var0.isStateSaved()) {
         DialogFragment var5 = (DialogFragment)var3.invoke();
         var5.show(var0, var1);
         if (var2) {
            var0.executePendingTransactions();
         }

         return var5;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   public static DialogFragment show$default(FragmentManager var0, String var1, boolean var2, Function0 var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         Intrinsics.reifiedOperationMarker(4, "DF");
         Class var6 = DialogFragment.class;
         var1 = DialogFragment.class.getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var1, "getSimpleName(...)");
         String var8 = var1;
      }

      if ((var4 & 2) != 0) {
         var2 = false;
      }

      Intrinsics.checkNotNullParameter(var0, "<this>");
      Intrinsics.checkNotNullParameter(var1, "tag");
      Intrinsics.checkNotNullParameter(var3, "factory");
      Fragment var9 = var0.findFragmentByTag(var1);
      Intrinsics.reifiedOperationMarker(3, "DF");
      if (!(var9 instanceof DialogFragment) && !var0.isStateSaved()) {
         DialogFragment var7 = (DialogFragment)var3.invoke();
         var7.show(var0, var1);
         if (var2) {
            var0.executePendingTransactions();
         }

         return var7;
      } else {
         return null;
      }
   }
}
