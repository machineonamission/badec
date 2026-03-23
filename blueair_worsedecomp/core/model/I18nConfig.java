package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u00018B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010+\u001a\u00020,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020,HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00069"}, d2 = {"Lcom/blueair/core/model/I18nConfig;", "Landroid/os/Parcelable;", "default", "", "en", "fr", "ja", "ko", "es", "sv", "de", "pl", "zhHans", "zhHant", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefault", "()Ljava/lang/String;", "getEn", "getFr", "getJa", "getKo", "getEs", "getSv", "getDe", "getPl", "getZhHans", "getZhHant", "getValue", "locale", "Ljava/util/Locale;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Adapter", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseJsonTypes.kt */
public final class I18nConfig implements Parcelable {
    public static final Parcelable.Creator<I18nConfig> CREATOR = new Creator();

    /* renamed from: de  reason: collision with root package name */
    private final String f84de;

    /* renamed from: default  reason: not valid java name */
    private final String f66default;
    private final String en;
    private final String es;
    private final String fr;
    private final String ja;
    private final String ko;
    private final String pl;
    private final String sv;
    private final String zhHans;
    private final String zhHant;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BaseJsonTypes.kt */
    public static final class Creator implements Parcelable.Creator<I18nConfig> {
        public final I18nConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new I18nConfig(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final I18nConfig[] newArray(int i) {
            return new I18nConfig[i];
        }
    }

    public static /* synthetic */ I18nConfig copy$default(I18nConfig i18nConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = i18nConfig.f66default;
        }
        if ((i & 2) != 0) {
            str2 = i18nConfig.en;
        }
        if ((i & 4) != 0) {
            str3 = i18nConfig.fr;
        }
        if ((i & 8) != 0) {
            str4 = i18nConfig.ja;
        }
        if ((i & 16) != 0) {
            str5 = i18nConfig.ko;
        }
        if ((i & 32) != 0) {
            str6 = i18nConfig.es;
        }
        if ((i & 64) != 0) {
            str7 = i18nConfig.sv;
        }
        if ((i & 128) != 0) {
            str8 = i18nConfig.f84de;
        }
        if ((i & 256) != 0) {
            str9 = i18nConfig.pl;
        }
        if ((i & 512) != 0) {
            str10 = i18nConfig.zhHans;
        }
        if ((i & 1024) != 0) {
            str11 = i18nConfig.zhHant;
        }
        String str12 = str10;
        String str13 = str11;
        String str14 = str8;
        String str15 = str9;
        String str16 = str6;
        String str17 = str7;
        String str18 = str4;
        String str19 = str5;
        return i18nConfig.copy(str, str2, str3, str18, str19, str16, str17, str14, str15, str12, str13);
    }

    public final String component1() {
        return this.f66default;
    }

    public final String component10() {
        return this.zhHans;
    }

    public final String component11() {
        return this.zhHant;
    }

    public final String component2() {
        return this.en;
    }

    public final String component3() {
        return this.fr;
    }

    public final String component4() {
        return this.ja;
    }

    public final String component5() {
        return this.ko;
    }

    public final String component6() {
        return this.es;
    }

    public final String component7() {
        return this.sv;
    }

    public final String component8() {
        return this.f84de;
    }

    public final String component9() {
        return this.pl;
    }

