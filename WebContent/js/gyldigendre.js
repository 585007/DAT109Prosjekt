"use strict";

let validBru;
let validPass;
let validNpass;
let validBpass;


const rootElm = document.getElementById('root');
const formElm = rootElm.querySelector('form[name="skjema"]');
const bruElm = rootElm.querySelector('input[name="bruker"]');
const passElm = rootElm.querySelector('input[name="passord"]');
const npassElm = rootElm.querySelector('input[name="nyttPassord"]');
const bpassElm = rootElm.querySelector('input[name="bekreftPassord"]');
const buttElm = rootElm.querySelector('button[id="submit"]');

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
bruElm.addEventListener('input', bruCheck);

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
passElm.addEventListener('input', passCheck);

function npassCheck() {
	if (npassElm.value.length >= 2) {
		npassElm.style.borderColor = "green";
		validNpass = true;
	} else {
		npassElm.style.borderColor = "red";
		validNpass = false;
	}
}
npassElm.addEventListener('mouseout', npassCheck);
npassElm.addEventListener('input', npassCheck);

function bpassCheck() {
	if (bpassElm.value == npassElm.value) {
		bpassElm.style.borderColor = "green";
		validBpass = true;
	} else {
		bpassElm.style.borderColor = "red";
		validBpass = false;
	}
}
bpassElm.addEventListener('mouseout', bpassCheck);
bpassElm.addEventListener('input', bpassCheck);

function isValidFormData() {
	return validPass && validBpass && validBru && validNpass;
}

buttElm.addEventListener('mouseover', function(event) {
	bruCheck();
	passCheck();
	npassCheck();
	bpassCheck();
})

formElm.addEventListener('submit', function(event) {
	if (!isValidFormData()) {
		console.log('invalid data')
		event.preventDefault()
	}
})
