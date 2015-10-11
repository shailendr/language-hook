package com.hook.login;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;


public class StrutsLoginAction extends BaseStrutsPortletAction{
	

    public void processAction(StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
    	
        ThemeDisplay themeDisplay =  (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	
    	User user = null;
    	
    	String flagStr = ParamUtil.getString(actionRequest, "loginHDN");
    	
    	if(flagStr.equalsIgnoreCase("email-address"))
    		user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), 
    			ParamUtil.getString(actionRequest, "login"));
    	else if(flagStr.equalsIgnoreCase("screen-name"))
    		user = UserLocalServiceUtil.getUserByScreenName(themeDisplay.getCompanyId(),
    				ParamUtil.getString(actionRequest, "login"));
    	
    	if(Validator.isNotNull(user)){
        	user.setLanguageId(ParamUtil.getString(actionRequest, "languageId"));
    		UserLocalServiceUtil.updateUser(user);
    	}
		originalStrutsPortletAction.processAction(
            originalStrutsPortletAction, portletConfig, actionRequest,
            actionResponse);
    }

    public String render(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws Exception {

        return originalStrutsPortletAction.render(
            null, portletConfig, renderRequest, renderResponse);

    }

    public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {

        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }

}
