package com.blueair.auth;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.blueair.core.util.LocaleUtils;
import com.blueair.core.util.LocationUtils;
import com.blueair.core.util.StringUtils;
import com.foobot.liblabclient.domain.outdoor.CityStation;
import com.gigya.android.sdk.GigyaDefinitions;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mapbox.maps.plugin.scalebar.LocaleUnitResolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005J \u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u0005J\u0010\u0010)\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/blueair/auth/RegionUtils;", "", "<init>", "()V", "BLUEAIR_REGION_CHINA", "", "CHINA", "KOREA", "USA", "EU_CODES", "", "[Ljava/lang/String;", "WYND_CODES", "ECOMMERCE_CODES", "FALLBACK_COUNTRY", "GIGYA_LANG_CHINESE_SIMPLIFIED", "GIGYA_LANG_CHINESE_TRADITIONAL", "formatGigyaLanguageFromLocaleLanguageTag", "langTag", "getCountryCodeFromGigyaRegion", "region", "isEUCountry", "", "countryCode", "isWyndCountry", "isEcommerceCountry", "isGreenRoomAllowed", "getBackupCountryCascading", "context", "Landroid/content/Context;", "getGpsCountry", "getSimCountry", "getResourceConfigCountryOrFallback", "getCountryFromGPS", "getCountryFromSim", "getDynamicLocaleString", "s", "sCN", "locale", "emptyCountryCheck", "country", "isBlueairRegionChina", "checkLocationServicesEnabled", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RegionUtils.kt */
public final class RegionUtils {
    public static final String BLUEAIR_REGION_CHINA = "cn-north-1";
    public static final String CHINA = "cn";
    private static final String[] ECOMMERCE_CODES = {"CZ", "DK", "EE", "ES", "FI", CityStation.GREEN_ROOM, "HR", "IT", "LT", "LV", "PL", "PT", "SE", "UA"};
    private static final String[] EU_CODES = {"AL", "AD", "AM", "AT", "BY", "BE", "BA", "BG", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "FO", "FI", "FR", "GB", "GE", "GI", CityStation.GREEN_ROOM, "HU", "HR", "IE", "IS", "IT", "LT", "LU", "LV", "MC", "MK", "MT", "NO", "NL", "PL", "PT", "RO", "RU", "SE", "SI", "SK", "SM", "TR", "UA", "VA"};
    public static final String FALLBACK_COUNTRY = "gb";
    public static final String GIGYA_LANG_CHINESE_SIMPLIFIED = "zh-cn";
    public static final String GIGYA_LANG_CHINESE_TRADITIONAL = "zh-tw";
    public static final RegionUtils INSTANCE = new RegionUtils();
    public static final String KOREA = "kr";
    public static final String USA = "us";
    private static final String[] WYND_CODES = {"KR", "IN", "JP"};

    private RegionUtils() {
    }

    public final String formatGigyaLanguageFromLocaleLanguageTag(String str) {
        Intrinsics.checkNotNullParameter(str, "langTag");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual((Object) str, (Object) Locale.SIMPLIFIED_CHINESE.toLanguageTag())) {
            return GIGYA_LANG_CHINESE_SIMPLIFIED;
        }
        CharSequence charSequence = lowerCase;
        if (StringsKt.contains$default(charSequence, (CharSequence) "zh", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) "cn", false, 2, (Object) null)) {
            return GIGYA_LANG_CHINESE_SIMPLIFIED;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "zh", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) "hans", false, 2, (Object) null)) {
            return GIGYA_LANG_CHINESE_SIMPLIFIED;
        }
        if (Intrinsics.areEqual((Object) str, (Object) Locale.TRADITIONAL_CHINESE.toLanguageTag())) {
            return GIGYA_LANG_CHINESE_TRADITIONAL;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "zh", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) LocationService.TAIWAN, false, 2, (Object) null)) {
            return GIGYA_LANG_CHINESE_TRADITIONAL;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "zh", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) "hant", false, 2, (Object) null)) {
            return GIGYA_LANG_CHINESE_TRADITIONAL;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "zh", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) LocationService.HONGKONG, false, 2, (Object) null)) {
            return GIGYA_LANG_CHINESE_TRADITIONAL;
        }
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    public final String getCountryCodeFromGigyaRegion(String str) {
        List split$default = str != null ? StringsKt.split$default((CharSequence) str, new String[]{GigyaService.DEFAULT_USER_NAME}, false, 0, 6, (Object) null) : null;
        if (split$default != null) {
            return (String) CollectionsKt.getOrNull(split$default, 0);
        }
        return null;
    }

    private final boolean isEUCountry(String str) {
        String[] strArr = EU_CODES;
        ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(strArr, strArr.length)));
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return arrayList.contains(upperCase);
    }

    private final boolean isWyndCountry(String str) {
        String[] strArr = WYND_CODES;
        ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(strArr, strArr.length)));
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return arrayList.contains(upperCase);
    }

    @JvmStatic
    public static final boolean isEcommerceCountry(String str) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
        String[] strArr = ECOMMERCE_CODES;
        ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(strArr, strArr.length)));
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return arrayList.contains(upperCase);
    }

    public final boolean isGreenRoomAllowed(String str) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return !Intrinsics.areEqual((Object) upperCase, (Object) "CN") && !Intrinsics.areEqual((Object) upperCase, (Object) LocaleUnitResolver.ImperialCountryCode.US) && !Intrinsics.areEqual((Object) upperCase, (Object) "CA") && !isEUCountry(upperCase) && !isWyndCountry(upperCase);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = getSimCountry(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getBackupCountryCascading(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = r1.getGpsCountry(r2)
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = r1.getSimCountry(r2)
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = r1.getResourceConfigCountryOrFallback(r2)
            return r2
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.auth.RegionUtils.getBackupCountryCascading(android.content.Context):java.lang.String");
    }

    public final String getGpsCountry(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String countryFromGPS = getCountryFromGPS(context);
        if (countryFromGPS.length() > 0) {
            return countryFromGPS;
        }
        return null;
    }

    public final String getSimCountry(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String countryFromSim = getCountryFromSim(context);
        if (countryFromSim.length() > 0) {
            return countryFromSim;
        }
        return null;
    }

    public final String getResourceConfigCountryOrFallback(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String nullSafeToLowerCase = StringUtils.INSTANCE.nullSafeToLowerCase(context.getResources().getConfiguration().locale.getCountry());
        return nullSafeToLowerCase.length() > 0 ? nullSafeToLowerCase : FALLBACK_COUNTRY;
    }

    private final String getCountryFromGPS(Context context) {
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        String str = "";
        if (LocationUtils.INSTANCE.isLocationPermissionGranted(context)) {
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            Geocoder geocoder = new Geocoder(context);
            if (lastKnownLocation != null) {
                try {
                    List<Address> fromLocation = geocoder.getFromLocation(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), 1);
                    if (fromLocation != null && fromLocation.size() > 0) {
                        str = StringUtils.INSTANCE.nullSafeToLowerCase(fromLocation.get(0).getCountryCode());
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (IOException e) {
                    e.getMessage();
                }
            } else {
                GpsLocation gpsLocation = new GpsLocation(context);
                try {
                    List<Address> fromLocation2 = geocoder.getFromLocation(gpsLocation.getLatitude$auth_otherRelease(), gpsLocation.getLongitude$auth_otherRelease(), 1);
                    if (fromLocation2 != null && fromLocation2.size() > 0) {
                        str = StringUtils.INSTANCE.nullSafeToLowerCase(fromLocation2.get(0).getCountryCode());
                    }
                    Unit unit2 = Unit.INSTANCE;
                } catch (IOException e2) {
                    e2.getMessage();
                }
            }
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("country from gps: " + str, new Object[0]);
        return str;
    }

    private final String getCountryFromSim(Context context) {
        Object systemService = context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String nullSafeToLowerCase = StringUtils.INSTANCE.nullSafeToLowerCase(((TelephonyManager) systemService).getSimCountryIso());
        Timber.Forest forest = Timber.Forest;
        forest.d("country from sim: " + nullSafeToLowerCase, new Object[0]);
        return nullSafeToLowerCase;
    }

    public final String getDynamicLocaleString(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "s");
        Intrinsics.checkNotNullParameter(str3, GigyaDefinitions.AccountProfileExtraFields.LOCALE);
        return (!Intrinsics.areEqual((Object) str3, (Object) "cn") || str2 == null) ? str : str2;
    }

    public final String getDynamicLocaleString(String str, String str2, Context context) {
        Intrinsics.checkNotNullParameter(str, "s");
        Intrinsics.checkNotNullParameter(context, "context");
        return getDynamicLocaleString(str, str2, LocaleUtils.INSTANCE.getCountryLocale(context));
    }

    public final boolean emptyCountryCheck(String str) {
        if (str == null || str.length() != 0) {
            return str != null && Intrinsics.areEqual((Object) str, (Object) "");
        }
        return true;
    }

    public final boolean isBlueairRegionChina(String str) {
        return Intrinsics.areEqual((Object) str, (Object) "cn-north-1");
    }

    public final boolean checkLocationServicesEnabled(Context context) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        try {
            z = locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            z = false;
        }
        try {
            z2 = locationManager.isProviderEnabled("network");
        } catch (Exception unused2) {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
