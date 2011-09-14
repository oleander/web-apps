$(function() {
    DarkenJQ.darkenElement('content_wrapper');
});

var DarkenJQ = {
    darkenElement: function (id) {
        var $e = $('#' + id);
        var oc = $e.css('background-color');
        $e.hover(
            function () {
                $e.css('background-color', $.xcolor.darken(oc));
            },
            function() {
               $e.css('background-color', oc); 
            }
        );
}};