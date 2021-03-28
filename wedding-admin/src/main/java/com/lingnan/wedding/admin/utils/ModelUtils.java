package com.lingnan.wedding.admin.utils;

import com.lingnan.wedding.core.entity.SystemUser;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class ModelUtils {
    public static ModelAndView createModel(HttpServletRequest request, String view) {
        ModelAndView result = new ModelAndView();
        result.setViewName(view);
        if (ShiroUtil.getSubject() != null) {
            SystemUser systemUser = (SystemUser) ShiroUtil.getSubject().getPrincipal();
            result.addObject("systemUser", systemUser);
        }
        return result;
    }
}
