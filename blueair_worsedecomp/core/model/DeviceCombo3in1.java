package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTimer;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0003\b\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u0012Bõ\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u0012\b\b\u0002\u0010$\u001a\u00020\u0017\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020\u0014\u0012\b\b\u0002\u0010(\u001a\u00020\u0014\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\b\b\u0002\u0010*\u001a\u00020\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u0014\u0012\b\b\u0002\u0010,\u001a\u00020\u0014\u0012\b\b\u0002\u0010-\u001a\u00020\u0014\u0012\b\b\u0002\u0010.\u001a\u00020\u0014\u0012\b\b\u0002\u0010/\u001a\u00020\u0014\u0012\b\b\u0002\u00100\u001a\u00020\u0014\u0012\b\b\u0002\u00101\u001a\u00020\u0014\u0012\b\b\u0002\u00102\u001a\u000203\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u00105\u001a\u000203\u0012\b\b\u0002\u00106\u001a\u000203\u0012\b\b\u0002\u00107\u001a\u000203\u0012\b\b\u0002\u00108\u001a\u00020\u0017\u0012\b\b\u0002\u00109\u001a\u00020\u001f\u0012\b\b\u0002\u0010:\u001a\u00020\u001f\u0012\b\b\u0002\u0010;\u001a\u00020\u0014\u0012\b\b\u0002\u0010<\u001a\u00020\u0014\u0012\b\b\u0002\u0010=\u001a\u00020\u0017\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010A\u001a\u00020\u0017\u0012\b\b\u0002\u0010B\u001a\u00020\u0017\u0012\b\b\u0002\u0010C\u001a\u00020\u0017\u0012\b\b\u0002\u0010D\u001a\u00020&\u0012\b\b\u0002\u0010E\u001a\u00020\u0017\u0012\b\b\u0002\u0010F\u001a\u00020\u0017\u0012\b\b\u0002\u0010G\u001a\u00020\u0017\u0012\b\b\u0002\u0010H\u001a\u00020\u0017\u0012\b\b\u0002\u0010I\u001a\u00020\u0017\u0012\b\b\u0002\u0010J\u001a\u00020\u0017\u0012\b\b\u0002\u0010K\u001a\u00020\u0017\u0012\b\b\u0002\u0010L\u001a\u00020\u0017\u0012\b\b\u0002\u0010M\u001a\u00020\u0017\u0012\b\b\u0002\u0010N\u001a\u00020\u0017\u0012\b\b\u0002\u0010O\u001a\u00020P\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010R\u001a\u00020\u0017\u0012\b\b\u0002\u0010S\u001a\u00020\u0017\u0012\b\b\u0002\u0010T\u001a\u00020\u0017\u0012\b\b\u0002\u0010U\u001a\u000203\u0012\b\b\u0002\u0010V\u001a\u00020\u0017\u0012\b\b\u0002\u0010W\u001a\u000203\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bY\u0010ZJ\n\u0010 \u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0017HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010aJ\n\u0010¤\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0014HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u001fHÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u001fHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010­\u0001\u001a\u00020&HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¹\u0001\u001a\u000203HÆ\u0003J\n\u0010º\u0001\u001a\u000203HÆ\u0003J\n\u0010»\u0001\u001a\u000203HÆ\u0003J\n\u0010¼\u0001\u001a\u000203HÆ\u0003J\n\u0010½\u0001\u001a\u000203HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u001fHÆ\u0003J\n\u0010À\u0001\u001a\u00020\u001fHÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010@HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010É\u0001\u001a\u00020&HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020PHÆ\u0003J\n\u0010Õ\u0001\u001a\u00020PHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ù\u0001\u001a\u000203HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Û\u0001\u001a\u000203HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0005\u0010Ý\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u00142\b\b\u0002\u0010+\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\u00142\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u00142\b\b\u0002\u0010/\u001a\u00020\u00142\b\b\u0002\u00100\u001a\u00020\u00142\b\b\u0002\u00101\u001a\u00020\u00142\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u0002032\b\b\u0002\u00106\u001a\u0002032\b\b\u0002\u00107\u001a\u0002032\b\b\u0002\u00108\u001a\u00020\u00172\b\b\u0002\u00109\u001a\u00020\u001f2\b\b\u0002\u0010:\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020\u00142\b\b\u0002\u0010<\u001a\u00020\u00142\b\b\u0002\u0010=\u001a\u00020\u00172\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020\u00172\b\b\u0002\u0010C\u001a\u00020\u00172\b\b\u0002\u0010D\u001a\u00020&2\b\b\u0002\u0010E\u001a\u00020\u00172\b\b\u0002\u0010F\u001a\u00020\u00172\b\b\u0002\u0010G\u001a\u00020\u00172\b\b\u0002\u0010H\u001a\u00020\u00172\b\b\u0002\u0010I\u001a\u00020\u00172\b\b\u0002\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\u00172\b\b\u0002\u0010L\u001a\u00020\u00172\b\b\u0002\u0010M\u001a\u00020\u00172\b\b\u0002\u0010N\u001a\u00020\u00172\b\b\u0002\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020P2\b\b\u0002\u0010R\u001a\u00020\u00172\b\b\u0002\u0010S\u001a\u00020\u00172\b\b\u0002\u0010T\u001a\u00020\u00172\b\b\u0002\u0010U\u001a\u0002032\b\b\u0002\u0010V\u001a\u00020\u00172\b\b\u0002\u0010W\u001a\u0002032\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0003\u0010Þ\u0001J\u0007\u0010ß\u0001\u001a\u00020\u0017J\u0016\u0010à\u0001\u001a\u00020\u001f2\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001HÖ\u0003J\n\u0010ã\u0001\u001a\u00020\u0017HÖ\u0001J\n\u0010ä\u0001\u001a\u00020\u0014HÖ\u0001J\u001b\u0010å\u0001\u001a\u00030æ\u00012\b\u0010ç\u0001\u001a\u00030è\u00012\u0007\u0010é\u0001\u001a\u00020\u0017R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\\R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0004¢\u0006\n\n\u0002\u0010b\u001a\u0004\b`\u0010aR\u0014\u0010\u0019\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010_R\u0014\u0010\u001a\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\\R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\\R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010 \u001a\u0004\u0018\u00010!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u0010\"\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010_R\u0014\u0010#\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010iR\u0014\u0010$\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010_R\u0014\u0010%\u001a\u00020&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0014\u0010'\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\\R\u0014\u0010(\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\\R\u0014\u0010)\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010\\R\u0014\u0010*\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\\R\u0014\u0010+\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\\R\u0014\u0010,\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\\R\u0014\u0010-\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\\R\u0014\u0010.\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\\R\u0014\u0010/\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\\R\u0014\u00100\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010\\R\u0014\u00101\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\\R\u0014\u00102\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0014\u00104\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010|R\u0014\u00105\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010|R\u0014\u00106\u001a\u000203X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010|R\u0015\u00107\u001a\u000203X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010|R\u0015\u00108\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0014\u00109\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010iR\u0014\u0010:\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010iR\u0015\u0010;\u001a\u00020\u0014X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\R\u0015\u0010<\u001a\u00020\u0014X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\R\u0015\u0010=\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0017\u0010>\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\R\u0018\u0010?\u001a\u0004\u0018\u00010@X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010A\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010B\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010C\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010D\u001a\u00020&X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010oR\u0015\u0010E\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010F\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010G\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010H\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010I\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010J\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010K\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010L\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010M\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010N\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0016\u0010O\u001a\u00020PX\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010Q\u001a\u00020PX\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010R\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010S\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010T\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010U\u001a\u000203X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010|R\u0015\u0010V\u001a\u00020\u0017X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R\u0015\u0010W\u001a\u000203X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010|R\u0017\u0010X\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\¨\u0006ê\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceCombo3in1;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasTemperatureUnit;", "Lcom/blueair/core/model/HasOscillation;", "Lcom/blueair/core/model/HasCombo3in1MainMode;", "Lcom/blueair/core/model/HasLocation;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "oscillationState", "oscillationAngle", "oscillationDirection", "oscillationFanSpeed", "mainMode", "apSubMode", "apFanSpeed", "heatSubMode", "heatFanSpeed", "heatAutoTmp", "", "heatEcoTmp", "coolSubMode", "coolFanSpeed", "coolAutoTag", "coolAutoPresets", "coolEcoTag", "coolEcoPresets", "locationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJIIIIIIIIIIDDIII[DI[DLjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getOscillationState", "getOscillationAngle", "getOscillationDirection", "getOscillationFanSpeed", "getMainMode", "getApSubMode", "getApFanSpeed", "getHeatSubMode", "getHeatFanSpeed", "getHeatAutoTmp", "()D", "getHeatEcoTmp", "getCoolSubMode", "getCoolFanSpeed", "getCoolAutoTag", "getCoolAutoPresets", "getCoolEcoTag", "getCoolEcoPresets", "getLocationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJIIIIIIIIIIDDIII[DI[DLjava/lang/String;)Lcom/blueair/core/model/DeviceCombo3in1;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceCombo3in1 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasWelcomeHome, HasTimer, HasTemperatureUnit, HasOscillation, HasCombo3in1MainMode, HasLocation {
    public static final Parcelable.Creator<DeviceCombo3in1> CREATOR = new Creator();
    private final int apFanSpeed;
    private final int apSubMode;
    private final String autoModeText;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final double[] coolAutoPresets;
    private final int coolAutoTag;
    private final double[] coolEcoPresets;
    private final int coolEcoTag;
    private final int coolFanSpeed;
    private final int coolSubMode;
    private final String dealerCountry;
    private final String dealerName;
    private final DeviceUuid deviceUuid;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String g4NightModeFilterTrigger;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final double heatAutoTmp;
    private final double heatEcoTmp;
    private final int heatFanSpeed;
    private final int heatSubMode;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isG4NightModeOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String locationId;
    private final String mac;
    private final int mainMode;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final int oscillationAngle;
    private final int oscillationDirection;
    private final int oscillationFanSpeed;
    private final int oscillationState;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final int temperatureUnit;
    private final String timeZone;
    private final int timerDuration;
    private final int timerLeftTime;
    private final long timerLeftTimeUpdateTime;
    private final int timerStatus;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final WelcomeHomeLocation welcomeHome;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceCombo3in1> {
        public final DeviceCombo3in1 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
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
            boolean z5 = parcel2.readInt() != 0;
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
            boolean z6 = z2;
            long readLong = parcel2.readLong();
            boolean z7 = z6;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z8 = z7;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z9 = z8;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z10 = z9;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z11 = z10;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z12 = z11;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z13 = z12;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z14 = z;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z15 = z13;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z16 = z14;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z17 = z15;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z16;
                z16 = z17;
            } else {
                z4 = z16;
            }
            if (parcel2.readInt() == 0) {
                z17 = z4;
            }
            String readString16 = parcel2.readString();
            String readString17 = parcel2.readString();
            int readInt6 = parcel2.readInt();
            String readString18 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                welcomeHomeLocation = WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            }
            return new DeviceCombo3in1(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z5, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z16, z17, readString16, readString17, readInt6, readString18, welcomeHomeLocation, parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readLong(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.readDouble(), parcel2.readDouble(), parcel2.readInt(), parcel2.readInt(), parcel2.readInt(), parcel2.createDoubleArray(), parcel2.readInt(), parcel2.createDoubleArray(), parcel2.readString());
        }

        public final DeviceCombo3in1[] newArray(int i) {
            return new DeviceCombo3in1[i];
        }
    }

    public static /* synthetic */ DeviceCombo3in1 copy$default(DeviceCombo3in1 deviceCombo3in1, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, double d, double d2, int i20, int i21, int i22, double[] dArr6, int i23, double[] dArr7, String str19, int i24, int i25, Object obj) {
        long j3;
        String str20;
        String str21;
        double[] dArr8;
        int i26;
        double[] dArr9;
        int i27;
        int i28;
        int i29;
        double d3;
        double d4;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        long j4;
        int i40;
        int i41;
        int i42;
        WelcomeHomeLocation welcomeHomeLocation2;
        String str22;
        int i43;
        String str23;
        String str24;
        boolean z5;
        boolean z6;
        int i44;
        double[] dArr10;
        double[] dArr11;
        double[] dArr12;
        double[] dArr13;
        double[] dArr14;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        long j5;
        int i45;
        boolean z7;
        int i46;
        IndoorDatapoint indoorDatapoint2;
        boolean z8;
        DeviceUuid deviceUuid3;
        String str36;
        String str37;
        int i47;
        Integer num2;
        int i48;
        DeviceCombo3in1 deviceCombo3in12 = deviceCombo3in1;
        int i49 = i24;
        int i50 = i25;
        String str38 = (i49 & 1) != 0 ? deviceCombo3in12.uid : str;
        String str39 = (i49 & 2) != 0 ? deviceCombo3in12.name : str2;
        int i51 = (i49 & 4) != 0 ? deviceCombo3in12.fanSpeed : i;
        Integer num3 = (i49 & 8) != 0 ? deviceCombo3in12.filterLife : num;
        int i52 = (i49 & 16) != 0 ? deviceCombo3in12.brightness : i2;
        String str40 = (i49 & 32) != 0 ? deviceCombo3in12.autoModeText : str3;
        String str41 = (i49 & 64) != 0 ? deviceCombo3in12.info : str4;
        DeviceUuid deviceUuid4 = (i49 & 128) != 0 ? deviceCombo3in12.deviceUuid : deviceUuid2;
        boolean z9 = (i49 & 256) != 0 ? deviceCombo3in12.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint3 = (i49 & 512) != 0 ? deviceCombo3in12.latestSensorDatapoint : indoorDatapoint;
        int i53 = (i49 & 1024) != 0 ? deviceCombo3in12.lastSelectedSensorTypeIndex : i3;
        boolean z10 = (i49 & 2048) != 0 ? deviceCombo3in12.isChildLockOn : z2;
        int i54 = (i49 & 4096) != 0 ? deviceCombo3in12.connectivityStatusIndex : i4;
        String str42 = str38;
        String str43 = str39;
        long j6 = (i49 & 8192) != 0 ? deviceCombo3in12.lastConnectivityInMillis : j;
        String str44 = (i49 & 16384) != 0 ? deviceCombo3in12.mac : str5;
        String str45 = (i49 & 32768) != 0 ? deviceCombo3in12.mcuFirmware : str6;
        String str46 = (i49 & 65536) != 0 ? deviceCombo3in12.wifiFirmware : str7;
        String str47 = (i24 & 131072) != 0 ? deviceCombo3in12.hardware : str8;
        String str48 = (i24 & 262144) != 0 ? deviceCombo3in12.timeZone : str9;
        String str49 = (i24 & 524288) != 0 ? deviceCombo3in12.serial : str10;
        String str50 = (i24 & 1048576) != 0 ? deviceCombo3in12.purchaseDate : str11;
        String str51 = (i24 & 2097152) != 0 ? deviceCombo3in12.dealerName : str12;
        String str52 = (i24 & 4194304) != 0 ? deviceCombo3in12.dealerCountry : str13;
        String str53 = (i24 & 8388608) != 0 ? deviceCombo3in12.filterType : str14;
        String str54 = (i24 & 16777216) != 0 ? deviceCombo3in12.filterTrigger : str15;
        double[] dArr15 = (i24 & 33554432) != 0 ? deviceCombo3in12.pm1Ranges : dArr;
        double[] dArr16 = (i24 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceCombo3in12.pm10Ranges : dArr2;
        double[] dArr17 = (i24 & 134217728) != 0 ? deviceCombo3in12.pm25Ranges : dArr3;
        double[] dArr18 = (i24 & 268435456) != 0 ? deviceCombo3in12.vocRanges : dArr4;
        double[] dArr19 = (i24 & 536870912) != 0 ? deviceCombo3in12.hchoRanges : dArr5;
        int i55 = (i24 & 1073741824) != 0 ? deviceCombo3in12.updateProgress : i5;
        boolean z11 = (i24 & Integer.MIN_VALUE) != 0 ? deviceCombo3in12.isStandByOn : z3;
        boolean z12 = (i50 & 1) != 0 ? deviceCombo3in12.isG4NightModeOn : z4;
        String str55 = (i50 & 2) != 0 ? deviceCombo3in12.g4NightModeFilterTrigger : str16;
        String str56 = (i50 & 4) != 0 ? deviceCombo3in12.modelName : str17;
        int i56 = (i50 & 8) != 0 ? deviceCombo3in12.typeIndex : i6;
        String str57 = (i50 & 16) != 0 ? deviceCombo3in12.sku : str18;
        WelcomeHomeLocation welcomeHomeLocation3 = (i50 & 32) != 0 ? deviceCombo3in12.welcomeHome : welcomeHomeLocation;
        int i57 = (i50 & 64) != 0 ? deviceCombo3in12.timerStatus : i7;
        int i58 = (i50 & 128) != 0 ? deviceCombo3in12.timerDuration : i8;
        int i59 = (i50 & 256) != 0 ? deviceCombo3in12.timerLeftTime : i9;
        String str58 = str44;
        if ((i50 & 512) != 0) {
            str20 = str45;
            j3 = deviceCombo3in12.timerLeftTimeUpdateTime;
        } else {
            str20 = str45;
            j3 = j2;
        }
        String str59 = str20;
        int i60 = (i50 & 1024) != 0 ? deviceCombo3in12.temperatureUnit : i10;
        int i61 = (i50 & 2048) != 0 ? deviceCombo3in12.oscillationState : i11;
        int i62 = (i50 & 4096) != 0 ? deviceCombo3in12.oscillationAngle : i12;
        int i63 = (i50 & 8192) != 0 ? deviceCombo3in12.oscillationDirection : i13;
        int i64 = (i50 & 16384) != 0 ? deviceCombo3in12.oscillationFanSpeed : i14;
        int i65 = (i50 & 32768) != 0 ? deviceCombo3in12.mainMode : i15;
        int i66 = (i50 & 65536) != 0 ? deviceCombo3in12.apSubMode : i16;
        int i67 = (i50 & 131072) != 0 ? deviceCombo3in12.apFanSpeed : i17;
        int i68 = (i50 & 262144) != 0 ? deviceCombo3in12.heatSubMode : i18;
        int i69 = (i50 & 524288) != 0 ? deviceCombo3in12.heatFanSpeed : i19;
        double d5 = (i50 & 1048576) != 0 ? deviceCombo3in12.heatAutoTmp : d;
        double d6 = (i25 & 2097152) != 0 ? deviceCombo3in12.heatEcoTmp : d2;
        int i70 = (i25 & 4194304) != 0 ? deviceCombo3in12.coolSubMode : i20;
        int i71 = (i25 & 8388608) != 0 ? deviceCombo3in12.coolFanSpeed : i21;
        int i72 = i70;
        int i73 = (i25 & 16777216) != 0 ? deviceCombo3in12.coolAutoTag : i22;
        double[] dArr20 = (i25 & 33554432) != 0 ? deviceCombo3in12.coolAutoPresets : dArr6;
        int i74 = (i25 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceCombo3in12.coolEcoTag : i23;
        double[] dArr21 = (i25 & 134217728) != 0 ? deviceCombo3in12.coolEcoPresets : dArr7;
        if ((i25 & 268435456) != 0) {
            String str60 = str59;
            dArr11 = dArr18;
            str34 = str60;
            dArr8 = dArr21;
            str21 = deviceCombo3in12.locationId;
            i35 = i64;
            i34 = i65;
            i33 = i66;
            i32 = i67;
            i31 = i68;
            i30 = i69;
            d4 = d5;
            d3 = d6;
            i29 = i72;
            i27 = i73;
            dArr9 = dArr20;
            i26 = i74;
            i28 = i71;
            j4 = j3;
            num2 = num3;
            str24 = str55;
            str23 = str56;
            i43 = i56;
            str22 = str57;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            i42 = i57;
            i41 = i58;
            i40 = i59;
            i39 = i60;
            i38 = i61;
            i37 = i62;
            i36 = i63;
            str29 = str50;
            str28 = str51;
            str27 = str52;
            str26 = str53;
            str25 = str54;
            dArr14 = dArr15;
            dArr13 = dArr16;
            dArr12 = dArr17;
            dArr10 = dArr19;
            i44 = i55;
            z6 = z11;
            z5 = z12;
            str35 = str58;
            z8 = z9;
            indoorDatapoint2 = indoorDatapoint3;
            i46 = i53;
            z7 = z10;
            i45 = i54;
            j5 = j6;
            str33 = str46;
            str32 = str47;
            str31 = str48;
            str30 = str49;
            i48 = i51;
            i47 = i52;
            str37 = str40;
            str36 = str41;
            deviceUuid3 = deviceUuid4;
        } else {
            String str61 = str59;
            dArr11 = dArr18;
            str34 = str61;
            str21 = str19;
            dArr8 = dArr21;
            i35 = i64;
            i36 = i63;
            i34 = i65;
            i33 = i66;
            i32 = i67;
            i31 = i68;
            i30 = i69;
            d4 = d5;
            d3 = d6;
            i29 = i72;
            i27 = i73;
            dArr9 = dArr20;
            i26 = i74;
            i28 = i71;
            j4 = j3;
            num2 = num3;
            z5 = z12;
            str24 = str55;
            str23 = str56;
            i43 = i56;
            str22 = str57;
            welcomeHomeLocation2 = welcomeHomeLocation3;
            i42 = i57;
            i41 = i58;
            i40 = i59;
            i39 = i60;
            i38 = i61;
            i37 = i62;
            str30 = str49;
            str29 = str50;
            str28 = str51;
            str27 = str52;
            str26 = str53;
            str25 = str54;
            dArr14 = dArr15;
            dArr13 = dArr16;
            dArr12 = dArr17;
            dArr10 = dArr19;
            i44 = i55;
            z6 = z11;
            str35 = str58;
            deviceUuid3 = deviceUuid4;
            z8 = z9;
            indoorDatapoint2 = indoorDatapoint3;
            i46 = i53;
            z7 = z10;
            i45 = i54;
            j5 = j6;
            str33 = str46;
            str32 = str47;
            str31 = str48;
            i48 = i51;
            i47 = i52;
            str37 = str40;
            str36 = str41;
        }
        return deviceCombo3in12.copy(str42, str43, i48, num2, i47, str37, str36, deviceUuid3, z8, indoorDatapoint2, i46, z7, i45, j5, str35, str34, str33, str32, str31, str30, str29, str28, str27, str26, str25, dArr14, dArr13, dArr12, dArr11, dArr10, i44, z6, z5, str24, str23, i43, str22, welcomeHomeLocation2, i42, i41, i40, j4, i39, i38, i37, i36, i35, i34, i33, i32, i31, i30, d4, d3, i29, i28, i27, dArr9, i26, dArr8, str21);
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

    public final WelcomeHomeLocation component38() {
        return this.welcomeHome;
    }

    public final int component39() {
        return this.timerStatus;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final int component40() {
        return this.timerDuration;
    }

    public final int component41() {
        return this.timerLeftTime;
    }

    public final long component42() {
        return this.timerLeftTimeUpdateTime;
    }

    public final int component43() {
        return this.temperatureUnit;
    }

    public final int component44() {
        return this.oscillationState;
    }

    public final int component45() {
        return this.oscillationAngle;
    }

    public final int component46() {
        return this.oscillationDirection;
    }

    public final int component47() {
        return this.oscillationFanSpeed;
    }

    public final int component48() {
        return this.mainMode;
    }

    public final int component49() {
        return this.apSubMode;
    }

    public final int component5() {
        return this.brightness;
    }

    public final int component50() {
        return this.apFanSpeed;
    }

    public final int component51() {
        return this.heatSubMode;
    }

    public final int component52() {
        return this.heatFanSpeed;
    }

    public final double component53() {
        return this.heatAutoTmp;
    }

    public final double component54() {
        return this.heatEcoTmp;
    }

    public final int component55() {
        return this.coolSubMode;
    }

    public final int component56() {
        return this.coolFanSpeed;
    }

    public final int component57() {
        return this.coolAutoTag;
    }

    public final double[] component58() {
        return this.coolAutoPresets;
    }

    public final int component59() {
        return this.coolEcoTag;
    }

    public final String component6() {
        return this.autoModeText;
    }

    public final double[] component60() {
        return this.coolEcoPresets;
    }

    public final String component61() {
        return this.locationId;
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

    public final DeviceCombo3in1 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, double d, double d2, int i20, int i21, int i22, double[] dArr6, int i23, double[] dArr7, String str19) {
        String str20 = str;
        Intrinsics.checkNotNullParameter(str20, "uid");
        String str21 = str2;
        Intrinsics.checkNotNullParameter(str21, "name");
        String str22 = str3;
        Intrinsics.checkNotNullParameter(str22, "autoModeText");
        Intrinsics.checkNotNullParameter(str5, AnalyticEvent.KEY_MAC);
        String str23 = str6;
        Intrinsics.checkNotNullParameter(str23, "mcuFirmware");
        String str24 = str7;
        Intrinsics.checkNotNullParameter(str24, "wifiFirmware");
        String str25 = str8;
        Intrinsics.checkNotNullParameter(str25, "hardware");
        String str26 = str9;
        Intrinsics.checkNotNullParameter(str26, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str27 = str10;
        Intrinsics.checkNotNullParameter(str27, "serial");
        String str28 = str11;
        Intrinsics.checkNotNullParameter(str28, "purchaseDate");
        String str29 = str12;
        Intrinsics.checkNotNullParameter(str29, "dealerName");
        String str30 = str13;
        Intrinsics.checkNotNullParameter(str30, "dealerCountry");
        String str31 = str14;
        Intrinsics.checkNotNullParameter(str31, "filterType");
        String str32 = str15;
        Intrinsics.checkNotNullParameter(str32, "filterTrigger");
        double[] dArr8 = dArr;
        Intrinsics.checkNotNullParameter(dArr8, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        Intrinsics.checkNotNullParameter(str17, "modelName");
        Intrinsics.checkNotNullParameter(dArr6, "coolAutoPresets");
        Intrinsics.checkNotNullParameter(dArr7, "coolEcoPresets");
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        String str41 = str31;
        String str42 = str32;
        double[] dArr9 = dArr8;
        return new DeviceCombo3in1(str20, str21, i, num, i2, str22, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, dArr9, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, str16, str17, i6, str18, welcomeHomeLocation, i7, i8, i9, j2, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, d, d2, i20, i21, i22, dArr6, i23, dArr7, str19);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceCombo3in1)) {
            return false;
        }
        DeviceCombo3in1 deviceCombo3in1 = (DeviceCombo3in1) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceCombo3in1.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceCombo3in1.name) && this.fanSpeed == deviceCombo3in1.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceCombo3in1.filterLife) && this.brightness == deviceCombo3in1.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceCombo3in1.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceCombo3in1.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceCombo3in1.deviceUuid) && this.hasFinishedOnboarding == deviceCombo3in1.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceCombo3in1.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceCombo3in1.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceCombo3in1.isChildLockOn && this.connectivityStatusIndex == deviceCombo3in1.connectivityStatusIndex && this.lastConnectivityInMillis == deviceCombo3in1.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceCombo3in1.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceCombo3in1.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceCombo3in1.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceCombo3in1.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceCombo3in1.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceCombo3in1.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceCombo3in1.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceCombo3in1.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceCombo3in1.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceCombo3in1.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceCombo3in1.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceCombo3in1.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceCombo3in1.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceCombo3in1.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceCombo3in1.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceCombo3in1.hchoRanges) && this.updateProgress == deviceCombo3in1.updateProgress && this.isStandByOn == deviceCombo3in1.isStandByOn && this.isG4NightModeOn == deviceCombo3in1.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceCombo3in1.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceCombo3in1.modelName) && this.typeIndex == deviceCombo3in1.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceCombo3in1.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceCombo3in1.welcomeHome) && this.timerStatus == deviceCombo3in1.timerStatus && this.timerDuration == deviceCombo3in1.timerDuration && this.timerLeftTime == deviceCombo3in1.timerLeftTime && this.timerLeftTimeUpdateTime == deviceCombo3in1.timerLeftTimeUpdateTime && this.temperatureUnit == deviceCombo3in1.temperatureUnit && this.oscillationState == deviceCombo3in1.oscillationState && this.oscillationAngle == deviceCombo3in1.oscillationAngle && this.oscillationDirection == deviceCombo3in1.oscillationDirection && this.oscillationFanSpeed == deviceCombo3in1.oscillationFanSpeed && this.mainMode == deviceCombo3in1.mainMode && this.apSubMode == deviceCombo3in1.apSubMode && this.apFanSpeed == deviceCombo3in1.apFanSpeed && this.heatSubMode == deviceCombo3in1.heatSubMode && this.heatFanSpeed == deviceCombo3in1.heatFanSpeed && Double.compare(this.heatAutoTmp, deviceCombo3in1.heatAutoTmp) == 0 && Double.compare(this.heatEcoTmp, deviceCombo3in1.heatEcoTmp) == 0 && this.coolSubMode == deviceCombo3in1.coolSubMode && this.coolFanSpeed == deviceCombo3in1.coolFanSpeed && this.coolAutoTag == deviceCombo3in1.coolAutoTag && Intrinsics.areEqual((Object) this.coolAutoPresets, (Object) deviceCombo3in1.coolAutoPresets) && this.coolEcoTag == deviceCombo3in1.coolEcoTag && Intrinsics.areEqual((Object) this.coolEcoPresets, (Object) deviceCombo3in1.coolEcoPresets) && Intrinsics.areEqual((Object) this.locationId, (Object) deviceCombo3in1.locationId);
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
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        int hashCode7 = (((((((((((((((((((((((((((((((((((((((((((((hashCode6 + (welcomeHomeLocation == null ? 0 : welcomeHomeLocation.hashCode())) * 31) + this.timerStatus) * 31) + this.timerDuration) * 31) + this.timerLeftTime) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31) + this.temperatureUnit) * 31) + this.oscillationState) * 31) + this.oscillationAngle) * 31) + this.oscillationDirection) * 31) + this.oscillationFanSpeed) * 31) + this.mainMode) * 31) + this.apSubMode) * 31) + this.apFanSpeed) * 31) + this.heatSubMode) * 31) + this.heatFanSpeed) * 31) + Double.doubleToLongBits(this.heatAutoTmp)) * 31) + Double.doubleToLongBits(this.heatEcoTmp)) * 31) + this.coolSubMode) * 31) + this.coolFanSpeed) * 31) + this.coolAutoTag) * 31) + Arrays.hashCode(this.coolAutoPresets)) * 31) + this.coolEcoTag) * 31) + Arrays.hashCode(this.coolEcoPresets)) * 31;
        String str3 = this.locationId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "DeviceCombo3in1(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ", timerStatus=" + this.timerStatus + ", timerDuration=" + this.timerDuration + ", timerLeftTime=" + this.timerLeftTime + ", timerLeftTimeUpdateTime=" + this.timerLeftTimeUpdateTime + ", temperatureUnit=" + this.temperatureUnit + ", oscillationState=" + this.oscillationState + ", oscillationAngle=" + this.oscillationAngle + ", oscillationDirection=" + this.oscillationDirection + ", oscillationFanSpeed=" + this.oscillationFanSpeed + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", apFanSpeed=" + this.apFanSpeed + ", heatSubMode=" + this.heatSubMode + ", heatFanSpeed=" + this.heatFanSpeed + ", heatAutoTmp=" + this.heatAutoTmp + ", heatEcoTmp=" + this.heatEcoTmp + ", coolSubMode=" + this.coolSubMode + ", coolFanSpeed=" + this.coolFanSpeed + ", coolAutoTag=" + this.coolAutoTag + ", coolAutoPresets=" + Arrays.toString(this.coolAutoPresets) + ", coolEcoTag=" + this.coolEcoTag + ", coolEcoPresets=" + Arrays.toString(this.coolEcoPresets) + ", locationId=" + this.locationId + ')';
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
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            welcomeHomeLocation.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.timerStatus);
        parcel.writeInt(this.timerDuration);
        parcel.writeInt(this.timerLeftTime);
        parcel.writeLong(this.timerLeftTimeUpdateTime);
        parcel.writeInt(this.temperatureUnit);
        parcel.writeInt(this.oscillationState);
        parcel.writeInt(this.oscillationAngle);
        parcel.writeInt(this.oscillationDirection);
        parcel.writeInt(this.oscillationFanSpeed);
        parcel.writeInt(this.mainMode);
        parcel.writeInt(this.apSubMode);
        parcel.writeInt(this.apFanSpeed);
        parcel.writeInt(this.heatSubMode);
        parcel.writeInt(this.heatFanSpeed);
        parcel.writeDouble(this.heatAutoTmp);
        parcel.writeDouble(this.heatEcoTmp);
        parcel.writeInt(this.coolSubMode);
        parcel.writeInt(this.coolFanSpeed);
        parcel.writeInt(this.coolAutoTag);
        parcel.writeDoubleArray(this.coolAutoPresets);
        parcel.writeInt(this.coolEcoTag);
        parcel.writeDoubleArray(this.coolEcoPresets);
        parcel.writeString(this.locationId);
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

    public int currentFanSpeed() {
        return HasCombo3in1MainMode.CC.$default$currentFanSpeed(this);
    }

    public FanSpeedEnum currentFanSpeedEnum() {
        return HasCombo3in1MainMode.CC.$default$currentFanSpeedEnum(this);
    }

    public ApSubMode currentSubMode() {
        return HasCombo3in1MainMode.CC.$default$currentSubMode(this);
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

    public boolean isInSubMode(ApSubMode apSubMode2) {
        return HasCombo3in1MainMode.CC.$default$isInSubMode(this, apSubMode2);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isOscillationEnabled() {
        return HasOscillation.CC.$default$isOscillationEnabled(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public MainMode mainMode() {
        return HasMainMode.CC.$default$mainMode(this);
    }

    public OscillationDirection oscillationDirection() {
        return HasOscillation.CC.$default$oscillationDirection(this);
    }

    public OscillationFanSpeed oscillationFanSpeed() {
        return HasOscillation.CC.$default$oscillationFanSpeed(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public TimerState timerStatus() {
        return HasTimer.CC.$default$timerStatus(this);
    }

    public DeviceCombo3in1(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, int i9, long j2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, double d, double d2, int i20, int i21, int i22, double[] dArr6, int i23, double[] dArr7, String str19) {
        String str20 = str;
        String str21 = str2;
        String str22 = str3;
        String str23 = str5;
        String str24 = str6;
        String str25 = str7;
        String str26 = str8;
        String str27 = str9;
        String str28 = str10;
        String str29 = str11;
        String str30 = str12;
        String str31 = str13;
        String str32 = str14;
        String str33 = str15;
        Intrinsics.checkNotNullParameter(str20, "uid");
        Intrinsics.checkNotNullParameter(str21, "name");
        Intrinsics.checkNotNullParameter(str22, "autoModeText");
        Intrinsics.checkNotNullParameter(str23, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str24, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str25, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str26, "hardware");
        Intrinsics.checkNotNullParameter(str27, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str28, "serial");
        Intrinsics.checkNotNullParameter(str29, "purchaseDate");
        Intrinsics.checkNotNullParameter(str30, "dealerName");
        Intrinsics.checkNotNullParameter(str31, "dealerCountry");
        Intrinsics.checkNotNullParameter(str32, "filterType");
        Intrinsics.checkNotNullParameter(str33, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        Intrinsics.checkNotNullParameter(str17, "modelName");
        Intrinsics.checkNotNullParameter(dArr6, "coolAutoPresets");
        double[] dArr8 = dArr7;
        Intrinsics.checkNotNullParameter(dArr8, "coolEcoPresets");
        this.uid = str20;
        this.name = str21;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str22;
        this.info = str4;
        this.deviceUuid = deviceUuid2;
        this.hasFinishedOnboarding = z;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i3;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i4;
        this.lastConnectivityInMillis = j;
        this.mac = str23;
        this.mcuFirmware = str24;
        this.wifiFirmware = str25;
        this.hardware = str26;
        this.timeZone = str27;
        this.serial = str28;
        this.purchaseDate = str29;
        this.dealerName = str30;
        this.dealerCountry = str31;
        this.filterType = str32;
        this.filterTrigger = str33;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i5;
        this.isStandByOn = z3;
        this.isG4NightModeOn = z4;
        this.g4NightModeFilterTrigger = str16;
        this.modelName = str17;
        this.typeIndex = i6;
        this.sku = str18;
        this.welcomeHome = welcomeHomeLocation;
        this.timerStatus = i7;
        this.timerDuration = i8;
        this.timerLeftTime = i9;
        this.timerLeftTimeUpdateTime = j2;
        this.temperatureUnit = i10;
        this.oscillationState = i11;
        this.oscillationAngle = i12;
        this.oscillationDirection = i13;
        this.oscillationFanSpeed = i14;
        this.mainMode = i15;
        this.apSubMode = i16;
        this.apFanSpeed = i17;
        this.heatSubMode = i18;
        this.heatFanSpeed = i19;
        this.heatAutoTmp = d;
        this.heatEcoTmp = d2;
        this.coolSubMode = i20;
        this.coolFanSpeed = i21;
        this.coolAutoTag = i22;
        this.coolAutoPresets = dArr6;
        this.coolEcoTag = i23;
        this.coolEcoPresets = dArr8;
        this.locationId = str19;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceCombo3in1(java.lang.String r56, java.lang.String r57, int r58, java.lang.Integer r59, int r60, java.lang.String r61, java.lang.String r62, com.blueair.core.model.DeviceUuid r63, boolean r64, com.blueair.core.model.IndoorDatapoint r65, int r66, boolean r67, int r68, long r69, java.lang.String r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, java.lang.String r75, java.lang.String r76, java.lang.String r77, java.lang.String r78, java.lang.String r79, java.lang.String r80, java.lang.String r81, double[] r82, double[] r83, double[] r84, double[] r85, double[] r86, int r87, boolean r88, boolean r89, java.lang.String r90, java.lang.String r91, int r92, java.lang.String r93, com.blueair.core.model.WelcomeHomeLocation r94, int r95, int r96, int r97, long r98, int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109, double r110, double r112, int r114, int r115, int r116, double[] r117, int r118, double[] r119, java.lang.String r120, int r121, int r122, kotlin.jvm.internal.DefaultConstructorMarker r123) {
        /*
            r55 = this;
            r0 = r121
            r1 = r122
            r2 = r0 & 2
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = "Pairing…"
            goto L_0x000d
        L_0x000b:
            r2 = r57
        L_0x000d:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0015
        L_0x0013:
            r3 = r58
        L_0x0015:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001b
            r5 = 0
            goto L_0x001d
        L_0x001b:
            r5 = r59
        L_0x001d:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0023
            r7 = 0
            goto L_0x0025
        L_0x0023:
            r7 = r60
        L_0x0025:
            r8 = r0 & 32
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002d
            r8 = r9
            goto L_0x002f
        L_0x002d:
            r8 = r61
        L_0x002f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0035
            r10 = 0
            goto L_0x0037
        L_0x0035:
            r10 = r62
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r63
        L_0x003f:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r64
        L_0x0047:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x004d
            r13 = 0
            goto L_0x004f
        L_0x004d:
            r13 = r65
        L_0x004f:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0055
            r14 = 0
            goto L_0x0057
        L_0x0055:
            r14 = r66
        L_0x0057:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005d
            r15 = 0
            goto L_0x005f
        L_0x005d:
            r15 = r67
        L_0x005f:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r6 = r6.ordinal()
            goto L_0x006c
        L_0x006a:
            r6 = r68
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            r16 = 0
            if (r4 == 0) goto L_0x0075
            r18 = r16
            goto L_0x0077
        L_0x0075:
            r18 = r69
        L_0x0077:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007d
            r4 = r9
            goto L_0x007f
        L_0x007d:
            r4 = r71
        L_0x007f:
            r20 = 32768(0x8000, float:4.5918E-41)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x0089
            r21 = r9
            goto L_0x008b
        L_0x0089:
            r21 = r72
        L_0x008b:
            r22 = 65536(0x10000, float:9.18355E-41)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x0094
            r23 = r9
            goto L_0x0096
        L_0x0094:
            r23 = r73
        L_0x0096:
            r24 = 131072(0x20000, float:1.83671E-40)
            r25 = r0 & r24
            if (r25 == 0) goto L_0x009f
            r25 = r9
            goto L_0x00a1
        L_0x009f:
            r25 = r74
        L_0x00a1:
            r26 = 262144(0x40000, float:3.67342E-40)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00aa
            r26 = r9
            goto L_0x00ac
        L_0x00aa:
            r26 = r75
        L_0x00ac:
            r27 = 524288(0x80000, float:7.34684E-40)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00b5
            r27 = r9
            goto L_0x00b7
        L_0x00b5:
            r27 = r76
        L_0x00b7:
            r28 = 1048576(0x100000, float:1.469368E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00c0
            r28 = r9
            goto L_0x00c2
        L_0x00c0:
            r28 = r77
        L_0x00c2:
            r29 = 2097152(0x200000, float:2.938736E-39)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00cb
            r29 = r9
            goto L_0x00cd
        L_0x00cb:
            r29 = r78
        L_0x00cd:
            r30 = 4194304(0x400000, float:5.877472E-39)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00d6
            r30 = r9
            goto L_0x00d8
        L_0x00d6:
            r30 = r79
        L_0x00d8:
            r31 = 8388608(0x800000, float:1.17549435E-38)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00e1
            r31 = r9
            goto L_0x00e3
        L_0x00e1:
            r31 = r80
        L_0x00e3:
            r32 = 16777216(0x1000000, float:2.3509887E-38)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x00ec
            r32 = r9
            goto L_0x00ee
        L_0x00ec:
            r32 = r81
        L_0x00ee:
            r33 = 33554432(0x2000000, float:9.403955E-38)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x00fa
            r33 = r2
            r0 = 0
            double[] r2 = new double[r0]
            goto L_0x00ff
        L_0x00fa:
            r33 = r2
            r0 = 0
            r2 = r82
        L_0x00ff:
            r34 = 67108864(0x4000000, float:1.5046328E-36)
            r34 = r121 & r34
            r58 = r2
            if (r34 == 0) goto L_0x010a
            double[] r2 = new double[r0]
            goto L_0x010c
        L_0x010a:
            r2 = r83
        L_0x010c:
            r34 = 134217728(0x8000000, float:3.85186E-34)
            r34 = r121 & r34
            r59 = r2
            if (r34 == 0) goto L_0x0117
            double[] r2 = new double[r0]
            goto L_0x0119
        L_0x0117:
            r2 = r84
        L_0x0119:
            r34 = 268435456(0x10000000, float:2.5243549E-29)
            r34 = r121 & r34
            r60 = r2
            if (r34 == 0) goto L_0x0124
            double[] r2 = new double[r0]
            goto L_0x0126
        L_0x0124:
            r2 = r85
        L_0x0126:
            r34 = 536870912(0x20000000, float:1.0842022E-19)
            r34 = r121 & r34
            r61 = r2
            if (r34 == 0) goto L_0x0131
            double[] r2 = new double[r0]
            goto L_0x0133
        L_0x0131:
            r2 = r86
        L_0x0133:
            r0 = 1073741824(0x40000000, float:2.0)
            r0 = r121 & r0
            if (r0 == 0) goto L_0x013b
            r0 = 0
            goto L_0x013d
        L_0x013b:
            r0 = r87
        L_0x013d:
            r34 = -2147483648(0xffffffff80000000, float:-0.0)
            r34 = r121 & r34
            if (r34 == 0) goto L_0x0146
            r34 = 0
            goto L_0x0148
        L_0x0146:
            r34 = r88
        L_0x0148:
            r35 = r1 & 1
            if (r35 == 0) goto L_0x014f
            r35 = 0
            goto L_0x0151
        L_0x014f:
            r35 = r89
        L_0x0151:
            r36 = r1 & 2
            if (r36 == 0) goto L_0x0158
            r36 = r9
            goto L_0x015a
        L_0x0158:
            r36 = r90
        L_0x015a:
            r37 = r1 & 4
            if (r37 == 0) goto L_0x015f
            goto L_0x0161
        L_0x015f:
            r9 = r91
        L_0x0161:
            r37 = r1 & 8
            if (r37 == 0) goto L_0x016c
            com.blueair.core.model.DeviceType$Combo3in1 r37 = com.blueair.core.model.DeviceType.Combo3in1.INSTANCE
            int r37 = r37.getIndex()
            goto L_0x016e
        L_0x016c:
            r37 = r92
        L_0x016e:
            r38 = r1 & 16
            if (r38 == 0) goto L_0x0175
            r38 = 0
            goto L_0x0177
        L_0x0175:
            r38 = r93
        L_0x0177:
            r39 = r1 & 32
            if (r39 == 0) goto L_0x017e
            r39 = 0
            goto L_0x0180
        L_0x017e:
            r39 = r94
        L_0x0180:
            r40 = r1 & 64
            if (r40 == 0) goto L_0x0187
            r40 = 0
            goto L_0x0189
        L_0x0187:
            r40 = r95
        L_0x0189:
            r62 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0191
            r0 = 0
            goto L_0x0193
        L_0x0191:
            r0 = r96
        L_0x0193:
            r63 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x019b
            r0 = 0
            goto L_0x019d
        L_0x019b:
            r0 = r97
        L_0x019d:
            r64 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x01a4
            goto L_0x01a6
        L_0x01a4:
            r16 = r98
        L_0x01a6:
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01ac
            r0 = 0
            goto L_0x01ae
        L_0x01ac:
            r0 = r100
        L_0x01ae:
            r65 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01b6
            r0 = 0
            goto L_0x01b8
        L_0x01b6:
            r0 = r101
        L_0x01b8:
            r66 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01c1
            r0 = 90
            goto L_0x01c3
        L_0x01c1:
            r0 = r102
        L_0x01c3:
            r67 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01cb
            r0 = 0
            goto L_0x01cd
        L_0x01cb:
            r0 = r103
        L_0x01cd:
            r68 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01d5
            r0 = 0
            goto L_0x01d7
        L_0x01d5:
            r0 = r104
        L_0x01d7:
            r20 = r1 & r20
            if (r20 == 0) goto L_0x01de
            r20 = 0
            goto L_0x01e0
        L_0x01de:
            r20 = r105
        L_0x01e0:
            r22 = r1 & r22
            r69 = r0
            if (r22 == 0) goto L_0x01e9
            r22 = 2
            goto L_0x01eb
        L_0x01e9:
            r22 = r106
        L_0x01eb:
            r24 = r1 & r24
            if (r24 == 0) goto L_0x01f2
            r24 = 0
            goto L_0x01f4
        L_0x01f2:
            r24 = r107
        L_0x01f4:
            r41 = 262144(0x40000, float:3.67342E-40)
            r41 = r1 & r41
            if (r41 == 0) goto L_0x01fd
            r41 = 2
            goto L_0x01ff
        L_0x01fd:
            r41 = r108
        L_0x01ff:
            r42 = 524288(0x80000, float:7.34684E-40)
            r42 = r1 & r42
            if (r42 == 0) goto L_0x0208
            r42 = 0
            goto L_0x020a
        L_0x0208:
            r42 = r109
        L_0x020a:
            r43 = 1048576(0x100000, float:1.469368E-39)
            r43 = r1 & r43
            if (r43 == 0) goto L_0x0213
            r43 = 4626885667169763328(0x4036000000000000, double:22.0)
            goto L_0x0215
        L_0x0213:
            r43 = r110
        L_0x0215:
            r45 = 2097152(0x200000, float:2.938736E-39)
            r45 = r1 & r45
            if (r45 == 0) goto L_0x021e
            r45 = 4626885667169763328(0x4036000000000000, double:22.0)
            goto L_0x0220
        L_0x021e:
            r45 = r112
        L_0x0220:
            r47 = 4194304(0x400000, float:5.877472E-39)
            r47 = r1 & r47
            if (r47 == 0) goto L_0x0229
            r47 = 2
            goto L_0x022b
        L_0x0229:
            r47 = r114
        L_0x022b:
            r48 = 8388608(0x800000, float:1.17549435E-38)
            r48 = r1 & r48
            if (r48 == 0) goto L_0x0234
            r48 = 0
            goto L_0x0236
        L_0x0234:
            r48 = r115
        L_0x0236:
            r49 = 16777216(0x1000000, float:2.3509887E-38)
            r49 = r1 & r49
            if (r49 == 0) goto L_0x023f
            r49 = 0
            goto L_0x0241
        L_0x023f:
            r49 = r116
        L_0x0241:
            r50 = 33554432(0x2000000, float:9.403955E-38)
            r50 = r1 & r50
            r51 = 1
            r70 = 2
            if (r50 == 0) goto L_0x025d
            r0 = 3
            double[] r0 = new double[r0]
            r52 = 4626322717216342016(0x4034000000000000, double:20.0)
            r50 = 0
            r0[r50] = r52
            r52 = 4627167142146473984(0x4037000000000000, double:23.0)
            r0[r51] = r52
            r52 = 4627730092099895296(0x4039000000000000, double:25.0)
            r0[r70] = r52
            goto L_0x025f
        L_0x025d:
            r0 = r117
        L_0x025f:
            r50 = 67108864(0x4000000, float:1.5046328E-36)
            r50 = r1 & r50
            if (r50 == 0) goto L_0x0268
            r50 = 0
            goto L_0x026a
        L_0x0268:
            r50 = r118
        L_0x026a:
            r52 = 134217728(0x8000000, float:3.85186E-34)
            r52 = r1 & r52
            r71 = r0
            if (r52 == 0) goto L_0x0281
            r0 = r70
            double[] r0 = new double[r0]
            r52 = 4626322717216342016(0x4034000000000000, double:20.0)
            r54 = 0
            r0[r54] = r52
            r52 = 4627730092099895296(0x4039000000000000, double:25.0)
            r0[r51] = r52
            goto L_0x0283
        L_0x0281:
            r0 = r119
        L_0x0283:
            r51 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = r1 & r51
            if (r1 == 0) goto L_0x028c
            r122 = 0
            goto L_0x028e
        L_0x028c:
            r122 = r120
        L_0x028e:
            r57 = r55
            r84 = r58
            r85 = r59
            r86 = r60
            r87 = r61
            r89 = r62
            r98 = r63
            r99 = r64
            r102 = r65
            r103 = r66
            r104 = r67
            r105 = r68
            r106 = r69
            r119 = r71
            r121 = r0
            r88 = r2
            r60 = r3
            r73 = r4
            r61 = r5
            r70 = r6
            r62 = r7
            r63 = r8
            r93 = r9
            r64 = r10
            r65 = r11
            r66 = r12
            r67 = r13
            r68 = r14
            r69 = r15
            r100 = r16
            r71 = r18
            r107 = r20
            r74 = r21
            r108 = r22
            r75 = r23
            r109 = r24
            r76 = r25
            r77 = r26
            r78 = r27
            r79 = r28
            r80 = r29
            r81 = r30
            r82 = r31
            r83 = r32
            r59 = r33
            r90 = r34
            r91 = r35
            r92 = r36
            r94 = r37
            r95 = r38
            r96 = r39
            r97 = r40
            r110 = r41
            r111 = r42
            r112 = r43
            r114 = r45
            r116 = r47
            r117 = r48
            r118 = r49
            r120 = r50
            r58 = r56
            r57.<init>(r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r114, r116, r117, r118, r119, r120, r121, r122)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceCombo3in1.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, int, int, int, long, int, int, int, int, int, int, int, int, int, int, double, double, int, int, int, double[], int, double[], java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public WelcomeHomeLocation getWelcomeHome() {
        return this.welcomeHome;
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

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public int getOscillationState() {
        return this.oscillationState;
    }

    public int getOscillationAngle() {
        return this.oscillationAngle;
    }

    public int getOscillationDirection() {
        return this.oscillationDirection;
    }

    public int getOscillationFanSpeed() {
        return this.oscillationFanSpeed;
    }

    public int getMainMode() {
        return this.mainMode;
    }

    public int getApSubMode() {
        return this.apSubMode;
    }

    public int getApFanSpeed() {
        return this.apFanSpeed;
    }

    public int getHeatSubMode() {
        return this.heatSubMode;
    }

    public int getHeatFanSpeed() {
        return this.heatFanSpeed;
    }

    public double getHeatAutoTmp() {
        return this.heatAutoTmp;
    }

    public double getHeatEcoTmp() {
        return this.heatEcoTmp;
    }

    public int getCoolSubMode() {
        return this.coolSubMode;
    }

    public int getCoolFanSpeed() {
        return this.coolFanSpeed;
    }

    public int getCoolAutoTag() {
        return this.coolAutoTag;
    }

    public double[] getCoolAutoPresets() {
        return this.coolAutoPresets;
    }

    public int getCoolEcoTag() {
        return this.coolEcoTag;
    }

    public double[] getCoolEcoPresets() {
        return this.coolEcoPresets;
    }

    public String getLocationId() {
        return this.locationId;
    }
}
