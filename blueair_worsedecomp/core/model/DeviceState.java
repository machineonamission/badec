package com.blueair.core.model;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0003\b\u0002\b\b\u0018\u00002\u00020\u0001B\b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bZ\u0010[J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010¸\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010º\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010»\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010¼\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010½\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010À\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ä\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010Æ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010È\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ì\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Í\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Î\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010Ï\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ð\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ñ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ò\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ó\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ô\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Õ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010×\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ø\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ù\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ú\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ü\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Ý\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010á\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010â\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ã\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ä\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010å\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010æ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010è\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ê\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010ë\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010í\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010î\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010ñ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ò\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ó\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010ô\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010õ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ö\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010÷\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ø\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ù\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010û\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ü\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010þ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010ÿ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010gJ\b\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0003\u0010\u0002J\u0015\u0010\u0002\u001a\u00020\u00052\t\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0002\u001a\u00020\fHÖ\u0001J\n\u0010\u0002\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\b^\u0010_R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\ba\u0010_R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bb\u0010_R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bc\u0010_R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bd\u0010_R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\be\u0010_R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010gR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bi\u0010_R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bj\u0010_R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bk\u0010]R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bl\u0010_R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010]R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bn\u0010gR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bo\u0010_R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bp\u0010gR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bq\u0010_R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\br\u0010gR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bs\u0010_R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bt\u0010_R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bu\u0010gR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bv\u0010gR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bw\u0010gR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010`\u001a\u0004\bx\u0010_R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\by\u0010gR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\bz\u0010gR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\b{\u0010gR\u0015\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\b|\u0010gR\u0015\u0010!\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\b}\u0010gR\u0015\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\b~\u0010gR\u0015\u0010#\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010h\u001a\u0004\b\u0010gR\u0016\u0010$\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010(\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010)\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010*\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010+\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010,\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010-\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010.\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010/\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00100\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00101\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00102\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00103\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00104\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00105\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00106\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00107\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u00108\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b\u0001\u0010_R\u0016\u00109\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010:\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010;\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b\u0001\u0010_R\u0016\u0010<\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010=\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b\u0001\u0010_R\u0016\u0010>\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b\u0001\u0010_R\u0016\u0010?\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010@\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010A\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b\u0001\u0010_R\u0016\u0010B\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b\u0001\u0010_R\u0016\u0010C\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b\u0001\u0010gR\u0016\u0010D\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b \u0001\u0010gR\u0016\u0010E\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b¡\u0001\u0010gR\u0016\u0010F\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b¢\u0001\u0010gR\u0016\u0010G\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b£\u0001\u0010gR\u0016\u0010H\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b¤\u0001\u0010gR\u0016\u0010I\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b¥\u0001\u0010gR\u0016\u0010J\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b¦\u0001\u0010gR\u0016\u0010K\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b§\u0001\u0010_R\u0016\u0010L\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b¨\u0001\u0010_R\u0016\u0010M\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b©\u0001\u0010gR\u0016\u0010N\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\bª\u0001\u0010gR\u0015\u0010O\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001R\u0015\u0010P\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b­\u0001\u0010¬\u0001R\u0015\u0010Q\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010¬\u0001R\u0015\u0010R\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010¬\u0001R\u0015\u0010S\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b°\u0001\u0010¬\u0001R\u0015\u0010T\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010¬\u0001R\u0016\u0010U\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b²\u0001\u0010gR\u0016\u0010V\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b³\u0001\u0010_R\u0016\u0010W\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\b´\u0001\u0010_R\u0016\u0010X\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010`\u001a\u0005\bµ\u0001\u0010_R\u0016\u0010Y\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010h\u001a\u0005\b¶\u0001\u0010g¨\u0006\u0002"}, d2 = {"Lcom/blueair/core/model/DeviceState;", "", "cfv", "", "germshield", "", "gsnm", "standby", "eco", "hins", "nmhins", "fanspeed", "", "childlock", "nightmode", "mfv", "automode", "ofv", "brightness", "safetyswitch", "filterusage", "disinfection", "disinftime", "wickdrye", "wickdrys", "wickdryl", "wickdryts", "wickusage", "wshortage", "autorh", "timstate", "timdur", "timl", "timts", "tu", "oscstate", "osc", "oscdir", "oscfs", "mainmode", "apsubmode", "fsp0", "heatsubmode", "heatfs", "heattemp", "ecoheattemp", "coolsubmode", "coolfs", "coolautotag", "coolautofs1", "coolautofs2", "coolautofs3", "coolecotag", "coolecofs1", "coolecofs2", "mode", "hummode", "wlevel", "dehsubmode", "watertankfailure", "smartsubmode", "detectcat", "bodymounted", "aireta", "displaymode", "hover", "airrefresh", "arstate", "ardur", "arts", "startts", "endts", "roomtype", "nlbrightness", "wickdrydur", "wickdrydone", "ywrme", "ywrmusage", "nlstepless", "alarm1", "alarm2", "alarm3", "alarm4", "alarm5", "alarm6", "humsubmode", "hourformat", "wtankfail", "waterinfill", "sensormode", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getCfv", "()Ljava/lang/String;", "getGermshield", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGsnm", "getStandby", "getEco", "getHins", "getNmhins", "getFanspeed", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChildlock", "getNightmode", "getMfv", "getAutomode", "getOfv", "getBrightness", "getSafetyswitch", "getFilterusage", "getDisinfection", "getDisinftime", "getWickdrye", "getWickdrys", "getWickdryl", "getWickdryts", "getWickusage", "getWshortage", "getAutorh", "getTimstate", "getTimdur", "getTiml", "getTimts", "getTu", "getOscstate", "getOsc", "getOscdir", "getOscfs", "getMainmode", "getApsubmode", "getFsp0", "getHeatsubmode", "getHeatfs", "getHeattemp", "getEcoheattemp", "getCoolsubmode", "getCoolfs", "getCoolautotag", "getCoolautofs1", "getCoolautofs2", "getCoolautofs3", "getCoolecotag", "getCoolecofs1", "getCoolecofs2", "getMode", "getHummode", "getWlevel", "getDehsubmode", "getWatertankfailure", "getSmartsubmode", "getDetectcat", "getBodymounted", "getAireta", "getDisplaymode", "getHover", "getAirrefresh", "getArstate", "getArdur", "getArts", "getStartts", "getEndts", "getRoomtype", "getNlbrightness", "getWickdrydur", "getWickdrydone", "getYwrme", "getYwrmusage", "getNlstepless", "getAlarm1", "()Ljava/lang/Object;", "getAlarm2", "getAlarm3", "getAlarm4", "getAlarm5", "getAlarm6", "getHumsubmode", "getHourformat", "getWtankfail", "getWaterinfill", "getSensormode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/blueair/core/model/DeviceState;", "equals", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceStateBundle.kt */
public final class DeviceState {
    private final Integer aireta;
    private final Boolean airrefresh;
    private final Object alarm1;
    private final Object alarm2;
    private final Object alarm3;
    private final Object alarm4;
    private final Object alarm5;
    private final Object alarm6;
    private final Integer apsubmode;
    private final Integer ardur;
    private final Integer arstate;
    private final Integer arts;
    private final Boolean automode;
    private final Integer autorh;
    private final Boolean bodymounted;
    private final Integer brightness;
    private final String cfv;
    private final Boolean childlock;
    private final Integer coolautofs1;
    private final Integer coolautofs2;
    private final Integer coolautofs3;
    private final Integer coolautotag;
    private final Integer coolecofs1;
    private final Integer coolecofs2;
    private final Integer coolecotag;
    private final Integer coolfs;
    private final Integer coolsubmode;
    private final Integer dehsubmode;
    private final Boolean detectcat;
    private final Boolean disinfection;
    private final Integer disinftime;
    private final Integer displaymode;
    private final Boolean eco;
    private final Integer ecoheattemp;
    private final Integer endts;
    private final Integer fanspeed;
    private final Integer filterusage;
    private final Integer fsp0;
    private final Boolean germshield;
    private final Boolean gsnm;
    private final Integer heatfs;
    private final Integer heatsubmode;
    private final Integer heattemp;
    private final Boolean hins;
    private final Boolean hourformat;
    private final Boolean hover;
    private final Boolean hummode;
    private final Integer humsubmode;
    private final Integer mainmode;
    private final String mfv;
    private final Integer mode;
    private final Boolean nightmode;
    private final Integer nlbrightness;
    private final Integer nlstepless;
    private final Boolean nmhins;
    private final String ofv;
    private final Integer osc;
    private final Integer oscdir;
    private final Integer oscfs;
    private final Integer oscstate;
    private final Integer roomtype;
    private final Boolean safetyswitch;
    private final Integer sensormode;
    private final Integer smartsubmode;
    private final Boolean standby;
    private final Integer startts;
    private final Integer timdur;
    private final Integer timl;
    private final Integer timstate;
    private final Integer timts;
    private final Integer tu;
    private final Boolean waterinfill;
    private final Boolean watertankfailure;
    private final Boolean wickdrydone;
    private final Integer wickdrydur;
    private final Boolean wickdrye;
    private final Integer wickdryl;
    private final Boolean wickdrys;
    private final Integer wickdryts;
    private final Integer wickusage;
    private final Integer wlevel;
    private final Boolean wshortage;
    private final Boolean wtankfail;
    private final Boolean ywrme;
    private final Integer ywrmusage;

