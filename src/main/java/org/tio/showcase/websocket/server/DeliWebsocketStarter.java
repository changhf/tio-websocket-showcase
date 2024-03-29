package org.tio.showcase.websocket.server;

import java.io.IOException;

import org.tio.server.ServerGroupContext;
import org.tio.showcase.http.init.HttpServerInit;
import org.tio.utils.jfinal.P;
import org.tio.websocket.server.WsServerStarter;

/**
 * @author chang_hfeng
 */
public class DeliWebsocketStarter {

	private WsServerStarter wsServerStarter;
	private ServerGroupContext serverGroupContext;

	/**
	 *
	 * @author chang_hfeng
	 */
	public DeliWebsocketStarter(int port, DeliWsMsgHandler wsMsgHandler) throws Exception {
		wsServerStarter = new WsServerStarter(port, wsMsgHandler);

		serverGroupContext = wsServerStarter.getServerGroupContext();
		serverGroupContext.setName(DeliServerConfig.PROTOCOL_NAME);
		serverGroupContext.setServerAioListener(DeliServerAioListener.me);

		//设置ip监控
		serverGroupContext.setIpStatListener(DeliIpStatListener.me);
		//设置ip统计时间段
		serverGroupContext.ipStats.addDurations(Constants.IPSTAT_DURATIONS);
		
		//设置心跳超时时间
		serverGroupContext.setHeartbeatTimeout(DeliServerConfig.HEARTBEAT_TIMEOUT);
		
		if (P.getInt("ws.use.ssl", 1) == 1) {
			//如果你希望通过wss来访问，就加上下面的代码吧，不过首先你得有SSL证书（证书必须和域名相匹配，否则可能访问不了ssl）
//			String keyStoreFile = "classpath:config/ssl/keystore.jks";
//			String trustStoreFile = "classpath:config/ssl/keystore.jks";
//			String keyStorePwd = "214323428310224";
			
			
			String keyStoreFile = P.get("ssl.keystore", null);
			String trustStoreFile = P.get("ssl.truststore", null);
			String keyStorePwd = P.get("ssl.pwd", null);
			serverGroupContext.useSsl(keyStoreFile, trustStoreFile, keyStorePwd);
		}
	}

	/**
	 * @param
	 * @author chang_hfeng
	 * @throws IOException
	 */
	public static void start() throws Exception {
		DeliWebsocketStarter appStarter = new DeliWebsocketStarter(DeliServerConfig.SERVER_PORT, DeliWsMsgHandler.me);
		appStarter.wsServerStarter.start();
	}

	/**
	 * @return the serverGroupContext
	 */
	public ServerGroupContext getServerGroupContext() {
		return serverGroupContext;
	}

	public WsServerStarter getWsServerStarter() {
		return wsServerStarter;
	}
	
	public static void main(String[] args) throws Exception {
		//启动http server，这个步骤不是必须的，但是为了用页面演示websocket，所以先启动http
		P.use("app.properties");
		
		
		if (P.getInt("start.http", 1) == 1) {
			HttpServerInit.init();
		}
		
		//启动websocket server
		start();
	}

}
