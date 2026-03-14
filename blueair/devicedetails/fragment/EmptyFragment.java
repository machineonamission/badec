package com.blueair.devicedetails.fragment;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"},
   d2 = {"Lcom/blueair/devicedetails/fragment/EmptyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onAttached", "Lkotlin/Function1;", "", "onAttach", "context", "Landroid/content/Context;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class EmptyFragment extends Fragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String TAG = "EmptyFragment";
   private Function1 onAttached;

   public void onAttach(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super.onAttach(var1);
      Function1 var2 = this.onAttached;
      if (var2 != null) {
         var2.invoke(this);
      }

   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/fragment/EmptyFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/blueair/devicedetails/fragment/EmptyFragment;", "onAttached", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "buildIn", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "devicedetails_otherRelease"},
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

      private final EmptyFragment newInstance(Function1 var1) {
         EmptyFragment var2 = new EmptyFragment();
         var2.onAttached = var1;
         return var2;
      }

      public final EmptyFragment buildIn(FragmentManager var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "fragmentManager");
         Intrinsics.checkNotNullParameter(var2, "onAttached");
         Fragment var3 = var1.findFragmentByTag("EmptyFragment");
         if (var3 == null) {
            EmptyFragment var4 = this.newInstance(var2);
            var1.beginTransaction().add(var4, "EmptyFragment").commitAllowingStateLoss();
            var1.executePendingTransactions();
            return var4;
         } else {
            return (EmptyFragment)var3;
         }
      }
   }
}
