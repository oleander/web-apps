var Flasher = {
	/*
	 * This function takes the id of an element and animates it's background colour from
	 * black to white. Once the color is white, the animation is stopped and the original
	 * colour of the element is restored.
	 *
	 * NOTE: Several things need to be fixed before it works...
	 */
	flash: function(id) {
                var stepsize = 8;
                var e = document.getElementById(id);
                var original_colour = Flasher.getStyle(e, "background-color");
                var colour = 0;
		id = setInterval(function() {
			colour += stepsize;
			e.style.backgroundColor = "#" + colour.toString(16) + colour.toString(16) + colour.toString(16);
			if ((colour % 256) === 0) {
				clearInterval(id);
				e.style.backgroundColor = original_colour;
			}
		}, 5);
                
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