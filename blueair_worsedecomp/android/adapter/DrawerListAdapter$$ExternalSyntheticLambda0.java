package com.blueair.android.adapter;

import android.view.MenuItem;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DrawerListAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DrawerListAdapter f$0;
    public final /* synthetic */ MenuItem f$1;

    public /* synthetic */ DrawerListAdapter$$ExternalSyntheticLambda0(DrawerListAdapter drawerListAdapter, MenuItem menuItem) {
        this.f$0 = drawerListAdapter;
        this.f$1 = menuItem;
    }

    public final void onClick(View view) {
        DrawerListAdapter.onBindViewHolder$lambda$3$lambda$2(this.f$0, this.f$1, view);
    }
}
