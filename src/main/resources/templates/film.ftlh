<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>
<@c.page>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        <@spring.message "film.addnewfilm"/>
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" name="title" class="form-control" placeholder="<@spring.message "film.entertitle"/>"/>
                </div>
                <div class="form-group">
                    <input type="text" name="description" class="form-control" placeholder="<@spring.message "film.enterdescription"/>">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary"><@spring.message "film.addfilm"/></button>
                </div>
            </form>
        </div>
    </div>
    <div class="card-columns">
    <#list films  as film>
        <div class="card my-3" style="width: 18rem;">
            <b>${film.title}. </b>
            <div class="m-2">
                <i>${film.description}</i>
            </div>
            <div class="card-footer text-muted">
                ${film.id}
            </div>
        </div>
    <#else>
        <@spring.message "film.nofilm"/>
    </#list>
    </div>
</@c.page>