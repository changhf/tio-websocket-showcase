package org.tio.showcase;

import org.tio.showcase.http.init.HttpServerInit;
import org.tio.showcase.websocket.server.DeliWebsocketStarter;
import org.tio.utils.jfinal.P;

/**
 * @author chang_hfeng
 */
public class Starter {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//加载属性文件
		P.use("app.properties");

		//启动http server，这个步骤不是必须的，但是为了用页面演示websocket，所以先启动http
		if (P.getInt("start.http", 1) == 1) {
			HttpServerInit.init();
		}

		//启动websocket服务器
		DeliWebsocketStarter.start();
	}
}