    public final I18nConfig copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, @Json(name = "zh-Hans") String str10, @Json(name = "zh-Hant") String str11) {
        return new I18nConfig(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I18nConfig)) {
            return false;
        }
        I18nConfig i18nConfig = (I18nConfig) obj;
        return Intrinsics.areEqual((Object) this.f66default, (Object) i18nConfig.f66default) && Intrinsics.areEqual((Object) this.en, (Object) i18nConfig.en) && Intrinsics.areEqual((Object) this.fr, (Object) i18nConfig.fr) && Intrinsics.areEqual((Object) this.ja, (Object) i18nConfig.ja) && Intrinsics.areEqual((Object) this.ko, (Object) i18nConfig.ko) && Intrinsics.areEqual((Object) this.es, (Object) i18nConfig.es) && Intrinsics.areEqual((Object) this.sv, (Object) i18nConfig.sv) && Intrinsics.areEqual((Object) this.f84de, (Object) i18nConfig.f84de) && Intrinsics.areEqual((Object) this.pl, (Object) i18nConfig.pl) && Intrinsics.areEqual((Object) this.zhHans, (Object) i18nConfig.zhHans) && Intrinsics.areEqual((Object) this.zhHant, (Object) i18nConfig.zhHant);
    }

    public int hashCode() {
        String str = this.f66default;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.en;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fr;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ja;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ko;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.es;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sv;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f84de;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.pl;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.zhHans;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.zhHant;
        if (str11 != null) {
            i = str11.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "I18nConfig(default=" + this.f66default + ", en=" + this.en + ", fr=" + this.fr + ", ja=" + this.ja + ", ko=" + this.ko + ", es=" + this.es + ", sv=" + this.sv + ", de=" + this.f84de + ", pl=" + this.pl + ", zhHans=" + this.zhHans + ", zhHant=" + this.zhHant + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.f66default);
        parcel.writeString(this.en);
        parcel.writeString(this.fr);
        parcel.writeString(this.ja);
        parcel.writeString(this.ko);
        parcel.writeString(this.es);
        parcel.writeString(this.sv);
        parcel.writeString(this.f84de);
        parcel.writeString(this.pl);
        parcel.writeString(this.zhHans);
        parcel.writeString(this.zhHant);
    }

    public I18nConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, @Json(name = "zh-Hans") String str10, @Json(name = "zh-Hant") String str11) {
        this.f66default = str;
        this.en = str2;
        this.fr = str3;
        this.ja = str4;
        this.ko = str5;
        this.es = str6;
        this.sv = str7;
        this.f84de = str8;
        this.pl = str9;
        this.zhHans = str10;
        this.zhHant = str11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ I18nConfig(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r1 = this;
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r14 = r13 & 4
            if (r14 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r14 = r13 & 8
            if (r14 == 0) goto L_0x0010
            r5 = r0
        L_0x0010:
            r14 = r13 & 16
            if (r14 == 0) goto L_0x0015
            r6 = r0
        L_0x0015:
            r14 = r13 & 32
            if (r14 == 0) goto L_0x001a
            r7 = r0
        L_0x001a:
            r14 = r13 & 64
            if (r14 == 0) goto L_0x001f
            r8 = r0
        L_0x001f:
            r14 = r13 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0024
            r9 = r0
        L_0x0024:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x0029
            r10 = r0
        L_0x0029:
            r14 = r13 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x002e
            r11 = r0
        L_0x002e:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0034
            r13 = r0
            goto L_0x0035
        L_0x0034:
            r13 = r12
        L_0x0035:
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.I18nConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDefault() {
        return this.f66default;
    }

    public final String getEn() {
        return this.en;
    }

    public final String getFr() {
        return this.fr;
    }

    public final String getJa() {
        return this.ja;
    }

    public final String getKo() {
        return this.ko;
    }

    public final String getEs() {
        return this.es;
    }

    public final String getSv() {
        return this.sv;
    }

    public final String getDe() {
        return this.f84de;
    }

    public final String getPl() {
        return this.pl;
    }

    public final String getZhHans() {
        return this.zhHans;
    }

    public final String getZhHant() {
        return this.zhHant;
    }

    public static /* synthetic */ String getValue$default(I18nConfig i18nConfig, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        }
        return i18nConfig.getValue(locale);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getValue(java.util.Locale r4) {
        /*
            r3 = this;
            java.lang.String r0 = "locale"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = r4.getLanguage()
            if (r4 == 0) goto L_0x00d2
            int r0 = r4.hashCode()
            r1 = 3201(0xc81, float:4.486E-42)
            if (r0 == r1) goto L_0x00c6
            r1 = 3241(0xca9, float:4.542E-42)
            if (r0 == r1) goto L_0x00ba
            r1 = 3246(0xcae, float:4.549E-42)
            if (r0 == r1) goto L_0x00ae
            r1 = 3276(0xccc, float:4.59E-42)
            if (r0 == r1) goto L_0x00a2
            r1 = 3383(0xd37, float:4.74E-42)
            if (r0 == r1) goto L_0x0096
            r1 = 3428(0xd64, float:4.804E-42)
            if (r0 == r1) goto L_0x008a
            r1 = 3580(0xdfc, float:5.017E-42)
            if (r0 == r1) goto L_0x007e
            r1 = 3683(0xe63, float:5.161E-42)
            if (r0 == r1) goto L_0x0072
            r1 = 3886(0xf2e, float:5.445E-42)
            if (r0 == r1) goto L_0x0035
            goto L_0x00d2
        L_0x0035:
            java.lang.String r0 = "zh"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x003f
            goto L_0x00d2
        L_0x003f:
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.toLanguageTag()
            int r0 = r4.length()
            java.lang.String r1 = "zh-Hans"
            r2 = 7
            if (r0 < r2) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r0 = 0
            java.lang.String r4 = r4.substring(r0, r2)
            java.lang.String r0 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            goto L_0x005f
        L_0x005e:
            r4 = r1
        L_0x005f:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0 = 1
            boolean r4 = kotlin.text.StringsKt.contentEquals(r4, r1, r0)
            if (r4 == 0) goto L_0x006e
            java.lang.String r4 = r3.zhHans
            goto L_0x00d4
        L_0x006e:
            java.lang.String r4 = r3.zhHant
            goto L_0x00d4
        L_0x0072:
            java.lang.String r0 = "sv"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x007b
            goto L_0x00d2
        L_0x007b:
            java.lang.String r4 = r3.sv
            goto L_0x00d4
        L_0x007e:
            java.lang.String r0 = "pl"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0087
            goto L_0x00d2
        L_0x0087:
            java.lang.String r4 = r3.pl
            goto L_0x00d4
        L_0x008a:
            java.lang.String r0 = "ko"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0093
            goto L_0x00d2
        L_0x0093:
            java.lang.String r4 = r3.ko
            goto L_0x00d4
        L_0x0096:
            java.lang.String r0 = "ja"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x009f
            goto L_0x00d2
        L_0x009f:
            java.lang.String r4 = r3.ja
            goto L_0x00d4
        L_0x00a2:
            java.lang.String r0 = "fr"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00ab
            goto L_0x00d2
        L_0x00ab:
            java.lang.String r4 = r3.fr
            goto L_0x00d4
        L_0x00ae:
            java.lang.String r0 = "es"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00b7
            goto L_0x00d2
        L_0x00b7:
            java.lang.String r4 = r3.es
            goto L_0x00d4
        L_0x00ba:
            java.lang.String r0 = "en"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00c3
            goto L_0x00d2
        L_0x00c3:
            java.lang.String r4 = r3.en
            goto L_0x00d4
        L_0x00c6:
            java.lang.String r0 = "de"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x00cf
            goto L_0x00d2
        L_0x00cf:
            java.lang.String r4 = r3.f84de
            goto L_0x00d4
        L_0x00d2:
            java.lang.String r4 = r3.f66default
        L_0x00d4:
            if (r4 != 0) goto L_0x00d8
            java.lang.String r4 = r3.f66default
        L_0x00d8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.I18nConfig.getValue(java.util.Locale):java.lang.String");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0017J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0017R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/I18nConfig$Adapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/blueair/core/model/I18nConfig;", "<init>", "()V", "adapter", "kotlin.jvm.PlatformType", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BaseJsonTypes.kt */
    public static final class Adapter extends JsonAdapter<I18nConfig> {
        public static final Adapter INSTANCE = new Adapter();
        private static final JsonAdapter<I18nConfig> adapter = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(I18nConfig.class);

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: BaseJsonTypes.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.squareup.moshi.JsonReader$Token[] r0 = com.squareup.moshi.JsonReader.Token.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.STRING     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.I18nConfig.Adapter.WhenMappings.<clinit>():void");
            }
        }

        private Adapter() {
        }

        @FromJson
        public I18nConfig fromJson(JsonReader jsonReader) {
            Intrinsics.checkNotNullParameter(jsonReader, "reader");
            JsonReader.Token peek = jsonReader.peek();
            int i = peek == null ? -1 : WhenMappings.$EnumSwitchMapping$0[peek.ordinal()];
            if (i == 1) {
                return adapter.fromJson(jsonReader);
            }
            if (i != 2) {
                return null;
            }
            return new I18nConfig(jsonReader.nextString(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null);
        }

        @ToJson
        public void toJson(JsonWriter jsonWriter, I18nConfig i18nConfig) {
            Intrinsics.checkNotNullParameter(jsonWriter, "writer");
            adapter.toJson(jsonWriter, i18nConfig);
        }
    }
}
