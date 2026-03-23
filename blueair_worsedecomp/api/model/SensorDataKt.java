package com.blueair.api.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"toIndoorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "", "Lcom/blueair/api/model/SensorData;", "api_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: SensorData.kt */
public final class SensorDataKt {
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        r1 = r2.getTimeDelta();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.blueair.core.model.IndoorDatapoint toIndoorDatapoint(java.util.List<com.blueair.api.model.SensorData> r19) {
        /*
            r0 = r19
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r1 = r0.iterator()
        L_0x000d:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()
            r4 = r2
            com.blueair.api.model.SensorData r4 = (com.blueair.api.model.SensorData) r4
            java.lang.Long r4 = r4.getTimeDelta()
            if (r4 == 0) goto L_0x000d
            goto L_0x0023
        L_0x0022:
            r2 = r3
        L_0x0023:
            com.blueair.api.model.SensorData r2 = (com.blueair.api.model.SensorData) r2
            if (r2 == 0) goto L_0x0032
            java.lang.Long r1 = r2.getTimeDelta()
            if (r1 == 0) goto L_0x0032
            long r1 = r1.longValue()
            goto L_0x0034
        L_0x0032:
            r1 = 0
        L_0x0034:
            java.util.Iterator r4 = r0.iterator()
        L_0x0038:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004c
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.blueair.api.model.SensorData r6 = (com.blueair.api.model.SensorData) r6
            java.lang.Long r6 = r6.getBaseTime()
            if (r6 == 0) goto L_0x0038
            goto L_0x004d
        L_0x004c:
            r5 = r3
        L_0x004d:
            com.blueair.api.model.SensorData r5 = (com.blueair.api.model.SensorData) r5
            if (r5 == 0) goto L_0x005c
            java.lang.Long r4 = r5.getBaseTime()
            if (r4 == 0) goto L_0x005c
            long r4 = r4.longValue()
            goto L_0x0063
        L_0x005c:
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
        L_0x0063:
            long r7 = r4 - r1
            java.util.Iterator r1 = r0.iterator()
        L_0x0069:
            boolean r2 = r1.hasNext()
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0089
            java.lang.Object r2 = r1.next()
            r6 = r2
            com.blueair.api.model.SensorData r6 = (com.blueair.api.model.SensorData) r6
            java.lang.String r6 = r6.getName()
            com.blueair.api.utils.BlueCloudSensor$PM1 r9 = com.blueair.api.utils.BlueCloudSensor.PM1.INSTANCE
            java.lang.String r9 = r9.getName()
            boolean r6 = kotlin.text.StringsKt.endsWith$default(r6, r9, r5, r4, r3)
            if (r6 == 0) goto L_0x0069
            goto L_0x008a
        L_0x0089:
            r2 = r3
        L_0x008a:
            com.blueair.api.model.SensorData r2 = (com.blueair.api.model.SensorData) r2
            if (r2 == 0) goto L_0x0093
            java.lang.Object r1 = r2.getValue()
            goto L_0x0094
        L_0x0093:
            r1 = r3
        L_0x0094:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Double r1 = kotlin.text.StringsKt.toDoubleOrNull(r1)
            java.util.Iterator r2 = r0.iterator()
        L_0x00a0:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00be
            java.lang.Object r6 = r2.next()
            r9 = r6
            com.blueair.api.model.SensorData r9 = (com.blueair.api.model.SensorData) r9
            java.lang.String r9 = r9.getName()
            com.blueair.api.utils.BlueCloudSensor$PM10 r10 = com.blueair.api.utils.BlueCloudSensor.PM10.INSTANCE
            java.lang.String r10 = r10.getName()
            boolean r9 = kotlin.text.StringsKt.endsWith$default(r9, r10, r5, r4, r3)
            if (r9 == 0) goto L_0x00a0
            goto L_0x00bf
        L_0x00be:
            r6 = r3
        L_0x00bf:
            com.blueair.api.model.SensorData r6 = (com.blueair.api.model.SensorData) r6
            if (r6 == 0) goto L_0x00c8
            java.lang.Object r2 = r6.getValue()
            goto L_0x00c9
        L_0x00c8:
            r2 = r3
        L_0x00c9:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Double r2 = kotlin.text.StringsKt.toDoubleOrNull(r2)
            java.util.Iterator r6 = r0.iterator()
        L_0x00d5:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r6.next()
            r10 = r9
            com.blueair.api.model.SensorData r10 = (com.blueair.api.model.SensorData) r10
            java.lang.String r11 = r10.getName()
            com.blueair.api.utils.BlueCloudSensor$PM25 r12 = com.blueair.api.utils.BlueCloudSensor.PM25.INSTANCE
            java.lang.String r12 = r12.getName()
            boolean r11 = kotlin.text.StringsKt.endsWith$default(r11, r12, r5, r4, r3)
            if (r11 != 0) goto L_0x0100
            java.lang.String r10 = r10.getName()
            java.lang.String r11 = "pm2.5"
            boolean r10 = kotlin.text.StringsKt.endsWith$default(r10, r11, r5, r4, r3)
            if (r10 == 0) goto L_0x00d5
            goto L_0x0100
        L_0x00ff:
            r9 = r3
        L_0x0100:
            com.blueair.api.model.SensorData r9 = (com.blueair.api.model.SensorData) r9
            if (r9 == 0) goto L_0x0109
            java.lang.Object r6 = r9.getValue()
            goto L_0x010a
        L_0x0109:
            r6 = r3
        L_0x010a:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Double r6 = kotlin.text.StringsKt.toDoubleOrNull(r6)
            java.util.Iterator r9 = r0.iterator()
        L_0x0116:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x015c
            java.lang.Object r10 = r9.next()
            r11 = r10
            com.blueair.api.model.SensorData r11 = (com.blueair.api.model.SensorData) r11
            java.lang.String r12 = r11.getName()
            java.util.Locale r13 = java.util.Locale.ENGLISH
            java.lang.String r14 = "ENGLISH"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.String r12 = r12.toLowerCase(r13)
            java.lang.String r13 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            com.blueair.api.utils.BlueCloudSensor$VOC r15 = com.blueair.api.utils.BlueCloudSensor.VOC.INSTANCE
            java.lang.String r15 = r15.getName()
            boolean r12 = kotlin.text.StringsKt.endsWith$default(r12, r15, r5, r4, r3)
            if (r12 != 0) goto L_0x015d
            java.lang.String r11 = r11.getName()
            java.util.Locale r12 = java.util.Locale.ENGLISH
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r14)
            java.lang.String r11 = r11.toLowerCase(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.lang.String r12 = "voc"
            boolean r11 = kotlin.text.StringsKt.endsWith$default(r11, r12, r5, r4, r3)
            if (r11 == 0) goto L_0x0116
            goto L_0x015d
        L_0x015c:
            r10 = r3
        L_0x015d:
            com.blueair.api.model.SensorData r10 = (com.blueair.api.model.SensorData) r10
            if (r10 == 0) goto L_0x0166
            java.lang.Object r9 = r10.getValue()
            goto L_0x0167
        L_0x0166:
            r9 = r3
        L_0x0167:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.Double r9 = kotlin.text.StringsKt.toDoubleOrNull(r9)
            java.util.Iterator r10 = r0.iterator()
        L_0x0173:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0191
            java.lang.Object r11 = r10.next()
            r12 = r11
            com.blueair.api.model.SensorData r12 = (com.blueair.api.model.SensorData) r12
            java.lang.String r12 = r12.getName()
            com.blueair.api.utils.BlueCloudSensor$HCHO r13 = com.blueair.api.utils.BlueCloudSensor.HCHO.INSTANCE
            java.lang.String r13 = r13.getName()
            boolean r12 = kotlin.text.StringsKt.endsWith$default(r12, r13, r5, r4, r3)
            if (r12 == 0) goto L_0x0173
            goto L_0x0192
        L_0x0191:
            r11 = r3
        L_0x0192:
            com.blueair.api.model.SensorData r11 = (com.blueair.api.model.SensorData) r11
            if (r11 == 0) goto L_0x019b
            java.lang.Object r10 = r11.getValue()
            goto L_0x019c
        L_0x019b:
            r10 = r3
        L_0x019c:
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.Double r10 = kotlin.text.StringsKt.toDoubleOrNull(r10)
            java.util.Iterator r11 = r0.iterator()
        L_0x01a8:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01d2
            java.lang.Object r12 = r11.next()
            r13 = r12
            com.blueair.api.model.SensorData r13 = (com.blueair.api.model.SensorData) r13
            java.lang.String r14 = r13.getName()
            com.blueair.api.utils.BlueCloudSensor$Temperature r15 = com.blueair.api.utils.BlueCloudSensor.Temperature.INSTANCE
            java.lang.String r15 = r15.getName()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            if (r14 != 0) goto L_0x01d3
            java.lang.String r13 = r13.getName()
            java.lang.String r14 = "tmp"
            boolean r13 = kotlin.text.StringsKt.endsWith$default(r13, r14, r5, r4, r3)
            if (r13 == 0) goto L_0x01a8
            goto L_0x01d3
        L_0x01d2:
            r12 = r3
        L_0x01d3:
            com.blueair.api.model.SensorData r12 = (com.blueair.api.model.SensorData) r12
            if (r12 == 0) goto L_0x01dc
            java.lang.Object r11 = r12.getValue()
            goto L_0x01dd
        L_0x01dc:
            r11 = r3
        L_0x01dd:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.Double r11 = kotlin.text.StringsKt.toDoubleOrNull(r11)
            java.util.Iterator r12 = r0.iterator()
        L_0x01e9:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0216
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.api.model.SensorData r14 = (com.blueair.api.model.SensorData) r14
            java.lang.String r15 = r14.getName()
            com.blueair.api.utils.BlueCloudSensor$Humidity r16 = com.blueair.api.utils.BlueCloudSensor.Humidity.INSTANCE
            java.lang.String r3 = r16.getName()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x0217
            java.lang.String r3 = r14.getName()
            java.lang.String r14 = "hum"
            r15 = 0
            boolean r3 = kotlin.text.StringsKt.endsWith$default(r3, r14, r5, r4, r15)
            if (r3 == 0) goto L_0x0214
            goto L_0x0217
        L_0x0214:
            r3 = 0
            goto L_0x01e9
        L_0x0216:
            r13 = 0
        L_0x0217:
            com.blueair.api.model.SensorData r13 = (com.blueair.api.model.SensorData) r13
            if (r13 == 0) goto L_0x0220
            java.lang.Object r3 = r13.getValue()
            goto L_0x0221
        L_0x0220:
            r3 = 0
        L_0x0221:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Double r3 = kotlin.text.StringsKt.toDoubleOrNull(r3)
            java.util.Iterator r12 = r0.iterator()
        L_0x022d:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0261
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.blueair.api.model.SensorData r14 = (com.blueair.api.model.SensorData) r14
            java.lang.String r15 = r14.getName()
            com.blueair.api.utils.BlueCloudSensor$Fan r16 = com.blueair.api.utils.BlueCloudSensor.Fan.INSTANCE
            r17 = r0
            java.lang.String r0 = r16.getName()
            r16 = r1
            r1 = 0
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r15, r0, r5, r4, r1)
            if (r0 != 0) goto L_0x0266
            java.lang.String r0 = r14.getName()
            java.lang.String r14 = "fan"
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r0, r14, r5, r4, r1)
            if (r0 == 0) goto L_0x025c
            goto L_0x0266
        L_0x025c:
            r1 = r16
            r0 = r17
            goto L_0x022d
        L_0x0261:
            r17 = r0
            r16 = r1
            r13 = 0
        L_0x0266:
            com.blueair.api.model.SensorData r13 = (com.blueair.api.model.SensorData) r13
            if (r13 == 0) goto L_0x026f
            java.lang.Object r0 = r13.getValue()
            goto L_0x0270
        L_0x026f:
            r0 = 0
        L_0x0270:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Double r0 = kotlin.text.StringsKt.toDoubleOrNull(r0)
            java.util.Iterator r1 = r17.iterator()
        L_0x027c:
            boolean r12 = r1.hasNext()
            if (r12 == 0) goto L_0x0297
            java.lang.Object r12 = r1.next()
            r13 = r12
            com.blueair.api.model.SensorData r13 = (com.blueair.api.model.SensorData) r13
            java.lang.String r13 = r13.getName()
            java.lang.String r14 = "disinftime"
            r15 = 0
            boolean r13 = kotlin.text.StringsKt.endsWith$default(r13, r14, r5, r4, r15)
            if (r13 == 0) goto L_0x027c
            goto L_0x0298
        L_0x0297:
            r12 = 0
        L_0x0298:
            com.blueair.api.model.SensorData r12 = (com.blueair.api.model.SensorData) r12
            if (r12 == 0) goto L_0x02a1
            java.lang.Object r1 = r12.getValue()
            goto L_0x02a2
        L_0x02a1:
            r1 = 0
        L_0x02a2:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Double r1 = kotlin.text.StringsKt.toDoubleOrNull(r1)
            java.util.Iterator r12 = r17.iterator()
        L_0x02ae:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x02d2
            java.lang.Object r15 = r12.next()
            r13 = r15
            com.blueair.api.model.SensorData r13 = (com.blueair.api.model.SensorData) r13
            java.lang.String r13 = r13.getName()
            com.blueair.api.utils.BlueCloudSensor$Weight r14 = com.blueair.api.utils.BlueCloudSensor.Weight.INSTANCE
            java.lang.String r14 = r14.getName()
            r17 = r0
            r0 = 0
            boolean r13 = kotlin.text.StringsKt.endsWith$default(r13, r14, r5, r4, r0)
            if (r13 == 0) goto L_0x02cf
            goto L_0x02d5
        L_0x02cf:
            r0 = r17
            goto L_0x02ae
        L_0x02d2:
            r17 = r0
            r15 = 0
        L_0x02d5:
            com.blueair.api.model.SensorData r15 = (com.blueair.api.model.SensorData) r15
            if (r15 == 0) goto L_0x02de
            java.lang.Object r15 = r15.getValue()
            goto L_0x02df
        L_0x02de:
            r15 = 0
        L_0x02df:
            java.lang.String r0 = java.lang.String.valueOf(r15)
            java.lang.Double r0 = kotlin.text.StringsKt.toDoubleOrNull(r0)
            r4 = r6
            com.blueair.core.model.IndoorDatapoint r6 = new com.blueair.core.model.IndoorDatapoint
            if (r16 == 0) goto L_0x02f6
            double r12 = r16.doubleValue()
            float r5 = (float) r12
            java.lang.Float r15 = java.lang.Float.valueOf(r5)
            goto L_0x02f7
        L_0x02f6:
            r15 = 0
        L_0x02f7:
            if (r2 == 0) goto L_0x0308
            double r12 = r2.doubleValue()
            float r2 = (float) r12
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r18 = r10
            r10 = r2
            r2 = r18
            goto L_0x030a
        L_0x0308:
            r2 = r10
            r10 = 0
        L_0x030a:
            if (r4 == 0) goto L_0x031b
            double r4 = r4.doubleValue()
            float r4 = (float) r4
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r18 = r11
            r11 = r4
            r4 = r18
            goto L_0x031d
        L_0x031b:
            r4 = r11
            r11 = 0
        L_0x031d:
            if (r9 == 0) goto L_0x032a
            double r12 = r9.doubleValue()
            float r5 = (float) r12
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r12 = r5
            goto L_0x032b
        L_0x032a:
            r12 = 0
        L_0x032b:
            if (r2 == 0) goto L_0x0338
            double r13 = r2.doubleValue()
            float r2 = (float) r13
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r13 = r2
            goto L_0x0339
        L_0x0338:
            r13 = 0
        L_0x0339:
            if (r4 == 0) goto L_0x0346
            double r4 = r4.doubleValue()
            float r2 = (float) r4
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r14 = r2
            goto L_0x0347
        L_0x0346:
            r14 = 0
        L_0x0347:
            if (r3 == 0) goto L_0x0355
            double r2 = r3.doubleValue()
            float r2 = (float) r2
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r9 = r15
            r15 = r2
            goto L_0x0357
        L_0x0355:
            r9 = r15
            r15 = 0
        L_0x0357:
            if (r17 == 0) goto L_0x0365
            double r2 = r17.doubleValue()
            float r2 = (float) r2
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r16 = r2
            goto L_0x0367
        L_0x0365:
            r16 = 0
        L_0x0367:
            if (r0 == 0) goto L_0x0375
            double r2 = r0.doubleValue()
            float r0 = (float) r2
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r17 = r0
            goto L_0x0377
        L_0x0375:
            r17 = 0
        L_0x0377:
            r6.<init>(r7, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            if (r1 == 0) goto L_0x0386
            double r0 = r1.doubleValue()
            int r0 = (int) r0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r0)
            goto L_0x0387
        L_0x0386:
            r15 = 0
        L_0x0387:
            r6.setDisinftime(r15)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0392
            r15 = 0
            return r15
        L_0x0392:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.model.SensorDataKt.toIndoorDatapoint(java.util.List):com.blueair.core.model.IndoorDatapoint");
    }
}
