<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<#include "parts/security.ftlh">
<@c.page>
<h5><@spring.message "main.yourticket"/>: </h5>
<div class="card-columns">
    <#list tickets  as ticket>
        <div class="card my-3" style="width: 18rem;">
            <b>    ${ticket.getEvent().getFilm().getTitle()} </b>
            <div class="m-2">
                <b><@spring.message "main.date"/>: ${ticket.getEvent().getDate()}.    </b>
                <b><@spring.message "main.time"/>: ${ticket.getEvent().getTime()}.
                </b>
                <span><@spring.message "main.seat"/>: ${ticket.getSeat()}</span>
            </div>
            <div class="card-footer text-muted">
                <b><@spring.message "main.price"/> = ${ticket.getEvent().getPrice()}. <@spring.message "event.money"/></b>
                <b><@spring.message "main.user"/>: ${ticket.getUser().getUsername()}.    </b>
            </div>
        </div>
    <#else>
        <@spring.message "main.noticket"/> - <a href="/"><@spring.message "main.schedule"/></a>
    </#list>
</div>
</@c.page>
