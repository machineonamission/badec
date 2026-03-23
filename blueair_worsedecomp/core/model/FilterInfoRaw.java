package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006*"}, d2 = {"Lcom/blueair/core/model/FilterInfoRaw;", "", "type", "", "name", "Lcom/blueair/core/model/I18nConfig;", "image", "summary", "manual", "linkSubscribe", "Lcom/blueair/core/model/IpConfig;", "linkPurchase", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IpConfig;Lcom/blueair/core/model/IpConfig;)V", "getType", "()Ljava/lang/String;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getImage", "getSummary", "getManual", "getLinkSubscribe", "()Lcom/blueair/core/model/IpConfig;", "getLinkPurchase", "toFilterInfo", "Lcom/blueair/core/model/FilterInfo;", "manualMap", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class FilterInfoRaw {
    private final String image;
    private final IpConfig linkPurchase;
    private final IpConfig linkSubscribe;
    private final String manual;
    private final I18nConfig name;
    private final String summary;
    private final String type;

    public static /* synthetic */ FilterInfoRaw copy$default(FilterInfoRaw filterInfoRaw, String str, I18nConfig i18nConfig, String str2, String str3, String str4, IpConfig ipConfig, IpConfig ipConfig2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filterInfoRaw.type;
        }
        if ((i & 2) != 0) {
            i18nConfig = filterInfoRaw.name;
        }
        if ((i & 4) != 0) {
            str2 = filterInfoRaw.image;
        }
        if ((i & 8) != 0) {
            str3 = filterInfoRaw.summary;
        }
        if ((i & 16) != 0) {
            str4 = filterInfoRaw.manual;
        }
        if ((i & 32) != 0) {
            ipConfig = filterInfoRaw.linkSubscribe;
        }
        if ((i & 64) != 0) {
            ipConfig2 = filterInfoRaw.linkPurchase;
        }
        IpConfig ipConfig3 = ipConfig;
        IpConfig ipConfig4 = ipConfig2;
        String str5 = str3;
        String str6 = str4;
        return filterInfoRaw.copy(str, i18nConfig, str2, str5, str6, ipConfig3, ipConfig4);
    }

    public final String component1() {
        return this.type;
    }

    public final I18nConfig component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.summary;
    }

    public final String component5() {
        return this.manual;
    }

    public final IpConfig component6() {
        return this.linkSubscribe;
    }

    public final IpConfig component7() {
        return this.linkPurchase;
    }

    public final FilterInfoRaw copy(String str, I18nConfig i18nConfig, String str2, String str3, String str4, IpConfig ipConfig, IpConfig ipConfig2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        Intrinsics.checkNotNullParameter(str2, "image");
        return new FilterInfoRaw(str, i18nConfig, str2, str3, str4, ipConfig, ipConfig2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterInfoRaw)) {
            return false;
        }
        FilterInfoRaw filterInfoRaw = (FilterInfoRaw) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) filterInfoRaw.type) && Intrinsics.areEqual((Object) this.name, (Object) filterInfoRaw.name) && Intrinsics.areEqual((Object) this.image, (Object) filterInfoRaw.image) && Intrinsics.areEqual((Object) this.summary, (Object) filterInfoRaw.summary) && Intrinsics.areEqual((Object) this.manual, (Object) filterInfoRaw.manual) && Intrinsics.areEqual((Object) this.linkSubscribe, (Object) filterInfoRaw.linkSubscribe) && Intrinsics.areEqual((Object) this.linkPurchase, (Object) filterInfoRaw.linkPurchase);
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31;
        String str = this.summary;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.manual;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        IpConfig ipConfig = this.linkSubscribe;
        int hashCode4 = (hashCode3 + (ipConfig == null ? 0 : ipConfig.hashCode())) * 31;
        IpConfig ipConfig2 = this.linkPurchase;
        if (ipConfig2 != null) {
            i = ipConfig2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "FilterInfoRaw(type=" + this.type + ", name=" + this.name + ", image=" + this.image + ", summary=" + this.summary + ", manual=" + this.manual + ", linkSubscribe=" + this.linkSubscribe + ", linkPurchase=" + this.linkPurchase + ')';
    }

    public FilterInfoRaw(String str, I18nConfig i18nConfig, String str2, String str3, String str4, IpConfig ipConfig, IpConfig ipConfig2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(i18nConfig, "name");
        Intrinsics.checkNotNullParameter(str2, "image");
        this.type = str;
        this.name = i18nConfig;
        this.image = str2;
        this.summary = str3;
        this.manual = str4;
        this.linkSubscribe = ipConfig;
        this.linkPurchase = ipConfig2;
    }

    public final String getType() {
        return this.type;
    }

    public final I18nConfig getName() {
        return this.name;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getManual() {
        return this.manual;
    }

    public final IpConfig getLinkSubscribe() {
        return this.linkSubscribe;
    }

    public final IpConfig getLinkPurchase() {
        return this.linkPurchase;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01fc, code lost:
        if (r0.equals("r_hum2.0") == false) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ff, code lost:
        r0 = com.blueair.core.R.drawable.refresher_default;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0232, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0233, code lost:
        r1 = r11.summary;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0235, code lost:
        if (r1 == null) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x023b, code lost:
        switch(r1.hashCode()) {
            case -1779796760: goto L_0x02ca;
            case -1680800543: goto L_0x02c0;
            case -1626910882: goto L_0x02b4;
            case -1556683460: goto L_0x02aa;
            case -1165530794: goto L_0x02a0;
            case -113355247: goto L_0x0299;
            case 308228426: goto L_0x028d;
            case 318969935: goto L_0x0281;
            case 607859486: goto L_0x0276;
            case 716884769: goto L_0x0268;
            case 1188771019: goto L_0x025a;
            case 1803669703: goto L_0x024c;
            case 1937343526: goto L_0x0240;
            default: goto L_0x023e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0244, code lost:
        if (r1.equals("w_humidifier") != false) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0248, code lost:
        r9 = com.blueair.core.R.string.wick_summary_replacement_h35i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0252, code lost:
        if (r1.equals("blue_allergen") != false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0256, code lost:
        r9 = com.blueair.core.R.string.filter_summary_blue_allergen;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0260, code lost:
        if (r1.equals("blue_particle") != false) goto L_0x0264;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0264, code lost:
        r9 = com.blueair.core.R.string.filter_summary_blue_particle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x026e, code lost:
        if (r1.equals("b4_combo") != false) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0272, code lost:
        r9 = com.blueair.core.R.string.filter_summary_b4_combo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x027a, code lost:
        if (r1.equals("cmb2in120_pro") != false) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x027e, code lost:
        r9 = com.blueair.core.R.string.filter_summary_2in120_pro;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0287, code lost:
        if (r1.equals("blue40_particle") != false) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x028a, code lost:
        r9 = com.blueair.core.R.string.filter_summary_blue40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0293, code lost:
        if (r1.equals("blue_smoke") != false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0296, code lost:
        r9 = com.blueair.core.R.string.filter_summary_blue_smoke;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x029d, code lost:
        if (r1.equals("r_cmb2in120_pro") != false) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02a4, code lost:
        if (r1.equals("w_cmb2in120_pro") != false) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a7, code lost:
        r9 = com.blueair.core.R.string.wick_summary_2in120_pro;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02ae, code lost:
        if (r1.equals("w_hum2.0") != false) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b1, code lost:
        r9 = com.blueair.core.R.string.wick_summary_replacement_h38i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02ba, code lost:
        if (r1.equals("humidifier") != false) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02bd, code lost:
        r9 = com.blueair.core.R.string.wick_summary_replacement_h35i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02c4, code lost:
        if (r1.equals("r_hum2.0") != false) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02c7, code lost:
        r9 = com.blueair.core.R.string.refresher_summary_default;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02d0, code lost:
        if (r1.equals("pet20_particle") != false) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d3, code lost:
        r9 = com.blueair.core.R.string.filter_summary_pet;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02eb, code lost:
        return new com.blueair.core.model.FilterInfo(r2, r11.name, r0, r9, r12.get(r11.manual), r11.linkSubscribe, r11.linkPurchase);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0180, code lost:
        if (r0.equals("r_cmb2in120_pro") == false) goto L_0x0232;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.FilterInfo toFilterInfo(java.util.Map<java.lang.String, com.blueair.core.model.I18nConfig> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "manualMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = r11.type
            int r1 = r0.hashCode()
            r2 = -1274492040(0xffffffffb408cb78, float:-1.2740009E-7)
            if (r1 == r2) goto L_0x0033
            r2 = -564570936(0xffffffffde5954c8, float:-3.91509043E18)
            if (r1 == r2) goto L_0x0027
            r2 = 3649210(0x37aeba, float:5.113632E-39)
            if (r1 == r2) goto L_0x001b
            goto L_0x003b
        L_0x001b:
            java.lang.String r1 = "wick"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0024
            goto L_0x003b
        L_0x0024:
            com.blueair.core.model.DeviceFilterType r0 = com.blueair.core.model.DeviceFilterType.WICK
            goto L_0x003d
        L_0x0027:
            java.lang.String r1 = "refresher"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0030
            goto L_0x003b
        L_0x0030:
            com.blueair.core.model.DeviceFilterType r0 = com.blueair.core.model.DeviceFilterType.REFRESHER
            goto L_0x003d
        L_0x0033:
            java.lang.String r1 = "filter"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003f
        L_0x003b:
            com.blueair.core.model.DeviceFilterType r0 = com.blueair.core.model.DeviceFilterType.FILTER
        L_0x003d:
            r2 = r0
            goto L_0x0042
        L_0x003f:
            com.blueair.core.model.DeviceFilterType r0 = com.blueair.core.model.DeviceFilterType.FILTER
            goto L_0x003d
        L_0x0042:
            java.lang.String r0 = r11.image
            int r1 = r0.hashCode()
            java.lang.String r3 = "w_humidifier"
            java.lang.String r4 = "cmb2in120_pro"
            java.lang.String r5 = "r_cmb2in120_pro"
            java.lang.String r6 = "w_cmb2in120_pro"
            java.lang.String r7 = "w_hum2.0"
            java.lang.String r8 = "r_hum2.0"
            r9 = 0
            switch(r1) {
                case -2052521520: goto L_0x0226;
                case -2052016370: goto L_0x021a;
                case -2052014448: goto L_0x020e;
                case -2052012526: goto L_0x0202;
                case -1680800543: goto L_0x01f8;
                case -1556683460: goto L_0x01ee;
                case -1437622836: goto L_0x01e2;
                case -1385985962: goto L_0x01d6;
                case -1165530794: goto L_0x01ca;
                case -798769918: goto L_0x01bc;
                case -666354575: goto L_0x01ae;
                case -372951568: goto L_0x01a0;
                case -211613083: goto L_0x0192;
                case -138706560: goto L_0x0184;
                case -113355247: goto L_0x017c;
                case -79548561: goto L_0x016e;
                case -51455891: goto L_0x0160;
                case 3090: goto L_0x0152;
                case 1593914: goto L_0x0144;
                case 1623705: goto L_0x0136;
                case 3028929: goto L_0x0128;
                case 104160705: goto L_0x011a;
                case 106556317: goto L_0x010c;
                case 213854446: goto L_0x00fe;
                case 241947116: goto L_0x00f0;
                case 535350123: goto L_0x00e2;
                case 607859486: goto L_0x00d6;
                case 621684004: goto L_0x00c8;
                case 689277381: goto L_0x00ba;
                case 828753130: goto L_0x00ac;
                case 830061412: goto L_0x009e;
                case 855707575: goto L_0x0090;
                case 1026574917: goto L_0x0082;
                case 1223088422: goto L_0x0074;
                case 1419601927: goto L_0x0066;
                case 1937343526: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x0232
        L_0x005a:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0062
            goto L_0x0232
        L_0x0062:
            int r0 = com.blueair.core.R.drawable.wick_humidifier
            goto L_0x0233
        L_0x0066:
            java.lang.String r1 = "211i_smoke"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0070
            goto L_0x0232
        L_0x0070:
            int r0 = com.blueair.core.R.drawable.filter_211i_smoke
            goto L_0x0233
        L_0x0074:
            java.lang.String r1 = "311i_smoke"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007e
            goto L_0x0232
        L_0x007e:
            int r0 = com.blueair.core.R.drawable.filter_311i_smoke
            goto L_0x0233
        L_0x0082:
            java.lang.String r1 = "411i_smoke"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008c
            goto L_0x0232
        L_0x008c:
            int r0 = com.blueair.core.R.drawable.filter_411i_smoke
            goto L_0x0233
        L_0x0090:
            java.lang.String r1 = "g4_smart"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009a
            goto L_0x0232
        L_0x009a:
            int r0 = com.blueair.core.R.drawable.filter_g4_smart
            goto L_0x0233
        L_0x009e:
            java.lang.String r1 = "511i_smoke"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a8
            goto L_0x0232
        L_0x00a8:
            int r0 = com.blueair.core.R.drawable.filter_511i_smoke
            goto L_0x0233
        L_0x00ac:
            java.lang.String r1 = "211i_allergen"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b6
            goto L_0x0232
        L_0x00b6:
            int r0 = com.blueair.core.R.drawable.filter_211i_allergen
            goto L_0x0233
        L_0x00ba:
            java.lang.String r1 = "g4_smart_ultra_fp"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c4
            goto L_0x0232
        L_0x00c4:
            int r0 = com.blueair.core.R.drawable.filter_g4_smart_ultra_fp
            goto L_0x0233
        L_0x00c8:
            java.lang.String r1 = "g4_smart_ultra"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d2
            goto L_0x0232
        L_0x00d2:
            int r0 = com.blueair.core.R.drawable.filter_g4_smart_ultra
            goto L_0x0233
        L_0x00d6:
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00de
            goto L_0x0232
        L_0x00de:
            int r0 = com.blueair.core.R.drawable.filter_cmb2in120_pro
            goto L_0x0233
        L_0x00e2:
            java.lang.String r1 = "311i_allergen"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ec
            goto L_0x0232
        L_0x00ec:
            int r0 = com.blueair.core.R.drawable.filter_311i_allergen
            goto L_0x0233
        L_0x00f0:
            java.lang.String r1 = "411i_allergen"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00fa
            goto L_0x0232
        L_0x00fa:
            int r0 = com.blueair.core.R.drawable.filter_411i_allergen
            goto L_0x0233
        L_0x00fe:
            java.lang.String r1 = "211i_particle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0108
            goto L_0x0232
        L_0x0108:
            int r0 = com.blueair.core.R.drawable.filter_211i_particle
            goto L_0x0233
        L_0x010c:
            java.lang.String r1 = "pet20"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0116
            goto L_0x0232
        L_0x0116:
            int r0 = com.blueair.core.R.drawable.filter_pet20
            goto L_0x0233
        L_0x011a:
            java.lang.String r1 = "mrest"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0124
            goto L_0x0232
        L_0x0124:
            int r0 = com.blueair.core.R.drawable.filter_mrest
            goto L_0x0233
        L_0x0128:
            java.lang.String r1 = "d26i"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0132
            goto L_0x0232
        L_0x0132:
            int r0 = com.blueair.core.R.drawable.filter_dehumidifier
            goto L_0x0233
        L_0x0136:
            java.lang.String r1 = "3in1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0140
            goto L_0x0232
        L_0x0140:
            int r0 = com.blueair.core.R.drawable.filter_combo3in1
            goto L_0x0233
        L_0x0144:
            java.lang.String r1 = "2in1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014e
            goto L_0x0232
        L_0x014e:
            int r0 = com.blueair.core.R.drawable.filter_combo2in1
            goto L_0x0233
        L_0x0152:
            java.lang.String r1 = "b4"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x015c
            goto L_0x0232
        L_0x015c:
            int r0 = com.blueair.core.R.drawable.filter_b4
            goto L_0x0233
        L_0x0160:
            java.lang.String r1 = "511i_allergen"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016a
            goto L_0x0232
        L_0x016a:
            int r0 = com.blueair.core.R.drawable.filter_511i_allergen
            goto L_0x0233
        L_0x016e:
            java.lang.String r1 = "311i_particle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0178
            goto L_0x0232
        L_0x0178:
            int r0 = com.blueair.core.R.drawable.filter_311i_particle
            goto L_0x0233
        L_0x017c:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x01ff
            goto L_0x0232
        L_0x0184:
            java.lang.String r1 = "classic_pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x018e
            goto L_0x0232
        L_0x018e:
            int r0 = com.blueair.core.R.drawable.filter_nc
            goto L_0x0233
        L_0x0192:
            java.lang.String r1 = "311i+_smoke"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x019c
            goto L_0x0232
        L_0x019c:
            int r0 = com.blueair.core.R.drawable.filter_311ip_smoke
            goto L_0x0233
        L_0x01a0:
            java.lang.String r1 = "411i_particle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01aa
            goto L_0x0232
        L_0x01aa:
            int r0 = com.blueair.core.R.drawable.filter_411i_particle
            goto L_0x0233
        L_0x01ae:
            java.lang.String r1 = "511i_particle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01b8
            goto L_0x0232
        L_0x01b8:
            int r0 = com.blueair.core.R.drawable.filter_511i_particle
            goto L_0x0233
        L_0x01bc:
            java.lang.String r1 = "w_2in1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01c6
            goto L_0x0232
        L_0x01c6:
            int r0 = com.blueair.core.R.drawable.wick_combo2in1
            goto L_0x0233
        L_0x01ca:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x01d2
            goto L_0x0232
        L_0x01d2:
            int r0 = com.blueair.core.R.drawable.wick_cmb2in120_pro
            goto L_0x0233
        L_0x01d6:
            java.lang.String r1 = "blue40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01df
            goto L_0x0232
        L_0x01df:
            int r0 = com.blueair.core.R.drawable.filter_blue40
            goto L_0x0233
        L_0x01e2:
            java.lang.String r1 = "311i+_allergen"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01eb
            goto L_0x0232
        L_0x01eb:
            int r0 = com.blueair.core.R.drawable.filter_311ip_allergen
            goto L_0x0233
        L_0x01ee:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x01f5
            goto L_0x0232
        L_0x01f5:
            int r0 = com.blueair.core.R.drawable.wick_humidifier20
            goto L_0x0233
        L_0x01f8:
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x01ff
            goto L_0x0232
        L_0x01ff:
            int r0 = com.blueair.core.R.drawable.refresher_default
            goto L_0x0233
        L_0x0202:
            java.lang.String r1 = "g4p_smart_8800"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x020b
            goto L_0x0232
        L_0x020b:
            int r0 = com.blueair.core.R.drawable.filter_g4p_smart_8800
            goto L_0x0233
        L_0x020e:
            java.lang.String r1 = "g4p_smart_8600"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0217
            goto L_0x0232
        L_0x0217:
            int r0 = com.blueair.core.R.drawable.filter_g4p_smart_8600
            goto L_0x0233
        L_0x021a:
            java.lang.String r1 = "g4p_smart_8400"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0223
            goto L_0x0232
        L_0x0223:
            int r0 = com.blueair.core.R.drawable.filter_g4p_smart_8400
            goto L_0x0233
        L_0x0226:
            java.lang.String r1 = "311i+_particle"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022f
            goto L_0x0232
        L_0x022f:
            int r0 = com.blueair.core.R.drawable.filter_311ip_particle
            goto L_0x0233
        L_0x0232:
            r0 = r9
        L_0x0233:
            java.lang.String r1 = r11.summary
            if (r1 == 0) goto L_0x02d5
            int r10 = r1.hashCode()
            switch(r10) {
                case -1779796760: goto L_0x02ca;
                case -1680800543: goto L_0x02c0;
                case -1626910882: goto L_0x02b4;
                case -1556683460: goto L_0x02aa;
                case -1165530794: goto L_0x02a0;
                case -113355247: goto L_0x0299;
                case 308228426: goto L_0x028d;
                case 318969935: goto L_0x0281;
                case 607859486: goto L_0x0276;
                case 716884769: goto L_0x0268;
                case 1188771019: goto L_0x025a;
                case 1803669703: goto L_0x024c;
                case 1937343526: goto L_0x0240;
                default: goto L_0x023e;
            }
        L_0x023e:
            goto L_0x02d5
        L_0x0240:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0248
            goto L_0x02d5
        L_0x0248:
            int r9 = com.blueair.core.R.string.wick_summary_replacement_h35i
            goto L_0x02d5
        L_0x024c:
            java.lang.String r3 = "blue_allergen"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0256
            goto L_0x02d5
        L_0x0256:
            int r9 = com.blueair.core.R.string.filter_summary_blue_allergen
            goto L_0x02d5
        L_0x025a:
            java.lang.String r3 = "blue_particle"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0264
            goto L_0x02d5
        L_0x0264:
            int r9 = com.blueair.core.R.string.filter_summary_blue_particle
            goto L_0x02d5
        L_0x0268:
            java.lang.String r3 = "b4_combo"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0272
            goto L_0x02d5
        L_0x0272:
            int r9 = com.blueair.core.R.string.filter_summary_b4_combo
            goto L_0x02d5
        L_0x0276:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x027e
            goto L_0x02d5
        L_0x027e:
            int r9 = com.blueair.core.R.string.filter_summary_2in120_pro
            goto L_0x02d5
        L_0x0281:
            java.lang.String r3 = "blue40_particle"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x028a
            goto L_0x02d5
        L_0x028a:
            int r9 = com.blueair.core.R.string.filter_summary_blue40
            goto L_0x02d5
        L_0x028d:
            java.lang.String r3 = "blue_smoke"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0296
            goto L_0x02d5
        L_0x0296:
            int r9 = com.blueair.core.R.string.filter_summary_blue_smoke
            goto L_0x02d5
        L_0x0299:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x02c7
            goto L_0x02d5
        L_0x02a0:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x02a7
            goto L_0x02d5
        L_0x02a7:
            int r9 = com.blueair.core.R.string.wick_summary_2in120_pro
            goto L_0x02d5
        L_0x02aa:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x02b1
            goto L_0x02d5
        L_0x02b1:
            int r9 = com.blueair.core.R.string.wick_summary_replacement_h38i
            goto L_0x02d5
        L_0x02b4:
            java.lang.String r3 = "humidifier"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02bd
            goto L_0x02d5
        L_0x02bd:
            int r9 = com.blueair.core.R.string.wick_summary_replacement_h35i
            goto L_0x02d5
        L_0x02c0:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x02c7
            goto L_0x02d5
        L_0x02c7:
            int r9 = com.blueair.core.R.string.refresher_summary_default
            goto L_0x02d5
        L_0x02ca:
            java.lang.String r3 = "pet20_particle"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02d3
            goto L_0x02d5
        L_0x02d3:
            int r9 = com.blueair.core.R.string.filter_summary_pet
        L_0x02d5:
            r5 = r9
            com.blueair.core.model.FilterInfo r1 = new com.blueair.core.model.FilterInfo
            com.blueair.core.model.I18nConfig r3 = r11.name
            java.lang.String r4 = r11.manual
            java.lang.Object r12 = r12.get(r4)
            r6 = r12
            com.blueair.core.model.I18nConfig r6 = (com.blueair.core.model.I18nConfig) r6
            com.blueair.core.model.IpConfig r7 = r11.linkSubscribe
            com.blueair.core.model.IpConfig r8 = r11.linkPurchase
            r4 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.FilterInfoRaw.toFilterInfo(java.util.Map):com.blueair.core.model.FilterInfo");
    }
}
