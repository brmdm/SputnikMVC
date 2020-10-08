<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<#import "/spring.ftl" as spring>
<@c.page>
    <@spring.message "ticket.title"/> ${event.get().getFilm().getTitle()}
    <table class="table">
        <thead>
        <tr>
            <th scope="col"><@spring.message "ticket.information"/></th>
            <th scope="col"><@spring.message "ticket.value"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row"><@spring.message "main.user"/></th>
            <td>${user.getUsername()}</td>
        </tr>
        <tr>
            <th scope="row"><@spring.message "ticket.film"/></th>
            <td>${event.get().getFilm().getTitle()}</td>
        </tr>
        <tr>
            <th scope="row"><@spring.message "ticket.date"/></th>
            <td>${event.get().getDate()}</td>
        </tr>
        <tr>
            <th scope="row"><@spring.message "ticket.time"/></th>
            <td>${event.get().getTime()}</td>
        </tr>
        <tr>
            <th scope="row"><@spring.message "ticket.price"/></th>
            <td>${event.get().getPrice()}</td>
        </tr>
        </tbody>
    </table>


    <form action="/ticket" method="post">
        <input type="text" name="seat" class="form-control" placeholder="<@spring.message "ticket.addseat"/>"/>
        <input type="hidden" value="${event.get().id}" name="eventId">
        <input type="hidden" value="${user.getUsername()}" name="userName">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary"><@spring.message "ticket.buy"/></button>
    </form>


</@c.page>