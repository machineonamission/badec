package com.blueair.core.util;

import android.view.View;
import android.view.ViewTreeObserver;
import io.reactivex.ObservableEmitter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class KeyboardManager$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ ObservableEmitter f$1;

    public /* synthetic */ KeyboardManager$$ExternalSyntheticLambda0(View view, ObservableEmitter observableEmitter) {
        this.f$0 = view;
        this.f$1 = observableEmitter;
    }

    public final void onGlobalLayout() {
        KeyboardManager.status$lambda$2$lambda$1(this.f$0, this.f$1);
    }
}
