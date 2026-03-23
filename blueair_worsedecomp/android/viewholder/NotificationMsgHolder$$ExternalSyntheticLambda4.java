package com.blueair.android.viewholder;

import android.view.View;
import com.blueair.android.adapter.NotificationItem;
import io.reactivex.subjects.PublishSubject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationMsgHolder$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ PublishSubject f$0;
    public final /* synthetic */ NotificationItem f$1;

    public /* synthetic */ NotificationMsgHolder$$ExternalSyntheticLambda4(PublishSubject publishSubject, NotificationItem notificationItem) {
        this.f$0 = publishSubject;
        this.f$1 = notificationItem;
    }

    public final void onClick(View view) {
        NotificationMsgHolder.hydrate$lambda$2$lambda$1(this.f$0, this.f$1, view);
    }
}
