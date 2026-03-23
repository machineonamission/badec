package com.blueair.api.restapi;

import com.blueair.api.restapi.DeviceAttribute;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"}, d2 = {"Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "", "userId", "", "uuid", "", "scope", "name", "currentValue", "defaultValue", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUuid", "()Ljava/lang/String;", "getScope", "getName", "getCurrentValue", "getDefaultValue", "getParsedAttribute", "Lcom/blueair/api/restapi/DeviceAttribute;", "getBooleanForAttribute", "", "getStringForAttribute", "getIntForAttribute", "getLongForAttribute", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "equals", "other", "hashCode", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAblRestApi.kt */
public final class DeviceAttributeOnAbl {
    private final String currentValue;
    private final String defaultValue;
    private final String name;
    private final String scope;
    private final Integer userId;
    private final String uuid;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAblRestApi.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(2:25|26)|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.api.restapi.DeviceAttributeName[] r0 = com.blueair.api.restapi.DeviceAttributeName.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.Brightness     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.FanSpeed     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.FilterRemainingMinutes     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.ChildLock     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.DealerCountry     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.DealerName     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.FanUsage     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.Mode     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.FilterType     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.AutoModeDependency     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.PurchaseDate     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.SerialNumber     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.api.restapi.DeviceAttributeName r1 = com.blueair.api.restapi.DeviceAttributeName.UnknownAttribute     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.restapi.DeviceAttributeOnAbl.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ DeviceAttributeOnAbl copy$default(DeviceAttributeOnAbl deviceAttributeOnAbl, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            num = deviceAttributeOnAbl.userId;
        }
        if ((i & 2) != 0) {
            str = deviceAttributeOnAbl.uuid;
        }
        if ((i & 4) != 0) {
            str2 = deviceAttributeOnAbl.scope;
        }
        if ((i & 8) != 0) {
            str3 = deviceAttributeOnAbl.name;
        }
        if ((i & 16) != 0) {
            str4 = deviceAttributeOnAbl.currentValue;
        }
        if ((i & 32) != 0) {
            str5 = deviceAttributeOnAbl.defaultValue;
        }
        String str6 = str4;
        String str7 = str5;
        String str8 = str3;
        String str9 = str;
        return deviceAttributeOnAbl.copy(num, str9, str2, str8, str6, str7);
    }

    public final Integer component1() {
        return this.userId;
    }

    public final String component2() {
        return this.uuid;
    }

    public final String component3() {
        return this.scope;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.currentValue;
    }

    public final String component6() {
        return this.defaultValue;
    }

    public final DeviceAttributeOnAbl copy(Integer num, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(str2, "scope");
        Intrinsics.checkNotNullParameter(str3, "name");
        return new DeviceAttributeOnAbl(num, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceAttributeOnAbl)) {
            return false;
        }
        DeviceAttributeOnAbl deviceAttributeOnAbl = (DeviceAttributeOnAbl) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) deviceAttributeOnAbl.userId) && Intrinsics.areEqual((Object) this.uuid, (Object) deviceAttributeOnAbl.uuid) && Intrinsics.areEqual((Object) this.scope, (Object) deviceAttributeOnAbl.scope) && Intrinsics.areEqual((Object) this.name, (Object) deviceAttributeOnAbl.name) && Intrinsics.areEqual((Object) this.currentValue, (Object) deviceAttributeOnAbl.currentValue) && Intrinsics.areEqual((Object) this.defaultValue, (Object) deviceAttributeOnAbl.defaultValue);
    }

    public int hashCode() {
        Integer num = this.userId;
        int i = 0;
        int hashCode = (((((((num == null ? 0 : num.hashCode()) * 31) + this.uuid.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.name.hashCode()) * 31;
        String str = this.currentValue;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.defaultValue;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DeviceAttributeOnAbl(userId=" + this.userId + ", uuid=" + this.uuid + ", scope=" + this.scope + ", name=" + this.name + ", currentValue=" + this.currentValue + ", defaultValue=" + this.defaultValue + ')';
    }

    public DeviceAttributeOnAbl(Integer num, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "uuid");
        Intrinsics.checkNotNullParameter(str2, "scope");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.userId = num;
        this.uuid = str;
        this.scope = str2;
        this.name = str3;
        this.currentValue = str4;
        this.defaultValue = str5;
    }

    public final Integer getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceAttributeOnAbl(Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, (i & 4) != 0 ? "device" : str2, str3, str4, str5);
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCurrentValue() {
        return this.currentValue;
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final DeviceAttribute<? extends Object> getParsedAttribute() {
        Timber.Forest forest = Timber.Forest;
        forest.v("Attempting to parse " + this, new Object[0]);
        switch (WhenMappings.$EnumSwitchMapping$0[DeviceAttributeName.Companion.fromName(this.name).ordinal()]) {
            case 1:
                return new DeviceAttribute.Brightness(getIntForAttribute());
            case 2:
                return new DeviceAttribute.FanSpeed(getIntForAttribute());
            case 3:
                return new DeviceAttribute.FilterRemainingMinutes(getIntForAttribute());
            case 4:
                return new DeviceAttribute.ChildLock(getBooleanForAttribute());
            case 5:
                return new DeviceAttribute.DealerCountry(getStringForAttribute());
            case 6:
                return new DeviceAttribute.DealerName(getStringForAttribute());
            case 7:
                return new DeviceAttribute.FanUsage(getStringForAttribute());
            case 8:
                return new DeviceAttribute.Mode(getStringForAttribute());
            case 9:
                return new DeviceAttribute.FilterType(getStringForAttribute());
            case 10:
                return new DeviceAttribute.AutoModeDependency(getStringForAttribute());
            case 11:
                return new DeviceAttribute.PurchaseDate(getStringForAttribute());
            case 12:
                return new DeviceAttribute.SerialNumber(getStringForAttribute());
            case 13:
                return new DeviceAttribute.UnknownAttribute(getStringForAttribute());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean getBooleanForAttribute() {
        return getIntForAttribute() == 1;
    }

    private final String getStringForAttribute() {
        String str = this.currentValue;
        if (str != null) {
            return str;
        }
        String str2 = this.defaultValue;
        return str2 == null ? "" : str2;
    }

    private final int getIntForAttribute() {
        try {
            CharSequence charSequence = this.currentValue;
            if (charSequence == null || charSequence.length() == 0) {
                CharSequence charSequence2 = this.defaultValue;
                if (charSequence2 != null) {
                    if (charSequence2.length() == 0) {
                    }
                }
                return 0;
            }
            String str = this.currentValue;
            if (!(str == null && (str = this.defaultValue) == null)) {
                return Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }

    private final long getLongForAttribute() {
        try {
            CharSequence charSequence = this.currentValue;
            if (charSequence == null || charSequence.length() == 0) {
                CharSequence charSequence2 = this.defaultValue;
                if (charSequence2 != null) {
                    if (charSequence2.length() == 0) {
                    }
                }
                return 0;
            }
            String str = this.currentValue;
            if (!(str == null && (str = this.defaultValue) == null)) {
                return Long.parseLong(str);
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }
}
