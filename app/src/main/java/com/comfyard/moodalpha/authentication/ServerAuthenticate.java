package com.comfyard.moodalpha.authentication;

/**
 * Created by moredream on 11/13/14.
 */
public interface ServerAuthenticate {
    public String userSignUp(final String name, final String email, final String pass, String authType) throws Exception;
    public String userSignIn(final String user, final String pass, String authType) throws Exception;
}
