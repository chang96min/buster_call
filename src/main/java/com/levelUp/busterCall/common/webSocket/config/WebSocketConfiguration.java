package com.levelUp.busterCall.common.webSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");  //해당 주소로 메세지 전달
        registry.setApplicationDestinationPrefixes("/app");     //해당 주소를 구독하고 있는 client에게 전송
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")     //sockJs 연결 주소
                .setAllowedOrigins("*")        //CORS 전체 허용(임시)          
                .withSockJS();                 //sockJS 사용
    }
}
