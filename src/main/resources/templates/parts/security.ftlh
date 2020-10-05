<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isAdmin = user.isAdmin()
        isUser = user.isUser()
        isGuest = false
    >
    <#else >
        <#assign
        name = "guest"
        isAdmin = false
        isUser = false
        isGuest = true
        >
</#if>