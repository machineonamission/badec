package com.blueair.viewcore.viewholder;

import android.view.View;
import com.blueair.core.model.FilterInfo;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FilterTypeHolder$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ FilterInfo f$1;

    public /* synthetic */ FilterTypeHolder$$ExternalSyntheticLambda1(Function1 function1, FilterInfo filterInfo) {
        this.f$0 = function1;
        this.f$1 = filterInfo;
    }

    public final void onClick(View view) {
        FilterTypeHolder.update$lambda$4$lambda$3$lambda$2(this.f$0, this.f$1, view);
    }
}
