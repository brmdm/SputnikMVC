<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
<h5>Welcome, ${name}</h5>
    <div>LogIn for order tickets</div>

    <div class="card-columns">
    <#list events  as event>
        <div class="card my-3" style="width: 18rem;">
            <b>${event.date}. </b>
            <b>${event.time}. </b>
            <div class="m-2">
                <i>${event.getFilm().getTitle()}</i>
            </div>
            <div class="card-footer text-muted">
                PRICE = ${event.price} UAH
            </div>
        </div>
    </#list>
</@c.page>