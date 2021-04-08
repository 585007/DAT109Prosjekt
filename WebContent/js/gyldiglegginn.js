"use strict";
console.log("script på");

let validFor;

const rootElm = document.getElementById('root');

const proElm = rootElm.querySelector('input[name="navn"]');

function proCheck() {
	if (proElm.value.length >= 2 && proElm.value.length <= 20) {
		proElm.style.borderColor = "green";
		validFor = true;
	} else {
		proElm.style.borderColor = "red";
		validFor = false;
	}
}
proElm.addEventListener('mouseout', proCheck);

