package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b}\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u0011BÛ\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0016\u0012\b\b\u0002\u0010\"\u001a\u00020\u001e\u0012\b\b\u0002\u0010#\u001a\u00020\u0016\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\b\b\u0002\u0010&\u001a\u00020\u0013\u0012\b\b\u0002\u0010'\u001a\u00020\u0013\u0012\b\b\u0002\u0010(\u001a\u00020\u0013\u0012\b\b\u0002\u0010)\u001a\u00020\u0013\u0012\b\b\u0002\u0010*\u001a\u00020\u0013\u0012\b\b\u0002\u0010+\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u0013\u0012\b\b\u0002\u0010-\u001a\u00020\u0013\u0012\b\b\u0002\u0010.\u001a\u00020\u0013\u0012\b\b\u0002\u0010/\u001a\u00020\u0013\u0012\b\b\u0002\u00100\u001a\u00020\u0013\u0012\b\b\u0002\u00101\u001a\u000202\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u00104\u001a\u000202\u0012\b\b\u0002\u00105\u001a\u000202\u0012\b\b\u0002\u00106\u001a\u000202\u0012\b\b\u0002\u00107\u001a\u00020\u0016\u0012\b\b\u0002\u00108\u001a\u00020\u001e\u0012\b\b\u0002\u00109\u001a\u00020\u001e\u0012\b\b\u0002\u0010:\u001a\u00020\u0013\u0012\b\b\u0002\u0010;\u001a\u00020\u0013\u0012\b\b\u0002\u0010<\u001a\u00020\u0016\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010>\u001a\u00020\u0016\u0012\b\b\u0002\u0010?\u001a\u00020\u0016\u0012\b\b\u0002\u0010@\u001a\u00020\u0016\u0012\b\b\u0002\u0010A\u001a\u00020%\u0012\b\b\u0002\u0010B\u001a\u00020\u0016\u0012\b\b\u0002\u0010C\u001a\u00020\u0016\u0012\b\b\u0002\u0010D\u001a\u00020\u0016\u0012\b\b\u0002\u0010E\u001a\u00020\u001e\u0012\b\b\u0002\u0010F\u001a\u00020\u001e¢\u0006\u0004\bG\u0010HJ\t\u0010}\u001a\u00020\u0013HÆ\u0003J\t\u0010~\u001a\u00020\u0013HÆ\u0003J\t\u0010\u001a\u00020\u0016HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010OJ\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020%HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u000202HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0016HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¥\u0001\u001a\u00020%HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0016HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u001eHÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u001eHÆ\u0003Jæ\u0003\u0010«\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u00162\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u00132\b\b\u0002\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u00132\b\b\u0002\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u00020\u00132\b\b\u0002\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u0002022\b\b\u0002\u00105\u001a\u0002022\b\b\u0002\u00106\u001a\u0002022\b\b\u0002\u00107\u001a\u00020\u00162\b\b\u0002\u00108\u001a\u00020\u001e2\b\b\u0002\u00109\u001a\u00020\u001e2\b\b\u0002\u0010:\u001a\u00020\u00132\b\b\u0002\u0010;\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020\u00162\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010>\u001a\u00020\u00162\b\b\u0002\u0010?\u001a\u00020\u00162\b\b\u0002\u0010@\u001a\u00020\u00162\b\b\u0002\u0010A\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020\u00162\b\b\u0002\u0010D\u001a\u00020\u00162\b\b\u0002\u0010E\u001a\u00020\u001e2\b\b\u0002\u0010F\u001a\u00020\u001eHÆ\u0001¢\u0006\u0003\u0010¬\u0001J\u0007\u0010­\u0001\u001a\u00020\u0016J\u0016\u0010®\u0001\u001a\u00020\u001e2\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001HÖ\u0003J\n\u0010±\u0001\u001a\u00020\u0016HÖ\u0001J\n\u0010²\u0001\u001a\u00020\u0013HÖ\u0001J\u001b\u0010³\u0001\u001a\u00030´\u00012\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010·\u0001\u001a\u00020\u0016R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010JR\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\n\n\u0002\u0010P\u001a\u0004\bN\u0010OR\u0014\u0010\u0018\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010MR\u0014\u0010\u0019\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010JR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010JR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0014\u0010!\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010MR\u0014\u0010\"\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010WR\u0014\u0010#\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010MR\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010&\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010JR\u0014\u0010'\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010JR\u0014\u0010(\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010JR\u0014\u0010)\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010JR\u0014\u0010*\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010JR\u0014\u0010+\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010JR\u0014\u0010,\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010JR\u0014\u0010-\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010JR\u0014\u0010.\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010JR\u0014\u0010/\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010JR\u0014\u00100\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010JR\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0014\u00103\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010jR\u0014\u00104\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010jR\u0014\u00105\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010jR\u0014\u00106\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010jR\u0014\u00107\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010MR\u0014\u00108\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010WR\u0014\u00109\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010WR\u0014\u0010:\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010JR\u0014\u0010;\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010JR\u0014\u0010<\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010MR\u0016\u0010=\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010JR\u0014\u0010>\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010MR\u0014\u0010?\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010MR\u0014\u0010@\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010MR\u0014\u0010A\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010]R\u0014\u0010B\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010MR\u0014\u0010C\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010MR\u0014\u0010D\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010MR\u0014\u0010E\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010WR\u0014\u0010F\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010W¨\u0006¸\u0001"}, d2 = {"Lcom/blueair/core/model/DevicePet20;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasPetMainMode;", "Lcom/blueair/core/model/HasDetectCat;", "Lcom/blueair/core/model/HasWeight;", "Lcom/blueair/core/model/HasBody;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "mainMode", "apSubMode", "smartSubMode", "detectCat", "bodyMounted", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIJIIIZZ)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getMainMode", "getApSubMode", "getSmartSubMode", "getDetectCat", "getBodyMounted", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIJIIIZZ)Lcom/blueair/core/model/DevicePet20;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DevicePet20 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasTimer, HasPetMainMode, HasDetectCat, HasWeight, HasBody {
    public static final Parcelable.Creator<DevicePet20> CREATOR = new Creator();
    private final int apSubMode;
    private final String autoModeText;
    private final boolean bodyMounted;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final boolean detectCat;
    private final DeviceUuid deviceUuid;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String g4NightModeFilterTrigger;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isG4NightModeOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String mac;
    private final int mainMode;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final int smartSubMode;
    private final String timeZone;
    private final int timerDuration;
    private final int timerLeftTime;
    private final long timerLeftTimeUpdateTime;
    private final int timerStatus;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DevicePet20> {
        public final DevicePet20 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            IndoorDatapoint indoorDatapoint = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z5 = parcel2.readInt() != 0;
            if (parcel2.readInt() != 0) {
                indoorDatapoint = IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            }
            IndoorDatapoint indoorDatapoint2 = indoorDatapoint;
            boolean z6 = false;
            int readInt3 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z = false;
                z6 = true;
            } else {
                z = false;
            }
            boolean z7 = z;
            int readInt4 = parcel2.readInt();
            long readLong = parcel2.readLong();
            boolean z8 = z7;
            String readString5 = parcel2.readString();
            boolean z9 = z8;
            String readString6 = parcel2.readString();
            boolean z10 = z9;
            String readString7 = parcel2.readString();
            boolean z11 = z10;
            String readString8 = parcel2.readString();
            boolean z12 = z11;
            String readString9 = parcel2.readString();
            boolean z13 = z12;
            String readString10 = parcel2.readString();
            boolean z14 = z13;
            String readString11 = parcel2.readString();
            boolean z15 = z14;
            String readString12 = parcel2.readString();
            boolean z16 = z15;
            String readString13 = parcel2.readString();
            boolean z17 = z16;
            String readString14 = parcel2.readString();
            boolean z18 = z17;
            String readString15 = parcel2.readString();
            boolean z19 = z18;
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z20 = z19;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z21 = z20;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z22 = z21;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z23 = z22;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z24 = z23;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z2 = z24;
                z24 = true;
            } else {
                z2 = z24;
            }
            if (parcel2.readInt() != 0) {
                z3 = z2;
                z2 = true;
            } else {
                z3 = z2;
            }
            boolean z25 = z3;
            String readString16 = parcel2.readString();
            String readString17 = parcel2.readString();
            boolean z26 = z25;
            int readInt6 = parcel2.readInt();
            boolean z27 = z26;
            String readString18 = parcel2.readString();
            boolean z28 = z27;
            int readInt7 = parcel2.readInt();
            boolean z29 = z28;
            int readInt8 = parcel2.readInt();
            boolean z30 = z29;
            int readInt9 = parcel2.readInt();
            boolean z31 = z30;
            long readLong2 = parcel2.readLong();
            boolean z32 = z31;
            int readInt10 = parcel2.readInt();
            boolean z33 = z32;
            int readInt11 = parcel2.readInt();
            boolean z34 = z33;
            int readInt12 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z34;
                z34 = true;
            } else {
                z4 = z34;
            }
            if (parcel2.readInt() != 0) {
                z4 = true;
            }
            return new DevicePet20(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z5, indoorDatapoint2, readInt3, z6, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z24, z2, readString16, readString17, readInt6, readString18, readInt7, readInt8, readInt9, readLong2, readInt10, readInt11, readInt12, z34, z4);
        }

        public final DevicePet20[] newArray(int i) {
            return new DevicePet20[i];
        }
    }

    public static /* synthetic */ DevicePet20 copy$default(DevicePet20 devicePet20, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, boolean z5, boolean z6, int i13, int i14, Object obj) {
        long j3;
        String str19;
        DevicePet20 devicePet202 = devicePet20;
        int i15 = i13;
        int i16 = i14;
        String str20 = (i15 & 1) != 0 ? devicePet202.uid : str;
        String str21 = (i15 & 2) != 0 ? devicePet202.name : str2;
        int i17 = (i15 & 4) != 0 ? devicePet202.fanSpeed : i;
        Integer num2 = (i15 & 8) != 0 ? devicePet202.filterLife : num;
        int i18 = (i15 & 16) != 0 ? devicePet202.brightness : i2;
        String str22 = (i15 & 32) != 0 ? devicePet202.autoModeText : str3;
        String str23 = (i15 & 64) != 0 ? devicePet202.info : str4;
        DeviceUuid deviceUuid3 = (i15 & 128) != 0 ? devicePet202.deviceUuid : deviceUuid2;
        boolean z7 = (i15 & 256) != 0 ? devicePet202.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint2 = (i15 & 512) != 0 ? devicePet202.latestSensorDatapoint : indoorDatapoint;
        int i19 = (i15 & 1024) != 0 ? devicePet202.lastSelectedSensorTypeIndex : i3;
        boolean z8 = (i15 & 2048) != 0 ? devicePet202.isChildLockOn : z2;
        int i20 = (i15 & 4096) != 0 ? devicePet202.connectivityStatusIndex : i4;
        String str24 = str20;
        String str25 = str21;
        long j4 = (i15 & 8192) != 0 ? devicePet202.lastConnectivityInMillis : j;
        String str26 = (i15 & 16384) != 0 ? devicePet202.mac : str5;
        String str27 = (32768 & i15) != 0 ? devicePet202.mcuFirmware : str6;
        String str28 = (i15 & 65536) != 0 ? devicePet202.wifiFirmware : str7;
        String str29 = (i13 & 131072) != 0 ? devicePet202.hardware : str8;
        String str30 = (i13 & 262144) != 0 ? devicePet202.timeZone : str9;
        String str31 = (i13 & 524288) != 0 ? devicePet202.serial : str10;
        String str32 = (i13 & 1048576) != 0 ? devicePet202.purchaseDate : str11;
        String str33 = (i13 & 2097152) != 0 ? devicePet202.dealerName : str12;
        String str34 = (i13 & 4194304) != 0 ? devicePet202.dealerCountry : str13;
        String str35 = (i13 & 8388608) != 0 ? devicePet202.filterType : str14;
        String str36 = (i13 & 16777216) != 0 ? devicePet202.filterTrigger : str15;
        double[] dArr6 = (i13 & 33554432) != 0 ? devicePet202.pm1Ranges : dArr;
        double[] dArr7 = (i13 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? devicePet202.pm10Ranges : dArr2;
        double[] dArr8 = (i13 & 134217728) != 0 ? devicePet202.pm25Ranges : dArr3;
        double[] dArr9 = (i13 & 268435456) != 0 ? devicePet202.vocRanges : dArr4;
        double[] dArr10 = (i13 & 536870912) != 0 ? devicePet202.hchoRanges : dArr5;
        int i21 = (i13 & 1073741824) != 0 ? devicePet202.updateProgress : i5;
        boolean z9 = (i13 & Integer.MIN_VALUE) != 0 ? devicePet202.isStandByOn : z3;
        boolean z10 = (i16 & 1) != 0 ? devicePet202.isG4NightModeOn : z4;
        String str37 = (i16 & 2) != 0 ? devicePet202.g4NightModeFilterTrigger : str16;
        String str38 = (i16 & 4) != 0 ? devicePet202.modelName : str17;
        int i22 = (i16 & 8) != 0 ? devicePet202.typeIndex : i6;
        String str39 = (i16 & 16) != 0 ? devicePet202.sku : str18;
        int i23 = (i16 & 32) != 0 ? devicePet202.timerStatus : i7;
        int i24 = (i16 & 64) != 0 ? devicePet202.timerDuration : i8;
        int i25 = (i16 & 128) != 0 ? devicePet202.timerLeftTime : i9;
        String str40 = str26;
        if ((i16 & 256) != 0) {
            str19 = str27;
            j3 = devicePet202.timerLeftTimeUpdateTime;
        } else {
            str19 = str27;
            j3 = j2;
        }
        return devicePet202.copy(str24, str25, i17, num2, i18, str22, str23, deviceUuid3, z7, indoorDatapoint2, i19, z8, i20, j4, str40, str19, str28, str29, str30, str31, str32, str33, str34, str35, str36, dArr6, dArr7, dArr8, dArr9, dArr10, i21, z9, z10, str37, str38, i22, str39, i23, i24, i25, j3, (i16 & 512) != 0 ? devicePet202.mainMode : i10, (i16 & 1024) != 0 ? devicePet202.apSubMode : i11, (i16 & 2048) != 0 ? devicePet202.smartSubMode : i12, (i16 & 4096) != 0 ? devicePet202.detectCat : z5, (i16 & 8192) != 0 ? devicePet202.bodyMounted : z6);
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

    public final boolean component33() {
        return this.isG4NightModeOn;
    }

    public final String component34() {
        return this.g4NightModeFilterTrigger;
    }

    public final String component35() {
        return this.modelName;
    }

    public final int component36() {
        return this.typeIndex;
    }

    public final String component37() {
        return this.sku;
    }

    public final int component38() {
        return this.timerStatus;
    }

    public final int component39() {
        return this.timerDuration;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final int component40() {
        return this.timerLeftTime;
    }

    public final long component41() {
        return this.timerLeftTimeUpdateTime;
    }

    public final int component42() {
        return this.mainMode;
    }

    public final int component43() {
        return this.apSubMode;
    }

    public final int component44() {
        return this.smartSubMode;
    }

    public final boolean component45() {
        return this.detectCat;
    }

    public final boolean component46() {
        return this.bodyMounted;
    }

    public final int component5() {
        return this.brightness;
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

    public final DevicePet20 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, boolean z5, boolean z6) {
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
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        Intrinsics.checkNotNullParameter(str17, "modelName");
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
        return new DevicePet20(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, str16, str17, i6, str18, i7, i8, i9, j2, i10, i11, i12, z5, z6);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DevicePet20)) {
            return false;
        }
        DevicePet20 devicePet20 = (DevicePet20) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) devicePet20.uid) && Intrinsics.areEqual((Object) this.name, (Object) devicePet20.name) && this.fanSpeed == devicePet20.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) devicePet20.filterLife) && this.brightness == devicePet20.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) devicePet20.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) devicePet20.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) devicePet20.deviceUuid) && this.hasFinishedOnboarding == devicePet20.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) devicePet20.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == devicePet20.lastSelectedSensorTypeIndex && this.isChildLockOn == devicePet20.isChildLockOn && this.connectivityStatusIndex == devicePet20.connectivityStatusIndex && this.lastConnectivityInMillis == devicePet20.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) devicePet20.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) devicePet20.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) devicePet20.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) devicePet20.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) devicePet20.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) devicePet20.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) devicePet20.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) devicePet20.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) devicePet20.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) devicePet20.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) devicePet20.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) devicePet20.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) devicePet20.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) devicePet20.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) devicePet20.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) devicePet20.hchoRanges) && this.updateProgress == devicePet20.updateProgress && this.isStandByOn == devicePet20.isStandByOn && this.isG4NightModeOn == devicePet20.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) devicePet20.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) devicePet20.modelName) && this.typeIndex == devicePet20.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) devicePet20.sku) && this.timerStatus == devicePet20.timerStatus && this.timerDuration == devicePet20.timerDuration && this.timerLeftTime == devicePet20.timerLeftTime && this.timerLeftTimeUpdateTime == devicePet20.timerLeftTimeUpdateTime && this.mainMode == devicePet20.mainMode && this.apSubMode == devicePet20.apSubMode && this.smartSubMode == devicePet20.smartSubMode && this.detectCat == devicePet20.detectCat && this.bodyMounted == devicePet20.bodyMounted;
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
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn)) * 31) + this.g4NightModeFilterTrigger.hashCode()) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((((((((((((hashCode5 + i) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31) + this.mainMode) * 31) + this.apSubMode) * 31) + this.smartSubMode) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.detectCat)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.bodyMounted);
    }

    public String toString() {
        return "DevicePet20(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", smartSubMode=" + this.smartSubMode + ", detectCat=" + this.detectCat + ", bodyMounted=" + this.bodyMounted + ')';
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
        parcel.writeInt(this.isG4NightModeOn ? 1 : 0);
        parcel.writeString(this.g4NightModeFilterTrigger);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.typeIndex);
        parcel.writeString(this.sku);
        parcel.writeInt(this.timerStatus);
        parcel.writeInt(this.timerDuration);
        parcel.writeInt(this.timerLeftTime);
        parcel.writeLong(this.timerLeftTimeUpdateTime);
        parcel.writeInt(this.mainMode);
        parcel.writeInt(this.apSubMode);
        parcel.writeInt(this.smartSubMode);
        parcel.writeInt(this.detectCat ? 1 : 0);
        parcel.writeInt(this.bodyMounted ? 1 : 0);
    }

    public double[] airRatingsFor(SensorType sensorType) {
        return HasSensorData.CC.$default$airRatingsFor(this, sensorType);
    }

    public ApSubMode apSubMode() {
        return HasMainMode.CC.$default$apSubMode(this);
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

    public FilterTrigger getG4NightModeTrigger() {
        return HasG4NightMode.CC.$default$getG4NightModeTrigger(this);
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

    public UiG4NightMode getUiG4NightMode() {
        return HasG4NightMode.CC.$default$getUiG4NightMode(this);
    }

    public boolean isInApSubMode(ApSubMode apSubMode2) {
        return HasMainMode.CC.$default$isInApSubMode(this, apSubMode2);
    }

    public boolean isInMainMode(MainMode mainMode2) {
        return HasMainMode.CC.$default$isInMainMode(this, mainMode2);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public MainMode mainMode() {
        return HasMainMode.CC.$default$mainMode(this);
    }

    public SmartSubMode smartSubMode() {
        return HasPetMainMode.CC.$default$smartSubMode(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public TimerState timerStatus() {
        return HasTimer.CC.$default$timerStatus(this);
    }

    public DevicePet20(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, boolean z5, boolean z6) {
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
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        String str33 = str17;
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
        this.isG4NightModeOn = z4;
        this.g4NightModeFilterTrigger = str16;
        this.modelName = str33;
        this.typeIndex = i6;
        this.sku = str18;
        this.timerStatus = i7;
        this.timerDuration = i8;
        this.timerLeftTime = i9;
        this.timerLeftTimeUpdateTime = j2;
        this.mainMode = i10;
        this.apSubMode = i11;
        this.smartSubMode = i12;
        this.detectCat = z5;
        this.bodyMounted = z6;
    }

    public String getUid() {
        return this.uid;
    }

    public /* synthetic */ DevicePet20(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, int i7, int i8, int i9, long j2, int i10, int i11, int i12, boolean z5, boolean z6, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        double[] dArr6;
        boolean z7;
        boolean z8;
        int i15;
        int i16;
        int i17;
        long j3;
        int i18;
        int i19;
        int i20;
        String str19;
        int i21;
        String str20;
        String str21;
        boolean z9;
        boolean z10;
        int i22;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
        double[] dArr11;
        String str22;
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
        long j4;
        int i23;
        boolean z11;
        int i24;
        IndoorDatapoint indoorDatapoint2;
        boolean z12;
        DeviceUuid deviceUuid3;
        String str33;
        String str34;
        int i25;
        Integer num2;
        int i26;
        String str35;
        String str36;
        DevicePet20 devicePet20;
        int i27 = i13;
        int i28 = i14;
        String str37 = (i27 & 2) != 0 ? "Pairing…" : str2;
        int i29 = (i27 & 4) != 0 ? 0 : i;
        Integer num3 = (i27 & 8) != 0 ? null : num;
        int i30 = (i27 & 16) != 0 ? 0 : i2;
        String str38 = "";
        String str39 = (i27 & 32) != 0 ? str38 : str3;
        String str40 = (i27 & 64) != 0 ? null : str4;
        DeviceUuid deviceUuid4 = (i27 & 128) != 0 ? null : deviceUuid2;
        boolean z13 = (i27 & 256) != 0 ? false : z;
        IndoorDatapoint indoorDatapoint3 = (i27 & 512) != 0 ? null : indoorDatapoint;
        int i31 = (i27 & 1024) != 0 ? 0 : i3;
        boolean z14 = (i27 & 2048) != 0 ? false : z2;
        int ordinal = (i27 & 4096) != 0 ? ConnectivityStatus.ONLINE.ordinal() : i4;
        long j5 = 0;
        long j6 = (i27 & 8192) != 0 ? 0 : j;
        String str41 = (i27 & 16384) != 0 ? str38 : str5;
        String str42 = (i27 & 32768) != 0 ? str38 : str6;
        String str43 = (i27 & 65536) != 0 ? str38 : str7;
        String str44 = (i27 & 131072) != 0 ? str38 : str8;
        String str45 = (i27 & 262144) != 0 ? str38 : str9;
        String str46 = (i27 & 524288) != 0 ? str38 : str10;
        String str47 = (i27 & 1048576) != 0 ? str38 : str11;
        String str48 = (i27 & 2097152) != 0 ? str38 : str12;
        String str49 = (i27 & 4194304) != 0 ? str38 : str13;
        String str50 = (i27 & 8388608) != 0 ? str38 : str14;
        String str51 = (i27 & 16777216) != 0 ? str38 : str15;
        String str52 = str37;
        if ((i27 & 33554432) != 0) {
            dArr6 = new double[0];
        } else {
            dArr6 = dArr;
        }
        double[] dArr12 = dArr6;
        double[] dArr13 = (i13 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? new double[0] : dArr2;
        double[] dArr14 = (i13 & 134217728) != 0 ? new double[0] : dArr3;
        double[] dArr15 = (i13 & 268435456) != 0 ? new double[0] : dArr4;
        double[] dArr16 = (i13 & 536870912) != 0 ? new double[0] : dArr5;
        int i32 = (i13 & 1073741824) != 0 ? 0 : i5;
        boolean z15 = (i13 & Integer.MIN_VALUE) != 0 ? false : z3;
        boolean z16 = (i28 & 1) != 0 ? false : z4;
        String str53 = (i28 & 2) != 0 ? str38 : str16;
        str38 = (i28 & 4) == 0 ? str17 : str38;
        int index = (i28 & 8) != 0 ? DeviceType.Pet20.INSTANCE.getIndex() : i6;
        String str54 = (i28 & 16) != 0 ? null : str18;
        int i33 = (i28 & 32) != 0 ? 0 : i7;
        int i34 = (i28 & 64) != 0 ? 0 : i8;
        int i35 = (i28 & 128) != 0 ? 0 : i9;
        j5 = (i28 & 256) == 0 ? j2 : j5;
        int i36 = (i28 & 512) != 0 ? 0 : i10;
        int i37 = (i28 & 1024) != 0 ? 2 : i11;
        int i38 = (i28 & 2048) != 0 ? 0 : i12;
        boolean z17 = (i28 & 4096) != 0 ? false : z5;
        if ((i28 & 8192) != 0) {
            z7 = true;
            devicePet20 = this;
            dArr11 = dArr12;
            dArr10 = dArr13;
            dArr9 = dArr14;
            dArr8 = dArr15;
            i18 = i35;
            i17 = i36;
            i16 = i37;
            i15 = i38;
            str35 = str52;
            z8 = z17;
            dArr7 = dArr16;
            i26 = i29;
            str32 = str41;
            num2 = num3;
            i23 = ordinal;
            i25 = i30;
            str34 = str39;
            str20 = str38;
            str33 = str40;
            deviceUuid3 = deviceUuid4;
            z12 = z13;
            indoorDatapoint2 = indoorDatapoint3;
            i24 = i31;
            z11 = z14;
            j3 = j5;
            j4 = j6;
            str31 = str42;
            str30 = str43;
            str29 = str44;
            str28 = str45;
            str27 = str46;
            str26 = str47;
            str25 = str48;
            str24 = str49;
            str23 = str50;
            str22 = str51;
            i22 = i32;
            z10 = z15;
            z9 = z16;
            str21 = str53;
            i21 = index;
            str19 = str54;
            i20 = i33;
            i19 = i34;
            str36 = str;
        } else {
            z7 = z6;
            devicePet20 = this;
            dArr11 = dArr12;
            dArr10 = dArr13;
            dArr9 = dArr14;
            dArr8 = dArr15;
            i18 = i35;
            i17 = i36;
            i16 = i37;
            str35 = str52;
            z8 = z17;
            dArr7 = dArr16;
            i26 = i29;
            str32 = str41;
            num2 = num3;
            i23 = ordinal;
            i25 = i30;
            str34 = str39;
            str20 = str38;
            str33 = str40;
            z12 = z13;
            indoorDatapoint2 = indoorDatapoint3;
            i24 = i31;
            z11 = z14;
            j3 = j5;
            j4 = j6;
            str31 = str42;
            str30 = str43;
            str29 = str44;
            str28 = str45;
            str27 = str46;
            str26 = str47;
            str25 = str48;
            str24 = str49;
            str23 = str50;
            str22 = str51;
            i22 = i32;
            z10 = z15;
            z9 = z16;
            str21 = str53;
            i21 = index;
            str19 = str54;
            i20 = i33;
            i19 = i34;
            str36 = str;
            i15 = i38;
            deviceUuid3 = deviceUuid4;
        }
        new DevicePet20(str36, str35, i26, num2, i25, str34, str33, deviceUuid3, z12, indoorDatapoint2, i24, z11, i23, j4, str32, str31, str30, str29, str28, str27, str26, str25, str24, str23, str22, dArr11, dArr10, dArr9, dArr8, dArr7, i22, z10, z9, str21, str20, i21, str19, i20, i19, i18, j3, i17, i16, i15, z8, z7);
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

    public boolean isG4NightModeOn() {
        return this.isG4NightModeOn;
    }

    public String getG4NightModeFilterTrigger() {
        return this.g4NightModeFilterTrigger;
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

    public int getMainMode() {
        return this.mainMode;
    }

    public int getApSubMode() {
        return this.apSubMode;
    }

    public int getSmartSubMode() {
        return this.smartSubMode;
    }

    public boolean getDetectCat() {
        return this.detectCat;
    }

    public boolean getBodyMounted() {
        return this.bodyMounted;
    }
}
