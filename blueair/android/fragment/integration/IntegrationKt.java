package com.blueair.android.fragment.integration;

import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"},
   d2 = {"amazonAlexaSupportedDevices", "", "Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "tmallSupportedDevices", "app_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class IntegrationKt {
   private static final List amazonAlexaSupportedDevices;
   private static final List tmallSupportedDevices;

   static {
      amazonAlexaSupportedDevices = CollectionsKt.listOf(new IotDeviceConfig[]{new IotDeviceConfig("https://www.amazon.com/Blueair-AB-Aware/dp/B06Y27M8WX", R.string.blueair_aware, com.blueair.android.R.drawable.ic_device_aware), new IotDeviceConfig("https://www.amazon.com/Blueair-AB-Sense/dp/B06Y2B14RF", R.string.blueair_sense, com.blueair.android.R.drawable.ic_device_sense), new IotDeviceConfig("https://www.amazon.com/Blueair-AB-Custom-Skill/dp/B07B2Z1Q6S", R.string.blueair_classic_i, com.blueair.android.R.drawable.ic_device_classic), new IotDeviceConfig("https://www.amazon.com/Blueair-AB-Custom-Skill/dp/B07B2Z1Q6S", R.string.blueair_classic_05, com.blueair.android.R.drawable.ic_device_classic)});
      tmallSupportedDevices = CollectionsKt.listOf(new IotDeviceConfig[]{new IotDeviceConfig("https://google.com", R.string.blueair_b4, com.blueair.android.R.drawable.ic_b4), new IotDeviceConfig("https://google.com", R.string.blueair_g4, com.blueair.android.R.drawable.ic_g4)});
   }

   // $FF: synthetic method
   public static final List access$getAmazonAlexaSupportedDevices$p() {
      return amazonAlexaSupportedDevices;
   }

   // $FF: synthetic method
   public static final List access$getTmallSupportedDevices$p() {
      return tmallSupportedDevices;
   }
}
