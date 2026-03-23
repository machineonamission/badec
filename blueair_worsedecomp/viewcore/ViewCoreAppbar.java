package com.blueair.viewcore;

import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/blueair/viewcore/ViewCoreAppbar;", "", "headerTitle", "Landroid/widget/TextView;", "getHeaderTitle", "()Landroid/widget/TextView;", "headerMsg", "getHeaderMsg", "actionBar", "Landroidx/appcompat/app/ActionBar;", "getActionBar", "()Landroidx/appcompat/app/ActionBar;", "progressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "getProgressIndicator", "()Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "onboardingSteps", "", "getOnboardingSteps", "()Ljava/util/List;", "setHeader", "", "header", "Lcom/blueair/viewcore/Header;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Header.kt */
public interface ViewCoreAppbar {
    ActionBar getActionBar();

    TextView getHeaderMsg();

    TextView getHeaderTitle();

    List<TextView> getOnboardingSteps();

    LinearProgressIndicator getProgressIndicator();

    void setHeader(Header header);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Header.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void setHeader(ViewCoreAppbar viewCoreAppbar, Header header) {
            Intrinsics.checkNotNullParameter(header, "header");
            CC.$default$setHeader(viewCoreAppbar, header);
        }
    }

    /* renamed from: com.blueair.viewcore.ViewCoreAppbar$-CC  reason: invalid class name */
    /* compiled from: Header.kt */
    public final /* synthetic */ class CC {
        public static void $default$setHeader(ViewCoreAppbar _this, Header header) {
            Intrinsics.checkNotNullParameter(header, "header");
            _this.getHeaderTitle().setText(header.getTitle());
            _this.getHeaderMsg().setText(header.getMessage());
            _this.getHeaderMsg().setVisibility(header.getMessage().length() > 0 ? 0 : 8);
            if (header.getIconDrawableResource() != null) {
                ActionBar actionBar = _this.getActionBar();
                if (actionBar != null) {
                    actionBar.setHomeAsUpIndicator(header.getIconDrawableResource().intValue());
                }
                ActionBar actionBar2 = _this.getActionBar();
                if (actionBar2 != null) {
                    actionBar2.setDisplayHomeAsUpEnabled(true);
                }
            } else {
                ActionBar actionBar3 = _this.getActionBar();
                if (actionBar3 != null) {
                    actionBar3.setHomeAsUpIndicator(R.drawable.ic_arrow_back_trans);
                }
                ActionBar actionBar4 = _this.getActionBar();
                if (actionBar4 != null) {
                    actionBar4.setDisplayHomeAsUpEnabled(false);
                }
            }
            if (header.getStepOrdinal() != null) {
                _this.getProgressIndicator().setVisibility(0);
                _this.getProgressIndicator().setProgress(header.getStepOrdinal().intValue());
                int i = 0;
                for (Object next : _this.getOnboardingSteps()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    TextView textView = (TextView) next;
                    textView.setVisibility(0);
                    textView.setEnabled(i <= header.getStepOrdinal().intValue());
                    Integer stepOrdinal = header.getStepOrdinal();
                    textView.setSelected(stepOrdinal != null && i == stepOrdinal.intValue());
                    i = i2;
                }
                return;
            }
            _this.getProgressIndicator().setVisibility(8);
            for (TextView visibility : _this.getOnboardingSteps()) {
                visibility.setVisibility(8);
            }
        }
    }
}
