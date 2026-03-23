package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.viewcore.view.StatusLabelState;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u000fJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/blueair/viewcore/view/StatusLabelTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setStatus", "", "device", "Lcom/blueair/core/model/Device;", "setRatingStatus", "Lcom/blueair/core/model/HasSensorData;", "setRatingStatusFromDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "state", "Lcom/blueair/viewcore/view/StatusLabelState;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StatusLabelTextView.kt */
public final class StatusLabelTextView extends AppCompatTextView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StatusLabelTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StatusLabelTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatusLabelTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setStatus(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        setStatus(StatusLabelState.Companion.from(device, (SensorType) null));
    }

    public final void setRatingStatus(HasSensorData hasSensorData) {
        Intrinsics.checkNotNullParameter(hasSensorData, "device");
        setStatus(StatusLabelState.Companion.fromSensors$default(StatusLabelState.Companion, hasSensorData, (SensorType) null, 2, (Object) null));
    }

    public final void setRatingStatusFromDatapoint(IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData) {
        Intrinsics.checkNotNullParameter(hasSensorData, "device");
        if (indoorDatapoint != null) {
            setStatus(StatusLabelState.Companion.fromDatapoint$default(StatusLabelState.Companion, indoorDatapoint, hasSensorData, (SensorType) null, 4, (Object) null));
            return;
        }
        setStatus(StatusLabelState.Companion.fromSensors$default(StatusLabelState.Companion, hasSensorData, (SensorType) null, 2, (Object) null));
    }

    private final void setStatus(StatusLabelState statusLabelState) {
        CharSequence charSequence;
        ViewExtensionsKt.show(this, statusLabelState.getShouldShowStatusLabel());
        if (statusLabelState.getShouldSubstituteValueIntoText()) {
            charSequence = getContext().getString(statusLabelState.getTextResId(), new Object[]{String.valueOf(statusLabelState.getValueForText())});
        } else {
            charSequence = getContext().getString(statusLabelState.getTextResId());
        }
        setText(charSequence);
    }
}
