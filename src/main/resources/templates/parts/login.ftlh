<#import "/spring.ftl" as spring>
<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"><@spring.message "login.user"/> :</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="<@spring.message "login.user"/>" />
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"><@spring.message "login.password"/> :</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="<@spring.message "login.password"/>" />
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <#if !isRegisterForm><a href="/registration"><@spring.message "login.addnewuser"/></a></#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm><@spring.message "login.create"/><#else><@spring.message "navbar.signin"/></#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><@spring.message "login.signout"/></button>
    </form>
</#macro>