package com.blueair.devicedetails.viewholder;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder$1$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMainModeButtonsHolder.kt */
public final class DeviceMainModeButtonsHolder$1$1 extends GridLayoutManager.SpanSizeLookup {
    DeviceMainModeButtonsHolder$1$1() {
    }

    public int getSpanSize(int i) {
        return i % 3 == 1 ? 2 : 1;
    }
}
