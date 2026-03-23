package com.blueair.android.activity;

import android.view.View;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.adapter.NotificationMsgAdapter;
import com.blueair.android.viewmodel.NotificationsViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"com/blueair/android/activity/HomeActivity$prepareCardStack$layoutManager$1", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "onCardDragging", "", "direction", "Lcom/yuyakaido/android/cardstackview/Direction;", "ratio", "", "onCardSwiped", "onCardRewound", "onCardCanceled", "onCardAppeared", "view", "Landroid/view/View;", "position", "", "onCardDisappeared", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HomeActivity.kt */
public final class HomeActivity$prepareCardStack$layoutManager$1 implements CardStackListener {
    final /* synthetic */ HomeActivity this$0;

    public void onCardCanceled() {
    }

    public void onCardDisappeared(View view, int i) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
    }

    public void onCardDragging(Direction direction, float f) {
        Intrinsics.checkNotNullParameter(direction, "direction");
    }

    public void onCardRewound() {
    }

    HomeActivity$prepareCardStack$layoutManager$1(HomeActivity homeActivity) {
        this.this$0 = homeActivity;
    }

    public void onCardSwiped(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        NotificationMsgAdapter access$getCardAdapter$p = this.this$0.cardAdapter;
        if (access$getCardAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
            access$getCardAdapter$p = null;
        }
        NotificationItem item = access$getCardAdapter$p.getItem(0);
        if (item != null) {
            HomeActivity homeActivity = this.this$0;
            NotificationMsgAdapter access$getCardAdapter$p2 = homeActivity.cardAdapter;
            if (access$getCardAdapter$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                access$getCardAdapter$p2 = null;
            }
            access$getCardAdapter$p2.removeAt(0);
            NotificationsViewModel.dismissMsg$default(homeActivity.getNotificationsViewModel(), item, false, 2, (Object) null);
        }
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCardAppeared(android.view.View r2, int r3) {
        /*
            r1 = this;
            java.lang.String r3 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            com.blueair.android.activity.HomeActivity r2 = r1.this$0
            com.blueair.android.databinding.ActivityHomeBinding r2 = r2.homeDataBinding
            r3 = 0
            if (r2 != 0) goto L_0x0014
            java.lang.String r2 = "homeDataBinding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r2 = r3
        L_0x0014:
            com.yuyakaido.android.cardstackview.CardStackView r2 = r2.csNotification
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            boolean r0 = r2 instanceof com.blueair.viewcore.utils.CustomStackLayoutManager
            if (r0 == 0) goto L_0x0021
            r3 = r2
            com.blueair.viewcore.utils.CustomStackLayoutManager r3 = (com.blueair.viewcore.utils.CustomStackLayoutManager) r3
        L_0x0021:
            if (r3 == 0) goto L_0x0026
            r3.setSizeFromTopView()
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.HomeActivity$prepareCardStack$layoutManager$1.onCardAppeared(android.view.View, int):void");
    }
}
