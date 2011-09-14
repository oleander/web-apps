/* Here, you should not change anything else than the argument in the call below */
var Lighten = {
	/*
	 * Takes an id to an element and brightens its colour a notch...
	 * You should implement the lightenElement(id) function.
	 */
	lightenElement: function(id) {
            var el = document.getElementById(id);
            var l_original_colour = RGB(Lighten.getStyle(el, "background-color")).getHex();
            
            el.onmouseover = function () {
              var color = RGB(Lighten.getStyle(el, "background-color"));
              color.addRGB(30, 30, 30);
              el.style.backgroundColor = color.getHex();
            };
            
            el.onmouseout = function () {
                el.style.backgroundColor = l_original_colour;
            }
	},
        getStyle: function(oElm, strCssRule){
            var strValue = "";
            if(document.defaultView && document.defaultView.getComputedStyle){
                    strValue = document.defaultView.getComputedStyle(oElm, "").getPropertyValue(strCssRule);
            }
            else if(oElm.currentStyle){
                    strCssRule = strCssRule.replace(/\-(\w)/g, function (strMatch, p1){
                            return p1.toUpperCase();
                    });
                    strValue = oElm.currentStyle[strCssRule];
            }
            return strValue;
        }
}
