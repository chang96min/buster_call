package com.levelUp.busterCall.common.webSocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketHandler extends TextWebSocketHandler {
    private final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    //websocket handshake가 완료되어 연결이 수립될 때 호출
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.putIfAbsent(session.getId(), session);
    }

    //websocket 오류가 발생했을 때 호출
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        sessionMap.remove(session.getId());
    }

    //websocket 세션 연결이 종료되었을 때 호출
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
    }

    //websocket sessoin 으로 메시지가 수신되었을 때 호출
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //getPayload를 통해 websocket 메시지 payload를 가져온다.
        String payload = message.getPayload();
        //broadcasting message to all session
        sessionMap.forEach((sessionId, connectSession) -> {
            try {
                connectSession.sendMessage(message);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
