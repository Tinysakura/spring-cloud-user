package com.cfh.practice.user.utils;

import com.cfh.practice.user.VO.ResultVO;
import com.cfh.practice.user.enums.ResultEnum;

/**
 * Created by 廖师兄
 * 2017-12-10 18:03
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.LOGIN_SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.LOGIN_SUCCESS.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO repeateLogin(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.REPEAT_LOGIN.getCode());
        resultVO.setMsg(ResultEnum.REPEAT_LOGIN.getMessage());
        resultVO.setData(object);
        return resultVO;
    }
}
