package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.databinding.HolderTimezoneBinding;
import com.blueair.viewcore.R;
import com.gigya.android.sdk.GigyaDefinitions;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderTimezoneBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderTimezoneBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderTimezoneBinding;", "bind", "", "timezone", "Ljava/util/TimeZone;", "isSelected", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTimezoneHolder.kt */
public final class DeviceTimezoneHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderTimezoneBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceTimezoneHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceTimezoneHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            HolderTimezoneBinding inflate = HolderTimezoneBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceTimezoneHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceTimezoneHolder(HolderTimezoneBinding holderTimezoneBinding) {
        super(holderTimezoneBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderTimezoneBinding, "binding");
        this.binding = holderTimezoneBinding;
    }

    public final HolderTimezoneBinding getBinding() {
        return this.binding;
    }

    public final void bind(TimeZone timeZone, boolean z) {
        Intrinsics.checkNotNullParameter(timeZone, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        TextView textView = this.binding.displayName;
        TimezoneUtils timezoneUtils = TimezoneUtils.INSTANCE;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(timezoneUtils.getDisplayName(context, timeZone));
        this.binding.timezone.setText(timeZone.getID());
        this.itemView.setBackgroundTintList(ColorStateList.valueOf(z ? this.itemView.getContext().getColor(R.color.platinum) : 0));
    }
}
