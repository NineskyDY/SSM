package o2o.service;

import o2o.dto.WechatAuthExecution;
import o2o.entity.WechatAuth;
import o2o.exceptions.WechatAuthOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface WechatAuthService {

	/**
	 * 
	 * @param openId
	 * @return
	 */
	WechatAuth getWechatAuthByOpenId(String openId);

	/**
	 * 
	 * @param wechatAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	WechatAuthExecution register(WechatAuth wechatAuth,
                                 CommonsMultipartFile profileImg) throws WechatAuthOperationException;

}
