package com.blueair.viewcore.dialog;

import android.widget.PopupWindow;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DialogUtils$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ PopupWindow f$0;
    public final /* synthetic */ Function2 f$1;

    public /* synthetic */ DialogUtils$$ExternalSyntheticLambda1(PopupWindow popupWindow, Function2 function2) {
        this.f$0 = popupWindow;
        this.f$1 = function2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return DialogUtils.showDropDownList$lambda$2(this.f$0, this.f$1, ((Integer) obj).intValue(), (String) obj2);
    }
}
