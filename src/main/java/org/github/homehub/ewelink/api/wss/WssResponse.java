package org.github.homehub.ewelink.api.wss;

import org.github.homehub.ewelink.api.wss.wssrsp.WssRspMsg;

public interface WssResponse {

    void onMessage(String s);

    void onMessageParsed(WssRspMsg rsp);

    void onError(String error);
}
