// hadoop-common-project/hadoop-common/src/main/java/org/apache/hadoop/security/token/delegation/web/DelegationTokenAuthenticationFilter.java
  @Override
  protected Properties getConfiguration(String configPrefix,
      FilterConfig filterConfig) throws ServletException {
    Properties props = super.getConfiguration(configPrefix, filterConfig);
    String authType = props.getProperty(AUTH_TYPE);
    if (authType.equals(PseudoAuthenticationHandler.TYPE)) {
      props.setProperty(AUTH_TYPE,
          PseudoDelegationTokenAuthenticationHandler.class.getName());
    } else if (authType.equals(KerberosAuthenticationHandler.TYPE)) {
      props.setProperty(AUTH_TYPE,
          KerberosDelegationTokenAuthenticationHandler.class.getName());
    }
    return props;
  }

------------------------------------------------------------------------
/** An ExtractMethod refactoring */
  /**
   * The code fragment for setting AUTH_TYPE property is extracted as method 
   * setAuthHandlerClass(). Also add some codes for checking if authType is null. 
   */
  @Override
  protected Properties getConfiguration(String configPrefix,
      FilterConfig filterConfig) throws ServletException {
    Properties props = super.getConfiguration(configPrefix, filterConfig);
    setAuthHandlerClass(props);
    return props;
  }

  protected void setAuthHandlerClass(Properties props)
      throws ServletException {
    String authType = props.getProperty(AUTH_TYPE);
    if (authType == null) {
      throw new ServletException("Config property "
          + AUTH_TYPE + " doesn't exist");
    }
    if (authType.equals(PseudoAuthenticationHandler.TYPE)) {
      props.setProperty(AUTH_TYPE,
          PseudoDelegationTokenAuthenticationHandler.class.getName());
    } else if (authType.equals(KerberosAuthenticationHandler.TYPE)) {
      props.setProperty(AUTH_TYPE,
          KerberosDelegationTokenAuthenticationHandler.class.getName());
    }
  }