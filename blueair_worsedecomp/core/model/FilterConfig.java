package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/model/FilterConfig;", "", "video", "Lcom/blueair/core/model/AwsLinkConfig;", "videoThumbnail", "", "filters", "", "Lcom/blueair/core/model/FilterInfo;", "<init>", "(Lcom/blueair/core/model/AwsLinkConfig;ILjava/util/List;)V", "getVideo", "()Lcom/blueair/core/model/AwsLinkConfig;", "getVideoThumbnail", "()I", "getFilters", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class FilterConfig {
    private final List<FilterInfo> filters;
    private final AwsLinkConfig video;
    private final int videoThumbnail;

    public static /* synthetic */ FilterConfig copy$default(FilterConfig filterConfig, AwsLinkConfig awsLinkConfig, int i, List<FilterInfo> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            awsLinkConfig = filterConfig.video;
        }
        if ((i2 & 2) != 0) {
            i = filterConfig.videoThumbnail;
        }
        if ((i2 & 4) != 0) {
            list = filterConfig.filters;
        }
        return filterConfig.copy(awsLinkConfig, i, list);
    }

    public final AwsLinkConfig component1() {
        return this.video;
    }

    public final int component2() {
        return this.videoThumbnail;
    }

    public final List<FilterInfo> component3() {
        return this.filters;
    }

    public final FilterConfig copy(AwsLinkConfig awsLinkConfig, int i, List<FilterInfo> list) {
        Intrinsics.checkNotNullParameter(list, "filters");
        return new FilterConfig(awsLinkConfig, i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterConfig)) {
            return false;
        }
        FilterConfig filterConfig = (FilterConfig) obj;
        return Intrinsics.areEqual((Object) this.video, (Object) filterConfig.video) && this.videoThumbnail == filterConfig.videoThumbnail && Intrinsics.areEqual((Object) this.filters, (Object) filterConfig.filters);
    }

    public int hashCode() {
        AwsLinkConfig awsLinkConfig = this.video;
        return ((((awsLinkConfig == null ? 0 : awsLinkConfig.hashCode()) * 31) + this.videoThumbnail) * 31) + this.filters.hashCode();
    }

    public String toString() {
        return "FilterConfig(video=" + this.video + ", videoThumbnail=" + this.videoThumbnail + ", filters=" + this.filters + ')';
    }

    public FilterConfig(AwsLinkConfig awsLinkConfig, int i, List<FilterInfo> list) {
        Intrinsics.checkNotNullParameter(list, "filters");
        this.video = awsLinkConfig;
        this.videoThumbnail = i;
        this.filters = list;
    }

    public final AwsLinkConfig getVideo() {
        return this.video;
    }

    public final int getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public final List<FilterInfo> getFilters() {
        return this.filters;
    }
}
