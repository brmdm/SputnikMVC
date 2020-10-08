<#include "security.ftlh">
<#import "/spring.ftl" as spring>
<#import "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><@spring.message "navbar.title"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main"><@spring.message "navbar.main"/></a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user"><@spring.message "navbar.userlist"/></a>
            </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/film"><@spring.message "navbar.filmlist"/></a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/event"><@spring.message "navbar.eventlist"/></a>
                </li>
            </#if>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <@spring.message "navbar.language"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="?lang=uk">UA</a>
                    <a class="dropdown-item" href="?lang=en">ENG</a>
                    <a class="dropdown-item" href="?lang=de">GER</a>
                    <div class="dropdown-divider"></div>
                </div>
            </li>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <#if isAdmin>
        <@l.logout/>
        </#if>
        <#if isUser>
            <@l.logout/>
        </#if>
        <#if isGuest>
            <a href="/login"><@spring.message "navbar.signin"/></a>
        </#if>

    </div>
</nav>