    public DeviceState() {
        this((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, -1, -1, 2097151, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceState copy$default(DeviceState deviceState, String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num, Boolean bool7, Boolean bool8, String str2, Boolean bool9, String str3, Integer num2, Boolean bool10, Integer num3, Boolean bool11, Integer num4, Boolean bool12, Boolean bool13, Integer num5, Integer num6, Integer num7, Boolean bool14, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Boolean bool15, Integer num35, Integer num36, Boolean bool16, Integer num37, Boolean bool17, Boolean bool18, Integer num38, Integer num39, Boolean bool19, Boolean bool20, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47, Boolean bool21, Boolean bool22, Integer num48, Integer num49, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Integer num50, Boolean bool23, Boolean bool24, Boolean bool25, Integer num51, int i, int i2, int i3, Object obj7) {
        DeviceState deviceState2 = deviceState;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        String str4 = (i4 & 1) != 0 ? deviceState2.cfv : str;
        return deviceState2.copy(str4, (i4 & 2) != 0 ? deviceState2.germshield : bool, (i4 & 4) != 0 ? deviceState2.gsnm : bool2, (i4 & 8) != 0 ? deviceState2.standby : bool3, (i4 & 16) != 0 ? deviceState2.eco : bool4, (i4 & 32) != 0 ? deviceState2.hins : bool5, (i4 & 64) != 0 ? deviceState2.nmhins : bool6, (i4 & 128) != 0 ? deviceState2.fanspeed : num, (i4 & 256) != 0 ? deviceState2.childlock : bool7, (i4 & 512) != 0 ? deviceState2.nightmode : bool8, (i4 & 1024) != 0 ? deviceState2.mfv : str2, (i4 & 2048) != 0 ? deviceState2.automode : bool9, (i4 & 4096) != 0 ? deviceState2.ofv : str3, (i4 & 8192) != 0 ? deviceState2.brightness : num2, (i4 & 16384) != 0 ? deviceState2.safetyswitch : bool10, (i4 & 32768) != 0 ? deviceState2.filterusage : num3, (i & 65536) != 0 ? deviceState2.disinfection : bool11, (i & 131072) != 0 ? deviceState2.disinftime : num4, (i & 262144) != 0 ? deviceState2.wickdrye : bool12, (i & 524288) != 0 ? deviceState2.wickdrys : bool13, (i & 1048576) != 0 ? deviceState2.wickdryl : num5, (i & 2097152) != 0 ? deviceState2.wickdryts : num6, (i & 4194304) != 0 ? deviceState2.wickusage : num7, (i & 8388608) != 0 ? deviceState2.wshortage : bool14, (i & 16777216) != 0 ? deviceState2.autorh : num8, (i & 33554432) != 0 ? deviceState2.timstate : num9, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceState2.timdur : num10, (i & 134217728) != 0 ? deviceState2.timl : num11, (i & 268435456) != 0 ? deviceState2.timts : num12, (i & 536870912) != 0 ? deviceState2.tu : num13, (i & 1073741824) != 0 ? deviceState2.oscstate : num14, (i & Integer.MIN_VALUE) != 0 ? deviceState2.osc : num15, (i5 & 1) != 0 ? deviceState2.oscdir : num16, (i5 & 2) != 0 ? deviceState2.oscfs : num17, (i5 & 4) != 0 ? deviceState2.mainmode : num18, (i5 & 8) != 0 ? deviceState2.apsubmode : num19, (i5 & 16) != 0 ? deviceState2.fsp0 : num20, (i5 & 32) != 0 ? deviceState2.heatsubmode : num21, (i5 & 64) != 0 ? deviceState2.heatfs : num22, (i5 & 128) != 0 ? deviceState2.heattemp : num23, (i5 & 256) != 0 ? deviceState2.ecoheattemp : num24, (i5 & 512) != 0 ? deviceState2.coolsubmode : num25, (i5 & 1024) != 0 ? deviceState2.coolfs : num26, (i5 & 2048) != 0 ? deviceState2.coolautotag : num27, (i5 & 4096) != 0 ? deviceState2.coolautofs1 : num28, (i5 & 8192) != 0 ? deviceState2.coolautofs2 : num29, (i5 & 16384) != 0 ? deviceState2.coolautofs3 : num30, (i5 & 32768) != 0 ? deviceState2.coolecotag : num31, (i5 & 65536) != 0 ? deviceState2.coolecofs1 : num32, (i5 & 131072) != 0 ? deviceState2.coolecofs2 : num33, (i5 & 262144) != 0 ? deviceState2.mode : num34, (i5 & 524288) != 0 ? deviceState2.hummode : bool15, (i5 & 1048576) != 0 ? deviceState2.wlevel : num35, (i5 & 2097152) != 0 ? deviceState2.dehsubmode : num36, (i5 & 4194304) != 0 ? deviceState2.watertankfailure : bool16, (i5 & 8388608) != 0 ? deviceState2.smartsubmode : num37, (i5 & 16777216) != 0 ? deviceState2.detectcat : bool17, (i5 & 33554432) != 0 ? deviceState2.bodymounted : bool18, (i5 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceState2.aireta : num38, (i5 & 134217728) != 0 ? deviceState2.displaymode : num39, (i5 & 268435456) != 0 ? deviceState2.hover : bool19, (i5 & 536870912) != 0 ? deviceState2.airrefresh : bool20, (i5 & 1073741824) != 0 ? deviceState2.arstate : num40, (i5 & Integer.MIN_VALUE) != 0 ? deviceState2.ardur : num41, (i6 & 1) != 0 ? deviceState2.arts : num42, (i6 & 2) != 0 ? deviceState2.startts : num43, (i6 & 4) != 0 ? deviceState2.endts : num44, (i6 & 8) != 0 ? deviceState2.roomtype : num45, (i6 & 16) != 0 ? deviceState2.nlbrightness : num46, (i6 & 32) != 0 ? deviceState2.wickdrydur : num47, (i6 & 64) != 0 ? deviceState2.wickdrydone : bool21, (i6 & 128) != 0 ? deviceState2.ywrme : bool22, (i6 & 256) != 0 ? deviceState2.ywrmusage : num48, (i6 & 512) != 0 ? deviceState2.nlstepless : num49, (i6 & 1024) != 0 ? deviceState2.alarm1 : obj, (i6 & 2048) != 0 ? deviceState2.alarm2 : obj2, (i6 & 4096) != 0 ? deviceState2.alarm3 : obj3, (i6 & 8192) != 0 ? deviceState2.alarm4 : obj4, (i6 & 16384) != 0 ? deviceState2.alarm5 : obj5, (i6 & 32768) != 0 ? deviceState2.alarm6 : obj6, (i6 & 65536) != 0 ? deviceState2.humsubmode : num50, (i6 & 131072) != 0 ? deviceState2.hourformat : bool23, (i6 & 262144) != 0 ? deviceState2.wtankfail : bool24, (i6 & 524288) != 0 ? deviceState2.waterinfill : bool25, (i6 & 1048576) != 0 ? deviceState2.sensormode : num51);
    }

    public final String component1() {
        return this.cfv;
    }

    public final Boolean component10() {
        return this.nightmode;
    }

    public final String component11() {
        return this.mfv;
    }

    public final Boolean component12() {
        return this.automode;
    }

    public final String component13() {
        return this.ofv;
    }

    public final Integer component14() {
        return this.brightness;
    }

    public final Boolean component15() {
        return this.safetyswitch;
    }

    public final Integer component16() {
        return this.filterusage;
    }

    public final Boolean component17() {
        return this.disinfection;
    }

    public final Integer component18() {
        return this.disinftime;
    }

    public final Boolean component19() {
        return this.wickdrye;
    }

    public final Boolean component2() {
        return this.germshield;
    }

    public final Boolean component20() {
        return this.wickdrys;
    }

    public final Integer component21() {
        return this.wickdryl;
    }

    public final Integer component22() {
        return this.wickdryts;
    }

    public final Integer component23() {
        return this.wickusage;
    }

    public final Boolean component24() {
        return this.wshortage;
    }

    public final Integer component25() {
        return this.autorh;
    }

    public final Integer component26() {
        return this.timstate;
    }

    public final Integer component27() {
        return this.timdur;
    }

    public final Integer component28() {
        return this.timl;
    }

    public final Integer component29() {
        return this.timts;
    }

    public final Boolean component3() {
        return this.gsnm;
    }

    public final Integer component30() {
        return this.tu;
    }

    public final Integer component31() {
        return this.oscstate;
    }

    public final Integer component32() {
        return this.osc;
    }

    public final Integer component33() {
        return this.oscdir;
    }

    public final Integer component34() {
        return this.oscfs;
    }

    public final Integer component35() {
        return this.mainmode;
    }

    public final Integer component36() {
        return this.apsubmode;
    }

    public final Integer component37() {
        return this.fsp0;
    }

    public final Integer component38() {
        return this.heatsubmode;
    }

    public final Integer component39() {
        return this.heatfs;
    }

    public final Boolean component4() {
        return this.standby;
    }

    public final Integer component40() {
        return this.heattemp;
    }

    public final Integer component41() {
        return this.ecoheattemp;
    }

    public final Integer component42() {
        return this.coolsubmode;
    }

    public final Integer component43() {
        return this.coolfs;
    }

    public final Integer component44() {
        return this.coolautotag;
    }

    public final Integer component45() {
        return this.coolautofs1;
    }

    public final Integer component46() {
        return this.coolautofs2;
    }

    public final Integer component47() {
        return this.coolautofs3;
    }

    public final Integer component48() {
        return this.coolecotag;
    }

    public final Integer component49() {
        return this.coolecofs1;
    }

    public final Boolean component5() {
        return this.eco;
    }

    public final Integer component50() {
        return this.coolecofs2;
    }

    public final Integer component51() {
        return this.mode;
    }

    public final Boolean component52() {
        return this.hummode;
    }

    public final Integer component53() {
        return this.wlevel;
    }

    public final Integer component54() {
        return this.dehsubmode;
    }

    public final Boolean component55() {
        return this.watertankfailure;
    }

    public final Integer component56() {
        return this.smartsubmode;
    }

    public final Boolean component57() {
        return this.detectcat;
    }

    public final Boolean component58() {
        return this.bodymounted;
    }

    public final Integer component59() {
        return this.aireta;
    }

    public final Boolean component6() {
        return this.hins;
    }

    public final Integer component60() {
        return this.displaymode;
    }

    public final Boolean component61() {
        return this.hover;
    }

    public final Boolean component62() {
        return this.airrefresh;
    }

    public final Integer component63() {
        return this.arstate;
    }

    public final Integer component64() {
        return this.ardur;
    }

    public final Integer component65() {
        return this.arts;
    }

    public final Integer component66() {
        return this.startts;
    }

    public final Integer component67() {
        return this.endts;
    }

    public final Integer component68() {
        return this.roomtype;
    }

    public final Integer component69() {
        return this.nlbrightness;
    }

    public final Boolean component7() {
        return this.nmhins;
    }

    public final Integer component70() {
        return this.wickdrydur;
    }

    public final Boolean component71() {
        return this.wickdrydone;
    }

    public final Boolean component72() {
        return this.ywrme;
    }

    public final Integer component73() {
        return this.ywrmusage;
    }

    public final Integer component74() {
        return this.nlstepless;
    }

    public final Object component75() {
        return this.alarm1;
    }

    public final Object component76() {
        return this.alarm2;
    }

    public final Object component77() {
        return this.alarm3;
    }

    public final Object component78() {
        return this.alarm4;
    }

    public final Object component79() {
        return this.alarm5;
    }

    public final Integer component8() {
        return this.fanspeed;
    }

    public final Object component80() {
        return this.alarm6;
    }

    public final Integer component81() {
        return this.humsubmode;
    }

    public final Boolean component82() {
        return this.hourformat;
    }

    public final Boolean component83() {
        return this.wtankfail;
    }

    public final Boolean component84() {
        return this.waterinfill;
    }

    public final Integer component85() {
        return this.sensormode;
    }

    public final Boolean component9() {
        return this.childlock;
    }

    public final DeviceState copy(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num, Boolean bool7, Boolean bool8, String str2, Boolean bool9, String str3, Integer num2, Boolean bool10, Integer num3, Boolean bool11, Integer num4, Boolean bool12, Boolean bool13, Integer num5, Integer num6, Integer num7, Boolean bool14, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Boolean bool15, Integer num35, Integer num36, Boolean bool16, Integer num37, Boolean bool17, Boolean bool18, Integer num38, Integer num39, Boolean bool19, Boolean bool20, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47, Boolean bool21, Boolean bool22, Integer num48, Integer num49, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Integer num50, Boolean bool23, Boolean bool24, Boolean bool25, Integer num51) {
        return new DeviceState(str, bool, bool2, bool3, bool4, bool5, bool6, num, bool7, bool8, str2, bool9, str3, num2, bool10, num3, bool11, num4, bool12, bool13, num5, num6, num7, bool14, num8, num9, num10, num11, num12, num13, num14, num15, num16, num17, num18, num19, num20, num21, num22, num23, num24, num25, num26, num27, num28, num29, num30, num31, num32, num33, num34, bool15, num35, num36, bool16, num37, bool17, bool18, num38, num39, bool19, bool20, num40, num41, num42, num43, num44, num45, num46, num47, bool21, bool22, num48, num49, obj, obj2, obj3, obj4, obj5, obj6, num50, bool23, bool24, bool25, num51);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceState)) {
            return false;
        }
        DeviceState deviceState = (DeviceState) obj;
        return Intrinsics.areEqual((Object) this.cfv, (Object) deviceState.cfv) && Intrinsics.areEqual((Object) this.germshield, (Object) deviceState.germshield) && Intrinsics.areEqual((Object) this.gsnm, (Object) deviceState.gsnm) && Intrinsics.areEqual((Object) this.standby, (Object) deviceState.standby) && Intrinsics.areEqual((Object) this.eco, (Object) deviceState.eco) && Intrinsics.areEqual((Object) this.hins, (Object) deviceState.hins) && Intrinsics.areEqual((Object) this.nmhins, (Object) deviceState.nmhins) && Intrinsics.areEqual((Object) this.fanspeed, (Object) deviceState.fanspeed) && Intrinsics.areEqual((Object) this.childlock, (Object) deviceState.childlock) && Intrinsics.areEqual((Object) this.nightmode, (Object) deviceState.nightmode) && Intrinsics.areEqual((Object) this.mfv, (Object) deviceState.mfv) && Intrinsics.areEqual((Object) this.automode, (Object) deviceState.automode) && Intrinsics.areEqual((Object) this.ofv, (Object) deviceState.ofv) && Intrinsics.areEqual((Object) this.brightness, (Object) deviceState.brightness) && Intrinsics.areEqual((Object) this.safetyswitch, (Object) deviceState.safetyswitch) && Intrinsics.areEqual((Object) this.filterusage, (Object) deviceState.filterusage) && Intrinsics.areEqual((Object) this.disinfection, (Object) deviceState.disinfection) && Intrinsics.areEqual((Object) this.disinftime, (Object) deviceState.disinftime) && Intrinsics.areEqual((Object) this.wickdrye, (Object) deviceState.wickdrye) && Intrinsics.areEqual((Object) this.wickdrys, (Object) deviceState.wickdrys) && Intrinsics.areEqual((Object) this.wickdryl, (Object) deviceState.wickdryl) && Intrinsics.areEqual((Object) this.wickdryts, (Object) deviceState.wickdryts) && Intrinsics.areEqual((Object) this.wickusage, (Object) deviceState.wickusage) && Intrinsics.areEqual((Object) this.wshortage, (Object) deviceState.wshortage) && Intrinsics.areEqual((Object) this.autorh, (Object) deviceState.autorh) && Intrinsics.areEqual((Object) this.timstate, (Object) deviceState.timstate) && Intrinsics.areEqual((Object) this.timdur, (Object) deviceState.timdur) && Intrinsics.areEqual((Object) this.timl, (Object) deviceState.timl) && Intrinsics.areEqual((Object) this.timts, (Object) deviceState.timts) && Intrinsics.areEqual((Object) this.tu, (Object) deviceState.tu) && Intrinsics.areEqual((Object) this.oscstate, (Object) deviceState.oscstate) && Intrinsics.areEqual((Object) this.osc, (Object) deviceState.osc) && Intrinsics.areEqual((Object) this.oscdir, (Object) deviceState.oscdir) && Intrinsics.areEqual((Object) this.oscfs, (Object) deviceState.oscfs) && Intrinsics.areEqual((Object) this.mainmode, (Object) deviceState.mainmode) && Intrinsics.areEqual((Object) this.apsubmode, (Object) deviceState.apsubmode) && Intrinsics.areEqual((Object) this.fsp0, (Object) deviceState.fsp0) && Intrinsics.areEqual((Object) this.heatsubmode, (Object) deviceState.heatsubmode) && Intrinsics.areEqual((Object) this.heatfs, (Object) deviceState.heatfs) && Intrinsics.areEqual((Object) this.heattemp, (Object) deviceState.heattemp) && Intrinsics.areEqual((Object) this.ecoheattemp, (Object) deviceState.ecoheattemp) && Intrinsics.areEqual((Object) this.coolsubmode, (Object) deviceState.coolsubmode) && Intrinsics.areEqual((Object) this.coolfs, (Object) deviceState.coolfs) && Intrinsics.areEqual((Object) this.coolautotag, (Object) deviceState.coolautotag) && Intrinsics.areEqual((Object) this.coolautofs1, (Object) deviceState.coolautofs1) && Intrinsics.areEqual((Object) this.coolautofs2, (Object) deviceState.coolautofs2) && Intrinsics.areEqual((Object) this.coolautofs3, (Object) deviceState.coolautofs3) && Intrinsics.areEqual((Object) this.coolecotag, (Object) deviceState.coolecotag) && Intrinsics.areEqual((Object) this.coolecofs1, (Object) deviceState.coolecofs1) && Intrinsics.areEqual((Object) this.coolecofs2, (Object) deviceState.coolecofs2) && Intrinsics.areEqual((Object) this.mode, (Object) deviceState.mode) && Intrinsics.areEqual((Object) this.hummode, (Object) deviceState.hummode) && Intrinsics.areEqual((Object) this.wlevel, (Object) deviceState.wlevel) && Intrinsics.areEqual((Object) this.dehsubmode, (Object) deviceState.dehsubmode) && Intrinsics.areEqual((Object) this.watertankfailure, (Object) deviceState.watertankfailure) && Intrinsics.areEqual((Object) this.smartsubmode, (Object) deviceState.smartsubmode) && Intrinsics.areEqual((Object) this.detectcat, (Object) deviceState.detectcat) && Intrinsics.areEqual((Object) this.bodymounted, (Object) deviceState.bodymounted) && Intrinsics.areEqual((Object) this.aireta, (Object) deviceState.aireta) && Intrinsics.areEqual((Object) this.displaymode, (Object) deviceState.displaymode) && Intrinsics.areEqual((Object) this.hover, (Object) deviceState.hover) && Intrinsics.areEqual((Object) this.airrefresh, (Object) deviceState.airrefresh) && Intrinsics.areEqual((Object) this.arstate, (Object) deviceState.arstate) && Intrinsics.areEqual((Object) this.ardur, (Object) deviceState.ardur) && Intrinsics.areEqual((Object) this.arts, (Object) deviceState.arts) && Intrinsics.areEqual((Object) this.startts, (Object) deviceState.startts) && Intrinsics.areEqual((Object) this.endts, (Object) deviceState.endts) && Intrinsics.areEqual((Object) this.roomtype, (Object) deviceState.roomtype) && Intrinsics.areEqual((Object) this.nlbrightness, (Object) deviceState.nlbrightness) && Intrinsics.areEqual((Object) this.wickdrydur, (Object) deviceState.wickdrydur) && Intrinsics.areEqual((Object) this.wickdrydone, (Object) deviceState.wickdrydone) && Intrinsics.areEqual((Object) this.ywrme, (Object) deviceState.ywrme) && Intrinsics.areEqual((Object) this.ywrmusage, (Object) deviceState.ywrmusage) && Intrinsics.areEqual((Object) this.nlstepless, (Object) deviceState.nlstepless) && Intrinsics.areEqual(this.alarm1, deviceState.alarm1) && Intrinsics.areEqual(this.alarm2, deviceState.alarm2) && Intrinsics.areEqual(this.alarm3, deviceState.alarm3) && Intrinsics.areEqual(this.alarm4, deviceState.alarm4) && Intrinsics.areEqual(this.alarm5, deviceState.alarm5) && Intrinsics.areEqual(this.alarm6, deviceState.alarm6) && Intrinsics.areEqual((Object) this.humsubmode, (Object) deviceState.humsubmode) && Intrinsics.areEqual((Object) this.hourformat, (Object) deviceState.hourformat) && Intrinsics.areEqual((Object) this.wtankfail, (Object) deviceState.wtankfail) && Intrinsics.areEqual((Object) this.waterinfill, (Object) deviceState.waterinfill) && Intrinsics.areEqual((Object) this.sensormode, (Object) deviceState.sensormode);
    }

    public int hashCode() {
        String str = this.cfv;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.germshield;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.gsnm;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.standby;
        int hashCode4 = (hashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.eco;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.hins;
        int hashCode6 = (hashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.nmhins;
        int hashCode7 = (hashCode6 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Integer num = this.fanspeed;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool7 = this.childlock;
        int hashCode9 = (hashCode8 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.nightmode;
        int hashCode10 = (hashCode9 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        String str2 = this.mfv;
        int hashCode11 = (hashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool9 = this.automode;
        int hashCode12 = (hashCode11 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        String str3 = this.ofv;
        int hashCode13 = (hashCode12 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.brightness;
        int hashCode14 = (hashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool10 = this.safetyswitch;
        int hashCode15 = (hashCode14 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Integer num3 = this.filterusage;
        int hashCode16 = (hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool11 = this.disinfection;
        int hashCode17 = (hashCode16 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Integer num4 = this.disinftime;
        int hashCode18 = (hashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool12 = this.wickdrye;
        int hashCode19 = (hashCode18 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        Boolean bool13 = this.wickdrys;
        int hashCode20 = (hashCode19 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
        Integer num5 = this.wickdryl;
        int hashCode21 = (hashCode20 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.wickdryts;
        int hashCode22 = (hashCode21 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.wickusage;
        int hashCode23 = (hashCode22 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Boolean bool14 = this.wshortage;
        int hashCode24 = (hashCode23 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
        Integer num8 = this.autorh;
        int hashCode25 = (hashCode24 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.timstate;
        int hashCode26 = (hashCode25 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.timdur;
        int hashCode27 = (hashCode26 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.timl;
        int hashCode28 = (hashCode27 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.timts;
        int hashCode29 = (hashCode28 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.tu;
        int hashCode30 = (hashCode29 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.oscstate;
        int hashCode31 = (hashCode30 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.osc;
        int hashCode32 = (hashCode31 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Integer num16 = this.oscdir;
        int hashCode33 = (hashCode32 + (num16 == null ? 0 : num16.hashCode())) * 31;
        Integer num17 = this.oscfs;
        int hashCode34 = (hashCode33 + (num17 == null ? 0 : num17.hashCode())) * 31;
        Integer num18 = this.mainmode;
        int hashCode35 = (hashCode34 + (num18 == null ? 0 : num18.hashCode())) * 31;
        Integer num19 = this.apsubmode;
        int hashCode36 = (hashCode35 + (num19 == null ? 0 : num19.hashCode())) * 31;
        Integer num20 = this.fsp0;
        int hashCode37 = (hashCode36 + (num20 == null ? 0 : num20.hashCode())) * 31;
        Integer num21 = this.heatsubmode;
        int hashCode38 = (hashCode37 + (num21 == null ? 0 : num21.hashCode())) * 31;
        Integer num22 = this.heatfs;
        int hashCode39 = (hashCode38 + (num22 == null ? 0 : num22.hashCode())) * 31;
        Integer num23 = this.heattemp;
        int hashCode40 = (hashCode39 + (num23 == null ? 0 : num23.hashCode())) * 31;
        Integer num24 = this.ecoheattemp;
        int hashCode41 = (hashCode40 + (num24 == null ? 0 : num24.hashCode())) * 31;
        Integer num25 = this.coolsubmode;
        int hashCode42 = (hashCode41 + (num25 == null ? 0 : num25.hashCode())) * 31;
        Integer num26 = this.coolfs;
        int hashCode43 = (hashCode42 + (num26 == null ? 0 : num26.hashCode())) * 31;
        Integer num27 = this.coolautotag;
        int hashCode44 = (hashCode43 + (num27 == null ? 0 : num27.hashCode())) * 31;
        Integer num28 = this.coolautofs1;
        int hashCode45 = (hashCode44 + (num28 == null ? 0 : num28.hashCode())) * 31;
        Integer num29 = this.coolautofs2;
        int hashCode46 = (hashCode45 + (num29 == null ? 0 : num29.hashCode())) * 31;
        Integer num30 = this.coolautofs3;
        int hashCode47 = (hashCode46 + (num30 == null ? 0 : num30.hashCode())) * 31;
        Integer num31 = this.coolecotag;
        int hashCode48 = (hashCode47 + (num31 == null ? 0 : num31.hashCode())) * 31;
        Integer num32 = this.coolecofs1;
        int hashCode49 = (hashCode48 + (num32 == null ? 0 : num32.hashCode())) * 31;
        Integer num33 = this.coolecofs2;
        int hashCode50 = (hashCode49 + (num33 == null ? 0 : num33.hashCode())) * 31;
        Integer num34 = this.mode;
        int hashCode51 = (hashCode50 + (num34 == null ? 0 : num34.hashCode())) * 31;
        Boolean bool15 = this.hummode;
        int hashCode52 = (hashCode51 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
        Integer num35 = this.wlevel;
        int hashCode53 = (hashCode52 + (num35 == null ? 0 : num35.hashCode())) * 31;
        Integer num36 = this.dehsubmode;
        int hashCode54 = (hashCode53 + (num36 == null ? 0 : num36.hashCode())) * 31;
        Boolean bool16 = this.watertankfailure;
        int hashCode55 = (hashCode54 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
        Integer num37 = this.smartsubmode;
        int hashCode56 = (hashCode55 + (num37 == null ? 0 : num37.hashCode())) * 31;
        Boolean bool17 = this.detectcat;
        int hashCode57 = (hashCode56 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
        Boolean bool18 = this.bodymounted;
        int hashCode58 = (hashCode57 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
        Integer num38 = this.aireta;
        int hashCode59 = (hashCode58 + (num38 == null ? 0 : num38.hashCode())) * 31;
        Integer num39 = this.displaymode;
        int hashCode60 = (hashCode59 + (num39 == null ? 0 : num39.hashCode())) * 31;
        Boolean bool19 = this.hover;
        int hashCode61 = (hashCode60 + (bool19 == null ? 0 : bool19.hashCode())) * 31;
        Boolean bool20 = this.airrefresh;
        int hashCode62 = (hashCode61 + (bool20 == null ? 0 : bool20.hashCode())) * 31;
        Integer num40 = this.arstate;
        int hashCode63 = (hashCode62 + (num40 == null ? 0 : num40.hashCode())) * 31;
        Integer num41 = this.ardur;
        int hashCode64 = (hashCode63 + (num41 == null ? 0 : num41.hashCode())) * 31;
        Integer num42 = this.arts;
        int hashCode65 = (hashCode64 + (num42 == null ? 0 : num42.hashCode())) * 31;
        Integer num43 = this.startts;
        int hashCode66 = (hashCode65 + (num43 == null ? 0 : num43.hashCode())) * 31;
        Integer num44 = this.endts;
        int hashCode67 = (hashCode66 + (num44 == null ? 0 : num44.hashCode())) * 31;
        Integer num45 = this.roomtype;
        int hashCode68 = (hashCode67 + (num45 == null ? 0 : num45.hashCode())) * 31;
        Integer num46 = this.nlbrightness;
        int hashCode69 = (hashCode68 + (num46 == null ? 0 : num46.hashCode())) * 31;
        Integer num47 = this.wickdrydur;
        int hashCode70 = (hashCode69 + (num47 == null ? 0 : num47.hashCode())) * 31;
        Boolean bool21 = this.wickdrydone;
        int hashCode71 = (hashCode70 + (bool21 == null ? 0 : bool21.hashCode())) * 31;
        Boolean bool22 = this.ywrme;
        int hashCode72 = (hashCode71 + (bool22 == null ? 0 : bool22.hashCode())) * 31;
        Integer num48 = this.ywrmusage;
        int hashCode73 = (hashCode72 + (num48 == null ? 0 : num48.hashCode())) * 31;
        Integer num49 = this.nlstepless;
        int hashCode74 = (hashCode73 + (num49 == null ? 0 : num49.hashCode())) * 31;
        Object obj = this.alarm1;
        int hashCode75 = (hashCode74 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.alarm2;
        int hashCode76 = (hashCode75 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.alarm3;
        int hashCode77 = (hashCode76 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.alarm4;
        int hashCode78 = (hashCode77 + (obj4 == null ? 0 : obj4.hashCode())) * 31;
        Object obj5 = this.alarm5;
        int hashCode79 = (hashCode78 + (obj5 == null ? 0 : obj5.hashCode())) * 31;
        Object obj6 = this.alarm6;
        int hashCode80 = (hashCode79 + (obj6 == null ? 0 : obj6.hashCode())) * 31;
        Integer num50 = this.humsubmode;
        int hashCode81 = (hashCode80 + (num50 == null ? 0 : num50.hashCode())) * 31;
        Boolean bool23 = this.hourformat;
        int hashCode82 = (hashCode81 + (bool23 == null ? 0 : bool23.hashCode())) * 31;
        Boolean bool24 = this.wtankfail;
        int hashCode83 = (hashCode82 + (bool24 == null ? 0 : bool24.hashCode())) * 31;
        Boolean bool25 = this.waterinfill;
        int hashCode84 = (hashCode83 + (bool25 == null ? 0 : bool25.hashCode())) * 31;
        Integer num51 = this.sensormode;
        if (num51 != null) {
            i = num51.hashCode();
        }
        return hashCode84 + i;
    }

    public String toString() {
        return "DeviceState(cfv=" + this.cfv + ", germshield=" + this.germshield + ", gsnm=" + this.gsnm + ", standby=" + this.standby + ", eco=" + this.eco + ", hins=" + this.hins + ", nmhins=" + this.nmhins + ", fanspeed=" + this.fanspeed + ", childlock=" + this.childlock + ", nightmode=" + this.nightmode + ", mfv=" + this.mfv + ", automode=" + this.automode + ", ofv=" + this.ofv + ", brightness=" + this.brightness + ", safetyswitch=" + this.safetyswitch + ", filterusage=" + this.filterusage + ", disinfection=" + this.disinfection + ", disinftime=" + this.disinftime + ", wickdrye=" + this.wickdrye + ", wickdrys=" + this.wickdrys + ", wickdryl=" + this.wickdryl + ", wickdryts=" + this.wickdryts + ", wickusage=" + this.wickusage + ", wshortage=" + this.wshortage + ", autorh=" + this.autorh + ", timstate=" + this.timstate + ", timdur=" + this.timdur + ", timl=" + this.timl + ", timts=" + this.timts + ", tu=" + this.tu + ", oscstate=" + this.oscstate + ", osc=" + this.osc + ", oscdir=" + this.oscdir + ", oscfs=" + this.oscfs + ", mainmode=" + this.mainmode + ", apsubmode=" + this.apsubmode + ", fsp0=" + this.fsp0 + ", heatsubmode=" + this.heatsubmode + ", heatfs=" + this.heatfs + ", heattemp=" + this.heattemp + ", ecoheattemp=" + this.ecoheattemp + ", coolsubmode=" + this.coolsubmode + ", coolfs=" + this.coolfs + ", coolautotag=" + this.coolautotag + ", coolautofs1=" + this.coolautofs1 + ", coolautofs2=" + this.coolautofs2 + ", coolautofs3=" + this.coolautofs3 + ", coolecotag=" + this.coolecotag + ", coolecofs1=" + this.coolecofs1 + ", coolecofs2=" + this.coolecofs2 + ", mode=" + this.mode + ", hummode=" + this.hummode + ", wlevel=" + this.wlevel + ", dehsubmode=" + this.dehsubmode + ", watertankfailure=" + this.watertankfailure + ", smartsubmode=" + this.smartsubmode + ", detectcat=" + this.detectcat + ", bodymounted=" + this.bodymounted + ", aireta=" + this.aireta + ", displaymode=" + this.displaymode + ", hover=" + this.hover + ", airrefresh=" + this.airrefresh + ", arstate=" + this.arstate + ", ardur=" + this.ardur + ", arts=" + this.arts + ", startts=" + this.startts + ", endts=" + this.endts + ", roomtype=" + this.roomtype + ", nlbrightness=" + this.nlbrightness + ", wickdrydur=" + this.wickdrydur + ", wickdrydone=" + this.wickdrydone + ", ywrme=" + this.ywrme + ", ywrmusage=" + this.ywrmusage + ", nlstepless=" + this.nlstepless + ", alarm1=" + this.alarm1 + ", alarm2=" + this.alarm2 + ", alarm3=" + this.alarm3 + ", alarm4=" + this.alarm4 + ", alarm5=" + this.alarm5 + ", alarm6=" + this.alarm6 + ", humsubmode=" + this.humsubmode + ", hourformat=" + this.hourformat + ", wtankfail=" + this.wtankfail + ", waterinfill=" + this.waterinfill + ", sensormode=" + this.sensormode + ')';
    }

    public DeviceState(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num, Boolean bool7, Boolean bool8, String str2, Boolean bool9, String str3, Integer num2, Boolean bool10, Integer num3, Boolean bool11, Integer num4, Boolean bool12, Boolean bool13, Integer num5, Integer num6, Integer num7, Boolean bool14, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, Integer num28, Integer num29, Integer num30, Integer num31, Integer num32, Integer num33, Integer num34, Boolean bool15, Integer num35, Integer num36, Boolean bool16, Integer num37, Boolean bool17, Boolean bool18, Integer num38, Integer num39, Boolean bool19, Boolean bool20, Integer num40, Integer num41, Integer num42, Integer num43, Integer num44, Integer num45, Integer num46, Integer num47, Boolean bool21, Boolean bool22, Integer num48, Integer num49, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Integer num50, Boolean bool23, Boolean bool24, Boolean bool25, Integer num51) {
        this.cfv = str;
        this.germshield = bool;
        this.gsnm = bool2;
        this.standby = bool3;
        this.eco = bool4;
        this.hins = bool5;
        this.nmhins = bool6;
        this.fanspeed = num;
        this.childlock = bool7;
        this.nightmode = bool8;
        this.mfv = str2;
        this.automode = bool9;
        this.ofv = str3;
        this.brightness = num2;
        this.safetyswitch = bool10;
        this.filterusage = num3;
        this.disinfection = bool11;
        this.disinftime = num4;
        this.wickdrye = bool12;
        this.wickdrys = bool13;
        this.wickdryl = num5;
        this.wickdryts = num6;
        this.wickusage = num7;
        this.wshortage = bool14;
        this.autorh = num8;
        this.timstate = num9;
        this.timdur = num10;
        this.timl = num11;
        this.timts = num12;
        this.tu = num13;
        this.oscstate = num14;
        this.osc = num15;
        this.oscdir = num16;
        this.oscfs = num17;
        this.mainmode = num18;
        this.apsubmode = num19;
        this.fsp0 = num20;
        this.heatsubmode = num21;
        this.heatfs = num22;
        this.heattemp = num23;
        this.ecoheattemp = num24;
        this.coolsubmode = num25;
        this.coolfs = num26;
        this.coolautotag = num27;
        this.coolautofs1 = num28;
        this.coolautofs2 = num29;
        this.coolautofs3 = num30;
        this.coolecotag = num31;
        this.coolecofs1 = num32;
        this.coolecofs2 = num33;
        this.mode = num34;
        this.hummode = bool15;
        this.wlevel = num35;
        this.dehsubmode = num36;
        this.watertankfailure = bool16;
        this.smartsubmode = num37;
        this.detectcat = bool17;
        this.bodymounted = bool18;
        this.aireta = num38;
        this.displaymode = num39;
        this.hover = bool19;
        this.airrefresh = bool20;
        this.arstate = num40;
        this.ardur = num41;
        this.arts = num42;
        this.startts = num43;
        this.endts = num44;
        this.roomtype = num45;
        this.nlbrightness = num46;
        this.wickdrydur = num47;
        this.wickdrydone = bool21;
        this.ywrme = bool22;
        this.ywrmusage = num48;
        this.nlstepless = num49;
        this.alarm1 = obj;
        this.alarm2 = obj2;
        this.alarm3 = obj3;
        this.alarm4 = obj4;
        this.alarm5 = obj5;
        this.alarm6 = obj6;
        this.humsubmode = num50;
        this.hourformat = bool23;
        this.wtankfail = bool24;
        this.waterinfill = bool25;
        this.sensormode = num51;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceState(java.lang.String r69, java.lang.Boolean r70, java.lang.Boolean r71, java.lang.Boolean r72, java.lang.Boolean r73, java.lang.Boolean r74, java.lang.Boolean r75, java.lang.Integer r76, java.lang.Boolean r77, java.lang.Boolean r78, java.lang.String r79, java.lang.Boolean r80, java.lang.String r81, java.lang.Integer r82, java.lang.Boolean r83, java.lang.Integer r84, java.lang.Boolean r85, java.lang.Integer r86, java.lang.Boolean r87, java.lang.Boolean r88, java.lang.Integer r89, java.lang.Integer r90, java.lang.Integer r91, java.lang.Boolean r92, java.lang.Integer r93, java.lang.Integer r94, java.lang.Integer r95, java.lang.Integer r96, java.lang.Integer r97, java.lang.Integer r98, java.lang.Integer r99, java.lang.Integer r100, java.lang.Integer r101, java.lang.Integer r102, java.lang.Integer r103, java.lang.Integer r104, java.lang.Integer r105, java.lang.Integer r106, java.lang.Integer r107, java.lang.Integer r108, java.lang.Integer r109, java.lang.Integer r110, java.lang.Integer r111, java.lang.Integer r112, java.lang.Integer r113, java.lang.Integer r114, java.lang.Integer r115, java.lang.Integer r116, java.lang.Integer r117, java.lang.Integer r118, java.lang.Integer r119, java.lang.Boolean r120, java.lang.Integer r121, java.lang.Integer r122, java.lang.Boolean r123, java.lang.Integer r124, java.lang.Boolean r125, java.lang.Boolean r126, java.lang.Integer r127, java.lang.Integer r128, java.lang.Boolean r129, java.lang.Boolean r130, java.lang.Integer r131, java.lang.Integer r132, java.lang.Integer r133, java.lang.Integer r134, java.lang.Integer r135, java.lang.Integer r136, java.lang.Integer r137, java.lang.Integer r138, java.lang.Boolean r139, java.lang.Boolean r140, java.lang.Integer r141, java.lang.Integer r142, java.lang.Object r143, java.lang.Object r144, java.lang.Object r145, java.lang.Object r146, java.lang.Object r147, java.lang.Object r148, java.lang.Integer r149, java.lang.Boolean r150, java.lang.Boolean r151, java.lang.Boolean r152, java.lang.Integer r153, int r154, int r155, int r156, kotlin.jvm.internal.DefaultConstructorMarker r157) {
        /*
            r68 = this;
            r0 = r154
            r1 = r155
            r2 = r156
            r3 = r0 & 1
            if (r3 == 0) goto L_0x000c
            r3 = 0
            goto L_0x000e
        L_0x000c:
            r3 = r69
        L_0x000e:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x0014
            r5 = 0
            goto L_0x0016
        L_0x0014:
            r5 = r70
        L_0x0016:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001c
            r6 = 0
            goto L_0x001e
        L_0x001c:
            r6 = r71
        L_0x001e:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0024
            r7 = 0
            goto L_0x0026
        L_0x0024:
            r7 = r72
        L_0x0026:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002c
            r8 = 0
            goto L_0x002e
        L_0x002c:
            r8 = r73
        L_0x002e:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0034
            r9 = 0
            goto L_0x0036
        L_0x0034:
            r9 = r74
        L_0x0036:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003c
            r10 = 0
            goto L_0x003e
        L_0x003c:
            r10 = r75
        L_0x003e:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0044
            r11 = 0
            goto L_0x0046
        L_0x0044:
            r11 = r76
        L_0x0046:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004c
            r12 = 0
            goto L_0x004e
        L_0x004c:
            r12 = r77
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0054
            r13 = 0
            goto L_0x0056
        L_0x0054:
            r13 = r78
        L_0x0056:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005c
            r14 = 0
            goto L_0x005e
        L_0x005c:
            r14 = r79
        L_0x005e:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0064
            r15 = 0
            goto L_0x0066
        L_0x0064:
            r15 = r80
        L_0x0066:
            r4 = r0 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x006c
            r4 = 0
            goto L_0x006e
        L_0x006c:
            r4 = r81
        L_0x006e:
            r69 = r3
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0076
            r3 = 0
            goto L_0x0078
        L_0x0076:
            r3 = r82
        L_0x0078:
            r70 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x0080
            r3 = 0
            goto L_0x0082
        L_0x0080:
            r3 = r83
        L_0x0082:
            r16 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r16
            if (r17 == 0) goto L_0x008c
            r17 = 0
            goto L_0x008e
        L_0x008c:
            r17 = r84
        L_0x008e:
            r18 = 65536(0x10000, float:9.18355E-41)
            r19 = r0 & r18
            if (r19 == 0) goto L_0x0097
            r19 = 0
            goto L_0x0099
        L_0x0097:
            r19 = r85
        L_0x0099:
            r20 = 131072(0x20000, float:1.83671E-40)
            r21 = r0 & r20
            if (r21 == 0) goto L_0x00a2
            r21 = 0
            goto L_0x00a4
        L_0x00a2:
            r21 = r86
        L_0x00a4:
            r22 = 262144(0x40000, float:3.67342E-40)
            r23 = r0 & r22
            if (r23 == 0) goto L_0x00ad
            r23 = 0
            goto L_0x00af
        L_0x00ad:
            r23 = r87
        L_0x00af:
            r24 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r24
            if (r25 == 0) goto L_0x00b8
            r25 = 0
            goto L_0x00ba
        L_0x00b8:
            r25 = r88
        L_0x00ba:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r27 = r0 & r26
            if (r27 == 0) goto L_0x00c3
            r27 = 0
            goto L_0x00c5
        L_0x00c3:
            r27 = r89
        L_0x00c5:
            r28 = 2097152(0x200000, float:2.938736E-39)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00ce
            r28 = 0
            goto L_0x00d0
        L_0x00ce:
            r28 = r90
        L_0x00d0:
            r29 = 4194304(0x400000, float:5.877472E-39)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00d9
            r29 = 0
            goto L_0x00db
        L_0x00d9:
            r29 = r91
        L_0x00db:
            r30 = 8388608(0x800000, float:1.17549435E-38)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x00e4
            r30 = 0
            goto L_0x00e6
        L_0x00e4:
            r30 = r92
        L_0x00e6:
            r31 = 16777216(0x1000000, float:2.3509887E-38)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00ef
            r31 = 0
            goto L_0x00f1
        L_0x00ef:
            r31 = r93
        L_0x00f1:
            r32 = 33554432(0x2000000, float:9.403955E-38)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x00fa
            r32 = 0
            goto L_0x00fc
        L_0x00fa:
            r32 = r94
        L_0x00fc:
            r33 = 67108864(0x4000000, float:1.5046328E-36)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x0105
            r33 = 0
            goto L_0x0107
        L_0x0105:
            r33 = r95
        L_0x0107:
            r34 = 134217728(0x8000000, float:3.85186E-34)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x0110
            r34 = 0
            goto L_0x0112
        L_0x0110:
            r34 = r96
        L_0x0112:
            r35 = 268435456(0x10000000, float:2.5243549E-29)
            r35 = r0 & r35
            if (r35 == 0) goto L_0x011b
            r35 = 0
            goto L_0x011d
        L_0x011b:
            r35 = r97
        L_0x011d:
            r36 = 536870912(0x20000000, float:1.0842022E-19)
            r36 = r0 & r36
            if (r36 == 0) goto L_0x0126
            r36 = 0
            goto L_0x0128
        L_0x0126:
            r36 = r98
        L_0x0128:
            r37 = 1073741824(0x40000000, float:2.0)
            r37 = r0 & r37
            if (r37 == 0) goto L_0x0131
            r37 = 0
            goto L_0x0133
        L_0x0131:
            r37 = r99
        L_0x0133:
            r38 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r38
            if (r0 == 0) goto L_0x013b
            r0 = 0
            goto L_0x013d
        L_0x013b:
            r0 = r100
        L_0x013d:
            r38 = r1 & 1
            if (r38 == 0) goto L_0x0144
            r38 = 0
            goto L_0x0146
        L_0x0144:
            r38 = r101
        L_0x0146:
            r39 = r1 & 2
            if (r39 == 0) goto L_0x014d
            r39 = 0
            goto L_0x014f
        L_0x014d:
            r39 = r102
        L_0x014f:
            r40 = r1 & 4
            if (r40 == 0) goto L_0x0156
            r40 = 0
            goto L_0x0158
        L_0x0156:
            r40 = r103
        L_0x0158:
            r41 = r1 & 8
            if (r41 == 0) goto L_0x015f
            r41 = 0
            goto L_0x0161
        L_0x015f:
            r41 = r104
        L_0x0161:
            r42 = r1 & 16
            if (r42 == 0) goto L_0x0168
            r42 = 0
            goto L_0x016a
        L_0x0168:
            r42 = r105
        L_0x016a:
            r43 = r1 & 32
            if (r43 == 0) goto L_0x0171
            r43 = 0
            goto L_0x0173
        L_0x0171:
            r43 = r106
        L_0x0173:
            r44 = r1 & 64
            if (r44 == 0) goto L_0x017a
            r44 = 0
            goto L_0x017c
        L_0x017a:
            r44 = r107
        L_0x017c:
            r71 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0184
            r0 = 0
            goto L_0x0186
        L_0x0184:
            r0 = r108
        L_0x0186:
            r72 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018e
            r0 = 0
            goto L_0x0190
        L_0x018e:
            r0 = r109
        L_0x0190:
            r73 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0198
            r0 = 0
            goto L_0x019a
        L_0x0198:
            r0 = r110
        L_0x019a:
            r74 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01a2
            r0 = 0
            goto L_0x01a4
        L_0x01a2:
            r0 = r111
        L_0x01a4:
            r75 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01ac
            r0 = 0
            goto L_0x01ae
        L_0x01ac:
            r0 = r112
        L_0x01ae:
            r76 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01b6
            r0 = 0
            goto L_0x01b8
        L_0x01b6:
            r0 = r113
        L_0x01b8:
            r77 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c0
            r0 = 0
            goto L_0x01c2
        L_0x01c0:
            r0 = r114
        L_0x01c2:
            r78 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01ca
            r0 = 0
            goto L_0x01cc
        L_0x01ca:
            r0 = r115
        L_0x01cc:
            r45 = r1 & r16
            if (r45 == 0) goto L_0x01d3
            r45 = 0
            goto L_0x01d5
        L_0x01d3:
            r45 = r116
        L_0x01d5:
            r46 = r1 & r18
            if (r46 == 0) goto L_0x01dc
            r46 = 0
            goto L_0x01de
        L_0x01dc:
            r46 = r117
        L_0x01de:
            r47 = r1 & r20
            if (r47 == 0) goto L_0x01e5
            r47 = 0
            goto L_0x01e7
        L_0x01e5:
            r47 = r118
        L_0x01e7:
            r48 = r1 & r22
            if (r48 == 0) goto L_0x01ee
            r48 = 0
            goto L_0x01f0
        L_0x01ee:
            r48 = r119
        L_0x01f0:
            r49 = r1 & r24
            if (r49 == 0) goto L_0x01f7
            r49 = 0
            goto L_0x01f9
        L_0x01f7:
            r49 = r120
        L_0x01f9:
            r50 = r1 & r26
            if (r50 == 0) goto L_0x0200
            r50 = 0
            goto L_0x0202
        L_0x0200:
            r50 = r121
        L_0x0202:
            r51 = 2097152(0x200000, float:2.938736E-39)
            r51 = r1 & r51
            if (r51 == 0) goto L_0x020b
            r51 = 0
            goto L_0x020d
        L_0x020b:
            r51 = r122
        L_0x020d:
            r52 = 4194304(0x400000, float:5.877472E-39)
            r52 = r1 & r52
            if (r52 == 0) goto L_0x0216
            r52 = 0
            goto L_0x0218
        L_0x0216:
            r52 = r123
        L_0x0218:
            r53 = 8388608(0x800000, float:1.17549435E-38)
            r53 = r1 & r53
            if (r53 == 0) goto L_0x0221
            r53 = 0
            goto L_0x0223
        L_0x0221:
            r53 = r124
        L_0x0223:
            r54 = 16777216(0x1000000, float:2.3509887E-38)
            r54 = r1 & r54
            if (r54 == 0) goto L_0x022c
            r54 = 0
            goto L_0x022e
        L_0x022c:
            r54 = r125
        L_0x022e:
            r55 = 33554432(0x2000000, float:9.403955E-38)
            r55 = r1 & r55
            if (r55 == 0) goto L_0x0237
            r55 = 0
            goto L_0x0239
        L_0x0237:
            r55 = r126
        L_0x0239:
            r56 = 67108864(0x4000000, float:1.5046328E-36)
            r56 = r1 & r56
            if (r56 == 0) goto L_0x0242
            r56 = 0
            goto L_0x0244
        L_0x0242:
            r56 = r127
        L_0x0244:
            r57 = 134217728(0x8000000, float:3.85186E-34)
            r57 = r1 & r57
            if (r57 == 0) goto L_0x024d
            r57 = 0
            goto L_0x024f
        L_0x024d:
            r57 = r128
        L_0x024f:
            r58 = 268435456(0x10000000, float:2.5243549E-29)
            r58 = r1 & r58
            if (r58 == 0) goto L_0x0258
            r58 = 0
            goto L_0x025a
        L_0x0258:
            r58 = r129
        L_0x025a:
            r59 = 536870912(0x20000000, float:1.0842022E-19)
            r59 = r1 & r59
            if (r59 == 0) goto L_0x0263
            r59 = 0
            goto L_0x0265
        L_0x0263:
            r59 = r130
        L_0x0265:
            r60 = 1073741824(0x40000000, float:2.0)
            r60 = r1 & r60
            if (r60 == 0) goto L_0x026e
            r60 = 0
            goto L_0x0270
        L_0x026e:
            r60 = r131
        L_0x0270:
            r61 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r61
            if (r1 == 0) goto L_0x0278
            r1 = 0
            goto L_0x027a
        L_0x0278:
            r1 = r132
        L_0x027a:
            r61 = r2 & 1
            if (r61 == 0) goto L_0x0281
            r61 = 0
            goto L_0x0283
        L_0x0281:
            r61 = r133
        L_0x0283:
            r62 = r2 & 2
            if (r62 == 0) goto L_0x028a
            r62 = 0
            goto L_0x028c
        L_0x028a:
            r62 = r134
        L_0x028c:
            r63 = r2 & 4
            if (r63 == 0) goto L_0x0293
            r63 = 0
            goto L_0x0295
        L_0x0293:
            r63 = r135
        L_0x0295:
            r64 = r2 & 8
            if (r64 == 0) goto L_0x029c
            r64 = 0
            goto L_0x029e
        L_0x029c:
            r64 = r136
        L_0x029e:
            r65 = r2 & 16
            if (r65 == 0) goto L_0x02a5
            r65 = 0
            goto L_0x02a7
        L_0x02a5:
            r65 = r137
        L_0x02a7:
            r66 = r2 & 32
            if (r66 == 0) goto L_0x02ae
            r66 = 0
            goto L_0x02b0
        L_0x02ae:
            r66 = r138
        L_0x02b0:
            r67 = r2 & 64
            if (r67 == 0) goto L_0x02b7
            r67 = 0
            goto L_0x02b9
        L_0x02b7:
            r67 = r139
        L_0x02b9:
            r79 = r0
            r0 = r2 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x02c1
            r0 = 0
            goto L_0x02c3
        L_0x02c1:
            r0 = r140
        L_0x02c3:
            r80 = r0
            r0 = r2 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x02cb
            r0 = 0
            goto L_0x02cd
        L_0x02cb:
            r0 = r141
        L_0x02cd:
            r81 = r0
            r0 = r2 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x02d5
            r0 = 0
            goto L_0x02d7
        L_0x02d5:
            r0 = r142
        L_0x02d7:
            r82 = r0
            r0 = r2 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x02df
            r0 = 0
            goto L_0x02e1
        L_0x02df:
            r0 = r143
        L_0x02e1:
            r83 = r0
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02e9
            r0 = 0
            goto L_0x02eb
        L_0x02e9:
            r0 = r144
        L_0x02eb:
            r84 = r0
            r0 = r2 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x02f3
            r0 = 0
            goto L_0x02f5
        L_0x02f3:
            r0 = r145
        L_0x02f5:
            r85 = r0
            r0 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x02fd
            r0 = 0
            goto L_0x02ff
        L_0x02fd:
            r0 = r146
        L_0x02ff:
            r86 = r0
            r0 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0307
            r0 = 0
            goto L_0x0309
        L_0x0307:
            r0 = r147
        L_0x0309:
            r16 = r2 & r16
            if (r16 == 0) goto L_0x0310
            r16 = 0
            goto L_0x0312
        L_0x0310:
            r16 = r148
        L_0x0312:
            r18 = r2 & r18
            if (r18 == 0) goto L_0x0319
            r18 = 0
            goto L_0x031b
        L_0x0319:
            r18 = r149
        L_0x031b:
            r20 = r2 & r20
            if (r20 == 0) goto L_0x0322
            r20 = 0
            goto L_0x0324
        L_0x0322:
            r20 = r150
        L_0x0324:
            r22 = r2 & r22
            if (r22 == 0) goto L_0x032b
            r22 = 0
            goto L_0x032d
        L_0x032b:
            r22 = r151
        L_0x032d:
            r24 = r2 & r24
            if (r24 == 0) goto L_0x0334
            r24 = 0
            goto L_0x0336
        L_0x0334:
            r24 = r152
        L_0x0336:
            r2 = r2 & r26
            if (r2 == 0) goto L_0x033d
            r154 = 0
            goto L_0x033f
        L_0x033d:
            r154 = r153
        L_0x033f:
            r101 = r71
            r109 = r72
            r110 = r73
            r111 = r74
            r112 = r75
            r113 = r76
            r114 = r77
            r115 = r78
            r116 = r79
            r141 = r80
            r142 = r81
            r143 = r82
            r144 = r83
            r145 = r84
            r146 = r85
            r147 = r86
            r148 = r0
            r133 = r1
            r84 = r3
            r82 = r4
            r71 = r5
            r72 = r6
            r73 = r7
            r74 = r8
            r75 = r9
            r76 = r10
            r77 = r11
            r78 = r12
            r79 = r13
            r80 = r14
            r81 = r15
            r149 = r16
            r85 = r17
            r150 = r18
            r86 = r19
            r151 = r20
            r87 = r21
            r152 = r22
            r88 = r23
            r153 = r24
            r89 = r25
            r90 = r27
            r91 = r28
            r92 = r29
            r93 = r30
            r94 = r31
            r95 = r32
            r96 = r33
            r97 = r34
            r98 = r35
            r99 = r36
            r100 = r37
            r102 = r38
            r103 = r39
            r104 = r40
            r105 = r41
            r106 = r42
            r107 = r43
            r108 = r44
            r117 = r45
            r118 = r46
            r119 = r47
            r120 = r48
            r121 = r49
            r122 = r50
            r123 = r51
            r124 = r52
            r125 = r53
            r126 = r54
            r127 = r55
            r128 = r56
            r129 = r57
            r130 = r58
            r131 = r59
            r132 = r60
            r134 = r61
            r135 = r62
            r136 = r63
            r137 = r64
            r138 = r65
            r139 = r66
            r140 = r67
            r83 = r70
            r70 = r69
            r69 = r68
            r69.<init>(r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceState.<init>(java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCfv() {
        return this.cfv;
    }

    public final Boolean getGermshield() {
        return this.germshield;
    }

    public final Boolean getGsnm() {
        return this.gsnm;
    }

    public final Boolean getStandby() {
        return this.standby;
    }

    public final Boolean getEco() {
        return this.eco;
    }

    public final Boolean getHins() {
        return this.hins;
    }

    public final Boolean getNmhins() {
        return this.nmhins;
    }

    public final Integer getFanspeed() {
        return this.fanspeed;
    }

    public final Boolean getChildlock() {
        return this.childlock;
    }

    public final Boolean getNightmode() {
        return this.nightmode;
    }

    public final String getMfv() {
        return this.mfv;
    }

    public final Boolean getAutomode() {
        return this.automode;
    }

    public final String getOfv() {
        return this.ofv;
    }

    public final Integer getBrightness() {
        return this.brightness;
    }

    public final Boolean getSafetyswitch() {
        return this.safetyswitch;
    }

    public final Integer getFilterusage() {
        return this.filterusage;
    }

    public final Boolean getDisinfection() {
        return this.disinfection;
    }

    public final Integer getDisinftime() {
        return this.disinftime;
    }

    public final Boolean getWickdrye() {
        return this.wickdrye;
    }

    public final Boolean getWickdrys() {
        return this.wickdrys;
    }

    public final Integer getWickdryl() {
        return this.wickdryl;
    }

    public final Integer getWickdryts() {
        return this.wickdryts;
    }

    public final Integer getWickusage() {
        return this.wickusage;
    }

    public final Boolean getWshortage() {
        return this.wshortage;
    }

    public final Integer getAutorh() {
        return this.autorh;
    }

    public final Integer getTimstate() {
        return this.timstate;
    }

    public final Integer getTimdur() {
        return this.timdur;
    }

    public final Integer getTiml() {
        return this.timl;
    }

    public final Integer getTimts() {
        return this.timts;
    }

    public final Integer getTu() {
        return this.tu;
    }

    public final Integer getOscstate() {
        return this.oscstate;
    }

    public final Integer getOsc() {
        return this.osc;
    }

    public final Integer getOscdir() {
        return this.oscdir;
    }

    public final Integer getOscfs() {
        return this.oscfs;
    }

    public final Integer getMainmode() {
        return this.mainmode;
    }

    public final Integer getApsubmode() {
        return this.apsubmode;
    }

    public final Integer getFsp0() {
        return this.fsp0;
    }

    public final Integer getHeatsubmode() {
        return this.heatsubmode;
    }

    public final Integer getHeatfs() {
        return this.heatfs;
    }

    public final Integer getHeattemp() {
        return this.heattemp;
    }

    public final Integer getEcoheattemp() {
        return this.ecoheattemp;
    }

    public final Integer getCoolsubmode() {
        return this.coolsubmode;
    }

    public final Integer getCoolfs() {
        return this.coolfs;
    }

    public final Integer getCoolautotag() {
        return this.coolautotag;
    }

    public final Integer getCoolautofs1() {
        return this.coolautofs1;
    }

    public final Integer getCoolautofs2() {
        return this.coolautofs2;
    }

    public final Integer getCoolautofs3() {
        return this.coolautofs3;
    }

    public final Integer getCoolecotag() {
        return this.coolecotag;
    }

    public final Integer getCoolecofs1() {
        return this.coolecofs1;
    }

    public final Integer getCoolecofs2() {
        return this.coolecofs2;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final Boolean getHummode() {
        return this.hummode;
    }

    public final Integer getWlevel() {
        return this.wlevel;
    }

    public final Integer getDehsubmode() {
        return this.dehsubmode;
    }

    public final Boolean getWatertankfailure() {
        return this.watertankfailure;
    }

    public final Integer getSmartsubmode() {
        return this.smartsubmode;
    }

    public final Boolean getDetectcat() {
        return this.detectcat;
    }

    public final Boolean getBodymounted() {
        return this.bodymounted;
    }

    public final Integer getAireta() {
        return this.aireta;
    }

    public final Integer getDisplaymode() {
        return this.displaymode;
    }

    public final Boolean getHover() {
        return this.hover;
    }

    public final Boolean getAirrefresh() {
        return this.airrefresh;
    }

    public final Integer getArstate() {
        return this.arstate;
    }

    public final Integer getArdur() {
        return this.ardur;
    }

    public final Integer getArts() {
        return this.arts;
    }

    public final Integer getStartts() {
        return this.startts;
    }

    public final Integer getEndts() {
        return this.endts;
    }

    public final Integer getRoomtype() {
        return this.roomtype;
    }

    public final Integer getNlbrightness() {
        return this.nlbrightness;
    }

    public final Integer getWickdrydur() {
        return this.wickdrydur;
    }

    public final Boolean getWickdrydone() {
        return this.wickdrydone;
    }

    public final Boolean getYwrme() {
        return this.ywrme;
    }

    public final Integer getYwrmusage() {
        return this.ywrmusage;
    }

    public final Integer getNlstepless() {
        return this.nlstepless;
    }

    public final Object getAlarm1() {
        return this.alarm1;
    }

    public final Object getAlarm2() {
        return this.alarm2;
    }

    public final Object getAlarm3() {
        return this.alarm3;
    }

    public final Object getAlarm4() {
        return this.alarm4;
    }

    public final Object getAlarm5() {
        return this.alarm5;
    }

    public final Object getAlarm6() {
        return this.alarm6;
    }

    public final Integer getHumsubmode() {
        return this.humsubmode;
    }

    public final Boolean getHourformat() {
        return this.hourformat;
    }

    public final Boolean getWtankfail() {
        return this.wtankfail;
    }

    public final Boolean getWaterinfill() {
        return this.waterinfill;
    }

    public final Integer getSensormode() {
        return this.sensormode;
    }
}
