package com.ibm.moses.common.message;

import com.ibm.moses.config.LocaleMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Moses
 */
@Service
public class LocaleMessageService {
    @Resource
    private LocaleMessage localeMessage;

    public String getMessage(String msgId, Object... params) {
        return localeMessage.getMessage(msgId, params);
    }
}
