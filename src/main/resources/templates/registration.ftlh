<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>
<@c.page>
<div class="mb-1" ><@spring.message "registr.newuser"/></div>

${message?ifExists}
<@l.login "/registration" true/>
</@c.page>