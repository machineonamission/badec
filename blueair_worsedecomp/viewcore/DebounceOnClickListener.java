package com.blueair.viewcore;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/viewcore/DebounceOnClickListener;", "Landroid/view/View$OnClickListener;", "interval", "", "listenerBlock", "Lkotlin/Function1;", "Landroid/view/View;", "", "<init>", "(JLkotlin/jvm/functions/Function1;)V", "lastClickTime", "onClick", "v", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class DebounceOnClickListener implements View.OnClickListener {
    private final long interval;
    private long lastClickTime;
    private final Function1<View, Unit> listenerBlock;

    public DebounceOnClickListener(long j, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listenerBlock");
        this.interval = j;
        this.listenerBlock = function1;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= this.interval) {
            this.lastClickTime = currentTimeMillis;
            this.listenerBlock.invoke(view);
        }
    }
}
