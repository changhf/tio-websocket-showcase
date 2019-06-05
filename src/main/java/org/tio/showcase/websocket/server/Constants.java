/**
 * 
 */
package org.tio.showcase.websocket.server;

import org.tio.utils.time.Time;

/**
 * @author chang_hfeng
 *
 */
public class Constants {
	/**
	 * 用于群聊的group id
	 */
	public static final String GROUP_ID = "showcase-websocket";

	public static final Long DURATION_1 = Time.MINUTE_1 * 5;
	public static final Long[] IPSTAT_DURATIONS = new Long[]{DURATION_1};
}
