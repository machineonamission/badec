package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jq\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/blueair/api/restapi/ConfigurationAutoMode;", "", "p", "", "a", "tf", "", "e", "ot", "autoModeTrigger", "nightModeTrigger", "tn", "n", "fe", "<init>", "(ZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getP", "()Z", "getA", "getTf", "()Ljava/lang/String;", "getE", "getOt", "getAutoModeTrigger", "getNightModeTrigger", "getTn", "getN", "getFe", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class ConfigurationAutoMode {
    private final boolean a;
    private final String autoModeTrigger;
    private final boolean e;
    private final boolean fe;
    private final String n;
    private final String nightModeTrigger;
    private final String ot;
    private final boolean p;
    private final String tf;
    private final String tn;

    public static /* synthetic */ ConfigurationAutoMode copy$default(ConfigurationAutoMode configurationAutoMode, boolean z, boolean z2, String str, boolean z3, String str2, String str3, String str4, String str5, String str6, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = configurationAutoMode.p;
        }
        if ((i & 2) != 0) {
            z2 = configurationAutoMode.a;
        }
        if ((i & 4) != 0) {
            str = configurationAutoMode.tf;
        }
        if ((i & 8) != 0) {
            z3 = configurationAutoMode.e;
        }
        if ((i & 16) != 0) {
            str2 = configurationAutoMode.ot;
        }
        if ((i & 32) != 0) {
            str3 = configurationAutoMode.autoModeTrigger;
        }
        if ((i & 64) != 0) {
            str4 = configurationAutoMode.nightModeTrigger;
        }
        if ((i & 128) != 0) {
            str5 = configurationAutoMode.tn;
        }
        if ((i & 256) != 0) {
            str6 = configurationAutoMode.n;
        }
        if ((i & 512) != 0) {
            z4 = configurationAutoMode.fe;
        }
        String str7 = str6;
        boolean z5 = z4;
        String str8 = str4;
        String str9 = str5;
        String str10 = str2;
        String str11 = str3;
        boolean z6 = z3;
        boolean z7 = z2;
        return configurationAutoMode.copy(z, z7, str, z6, str10, str11, str8, str9, str7, z5);
    }

    public final boolean component1() {
        return this.p;
    }

    public final boolean component10() {
        return this.fe;
    }

    public final boolean component2() {
        return this.a;
    }

    public final String component3() {
        return this.tf;
    }

    public final boolean component4() {
        return this.e;
    }

    public final String component5() {
        return this.ot;
    }

    public final String component6() {
        return this.autoModeTrigger;
    }

    public final String component7() {
        return this.nightModeTrigger;
    }

    public final String component8() {
        return this.tn;
    }

    public final String component9() {
        return this.n;
    }

    public final ConfigurationAutoMode copy(boolean z, boolean z2, String str, boolean z3, String str2, @Json(name = "amt") String str3, @Json(name = "nmt") String str4, String str5, String str6, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "tf");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "ot");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "tn");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "n");
        return new ConfigurationAutoMode(z, z2, str, z3, str7, str3, str4, str8, str9, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigurationAutoMode)) {
            return false;
        }
        ConfigurationAutoMode configurationAutoMode = (ConfigurationAutoMode) obj;
        return this.p == configurationAutoMode.p && this.a == configurationAutoMode.a && Intrinsics.areEqual((Object) this.tf, (Object) configurationAutoMode.tf) && this.e == configurationAutoMode.e && Intrinsics.areEqual((Object) this.ot, (Object) configurationAutoMode.ot) && Intrinsics.areEqual((Object) this.autoModeTrigger, (Object) configurationAutoMode.autoModeTrigger) && Intrinsics.areEqual((Object) this.nightModeTrigger, (Object) configurationAutoMode.nightModeTrigger) && Intrinsics.areEqual((Object) this.tn, (Object) configurationAutoMode.tn) && Intrinsics.areEqual((Object) this.n, (Object) configurationAutoMode.n) && this.fe == configurationAutoMode.fe;
    }

    public int hashCode() {
        int m = ((((((((AddDeviceState$$ExternalSyntheticBackport0.m(this.p) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.a)) * 31) + this.tf.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.e)) * 31) + this.ot.hashCode()) * 31;
        String str = this.autoModeTrigger;
        int i = 0;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nightModeTrigger;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.tn.hashCode()) * 31) + this.n.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.fe);
    }

    public String toString() {
        return "ConfigurationAutoMode(p=" + this.p + ", a=" + this.a + ", tf=" + this.tf + ", e=" + this.e + ", ot=" + this.ot + ", autoModeTrigger=" + this.autoModeTrigger + ", nightModeTrigger=" + this.nightModeTrigger + ", tn=" + this.tn + ", n=" + this.n + ", fe=" + this.fe + ')';
    }

    public ConfigurationAutoMode(boolean z, boolean z2, String str, boolean z3, String str2, @Json(name = "amt") String str3, @Json(name = "nmt") String str4, String str5, String str6, boolean z4) {
        Intrinsics.checkNotNullParameter(str, "tf");
        Intrinsics.checkNotNullParameter(str2, "ot");
        Intrinsics.checkNotNullParameter(str5, "tn");
        Intrinsics.checkNotNullParameter(str6, "n");
        this.p = z;
        this.a = z2;
        this.tf = str;
        this.e = z3;
        this.ot = str2;
        this.autoModeTrigger = str3;
        this.nightModeTrigger = str4;
        this.tn = str5;
        this.n = str6;
        this.fe = z4;
    }

    public final boolean getP() {
        return this.p;
    }

    public final boolean getA() {
        return this.a;
    }

    public final String getTf() {
        return this.tf;
    }

    public final boolean getE() {
        return this.e;
    }

    public final String getOt() {
        return this.ot;
    }

    public final String getAutoModeTrigger() {
        return this.autoModeTrigger;
    }

    public final String getNightModeTrigger() {
        return this.nightModeTrigger;
    }

    public final String getTn() {
        return this.tn;
    }

    public final String getN() {
        return this.n;
    }

    public final boolean getFe() {
        return this.fe;
    }
}
