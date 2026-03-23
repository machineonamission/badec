package io.flatcircle.connectivityhelper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.blueair.bluetooth.espressif.Provision;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¨\u0006\u0016"}, d2 = {"Lio/flatcircle/connectivityhelper/NetUtil;", "", "()V", "getActiveWifiBSSID", "", "context", "Landroid/content/Context;", "getActiveWifiInfo", "Landroid/net/wifi/WifiInfo;", "getActiveWifiSSID", "getWifiInfo", "getWifiInfoInternal", "getWifiInfoPartial", "isProbablyOnline", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "isWifiConnected", "ping", "destination", "timeoutInSeconds", "", "connectivityhelper_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: NetUtil.kt */
public final class NetUtil {
    public static final NetUtil INSTANCE = new NetUtil();

    private NetUtil() {
    }

    public final boolean isProbablyOnline(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return isProbablyOnline((ConnectivityManager) systemService);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final boolean isProbablyOnline(ConnectivityManager connectivityManager) {
        Intrinsics.checkParameterIsNotNull(connectivityManager, "connectivityManager");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final WifiInfo getWifiInfo(Context context) {
        return getWifiInfoPartial(context);
    }

    public final WifiInfo getWifiInfoPartial(Context context) {
        if (context == null) {
            return null;
        }
        return getWifiInfoInternal(context);
    }

    private final WifiInfo getWifiInfoInternal(Context context) {
        Object systemService = context.getApplicationContext().getSystemService(Provision.CONFIG_TRANSPORT_WIFI);
        if (systemService != null) {
            WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
            Intrinsics.checkExpressionValueIsNotNull(connectionInfo, "wifiMgr.connectionInfo");
            return connectionInfo;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    public static /* synthetic */ boolean ping$default(NetUtil netUtil, String str, int i, int i2, Object obj) throws InterruptedException, SecurityException {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return netUtil.ping(str, i);
    }

    public final boolean ping(String str, int i) throws InterruptedException, SecurityException {
        Intrinsics.checkParameterIsNotNull(str, "destination");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("/system/bin/ping -c 3 -W %d %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), str}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            Process exec = Runtime.getRuntime().exec(format);
            int waitFor = exec.waitFor();
            exec.destroy();
            return waitFor == 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isWifiConnected(Context context) {
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network[] allNetworks = connectivityManager.getAllNetworks();
            if (allNetworks != null) {
                if (!(allNetworks.length == 0)) {
                    Collection arrayList = new ArrayList(allNetworks.length);
                    for (Network networkInfo : allNetworks) {
                        arrayList.add(connectivityManager.getNetworkInfo(networkInfo));
                    }
                    Collection arrayList2 = new ArrayList();
                    for (Object next : (List) arrayList) {
                        NetworkInfo networkInfo2 = (NetworkInfo) next;
                        if (networkInfo2 != null && networkInfo2.getType() == 1 && networkInfo2.isConnected()) {
                            arrayList2.add(next);
                        }
                    }
                    if (((List) arrayList2).size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final WifiInfo getActiveWifiInfo(Context context) {
        if (context == null || !isWifiConnected(context)) {
            return null;
        }
        Object systemService = context.getApplicationContext().getSystemService(Provision.CONFIG_TRANSPORT_WIFI);
        if (systemService != null) {
            return ((WifiManager) systemService).getConnectionInfo();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    public final String getActiveWifiSSID(Context context) {
        String ssid;
        WifiInfo activeWifiInfo = getActiveWifiInfo(context);
        if (activeWifiInfo == null || (ssid = activeWifiInfo.getSSID()) == null) {
            return null;
        }
        if (ssid.length() <= 2 || ssid.charAt(0) != '\"' || ssid.charAt(ssid.length() - 1) != '\"') {
            return ssid;
        }
        String substring = ssid.substring(1, ssid.length() - 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String getActiveWifiBSSID(Context context) {
        String bssid;
        WifiInfo activeWifiInfo = getActiveWifiInfo(context);
        if (activeWifiInfo == null || (bssid = activeWifiInfo.getBSSID()) == null) {
            return null;
        }
        return bssid;
    }
}
