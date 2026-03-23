package com.blueair.core.util;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class KeyboardManager$$ExternalSyntheticLambda1 implements ObservableOnSubscribe {
    public final /* synthetic */ KeyboardManager f$0;

    public /* synthetic */ KeyboardManager$$ExternalSyntheticLambda1(KeyboardManager keyboardManager) {
        this.f$0 = keyboardManager;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        KeyboardManager.status$lambda$2(this.f$0, observableEmitter);
    }
}
