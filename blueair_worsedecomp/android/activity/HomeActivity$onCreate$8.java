package com.blueair.android.activity;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.blueair.core.model.AnalyticEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"com/blueair/android/activity/HomeActivity$onCreate$8", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "opened", "", "getOpened", "()Z", "setOpened", "(Z)V", "onDrawerSlide", "", "drawerView", "Landroid/view/View;", "slideOffset", "", "onDrawerOpened", "onDrawerClosed", "onDrawerStateChanged", "newState", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HomeActivity.kt */
public final class HomeActivity$onCreate$8 implements DrawerLayout.DrawerListener {
    private boolean opened;
    final /* synthetic */ HomeActivity this$0;

    public void onDrawerSlide(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "drawerView");
    }

    HomeActivity$onCreate$8(HomeActivity homeActivity) {
        this.this$0 = homeActivity;
    }

    public final boolean getOpened() {
        return this.opened;
    }

    public final void setOpened(boolean z) {
        this.opened = z;
    }

    public void onDrawerOpened(View view) {
        Intrinsics.checkNotNullParameter(view, "drawerView");
        this.opened = true;
        this.this$0.getAnalytics().event(new AnalyticEvent.ScreenViewEvent(AnalyticEvent.ScreenViewEvent.SIDE_MENU, "DrawerLayout"));
    }

    public void onDrawerClosed(View view) {
        Intrinsics.checkNotNullParameter(view, "drawerView");
        this.opened = false;
    }

    public void onDrawerStateChanged(int i) {
        if (i == 2) {
            this.this$0.setStatusMode(this.opened);
        }
    }
}
