package com.blueair.antifake.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.antifake.databinding.HolderScanResultBinding;
import com.blueair.antifake.databinding.HolderVerificationBinding;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/antifake/adapter/ScanTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "title", "Landroid/widget/TextView;", "info", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "update", "", "result", "Lcom/blueair/antifake/adapter/ScanInfoType;", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScanTypeAdapter.kt */
public final class ScanTypeHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ViewBinding binding;
    private AppCompatImageView image;
    private TextView info;
    private TextView title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanTypeHolder(ViewBinding viewBinding) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "binding");
        this.binding = viewBinding;
        if (viewBinding instanceof HolderVerificationBinding) {
            TextView textView = ((HolderVerificationBinding) viewBinding).verificationTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "verificationTitle");
            this.title = textView;
            TextView textView2 = ((HolderVerificationBinding) viewBinding).verificationInfo;
            Intrinsics.checkNotNullExpressionValue(textView2, "verificationInfo");
            this.info = textView2;
            AppCompatImageView appCompatImageView = ((HolderVerificationBinding) viewBinding).verificationImage;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "verificationImage");
            this.image = appCompatImageView;
        } else if (viewBinding instanceof HolderScanResultBinding) {
            TextView textView3 = ((HolderScanResultBinding) viewBinding).resultTitle;
            Intrinsics.checkNotNullExpressionValue(textView3, "resultTitle");
            this.title = textView3;
            TextView textView4 = ((HolderScanResultBinding) viewBinding).resultInfo;
            Intrinsics.checkNotNullExpressionValue(textView4, "resultInfo");
            this.info = textView4;
            AppCompatImageView appCompatImageView2 = ((HolderScanResultBinding) viewBinding).iconResult;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "iconResult");
            this.image = appCompatImageView2;
        }
    }

    public final ViewBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/antifake/adapter/ScanTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/adapter/ScanTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "scanType", "Lcom/blueair/antifake/adapter/ScanType;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScanTypeAdapter.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: ScanTypeAdapter.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.blueair.antifake.adapter.ScanType[] r0 = com.blueair.antifake.adapter.ScanType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.blueair.antifake.adapter.ScanType r1 = com.blueair.antifake.adapter.ScanType.Verification     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.blueair.antifake.adapter.ScanType r1 = com.blueair.antifake.adapter.ScanType.Result     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.adapter.ScanTypeHolder.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScanTypeHolder newInstance(ViewGroup viewGroup, ScanType scanType) {
            ViewBinding viewBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(scanType, "scanType");
            int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
            if (i == 1) {
                HolderVerificationBinding inflate = HolderVerificationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                viewBinding = inflate;
            } else if (i == 2) {
                HolderScanResultBinding inflate2 = HolderScanResultBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                viewBinding = inflate2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new ScanTypeHolder(viewBinding);
        }
    }

    public final void update(ScanInfoType scanInfoType) {
        Intrinsics.checkNotNullParameter(scanInfoType, "result");
        TextView textView = this.title;
        AppCompatImageView appCompatImageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(this.itemView.getContext().getText(scanInfoType.getTitle()));
        TextView textView2 = this.info;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            textView2 = null;
        }
        textView2.setText(this.itemView.getContext().getText(scanInfoType.getInfo()));
        AppCompatImageView appCompatImageView2 = this.image;
        if (appCompatImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        } else {
            appCompatImageView = appCompatImageView2;
        }
        appCompatImageView.setImageResource(scanInfoType.getImage());
    }
}
