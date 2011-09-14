$(function() {
    LightenJQ.lightenElement('menu_wrapper');
});

var LightenJQ = {
    lightenElement: function (id) {
        var $e = $('#' + id);
        var oc = $e.css('background-color');
        $e.hover(
            function () {
            $e.css('background-color', $.xcolor.lighten(oc));
            },
            function() {
            $e.css('background-color', oc); 
            }
        );
}};