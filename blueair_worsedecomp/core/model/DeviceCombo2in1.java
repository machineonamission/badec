package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWick;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\n\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u0013B\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010$\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020\u0015\u0012\b\b\u0002\u0010)\u001a\u00020\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\u0015\u0012\b\b\u0002\u0010+\u001a\u00020\u0015\u0012\b\b\u0002\u0010,\u001a\u00020\u0015\u0012\b\b\u0002\u0010-\u001a\u00020\u0015\u0012\b\b\u0002\u0010.\u001a\u00020\u0015\u0012\b\b\u0002\u0010/\u001a\u00020\u0015\u0012\b\b\u0002\u00100\u001a\u00020\u0015\u0012\b\b\u0002\u00101\u001a\u00020\u0015\u0012\b\b\u0002\u00102\u001a\u00020\u0015\u0012\b\b\u0002\u00103\u001a\u000204\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00106\u001a\u000204\u0012\b\b\u0002\u00107\u001a\u000204\u0012\b\b\u0002\u00108\u001a\u000204\u0012\b\b\u0002\u00109\u001a\u00020\u0018\u0012\b\b\u0002\u0010:\u001a\u00020 \u0012\b\b\u0002\u0010;\u001a\u00020\u0015\u0012\b\b\u0002\u0010<\u001a\u00020\u0018\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010@\u001a\u00020 \u0012\b\b\u0002\u0010A\u001a\u00020 \u0012\b\b\u0002\u0010B\u001a\u00020\u0018\u0012\b\b\u0002\u0010C\u001a\u00020'\u0012\b\b\u0002\u0010D\u001a\u00020\u0018\u0012\b\b\u0002\u0010E\u001a\u00020 \u0012\b\b\u0002\u0010F\u001a\u00020\u0018\u0012\b\b\u0002\u0010G\u001a\u00020\u0018\u0012\b\b\u0002\u0010H\u001a\u00020\u0018\u0012\b\b\u0002\u0010I\u001a\u00020\u0018\u0012\b\b\u0002\u0010J\u001a\u00020'\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010L\u001a\u00020\u0018\u0012\b\b\u0002\u0010M\u001a\u00020 \u0012\b\b\u0002\u0010N\u001a\u00020\u0018¢\u0006\u0004\bO\u0010PJ\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0018HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010WJ\n\u0010\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\n\u0010\u0001\u001a\u00020 HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0001\u001a\u00020 HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0001\u001a\u00020'HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¥\u0001\u001a\u000204HÆ\u0003J\n\u0010¦\u0001\u001a\u000204HÆ\u0003J\n\u0010§\u0001\u001a\u000204HÆ\u0003J\n\u0010¨\u0001\u001a\u000204HÆ\u0003J\n\u0010©\u0001\u001a\u000204HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010«\u0001\u001a\u00020 HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010­\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010°\u0001\u001a\u00020 HÆ\u0003J\n\u0010±\u0001\u001a\u00020 HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010³\u0001\u001a\u00020'HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010µ\u0001\u001a\u00020 HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010º\u0001\u001a\u00020'HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010½\u0001\u001a\u00020 HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0018HÆ\u0003J\u0004\u0010¿\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u00152\b\b\u0002\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u00020\u00152\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002042\b\b\u0002\u00109\u001a\u00020\u00182\b\b\u0002\u0010:\u001a\u00020 2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00182\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020 2\b\b\u0002\u0010A\u001a\u00020 2\b\b\u0002\u0010B\u001a\u00020\u00182\b\b\u0002\u0010C\u001a\u00020'2\b\b\u0002\u0010D\u001a\u00020\u00182\b\b\u0002\u0010E\u001a\u00020 2\b\b\u0002\u0010F\u001a\u00020\u00182\b\b\u0002\u0010G\u001a\u00020\u00182\b\b\u0002\u0010H\u001a\u00020\u00182\b\b\u0002\u0010I\u001a\u00020\u00182\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010L\u001a\u00020\u00182\b\b\u0002\u0010M\u001a\u00020 2\b\b\u0002\u0010N\u001a\u00020\u0018HÆ\u0001¢\u0006\u0003\u0010À\u0001J\u0007\u0010Á\u0001\u001a\u00020\u0018J\u0016\u0010Â\u0001\u001a\u00020 2\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001HÖ\u0003J\n\u0010Å\u0001\u001a\u00020\u0018HÖ\u0001J\n\u0010Æ\u0001\u001a\u00020\u0015HÖ\u0001J\u001b\u0010Ç\u0001\u001a\u00030È\u00012\b\u0010É\u0001\u001a\u00030Ê\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0018R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010RR\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\bV\u0010WR\u0014\u0010\u001a\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010UR\u0014\u0010\u001b\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010RR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010RR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010\u001f\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0016\u0010!\u001a\u0004\u0018\u00010\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0014\u0010#\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010UR\u0014\u0010$\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010_R\u0014\u0010%\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010UR\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0014\u0010(\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010RR\u0014\u0010)\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010RR\u0014\u0010*\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010RR\u0014\u0010+\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010RR\u0014\u0010,\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010RR\u0014\u0010-\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010RR\u0014\u0010.\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010RR\u0014\u0010/\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010RR\u0014\u00100\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010RR\u0014\u00101\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010RR\u0014\u00102\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010RR\u0014\u00103\u001a\u000204X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0014\u00105\u001a\u000204X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010rR\u0014\u00106\u001a\u000204X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010rR\u0014\u00107\u001a\u000204X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010rR\u0014\u00108\u001a\u000204X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010rR\u0014\u00109\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010UR\u0014\u0010:\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010_R\u0014\u0010;\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010RR\u0014\u0010<\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010UR\u0016\u0010=\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010RR\u0016\u0010>\u001a\u0004\u0018\u00010?X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0014\u0010@\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010_R\u0014\u0010A\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010_R\u0014\u0010B\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010UR\u0015\u0010C\u001a\u00020'X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0015\u0010D\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u0015\u0010E\u001a\u00020 X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010F\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u0015\u0010G\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u0015\u0010H\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u0015\u0010I\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u0015\u0010J\u001a\u00020'X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010eR\u0017\u0010K\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010RR\u0015\u0010L\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010UR\u0015\u0010M\u001a\u00020 X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010N\u001a\u00020\u0018X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010U¨\u0006Ì\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceCombo2in1;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasWick;", "Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasLocation;", "Lcom/blueair/core/model/HasMode;", "Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/HasHumMode;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "locationId", "mode", "humMode", "waterLevel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJLjava/lang/String;IZI)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getLocationId", "getMode", "getHumMode", "getWaterLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJLjava/lang/String;IZI)Lcom/blueair/core/model/DeviceCombo2in1;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceCombo2in1 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasScheduling, HasSKU, HasWelcomeHome, HasWick, HasAutoRh, HasTimer, HasLocation, HasMode, HasWaterLevel, HasHumMode {
    public static final Parcelable.Creator<DeviceCombo2in1> CREATOR = new Creator();
    private final String autoModeText;
    private final int autoRh;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final DeviceUuid deviceUuid;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final boolean humMode;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String locationId;
    private final String mac;
    private final String mcuFirmware;
    private final int mode;
    private final String modelName;
    private final String name;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final String timeZone;
    private final int timerDuration;
    private final int timerLeftTime;
    private final long timerLeftTimeUpdateTime;
    private final int timerStatus;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final int waterLevel;
    private final boolean waterShortage;
    private final WelcomeHomeLocation welcomeHome;
    private final int wickUsage;
    private final boolean wickdryEnabled;
    private final int wickdryLeftTime;
    private final long wickdryLeftTimeUpdateTime;
    private final boolean wickdryOn;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceCombo2in1> {
        public final DeviceCombo2in1 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            WelcomeHomeLocation welcomeHomeLocation = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z9 = parcel2.readInt() != 0;
            IndoorDatapoint createFromParcel2 = parcel2.readInt() == 0 ? null : IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            int readInt3 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z2 = true;
                z = false;
                indoorDatapoint = createFromParcel2;
                z3 = true;
            } else {
                z2 = true;
                indoorDatapoint = createFromParcel2;
                z3 = false;
                z = false;
            }
            int readInt4 = parcel2.readInt();
            boolean z10 = z2;
            long readLong = parcel2.readLong();
            boolean z11 = z10;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z12 = z11;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z13 = z12;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z14 = z13;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z15 = z14;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z16 = z15;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z17 = z16;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z18 = z;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z19 = z17;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z20 = z18;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z21 = z19;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z5 = z20;
                z20 = z21;
                z4 = z20;
            } else {
                z5 = z20;
                z4 = z21;
            }
            String readString16 = parcel2.readString();
            boolean z22 = z5;
            int readInt6 = parcel2.readInt();
            boolean z23 = z4;
            String readString17 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                welcomeHomeLocation = WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            }
            WelcomeHomeLocation welcomeHomeLocation2 = welcomeHomeLocation;
            if (parcel2.readInt() != 0) {
                z6 = z23;
            } else {
                z6 = z23;
                z23 = z22;
            }
            if (parcel2.readInt() != 0) {
                z7 = z6;
            } else {
                z7 = z6;
                z6 = z22;
            }
            boolean z24 = z7;
            int readInt7 = parcel2.readInt();
            long readLong2 = parcel2.readLong();
            boolean z25 = z24;
            int readInt8 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z8 = z25;
            } else {
                z8 = z25;
                z25 = z22;
            }
            boolean z26 = z8;
            int readInt9 = parcel2.readInt();
            int readInt10 = parcel2.readInt();
            boolean z27 = z26;
            int readInt11 = parcel2.readInt();
            boolean z28 = z27;
            int readInt12 = parcel2.readInt();
            boolean z29 = z28;
            long readLong3 = parcel2.readLong();
            boolean z30 = z29;
            String readString18 = parcel2.readString();
            boolean z31 = z30;
            int readInt13 = parcel2.readInt();
            if (parcel2.readInt() == 0) {
                z31 = z22;
            }
            return new DeviceCombo2in1(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z9, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z20, readString16, readInt6, readString17, welcomeHomeLocation2, z23, z6, readInt7, readLong2, readInt8, z25, readInt9, readInt10, readInt11, readInt12, readLong3, readString18, readInt13, z31, parcel2.readInt());
        }

        public final DeviceCombo2in1[] newArray(int i) {
            return new DeviceCombo2in1[i];
        }
    }

    public static /* synthetic */ DeviceCombo2in1 copy$default(DeviceCombo2in1 deviceCombo2in1, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, String str16, int i6, String str17, WelcomeHomeLocation welcomeHomeLocation, boolean z4, boolean z5, int i7, long j2, int i8, boolean z6, int i9, int i10, int i11, int i12, long j3, String str18, int i13, boolean z7, int i14, int i15, int i16, Object obj) {
        long j4;
        String str19;
        int i17;
        boolean z8;
        int i18;
        String str20;
        long j5;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z9;
        int i23;
        long j6;
        int i24;
        boolean z10;
        boolean z11;
        WelcomeHomeLocation welcomeHomeLocation2;
        String str21;
        int i25;
        String str22;
        boolean z12;
        int i26;
        double[] dArr6;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        int i27;
        boolean z13;
        int i28;
        IndoorDatapoint indoorDatapoint2;
        boolean z14;
        DeviceUuid deviceUuid3;
        String str34;
        String str35;
        int i29;
        Integer num2;
        DeviceCombo2in1 deviceCombo2in12 = deviceCombo2in1;
        int i30 = i15;
        int i31 = i16;
        String str36 = (i30 & 1) != 0 ? deviceCombo2in12.uid : str;
        String str37 = (i30 & 2) != 0 ? deviceCombo2in12.name : str2;
        int i32 = (i30 & 4) != 0 ? deviceCombo2in12.fanSpeed : i;
        Integer num3 = (i30 & 8) != 0 ? deviceCombo2in12.filterLife : num;
        int i33 = (i30 & 16) != 0 ? deviceCombo2in12.brightness : i2;
        String str38 = (i30 & 32) != 0 ? deviceCombo2in12.autoModeText : str3;
        String str39 = (i30 & 64) != 0 ? deviceCombo2in12.info : str4;
        DeviceUuid deviceUuid4 = (i30 & 128) != 0 ? deviceCombo2in12.deviceUuid : deviceUuid2;
        boolean z15 = (i30 & 256) != 0 ? deviceCombo2in12.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint3 = (i30 & 512) != 0 ? deviceCombo2in12.latestSensorDatapoint : indoorDatapoint;
        int i34 = (i30 & 1024) != 0 ? deviceCombo2in12.lastSelectedSensorTypeIndex : i3;
        boolean z16 = (i30 & 2048) != 0 ? deviceCombo2in12.isChildLockOn : z2;
        int i35 = (i30 & 4096) != 0 ? deviceCombo2in12.connectivityStatusIndex : i4;
        String str40 = str36;
        String str41 = str37;
        long j7 = (i30 & 8192) != 0 ? deviceCombo2in12.lastConnectivityInMillis : j;
        String str42 = (i30 & 16384) != 0 ? deviceCombo2in12.mac : str5;
        String str43 = (i30 & 32768) != 0 ? deviceCombo2in12.mcuFirmware : str6;
        String str44 = (i30 & 65536) != 0 ? deviceCombo2in12.wifiFirmware : str7;
        String str45 = (i15 & 131072) != 0 ? deviceCombo2in12.hardware : str8;
        String str46 = (i15 & 262144) != 0 ? deviceCombo2in12.timeZone : str9;
        String str47 = (i15 & 524288) != 0 ? deviceCombo2in12.serial : str10;
        String str48 = (i15 & 1048576) != 0 ? deviceCombo2in12.purchaseDate : str11;
        String str49 = (i15 & 2097152) != 0 ? deviceCombo2in12.dealerName : str12;
        String str50 = (i15 & 4194304) != 0 ? deviceCombo2in12.dealerCountry : str13;
        String str51 = (i15 & 8388608) != 0 ? deviceCombo2in12.filterType : str14;
        String str52 = (i15 & 16777216) != 0 ? deviceCombo2in12.filterTrigger : str15;
        double[] dArr11 = (i15 & 33554432) != 0 ? deviceCombo2in12.pm1Ranges : dArr;
        double[] dArr12 = (i15 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceCombo2in12.pm10Ranges : dArr2;
        double[] dArr13 = (i15 & 134217728) != 0 ? deviceCombo2in12.pm25Ranges : dArr3;
        double[] dArr14 = (i15 & 268435456) != 0 ? deviceCombo2in12.vocRanges : dArr4;
        double[] dArr15 = (i15 & 536870912) != 0 ? deviceCombo2in12.hchoRanges : dArr5;
        int i36 = (i15 & 1073741824) != 0 ? deviceCombo2in12.updateProgress : i5;
        boolean z17 = (i15 & Integer.MIN_VALUE) != 0 ? deviceCombo2in12.isStandByOn : z3;
        String str53 = (i31 & 1) != 0 ? deviceCombo2in12.modelName : str16;
        int i37 = (i31 & 2) != 0 ? deviceCombo2in12.typeIndex : i6;
        String str54 = (i31 & 4) != 0 ? deviceCombo2in12.sku : str17;
        WelcomeHomeLocation welcomeHomeLocation3 = (i31 & 8) != 0 ? deviceCombo2in12.welcomeHome : welcomeHomeLocation;
        boolean z18 = (i31 & 16) != 0 ? deviceCombo2in12.wickdryEnabled : z4;
        boolean z19 = (i31 & 32) != 0 ? deviceCombo2in12.wickdryOn : z5;
        int i38 = (i31 & 64) != 0 ? deviceCombo2in12.wickdryLeftTime : i7;
        String str55 = str42;
        if ((i31 & 128) != 0) {
            str19 = str43;
            j4 = deviceCombo2in12.wickdryLeftTimeUpdateTime;
        } else {
            str19 = str43;
            j4 = j2;
        }
        String str56 = str19;
        int i39 = (i31 & 256) != 0 ? deviceCombo2in12.wickUsage : i8;
        boolean z20 = (i31 & 512) != 0 ? deviceCombo2in12.waterShortage : z6;
        int i40 = (i31 & 1024) != 0 ? deviceCombo2in12.autoRh : i9;
        int i41 = (i31 & 2048) != 0 ? deviceCombo2in12.timerStatus : i10;
        int i42 = (i31 & 4096) != 0 ? deviceCombo2in12.timerDuration : i11;
        int i43 = (i31 & 8192) != 0 ? deviceCombo2in12.timerLeftTime : i12;
        long j8 = (i31 & 16384) != 0 ? deviceCombo2in12.timerLeftTimeUpdateTime : j3;
        String str57 = (i16 & 32768) != 0 ? deviceCombo2in12.locationId : str18;
        int i44 = (i16 & 65536) != 0 ? deviceCombo2in12.mode : i13;
        String str58 = str57;
        boolean z21 = (i16 & 131072) != 0 ? deviceCombo2in12.humMode : z7;
        if ((i16 & 262144) != 0) {
            z8 = z21;
            i17 = deviceCombo2in12.waterLevel;
            str20 = str58;
            z11 = z18;
            z10 = z19;
            i24 = i38;
            i23 = i39;
            z9 = z20;
            i22 = i40;
            i21 = i41;
            i20 = i42;
            i19 = i43;
            j5 = j8;
            i18 = i44;
            j6 = j4;
            num2 = num3;
            str24 = str51;
            str23 = str52;
            dArr10 = dArr11;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            i26 = i36;
            z12 = z17;
            str22 = str53;
            i25 = i37;
            str21 = str54;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            str32 = str56;
            str33 = str55;
            z13 = z16;
            i27 = i35;
            str31 = str44;
            str30 = str45;
            str29 = str46;
            str28 = str47;
            str27 = str48;
            str26 = str49;
            str25 = str50;
            dArr9 = dArr12;
            i29 = i33;
            str35 = str38;
            str34 = str39;
            deviceUuid3 = deviceUuid4;
            z14 = z15;
            indoorDatapoint2 = indoorDatapoint3;
            i28 = i34;
        } else {
            i17 = i14;
            z8 = z21;
            str20 = str58;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            z11 = z18;
            z10 = z19;
            i24 = i38;
            i23 = i39;
            z9 = z20;
            i22 = i40;
            i21 = i41;
            i20 = i42;
            i19 = i43;
            j5 = j8;
            i18 = i44;
            j6 = j4;
            num2 = num3;
            str25 = str50;
            str24 = str51;
            str23 = str52;
            dArr10 = dArr11;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            i26 = i36;
            z12 = z17;
            str22 = str53;
            i25 = i37;
            str21 = str54;
            str32 = str56;
            str33 = str55;
            i28 = i34;
            z13 = z16;
            i27 = i35;
            str31 = str44;
            str30 = str45;
            str29 = str46;
            str28 = str47;
            str27 = str48;
            str26 = str49;
            dArr9 = dArr12;
            i29 = i33;
            str35 = str38;
            str34 = str39;
            deviceUuid3 = deviceUuid4;
            z14 = z15;
            indoorDatapoint2 = indoorDatapoint3;
        }
        return deviceCombo2in12.copy(str40, str41, i32, num2, i29, str35, str34, deviceUuid3, z14, indoorDatapoint2, i28, z13, i27, j7, str33, str32, str31, str30, str29, str28, str27, str26, str25, str24, str23, dArr10, dArr9, dArr8, dArr7, dArr6, i26, z12, str22, i25, str21, welcomeHomeLocation2, z11, z10, i24, j6, i23, z9, i22, i21, i20, i19, j5, str20, i18, z8, i17);
    }

    public final String component1() {
        return this.uid;
    }

    public final IndoorDatapoint component10() {
        return this.latestSensorDatapoint;
    }

    public final int component11() {
        return this.lastSelectedSensorTypeIndex;
    }

    public final boolean component12() {
        return this.isChildLockOn;
    }

    public final int component13() {
        return this.connectivityStatusIndex;
    }

    public final long component14() {
        return this.lastConnectivityInMillis;
    }

    public final String component15() {
        return this.mac;
    }

    public final String component16() {
        return this.mcuFirmware;
    }

    public final String component17() {
        return this.wifiFirmware;
    }

    public final String component18() {
        return this.hardware;
    }

    public final String component19() {
        return this.timeZone;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.serial;
    }

    public final String component21() {
        return this.purchaseDate;
    }

    public final String component22() {
        return this.dealerName;
    }

    public final String component23() {
        return this.dealerCountry;
    }

    public final String component24() {
        return this.filterType;
    }

    public final String component25() {
        return this.filterTrigger;
    }

    public final double[] component26() {
        return this.pm1Ranges;
    }

    public final double[] component27() {
        return this.pm10Ranges;
    }

    public final double[] component28() {
        return this.pm25Ranges;
    }

    public final double[] component29() {
        return this.vocRanges;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final double[] component30() {
        return this.hchoRanges;
    }

    public final int component31() {
        return this.updateProgress;
    }

    public final boolean component32() {
        return this.isStandByOn;
    }

    public final String component33() {
        return this.modelName;
    }

    public final int component34() {
        return this.typeIndex;
    }

    public final String component35() {
        return this.sku;
    }

    public final WelcomeHomeLocation component36() {
        return this.welcomeHome;
    }

    public final boolean component37() {
        return this.wickdryEnabled;
    }

    public final boolean component38() {
        return this.wickdryOn;
    }

    public final int component39() {
        return this.wickdryLeftTime;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final long component40() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public final int component41() {
        return this.wickUsage;
    }

    public final boolean component42() {
        return this.waterShortage;
    }

    public final int component43() {
        return this.autoRh;
    }

    public final int component44() {
        return this.timerStatus;
    }

    public final int component45() {
        return this.timerDuration;
    }

    public final int component46() {
        return this.timerLeftTime;
    }

    public final long component47() {
        return this.timerLeftTimeUpdateTime;
    }

    public final String component48() {
        return this.locationId;
    }

    public final int component49() {
        return this.mode;
    }

    public final int component5() {
        return this.brightness;
    }

    public final boolean component50() {
        return this.humMode;
    }

    public final int component51() {
        return this.waterLevel;
    }

    public final String component6() {
        return this.autoModeText;
    }

    public final String component7() {
        return this.info;
    }

    public final DeviceUuid component8() {
        return this.deviceUuid;
    }

    public final boolean component9() {
        return this.hasFinishedOnboarding;
    }

    public final DeviceCombo2in1 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, String str16, int i6, String str17, WelcomeHomeLocation welcomeHomeLocation, boolean z4, boolean z5, int i7, long j2, int i8, boolean z6, int i9, int i10, int i11, int i12, long j3, String str18, int i13, boolean z7, int i14) {
        String str19 = str;
        Intrinsics.checkNotNullParameter(str19, "uid");
        String str20 = str2;
        Intrinsics.checkNotNullParameter(str20, "name");
        String str21 = str3;
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str5, AnalyticEvent.KEY_MAC);
        String str22 = str6;
        Intrinsics.checkNotNullParameter(str22, "mcuFirmware");
        String str23 = str7;
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        String str24 = str8;
        Intrinsics.checkNotNullParameter(str24, "hardware");
        String str25 = str9;
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str26 = str10;
        Intrinsics.checkNotNullParameter(str26, "serial");
        String str27 = str11;
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        String str28 = str12;
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        String str29 = str13;
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        String str30 = str14;
        Intrinsics.checkNotNullParameter(str30, "filterType");
        String str31 = str15;
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "modelName");
        String str32 = str22;
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        String str41 = str31;
        double[] dArr7 = dArr6;
        return new DeviceCombo2in1(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, str16, i6, str17, welcomeHomeLocation, z4, z5, i7, j2, i8, z6, i9, i10, i11, i12, j3, str18, i13, z7, i14);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceCombo2in1)) {
            return false;
        }
        DeviceCombo2in1 deviceCombo2in1 = (DeviceCombo2in1) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceCombo2in1.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceCombo2in1.name) && this.fanSpeed == deviceCombo2in1.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceCombo2in1.filterLife) && this.brightness == deviceCombo2in1.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceCombo2in1.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceCombo2in1.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceCombo2in1.deviceUuid) && this.hasFinishedOnboarding == deviceCombo2in1.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceCombo2in1.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceCombo2in1.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceCombo2in1.isChildLockOn && this.connectivityStatusIndex == deviceCombo2in1.connectivityStatusIndex && this.lastConnectivityInMillis == deviceCombo2in1.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceCombo2in1.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceCombo2in1.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceCombo2in1.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceCombo2in1.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceCombo2in1.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceCombo2in1.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceCombo2in1.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceCombo2in1.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceCombo2in1.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceCombo2in1.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceCombo2in1.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceCombo2in1.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceCombo2in1.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceCombo2in1.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceCombo2in1.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceCombo2in1.hchoRanges) && this.updateProgress == deviceCombo2in1.updateProgress && this.isStandByOn == deviceCombo2in1.isStandByOn && Intrinsics.areEqual((Object) this.modelName, (Object) deviceCombo2in1.modelName) && this.typeIndex == deviceCombo2in1.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceCombo2in1.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceCombo2in1.welcomeHome) && this.wickdryEnabled == deviceCombo2in1.wickdryEnabled && this.wickdryOn == deviceCombo2in1.wickdryOn && this.wickdryLeftTime == deviceCombo2in1.wickdryLeftTime && this.wickdryLeftTimeUpdateTime == deviceCombo2in1.wickdryLeftTimeUpdateTime && this.wickUsage == deviceCombo2in1.wickUsage && this.waterShortage == deviceCombo2in1.waterShortage && this.autoRh == deviceCombo2in1.autoRh && this.timerStatus == deviceCombo2in1.timerStatus && this.timerDuration == deviceCombo2in1.timerDuration && this.timerLeftTime == deviceCombo2in1.timerLeftTime && this.timerLeftTimeUpdateTime == deviceCombo2in1.timerLeftTimeUpdateTime && Intrinsics.areEqual((Object) this.locationId, (Object) deviceCombo2in1.locationId) && this.mode == deviceCombo2in1.mode && this.humMode == deviceCombo2in1.humMode && this.waterLevel == deviceCombo2in1.waterLevel;
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DeviceUuid deviceUuid2 = this.deviceUuid;
        int hashCode4 = (((hashCode3 + (deviceUuid2 == null ? 0 : deviceUuid2.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding)) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        int hashCode7 = (((((((((((((((((((((((hashCode6 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn)) * 31) + this.wickdryLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime)) * 31) + this.wickUsage) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage)) * 31) + this.autoRh) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31;
        String str3 = this.locationId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((((hashCode7 + i) * 31) + this.mode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.humMode)) * 31) + this.waterLevel;
    }

    public String toString() {
        return "DeviceCombo2in1(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ", wickdryEnabled=" + this.wickdryEnabled + ", wickdryOn=" + this.wickdryOn + ", wickdryLeftTime=" + this.wickdryLeftTime + ", wickdryLeftTimeUpdateTime=" + this.wickdryLeftTimeUpdateTime + ", wickUsage=" + this.wickUsage + ", waterShortage=" + this.waterShortage + ", autoRh=" + this.autoRh + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", locationId=" + this.locationId + ", mode=" + this.mode + ", humMode=" + this.humMode + ", waterLevel=" + this.waterLevel + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.fanSpeed);
        Integer num = this.filterLife;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.brightness);
        parcel.writeString(this.autoModeText);
        parcel.writeString(this.info);
        DeviceUuid deviceUuid2 = this.deviceUuid;
        if (deviceUuid2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            deviceUuid2.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.hasFinishedOnboarding ? 1 : 0);
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        if (indoorDatapoint == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            indoorDatapoint.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.lastSelectedSensorTypeIndex);
        parcel.writeInt(this.isChildLockOn ? 1 : 0);
        parcel.writeInt(this.connectivityStatusIndex);
        parcel.writeLong(this.lastConnectivityInMillis);
        parcel.writeString(this.mac);
        parcel.writeString(this.mcuFirmware);
        parcel.writeString(this.wifiFirmware);
        parcel.writeString(this.hardware);
        parcel.writeString(this.timeZone);
        parcel.writeString(this.serial);
        parcel.writeString(this.purchaseDate);
        parcel.writeString(this.dealerName);
        parcel.writeString(this.dealerCountry);
        parcel.writeString(this.filterType);
        parcel.writeString(this.filterTrigger);
        parcel.writeDoubleArray(this.pm1Ranges);
        parcel.writeDoubleArray(this.pm10Ranges);
        parcel.writeDoubleArray(this.pm25Ranges);
        parcel.writeDoubleArray(this.vocRanges);
        parcel.writeDoubleArray(this.hchoRanges);
        parcel.writeInt(this.updateProgress);
        parcel.writeInt(this.isStandByOn ? 1 : 0);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.typeIndex);
        parcel.writeString(this.sku);
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            welcomeHomeLocation.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.wickdryEnabled ? 1 : 0);
        parcel.writeInt(this.wickdryOn ? 1 : 0);
        parcel.writeInt(this.wickdryLeftTime);
        parcel.writeLong(this.wickdryLeftTimeUpdateTime);
        parcel.writeInt(this.wickUsage);
        parcel.writeInt(this.waterShortage ? 1 : 0);
        parcel.writeInt(this.autoRh);
        parcel.writeInt(this.timerStatus);
        parcel.writeInt(this.timerDuration);
        parcel.writeInt(this.timerLeftTime);
        parcel.writeLong(this.timerLeftTimeUpdateTime);
        parcel.writeString(this.locationId);
        parcel.writeInt(this.mode);
        parcel.writeInt(this.humMode ? 1 : 0);
        parcel.writeInt(this.waterLevel);
    }

    public double[] airRatingsFor(SensorType sensorType) {
        return HasSensorData.CC.$default$airRatingsFor(this, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(double d, SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, d, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, sensorType);
    }

    public IndoorAirRatingRanges getAirRatingRanges() {
        return HasSensorData.CC.$default$getAirRatingRanges(this);
    }

    public AutoMode getAutoMode() {
        return HasFanSpeed.CC.$default$getAutoMode(this);
    }

    public Brightness getBrightnessEnum() {
        return HasBrightness.CC.$default$getBrightnessEnum(this);
    }

    public ConnectivityStatus getConnectivityStatus() {
        return Device.CC.$default$getConnectivityStatus(this);
    }

    public FanSpeedEnum getFanSpeedEnum() {
        return HasFanSpeed.CC.$default$getFanSpeedEnum(this);
    }

    public Filter getFilter() {
        return HasFanSpeed.CC.$default$getFilter(this);
    }

    public boolean getHasGear0() {
        return HasFanSpeed.CC.$default$getHasGear0(this);
    }

    public boolean getHasGear4() {
        return HasFanSpeed.CC.$default$getHasGear4(this);
    }

    public SensorType getLastSelectedSensorType() {
        return HasSensorData.CC.$default$getLastSelectedSensorType(this);
    }

    public int getLeftSeconds() {
        return HasTimer.CC.$default$getLeftSeconds(this);
    }

    public int getRealTimerLeftTime(long j) {
        return HasTimer.CC.$default$getRealTimerLeftTime(this, j);
    }

    public TimeZone getTimezone(Context context) {
        return Device.CC.$default$getTimezone(this, context);
    }

    public FilterTrigger getTrigger() {
        return HasFanSpeed.CC.$default$getTrigger(this);
    }

    public DeviceType getType() {
        return Device.CC.$default$getType(this);
    }

    public UiAutoMode getUiAutoMode() {
        return HasFanSpeed.CC.$default$getUiAutoMode(this);
    }

    public int getWickDryLeftSeconds() {
        return HasWick.CC.$default$getWickDryLeftSeconds(this);
    }

    public int getWickLifeLeft() {
        return HasWick.CC.$default$getWickLifeLeft(this);
    }

    public boolean isInMode(Mode mode2) {
        return HasMode.CC.$default$isInMode(this, mode2);
    }

    public boolean isInWaterLevel(WaterLevel waterLevel2) {
        return HasWaterLevel.CC.$default$isInWaterLevel(this, waterLevel2);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public Mode mode() {
        return HasMode.CC.$default$mode(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public TimerState timerStatus() {
        return HasTimer.CC.$default$timerStatus(this);
    }

    public WaterLevel waterLevel() {
        return HasWaterLevel.CC.$default$waterLevel(this);
    }

    public DeviceCombo2in1(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, String str16, int i6, String str17, WelcomeHomeLocation welcomeHomeLocation, boolean z4, boolean z5, int i7, long j2, int i8, boolean z6, int i9, int i10, int i11, int i12, long j3, String str18, int i13, boolean z7, int i14) {
        String str19 = str;
        String str20 = str2;
        String str21 = str3;
        String str22 = str5;
        String str23 = str6;
        String str24 = str7;
        String str25 = str8;
        String str26 = str9;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        String str30 = str13;
        String str31 = str14;
        String str32 = str15;
        Intrinsics.checkNotNullParameter(str19, "uid");
        Intrinsics.checkNotNullParameter(str20, "name");
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str22, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str23, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str24, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str25, "hardware");
        Intrinsics.checkNotNullParameter(str26, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str27, "serial");
        Intrinsics.checkNotNullParameter(str28, "purchaseDate");
        Intrinsics.checkNotNullParameter(str29, "dealerName");
        Intrinsics.checkNotNullParameter(str30, "dealerCountry");
        Intrinsics.checkNotNullParameter(str31, "filterType");
        Intrinsics.checkNotNullParameter(str32, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        String str33 = str16;
        Intrinsics.checkNotNullParameter(str33, "modelName");
        this.uid = str19;
        this.name = str20;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str21;
        this.info = str4;
        this.deviceUuid = deviceUuid2;
        this.hasFinishedOnboarding = z;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i3;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i4;
        this.lastConnectivityInMillis = j;
        this.mac = str22;
        this.mcuFirmware = str23;
        this.wifiFirmware = str24;
        this.hardware = str25;
        this.timeZone = str26;
        this.serial = str27;
        this.purchaseDate = str28;
        this.dealerName = str29;
        this.dealerCountry = str30;
        this.filterType = str31;
        this.filterTrigger = str32;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i5;
        this.isStandByOn = z3;
        this.modelName = str33;
        this.typeIndex = i6;
        this.sku = str17;
        this.welcomeHome = welcomeHomeLocation;
        this.wickdryEnabled = z4;
        this.wickdryOn = z5;
        this.wickdryLeftTime = i7;
        this.wickdryLeftTimeUpdateTime = j2;
        this.wickUsage = i8;
        this.waterShortage = z6;
        this.autoRh = i9;
        this.timerStatus = i10;
        this.timerDuration = i11;
        this.timerLeftTime = i12;
        this.timerLeftTimeUpdateTime = j3;
        this.locationId = str18;
        this.mode = i13;
        this.humMode = z7;
        this.waterLevel = i14;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceCombo2in1(java.lang.String r45, java.lang.String r46, int r47, java.lang.Integer r48, int r49, java.lang.String r50, java.lang.String r51, com.blueair.core.model.DeviceUuid r52, boolean r53, com.blueair.core.model.IndoorDatapoint r54, int r55, boolean r56, int r57, long r58, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.lang.String r63, java.lang.String r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, double[] r71, double[] r72, double[] r73, double[] r74, double[] r75, int r76, boolean r77, java.lang.String r78, int r79, java.lang.String r80, com.blueair.core.model.WelcomeHomeLocation r81, boolean r82, boolean r83, int r84, long r85, int r87, boolean r88, int r89, int r90, int r91, int r92, long r93, java.lang.String r95, int r96, boolean r97, int r98, int r99, int r100, kotlin.jvm.internal.DefaultConstructorMarker r101) {
        /*
            r44 = this;
            r0 = r99
            r1 = r100
            r2 = r0 & 2
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = "Pairing…"
            goto L_0x000d
        L_0x000b:
            r2 = r46
        L_0x000d:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0015
        L_0x0013:
            r3 = r47
        L_0x0015:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001b
            r5 = 0
            goto L_0x001d
        L_0x001b:
            r5 = r48
        L_0x001d:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0023
            r7 = 0
            goto L_0x0025
        L_0x0023:
            r7 = r49
        L_0x0025:
            r8 = r0 & 32
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002d
            r8 = r9
            goto L_0x002f
        L_0x002d:
            r8 = r50
        L_0x002f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0035
            r10 = 0
            goto L_0x0037
        L_0x0035:
            r10 = r51
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r52
        L_0x003f:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r53
        L_0x0047:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x004d
            r13 = 0
            goto L_0x004f
        L_0x004d:
            r13 = r54
        L_0x004f:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0055
            r14 = 0
            goto L_0x0057
        L_0x0055:
            r14 = r55
        L_0x0057:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005d
            r15 = 0
            goto L_0x005f
        L_0x005d:
            r15 = r56
        L_0x005f:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r6 = r6.ordinal()
            goto L_0x006c
        L_0x006a:
            r6 = r57
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            r16 = 0
            if (r4 == 0) goto L_0x0075
            r18 = r16
            goto L_0x0077
        L_0x0075:
            r18 = r58
        L_0x0077:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007d
            r4 = r9
            goto L_0x007f
        L_0x007d:
            r4 = r60
        L_0x007f:
            r20 = 32768(0x8000, float:4.5918E-41)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x0089
            r21 = r9
            goto L_0x008b
        L_0x0089:
            r21 = r61
        L_0x008b:
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x0094
            r23 = r9
            goto L_0x0096
        L_0x0094:
            r23 = r62
        L_0x0096:
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = r0 & r24
            if (r25 == 0) goto L_0x009f
            r25 = r9
            goto L_0x00a1
        L_0x009f:
            r25 = r63
        L_0x00a1:
            r26 = 262144(0x40000, float:3.67342E-40)
            r27 = r0 & r26
            if (r27 == 0) goto L_0x00aa
            r27 = r9
            goto L_0x00ac
        L_0x00aa:
            r27 = r64
        L_0x00ac:
            r28 = 524288(0x80000, float:7.34684E-40)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00b5
            r28 = r9
            goto L_0x00b7
        L_0x00b5:
            r28 = r65
        L_0x00b7:
            r29 = 1048576(0x100000, float:1.469368E-39)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00c0
            r29 = r9
            goto L_0x00c2
        L_0x00c0:
            r29 = r66
        L_0x00c2:
            r30 = 2097152(0x200000, float:2.938736E-39)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00cb
            r30 = r9
            goto L_0x00cd
        L_0x00cb:
            r30 = r67
        L_0x00cd:
            r31 = 4194304(0x400000, float:5.877472E-39)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00d6
            r31 = r9
            goto L_0x00d8
        L_0x00d6:
            r31 = r68
        L_0x00d8:
            r32 = 8388608(0x800000, float:1.17549435E-38)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x00e1
            r32 = r9
            goto L_0x00e3
        L_0x00e1:
            r32 = r69
        L_0x00e3:
            r33 = 16777216(0x1000000, float:2.3509887E-38)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x00ec
            r33 = r9
            goto L_0x00ee
        L_0x00ec:
            r33 = r70
        L_0x00ee:
            r34 = 33554432(0x2000000, float:9.403955E-38)
            r34 = r0 & r34
            r101 = r2
            r0 = 0
            if (r34 == 0) goto L_0x00fa
            double[] r2 = new double[r0]
            goto L_0x00fc
        L_0x00fa:
            r2 = r71
        L_0x00fc:
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            r34 = r99 & r34
            r47 = r2
            if (r34 == 0) goto L_0x0107
            double[] r2 = new double[r0]
            goto L_0x0109
        L_0x0107:
            r2 = r72
        L_0x0109:
            r34 = 134217728(0x8000000, float:3.85186E-34)
            r34 = r99 & r34
            r48 = r2
            if (r34 == 0) goto L_0x0114
            double[] r2 = new double[r0]
            goto L_0x0116
        L_0x0114:
            r2 = r73
        L_0x0116:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
            r34 = r99 & r34
            r49 = r2
            if (r34 == 0) goto L_0x0121
            double[] r2 = new double[r0]
            goto L_0x0123
        L_0x0121:
            r2 = r74
        L_0x0123:
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            r34 = r99 & r34
            r50 = r2
            if (r34 == 0) goto L_0x012e
            double[] r2 = new double[r0]
            goto L_0x0130
        L_0x012e:
            r2 = r75
        L_0x0130:
            r34 = 1073741824(0x40000000, float:2.0)
            r34 = r99 & r34
            if (r34 == 0) goto L_0x0139
            r34 = r0
            goto L_0x013b
        L_0x0139:
            r34 = r76
        L_0x013b:
            r35 = -2147483648(0xffffffff80000000, float:-0.0)
            r35 = r99 & r35
            if (r35 == 0) goto L_0x0144
            r35 = r0
            goto L_0x0146
        L_0x0144:
            r35 = r77
        L_0x0146:
            r36 = r1 & 1
            if (r36 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r9 = r78
        L_0x014d:
            r36 = r1 & 2
            if (r36 == 0) goto L_0x0158
            com.blueair.core.model.DeviceType$Combo2in1 r36 = com.blueair.core.model.DeviceType.Combo2in1.INSTANCE
            int r36 = r36.getIndex()
            goto L_0x015a
        L_0x0158:
            r36 = r79
        L_0x015a:
            r37 = r1 & 4
            if (r37 == 0) goto L_0x0161
            r37 = 0
            goto L_0x0163
        L_0x0161:
            r37 = r80
        L_0x0163:
            r38 = r1 & 8
            if (r38 == 0) goto L_0x016a
            r38 = 0
            goto L_0x016c
        L_0x016a:
            r38 = r81
        L_0x016c:
            r39 = r1 & 16
            if (r39 == 0) goto L_0x0173
            r39 = r0
            goto L_0x0175
        L_0x0173:
            r39 = r82
        L_0x0175:
            r40 = r1 & 32
            if (r40 == 0) goto L_0x017c
            r40 = r0
            goto L_0x017e
        L_0x017c:
            r40 = r83
        L_0x017e:
            r41 = r1 & 64
            if (r41 == 0) goto L_0x0185
            r41 = r0
            goto L_0x0187
        L_0x0185:
            r41 = r84
        L_0x0187:
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018e
            r42 = r16
            goto L_0x0190
        L_0x018e:
            r42 = r85
        L_0x0190:
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0196
            r0 = 0
            goto L_0x0198
        L_0x0196:
            r0 = r87
        L_0x0198:
            r52 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a0
            r0 = 0
            goto L_0x01a2
        L_0x01a0:
            r0 = r88
        L_0x01a2:
            r53 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01ab
            r0 = 50
            goto L_0x01ad
        L_0x01ab:
            r0 = r89
        L_0x01ad:
            r54 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b5
            r0 = 0
            goto L_0x01b7
        L_0x01b5:
            r0 = r90
        L_0x01b7:
            r55 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01bf
            r0 = 0
            goto L_0x01c1
        L_0x01bf:
            r0 = r91
        L_0x01c1:
            r56 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c9
            r0 = 0
            goto L_0x01cb
        L_0x01c9:
            r0 = r92
        L_0x01cb:
            r57 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r16 = r93
        L_0x01d4:
            r0 = r1 & r20
            if (r0 == 0) goto L_0x01da
            r0 = 0
            goto L_0x01dc
        L_0x01da:
            r0 = r95
        L_0x01dc:
            r20 = r1 & r22
            if (r20 == 0) goto L_0x01e3
            r20 = 0
            goto L_0x01e5
        L_0x01e3:
            r20 = r96
        L_0x01e5:
            r22 = r1 & r24
            if (r22 == 0) goto L_0x01ec
            r22 = 0
            goto L_0x01ee
        L_0x01ec:
            r22 = r97
        L_0x01ee:
            r1 = r1 & r26
            if (r1 == 0) goto L_0x01f5
            r100 = 0
            goto L_0x01f7
        L_0x01f5:
            r100 = r98
        L_0x01f7:
            r46 = r44
            r73 = r47
            r74 = r48
            r75 = r49
            r76 = r50
            r89 = r52
            r90 = r53
            r91 = r54
            r92 = r55
            r93 = r56
            r94 = r57
            r48 = r101
            r97 = r0
            r77 = r2
            r49 = r3
            r62 = r4
            r50 = r5
            r59 = r6
            r51 = r7
            r52 = r8
            r80 = r9
            r53 = r10
            r54 = r11
            r55 = r12
            r56 = r13
            r57 = r14
            r58 = r15
            r95 = r16
            r60 = r18
            r98 = r20
            r63 = r21
            r99 = r22
            r64 = r23
            r65 = r25
            r66 = r27
            r67 = r28
            r68 = r29
            r69 = r30
            r70 = r31
            r71 = r32
            r72 = r33
            r78 = r34
            r79 = r35
            r81 = r36
            r82 = r37
            r83 = r38
            r84 = r39
            r85 = r40
            r86 = r41
            r87 = r42
            r47 = r45
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r89, r90, r91, r92, r93, r94, r95, r97, r98, r99, r100)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceCombo2in1.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, boolean, boolean, int, long, int, boolean, int, int, int, int, long, java.lang.String, int, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getName() {
        return this.name;
    }

    public int getFanSpeed() {
        return this.fanSpeed;
    }

    public Integer getFilterLife() {
        return this.filterLife;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getAutoModeText() {
        return this.autoModeText;
    }

    public String getInfo() {
        return this.info;
    }

    public DeviceUuid getDeviceUuid() {
        return this.deviceUuid;
    }

    public boolean getHasFinishedOnboarding() {
        return this.hasFinishedOnboarding;
    }

    public IndoorDatapoint getLatestSensorDatapoint() {
        return this.latestSensorDatapoint;
    }

    public int getLastSelectedSensorTypeIndex() {
        return this.lastSelectedSensorTypeIndex;
    }

    public boolean isChildLockOn() {
        return this.isChildLockOn;
    }

    public int getConnectivityStatusIndex() {
        return this.connectivityStatusIndex;
    }

    public long getLastConnectivityInMillis() {
        return this.lastConnectivityInMillis;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public String getDealerCountry() {
        return this.dealerCountry;
    }

    public String getFilterType() {
        return this.filterType;
    }

    public String getFilterTrigger() {
        return this.filterTrigger;
    }

    public double[] getPm1Ranges() {
        return this.pm1Ranges;
    }

    public double[] getPm10Ranges() {
        return this.pm10Ranges;
    }

    public double[] getPm25Ranges() {
        return this.pm25Ranges;
    }

    public double[] getVocRanges() {
        return this.vocRanges;
    }

    public double[] getHchoRanges() {
        return this.hchoRanges;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }

    public boolean isStandByOn() {
        return this.isStandByOn;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public String getSku() {
        return this.sku;
    }

    public WelcomeHomeLocation getWelcomeHome() {
        return this.welcomeHome;
    }

    public boolean getWickdryEnabled() {
        return this.wickdryEnabled;
    }

    public boolean getWickdryOn() {
        return this.wickdryOn;
    }

    public int getWickdryLeftTime() {
        return this.wickdryLeftTime;
    }

    public long getWickdryLeftTimeUpdateTime() {
        return this.wickdryLeftTimeUpdateTime;
    }

    public int getWickUsage() {
        return this.wickUsage;
    }

    public boolean getWaterShortage() {
        return this.waterShortage;
    }

    public int getAutoRh() {
        return this.autoRh;
    }

    public int getTimerStatus() {
        return this.timerStatus;
    }

    public int getTimerDuration() {
        return this.timerDuration;
    }

    public int getTimerLeftTime() {
        return this.timerLeftTime;
    }

    public long getTimerLeftTimeUpdateTime() {
        return this.timerLeftTimeUpdateTime;
    }

    public String getLocationId() {
        return this.locationId;
    }

    public int getMode() {
        return this.mode;
    }

    public boolean getHumMode() {
        return this.humMode;
    }

    public int getWaterLevel() {
        return this.waterLevel;
    }
}
