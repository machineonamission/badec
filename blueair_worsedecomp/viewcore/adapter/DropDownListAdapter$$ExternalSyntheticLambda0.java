package com.blueair.viewcore.adapter;

import android.view.View;
import com.blueair.viewcore.viewholder.DropDownItemHolder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DropDownListAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DropDownListAdapter f$0;
    public final /* synthetic */ DropDownItemHolder f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DropDownListAdapter$$ExternalSyntheticLambda0(DropDownListAdapter dropDownListAdapter, DropDownItemHolder dropDownItemHolder, int i) {
        this.f$0 = dropDownListAdapter;
        this.f$1 = dropDownItemHolder;
        this.f$2 = i;
    }

    public final void onClick(View view) {
        DropDownListAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, this.f$1, this.f$2, view);
    }
}
