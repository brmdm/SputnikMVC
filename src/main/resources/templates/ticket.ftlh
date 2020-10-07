<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    Ordering ticket to ${event.getFilm().getTitle()}
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Information</th>
            <th scope="col">Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">User</th>
            <td>${user.getUsername()}</td>
        </tr>
        <tr>
            <th scope="row">Film</th>
            <td>${event.getFilm().getTitle()}</td>
        </tr>
        <tr>
            <th scope="row">Date</th>
            <td>${event.getDate()}</td>
        </tr>
        <tr>
            <th scope="row">Time</th>
            <td>${event.getTime()}</td>
        </tr>
        <tr>
            <th scope="row">Price</th>
            <td>${event.getPrice()}</td>
        </tr>
        </tbody>
    </table>


    <form action="/ticket" method="post">
        <input type="text" name="seat" class="form-control" placeholder="Add FREE seat"/>
        <input type="hidden" value="${event.id}" name="eventId">
        <input type="hidden" value="${user.getUsername()}" name="userName">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary">Buy</button>
    </form>


<#--    <form action="/ticket" method="post">-->
<#--        <b>Event: ${event.getFilm().getTitle()} </b>-->
<#--        <input type="text" name="username" value="${user.username}">-->
<#--        <#list roles as role>-->
<#--            <div>-->
<#--                <label><input type="checkbox"-->
<#--                              name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}-->
<#--                </label>-->
<#--            </div>-->
<#--        </#list>-->

<#--        <input type="hidden" value="${user.id}" name="userId">-->
<#--        <input type="hidden" value="${_csrf.token}" name="_csrf">-->
<#--        <button type="submit">Save</button>-->
<#--    </form>-->
</@c.page>

<#--<#import "parts/common.ftlh" as c>-->

<#--<@c.page>-->
<#--    User editor-->

<#--    <form action="/user" method="post">-->
<#--&lt;#&ndash;        <input type="text" name="username" value="${usr.username}">&ndash;&gt;-->
<#--        <#list roles as role>-->
<#--            <div>-->
<#--                <label><input type="checkbox" name="${role}"-->
<#--&lt;#&ndash;                            ${usr.roles?seq_contains(role)?string("checked", "")}&ndash;&gt;-->
<#--                    >${role}</label>-->
<#--            </div>-->
<#--        </#list>-->
<#--&lt;#&ndash;        <input type="hidden" value="${usr.id}" name="userId">&ndash;&gt;-->
<#--        <input type="hidden" value="${_csrf.token}" name="_csrf">-->
<#--        <button type="submit">Save</button>-->
<#--    </form>-->
<#--</@c.page>-->