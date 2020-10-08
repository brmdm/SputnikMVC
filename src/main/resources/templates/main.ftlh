<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
<h5>YOUR TICKETS: </h5>
<div class="card-columns">
    <#list tickets  as ticket>
        <div class="card my-3" style="width: 18rem;">
            <b>    ${ticket.getEvent().getFilm().getTitle()} </b>
            <div class="m-2">
                <b>Date: ${ticket.getEvent().getDate()}.    </b>
                <b>Time: ${ticket.getEvent().getTime()}.
                </b>
                <span>Seat: ${ticket.getSeat()}</span>
            </div>
            <div class="card-footer text-muted">
                <b>PRICE = ${ticket.getEvent().getPrice()}. UAH</b>
                <b>USER: ${ticket.getUser().getUsername()}.    </b>
            </div>
        </div>
    <#else>
        You are don't have any ticket's. For get some - <a href="/">Click schedule</a>
    </#list>
</div>
</@c.page>

<#--<div class="form-row">-->
<#--    <div class="form-group col-md-6">-->
<#--        <form method="get" action="/main" class="form-inline">-->
<#--            <input type="text" name="filter" class="form-control" value="${filter?ifExists}"-->
<#--                   placeholder="Search by tag">-->
<#--            <button type="submit" class="btn btn-primary ml-2">Search</button>-->
<#--        </form>-->
<#--    </div>-->
<#--</div>-->
