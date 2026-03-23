package com.blueair.adddevice;

import android.content.Context;
import com.hiflying.smartlink.OnSmartLinkListener;
import com.hiflying.smartlink.SmartLinkedModule;
import com.hiflying.smartlink.v7.MulticastSmartLinker;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/adddevice/DevicePairManager;", "", "<init>", "()V", "LOG_TAG", "", "kotlin.jvm.PlatformType", "BROKEN_LIB_MAC_TEST", "DEFAULT_SMARTLINKER_UUID", "kDeviceServerIP", "kDeviceServerPort", "", "kReadTimeout", "smartLinkerAttempt", "mDeviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "performAutomaticPairing", "", "context", "Landroid/content/Context;", "networkSSID", "networkPassPhrase", "autoPairingListener", "Lcom/blueair/adddevice/DevicePairManager$AutoPairingListener;", "performManualPairing", "onLinked", "smartLinkedModule", "Lcom/hiflying/smartlink/SmartLinkedModule;", "AutoPairingListener", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevicePairManager.kt */
public final class DevicePairManager {
    private static final String BROKEN_LIB_MAC_TEST = ";";
    public static final String DEFAULT_SMARTLINKER_UUID = "LPB100";
    public static final DevicePairManager INSTANCE = new DevicePairManager();
    private static final String LOG_TAG = "DevicePairManager";
    private static final String kDeviceServerIP = "10.10.100.254";
    private static final int kDeviceServerPort = 1337;
    private static final int kReadTimeout = 30000;
    private static DeviceInformationLegacy mDeviceInformation;
    /* access modifiers changed from: private */
    public static int smartLinkerAttempt;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/adddevice/DevicePairManager$AutoPairingListener;", "", "onCompleted", "", "deviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DevicePairManager.kt */
    public interface AutoPairingListener {
        void onCompleted(DeviceInformationLegacy deviceInformationLegacy);
    }

    private DevicePairManager() {
    }

    public final void performAutomaticPairing(Context context, String str, String str2, AutoPairingListener autoPairingListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "networkSSID");
        Intrinsics.checkNotNullParameter(str2, "networkPassPhrase");
        Intrinsics.checkNotNullParameter(autoPairingListener, "autoPairingListener");
        Timber.Forest.d("performAutomaticPairing()", new Object[0]);
        MulticastSmartLinker instance = MulticastSmartLinker.getInstance();
        instance.setMixType(1);
        instance.setTimeoutPeriod(30000);
        DevicePairManager$$ExternalSyntheticLambda0 devicePairManager$$ExternalSyntheticLambda0 = new DevicePairManager$$ExternalSyntheticLambda0(instance);
        instance.setOnSmartLinkListener(new DevicePairManager$performAutomaticPairing$1(devicePairManager$$ExternalSyntheticLambda0, autoPairingListener));
        try {
            instance.start(context, str2, str);
        } catch (Throwable th) {
            Timber.Forest.e(th);
            devicePairManager$$ExternalSyntheticLambda0.invoke();
            autoPairingListener.onCompleted((DeviceInformationLegacy) null);
        }
    }

    /* access modifiers changed from: private */
    public static final Unit performAutomaticPairing$lambda$0(MulticastSmartLinker multicastSmartLinker) {
        multicastSmartLinker.setOnSmartLinkListener((OnSmartLinkListener) null);
        multicastSmartLinker.stop();
        return Unit.INSTANCE;
    }

    public final DeviceInformationLegacy performManualPairing(String str, String str2) {
        String readMessage;
        List list;
        Intrinsics.checkNotNullParameter(str, "networkSSID");
        Intrinsics.checkNotNullParameter(str2, "networkPassPhrase");
        Timber.Forest.d("performManualPairing()", new Object[0]);
        mDeviceInformation = null;
        NetworkTCPTextClient networkTCPTextClient = new NetworkTCPTextClient(kDeviceServerIP, kDeviceServerPort, kReadTimeout);
        if (networkTCPTextClient.connect()) {
            String str3 = "w;" + str + ';' + str2;
            Timber.Forest.d("Sending the command to the device: \"" + str3 + "\".", new Object[0]);
            if (networkTCPTextClient.writeMessage(str3)) {
                do {
                    readMessage = networkTCPTextClient.readMessage();
                    if (readMessage != null) {
                        CharSequence charSequence = readMessage;
                        if (StringsKt.contains$default(charSequence, (CharSequence) BROKEN_LIB_MAC_TEST, false, 2, (Object) null)) {
                            Timber.Forest.d("Received a response from the device: " + readMessage, new Object[0]);
                            List<String> split = new Regex(BROKEN_LIB_MAC_TEST).split(charSequence, 0);
                            if (!split.isEmpty()) {
                                ListIterator<String> listIterator = split.listIterator(split.size());
                                while (true) {
                                    if (listIterator.hasPrevious()) {
                                        if (listIterator.previous().length() != 0) {
                                            list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            list = CollectionsKt.emptyList();
                            String[] strArr = (String[]) list.toArray(new String[0]);
                            if (strArr.length == 2) {
                                Timber.Forest.d("Creating device information (this does not mean the configuration was successful).", new Object[0]);
                                String id = TimeZone.getDefault().getID();
                                String str4 = strArr[0];
                                String str5 = strArr[1];
                                Intrinsics.checkNotNull(id);
                                mDeviceInformation = new DeviceInformationLegacy((String) null, str4, str5, "Unknown", "Unknown", "Unknown", id);
                                continue;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                } while (readMessage != null);
            } else {
                Timber.Forest.d("Sending of the command failed.", new Object[0]);
            }
            networkTCPTextClient.disconnect();
        }
        return mDeviceInformation;
    }

    /* access modifiers changed from: private */
    public final void onLinked(SmartLinkedModule smartLinkedModule, AutoPairingListener autoPairingListener) {
        String str;
        List list;
        smartLinkerAttempt = 0;
        String ip = smartLinkedModule.getIp();
        String mac = smartLinkedModule.getMac();
        String id = smartLinkedModule.getId();
        String str2 = "Unknown-ID";
        if (id == null) {
            id = str2;
        }
        Intrinsics.checkNotNull(mac);
        CharSequence charSequence = mac;
        if (StringsKt.contains$default(charSequence, (CharSequence) BROKEN_LIB_MAC_TEST, false, 2, (Object) null)) {
            Timber.Forest.w("Compensate for broken SmartLink library.", new Object[0]);
            Intrinsics.checkNotNull(mac);
            List<String> split = new Regex(BROKEN_LIB_MAC_TEST).split(charSequence, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            list = CollectionsKt.emptyList();
            String[] strArr = (String[]) list.toArray(new String[0]);
            if (strArr.length == 2) {
                mac = strArr[0];
                str2 = strArr[1];
            }
            str = str2;
        } else {
            str = id;
        }
        String id2 = TimeZone.getDefault().getID();
        Timber.Forest.d("SmartLinker linked set up device info", new Object[0]);
        Intrinsics.checkNotNull(id2);
        DeviceInformationLegacy deviceInformationLegacy = new DeviceInformationLegacy(ip, mac, str, "Unknown", "Unknown", "Unknown", id2);
        Timber.Forest.i(deviceInformationLegacy.toString(), new Object[0]);
        autoPairingListener.onCompleted(deviceInformationLegacy);
    }
}
