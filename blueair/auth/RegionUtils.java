package com.blueair.auth;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import com.blueair.core.util.LocaleUtils;
import com.blueair.core.util.LocationUtils;
import com.blueair.core.util.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005J \u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u0005J\u0010\u0010)\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"},
   d2 = {"Lcom/blueair/auth/RegionUtils;", "", "<init>", "()V", "BLUEAIR_REGION_CHINA", "", "CHINA", "KOREA", "USA", "EU_CODES", "", "[Ljava/lang/String;", "WYND_CODES", "ECOMMERCE_CODES", "FALLBACK_COUNTRY", "GIGYA_LANG_CHINESE_SIMPLIFIED", "GIGYA_LANG_CHINESE_TRADITIONAL", "formatGigyaLanguageFromLocaleLanguageTag", "langTag", "getCountryCodeFromGigyaRegion", "region", "isEUCountry", "", "countryCode", "isWyndCountry", "isEcommerceCountry", "isGreenRoomAllowed", "getBackupCountryCascading", "context", "Landroid/content/Context;", "getGpsCountry", "getSimCountry", "getResourceConfigCountryOrFallback", "getCountryFromGPS", "getCountryFromSim", "getDynamicLocaleString", "s", "sCN", "locale", "emptyCountryCheck", "country", "isBlueairRegionChina", "checkLocationServicesEnabled", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RegionUtils {
   public static final String BLUEAIR_REGION_CHINA = "cn-north-1";
   public static final String CHINA = "cn";
   private static final String[] ECOMMERCE_CODES = new String[]{"CZ", "DK", "EE", "ES", "FI", "GR", "HR", "IT", "LT", "LV", "PL", "PT", "SE", "UA"};
   private static final String[] EU_CODES = new String[]{"AL", "AD", "AM", "AT", "BY", "BE", "BA", "BG", "CH", "CY", "CZ", "DE", "DK", "EE", "ES", "FO", "FI", "FR", "GB", "GE", "GI", "GR", "HU", "HR", "IE", "IS", "IT", "LT", "LU", "LV", "MC", "MK", "MT", "NO", "NL", "PL", "PT", "RO", "RU", "SE", "SI", "SK", "SM", "TR", "UA", "VA"};
   public static final String FALLBACK_COUNTRY = "gb";
   public static final String GIGYA_LANG_CHINESE_SIMPLIFIED = "zh-cn";
   public static final String GIGYA_LANG_CHINESE_TRADITIONAL = "zh-tw";
   public static final RegionUtils INSTANCE = new RegionUtils();
   public static final String KOREA = "kr";
   public static final String USA = "us";
   private static final String[] WYND_CODES = new String[]{"KR", "IN", "JP"};

   private RegionUtils() {
   }

   private final String getCountryFromGPS(Context var1) {
      Object var3 = var1.getSystemService("location");
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.location.LocationManager");
      LocationManager var5 = (LocationManager)var3;
      boolean var2 = LocationUtils.INSTANCE.isLocationPermissionGranted(var1);
      String var17 = "";
      String var4 = var17;
      if (var2) {
         Location var24 = var5.getLastKnownLocation("gps");
         Geocoder var23 = new Geocoder(var1);
         if (var24 != null) {
            label87: {
               String var14 = var17;

               IOException var10000;
               label88: {
                  try {
                     var25 = var23.getFromLocation(var24.getLatitude(), var24.getLongitude(), 1);
                  } catch (IOException var13) {
                     var10000 = var13;
                     boolean var10001 = false;
                     break label88;
                  }

                  var4 = var17;
                  if (var25 != null) {
                     label89: {
                        var4 = var17;
                        var14 = var17;

                        try {
                           if (var25.size() <= 0) {
                              break label89;
                           }
                        } catch (IOException var12) {
                           var10000 = var12;
                           boolean var29 = false;
                           break label88;
                        }

                        var14 = var17;

                        try {
                           var4 = StringUtils.INSTANCE.nullSafeToLowerCase(((Address)var25.get(0)).getCountryCode());
                        } catch (IOException var11) {
                           var10000 = var11;
                           boolean var30 = false;
                           break label88;
                        }
                     }
                  }

                  var14 = var4;

                  try {
                     Unit var19 = Unit.INSTANCE;
                     break label87;
                  } catch (IOException var10) {
                     var10000 = var10;
                     boolean var31 = false;
                  }
               }

               IOException var18 = var10000;
               var18.getMessage();
               var4 = var14;
            }
         } else {
            label90: {
               GpsLocation var26 = new GpsLocation(var1);
               String var15 = var17;

               IOException var28;
               label91: {
                  try {
                     var27 = var23.getFromLocation(var26.getLatitude$auth_otherRelease(), var26.getLongitude$auth_otherRelease(), 1);
                  } catch (IOException var9) {
                     var28 = var9;
                     boolean var32 = false;
                     break label91;
                  }

                  var4 = var17;
                  if (var27 != null) {
                     label92: {
                        var4 = var17;
                        var15 = var17;

                        try {
                           if (var27.size() <= 0) {
                              break label92;
                           }
                        } catch (IOException var8) {
                           var28 = var8;
                           boolean var33 = false;
                           break label91;
                        }

                        var15 = var17;

                        try {
                           var4 = StringUtils.INSTANCE.nullSafeToLowerCase(((Address)var27.get(0)).getCountryCode());
                        } catch (IOException var7) {
                           var28 = var7;
                           boolean var34 = false;
                           break label91;
                        }
                     }
                  }

                  var15 = var4;

                  try {
                     Unit var21 = Unit.INSTANCE;
                     break label90;
                  } catch (IOException var6) {
                     var28 = var6;
                     boolean var35 = false;
                  }
               }

               IOException var20 = var28;
               var20.getMessage();
               var4 = var15;
            }
         }
      }

      Timber.Forest var22 = Timber.Forest;
      StringBuilder var16 = new StringBuilder("country from gps: ");
      var16.append(var4);
      var22.d(var16.toString(), new Object[0]);
      return var4;
   }

   private final String getCountryFromSim(Context var1) {
      Object var4 = var1.getSystemService("phone");
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type android.telephony.TelephonyManager");
      TelephonyManager var5 = (TelephonyManager)var4;
      String var2 = StringUtils.INSTANCE.nullSafeToLowerCase(var5.getSimCountryIso());
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("country from sim: ");
      var3.append(var2);
      var6.d(var3.toString(), new Object[0]);
      return var2;
   }

   private final boolean isEUCountry(String var1) {
      String[] var2 = EU_CODES;
      ArrayList var4 = new ArrayList((Collection)Arrays.asList(Arrays.copyOf(var2, var2.length)));
      var1 = var1.toUpperCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var1, "toUpperCase(...)");
      return var4.contains(var1);
   }

   @JvmStatic
   public static final boolean isEcommerceCountry(String var0) {
      Intrinsics.checkNotNullParameter(var0, "countryCode");
      String[] var1 = ECOMMERCE_CODES;
      ArrayList var3 = new ArrayList((Collection)Arrays.asList(Arrays.copyOf(var1, var1.length)));
      var0 = var0.toUpperCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var0, "toUpperCase(...)");
      return var3.contains(var0);
   }

   private final boolean isWyndCountry(String var1) {
      String[] var2 = WYND_CODES;
      ArrayList var4 = new ArrayList((Collection)Arrays.asList(Arrays.copyOf(var2, var2.length)));
      var1 = var1.toUpperCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var1, "toUpperCase(...)");
      return var4.contains(var1);
   }

   public final boolean checkLocationServicesEnabled(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Object var9 = var1.getSystemService("location");
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type android.location.LocationManager");
      LocationManager var10 = (LocationManager)var9;
      boolean var5 = false;

      boolean var2;
      try {
         var2 = var10.isProviderEnabled("gps");
      } catch (Exception var8) {
         var2 = false;
      }

      boolean var4;
      try {
         var4 = var10.isProviderEnabled("network");
      } catch (Exception var7) {
         var4 = false;
      }

      boolean var3 = var5;
      if (var2) {
         var3 = var5;
         if (var4) {
            var3 = true;
         }
      }

      return var3;
   }

   public final boolean emptyCountryCheck(String var1) {
      return var1 != null && ((CharSequence)var1).length() == 0 || var1 != null && Intrinsics.areEqual(var1, "");
   }

   public final String formatGigyaLanguageFromLocaleLanguageTag(String var1) {
      Intrinsics.checkNotNullParameter(var1, "langTag");
      String var2 = var1.toLowerCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var2, "toLowerCase(...)");
      if (!Intrinsics.areEqual(var1, Locale.SIMPLIFIED_CHINESE.toLanguageTag())) {
         CharSequence var4 = (CharSequence)var2;
         if ((!StringsKt.contains$default(var4, (CharSequence)"zh", false, 2, (Object)null) || !StringsKt.contains$default(var4, (CharSequence)"cn", false, 2, (Object)null)) && (!StringsKt.contains$default(var4, (CharSequence)"zh", false, 2, (Object)null) || !StringsKt.contains$default(var4, (CharSequence)"hans", false, 2, (Object)null))) {
            if (Intrinsics.areEqual(var1, Locale.TRADITIONAL_CHINESE.toLanguageTag()) || StringsKt.contains$default(var4, (CharSequence)"zh", false, 2, (Object)null) && StringsKt.contains$default(var4, (CharSequence)"tw", false, 2, (Object)null) || StringsKt.contains$default(var4, (CharSequence)"zh", false, 2, (Object)null) && StringsKt.contains$default(var4, (CharSequence)"hant", false, 2, (Object)null) || StringsKt.contains$default(var4, (CharSequence)"zh", false, 2, (Object)null) && StringsKt.contains$default(var4, (CharSequence)"hk", false, 2, (Object)null)) {
               return "zh-tw";
            }

            var1 = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(var1, "getLanguage(...)");
            return var1;
         }
      }

      return "zh-cn";
   }

   public final String getBackupCountryCascading(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String var3 = this.getGpsCountry(var1);
      String var2 = var3;
      if (var3 == null) {
         var3 = this.getSimCountry(var1);
         var2 = var3;
         if (var3 == null) {
            return this.getResourceConfigCountryOrFallback(var1);
         }
      }

      return var2;
   }

   public final String getCountryCodeFromGigyaRegion(String var1) {
      List var2;
      if (var1 != null) {
         var2 = StringsKt.split$default((CharSequence)var1, new String[]{"-"}, false, 0, 6, (Object)null);
      } else {
         var2 = null;
      }

      return var2 != null ? (String)CollectionsKt.getOrNull(var2, 0) : null;
   }

   public final String getDynamicLocaleString(String var1, String var2, Context var3) {
      Intrinsics.checkNotNullParameter(var1, "s");
      Intrinsics.checkNotNullParameter(var3, "context");
      return this.getDynamicLocaleString(var1, var2, LocaleUtils.INSTANCE.getCountryLocale(var3));
   }

   public final String getDynamicLocaleString(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "s");
      Intrinsics.checkNotNullParameter(var3, "locale");
      return Intrinsics.areEqual(var3, "cn") && var2 != null ? var2 : var1;
   }

   public final String getGpsCountry(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2 = this.getCountryFromGPS(var1);
      return ((CharSequence)var2).length() > 0 ? var2 : null;
   }

   public final String getResourceConfigCountryOrFallback(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2 = StringUtils.INSTANCE.nullSafeToLowerCase(var1.getResources().getConfiguration().locale.getCountry());
      return ((CharSequence)var2).length() > 0 ? var2 : "gb";
   }

   public final String getSimCountry(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2 = this.getCountryFromSim(var1);
      return ((CharSequence)var2).length() > 0 ? var2 : null;
   }

   public final boolean isBlueairRegionChina(String var1) {
      return Intrinsics.areEqual(var1, "cn-north-1");
   }

   public final boolean isGreenRoomAllowed(String var1) {
      Intrinsics.checkNotNullParameter(var1, "countryCode");
      var1 = var1.toUpperCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var1, "toUpperCase(...)");
      return !Intrinsics.areEqual(var1, "CN") && !Intrinsics.areEqual(var1, "US") && !Intrinsics.areEqual(var1, "CA") && !this.isEUCountry(var1) && !this.isWyndCountry(var1);
   }
}
