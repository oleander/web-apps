$(function() {
    DarkenJQ.darkenElement('content_wrapper');
});

var DarkenJQ = {
    darkenElement: function (id) {
        var $e = $('#' + id);
        // Fetch the original colour
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