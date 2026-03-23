package com.blueair.viewcore.viewholder;

import android.view.View;
import com.blueair.core.model.FilterInfo;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FilterTypeHolder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Function2 f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ FilterInfo f$2;

    public /* synthetic */ FilterTypeHolder$$ExternalSyntheticLambda0(Function2 function2, int i, FilterInfo filterInfo) {
        this.f$0 = function2;
        this.f$1 = i;
        this.f$2 = filterInfo;
    }

    public final void onClick(View view) {
        FilterTypeHolder.update$lambda$4$lambda$1$lambda$0(this.f$0, this.f$1, this.f$2, view);
    }
}
