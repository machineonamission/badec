package com.blueair.core.util;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/core/util/KeyboardManager;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "status", "Lio/reactivex/Observable;", "Lcom/blueair/core/util/KeyboardStatus;", "kotlin.jvm.PlatformType", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: KeyboardManager.kt */
public final class KeyboardManager {
    private final FragmentActivity activity;

    public KeyboardManager(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.activity = fragmentActivity;
    }

    public final Observable<KeyboardStatus> status() {
        return Observable.create(new KeyboardManager$$ExternalSyntheticLambda1(this)).distinctUntilChanged();
    }

    /* access modifiers changed from: private */
    public static final void status$lambda$2(KeyboardManager keyboardManager, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        View findViewById = keyboardManager.activity.findViewById(16908290);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new KeyboardManager$$ExternalSyntheticLambda0(findViewById, observableEmitter));
    }

    /* access modifiers changed from: private */
    public static final void status$lambda$2$lambda$1(View view, ObservableEmitter observableEmitter) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getHeight();
        if (((double) (height - rect.bottom)) > ((double) height) * 0.15d) {
            observableEmitter.onNext(KeyboardStatus.OPEN);
        } else {
            observableEmitter.onNext(KeyboardStatus.CLOSED);
        }
    }
}
