$(function(){
    $.getJSON("http://localhost:8084/getCatalog2",function (data) {
        var ctgall=data;
        $(".header_main_left_a").each(function(){
            var ctgnums= $(this).attr("ctg-data");
            if(ctgnums){
                var panel=$("<div class='header_main_left_main'></div>");
                var panelol=$("<ol class='header_ol'></ol>");
                 $.each(ctgall,function (i,ctg1) {
                     if (ctgnums == ctg1["id"]){
                         var cata2link=$("<a href='#' style= 'color: #111;' class='aaa'> ></a>");
                         var ctg2list= ctg1["pmsBaseCatalog2s"];
                         var li=$("<li></li>");
                         var len=0;
                         $.each(ctg2list,function (i,ctg2) {
                             var cata2link = $("<a href=\"http://localhost:8084/list.html?catalog2Id="+ctg2.id+"\" style=\"color: #999;\">" + ctg2.name + "</a>");
                             li.append(cata2link);
                             len=len+1+ctg2.name.length;
                         });
                         if(len>=46&&len<92){
                             li.attr("style","height: 60px;");
                         }else if(len>=92){
                             li.attr("style","height: 90px;");
                         }
                         panelol.append(cata2link).append(li);
                     }
                });
                panel.append(panelol);
                $(this).after(panel);
                $(this).parent().addClass("header_li2");
                // console.log($(".header_main_left").html());
            }
        });
    });
});