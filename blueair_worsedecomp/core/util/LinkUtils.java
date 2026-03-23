package com.blueair.core.util;

import com.blueair.android.fragment.IndoorFragment;
import com.blueair.auth.LocationService;
import com.foobot.liblabclient.domain.Attribute;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0005J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/util/LinkUtils;", "", "<init>", "()V", "webLinks", "", "", "init", "", "getVisitBlueairLinkFromCountryCode", "countryCode", "getPrivacyLinkFromCountryCode", "getTermsLink", "getSharedSdkInfoLink", "getConnectionTroubleShootingLink", "getSupportLink", "getBlueairStoreLink", "getWarrantyLink", "gigyaToken", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LinkUtils.kt */
public final class LinkUtils {
    public static final LinkUtils INSTANCE = new LinkUtils();
    private static Map<String, ? extends Map<String, String>> webLinks = MapsKt.emptyMap();

    private LinkUtils() {
    }

    public final void init(Map<String, ? extends Map<String, String>> map) {
        Intrinsics.checkNotNullParameter(map, "webLinks");
        webLinks = map;
    }

    public final String getVisitBlueairLinkFromCountryCode(String str) {
        String str2;
        Map map = (Map) webLinks.get("visit_blueair");
        if (map != null && (str2 = (String) map.get(str)) != null) {
            return str2;
        }
        String str3 = map != null ? (String) map.get(Attribute.DEF_VAL_TYPE) : null;
        return str3 == null ? IndoorFragment.BLUEAIR_URL : str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r3 = (java.lang.String) r0.get(com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.TYPE_NULL);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPrivacyLinkFromCountryCode(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> r0 = webLinks
            java.lang.String r1 = "privacy"
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
            if (r3 != 0) goto L_0x001d
            if (r0 == 0) goto L_0x001a
            java.lang.String r3 = "null"
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            return r3
        L_0x001a:
            java.lang.String r3 = "https://www.blueair.com/en-ae/privacy-notice.html"
            return r3
        L_0x001d:
            if (r0 == 0) goto L_0x0029
            java.lang.Object r1 = r0.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            return r1
        L_0x0029:
            if (r0 == 0) goto L_0x0034
            java.lang.String r1 = "default"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            if (r0 != 0) goto L_0x0056
            java.lang.String r0 = "cn"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0042
            java.lang.String r3 = "https://www.blueair.cn/yin-si-bao-hu-zhun-ze.html"
            return r3
        L_0x0042:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "https://www.blueair.com/"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = "/privacy-notice.html"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.LinkUtils.getPrivacyLinkFromCountryCode(java.lang.String):java.lang.String");
    }

    public final String getTermsLink(String str) {
        String str2;
        Map map = (Map) webLinks.get("terms");
        if (map != null && (str2 = (String) map.get(str)) != null) {
            return str2;
        }
        String str3 = map != null ? (String) map.get(Attribute.DEF_VAL_TYPE) : null;
        if (str3 != null) {
            return str3;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "cn")) {
            return "https://www.blueair.cn/wang-zhan-shi-yong-tiao-kuan.html";
        }
        if (Intrinsics.areEqual((Object) str, (Object) LocationService.JAPAN)) {
            return "https://www.blueair.jp/support/terms/";
        }
        return "https://www.blueair.com/" + str + "/terms-of-use.html";
    }

    public final String getSharedSdkInfoLink(String str) {
        String str2;
        Map map = (Map) webLinks.get("shared_sdk_info");
        if (map != null && (str2 = (String) map.get(str)) != null) {
            return str2;
        }
        String str3 = map != null ? (String) map.get(Attribute.DEF_VAL_TYPE) : null;
        return str3 == null ? "https://www.blueair.cn/yin-si-bao-hu-zhun-ze.html#sdk" : str3;
    }

    public final String getConnectionTroubleShootingLink(String str) {
        String str2;
        Map map = (Map) webLinks.get("troubleshooting_onboarding");
        if (map != null && (str2 = (String) map.get(str)) != null) {
            return str2;
        }
        String str3 = map != null ? (String) map.get(Attribute.DEF_VAL_TYPE) : null;
        if (str3 != null) {
            return str3;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3179) {
                if (hashCode != 3398) {
                    if (hashCode == 3742 && str.equals("us")) {
                        return "https://www.blueair.com/us/troubleshooting.html";
                    }
                } else if (str.equals(LocationService.JAPAN)) {
                    return "https://www.blueair.jp/support";
                }
            } else if (str.equals("cn")) {
                return "https://www.blueair.cn/help/blueair-app-instructions.html";
            }
        }
        return "https://www.blueair.com/" + str + "/connection-issues.html";
    }

    public final String getSupportLink(String str) {
        String str2;
        Map map = (Map) webLinks.get("customer_support");
        if (map != null && (str2 = (String) map.get(str)) != null) {
            return str2;
        }
        String str3 = map != null ? (String) map.get(Attribute.DEF_VAL_TYPE) : null;
        if (str3 != null) {
            return str3;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "cn")) {
            return "https://www.blueair.cn/help.html";
        }
        if (Intrinsics.areEqual((Object) str, (Object) LocationService.JAPAN)) {
            return "https://www.blueair.jp/support";
        }
        return "https://www.blueair.com/" + str + "/customer-support.html";
    }

    public final String getBlueairStoreLink(String str) {
        String str2;
        Map map = (Map) webLinks.get("blueair_store");
        if (map != null && (str2 = (String) map.get(str)) != null) {
            return str2;
        }
        String str3 = map != null ? (String) map.get(Attribute.DEF_VAL_TYPE) : null;
        if (str3 != null) {
            return str3;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3179) {
                if (hashCode != 3398) {
                    if (hashCode == 3742 && str.equals("us")) {
                        return "https://www.blueair.com/us/air-purifiers?utm_source=App&utm_medium=Buylink&utm_campaign=blueair_app";
                    }
                } else if (str.equals(LocationService.JAPAN)) {
                    return "https://www.blueair.jp/products";
                }
            } else if (str.equals("cn")) {
                return "https://www.blueair.cn/air-purifier.html";
            }
        }
        return "https://www.blueair.com/" + str + "/air-purifiers";
    }

    public static /* synthetic */ String getWarrantyLink$default(LinkUtils linkUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = Locale.getDefault().getCountry();
            Intrinsics.checkNotNullExpressionValue(str2, "getCountry(...)");
        }
        return linkUtils.getWarrantyLink(str, str2);
    }

    public final String getWarrantyLink(String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "gigyaToken");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
        Map map = (Map) webLinks.get("warranty");
        if (map == null || (str3 = (String) map.get(Attribute.DEF_VAL_TYPE)) == null) {
            str3 = "https://acct66616.extforms.netsuite.com/app/site/hosting/scriptlet.nl?script=519&deploy=1&compid=ACCT66616&ns-at=AAEJ7tMQfmeSpphDO4_M48rMl7P3e-0Rwps7QbIZuGMpoDxuZv0&idtoken=%s&country=%s";
        }
        String upperCase = str2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String format = String.format(str3, Arrays.copyOf(new Object[]{str, upperCase}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
