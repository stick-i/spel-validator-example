package cn.sticki.validator.spel.example.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/3/22 14:37
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resp<T> implements java.io.Serializable {

	/**
	 * 返回码，200表示成功，其他表示异常
	 */
	private int code = 200;

	/**
	 * 返回消息
	 */
	private String msg = "success";

	/**
	 * 返回数据
	 */
	private T data = null;

	public Resp(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static <T> Resp<T> ok() {
        return new Resp<>();
	}

	public static <T> Resp<T> ok(T data) {
		Resp<T> resp = new Resp<>();
		resp.data = data;
		return resp;
	}

}
