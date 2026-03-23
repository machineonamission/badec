package com.blueair.adddevice.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderCommonDeviceNameBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderCommonDeviceNameBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderCommonDeviceNameBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderCommonDeviceNameBinding;", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton", "()Landroid/widget/RadioButton;", "update", "", "name", "", "isSelected", "", "selectionUpdate", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CommonDeviceNameHolder.kt */
public final class CommonDeviceNameHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderCommonDeviceNameBinding binding;
    private final RadioButton radioButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonDeviceNameHolder(HolderCommonDeviceNameBinding holderCommonDeviceNameBinding) {
        super(holderCommonDeviceNameBinding.root);
        Intrinsics.checkNotNullParameter(holderCommonDeviceNameBinding, "binding");
        this.binding = holderCommonDeviceNameBinding;
        RadioButton radioButton2 = holderCommonDeviceNameBinding.root;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "root");
        this.radioButton = radioButton2;
    }

    public final HolderCommonDeviceNameBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: CommonDeviceNameHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CommonDeviceNameHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderCommonDeviceNameBinding inflate = HolderCommonDeviceNameBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new CommonDeviceNameHolder(inflate);
        }
    }

    public final RadioButton getRadioButton() {
        return this.radioButton;
    }

    public final void update(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.radioButton.setText(str);
        selectionUpdate(z);
    }

    public final void selectionUpdate(boolean z) {
        this.radioButton.setChecked(z);
        this.radioButton.setTypeface(ResourcesCompat.getFont(this.itemView.getContext(), z ? R.font.apercu_bold : R.font.apercu_light));
    }
}
