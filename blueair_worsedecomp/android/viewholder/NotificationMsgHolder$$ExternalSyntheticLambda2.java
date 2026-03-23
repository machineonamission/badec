package com.blueair.android.viewholder;

import android.view.View;
import com.blueair.android.adapter.NotificationItem;
import io.reactivex.subjects.PublishSubject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationMsgHolder$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ PublishSubject f$0;
    public final /* synthetic */ NotificationItem f$1;

    public /* synthetic */ NotificationMsgHolder$$ExternalSyntheticLambda2(PublishSubject publishSubject, NotificationItem notificationItem) {
        this.f$0 = publishSubject;
        this.f$1 = notificationItem;
    }

    public final void onClick(View view) {
        NotificationMsgHolder.hydrateAqi$lambda$4$lambda$3(this.f$0, this.f$1, view);
    }
}
