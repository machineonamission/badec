package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/blueair/core/model/DeviceConfigRaw;", "", "model", "", "image", "filter", "market", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getImage", "getFilter", "getMarket", "toDeviceConfig", "Lcom/blueair/core/model/DeviceConfig;", "filterConfigMap", "", "Lcom/blueair/core/model/FilterConfig;", "modelMap", "Lcom/blueair/core/model/DeviceModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class DeviceConfigRaw {
    private final String filter;
    private final String image;
    private final String market;
    private final String model;

    public static /* synthetic */ DeviceConfigRaw copy$default(DeviceConfigRaw deviceConfigRaw, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceConfigRaw.model;
        }
        if ((i & 2) != 0) {
            str2 = deviceConfigRaw.image;
        }
        if ((i & 4) != 0) {
            str3 = deviceConfigRaw.filter;
        }
        if ((i & 8) != 0) {
            str4 = deviceConfigRaw.market;
        }
        return deviceConfigRaw.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.model;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.filter;
    }

    public final String component4() {
        return this.market;
    }

    public final DeviceConfigRaw copy(String str, String str2, String str3, String str4) {
        return new DeviceConfigRaw(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceConfigRaw)) {
            return false;
        }
        DeviceConfigRaw deviceConfigRaw = (DeviceConfigRaw) obj;
        return Intrinsics.areEqual((Object) this.model, (Object) deviceConfigRaw.model) && Intrinsics.areEqual((Object) this.image, (Object) deviceConfigRaw.image) && Intrinsics.areEqual((Object) this.filter, (Object) deviceConfigRaw.filter) && Intrinsics.areEqual((Object) this.market, (Object) deviceConfigRaw.market);
    }

    public int hashCode() {
        String str = this.model;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.filter;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.market;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceConfigRaw(model=" + this.model + ", image=" + this.image + ", filter=" + this.filter + ", market=" + this.market + ')';
    }

    public DeviceConfigRaw(String str, String str2, String str3, String str4) {
        this.model = str;
        this.image = str2;
        this.filter = str3;
        this.market = str4;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final String getMarket() {
        return this.market;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e2, code lost:
        r9 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.blueair.core.model.DeviceConfig toDeviceConfig(java.util.Map<java.lang.String, com.blueair.core.model.FilterConfig> r19, java.util.Map<java.lang.String, com.blueair.core.model.DeviceModel> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "filterConfigMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "modelMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = r0.model
            java.lang.Object r2 = r2.get(r3)
            com.blueair.core.model.DeviceModel r2 = (com.blueair.core.model.DeviceModel) r2
            java.lang.String r3 = r0.image
            r4 = 0
            if (r3 == 0) goto L_0x01e4
            int r5 = r3.hashCode()
            switch(r5) {
                case -2014964886: goto L_0x01d7;
                case -1859308575: goto L_0x01cb;
                case -1808463891: goto L_0x01bf;
                case -1805796556: goto L_0x01b3;
                case -1802498872: goto L_0x01a7;
                case -1802469081: goto L_0x019b;
                case -1626910882: goto L_0x018f;
                case -1548032477: goto L_0x0182;
                case -905948611: goto L_0x0176;
                case -474225217: goto L_0x0168;
                case -141853947: goto L_0x015a;
                case -93260260: goto L_0x014c;
                case 3090: goto L_0x013e;
                case 3245: goto L_0x0130;
                case 100638: goto L_0x0122;
                case 104086: goto L_0x0114;
                case 93223518: goto L_0x0106;
                case 104160705: goto L_0x00f8;
                case 149513373: goto L_0x00ea;
                case 348852056: goto L_0x00dc;
                case 494553062: goto L_0x00ce;
                case 751200560: goto L_0x00c0;
                case 781109134: goto L_0x00b2;
                case 853620882: goto L_0x00a4;
                case 1531553724: goto L_0x0096;
                case 1587965599: goto L_0x0088;
                case 1717154017: goto L_0x007a;
                case 1736086658: goto L_0x006c;
                case 1736116449: goto L_0x005e;
                case 1736146240: goto L_0x0050;
                case 1736176031: goto L_0x0042;
                case 1766236297: goto L_0x0034;
                case 1766236359: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x01e4
        L_0x0026:
            java.lang.String r5 = "nc_cp9i"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0030
            goto L_0x01e4
        L_0x0030:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.CLASSIC_CP9I
            goto L_0x01e2
        L_0x0034:
            java.lang.String r5 = "nc_cp7i"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x003e
            goto L_0x01e4
        L_0x003e:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.CLASSIC_CP7I
            goto L_0x01e2
        L_0x0042:
            java.lang.String r5 = "nb_511i"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x004c
            goto L_0x01e4
        L_0x004c:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE_511I
            goto L_0x01e2
        L_0x0050:
            java.lang.String r5 = "nb_411i"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x005a
            goto L_0x01e4
        L_0x005a:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE_411I
            goto L_0x01e2
        L_0x005e:
            java.lang.String r5 = "nb_311i"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0068
            goto L_0x01e4
        L_0x0068:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE_311I
            goto L_0x01e2
        L_0x006c:
            java.lang.String r5 = "nb_211i"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0076
            goto L_0x01e4
        L_0x0076:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE_211I
            goto L_0x01e2
        L_0x007a:
            java.lang.String r5 = "humidifier20_large_blue"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0084
            goto L_0x01e4
        L_0x0084:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.HUMIDIFIER20_LARGE_BLUE
            goto L_0x01e2
        L_0x0088:
            java.lang.String r5 = "dehumidifier"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0092
            goto L_0x01e4
        L_0x0092:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.DEHUMIDIFIER
            goto L_0x01e2
        L_0x0096:
            java.lang.String r5 = "pet20_green_us"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00a0
            goto L_0x01e4
        L_0x00a0:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.PET20_GREEN_US
            goto L_0x01e2
        L_0x00a4:
            java.lang.String r5 = "classic"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00ae
            goto L_0x01e4
        L_0x00ae:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.CLASSIC
            goto L_0x01e2
        L_0x00b2:
            java.lang.String r5 = "combo3in1_dark"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00bc
            goto L_0x01e4
        L_0x00bc:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.COMBO3IN1_DARK
            goto L_0x01e2
        L_0x00c0:
            java.lang.String r5 = "cmb2in120"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00ca
            goto L_0x01e4
        L_0x00ca:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.CMB2IN120
            goto L_0x01e2
        L_0x00ce:
            java.lang.String r5 = "pet20_sand"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00d8
            goto L_0x01e4
        L_0x00d8:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.PET20_SAND
            goto L_0x01e2
        L_0x00dc:
            java.lang.String r5 = "humidifier20_large"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00e6
            goto L_0x01e4
        L_0x00e6:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.HUMIDIFIER20_LARGE
            goto L_0x01e2
        L_0x00ea:
            java.lang.String r5 = "humidifier20_blue"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x00f4
            goto L_0x01e4
        L_0x00f4:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.HUMIDIFIER20_BLUE
            goto L_0x01e2
        L_0x00f8:
            java.lang.String r5 = "mrest"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0102
            goto L_0x01e4
        L_0x0102:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.MREST
            goto L_0x01e2
        L_0x0106:
            java.lang.String r5 = "aware"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0110
            goto L_0x01e4
        L_0x0110:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.AWARE
            goto L_0x01e2
        L_0x0114:
            java.lang.String r5 = "icp"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x011e
            goto L_0x01e4
        L_0x011e:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.ICP
            goto L_0x01e2
        L_0x0122:
            java.lang.String r5 = "g4+"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x012c
            goto L_0x01e4
        L_0x012c:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.G4_PLUS
            goto L_0x01e2
        L_0x0130:
            java.lang.String r5 = "g4"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x013a
            goto L_0x01e4
        L_0x013a:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.G4
            goto L_0x01e2
        L_0x013e:
            java.lang.String r5 = "b4"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0148
            goto L_0x01e4
        L_0x0148:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.B4
            goto L_0x01e2
        L_0x014c:
            java.lang.String r5 = "humidifier20"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0156
            goto L_0x01e4
        L_0x0156:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.HUMIDIFIER20
            goto L_0x01e2
        L_0x015a:
            java.lang.String r5 = "mrest_green"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0164
            goto L_0x01e4
        L_0x0164:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.MREST_GREEN
            goto L_0x01e2
        L_0x0168:
            java.lang.String r5 = "blue40_dark"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0172
            goto L_0x01e4
        L_0x0172:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE40_DARK
            goto L_0x01e2
        L_0x0176:
            java.lang.String r5 = "sense+"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x01e4
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.SENSE
            goto L_0x01e2
        L_0x0182:
            java.lang.String r5 = "combo3in1_large"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x018c
            goto L_0x01e4
        L_0x018c:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.COMBO3IN1_LARGE
            goto L_0x01e2
        L_0x018f:
            java.lang.String r5 = "humidifier"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0198
            goto L_0x01e4
        L_0x0198:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.HUMIDIFIER
            goto L_0x01e2
        L_0x019b:
            java.lang.String r5 = "combo3in1"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01a4
            goto L_0x01e4
        L_0x01a4:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.COMBO3IN1
            goto L_0x01e2
        L_0x01a7:
            java.lang.String r5 = "combo2in1"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01b0
            goto L_0x01e4
        L_0x01b0:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.COMBO2IN1
            goto L_0x01e2
        L_0x01b3:
            java.lang.String r5 = "mrest_dark"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01bc
            goto L_0x01e4
        L_0x01bc:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.MREST_DARK
            goto L_0x01e2
        L_0x01bf:
            java.lang.String r5 = "blue40_light"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01c8
            goto L_0x01e4
        L_0x01c8:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE40_LIGHT
            goto L_0x01e2
        L_0x01cb:
            java.lang.String r5 = "pet20_green"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01d4
            goto L_0x01e4
        L_0x01d4:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.PET20_GREEN
            goto L_0x01e2
        L_0x01d7:
            java.lang.String r5 = "nb_311i+"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x01e0
            goto L_0x01e4
        L_0x01e0:
            com.blueair.core.model.DeviceImage r3 = com.blueair.core.model.DeviceImage.BLUE_311I_PLUS
        L_0x01e2:
            r9 = r3
            goto L_0x01e5
        L_0x01e4:
            r9 = r4
        L_0x01e5:
            com.blueair.core.model.DeviceConfig r5 = new com.blueair.core.model.DeviceConfig
            if (r2 == 0) goto L_0x01ef
            com.blueair.core.model.DeviceType r3 = r2.getType()
            r6 = r3
            goto L_0x01f0
        L_0x01ef:
            r6 = r4
        L_0x01f0:
            if (r2 == 0) goto L_0x01f8
            com.blueair.core.model.I18nConfig r3 = r2.getModelName()
            r7 = r3
            goto L_0x01f9
        L_0x01f8:
            r7 = r4
        L_0x01f9:
            if (r2 == 0) goto L_0x0201
            com.blueair.core.model.I18nConfig r3 = r2.getFamilyName()
            r8 = r3
            goto L_0x0202
        L_0x0201:
            r8 = r4
        L_0x0202:
            java.lang.String r3 = r0.filter
            java.lang.Object r1 = r1.get(r3)
            r10 = r1
            com.blueair.core.model.FilterConfig r10 = (com.blueair.core.model.FilterConfig) r10
            if (r2 == 0) goto L_0x0213
            com.blueair.core.model.I18nConfig r1 = r2.getUserManual()
            r11 = r1
            goto L_0x0214
        L_0x0213:
            r11 = r4
        L_0x0214:
            java.lang.String r1 = r0.market
            if (r1 == 0) goto L_0x0242
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            if (r1 == 0) goto L_0x0242
            r12 = r1
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r1 = 1
            char[] r13 = new char[r1]
            r1 = 47
            r2 = 0
            r13[r2] = r1
            r16 = 6
            r17 = 0
            r14 = 0
            r15 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (char[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            if (r1 == 0) goto L_0x0242
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r1)
        L_0x0242:
            r12 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceConfigRaw.toDeviceConfig(java.util.Map, java.util.Map):com.blueair.core.model.DeviceConfig");
    }
}
