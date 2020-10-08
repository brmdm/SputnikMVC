<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<@c.page>
    <@spring.message "user.list"/>
    <table>
        <thead>
        <tr>
            <th><@spring.message "user.name"/></th>
            <th><@spring.message "user.role"/></th>

        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
            </tr>

        </#list>
        </tbody>
    </table>
</@c.page>