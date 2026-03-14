package com.blueair.viewcore.fragment;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.viewcore.view.ProgressBlockerView;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J-\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015À\u0006\u0003"},
   d2 = {"Lcom/blueair/viewcore/fragment/ProgressFragment;", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "showProgress", "", "context", "Landroid/content/Context;", "shouldShow", "", "forcedColor", "", "(Landroid/content/Context;ZLjava/lang/Integer;)V", "hideProgress", "clearProgressFragment", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface ProgressFragment {
   void clearProgressFragment();

   ProgressBlockerView getProgressBlockerView();

   ConstraintLayout getRootView();

   void hideProgress(Context var1);

   void setProgressBlockerView(ProgressBlockerView var1);

   void showProgress(Context var1, boolean var2, Integer var3) throws NullPointerException;

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static void clearProgressFragment(ProgressFragment var0) {
         ProgressFragment$_CC.access$clearProgressFragment$jd(var0);
      }

      @Deprecated
      public static void hideProgress(ProgressFragment var0, Context var1) {
         ProgressFragment$_CC.access$hideProgress$jd(var0, var1);
      }

      @Deprecated
      public static void showProgress(ProgressFragment var0, Context var1, boolean var2, Integer var3) throws NullPointerException {
         ProgressFragment$_CC.access$showProgress$jd(var0, var1, var2, var3);
      }

      // $FF: synthetic method
      public static void showProgress$default(ProgressFragment var0, Context var1, boolean var2, Integer var3, int var4, Object var5) throws NullPointerException {
         ProgressFragment$_CC.showProgress$default(var0, var1, var2, var3, var4, var5);
      }
   }
}
