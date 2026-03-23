package com.blueair.outdoor.ui.viewmodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/blueair/outdoor/ui/viewmodels/SearchItemContainer;", "", "primaryText", "", "secondaryText", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPrimaryText", "()Ljava/lang/String;", "getSecondaryText", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchViewModel.kt */
public final class SearchItemContainer {
    private final String id;
    private final String primaryText;
    private final String secondaryText;

    public static /* synthetic */ SearchItemContainer copy$default(SearchItemContainer searchItemContainer, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchItemContainer.primaryText;
        }
        if ((i & 2) != 0) {
            str2 = searchItemContainer.secondaryText;
        }
        if ((i & 4) != 0) {
            str3 = searchItemContainer.id;
        }
        return searchItemContainer.copy(str, str2, str3);
    }

    public final String component1() {
        return this.primaryText;
    }

    public final String component2() {
        return this.secondaryText;
    }

    public final String component3() {
        return this.id;
    }

    public final SearchItemContainer copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "primaryText");
        Intrinsics.checkNotNullParameter(str2, "secondaryText");
        Intrinsics.checkNotNullParameter(str3, "id");
        return new SearchItemContainer(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchItemContainer)) {
            return false;
        }
        SearchItemContainer searchItemContainer = (SearchItemContainer) obj;
        return Intrinsics.areEqual((Object) this.primaryText, (Object) searchItemContainer.primaryText) && Intrinsics.areEqual((Object) this.secondaryText, (Object) searchItemContainer.secondaryText) && Intrinsics.areEqual((Object) this.id, (Object) searchItemContainer.id);
    }

    public int hashCode() {
        return (((this.primaryText.hashCode() * 31) + this.secondaryText.hashCode()) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "SearchItemContainer(primaryText=" + this.primaryText + ", secondaryText=" + this.secondaryText + ", id=" + this.id + ')';
    }

    public SearchItemContainer(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "primaryText");
        Intrinsics.checkNotNullParameter(str2, "secondaryText");
        Intrinsics.checkNotNullParameter(str3, "id");
        this.primaryText = str;
        this.secondaryText = str2;
        this.id = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPrimaryText() {
        return this.primaryText;
    }

    public final String getSecondaryText() {
        return this.secondaryText;
    }
}
