package com.example.ppt.tempsingleec.generators;

import com.example.ppt.temp_annotations.PayEntryGenerator;
import com.example.ppt.temp_coer.wechat.templete.WPayXEntryTmplete;

@PayEntryGenerator(packageName = "com.example.ppt.tempsingleec", payEntryTemplete = WPayXEntryTmplete.class)
public interface WechatPayEntry {
}
