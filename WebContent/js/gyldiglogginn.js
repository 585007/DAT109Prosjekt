"use strict";
console.log("script på");

let validBru;
let validPass;

const rootElm = document.getElementById('root');

const formElm = rootElm.querySelector('form[name="skjema"]');
const bruElm = rootElm.querySelector('input[name="bruker"]');
const passElm = rootElm.querySelector('input[name="passord"]');

function bruCheck() {
	if (bruElm.value.length >= 2) {
		bruElm.style.borderColor = "green";
		validBru = true;
	} else {
		bruElm.style.borderColor = "red";
		validBru = false;
	}
}
bruElm.addEventListener('mouseout', bruCheck);

function passCheck() {
	if (passElm.value.length >= 2) {
		passElm.style.borderColor = "green";
		validPass = true;
	} else {
		passElm.style.borderColor = "red";
		validPass = false;
	}
}
passElm.addEventListener('mouseout', passCheck);

buttElm.addEventListener('mouseover', function(event) {
	bruCheck();
	passCheck();
})

function isValidFormData() {
	return validPass && validBru;
}

formElm.addEventListener('submit', function(event) {
	if (!isValidFormData()) {
		console.log('invalid data')
		event.preventDefault()
	}
})
