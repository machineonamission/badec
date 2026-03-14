package com.blueair.viewcore;

import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018À\u0006\u0003"},
   d2 = {"Lcom/blueair/viewcore/ViewCoreAppbar;", "", "headerTitle", "Landroid/widget/TextView;", "getHeaderTitle", "()Landroid/widget/TextView;", "headerMsg", "getHeaderMsg", "actionBar", "Landroidx/appcompat/app/ActionBar;", "getActionBar", "()Landroidx/appcompat/app/ActionBar;", "progressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "getProgressIndicator", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "onboardingSteps", "", "getOnboardingSteps", "()Ljava/util/List;", "setHeader", "", "header", "Lcom/blueair/viewcore/Header;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface ViewCoreAppbar {
   ActionBar getActionBar();

   TextView getHeaderMsg();

   TextView getHeaderTitle();

   List getOnboardingSteps();

   LinearProgressIndicator getProgressIndicator();

   void setHeader(Header var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static void setHeader(ViewCoreAppbar var0, Header var1) {
         Intrinsics.checkNotNullParameter(var1, "header");
         ViewCoreAppbar$_CC.access$setHeader$jd(var0, var1);
      }
   }
}
