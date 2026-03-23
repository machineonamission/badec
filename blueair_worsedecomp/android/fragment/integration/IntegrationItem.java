package com.blueair.android.fragment.integration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.android.R;
import com.blueair.android.databinding.IntegrationItemBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u001a\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/blueair/android/fragment/integration/IntegrationItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/android/databinding/IntegrationItemBinding;", "integration", "Lcom/blueair/android/fragment/integration/Integration;", "linked", "", "onLinkClick", "Lkotlin/Function1;", "", "<init>", "(Lcom/blueair/android/fragment/integration/Integration;ZLkotlin/jvm/functions/Function1;)V", "getIntegration", "()Lcom/blueair/android/fragment/integration/Integration;", "getLinked", "()Z", "getOnLinkClick", "()Lkotlin/jvm/functions/Function1;", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "type", "", "getType", "()I", "bindView", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IntegrationItem.kt */
public final class IntegrationItem extends AbstractBindingItem<IntegrationItemBinding> {
    public static final int $stable = 8;
    private long identifier;
    private final Integration integration;
    private final boolean linked;
    private final Function1<IntegrationItem, Unit> onLinkClick;
    private final int type = R.id.integration_item_type;

    public final Integration getIntegration() {
        return this.integration;
    }

    public final boolean getLinked() {
        return this.linked;
    }

    public final Function1<IntegrationItem, Unit> getOnLinkClick() {
        return this.onLinkClick;
    }

    public IntegrationItem(Integration integration2, boolean z, Function1<? super IntegrationItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(integration2, "integration");
        Intrinsics.checkNotNullParameter(function1, "onLinkClick");
        this.integration = integration2;
        this.linked = z;
        this.onLinkClick = function1;
        this.identifier = (long) integration2.ordinal();
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(long j) {
        this.identifier = j;
    }

    public int getType() {
        return this.type;
    }

    public void bindView(IntegrationItemBinding integrationItemBinding, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(integrationItemBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        integrationItemBinding.title.setText(this.integration.getTitle());
        integrationItemBinding.summary.setText(this.integration.getSummary());
        integrationItemBinding.btnLink.setText(this.linked ? com.blueair.viewcore.R.string.unlink : com.blueair.viewcore.R.string.link);
        integrationItemBinding.btnLink.setOnClickListener(new IntegrationItem$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void bindView$lambda$0(IntegrationItem integrationItem, View view) {
        integrationItem.onLinkClick.invoke(integrationItem);
    }

    public IntegrationItemBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        IntegrationItemBinding inflate = IntegrationItemBinding.inflate(layoutInflater, viewGroup, false);
        inflate.integrationItemRoot.setAccessibilityDelegate(new IntegrationItem$createBinding$1$1());
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        return inflate;
    }
}
