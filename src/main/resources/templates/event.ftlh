<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<@c.page>
    ${message?ifExists}
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        <@spring.message "event.addnewevent"/>
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" name="date" class="form-control" placeholder="<@spring.message "event.enterdate"/>"/>
                </div>
                <div class="form-group">
                    <input type="text" name="time" class="form-control" placeholder="<@spring.message "event.entertime"/>:
                    9:00 | 11:00 | 13:00 | 16:00 | 19:00 | 22:00"/>
                </div>
                <div class="form-group">
                    <input type="text" name="film" class="form-control" placeholder="<@spring.message "event.entertitle"/>">
                </div>
                <div class="form-group">
                    <input type="text" name="price" class="form-control" placeholder="<@spring.message "event.enterprice"/>">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary"><@spring.message "event.addevent"/></button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
    <#list events  as event>
        <div class="card my-3" style="width: 18rem;">
            <b>${event.date}. </b>
            <b>${event.time}. </b>
            <div class="m-2">
                <i>${event.getFilm().getTitle()}</i>
            </div>
            <div class="card-footer text-muted">
                ID = ${event.id}, PRICE = ${event.price} <@spring.message "event.money"/>
                <form action="/event/delete" method="post">
                    <input type="hidden" name="eventId" value="${event.id}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary"><@spring.message "event.deleteevent"/></button>
                    </div>
                </form>
            </div>
        </div>
    <#else>
        <@spring.message "event.noevent"/>
    </#list>
    </div>
</@c.page>