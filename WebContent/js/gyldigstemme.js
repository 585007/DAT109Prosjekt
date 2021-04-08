"use strict";
console.log("script på");
let validMob;

const rootElm = document.getElementById('root');
const mobElm = rootElm.querySelector('input[name="tlf"]');

function mobCheck() {
	if (mobElm.value.length == 8) {
		mobElm.style.borderColor = "green";
		validMob = true;
	} else {
		mobElm.style.borderColor = "red";
		validMob = false;
	}
}
mobElm.addEventListener('input', mobCheck);


