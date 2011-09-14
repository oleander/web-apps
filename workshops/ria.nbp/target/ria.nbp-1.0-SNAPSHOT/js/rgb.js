/*
 * RGB "class".
 * col = a string representing a colour in the form "rgb(r,g,b)".
 */
var RGB =
        function(col) {
	this.colour = [0, 0, 0];

	/*
	 * Simple snippet of code that parses an incoming rgb(r,g,b)
	 * values an populates colour[].
	 */
	col = col.split(",");
	colour[0] = parseInt(col[0].substring(4));
	colour[1] = parseInt(col[1]);
	colour[2] = parseInt(col[2].substring(0, col[2].length - 1));

	/*
	 * Returns the hex value (#rrggbb) for the current colour.
	 */
	this.getHex = function() {
		return "#" + this.colour[0].toString(16) +
		             this.colour[1].toString(16) +
			     this.colour[2].toString(16);
	}

	/*
	 * Adds the given r, g and b values to the current colour value.
	 */
	this.addRGB = function(r, g, b) {
		r += this.colour[0];
		g += this.colour[1];
		b += this.colour[2];

		this.colour = [r > 255 ? 255 : (r < 0 ? 0 : r),
		               g > 255 ? 255 : (g < 0 ? 0 : g),
			       b > 255 ? 255 : (b < 0 ? 0 : b)];
	}

	/*
	 * Substracts the given r, g and b values from the current colour value.
	 */
	this.subRGB = function(r, g, b) {
		this.addRGB(-r, -g, -b);
	}

	return this;
};


