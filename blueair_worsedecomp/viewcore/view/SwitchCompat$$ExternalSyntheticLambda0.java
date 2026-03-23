package com.blueair.viewcore.view;

import android.widget.CompoundButton;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwitchCompat$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SwitchCompat f$0;
    public final /* synthetic */ CompoundButton.OnCheckedChangeListener f$1;

    public /* synthetic */ SwitchCompat$$ExternalSyntheticLambda0(SwitchCompat switchCompat, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f$0 = switchCompat;
        this.f$1 = onCheckedChangeListener;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SwitchCompat.setOnCheckedChangeListener$lambda$0(this.f$0, this.f$1, compoundButton, z);
    }
}
