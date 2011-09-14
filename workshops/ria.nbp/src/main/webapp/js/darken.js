/* Here, you should not change anything else than the argument in the call below */

var Darken = {
	/*
	 * Takes an id to an element and darkens its colour a notch...
	 * You should implement the darkenElement(id) function.
	 */
	darkenElement: function(id) {
            var e = document.getElementById(id);
            var original_colour = RGB(Darken.getStyle(e, "background-color")).getHex();
            console.log("Original colour, raw: ", original_colour);
            console.log("Original colour: " + original_colour);
            e.onmouseover = function () {
                console.log("mouseover");
                var colour = RGB(Darken.getStyle(e, "background-color"));
                colour.addRGB(-20, -20, -20);
                console.log("setting style: " + colour.getHex());
                e.style.backgroundColor = colour.getHex();
            };
            
            e.onmouseout = function () {
                console.log("mouseout");
                console.log("Original colour: " + original_colour);
                console.log("setting style: " + original_colour);
                e.style.backgroundColor = original_colour;
            };
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
