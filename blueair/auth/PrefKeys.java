package com.blueair.auth;

import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/auth/PrefKeys;", "", "<init>", "()V", "AppRegionFetched", "", "CloudRegionMismatchChecked", "GigyaServerCountryCode", "RegionCountry", "CountryCodePref", "GigyaCallId", "GigyaUid", "GigyaJwtAuthToken", "AirBoxLabsJwtAuthToken", "AblHomeHostUrl", "BlueHomeDomain", "GigyaBlueHomeDomain", "ForceBlueHomeDomain", "EncryptedEmail", "EncryptedPassword", "AblUser", "AppIdMqtt", "UserIdBlueCloud", "BlueAirLoginDetails", "PushToken", "Language", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PrefKeys {
   public static final String AblHomeHostUrl = "homehost_url_abl";
   public static final String AblUser = "user_abl";
   public static final String AirBoxLabsJwtAuthToken = "abl_jwt_token";
   public static final String AppIdMqtt = "app_id_mqtt";
   public static final String AppRegionFetched = "app_region_fetched_%s";
   public static final String BlueAirLoginDetails = "blueair_login_details";
   public static final String BlueHomeDomain = "domain_blue";
   public static final String CloudRegionMismatchChecked = "cloud_region_mismatch_checked_%s";
   public static final String CountryCodePref = "country_code_pref";
   public static final String EncryptedEmail = "auth_email_encrypted";
   public static final String EncryptedPassword = "auth_password_encrypted";
   public static final String ForceBlueHomeDomain = "force_domain_blue";
   public static final String GigyaBlueHomeDomain = "gigya_domain_blue";
   public static final String GigyaCallId = "gigya_call_id";
   public static final String GigyaJwtAuthToken = "gigya_jwt_auth_token";
   public static final String GigyaServerCountryCode = "gigya_server";
   public static final String GigyaUid = "gigya_uid";
   public static final PrefKeys INSTANCE = new PrefKeys();
   public static final String Language = "language";
   public static final String PushToken = "push_token";
   public static final String RegionCountry = "region_country";
   public static final String UserIdBlueCloud = "user_id_blue_cloud";

   private PrefKeys() {
   }
}
