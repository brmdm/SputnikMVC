<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
<h5>Welcome, ${name}</h5>

    <div class="card-columns">
    <#list events  as event>
        <div class="card my-3" style="width: 18rem;">
            <h5 class="card-title">  ${event.getFilm().getTitle()}.</h5>
            <b>Date: ${event.date}.    </b>
            <b>Time: ${event.time}. </b>
            <div class="m-2">
                <i>FREE SEATS : </i>
            </div>
            <div class="card-footer text-muted">
                PRICE = ${event.price} UAH. <a href="/ticket/${event.id}">Buy ticket</a>
            </div>

        </div>
    </#list>
</@c.page>