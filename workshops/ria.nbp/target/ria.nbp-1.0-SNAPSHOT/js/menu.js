$(function () {
    
    /*
     *  Hide menu divs
     */
    $(".dropdown_container").css('display', 'none');
    
    /*
     *  Populate hidden menu divs
     */
    var ids = ["fruits", "nuts", "vegetables"];
    var stop = ids.length;
    for (var i = 0;i<stop; i++) {
        var category = ids[i];
        var catid = "dropdown_" + category;
        $.ajax({
            url: "/get",
            data: {what: catid},
            dataType: "text",
            context: $('#' + catid),
            success: function (data) {
                this.html(data);
            }
        }); 
    }
    
    /*
     *  Bind click events to sub-menu items
     */
    $(".dropdown li").live('click', function () {
        $('#content').load("/get", {what: $(this).attr('id')});
    });
    
    /*
     *  Bind mouseout/in events to sub-menu items
     */
    $(".dropdown li").live({
        mouseenter: function () {
           $(this).css({color: "white", cursor: "pointer"}); 
        },
        mouseleave: function(){
            $(this).css({color: "black", cursor: "pointer"});
    }});
    
    /*
     *  Bind hover event to main menu items to show sub menues
     */
    $("#menu_list li").hover(
    function () {
        var cat = "#dropdown_" + $(this).attr('id');
        var height = $(this).height();
        var position = $(this).offset();
        $(this).append($(cat));
        $(cat).css({
            position: "absolute", 
            left: position.left, 
            top: position.top + height + 10,
            display: "inline-block"
        });
    },
    function (){
        var cat = "#dropdown_" + $(this).attr('id');
        $(cat).css("display", "none");
    });
});