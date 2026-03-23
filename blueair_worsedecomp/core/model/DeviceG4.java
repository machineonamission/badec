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
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\bp\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u0010BÑ\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\b\b\u0002\u0010%\u001a\u00020\u0012\u0012\b\b\u0002\u0010&\u001a\u00020\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0012\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\b\b\u0002\u0010+\u001a\u00020\u0012\u0012\b\b\u0002\u0010,\u001a\u00020\u0012\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u0012\u0012\b\b\u0002\u00100\u001a\u000201\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u00103\u001a\u000201\u0012\b\b\u0002\u00104\u001a\u000201\u0012\b\b\u0002\u00105\u001a\u000201\u0012\b\b\u0002\u00106\u001a\u00020\u0015\u0012\b\b\u0002\u00107\u001a\u00020\u001d\u0012\b\b\u0002\u00108\u001a\u00020\u001d\u0012\b\b\u0002\u00109\u001a\u00020\u001d\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010;\u001a\u00020\u0012\u0012\b\b\u0002\u0010<\u001a\u00020\u001d\u0012\b\b\u0002\u0010=\u001a\u00020\u0012\u0012\b\b\u0002\u0010>\u001a\u00020\u0015\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010$¢\u0006\u0004\bE\u0010FJ\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010MJ\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001dHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0001\u001a\u00020$HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u000201HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u001dHÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010nJ\n\u0010¤\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010AHÆ\u0003J\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010nJ\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010MJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u0010yJÜ\u0003\u0010­\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u0010+\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\b\b\u0002\u00105\u001a\u0002012\b\b\u0002\u00106\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\u001d2\b\b\u0002\u00108\u001a\u00020\u001d2\b\b\u0002\u00109\u001a\u00020\u001d2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010;\u001a\u00020\u00122\b\b\u0002\u0010<\u001a\u00020\u001d2\b\b\u0002\u0010=\u001a\u00020\u00122\b\b\u0002\u0010>\u001a\u00020\u00152\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010D\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0003\u0010®\u0001J\u0007\u0010¯\u0001\u001a\u00020\u0015J\u0016\u0010°\u0001\u001a\u00020\u001d2\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001HÖ\u0003J\n\u0010³\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010´\u0001\u001a\u00020\u0012HÖ\u0001J\u001b\u0010µ\u0001\u001a\u00030¶\u00012\b\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u0015R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010HR\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\n\n\u0002\u0010N\u001a\u0004\bL\u0010MR\u0014\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u0014\u0010\u0018\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010HR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010HR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010 \u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010KR\u0014\u0010!\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010UR\u0014\u0010\"\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010KR\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0014\u0010%\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010HR\u0014\u0010&\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010HR\u0014\u0010'\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010HR\u0014\u0010(\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010HR\u0014\u0010)\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010HR\u0014\u0010*\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010HR\u0014\u0010+\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010HR\u0014\u0010,\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010HR\u0014\u0010-\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010HR\u0014\u0010.\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010HR\u0014\u0010/\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010HR\u0014\u00100\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0014\u00102\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010hR\u0014\u00103\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010hR\u0014\u00104\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010hR\u0014\u00105\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010hR\u0014\u00106\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010KR\u0014\u00107\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010UR\u0014\u00108\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010UR\u0014\u00109\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010UR\u0018\u0010:\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\n\n\u0002\u0010o\u001a\u0004\b:\u0010nR\u0014\u0010;\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010HR\u0014\u0010<\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010UR\u0014\u0010=\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010HR\u0014\u0010>\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010KR\u0016\u0010?\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010HR\u0016\u0010@\u001a\u0004\u0018\u00010AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0018\u0010B\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\n\n\u0002\u0010o\u001a\u0004\bv\u0010nR\u0018\u0010C\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\n\n\u0002\u0010N\u001a\u0004\bw\u0010MR\u0018\u0010D\u001a\u0004\u0018\u00010$X\u0004¢\u0006\n\n\u0002\u0010z\u001a\u0004\bx\u0010yR\u0011\u0010{\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b{\u0010UR\u0011\u0010|\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b|\u0010UR\u0011\u0010}\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b~\u0010HR\u0012\u0010\u001a\u00020\u00128F¢\u0006\u0007\u001a\u0005\b\u0001\u0010H¨\u0006º\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceG4;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasGermShieldMode;", "Lcom/blueair/core/model/HasSafetySwitch;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasDisinfection;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "isGermShieldModeOn", "isGermShieldNightModeOn", "g4NightModeFilterTrigger", "isSafetySwitchOn", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "disinfection", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZLjava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getDisinfection", "getDisinfectLeftTime", "getDisinfectLeftTimeUpdateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isSuperPremium", "isPlus", "modelNumber", "getModelNumber", "modelSeries", "getModelSeries", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZLjava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/blueair/core/model/DeviceG4;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceG4 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasGermShieldMode, HasSafetySwitch, HasScheduling, HasSKU, HasWelcomeHome, HasDisinfection {
    public static final Parcelable.Creator<DeviceG4> CREATOR = new Creator();
    private final String autoModeText;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final DeviceUuid deviceUuid;
    private final Integer disinfectLeftTime;
    private final Long disinfectLeftTimeUpdateTime;
    private final Boolean disinfection;
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
    private final boolean isGermShieldModeOn;
    private final Boolean isGermShieldNightModeOn;
    private final boolean isSafetySwitchOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String mac;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final WelcomeHomeLocation welcomeHome;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceG4> {
        public final DeviceG4 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            boolean z5;
            boolean z6;
            Boolean valueOf;
            boolean z7;
            boolean z8;
            boolean z9;
            Boolean bool;
            Boolean bool2;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            Integer valueOf2 = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z10 = parcel2.readInt() != 0;
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
            boolean z11 = z2;
            long readLong = parcel2.readLong();
            boolean z12 = z11;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z13 = z12;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z14 = z13;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z15 = z14;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z16 = z15;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z17 = z16;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z18 = z17;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z19 = z18;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z20 = z;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z21 = z19;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z20;
                z20 = z21;
            } else {
                z4 = z20;
            }
            if (parcel2.readInt() != 0) {
                z5 = z21;
            } else {
                z5 = z21;
                z21 = z4;
            }
            if (parcel2.readInt() != 0) {
                z6 = z4;
                z4 = z5;
            } else {
                z6 = z4;
            }
            if (parcel2.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel2.readInt() != 0 ? z5 : z6);
            }
            boolean z22 = z6;
            String readString16 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                z8 = z5;
                z7 = z22;
                bool = valueOf;
                z9 = z8;
            } else {
                z8 = z5;
                bool = valueOf;
                z9 = z22;
                z7 = z9;
            }
            String readString17 = parcel2.readString();
            boolean z23 = z8;
            int readInt6 = parcel2.readInt();
            boolean z24 = z7;
            String readString18 = parcel2.readString();
            WelcomeHomeLocation createFromParcel3 = parcel2.readInt() == 0 ? null : WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            if (parcel2.readInt() == 0) {
                bool2 = null;
            } else {
                if (parcel2.readInt() == 0) {
                    z23 = z24;
                }
                bool2 = Boolean.valueOf(z23);
            }
            return new DeviceG4(readString, readString2, readInt, valueOf2, readInt2, readString3, readString4, createFromParcel, z10, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z20, z21, z4, bool, readString16, z9, readString17, readInt6, readString18, createFromParcel3, bool2, parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt()), parcel2.readInt() == 0 ? null : Long.valueOf(parcel2.readLong()));
        }

        public final DeviceG4[] newArray(int i) {
            return new DeviceG4[i];
        }
    }

    public static /* synthetic */ DeviceG4 copy$default(DeviceG4 deviceG4, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, Boolean bool, String str16, boolean z6, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, Boolean bool2, Integer num2, Long l, int i7, int i8, Object obj) {
        DeviceG4 deviceG42 = deviceG4;
        int i9 = i7;
        int i10 = i8;
        return deviceG42.copy((i9 & 1) != 0 ? deviceG42.uid : str, (i9 & 2) != 0 ? deviceG42.name : str2, (i9 & 4) != 0 ? deviceG42.fanSpeed : i, (i9 & 8) != 0 ? deviceG42.filterLife : num, (i9 & 16) != 0 ? deviceG42.brightness : i2, (i9 & 32) != 0 ? deviceG42.autoModeText : str3, (i9 & 64) != 0 ? deviceG42.info : str4, (i9 & 128) != 0 ? deviceG42.deviceUuid : deviceUuid2, (i9 & 256) != 0 ? deviceG42.hasFinishedOnboarding : z, (i9 & 512) != 0 ? deviceG42.latestSensorDatapoint : indoorDatapoint, (i9 & 1024) != 0 ? deviceG42.lastSelectedSensorTypeIndex : i3, (i9 & 2048) != 0 ? deviceG42.isChildLockOn : z2, (i9 & 4096) != 0 ? deviceG42.connectivityStatusIndex : i4, (i9 & 8192) != 0 ? deviceG42.lastConnectivityInMillis : j, (i9 & 16384) != 0 ? deviceG42.mac : str5, (32768 & i9) != 0 ? deviceG42.mcuFirmware : str6, (i9 & 65536) != 0 ? deviceG42.wifiFirmware : str7, (i7 & 131072) != 0 ? deviceG42.hardware : str8, (i7 & 262144) != 0 ? deviceG42.timeZone : str9, (i7 & 524288) != 0 ? deviceG42.serial : str10, (i7 & 1048576) != 0 ? deviceG42.purchaseDate : str11, (i7 & 2097152) != 0 ? deviceG42.dealerName : str12, (i7 & 4194304) != 0 ? deviceG42.dealerCountry : str13, (i7 & 8388608) != 0 ? deviceG42.filterType : str14, (i7 & 16777216) != 0 ? deviceG42.filterTrigger : str15, (i7 & 33554432) != 0 ? deviceG42.pm1Ranges : dArr, (i7 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceG42.pm10Ranges : dArr2, (i7 & 134217728) != 0 ? deviceG42.pm25Ranges : dArr3, (i7 & 268435456) != 0 ? deviceG42.vocRanges : dArr4, (i7 & 536870912) != 0 ? deviceG42.hchoRanges : dArr5, (i7 & 1073741824) != 0 ? deviceG42.updateProgress : i5, (i7 & Integer.MIN_VALUE) != 0 ? deviceG42.isStandByOn : z3, (i10 & 1) != 0 ? deviceG42.isG4NightModeOn : z4, (i10 & 2) != 0 ? deviceG42.isGermShieldModeOn : z5, (i10 & 4) != 0 ? deviceG42.isGermShieldNightModeOn : bool, (i10 & 8) != 0 ? deviceG42.g4NightModeFilterTrigger : str16, (i10 & 16) != 0 ? deviceG42.isSafetySwitchOn : z6, (i10 & 32) != 0 ? deviceG42.modelName : str17, (i10 & 64) != 0 ? deviceG42.typeIndex : i6, (i10 & 128) != 0 ? deviceG42.sku : str18, (i10 & 256) != 0 ? deviceG42.welcomeHome : welcomeHomeLocation, (i10 & 512) != 0 ? deviceG42.disinfection : bool2, (i10 & 1024) != 0 ? deviceG42.disinfectLeftTime : num2, (i10 & 2048) != 0 ? deviceG42.disinfectLeftTimeUpdateTime : l);
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

    public final boolean component34() {
        return this.isGermShieldModeOn;
    }

    public final Boolean component35() {
        return this.isGermShieldNightModeOn;
    }

    public final String component36() {
        return this.g4NightModeFilterTrigger;
    }

    public final boolean component37() {
        return this.isSafetySwitchOn;
    }

    public final String component38() {
        return this.modelName;
    }

    public final int component39() {
        return this.typeIndex;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final String component40() {
        return this.sku;
    }

    public final WelcomeHomeLocation component41() {
        return this.welcomeHome;
    }

    public final Boolean component42() {
        return this.disinfection;
    }

    public final Integer component43() {
        return this.disinfectLeftTime;
    }

    public final Long component44() {
        return this.disinfectLeftTimeUpdateTime;
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

    public final DeviceG4 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, Boolean bool, String str16, boolean z6, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, Boolean bool2, Integer num2, Long l) {
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
        return new DeviceG4(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, z5, bool, str16, z6, str17, i6, str18, welcomeHomeLocation, bool2, num2, l);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceG4)) {
            return false;
        }
        DeviceG4 deviceG4 = (DeviceG4) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceG4.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceG4.name) && this.fanSpeed == deviceG4.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceG4.filterLife) && this.brightness == deviceG4.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceG4.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceG4.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceG4.deviceUuid) && this.hasFinishedOnboarding == deviceG4.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceG4.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceG4.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceG4.isChildLockOn && this.connectivityStatusIndex == deviceG4.connectivityStatusIndex && this.lastConnectivityInMillis == deviceG4.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceG4.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceG4.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceG4.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceG4.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceG4.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceG4.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceG4.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceG4.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceG4.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceG4.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceG4.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceG4.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceG4.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceG4.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceG4.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceG4.hchoRanges) && this.updateProgress == deviceG4.updateProgress && this.isStandByOn == deviceG4.isStandByOn && this.isG4NightModeOn == deviceG4.isG4NightModeOn && this.isGermShieldModeOn == deviceG4.isGermShieldModeOn && Intrinsics.areEqual((Object) this.isGermShieldNightModeOn, (Object) deviceG4.isGermShieldNightModeOn) && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceG4.g4NightModeFilterTrigger) && this.isSafetySwitchOn == deviceG4.isSafetySwitchOn && Intrinsics.areEqual((Object) this.modelName, (Object) deviceG4.modelName) && this.typeIndex == deviceG4.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceG4.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceG4.welcomeHome) && Intrinsics.areEqual((Object) this.disinfection, (Object) deviceG4.disinfection) && Intrinsics.areEqual((Object) this.disinfectLeftTime, (Object) deviceG4.disinfectLeftTime) && Intrinsics.areEqual((Object) this.disinfectLeftTimeUpdateTime, (Object) deviceG4.disinfectLeftTimeUpdateTime);
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
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isGermShieldModeOn)) * 31;
        Boolean bool = this.isGermShieldNightModeOn;
        int hashCode6 = (((((((((hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31) + this.g4NightModeFilterTrigger.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isSafetySwitchOn)) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        int hashCode8 = (hashCode7 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31;
        Boolean bool2 = this.disinfection;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num2 = this.disinfectLeftTime;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.disinfectLeftTimeUpdateTime;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "DeviceG4(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", isGermShieldModeOn=" + this.isGermShieldModeOn + ", isGermShieldNightModeOn=" + this.isGermShieldNightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", isSafetySwitchOn=" + this.isSafetySwitchOn + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ", disinfection=" + this.disinfection + ", disinfectLeftTime=" + this.disinfectLeftTime + ", disinfectLeftTimeUpdateTime=" + this.disinfectLeftTimeUpdateTime + ')';
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
        parcel.writeInt(this.isGermShieldModeOn ? 1 : 0);
        Boolean bool = this.isGermShieldNightModeOn;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.g4NightModeFilterTrigger);
        parcel.writeInt(this.isSafetySwitchOn ? 1 : 0);
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
        Boolean bool2 = this.disinfection;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.disinfectLeftTime;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Long l = this.disinfectLeftTimeUpdateTime;
        if (l == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l.longValue());
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

    public FilterTrigger getG4NightModeTrigger() {
        return HasG4NightMode.CC.$default$getG4NightModeTrigger(this);
    }

    public boolean getHasGear0() {
        return HasFanSpeed.CC.$default$getHasGear0(this);
    }

    public boolean getHasGear4() {
        return HasFanSpeed.CC.$default$getHasGear4(this);
    }

    public boolean getHasGermShieldNightMode() {
        return HasGermShieldMode.CC.$default$getHasGermShieldNightMode(this);
    }

    public SensorType getLastSelectedSensorType() {
        return HasSensorData.CC.$default$getLastSelectedSensorType(this);
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

    public boolean isGermShieldPlus() {
        return HasGermShieldMode.CC.$default$isGermShieldPlus(this);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public DeviceG4(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, Boolean bool, String str16, boolean z6, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, Boolean bool2, Integer num2, Long l) {
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
        this.isGermShieldModeOn = z5;
        this.isGermShieldNightModeOn = bool;
        this.g4NightModeFilterTrigger = str16;
        this.isSafetySwitchOn = z6;
        this.modelName = str33;
        this.typeIndex = i6;
        this.sku = str18;
        this.welcomeHome = welcomeHomeLocation;
        this.disinfection = bool2;
        this.disinfectLeftTime = num2;
        this.disinfectLeftTimeUpdateTime = l;
    }

    public String getUid() {
        return this.uid;
    }

    public /* synthetic */ DeviceG4(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, Boolean bool, String str16, boolean z6, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, Boolean bool2, Integer num2, Long l, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        double[] dArr6;
        Long l2;
        Integer num3;
        Boolean bool3;
        WelcomeHomeLocation welcomeHomeLocation2;
        String str19;
        int i9;
        String str20;
        boolean z7;
        String str21;
        Boolean bool4;
        boolean z8;
        boolean z9;
        boolean z10;
        int i10;
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
        long j2;
        int i11;
        boolean z11;
        int i12;
        IndoorDatapoint indoorDatapoint2;
        boolean z12;
        DeviceUuid deviceUuid3;
        String str33;
        String str34;
        int i13;
        Integer num4;
        int i14;
        String str35;
        String str36;
        DeviceG4 deviceG4;
        int i15 = i7;
        int i16 = i8;
        String str37 = (i15 & 2) != 0 ? "Pairing…" : str2;
        int i17 = (i15 & 4) != 0 ? 0 : i;
        Integer num5 = (i15 & 8) != 0 ? null : num;
        int i18 = (i15 & 16) != 0 ? 0 : i2;
        String str38 = "";
        String str39 = (i15 & 32) != 0 ? str38 : str3;
        String str40 = (i15 & 64) != 0 ? null : str4;
        DeviceUuid deviceUuid4 = (i15 & 128) != 0 ? null : deviceUuid2;
        boolean z13 = (i15 & 256) != 0 ? false : z;
        IndoorDatapoint indoorDatapoint3 = (i15 & 512) != 0 ? null : indoorDatapoint;
        int i19 = (i15 & 1024) != 0 ? 0 : i3;
        boolean z14 = (i15 & 2048) != 0 ? false : z2;
        int ordinal = (i15 & 4096) != 0 ? ConnectivityStatus.ONLINE.ordinal() : i4;
        long j3 = (i15 & 8192) != 0 ? 0 : j;
        String str41 = (i15 & 16384) != 0 ? str38 : str5;
        String str42 = (i15 & 32768) != 0 ? str38 : str6;
        String str43 = (i15 & 65536) != 0 ? str38 : str7;
        String str44 = (i15 & 131072) != 0 ? str38 : str8;
        String str45 = (i15 & 262144) != 0 ? str38 : str9;
        String str46 = (i15 & 524288) != 0 ? str38 : str10;
        String str47 = (i15 & 1048576) != 0 ? str38 : str11;
        String str48 = (i15 & 2097152) != 0 ? str38 : str12;
        String str49 = (i15 & 4194304) != 0 ? str38 : str13;
        String str50 = (i15 & 8388608) != 0 ? str38 : str14;
        String str51 = (i15 & 16777216) != 0 ? str38 : str15;
        int i20 = i15 & 33554432;
        String str52 = str37;
        boolean z15 = false;
        if (i20 != 0) {
            dArr6 = new double[0];
        } else {
            dArr6 = dArr;
        }
        double[] dArr12 = dArr6;
        double[] dArr13 = (i7 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? new double[0] : dArr2;
        double[] dArr14 = (i7 & 134217728) != 0 ? new double[0] : dArr3;
        double[] dArr15 = (i7 & 268435456) != 0 ? new double[0] : dArr4;
        double[] dArr16 = (i7 & 536870912) != 0 ? new double[0] : dArr5;
        int i21 = (i7 & 1073741824) != 0 ? 0 : i5;
        boolean z16 = (i7 & Integer.MIN_VALUE) != 0 ? false : z3;
        boolean z17 = (i16 & 1) != 0 ? false : z4;
        z15 = (i16 & 2) == 0 ? z5 : z15;
        Boolean bool5 = (i16 & 4) != 0 ? null : bool;
        String str53 = (i16 & 8) != 0 ? str38 : str16;
        boolean z18 = (i16 & 16) != 0 ? true : z6;
        str38 = (i16 & 32) == 0 ? str17 : str38;
        int index = (i16 & 64) != 0 ? DeviceType.G4.INSTANCE.getIndex() : i6;
        boolean z19 = z15;
        String str54 = (i16 & 128) != 0 ? null : str18;
        WelcomeHomeLocation welcomeHomeLocation3 = (i16 & 256) != 0 ? null : welcomeHomeLocation;
        Boolean bool6 = (i16 & 512) != 0 ? null : bool2;
        Integer num6 = (i16 & 1024) != 0 ? null : num2;
        if ((i16 & 2048) != 0) {
            l2 = null;
            deviceG4 = this;
            dArr11 = dArr12;
            dArr10 = dArr13;
            dArr9 = dArr14;
            dArr8 = dArr15;
            z8 = z19;
            str19 = str54;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            bool3 = bool6;
            str35 = str52;
            num3 = num6;
            dArr7 = dArr16;
            i14 = i17;
            str32 = str41;
            num4 = num5;
            i11 = ordinal;
            i13 = i18;
            str34 = str39;
            str20 = str38;
            str33 = str40;
            deviceUuid3 = deviceUuid4;
            z12 = z13;
            indoorDatapoint2 = indoorDatapoint3;
            i12 = i19;
            z11 = z14;
            j2 = j3;
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
            i10 = i21;
            z10 = z16;
            z9 = z17;
            bool4 = bool5;
            str21 = str53;
            z7 = z18;
            i9 = index;
            str36 = str;
        } else {
            l2 = l;
            deviceG4 = this;
            dArr11 = dArr12;
            dArr10 = dArr13;
            dArr9 = dArr14;
            dArr8 = dArr15;
            z8 = z19;
            str19 = str54;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            str35 = str52;
            num3 = num6;
            dArr7 = dArr16;
            i14 = i17;
            str32 = str41;
            num4 = num5;
            i11 = ordinal;
            i13 = i18;
            str34 = str39;
            str20 = str38;
            str33 = str40;
            z12 = z13;
            indoorDatapoint2 = indoorDatapoint3;
            i12 = i19;
            z11 = z14;
            j2 = j3;
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
            i10 = i21;
            z10 = z16;
            z9 = z17;
            bool4 = bool5;
            str21 = str53;
            z7 = z18;
            i9 = index;
            str36 = str;
            bool3 = bool6;
            deviceUuid3 = deviceUuid4;
        }
        new DeviceG4(str36, str35, i14, num4, i13, str34, str33, deviceUuid3, z12, indoorDatapoint2, i12, z11, i11, j2, str32, str31, str30, str29, str28, str27, str26, str25, str24, str23, str22, dArr11, dArr10, dArr9, dArr8, dArr7, i10, z10, z9, z8, bool4, str21, z7, str20, i9, str19, welcomeHomeLocation2, bool3, num3, l2);
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

    public boolean isGermShieldModeOn() {
        return this.isGermShieldModeOn;
    }

    public Boolean isGermShieldNightModeOn() {
        return this.isGermShieldNightModeOn;
    }

    public String getG4NightModeFilterTrigger() {
        return this.g4NightModeFilterTrigger;
    }

    public boolean isSafetySwitchOn() {
        return this.isSafetySwitchOn;
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

    public Boolean getDisinfection() {
        return this.disinfection;
    }

    public Integer getDisinfectLeftTime() {
        return this.disinfectLeftTime;
    }

    public Long getDisinfectLeftTimeUpdateTime() {
        return this.disinfectLeftTimeUpdateTime;
    }

    public final boolean isSuperPremium() {
        String sku2 = getSku();
        if (sku2 != null) {
            return DeviceType.Companion.getG4SP_SKU().contains(sku2);
        }
        return false;
    }

    public final boolean isPlus() {
        String sku2 = getSku();
        if (sku2 != null) {
            return DeviceType.Companion.getG4Plus_SKU().contains(sku2);
        }
        return false;
    }

    public final String getModelNumber() {
        return DeviceType.Companion.g4ModelNumberFromModelName(getModelName());
    }

    public final String getModelSeries() {
        return DeviceType.Companion.g4ModelSeriesFromModelName(getModelName());
    }
}
