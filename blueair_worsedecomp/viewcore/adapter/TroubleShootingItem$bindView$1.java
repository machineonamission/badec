package com.blueair.viewcore.adapter;

import android.view.View;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/viewcore/adapter/TroubleShootingItem$bindView$1", "Lcom/blueair/viewcore/utils/NoUnderlineClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TroubleShootingItem.kt */
public final class TroubleShootingItem$bindView$1 extends NoUnderlineClickableSpan {
    final /* synthetic */ String $linkStr;
    final /* synthetic */ TroubleShootingItem this$0;

    TroubleShootingItem$bindView$1(TroubleShootingItem troubleShootingItem, String str) {
        this.this$0 = troubleShootingItem;
        this.$linkStr = str;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.onClickLink.invoke(this.$linkStr, this.this$0.simpleResource.getLinkToken());
    }
}
