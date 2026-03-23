package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u000fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/FilterConfigRaw;", "", "video", "", "filters", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVideo", "()Ljava/lang/String;", "getFilters", "()Ljava/util/List;", "toFilterConfig", "Lcom/blueair/core/model/FilterConfig;", "linkMap", "", "Lcom/blueair/core/model/AwsLinkConfig;", "filterInfoMap", "Lcom/blueair/core/model/FilterInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class FilterConfigRaw {
    private final List<String> filters;
    private final String video;

    public static /* synthetic */ FilterConfigRaw copy$default(FilterConfigRaw filterConfigRaw, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filterConfigRaw.video;
        }
        if ((i & 2) != 0) {
            list = filterConfigRaw.filters;
        }
        return filterConfigRaw.copy(str, list);
    }

    public final String component1() {
        return this.video;
    }

    public final List<String> component2() {
        return this.filters;
    }

    public final FilterConfigRaw copy(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "filters");
        return new FilterConfigRaw(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterConfigRaw)) {
            return false;
        }
        FilterConfigRaw filterConfigRaw = (FilterConfigRaw) obj;
        return Intrinsics.areEqual((Object) this.video, (Object) filterConfigRaw.video) && Intrinsics.areEqual((Object) this.filters, (Object) filterConfigRaw.filters);
    }

    public int hashCode() {
        String str = this.video;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.filters.hashCode();
    }

    public String toString() {
        return "FilterConfigRaw(video=" + this.video + ", filters=" + this.filters + ')';
    }

    public FilterConfigRaw(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "filters");
        this.video = str;
        this.filters = list;
    }

    public final String getVideo() {
        return this.video;
    }

    public final List<String> getFilters() {
        return this.filters;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.FilterConfig toFilterConfig(java.util.Map<java.lang.String, com.blueair.core.model.AwsLinkConfig> r5, java.util.Map<java.lang.String, com.blueair.core.model.FilterInfo> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "linkMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "filterInfoMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = r4.video
            if (r0 == 0) goto L_0x00a1
            int r1 = r0.hashCode()
            switch(r1) {
                case -1723117755: goto L_0x0095;
                case -583308225: goto L_0x0089;
                case -583278434: goto L_0x007d;
                case 3609878: goto L_0x0071;
                case 3610141: goto L_0x0065;
                case 3610142: goto L_0x0059;
                case 175182008: goto L_0x004d;
                case 177577620: goto L_0x0041;
                case 815674431: goto L_0x0033;
                case 1149287411: goto L_0x0025;
                case 1808260807: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x00a1
        L_0x0017:
            java.lang.String r1 = "v_humidifier"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0021
            goto L_0x00a1
        L_0x0021:
            int r0 = com.blueair.core.R.drawable.vt_humidifier
            goto L_0x00a2
        L_0x0025:
            java.lang.String r1 = "v_nb_511"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002f
            goto L_0x00a1
        L_0x002f:
            int r0 = com.blueair.core.R.drawable.vt_nb_511
            goto L_0x00a2
        L_0x0033:
            java.lang.String r1 = "v_blue40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003d
            goto L_0x00a1
        L_0x003d:
            int r0 = com.blueair.core.R.drawable.vt_blue40
            goto L_0x00a2
        L_0x0041:
            java.lang.String r1 = "v_pet20"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004a
            goto L_0x00a1
        L_0x004a:
            int r0 = com.blueair.core.R.drawable.vt_pet20
            goto L_0x00a2
        L_0x004d:
            java.lang.String r1 = "v_mrest"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0056
            goto L_0x00a1
        L_0x0056:
            int r0 = com.blueair.core.R.drawable.vt_mrest
            goto L_0x00a2
        L_0x0059:
            java.lang.String r1 = "v_nc"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0062
            goto L_0x00a1
        L_0x0062:
            int r0 = com.blueair.core.R.drawable.vt_nc
            goto L_0x00a2
        L_0x0065:
            java.lang.String r1 = "v_nb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006e
            goto L_0x00a1
        L_0x006e:
            int r0 = com.blueair.core.R.drawable.vt_nb
            goto L_0x00a2
        L_0x0071:
            java.lang.String r1 = "v_g4"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007a
            goto L_0x00a1
        L_0x007a:
            int r0 = com.blueair.core.R.drawable.vt_g4
            goto L_0x00a2
        L_0x007d:
            java.lang.String r1 = "v_combo3in1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0086
            goto L_0x00a1
        L_0x0086:
            int r0 = com.blueair.core.R.drawable.vt_combo3in1
            goto L_0x00a2
        L_0x0089:
            java.lang.String r1 = "v_combo2in1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0092
            goto L_0x00a1
        L_0x0092:
            int r0 = com.blueair.core.R.drawable.vt_combo2in1
            goto L_0x00a2
        L_0x0095:
            java.lang.String r1 = "v_humidifier20"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            int r0 = com.blueair.core.R.drawable.vt_humidifier20
            goto L_0x00a2
        L_0x00a1:
            r0 = 0
        L_0x00a2:
            java.lang.String r1 = r4.video
            java.lang.Object r5 = r5.get(r1)
            com.blueair.core.model.AwsLinkConfig r5 = (com.blueair.core.model.AwsLinkConfig) r5
            java.util.List<java.lang.String> r1 = r4.filters
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00b9:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00d1
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r3 = r6.get(r3)
            com.blueair.core.model.FilterInfo r3 = (com.blueair.core.model.FilterInfo) r3
            if (r3 == 0) goto L_0x00b9
            r2.add(r3)
            goto L_0x00b9
        L_0x00d1:
            java.util.List r2 = (java.util.List) r2
            com.blueair.core.model.FilterConfig r6 = new com.blueair.core.model.FilterConfig
            r6.<init>(r5, r0, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.FilterConfigRaw.toFilterConfig(java.util.Map, java.util.Map):com.blueair.core.model.FilterConfig");
    }
}
