package com.blueair.viewcore.dialog;

import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/blueair/viewcore/dialog/GuidesData;", "", "<init>", "()V", "ONBOARDING_TROUBLESHOOTING_WIFI", "Lcom/blueair/viewcore/dialog/StepGuides;", "getONBOARDING_TROUBLESHOOTING_WIFI", "()Lcom/blueair/viewcore/dialog/StepGuides;", "ONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN", "getONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN", "RESET_FILTER_TROUBLESHOOTING_OFFLINE", "getRESET_FILTER_TROUBLESHOOTING_OFFLINE", "RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT", "getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT", "RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT_FAN", "getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT_FAN", "RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET", "getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET", "RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN", "getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StepGuideDialogFragment.kt */
public final class GuidesData {
    public static final GuidesData INSTANCE = new GuidesData();
    private static final StepGuides ONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN = new StepGuides("ONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN", Integer.valueOf(R.string.support_troubleshooting), Integer.valueOf(R.string.bt_troubleshooting_0_step), Integer.valueOf(R.string.take_guide), R.string.step, R.string.onboarding_help_next_step, CollectionsKt.listOf(Integer.valueOf(R.string.bt_troubleshooting_1_step), Integer.valueOf(R.string.bt_troubleshooting_2_step), Integer.valueOf(R.string.bt_troubleshooting_3_step), Integer.valueOf(R.string.bt_troubleshooting_4_step), Integer.valueOf(R.string.bt_troubleshooting_5_step), Integer.valueOf(R.string.bt_troubleshooting_6_step)), R.string.completed, R.string.bt_troubleshooting_final_step, R.string.retry_onboarding, 5);
    private static final StepGuides ONBOARDING_TROUBLESHOOTING_WIFI = new StepGuides("ONBOARDING_TROUBLESHOOTING_WIFI", (Integer) null, (Integer) null, (Integer) null, R.string.step, R.string.onboarding_help_next_step, CollectionsKt.listOf(Integer.valueOf(R.string.wifi_troubleshooting_step_1), Integer.valueOf(R.string.wifi_troubleshooting_step_2), Integer.valueOf(R.string.wifi_troubleshooting_step_3), Integer.valueOf(R.string.wifi_troubleshooting_step_4), Integer.valueOf(R.string.wifi_troubleshooting_step_5)), R.string.completed, R.string.wifi_troubleshooting_final_step, R.string.retry_onboarding, 10);
    private static final StepGuides RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT;
    private static final StepGuides RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT_FAN;
    private static final StepGuides RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET;
    private static final StepGuides RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN;
    private static final StepGuides RESET_FILTER_TROUBLESHOOTING_OFFLINE = new StepGuides("RESET_FILTER_TROUBLESHOOTING_OFFLINE", Integer.valueOf(R.string.support_troubleshooting), Integer.valueOf(R.string.reset_filter_troubleshooting_offline_head_msg), Integer.valueOf(R.string.take_guide), R.string.step, R.string.onboarding_help_next_step, CollectionsKt.listOf(Integer.valueOf(R.string.bt_troubleshooting_1_step), Integer.valueOf(R.string.wifi_troubleshooting_step_1), Integer.valueOf(R.string.wifi_troubleshooting_step_5), Integer.valueOf(R.string.bt_troubleshooting_4_step)), R.string.completed, R.string.reset_filter_troubleshooting_offline_complete_msg, R.string.retry_onboarding, 10);

    private GuidesData() {
    }

    static {
        StepGuides stepGuides = new StepGuides("RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT", Integer.valueOf(R.string.support_troubleshooting), Integer.valueOf(R.string.bt_troubleshooting_0_step), Integer.valueOf(R.string.take_guide), R.string.step, R.string.onboarding_help_next_step, CollectionsKt.listOf(Integer.valueOf(R.string.bt_troubleshooting_1_step), Integer.valueOf(R.string.bt_troubleshooting_press_auto), Integer.valueOf(R.string.bt_troubleshooting_2_step), Integer.valueOf(R.string.bt_troubleshooting_3_step), Integer.valueOf(R.string.bt_troubleshooting_4_step), Integer.valueOf(R.string.bt_troubleshooting_5_step), Integer.valueOf(R.string.bt_troubleshooting_6_step)), R.string.completed, R.string.bt_troubleshooting_final_step, R.string.retry_onboarding, 5);
        RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT = stepGuides;
        RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT_FAN = StepGuides.copy$default(stepGuides, (String) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, CollectionsKt.listOf(Integer.valueOf(R.string.bt_troubleshooting_1_step), Integer.valueOf(R.string.step_content_ready_to_pair_fan), Integer.valueOf(R.string.bt_troubleshooting_2_step), Integer.valueOf(R.string.bt_troubleshooting_3_step), Integer.valueOf(R.string.bt_troubleshooting_4_step), Integer.valueOf(R.string.bt_troubleshooting_5_step), Integer.valueOf(R.string.bt_troubleshooting_6_step)), 0, 0, 0, 0, 1983, (Object) null);
        StepGuides stepGuides2 = new StepGuides("RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET", Integer.valueOf(R.string.support_troubleshooting), Integer.valueOf(R.string.bt_reset_filter_troubleshooting_0_step), Integer.valueOf(R.string.take_guide), R.string.step, R.string.onboarding_help_next_step, CollectionsKt.listOf(Integer.valueOf(R.string.bt_troubleshooting_press_auto), Integer.valueOf(R.string.bt_troubleshooting_1_step), Integer.valueOf(R.string.bt_troubleshooting_3_step)), R.string.completed, R.string.bt_reset_filter_troubleshooting_final_step, R.string.retry_onboarding, 5);
        RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET = stepGuides2;
        StepGuides stepGuides3 = stepGuides2;
        RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN = StepGuides.copy$default(stepGuides3, (String) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, CollectionsKt.listOf(Integer.valueOf(R.string.step_content_ready_to_pair_fan), Integer.valueOf(R.string.bt_troubleshooting_1_step), Integer.valueOf(R.string.bt_troubleshooting_3_step)), 0, 0, 0, 0, 1983, (Object) null);
    }

    public final StepGuides getONBOARDING_TROUBLESHOOTING_WIFI() {
        return ONBOARDING_TROUBLESHOOTING_WIFI;
    }

    public final StepGuides getONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN() {
        return ONBOARDING_TROUBLESHOOTING_BLUETOOTH_SCAN;
    }

    public final StepGuides getRESET_FILTER_TROUBLESHOOTING_OFFLINE() {
        return RESET_FILTER_TROUBLESHOOTING_OFFLINE;
    }

    public final StepGuides getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT() {
        return RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT;
    }

    public final StepGuides getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT_FAN() {
        return RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_CONNECT_FAN;
    }

    public final StepGuides getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET() {
        return RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET;
    }

    public final StepGuides getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN() {
        return RESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN;
    }
}
